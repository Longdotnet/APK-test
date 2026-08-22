package okhttp3.internal.http;

import androidx.emoji2.text.flatbuffer.bs.bUqMCsuPSX;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.collections.EmptyList;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okio.ByteString;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class HttpHeaders {
    static {
        ByteString byteString = ByteString.EMPTY;
        JSONObject.Null.encodeUtf8("\"\\");
        JSONObject.Null.encodeUtf8("\t ,=");
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0094 A[EDGE_INSN: B:27:0x0094->B:125:0x023a BREAK  A[LOOP:2: B:32:0x00bd->B:80:0x0181]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r25v3 */
    /* JADX WARN: Type inference failed for: r26v2 */
    public static final void receiveHeaders(HttpUrl.Companion receiveHeaders, HttpUrl url, Headers headers) {
        List list;
        Cookie cookie;
        String str;
        int i = 1;
        Intrinsics.checkNotNullParameter(receiveHeaders, "$this$receiveHeaders");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        if (receiveHeaders == HttpUrl.Companion.NO_COOKIES) {
            return;
        }
        Pattern pattern = Cookie.YEAR_PATTERN;
        int size = headers.size();
        int i2 = 0;
        ArrayList arrayList = null;
        for (int i3 = 0; i3 < size; i3++) {
            if ("Set-Cookie".equalsIgnoreCase(headers.name(i3))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(headers.value(i3));
            }
        }
        List listUnmodifiableList = EmptyList.INSTANCE;
        if (arrayList != null) {
            List listUnmodifiableList2 = Collections.unmodifiableList(arrayList);
            Intrinsics.checkNotNullExpressionValue(listUnmodifiableList2, "Collections.unmodifiableList(result)");
            list = listUnmodifiableList2;
        } else {
            list = listUnmodifiableList;
        }
        int size2 = list.size();
        ArrayList arrayList2 = null;
        for (int i4 = 0; i4 < size2; i4++) {
            String setCookie = (String) list.get(i4);
            Intrinsics.checkNotNullParameter(setCookie, "setCookie");
            long jCurrentTimeMillis = System.currentTimeMillis();
            byte[] bArr = Util.EMPTY_BYTE_ARRAY;
            char c = ';';
            int iDelimiterOffset = Util.delimiterOffset(setCookie, ';', i2, setCookie.length());
            char c2 = '=';
            int iDelimiterOffset2 = Util.delimiterOffset(setCookie, '=', i2, iDelimiterOffset);
            if (iDelimiterOffset2 == iDelimiterOffset) {
                cookie = null;
                break;
            }
            String strTrimSubstring = Util.trimSubstring(i2, iDelimiterOffset2, setCookie);
            if (strTrimSubstring.length() == 0 || Util.indexOfControlOrNonAscii(strTrimSubstring) != -1) {
                cookie = null;
                i2 = 0;
                break;
            }
            String strTrimSubstring2 = Util.trimSubstring(iDelimiterOffset2 + i, iDelimiterOffset, setCookie);
            if (Util.indexOfControlOrNonAscii(strTrimSubstring2) != -1) {
                cookie = null;
                i2 = 0;
                break;
            }
            int i5 = iDelimiterOffset + i;
            int length = setCookie.length();
            long j = 253402300799999L;
            boolean z = i;
            long expires = 253402300799999L;
            String str2 = null;
            long j2 = -1;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = 0;
            String str3 = null;
            while (true) {
                if (i5 >= length) {
                    if (j2 == Long.MIN_VALUE) {
                        j = Long.MIN_VALUE;
                    } else if (j2 != -1) {
                        long j3 = jCurrentTimeMillis + (j2 <= 9223372036854775L ? j2 * ((long) 1000) : Long.MAX_VALUE);
                        if (j3 >= jCurrentTimeMillis && j3 <= 253402300799999L) {
                            j = j3;
                        }
                    } else {
                        j = expires;
                    }
                    String str4 = url.host;
                    if (str2 == null) {
                        str2 = str4;
                    } else if (!Intrinsics.areEqual(str4, str2)) {
                        Intrinsics.checkNotNullParameter(str4, "<this>");
                        if (str4.endsWith(str2) && str4.charAt((str4.length() - str2.length()) - 1) == '.') {
                            Regex regex = Util.VERIFY_AS_IP_ADDRESS;
                            regex.getClass();
                            if (!regex.nativePattern.matcher(str4).matches()) {
                            }
                        }
                        i2 = 0;
                        cookie = null;
                        break;
                    }
                    if (str4.length() != str2.length() && PublicSuffixDatabase.instance.getEffectiveTldPlusOne(str2) == null) {
                        cookie = null;
                        i2 = 0;
                        break;
                    }
                    String strSubstring = "/";
                    String str5 = str3;
                    i2 = 0;
                    if (str5 == null || !StringsKt__StringsKt.startsWith(str5, "/", false)) {
                        String strEncodedPath = url.encodedPath();
                        int iLastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default(strEncodedPath, '/', 0, 6);
                        if (iLastIndexOf$default != 0) {
                            strSubstring = strEncodedPath.substring(0, iLastIndexOf$default);
                            Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        }
                        str = strSubstring;
                    } else {
                        str = str5;
                    }
                    cookie = new Cookie(strTrimSubstring, strTrimSubstring2, j, str2, str, z2, z3, z4, z);
                    break;
                }
                int iDelimiterOffset3 = Util.delimiterOffset(setCookie, c, i5, length);
                int iDelimiterOffset4 = Util.delimiterOffset(setCookie, c2, i5, iDelimiterOffset3);
                String strTrimSubstring3 = Util.trimSubstring(i5, iDelimiterOffset4, setCookie);
                String strTrimSubstring4 = iDelimiterOffset4 < iDelimiterOffset3 ? Util.trimSubstring(iDelimiterOffset4 + i, iDelimiterOffset3, setCookie) : "";
                if (strTrimSubstring3.equalsIgnoreCase("expires")) {
                    try {
                        expires = MapsKt__MapsKt.parseExpires(strTrimSubstring4.length(), strTrimSubstring4);
                        z4 = i;
                    } catch (NumberFormatException | IllegalArgumentException unused) {
                        i = 1;
                    }
                } else if (strTrimSubstring3.equalsIgnoreCase("max-age")) {
                    try {
                        long j4 = Long.parseLong(strTrimSubstring4);
                        j2 = j4 > 0 ? j4 : Long.MIN_VALUE;
                    } catch (NumberFormatException e) {
                        Pattern patternCompile = Pattern.compile("-?\\d+");
                        Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(pattern)");
                        if (!patternCompile.matcher(strTrimSubstring4).matches()) {
                            throw e;
                        }
                        j2 = StringsKt__StringsKt.startsWith(strTrimSubstring4, "-", false) ? Long.MIN_VALUE : Long.MAX_VALUE;
                    }
                    i = 1;
                    z4 = 1;
                } else if (!strTrimSubstring3.equalsIgnoreCase("domain")) {
                    if (strTrimSubstring3.equalsIgnoreCase("path")) {
                        str3 = strTrimSubstring4;
                    } else if (strTrimSubstring3.equalsIgnoreCase("secure")) {
                        i = 1;
                        z2 = true;
                    } else if (strTrimSubstring3.equalsIgnoreCase("httponly")) {
                        i = 1;
                        z3 = true;
                    }
                    i = 1;
                } else {
                    if (strTrimSubstring4.endsWith(".")) {
                        throw new IllegalArgumentException("Failed requirement.");
                    }
                    String canonicalHost = TextStreamsKt.toCanonicalHost(StringsKt__StringsKt.removePrefix(strTrimSubstring4, "."));
                    if (canonicalHost == null) {
                        throw new IllegalArgumentException();
                    }
                    str2 = canonicalHost;
                    i = 1;
                    z = 0;
                }
                i5 = iDelimiterOffset3 + 1;
                c = ';';
                c2 = '=';
                z4 = z4;
                z = z;
            }
            if (cookie != null) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList2.add(cookie);
            }
            i = 1;
        }
        if (arrayList2 != null) {
            listUnmodifiableList = Collections.unmodifiableList(arrayList2);
            Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "Collections.unmodifiableList(cookies)");
        }
        listUnmodifiableList.isEmpty();
    }

    public static final boolean promisesBody(Response response) {
        if (Intrinsics.areEqual((String) response.request.method, "HEAD")) {
            return false;
        }
        int i = response.code;
        if (((i >= 100 && i < 200) || i == 204 || i == 304) && Util.headersContentLength(response) == -1) {
            if (!bUqMCsuPSX.Emhr.equalsIgnoreCase(Response.header$default("Transfer-Encoding", response))) {
                return false;
            }
        }
        return true;
    }
}
