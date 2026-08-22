package com.daerisoft.thespikerm;

import android.app.Activity;
import android.util.Log;
import com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogDataset;
import com.google.android.gms.ads.internal.offline.buffering.Dk.eoBKjVuj;
import com.google.android.gms.games.snapshot.Xa.JrbhsraGtto;
import com.google.protobuf.util.JsonFormat;
import com.yoyogames.runner.RunnerJNILib;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Base64;
import java.util.Iterator;
import java.util.concurrent.CompletableFuture;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Dispatcher;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.RequestBody$Companion$toRequestBody$2;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.platform.Platform;
import okio.BufferedSource;
import okio.GzipSink;
import okio.RealBufferedSink;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class SuncyanNet extends RunnerActivity {
    public static final int EVENT_OTHER_SOCIAL = 70;
    public static final int GZIP_THRESHOLD_BYTES = 4096;
    public static Activity activity = RunnerActivity.CurrentActivity;
    public static OkHttpClient client;

    /* JADX INFO: renamed from: com.daerisoft.thespikerm.SuncyanNet$1 */
    /* JADX INFO: loaded from: classes.dex */
    public final class AnonymousClass1 extends RequestBody {
        public AnonymousClass1() {
        }

        @Override // okhttp3.RequestBody
        public final long contentLength() {
            return -1L;
        }

        @Override // okhttp3.RequestBody
        public final MediaType contentType() {
            return requestBody.contentType();
        }

        @Override // okhttp3.RequestBody
        public final void writeTo(RealBufferedSink realBufferedSink) {
            RealBufferedSink realBufferedSink2 = new RealBufferedSink(new GzipSink(realBufferedSink));
            requestBody.writeTo(realBufferedSink2);
            realBufferedSink2.close();
        }
    }

    public static void ApplicationEnd() {
        RunnerActivity.ViewHandler.post(new RunnerJNILib.AnonymousClass1(8));
    }

    public static String Base64ProtobufToGameLog(String str) throws IOException {
        if (str == null) {
            str = "";
        }
        return JsonFormat.printer().omittingInsignificantWhitespace().print(GameLogDataset.parseFrom(gunzipBytes(Base64.getDecoder().decode(str))));
    }

    public static double Base64ProtobufToGameLogAsync(String str) {
        int iJCreateDsMap = RunnerJNILib.jCreateDsMap(null, null, null);
        CompletableFuture.runAsync(new SuncyanNet$$ExternalSyntheticLambda8(str, iJCreateDsMap, 1));
        return iJCreateDsMap;
    }

    public static String ClientRequestExecute(String toHttpUrl, String str, String str2, String str3) {
        String upperCase = str == null ? "POST" : str.trim().toUpperCase();
        Request.Builder builder = new Request.Builder();
        Intrinsics.checkNotNullParameter(toHttpUrl, "url");
        if (StringsKt__StringsKt.startsWith(toHttpUrl, "ws:", true)) {
            String strSubstring = toHttpUrl.substring(3);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
            toHttpUrl = "http:".concat(strSubstring);
        } else if (StringsKt__StringsKt.startsWith(toHttpUrl, "wss:", true)) {
            String strSubstring2 = toHttpUrl.substring(4);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.String).substring(startIndex)");
            toHttpUrl = "https:".concat(strSubstring2);
        }
        Intrinsics.checkNotNullParameter(toHttpUrl, "$this$toHttpUrl");
        HttpUrl.Builder builder2 = new HttpUrl.Builder();
        builder2.parse$okhttp(null, toHttpUrl);
        builder.url = builder2.build();
        Pattern pattern = MediaType.TYPE_SUBTYPE;
        MediaType mediaType = MediaType.Companion.get("application/json; charset=utf-8");
        Headers.Builder builder3 = (Headers.Builder) builder.headers;
        builder3.getClass();
        Headers.Companion.checkName("Content-Type");
        Headers.Companion.checkValue("application/json; charset=utf-8", "Content-Type");
        builder3.addLenient$okhttp("Content-Type", "application/json; charset=utf-8");
        if (str3 != null && !str3.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(str3);
                Iterator itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String name = (String) itKeys.next();
                    String strOptString = jSONObject.optString(name, null);
                    if (strOptString != null) {
                        Intrinsics.checkNotNullParameter(name, "name");
                        Headers.Builder builder4 = (Headers.Builder) builder.headers;
                        builder4.getClass();
                        Headers.Companion.checkName(name);
                        Headers.Companion.checkValue(strOptString, name);
                        builder4.addLenient$okhttp(name, strOptString);
                    }
                }
            } catch (Exception e) {
                Log.w(GooglePlayBillingService.TAG, "Invalid additional_header JSON: " + e.getMessage());
            }
        }
        if (upperCase.equals("POST") || upperCase.equals("PUT") || upperCase.equals("PATCH") || upperCase.equals("DELETE")) {
            if (str2 == null) {
                str2 = "{}";
            }
            byte[] bytes = str2.getBytes(StandardCharsets.UTF_8);
            RequestBody$Companion$toRequestBody$2 requestBody$Companion$toRequestBody$2Create$default = HttpUrl.Companion.create$default(bytes, mediaType, 6);
            if (bytes.length >= 4096) {
                RequestBody requestBodyGzip = gzip(requestBody$Companion$toRequestBody$2Create$default);
                Headers.Builder builder5 = (Headers.Builder) builder.headers;
                builder5.getClass();
                Headers.Companion.checkName("Content-Encoding");
                Headers.Companion.checkValue("gzip", "Content-Encoding");
                builder5.addLenient$okhttp("Content-Encoding", "gzip");
                builder.method(upperCase, requestBodyGzip);
            } else {
                builder.method(upperCase, requestBody$Companion$toRequestBody$2Create$default);
            }
        } else {
            builder.method(upperCase, null);
        }
        Request requestBuild = builder.build();
        OkHttpClient okHttpClient = client;
        okHttpClient.getClass();
        RealCall realCall = new RealCall(okHttpClient, requestBuild);
        if (!realCall.executed.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed");
        }
        realCall.timeout.enter();
        Platform platform = Platform.platform;
        realCall.callStackTrace = Platform.platform.getStackTraceForCloseable();
        try {
            Dispatcher dispatcher = okHttpClient.dispatcher;
            synchronized (dispatcher) {
                ((ArrayDeque) dispatcher.runningSyncCalls).add(realCall);
            }
            Response responseWithInterceptorChain$okhttp = realCall.getResponseWithInterceptorChain$okhttp();
            okHttpClient.dispatcher.finished$okhttp(realCall);
            try {
                RealResponseBody realResponseBody = responseWithInterceptorChain$okhttp.body;
                if (realResponseBody == null) {
                    responseWithInterceptorChain$okhttp.close();
                    return "";
                }
                BufferedSource bufferedSourceSource = realResponseBody.source();
                try {
                    String string = bufferedSourceSource.readString(Util.readBomAsCharset(bufferedSourceSource, realResponseBody.charset()));
                    CloseableKt.closeFinally(bufferedSourceSource, null);
                    responseWithInterceptorChain$okhttp.close();
                    return string;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(bufferedSourceSource, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    responseWithInterceptorChain$okhttp.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        } catch (Throwable th5) {
            realCall.client.dispatcher.finished$okhttp(realCall);
            throw th5;
        }
    }

    public static String GameLogToProtobufBase64WithCompress(String str) throws IOException {
        if (str == null) {
            str = "{}";
        }
        GameLogDataset.Builder builderNewBuilder = GameLogDataset.newBuilder();
        JsonFormat.parser().ignoringUnknownFields().merge(str, builderNewBuilder);
        return Base64.getEncoder().encodeToString(gzipBytes(builderNewBuilder.build().toByteArray()));
    }

    public static double GameLogToProtobufBase64WithCompressAsync(String str) {
        int iJCreateDsMap = RunnerJNILib.jCreateDsMap(null, null, null);
        CompletableFuture.runAsync(new SuncyanNet$$ExternalSyntheticLambda8(str, iJCreateDsMap, 0));
        return iJCreateDsMap;
    }

    public static double RequestMTLS(String str, String str2, String str3, String str4) {
        int iJCreateDsMap = RunnerJNILib.jCreateDsMap(null, null, null);
        CompletableFuture.runAsync(new SuncyanNet$$ExternalSyntheticLambda10(str, str2, str3, str4, iJCreateDsMap));
        return iJCreateDsMap;
    }

    public static double SetCreateSuncyanMTLSClient(String str, String str2) {
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            byte[] bArrDecode = Base64.getDecoder().decode(str);
            Charset charset = StandardCharsets.UTF_8;
            new String(bArrDecode, charset);
            byte[] bArrDecode2 = Base64.getDecoder().decode(str.replace("-----BEGIN CERTIFICATE-----", "").replace("\n", "").replace("\r", "").replace("-----END CERTIFICATE-----", ""));
            keyStore.setKeyEntry(JrbhsraGtto.hdqcq, KeyFactory.getInstance(RunnerBillingSecurity.KEY_FACTORY_ALGORITHM).generatePrivate(new PKCS8EncodedKeySpec(Base64.getDecoder().decode(new String(Base64.getDecoder().decode(str2), charset).replace(eoBKjVuj.AJbs, "").replace("\n", "").replace("\r", "").replace("-----END PRIVATE KEY-----", "")))), "asdkljfbaskljdbfkjh2q34bfjkq3h4bfjkqh3g".toCharArray(), new Certificate[]{CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArrDecode2))});
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(keyStore, "asdkljfbaskljdbfkjh2q34bfjkq3h4bfjkqh3g".toCharArray());
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), new SecureRandom());
            SuncyanNet$$ExternalSyntheticLambda7 suncyanNet$$ExternalSyntheticLambda7 = new SuncyanNet$$ExternalSyntheticLambda7();
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.protocols(Arrays.asList(Protocol.HTTP_1_1));
            SSLSocketFactory sslSocketFactory = sSLContext.getSocketFactory();
            X509TrustManager trustManager = (X509TrustManager) trustManagerFactory.getTrustManagers()[0];
            Intrinsics.checkNotNullParameter(sslSocketFactory, "sslSocketFactory");
            Intrinsics.checkNotNullParameter(trustManager, "trustManager");
            if (sslSocketFactory.equals(builder.sslSocketFactoryOrNull)) {
                trustManager.equals(builder.x509TrustManagerOrNull);
            }
            builder.sslSocketFactoryOrNull = sslSocketFactory;
            Platform platform = Platform.platform;
            builder.certificateChainCleaner = Platform.platform.buildCertificateChainCleaner(trustManager);
            builder.x509TrustManagerOrNull = trustManager;
            builder.hostnameVerifier = suncyanNet$$ExternalSyntheticLambda7;
            client = new OkHttpClient(builder);
            return 1.0d;
        } catch (Exception e) {
            Log.i(GooglePlayBillingService.TAG, "Suncyan mTLS Error: " + e.getMessage());
            return 0.0d;
        }
    }

    public static void SetSuncyanCertificateWithEncodedCertGmx(String str, String str2) {
    }

    public static byte[] gunzipBytes(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
        try {
            byte[] bArr2 = new byte[4096];
            while (true) {
                int i = gZIPInputStream.read(bArr2);
                if (i == -1) {
                    gZIPInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr2, 0, i);
            }
        } catch (Throwable th) {
            try {
                gZIPInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static RequestBody gzip(RequestBody requestBody) {
        return new RequestBody() { // from class: com.daerisoft.thespikerm.SuncyanNet.1
            public AnonymousClass1() {
            }

            @Override // okhttp3.RequestBody
            public final long contentLength() {
                return -1L;
            }

            @Override // okhttp3.RequestBody
            public final MediaType contentType() {
                return requestBody.contentType();
            }

            @Override // okhttp3.RequestBody
            public final void writeTo(RealBufferedSink realBufferedSink) {
                RealBufferedSink realBufferedSink2 = new RealBufferedSink(new GzipSink(realBufferedSink));
                requestBody.writeTo(realBufferedSink2);
                realBufferedSink2.close();
            }
        };
    }

    public static byte[] gzipBytes(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                gZIPOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static /* synthetic */ void lambda$Base64ProtobufToGameLogAsync$3(String str, int i) {
        try {
            String strBase64ProtobufToGameLog = Base64ProtobufToGameLog(str);
            RunnerJNILib.DsMapAddDouble(i, "status", 1.0d);
            RunnerJNILib.DsMapAddString(i, "result", strBase64ProtobufToGameLog);
        } catch (Exception e) {
            RunnerJNILib.DsMapAddDouble(i, "status", -1.0d);
            RunnerJNILib.DsMapAddString(i, "error", e.toString());
        }
        RunnerJNILib.CreateAsynEventWithDSMap(i, 70);
    }

    public static /* synthetic */ void lambda$GameLogToProtobufBase64WithCompressAsync$2(String str, int i) {
        try {
            String strGameLogToProtobufBase64WithCompress = GameLogToProtobufBase64WithCompress(str);
            RunnerJNILib.DsMapAddDouble(i, "status", 1.0d);
            RunnerJNILib.DsMapAddString(i, "result", strGameLogToProtobufBase64WithCompress);
        } catch (Exception e) {
            RunnerJNILib.DsMapAddDouble(i, "status", -1.0d);
            RunnerJNILib.DsMapAddString(i, "error", e.toString());
        }
        RunnerJNILib.CreateAsynEventWithDSMap(i, 70);
    }

    public static /* synthetic */ void lambda$RequestMTLS$1(String str, String str2, String str3, String str4, int i) {
        try {
            String strClientRequestExecute = ClientRequestExecute(str, str2, str3, str4);
            RunnerJNILib.DsMapAddDouble(i, "id", i);
            RunnerJNILib.DsMapAddDouble(i, "status", 1.0d);
            RunnerJNILib.DsMapAddString(i, "result", strClientRequestExecute);
            RunnerJNILib.CreateAsynEventWithDSMap(i, 70);
        } catch (Exception e) {
            RunnerJNILib.DsMapAddDouble(i, "id", i);
            RunnerJNILib.DsMapAddDouble(i, "status", -1.0d);
            RunnerJNILib.DsMapAddString(i, "error", e.toString());
            RunnerJNILib.CreateAsynEventWithDSMap(i, 70);
        }
    }

    public static /* synthetic */ boolean lambda$SetCreateSuncyanMTLSClient$0(String str, SSLSession sSLSession) {
        return true;
    }
}
