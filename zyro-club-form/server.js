import crypto from "node:crypto";
import path from "node:path";
import { fileURLToPath } from "node:url";
import express from "express";
import { validateRegistration } from "./lib/validation.js";

const __dirname = path.dirname(fileURLToPath(import.meta.url));
const app = express();
const port = Number(process.env.PORT || 3000);
const apiUrl = (process.env.ZYRO_API_URL || "https://grhdawkxnrkgkahegnnd.supabase.co/functions/v1/zyro-api").replace(/\/$/, "");
const mailerWebAppUrl = String(process.env.MAILER_WEB_APP_URL || "").trim();
const mailerSharedSecret = String(process.env.MAILER_SHARED_SECRET || "").trim();

app.disable("x-powered-by");
app.set("trust proxy", 1);
app.use(express.json({ limit: "128kb" }));
app.use((req, res, next) => {
  const incomingId = String(req.get("x-request-id") || "").trim();
  const requestId = /^[A-Za-z0-9._:-]{8,100}$/.test(incomingId) ? incomingId : crypto.randomUUID();
  const cfRay = String(req.get("cf-ray") || req.get("rndr-id") || "").trim() || null;
  req.requestId = requestId;
  req.cfRay = cfRay;
  res.setHeader("X-Request-Id", requestId);
  const startedAt = performance.now();

  // Log at request arrival so a request that hangs is still visible in Render logs.
  console.log(JSON.stringify({
    event: "zyro_http_start",
    requestId,
    cfRay,
    method: req.method,
    path: req.path
  }));

  res.on("finish", () => {
    console.log(JSON.stringify({
      event: "zyro_http_request",
      requestId,
      cfRay,
      method: req.method,
      path: req.path,
      status: res.statusCode,
      durationMs: Math.round(performance.now() - startedAt)
    }));
  });
});
app.use(express.static(path.join(__dirname, "public"), { extensions: ["html"] }));

const rateWindow = new Map();
function submitRateLimit(req, res, next) {
  const now = Date.now();
  const key = req.ip || "unknown";
  const recent = (rateWindow.get(key) || []).filter((time) => now - time < 10 * 60 * 1000);
  if (recent.length >= 8) return res.status(429).json({ message: "Bạn gửi hơi nhanh. Thử lại sau ít phút nhé." });
  recent.push(now);
  rateWindow.set(key, recent);
  next();
}

function requireAdmin(req, res, next) {
  return requireEdgeAdmin(req, res, next);
}

function validEmail(value) {
  return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(String(value || "").trim());
}

async function requireEdgeAdmin(req, res, next) {
  const authorization = req.headers.authorization || "";
  if (!authorization.startsWith("Basic ")) {
    res.set("WWW-Authenticate", 'Basic realm="ZYRO Admin"');
    return res.status(401).json({ message: "Cần đăng nhập quản trị." });
  }
  try {
    await edgeFetch("/email-settings", { headers: { Authorization: authorization }, requestId: req.requestId, timeoutMs: 8000 });
    next();
  } catch (error) {
    if (error.status === 401) res.set("WWW-Authenticate", 'Basic realm="ZYRO Admin"');
    res.status(error.status || 503).json({ message: error.message || "Không xác thực được quyền quản trị." });
  }
}

function mailerConfigurationError() {
  const error = new Error("Chưa cấu hình Google Apps Script Mail Relay. Hãy thiết lập MAILER_WEB_APP_URL và MAILER_SHARED_SECRET trong Render.");
  error.status = 503;
  error.deliveryStatus = "pending";
  return error;
}

async function appsScriptRequest(payload, options = {}) {
  if (!mailerWebAppUrl || !mailerSharedSecret) throw mailerConfigurationError();
  const requestId = options.requestId || crypto.randomUUID();
  const timeoutMs = Number(options.timeoutMs) > 0 ? Number(options.timeoutMs) : 30000;
  const startedAt = performance.now();

  let response;
  try {
    response = await fetch(mailerWebAppUrl, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ ...payload, secret: mailerSharedSecret }),
      signal: AbortSignal.timeout(timeoutMs),
    });
    console.log(JSON.stringify({
      event: "zyro_upstream_request",
      requestId,
      service: "google_apps_script",
      action: payload.action,
      status: response.status,
      durationMs: Math.round(performance.now() - startedAt)
    }));
  } catch (cause) {
    console.warn(JSON.stringify({
      event: "zyro_upstream_error",
      requestId,
      service: "google_apps_script",
      action: payload.action,
      durationMs: Math.round(performance.now() - startedAt),
      error: cause?.name || "NetworkError"
    }));
    const error = new Error("Không nhận được phản hồi từ Google Apps Script. Với yêu cầu gửi thư, hãy kiểm tra Gmail mục Đã gửi trước khi thử lại.");
    error.status = 502;
    error.deliveryStatus = payload.action === "send" ? "uncertain" : "pending";
    error.cause = cause;
    throw error;
  }

  let result;
  try {
    result = await response.json();
  } catch {
    const error = new Error("Google Apps Script không trả về phản hồi JSON hợp lệ. Với yêu cầu gửi thư, hãy kiểm tra Gmail mục Đã gửi trước khi thử lại.");
    error.status = 502;
    error.deliveryStatus = payload.action === "send" ? "uncertain" : "pending";
    throw error;
  }

  if (!response.ok || result.ok !== true) {
    const error = new Error(result.message || `Google Apps Script trả về HTTP ${response.status}.`);
    error.status = response.ok ? (Number(result.httpStatus) || 502) : response.status;
    error.deliveryStatus = result.deliveryStatus === "uncertain" || (payload.action === "send" && result.deliveryStatus !== "pending")
      ? "uncertain"
      : "pending";
    throw error;
  }

  if (payload.action === "send" && (typeof result.messageId !== "string" || !result.messageId)) {
    const error = new Error("Google Apps Script đã phản hồi nhưng thiếu mã xác nhận. Hãy kiểm tra Gmail mục Đã gửi trước khi thử lại.");
    error.status = 502;
    error.deliveryStatus = "uncertain";
    throw error;
  }
  return result;
}

async function edgeFetch(pathname, options = {}) {
  const {
    requestId = crypto.randomUUID(),
    timeoutMs = 30000,
    ...fetchOptions
  } = options;
  const startedAt = performance.now();
  let response;

  try {
    response = await fetch(`${apiUrl}${pathname}`, {
      ...fetchOptions,
      headers: {
        "Content-Type": "application/json",
        ...(fetchOptions.headers || {}),
        "X-Request-Id": requestId,
      },
      signal: AbortSignal.timeout(timeoutMs),
    });
  } catch (cause) {
    const timedOut = cause?.name === "TimeoutError" || cause?.name === "AbortError";
    console.error(JSON.stringify({
      event: "zyro_upstream_error",
      requestId,
      service: "supabase_edge",
      method: fetchOptions.method || "GET",
      path: pathname,
      durationMs: Math.round(performance.now() - startedAt),
      outcome: timedOut ? "timeout" : "network_error",
      error: cause?.name || "NetworkError"
    }));
    const error = new Error(timedOut ? "Supabase API phản hồi quá thời gian chờ." : "Không kết nối được Supabase API.");
    error.status = timedOut ? 504 : 502;
    error.requestId = requestId;
    error.cause = cause;
    throw error;
  }

  const body = await response.json().catch(() => ({}));
  console.log(JSON.stringify({
    event: "zyro_upstream_request",
    requestId,
    service: "supabase_edge",
    method: fetchOptions.method || "GET",
    path: pathname,
    status: response.status,
    durationMs: Math.round(performance.now() - startedAt)
  }));
  if (!response.ok) {
    const error = new Error(body.message || `ZYRO API error ${response.status}`);
    error.status = response.status;
    error.body = body;
    error.requestId = requestId;
    throw error;
  }
  return body;
}

// Liveness: this endpoint must only report whether the Node.js process can answer HTTP.
app.get("/health", (_req, res) => {
  res.setHeader("Cache-Control", "no-store");
  res.status(200).json({ ok: true, service: "zyro-club-form" });
});

// Readiness: check Supabase separately; this must never delay the liveness endpoint.
app.get("/ready", async (req, res) => {
  try {
    await edgeFetch("/health", { requestId: req.requestId, timeoutMs: 8000 });
    res.setHeader("Cache-Control", "no-store");
    res.json({ ok: true, service: "zyro-club-form", dependencies: { supabase: true } });
  } catch (error) {
    res.setHeader("Cache-Control", "no-store");
    res.status(503).json({
      ok: false,
      service: "zyro-club-form",
      dependencies: { supabase: false },
      requestId: req.requestId
    });
  }
});

const allowedAdminOrigins = new Set([
  "https://zyro-volleyball-club.onrender.com",
  "https://zyro-club-form.onrender.com",
  "http://localhost:3000",
  "http://127.0.0.1:3000",
]);

app.use("/api/admin", (req, res, next) => {
  const origin = req.headers.origin;
  if (origin && !allowedAdminOrigins.has(origin)) {
    return res.status(403).json({ message: "Nguồn truy cập không được phép." });
  }
  if (origin) {
    res.setHeader("Access-Control-Allow-Origin", origin);
    res.setHeader("Vary", "Origin");
    res.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, X-Request-Id");
    res.setHeader("Access-Control-Expose-Headers", "X-Request-Id");
    res.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
  }
  if (req.method === "OPTIONS") return res.sendStatus(204);
  next();
});

app.get("/api/admin/email-settings", requireEdgeAdmin, async (req, res) => {
  if (!mailerWebAppUrl || !mailerSharedSecret) {
    res.setHeader("Cache-Control", "no-store");
    return res.json({ configured: false, senderEmail: "", remainingDailyQuota: null });
  }
  try {
    const settings = await appsScriptRequest({ action: "status" }, { requestId: req.requestId, timeoutMs: 8000 });
    res.setHeader("Cache-Control", "no-store");
    res.json({
      senderEmail: settings.senderEmail || "",
      configured: true,
      remainingDailyQuota: Number.isFinite(settings.remainingDailyQuota) ? settings.remainingDailyQuota : null,
    });
  } catch (error) {
    res.status(error.status || 503).json({ message: error.message || "Không kiểm tra được Google Apps Script Mail Relay." });
  }
});

app.post("/api/admin/email-settings/test", requireEdgeAdmin, async (req, res) => {
  try {
    const result = await appsScriptRequest({ action: "status" }, { requestId: req.requestId, timeoutMs: 8000 });
    res.json({
      ok: true,
      message: "Kết nối Google Apps Script thành công.",
      senderEmail: result.senderEmail || "",
      remainingDailyQuota: Number.isFinite(result.remainingDailyQuota) ? result.remainingDailyQuota : null,
    });
  } catch (error) {
    res.status(error.status || 502).json({ message: error.message || "Không kiểm tra được Google Apps Script." });
  }
});

app.post("/api/admin/email-settings/test-send", requireEdgeAdmin, async (req, res) => {
  try {
    const to = String(req.body?.to || "").trim().toLowerCase();
    if (!validEmail(to)) return res.status(400).json({ message: "Nhập email nhận thử hợp lệ." });
    const result = await appsScriptRequest({
      action: "send",
      to,
      subject: "Kiểm tra email ZYRO Volleyball Club",
      html: "<p>Đây là email thử để xác nhận Google Apps Script Mail Relay của <strong>ZYRO Volleyball Club</strong> hoạt động.</p>",
      idempotencyKey: "test-" + crypto.randomUUID(),
    }, { requestId: req.requestId });
    res.json({
      ok: true,
      message: "Google đã tiếp nhận yêu cầu gửi email thử. Hãy kiểm tra hộp thư đến và Spam.",
      messageId: result.messageId || null,
      remainingDailyQuota: Number.isFinite(result.remainingDailyQuota) ? result.remainingDailyQuota : null,
      to,
    });
  } catch (error) {
    res.status(error.status || 502).json({ message: error.message || "Không gửi được email thử qua Google Apps Script." });
  }
});

app.post("/api/admin/send-email", requireEdgeAdmin, async (req, res) => {
  try {
    const to = String(req.body?.to || "").trim().toLowerCase();
    const subject = String(req.body?.subject || "").replace(/[\r\n]+/g, " ").trim().slice(0, 180);
    const html = typeof req.body?.html === "string" ? req.body.html : "";
    const idempotencyKey = String(req.body?.idempotencyKey || "").trim();
    if (!validEmail(to) || !subject || !html || html.length > 30000 || !/^[a-z0-9_-]{8,160}$/i.test(idempotencyKey)) {
      return res.status(400).json({ message: "Thông tin email gửi đi không hợp lệ.", deliveryStatus: "pending" });
    }

    const result = await appsScriptRequest({
      action: "send",
      to,
      subject,
      html,
      idempotencyKey,
    }, { requestId: req.requestId });
    res.json({ ok: true, messageId: result.messageId || null, remainingDailyQuota: result.remainingDailyQuota ?? null });
  } catch (error) {
    res.status(502).json({
      message: error.message || "Google Apps Script không gửi được email.",
      deliveryStatus: error.deliveryStatus === "uncertain" ? "uncertain" : "pending",
    });
  }
});

app.post("/api/registrations", submitRateLimit, async (req, res, next) => {
  try {
    const result = validateRegistration(req.body);
    if (!result.ok) return res.status(400).json({ message: "Kiểm tra lại thông tin nhé.", errors: result.errors });
    const item = await edgeFetch("/registrations", { method: "POST", body: JSON.stringify(result.data), requestId: req.requestId });
    res.status(201).json({ id: item.id, message: "Đã nhận đăng ký." });
  } catch (error) {
    next(error);
  }
});

app.get("/admin", requireAdmin, (_req, res) => res.sendFile(path.join(__dirname, "public", "admin.html")));
app.get("/api/admin/registrations", requireAdmin, async (req, res, next) => {
  try {
    res.json(await edgeFetch("/registrations", {
      headers: { Authorization: req.headers.authorization },
      requestId: req.requestId,
    }));
  } catch (error) {
    next(error);
  }
});
app.patch("/api/admin/registrations/:id", requireAdmin, async (req, res, next) => {
  try {
    if (!new Set(["new", "approved", "rejected"]).has(req.body.status)) {
      return res.status(400).json({ message: "Trạng thái không hợp lệ." });
    }
    res.json(await edgeFetch(`/registrations/${encodeURIComponent(req.params.id)}`, {
      method: "PATCH",
      body: JSON.stringify({ status: req.body.status }),
      headers: { Authorization: req.headers.authorization },
      requestId: req.requestId,
    }));
  } catch (error) {
    next(error);
  }
});

app.get("/api/admin/zalo-mapping/groups", requireAdmin, async (req, res) => {
  try {
    res.setHeader("Cache-Control", "no-store");
    res.json(await edgeFetch("/zalo-mapping/groups", {
      headers: { Authorization: req.headers.authorization },
      requestId: req.requestId,
    }));
  } catch (error) {
    const status = Number(error.status);
    res.status(Number.isInteger(status) && status >= 400 && status <= 599 ? status : 502)
      .json({ message: error.message || "Không tải được danh sách nhóm Zalo từ Draft." });
  }
});

app.get("/api/admin/zalo-mapping/groups/:connectionId/:groupId/members", requireAdmin, async (req, res) => {
  try {
    const connectionId = String(req.params.connectionId || "").trim();
    const groupId = String(req.params.groupId || "").trim();
    if (!connectionId || !groupId || connectionId.length > 128 || groupId.length > 128) {
      return res.status(400).json({ message: "Mã tài khoản hoặc nhóm Zalo không hợp lệ." });
    }
    res.setHeader("Cache-Control", "no-store");
    res.json(await edgeFetch(
      `/zalo-mapping/groups/${encodeURIComponent(connectionId)}/${encodeURIComponent(groupId)}/members`,
      { headers: { Authorization: req.headers.authorization }, requestId: req.requestId },
    ));
  } catch (error) {
    const status = Number(error.status);
    res.status(Number.isInteger(status) && status >= 400 && status <= 599 ? status : 502)
      .json({ message: error.message || "Không tải được danh bạ thành viên Zalo." });
  }
});

app.get("/api/admin/zalo-mapping/registrations", requireAdmin, async (req, res) => {
  try {
    res.setHeader("Cache-Control", "no-store");
    res.json(await edgeFetch("/zalo-mapping/registrations", {
      headers: { Authorization: req.headers.authorization },
      requestId: req.requestId,
    }));
  } catch (error) {
    const status = Number(error.status);
    res.status(Number.isInteger(status) && status >= 400 && status <= 599 ? status : 502)
      .json({ message: error.message || "Không tải được hồ sơ đăng ký để mapping." });
  }
});

app.post("/api/admin/zalo-mapping/sync", requireAdmin, async (req, res) => {
  try {
    res.setHeader("Cache-Control", "no-store");
    res.json(await edgeFetch("/zalo-mapping/sync", {
      method: "POST",
      body: JSON.stringify(req.body || {}),
      headers: { Authorization: req.headers.authorization },
      requestId: req.requestId,
    }));
  } catch (error) {
    const status = Number(error.status);
    res.status(Number.isInteger(status) && status >= 400 && status <= 599 ? status : 502)
      .json({ message: error.message || "Không đồng bộ được hồ sơ thành viên sang Draft." });
  }
});

app.use((error, req, res, _next) => {
  console.error(JSON.stringify({
    event: "zyro_request_error",
    requestId: req.requestId || null,
    status: Number(error?.status) || 500,
    message: error?.message || "Unknown server error"
  }));
  const status = Number(error?.status);
  res.status(Number.isInteger(status) && status >= 400 && status <= 599 ? status : 500)
    .json({ message: "Có lỗi máy chủ. Vui lòng thử lại sau.", requestId: req.requestId || null });
});

app.listen(port, "0.0.0.0", () => console.log(`ZYRO form running on http://localhost:${port}`));

