package okhttp3.internal;

import androidx.emoji2.text.flatbuffer.bs.bUqMCsuPSX;
import androidx.loader.app.gv.DYYbQc;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.common.util.concurrent.dN.MnHfHMYQDPUO;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.ExceptionsKt;
import kotlin.collections.ArrayAsCollection;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http2.Header;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;
import okio.RealBufferedSource;
import okio.Source;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Util {
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final Headers EMPTY_HEADERS = Headers.Companion.of(new String[0]);
    public static final RealResponseBody EMPTY_RESPONSE;
    public static final Options UNICODE_BOMS;
    public static final TimeZone UTC;
    public static final Regex VERIFY_AS_IP_ADDRESS;
    public static final String okHttpName;

    static {
        int i;
        int iCompareTo;
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        Buffer buffer = new Buffer();
        buffer.write(bArr, 0, 0);
        EMPTY_RESPONSE = new RealResponseBody(buffer, (MediaType) null, 0);
        HttpUrl.Companion.create$default(bArr, null, 7);
        ByteString byteString = ByteString.EMPTY;
        ByteString[] byteStringArr = {JSONObject.Null.decodeHex("efbbbf"), JSONObject.Null.decodeHex("feff"), JSONObject.Null.decodeHex("fffe"), JSONObject.Null.decodeHex("0000ffff"), JSONObject.Null.decodeHex("ffff0000")};
        ArrayList arrayList = new ArrayList(new ArrayAsCollection(byteStringArr, false));
        if (arrayList.size() > 1) {
            Collections.sort(arrayList);
        }
        ArrayList arrayList2 = new ArrayList(5);
        for (int i2 = 0; i2 < 5; i2++) {
            ByteString byteString2 = byteStringArr[i2];
            arrayList2.add(-1);
        }
        Object[] array = arrayList2.toArray(new Integer[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        Integer[] numArr = (Integer[]) array;
        Integer[] elements = (Integer[]) Arrays.copyOf(numArr, numArr.length);
        Intrinsics.checkNotNullParameter(elements, "elements");
        ArrayList arrayList3 = elements.length == 0 ? new ArrayList() : new ArrayList(new ArrayAsCollection(elements, true));
        int i3 = 0;
        int i4 = 0;
        while (i3 < 5) {
            ByteString byteString3 = byteStringArr[i3];
            int i5 = i4 + 1;
            int size = arrayList.size();
            int size2 = arrayList.size();
            if (size < 0) {
                throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(size, "fromIndex (0) is greater than toIndex (", ")."));
            }
            if (size > size2) {
                throw new IndexOutOfBoundsException("toIndex (" + size + ") is greater than size (" + size2 + ").");
            }
            int i6 = size - 1;
            int i7 = 0;
            while (true) {
                if (i7 > i6) {
                    i = -(i7 + 1);
                    break;
                }
                i = (i7 + i6) >>> 1;
                Comparable comparable = (Comparable) arrayList.get(i);
                if (comparable == byteString3) {
                    iCompareTo = 0;
                } else if (comparable == null) {
                    iCompareTo = -1;
                } else {
                    iCompareTo = byteString3 == null ? 1 : comparable.compareTo(byteString3);
                }
                if (iCompareTo < 0) {
                    i7 = i + 1;
                } else if (iCompareTo <= 0) {
                    break;
                } else {
                    i6 = i - 1;
                }
            }
            arrayList3.set(i, Integer.valueOf(i4));
            i3++;
            i4 = i5;
        }
        if (((ByteString) arrayList.get(0)).getSize$okio() <= 0) {
            throw new IllegalArgumentException("the empty byte string is not a supported option");
        }
        int i8 = 0;
        while (i8 < arrayList.size()) {
            ByteString prefix = (ByteString) arrayList.get(i8);
            int i9 = i8 + 1;
            int i10 = i9;
            while (i10 < arrayList.size()) {
                ByteString byteString4 = (ByteString) arrayList.get(i10);
                byteString4.getClass();
                Intrinsics.checkNotNullParameter(prefix, "prefix");
                if (!byteString4.rangeEquals(prefix, prefix.getSize$okio())) {
                    break;
                }
                if (byteString4.getSize$okio() == prefix.getSize$okio()) {
                    throw new IllegalArgumentException(("duplicate option: " + byteString4).toString());
                }
                if (((Number) arrayList3.get(i10)).intValue() > ((Number) arrayList3.get(i8)).intValue()) {
                    arrayList.remove(i10);
                    arrayList3.remove(i10);
                } else {
                    i10++;
                }
            }
            i8 = i9;
        }
        Buffer buffer2 = new Buffer();
        MapsKt__MapsKt.buildTrieRecursive(0L, buffer2, 0, arrayList, 0, arrayList.size(), arrayList3);
        int[] iArr = new int[(int) (buffer2.size / ((long) 4))];
        int i11 = 0;
        while (!buffer2.exhausted()) {
            iArr[i11] = buffer2.readInt();
            i11++;
        }
        Object[] objArrCopyOf = Arrays.copyOf(byteStringArr, 5);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        UNICODE_BOMS = new Options((ByteString[]) objArrCopyOf, iArr);
        TimeZone timeZone = TimeZone.getTimeZone(bUqMCsuPSX.FXARhWXmCC);
        Intrinsics.checkNotNull(timeZone);
        UTC = timeZone;
        VERIFY_AS_IP_ADDRESS = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        String strRemovePrefix = StringsKt__StringsKt.removePrefix(OkHttpClient.class.getName(), "okhttp3.");
        if (strRemovePrefix.endsWith("Client")) {
            strRemovePrefix = strRemovePrefix.substring(0, strRemovePrefix.length() - 6);
            Intrinsics.checkNotNullExpressionValue(strRemovePrefix, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        okHttpName = strRemovePrefix;
    }

    public static final boolean canReuseConnectionFor(HttpUrl canReuseConnectionFor, HttpUrl other) {
        Intrinsics.checkNotNullParameter(canReuseConnectionFor, "$this$canReuseConnectionFor");
        Intrinsics.checkNotNullParameter(other, "other");
        return Intrinsics.areEqual(canReuseConnectionFor.host, other.host) && canReuseConnectionFor.port == other.port && Intrinsics.areEqual(canReuseConnectionFor.scheme, other.scheme);
    }

    public static final void closeQuietly(Closeable closeable) {
        Intrinsics.checkNotNullParameter(closeable, DYYbQc.nyIcGr);
        try {
            closeable.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    public static final int delimiterOffset(int i, int i2, String str, String str2) {
        while (i < i2) {
            if (StringsKt__StringsKt.contains$default(str2, str.charAt(i))) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static final boolean discard(Source source, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        try {
            return skipAll(source, 100, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static final String format(String format, Object... objArr) {
        Intrinsics.checkNotNullParameter(format, "format");
        Locale locale = Locale.US;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        return String.format(locale, format, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
    }

    public static final boolean hasIntersection(String[] hasIntersection, String[] strArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(hasIntersection, "$this$hasIntersection");
        if (hasIntersection.length != 0 && strArr != null && strArr.length != 0) {
            for (String str : hasIntersection) {
                for (String str2 : strArr) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final long headersContentLength(Response response) {
        String str = response.headers.get("Content-Length");
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static final List immutableListOf(Object... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object[] objArr = (Object[]) elements.clone();
        List listUnmodifiableList = Collections.unmodifiableList(CollectionsKt__CollectionsKt.listOf(Arrays.copyOf(objArr, objArr.length)));
        Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "Collections.unmodifiable…istOf(*elements.clone()))");
        return listUnmodifiableList;
    }

    public static final int indexOfControlOrNonAscii(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (Intrinsics.compare(cCharAt, 31) <= 0 || Intrinsics.compare(cCharAt, 127) >= 0) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOfFirstNonAsciiWhitespace(int i, int i2, String str) {
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static final int indexOfLastNonAsciiWhitespace(int i, int i2, String str) {
        int i3 = i2 - 1;
        if (i3 >= i) {
            while (true) {
                char cCharAt = str.charAt(i3);
                if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                    return i3 + 1;
                }
                if (i3 == i) {
                    break;
                }
                i3--;
            }
        }
        return i;
    }

    public static final String[] intersect(String[] strArr, String[] other, Comparator comparator) {
        Intrinsics.checkNotNullParameter(other, "other");
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            for (String str2 : other) {
                if (comparator.compare(str, str2) == 0) {
                    arrayList.add(str);
                    break;
                }
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public static final int parseHexDigit(char c) {
        if ('0' <= c && '9' >= c) {
            return c - '0';
        }
        if ('a' <= c && 'f' >= c) {
            return c - 'W';
        }
        if ('A' <= c && 'F' >= c) {
            return c - '7';
        }
        return -1;
    }

    public static final Charset readBomAsCharset(BufferedSource readBomAsCharset, Charset charset) {
        Charset charsetForName;
        Intrinsics.checkNotNullParameter(readBomAsCharset, "$this$readBomAsCharset");
        Intrinsics.checkNotNullParameter(charset, "default");
        int iSelect = readBomAsCharset.select(UNICODE_BOMS);
        if (iSelect == -1) {
            return charset;
        }
        if (iSelect == 0) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            return UTF_8;
        }
        if (iSelect == 1) {
            Charset UTF_16BE = StandardCharsets.UTF_16BE;
            Intrinsics.checkNotNullExpressionValue(UTF_16BE, "UTF_16BE");
            return UTF_16BE;
        }
        if (iSelect == 2) {
            Charset UTF_16LE = StandardCharsets.UTF_16LE;
            Intrinsics.checkNotNullExpressionValue(UTF_16LE, "UTF_16LE");
            return UTF_16LE;
        }
        if (iSelect == 3) {
            Charset charset2 = Charsets.UTF_8;
            charsetForName = Charsets.utf_32be;
            if (charsetForName == null) {
                charsetForName = Charset.forName("UTF-32BE");
                Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(\"UTF-32BE\")");
                Charsets.utf_32be = charsetForName;
            }
        } else {
            if (iSelect != 4) {
                throw new AssertionError();
            }
            Charset charset3 = Charsets.UTF_8;
            charsetForName = Charsets.utf_32le;
            if (charsetForName == null) {
                charsetForName = Charset.forName("UTF-32LE");
                Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(\"UTF-32LE\")");
                Charsets.utf_32le = charsetForName;
            }
        }
        return charsetForName;
    }

    public static final int readMedium(RealBufferedSource readMedium) {
        Intrinsics.checkNotNullParameter(readMedium, "$this$readMedium");
        return (readMedium.readByte() & 255) | ((readMedium.readByte() & 255) << 16) | ((readMedium.readByte() & 255) << 8);
    }

    public static final Headers toHeaders(List list) {
        ArrayList arrayList = new ArrayList(20);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Header header = (Header) it.next();
            String strUtf8 = header.name.utf8();
            String strUtf9 = header.value.utf8();
            arrayList.add(strUtf8);
            arrayList.add(StringsKt__StringsKt.trim(strUtf9).toString());
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return new Headers((String[]) array);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0052  */
    public static final String toHostHeader(HttpUrl toHostHeader, boolean z) {
        int i;
        Intrinsics.checkNotNullParameter(toHostHeader, "$this$toHostHeader");
        String str = toHostHeader.host;
        if (StringsKt__StringsKt.contains$default(str, ":")) {
            str = "[" + str + ']';
        }
        int i2 = toHostHeader.port;
        if (!z) {
            String scheme = toHostHeader.scheme;
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            int iHashCode = scheme.hashCode();
            if (iHashCode != 3213448) {
                if (iHashCode == 99617003 && scheme.equals("https")) {
                    i = 443;
                } else {
                    i = -1;
                }
            } else if (scheme.equals("http")) {
                i = 80;
            } else {
                i = -1;
            }
            if (i2 == i) {
                return str;
            }
        }
        return str + ':' + i2;
    }

    public static final List toImmutableList(List toImmutableList) {
        Intrinsics.checkNotNullParameter(toImmutableList, "$this$toImmutableList");
        List listUnmodifiableList = Collections.unmodifiableList(CollectionsKt.toMutableList(toImmutableList));
        Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "Collections.unmodifiableList(toMutableList())");
        return listUnmodifiableList;
    }

    public static final int toNonNegativeInt(int i, String str) {
        if (str != null) {
            try {
                long j = Long.parseLong(str);
                if (j > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (j < 0) {
                    return 0;
                }
                return (int) j;
            } catch (NumberFormatException unused) {
            }
        }
        return i;
    }

    public static final String trimSubstring(int i, int i2, String str) {
        int iIndexOfFirstNonAsciiWhitespace = indexOfFirstNonAsciiWhitespace(i, i2, str);
        String strSubstring = str.substring(iIndexOfFirstNonAsciiWhitespace, indexOfLastNonAsciiWhitespace(iIndexOfFirstNonAsciiWhitespace, i2, str));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final void withSuppressed(IOException withSuppressed, List list) {
        Intrinsics.checkNotNullParameter(withSuppressed, "$this$withSuppressed");
        if (list.size() > 1) {
            System.out.println(list);
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ExceptionsKt.addSuppressed(withSuppressed, (Exception) it.next());
        }
    }

    public static final int delimiterOffset(String str, char c, int i, int i2) {
        while (i < i2) {
            if (str.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static final boolean skipAll(Source source, int i, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(timeUnit, MnHfHMYQDPUO.OdsCVHIW);
        long jNanoTime = System.nanoTime();
        long jDeadlineNanoTime = source.timeout().hasDeadline() ? source.timeout().deadlineNanoTime() - jNanoTime : Long.MAX_VALUE;
        source.timeout().deadlineNanoTime(Math.min(jDeadlineNanoTime, timeUnit.toNanos(i)) + jNanoTime);
        try {
            Buffer buffer = new Buffer();
            while (source.read(buffer, 8192L) != -1) {
                buffer.skip(buffer.size);
            }
            if (jDeadlineNanoTime == Long.MAX_VALUE) {
                source.timeout().clearDeadline();
            } else {
                source.timeout().deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (jDeadlineNanoTime == Long.MAX_VALUE) {
                source.timeout().clearDeadline();
            } else {
                source.timeout().deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
            }
            return false;
        } catch (Throwable th) {
            if (jDeadlineNanoTime == Long.MAX_VALUE) {
                source.timeout().clearDeadline();
            } else {
                source.timeout().deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
            }
            throw th;
        }
    }

    public static final void closeQuietly(Socket closeQuietly) {
        Intrinsics.checkNotNullParameter(closeQuietly, "$this$closeQuietly");
        try {
            closeQuietly.close();
        } catch (AssertionError e) {
            throw e;
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }
}
