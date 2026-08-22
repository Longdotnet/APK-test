package okhttp3.internal.cache;

import com.google.firebase.auth.zzz;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RealResponseBody;

/* JADX INFO: loaded from: classes3.dex */
public final class CacheInterceptor implements Interceptor {

    public final class Companion {
        public static final Response access$stripBody(Response response) {
            if ((response != null ? response.body : null) == null) {
                return response;
            }
            Response.Builder builderNewBuilder = response.newBuilder();
            builderNewBuilder.body = null;
            return builderNewBuilder.build();
        }

        public static boolean isEndToEnd(String str) {
            return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
        }
    }

    /* JADX WARN: Code duplicated, block: B:175:0x01c6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:176:0x007a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:177:0x0080 A[EDGE_INSN: B:177:0x0080->B:24:0x0080 BREAK  A[LOOP:2: B:18:0x0064->B:22:0x0075], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:17:0x005f  */
    /* JADX WARN: Code duplicated, block: B:19:0x0066  */
    /* JADX WARN: Code duplicated, block: B:22:0x0075 A[LOOP:2: B:18:0x0064->B:22:0x0075, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:30:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:57:0x012d  */
    /* JADX WARN: Code duplicated, block: B:58:0x0131  */
    /* JADX WARN: Code duplicated, block: B:60:0x0139  */
    /* JADX WARN: Code duplicated, block: B:61:0x013d  */
    /* JADX WARN: Code duplicated, block: B:63:0x0145  */
    /* JADX WARN: Code duplicated, block: B:64:0x014d  */
    /* JADX WARN: Code duplicated, block: B:66:0x0156  */
    /* JADX WARN: Code duplicated, block: B:67:0x015e  */
    /* JADX WARN: Code duplicated, block: B:69:0x0166  */
    /* JADX WARN: Code duplicated, block: B:70:0x016a  */
    /* JADX WARN: Code duplicated, block: B:72:0x0172  */
    /* JADX WARN: Code duplicated, block: B:73:0x0176  */
    /* JADX WARN: Code duplicated, block: B:75:0x017e  */
    /* JADX WARN: Code duplicated, block: B:76:0x0182  */
    /* JADX WARN: Code duplicated, block: B:78:0x018a  */
    /* JADX WARN: Code duplicated, block: B:79:0x0195  */
    /* JADX WARN: Code duplicated, block: B:81:0x019d  */
    /* JADX WARN: Code duplicated, block: B:82:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:84:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:85:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:87:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:88:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:90:0x01c4  */
    @Override // okhttp3.Interceptor
    public final Response intercept(RealInterceptorChain realInterceptorChain) {
        zzz zzzVar;
        Headers headers;
        Headers headers2;
        int i;
        int length;
        int length2;
        zzz zzzVar2;
        String string;
        Headers headers3;
        int length3;
        String string2;
        int i2;
        System.currentTimeMillis();
        Request request = realInterceptorChain.request;
        zzz zzzVar3 = new zzz((Object) request, (AutoCloseable) null, 11);
        CacheControl cacheControl = (CacheControl) request.lazyCacheControl;
        if (cacheControl == null) {
            int i3 = CacheControl.$r8$clinit;
            Headers headers4 = (Headers) request.headers;
            int size = headers4.size();
            String str = null;
            int i4 = 0;
            boolean z = true;
            boolean z2 = false;
            boolean z3 = false;
            int nonNegativeInt = -1;
            int nonNegativeInt2 = -1;
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = false;
            int nonNegativeInt3 = -1;
            int nonNegativeInt4 = -1;
            boolean z7 = false;
            boolean z8 = false;
            boolean z9 = false;
            while (i4 < size) {
                String strName = headers4.name(i4);
                String strValue = headers4.value(i4);
                if (StringsKt__StringsKt.equals(strName, "Cache-Control")) {
                    if (str == null) {
                        str = strValue;
                    }
                    i = 0;
                    while (i < strValue.length()) {
                        length = strValue.length();
                        length2 = i;
                        while (true) {
                            if (length2 < length) {
                                zzzVar2 = zzzVar3;
                                length2 = strValue.length();
                                break;
                            }
                            zzzVar2 = zzzVar3;
                            if (StringsKt__StringsKt.contains$default("=,;", strValue.charAt(length2))) {
                                break;
                            }
                            length2++;
                            zzzVar3 = zzzVar2;
                        }
                        String strSubstring = strValue.substring(i, length2);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        string = StringsKt__StringsKt.trim(strSubstring).toString();
                        if (length2 != strValue.length() || strValue.charAt(length2) == ',' || strValue.charAt(length2) == ';') {
                            headers3 = headers4;
                            length3 = length2 + 1;
                            string2 = null;
                        } else {
                            int length4 = length2 + 1;
                            byte[] bArr = Util.EMPTY_BYTE_ARRAY;
                            int length5 = strValue.length();
                            while (true) {
                                if (length4 >= length5) {
                                    i2 = 1;
                                    length4 = strValue.length();
                                    break;
                                }
                                char cCharAt = strValue.charAt(length4);
                                int i5 = length5;
                                if (cCharAt != ' ' && cCharAt != '\t') {
                                    i2 = 1;
                                    break;
                                }
                                length4++;
                                length5 = i5;
                            }
                            if (length4 < strValue.length()) {
                                headers3 = headers4;
                                if (strValue.charAt(length4) == '\"') {
                                    int i6 = length4 + i2;
                                    int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) strValue, '\"', i6, false, 4);
                                    string2 = strValue.substring(i6, iIndexOf$default);
                                    Intrinsics.checkNotNullExpressionValue(string2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                    length3 = iIndexOf$default + 1;
                                }
                            } else {
                                headers3 = headers4;
                            }
                            int length6 = strValue.length();
                            length3 = length4;
                            while (true) {
                                if (length3 >= length6) {
                                    length3 = strValue.length();
                                    break;
                                }
                                int i7 = length6;
                                if (StringsKt__StringsKt.contains$default(",;", strValue.charAt(length3))) {
                                    break;
                                }
                                length3++;
                                length6 = i7;
                            }
                            String strSubstring2 = strValue.substring(length4, length3);
                            Intrinsics.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            string2 = StringsKt__StringsKt.trim(strSubstring2).toString();
                        }
                        if ("no-cache".equalsIgnoreCase(string)) {
                            z2 = true;
                        } else if ("no-store".equalsIgnoreCase(string)) {
                            z3 = true;
                        } else if ("max-age".equalsIgnoreCase(string)) {
                            nonNegativeInt = Util.toNonNegativeInt(-1, string2);
                        } else if ("s-maxage".equalsIgnoreCase(string)) {
                            nonNegativeInt2 = Util.toNonNegativeInt(-1, string2);
                        } else if ("private".equalsIgnoreCase(string)) {
                            z4 = true;
                        } else if ("public".equalsIgnoreCase(string)) {
                            z5 = true;
                        } else if ("must-revalidate".equalsIgnoreCase(string)) {
                            z6 = true;
                        } else if ("max-stale".equalsIgnoreCase(string)) {
                            nonNegativeInt3 = Util.toNonNegativeInt(Integer.MAX_VALUE, string2);
                        } else if ("min-fresh".equalsIgnoreCase(string)) {
                            nonNegativeInt4 = Util.toNonNegativeInt(-1, string2);
                        } else if ("only-if-cached".equalsIgnoreCase(string)) {
                            z7 = true;
                        } else if ("no-transform".equalsIgnoreCase(string)) {
                            z8 = true;
                        } else if ("immutable".equalsIgnoreCase(string)) {
                            z9 = true;
                        }
                        i = length3;
                        zzzVar3 = zzzVar2;
                        headers4 = headers3;
                    }
                    i4++;
                    zzzVar3 = zzzVar3;
                    headers4 = headers4;
                } else {
                    if (StringsKt__StringsKt.equals(strName, "Pragma")) {
                    }
                    i4++;
                    zzzVar3 = zzzVar3;
                    headers4 = headers4;
                }
                z = false;
                i = 0;
                while (i < strValue.length()) {
                    length = strValue.length();
                    length2 = i;
                    while (true) {
                        if (length2 < length) {
                            zzzVar2 = zzzVar3;
                            length2 = strValue.length();
                            break;
                        }
                        zzzVar2 = zzzVar3;
                        if (StringsKt__StringsKt.contains$default("=,;", strValue.charAt(length2))) {
                            break;
                            break;
                        }
                        length2++;
                        zzzVar3 = zzzVar2;
                    }
                    String strSubstring3 = strValue.substring(i, length2);
                    Intrinsics.checkNotNullExpressionValue(strSubstring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    string = StringsKt__StringsKt.trim(strSubstring3).toString();
                    if (length2 != strValue.length()) {
                        headers3 = headers4;
                        length3 = length2 + 1;
                        string2 = null;
                    } else {
                        headers3 = headers4;
                        length3 = length2 + 1;
                        string2 = null;
                    }
                    if ("no-cache".equalsIgnoreCase(string)) {
                        z2 = true;
                    } else if ("no-store".equalsIgnoreCase(string)) {
                        z3 = true;
                    } else if ("max-age".equalsIgnoreCase(string)) {
                        nonNegativeInt = Util.toNonNegativeInt(-1, string2);
                    } else if ("s-maxage".equalsIgnoreCase(string)) {
                        nonNegativeInt2 = Util.toNonNegativeInt(-1, string2);
                    } else if ("private".equalsIgnoreCase(string)) {
                        z4 = true;
                    } else if ("public".equalsIgnoreCase(string)) {
                        z5 = true;
                    } else if ("must-revalidate".equalsIgnoreCase(string)) {
                        z6 = true;
                    } else if ("max-stale".equalsIgnoreCase(string)) {
                        nonNegativeInt3 = Util.toNonNegativeInt(Integer.MAX_VALUE, string2);
                    } else if ("min-fresh".equalsIgnoreCase(string)) {
                        nonNegativeInt4 = Util.toNonNegativeInt(-1, string2);
                    } else if ("only-if-cached".equalsIgnoreCase(string)) {
                        z7 = true;
                    } else if ("no-transform".equalsIgnoreCase(string)) {
                        z8 = true;
                    } else if ("immutable".equalsIgnoreCase(string)) {
                        z9 = true;
                    }
                    i = length3;
                    zzzVar3 = zzzVar2;
                    headers4 = headers3;
                }
                i4++;
                zzzVar3 = zzzVar3;
                headers4 = headers4;
            }
            zzzVar = zzzVar3;
            cacheControl = new CacheControl(z2, z3, nonNegativeInt, nonNegativeInt2, z4, z5, z6, nonNegativeInt3, nonNegativeInt4, z7, z8, z9, !z ? null : str);
            request.lazyCacheControl = cacheControl;
        } else {
            zzzVar = zzzVar3;
        }
        zzz zzzVar4 = cacheControl.onlyIfCached ? new zzz((Object) null, (AutoCloseable) null, 11) : zzzVar;
        RealCall call = realInterceptorChain.call;
        boolean z10 = call instanceof RealCall;
        Request request2 = (Request) zzzVar4.zza;
        Response response = (Response) zzzVar4.zzb;
        if (request2 == null && response == null) {
            Response response2 = new Response(request, Protocol.HTTP_1_1, "Unsatisfiable Request (only-if-cached)", 504, null, new Headers.Builder().build(), Util.EMPTY_RESPONSE, null, null, null, -1L, System.currentTimeMillis(), null);
            Intrinsics.checkNotNullParameter(call, "call");
            return response2;
        }
        if (request2 == null) {
            Intrinsics.checkNotNull(response);
            Response.Builder builderNewBuilder = response.newBuilder();
            Response responseAccess$stripBody = Companion.access$stripBody(response);
            Response.Builder.checkSupportResponse("cacheResponse", responseAccess$stripBody);
            builderNewBuilder.cacheResponse = responseAccess$stripBody;
            Response responseBuild = builderNewBuilder.build();
            Intrinsics.checkNotNullParameter(call, "call");
            return responseBuild;
        }
        if (response != null) {
            Intrinsics.checkNotNullParameter(call, "call");
        }
        Response responseProceed = realInterceptorChain.proceed(request2);
        if (response != null) {
            if (responseProceed.code == 304) {
                Response.Builder builderNewBuilder2 = response.newBuilder();
                Headers.Builder builder = new Headers.Builder();
                Headers headers5 = response.headers;
                int size2 = headers5.size();
                int i8 = 0;
                while (true) {
                    headers = responseProceed.headers;
                    if (i8 >= size2) {
                        break;
                    }
                    String strName2 = headers5.name(i8);
                    String strValue2 = headers5.value(i8);
                    if ("Warning".equalsIgnoreCase(strName2)) {
                        headers2 = headers5;
                        if (!StringsKt__StringsKt.startsWith(strValue2, "1", false)) {
                        }
                        i8++;
                        headers5 = headers2;
                    } else {
                        headers2 = headers5;
                    }
                    if ("Content-Length".equalsIgnoreCase(strName2) || "Content-Encoding".equalsIgnoreCase(strName2) || "Content-Type".equalsIgnoreCase(strName2) || !Companion.isEndToEnd(strName2) || headers.get(strName2) == null) {
                        builder.addLenient$okhttp(strName2, strValue2);
                    }
                    i8++;
                    headers5 = headers2;
                }
                int size3 = headers.size();
                for (int i9 = 0; i9 < size3; i9++) {
                    String strName3 = headers.name(i9);
                    if (!"Content-Length".equalsIgnoreCase(strName3) && !"Content-Encoding".equalsIgnoreCase(strName3) && !"Content-Type".equalsIgnoreCase(strName3) && Companion.isEndToEnd(strName3)) {
                        builder.addLenient$okhttp(strName3, headers.value(i9));
                    }
                }
                builderNewBuilder2.headers = builder.build().newBuilder();
                builderNewBuilder2.sentRequestAtMillis = responseProceed.sentRequestAtMillis;
                builderNewBuilder2.receivedResponseAtMillis = responseProceed.receivedResponseAtMillis;
                Response responseAccess$stripBody2 = Companion.access$stripBody(response);
                Response.Builder.checkSupportResponse("cacheResponse", responseAccess$stripBody2);
                builderNewBuilder2.cacheResponse = responseAccess$stripBody2;
                Response responseAccess$stripBody3 = Companion.access$stripBody(responseProceed);
                Response.Builder.checkSupportResponse("networkResponse", responseAccess$stripBody3);
                builderNewBuilder2.networkResponse = responseAccess$stripBody3;
                builderNewBuilder2.build();
                RealResponseBody realResponseBody = responseProceed.body;
                Intrinsics.checkNotNull(realResponseBody);
                realResponseBody.close();
                Intrinsics.checkNotNull(null);
                throw null;
            }
            RealResponseBody realResponseBody2 = response.body;
            if (realResponseBody2 != null) {
                Util.closeQuietly(realResponseBody2);
            }
        }
        Response.Builder builderNewBuilder3 = responseProceed.newBuilder();
        Response responseAccess$stripBody4 = Companion.access$stripBody(response);
        Response.Builder.checkSupportResponse("cacheResponse", responseAccess$stripBody4);
        builderNewBuilder3.cacheResponse = responseAccess$stripBody4;
        Response responseAccess$stripBody5 = Companion.access$stripBody(responseProceed);
        Response.Builder.checkSupportResponse("networkResponse", responseAccess$stripBody5);
        builderNewBuilder3.networkResponse = responseAccess$stripBody5;
        return builderNewBuilder3.build();
    }
}
