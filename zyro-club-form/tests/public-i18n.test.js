import test from "node:test";
import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import { languages, normalizeLanguage, translate, hasTranslation } from "../public/i18n.js";

test("public languages support Vietnamese, English and Thai with safe fallback", () => {
  assert.deepEqual(languages, ["vi", "en", "th"]);
  assert.equal(normalizeLanguage("fr"), "vi");
  assert.equal(translate("Gửi đăng ký", "en"), "Submit application");
  assert.equal(translate("Gửi đăng ký", "th"), "ส่งใบสมัคร");
  assert.equal(translate("Gửi đăng ký", "vi"), "Gửi đăng ký");
  assert.equal(translate("Custom admin copy", "th"), "Custom admin copy");
});

test("all live form option captions and validation messages have translations", () => {
  const labels = ["Lâu dài", "Muốn trải nghiệm trước", "Ngắn hạn", "Nam", "Nữ",
    "Công", "Thủ", "Chuyền 2", "Toàn diện", "Người mới", "Trung bình", "Tốt",
    "Nhập tên Zalo để tụi mình nhận ra bạn nhé.", "Chọn một phương án để tiếp tục.",
    "Chọn một phương án.", "Viết vài chữ về điều bạn mong muốn khi vào sân nhé.",
    "Email chưa đúng định dạng. Bạn kiểm tra lại nhé.", "Đang gửi...",
    "Bước cuối: chủ động nhắn Zalo cho một trong các admin và ghi “Mình đã hoàn thành form” để tụi mình check nhanh nhé."];
  for (const label of labels) {
    assert.ok(hasTranslation(label), label);
    for (const language of ["en", "th"]) {
      assert.notEqual(translate(label, language), label);
    }
  }
});

test("public language controls do not alter registration payload or historical API", async () => {
  const html = await readFile(new URL("../public/index.html", import.meta.url), "utf8");
  const app = await readFile(new URL("../public/app.js", import.meta.url), "utf8");
  for (const language of languages) assert.match(html, new RegExp('data-language="' + language + '"'));
  assert.match(app, /grhdawkxnrkgkahegnnd\.supabase\.co\/functions\/v1\/zyro-api/);
  assert.match(app, /input\.value = option\.id/);
  assert.match(app, /choice\.querySelector\("input"\)\.checked = option\.id === selected/);
  assert.match(app, /zyro\.public\.language/);
  assert.match(app, /document\.documentElement\.lang = language/);
});
