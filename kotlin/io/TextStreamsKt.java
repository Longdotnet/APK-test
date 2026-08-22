package kotlin.io;

import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.util.Log;
import androidx.webkit.internal.ApiFeature;
import androidx.webkit.internal.ConditionallySupportedFeature;
import androidx.webkit.internal.WebViewFeatureInternal;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.UserDataStore$$ExternalSyntheticLambda0;
import com.facebook.internal.Utility;
import com.facebook.internal.WebDialog$UploadStagingResourcesTask$$ExternalSyntheticLambda0;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzah;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.net.IDN;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.Util;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.Okio;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TextStreamsKt {
    public static ClassLoader zza;
    public static Thread zzb;

    /* JADX WARN: Code duplicated, block: B:35:0x0062  */
    /* JADX WARN: Code duplicated, block: B:50:0x008e A[LOOP:2: B:25:0x004c->B:50:0x008e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:57:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b2 A[LOOP:1: B:56:0x00a5->B:60:0x00b2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:83:0x00b8 A[EDGE_INSN: B:83:0x00b8->B:61:0x00b8 BREAK  A[LOOP:1: B:56:0x00a5->B:60:0x00b2], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:0x00a2 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [int] */
    /* JADX WARN: Type inference failed for: r14v5 */
    public static final InetAddress decodeIpv6(int i, int i2, String str) {
        int i3;
        ?? r14;
        int i4;
        char cCharAt;
        int i5;
        int i6;
        int i7;
        int hexDigit;
        int i8 = 16;
        byte[] bArr = new byte[16];
        boolean z = false;
        int i9 = i;
        int i10 = 0;
        int i11 = -1;
        int i12 = -1;
        while (true) {
            if (i9 >= i2) {
                i3 = i8;
                break;
            }
            if (i10 == i8) {
                return null;
            }
            int i13 = i9 + 2;
            if (i13 <= i2 && StringsKt__StringsKt.startsWith(str, i9, "::", z)) {
                if (i11 != -1) {
                    return null;
                }
                i10 += 2;
                if (i13 == i2) {
                    i3 = i8;
                    i11 = i10;
                    break;
                }
                i11 = i10;
                i12 = i13;
                i9 = i12;
                i6 = 0;
                while (i9 < i2) {
                    hexDigit = Util.parseHexDigit(str.charAt(i9));
                    if (hexDigit == -1) {
                        break;
                        break;
                    }
                    i6 = (i6 << 4) + hexDigit;
                    i9++;
                }
                i7 = i9 - i12;
                if (i7 != 0) {
                }
                return null;
            }
            if (i10 != 0) {
                if (!StringsKt__StringsKt.startsWith(str, i9, ":", z)) {
                    if (StringsKt__StringsKt.startsWith(str, i9, ".", z)) {
                        int i14 = i10 - 2;
                        int i15 = i14;
                        while (i12 < i2) {
                            if (i15 != i8) {
                                if (i15 == i14) {
                                    r14 = z;
                                    i4 = i12;
                                    while (i4 < i2) {
                                        cCharAt = str.charAt(i4);
                                        if (Intrinsics.compare(cCharAt, 48) < 0 || Intrinsics.compare(cCharAt, 57) > 0) {
                                            break;
                                        }
                                        if ((r14 != 0 || i12 == i4) && (i5 = ((r14 * 10) + cCharAt) - 48) <= 255) {
                                            i4++;
                                            r14 = i5;
                                        }
                                    }
                                    if (i4 - i12 == 0) {
                                        bArr[i15] = (byte) r14;
                                        i15++;
                                        i12 = i4;
                                        i8 = 16;
                                        z = false;
                                    }
                                } else if (str.charAt(i12) == '.') {
                                    i12++;
                                    r14 = z;
                                    i4 = i12;
                                    while (i4 < i2) {
                                        cCharAt = str.charAt(i4);
                                        if (Intrinsics.compare(cCharAt, 48) < 0) {
                                            break;
                                        }
                                        break;
                                        break;
                                    }
                                    if (i4 - i12 == 0) {
                                        bArr[i15] = (byte) r14;
                                        i15++;
                                        i12 = i4;
                                        i8 = 16;
                                        z = false;
                                    }
                                }
                            }
                        }
                        if (i15 == i10 + 2) {
                            i10 += 2;
                            i3 = 16;
                            break;
                        }
                    }
                    return null;
                }
                i9++;
            }
            i12 = i9;
            i9 = i12;
            i6 = 0;
            while (i9 < i2) {
                hexDigit = Util.parseHexDigit(str.charAt(i9));
                if (hexDigit == -1) {
                    break;
                }
                i6 = (i6 << 4) + hexDigit;
                i9++;
            }
            i7 = i9 - i12;
            if (i7 != 0 || i7 > 4) {
                return null;
            }
            int i16 = i10 + 1;
            bArr[i10] = (byte) ((i6 >>> 8) & 255);
            i10 += 2;
            bArr[i16] = (byte) (i6 & 255);
            i8 = 16;
            z = false;
        }
        if (i10 != i3) {
            if (i11 == -1) {
                return null;
            }
            int i17 = i10 - i11;
            System.arraycopy(bArr, i11, bArr, 16 - i17, i17);
            Arrays.fill(bArr, i11, (16 - i10) + i11, (byte) 0);
        }
        return InetAddress.getByAddress(bArr);
    }

    public static SafeParcelable deserializeFromBytes(byte[] bArr, Parcelable.Creator creator) {
        zzah.checkNotNull(creator);
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArr, 0, bArr.length);
        parcelObtain.setDataPosition(0);
        SafeParcelable safeParcelable = (SafeParcelable) creator.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        return safeParcelable;
    }

    public static boolean isFeatureSupported(String str) {
        ApiFeature.M m = WebViewFeatureInternal.WEB_MESSAGE_ARRAY_BUFFER;
        Set<ConditionallySupportedFeature> setUnmodifiableSet = Collections.unmodifiableSet(ApiFeature.sValues);
        HashSet hashSet = new HashSet();
        for (ConditionallySupportedFeature conditionallySupportedFeature : setUnmodifiableSet) {
            if (((ApiFeature) conditionallySupportedFeature).mPublicFeatureValue.equals(str)) {
                hashSet.add(conditionallySupportedFeature);
            }
        }
        if (hashSet.isEmpty()) {
            throw new RuntimeException("Unknown feature ".concat(str));
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ApiFeature apiFeature = (ApiFeature) ((ConditionallySupportedFeature) it.next());
            if (apiFeature.isSupportedByFramework() || apiFeature.isSupportedByWebView()) {
                return true;
            }
        }
        return false;
    }

    public static final GraphRequest newUploadStagingResourceWithImageRequest(AccessToken accessToken, Uri uri, WebDialog$UploadStagingResourcesTask$$ExternalSyntheticLambda0 webDialog$UploadStagingResourcesTask$$ExternalSyntheticLambda0) {
        String path = uri.getPath();
        boolean zEqualsIgnoreCase = "file".equalsIgnoreCase(uri.getScheme());
        HttpMethod httpMethod = HttpMethod.POST;
        if (zEqualsIgnoreCase && path != null) {
            GraphRequest.ParcelableResourceWithMimeType parcelableResourceWithMimeType = new GraphRequest.ParcelableResourceWithMimeType(ParcelFileDescriptor.open(new File(path), 268435456));
            Bundle bundle = new Bundle(1);
            bundle.putParcelable("file", parcelableResourceWithMimeType);
            return new GraphRequest(accessToken, "me/staging_resources", bundle, httpMethod, webDialog$UploadStagingResourcesTask$$ExternalSyntheticLambda0);
        }
        if (!FirebaseAnalytics.Param.CONTENT.equalsIgnoreCase(uri.getScheme())) {
            throw new FacebookException("The image Uri must be either a file:// or content:// Uri");
        }
        GraphRequest.ParcelableResourceWithMimeType parcelableResourceWithMimeType2 = new GraphRequest.ParcelableResourceWithMimeType(uri);
        Bundle bundle2 = new Bundle(1);
        bundle2.putParcelable("file", parcelableResourceWithMimeType2);
        return new GraphRequest(accessToken, "me/staging_resources", bundle2, httpMethod, webDialog$UploadStagingResourcesTask$$ExternalSyntheticLambda0);
    }

    public static JsonElement parseReader(JsonReader jsonReader) {
        boolean z = jsonReader.lenient;
        jsonReader.lenient = true;
        try {
            try {
                try {
                    JsonElement jsonElement = Streams.parse(jsonReader);
                    jsonReader.lenient = z;
                    return jsonElement;
                } catch (OutOfMemoryError e) {
                    throw new JsonParseException("Failed parsing JSON source: " + jsonReader + " to Json", e);
                }
            } catch (StackOverflowError e2) {
                throw new JsonParseException("Failed parsing JSON source: " + jsonReader + " to Json", e2);
            }
        } catch (Throwable th) {
            jsonReader.lenient = z;
            throw th;
        }
    }

    public static final String readText(BufferedReader bufferedReader) throws IOException {
        StringWriter stringWriter = new StringWriter();
        char[] cArr = new char[8192];
        int i = bufferedReader.read(cArr);
        while (i >= 0) {
            stringWriter.write(cArr, 0, i);
            i = bufferedReader.read(cArr);
        }
        String string = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(string, "buffer.toString()");
        return string;
    }

    public static void setInternalUserData(HashMap map) {
        List listListOf;
        String[] strArr;
        int i = 0;
        UserDataStore userDataStore = UserDataStore.INSTANCE;
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return;
        }
        try {
            boolean z = UserDataStore.initialized.get();
            UserDataStore userDataStore2 = UserDataStore.INSTANCE;
            if (!z) {
                userDataStore2.initAndWait();
            }
            Iterator it = map.entrySet().iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                ConcurrentHashMap concurrentHashMap = UserDataStore.internalHashedUserData;
                if (!zHasNext) {
                    String strMapToJsonStr = Utility.mapToJsonStr(concurrentHashMap);
                    if (CrashShieldHandler.isObjectCrashing(userDataStore2)) {
                        return;
                    }
                    try {
                        FacebookSdk.getExecutor().execute(new UserDataStore$$ExternalSyntheticLambda0(strMapToJsonStr, i));
                        return;
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(userDataStore2, th);
                        return;
                    }
                }
                Map.Entry entry = (Map.Entry) it.next();
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                int length = str2.length() - 1;
                int i2 = 0;
                boolean z2 = false;
                while (i2 <= length) {
                    boolean z3 = Intrinsics.compare(str2.charAt(!z2 ? i2 : length), 32) <= 0;
                    if (z2) {
                        if (!z3) {
                            break;
                        } else {
                            length--;
                        }
                    } else if (z3) {
                        i2++;
                    } else {
                        z2 = true;
                    }
                }
                String strSha256hash = Utility.sha256hash(userDataStore2.normalizeData(str, str2.subSequence(i2, length + 1).toString()));
                if (concurrentHashMap.containsKey(str)) {
                    String str3 = (String) concurrentHashMap.get(str);
                    if (str3 == null) {
                        strArr = null;
                    } else {
                        Pattern patternCompile = Pattern.compile(",");
                        Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(pattern)");
                        StringsKt__StringsKt.requireNonNegativeLimit(0);
                        Matcher matcher = patternCompile.matcher(str3);
                        if (matcher.find()) {
                            ArrayList arrayList = new ArrayList(10);
                            int iEnd = 0;
                            do {
                                arrayList.add(str3.subSequence(iEnd, matcher.start()).toString());
                                iEnd = matcher.end();
                            } while (matcher.find());
                            arrayList.add(str3.subSequence(iEnd, str3.length()).toString());
                            listListOf = arrayList;
                        } else {
                            listListOf = Okio.listOf(str3.toString());
                        }
                        Object[] array = listListOf.toArray(new String[0]);
                        if (array == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                        strArr = (String[]) array;
                    }
                    if (strArr == null) {
                        strArr = new String[0];
                    }
                    Object[] elements = Arrays.copyOf(strArr, strArr.length);
                    Intrinsics.checkNotNullParameter(elements, "elements");
                    LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsKt.mapCapacity(elements.length));
                    ArraysKt.toCollection(elements, linkedHashSet);
                    if (linkedHashSet.contains(strSha256hash)) {
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    if (strArr.length == 0) {
                        sb.append(strSha256hash);
                    } else if (strArr.length < 5) {
                        sb.append(str3);
                        sb.append(",");
                        sb.append(strSha256hash);
                    } else {
                        int i3 = 1;
                        while (true) {
                            int i4 = i3 + 1;
                            sb.append(strArr[i3]);
                            sb.append(",");
                            if (i4 >= 5) {
                                break;
                            } else {
                                i3 = i4;
                            }
                        }
                        sb.append(strSha256hash);
                        linkedHashSet.remove(strArr[0]);
                    }
                    concurrentHashMap.put(str, sb.toString());
                } else {
                    concurrentHashMap.put(str, strSha256hash);
                }
            }
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(UserDataStore.class, th2);
        }
    }

    public static final String toCanonicalHost(String toCanonicalHost) {
        Intrinsics.checkNotNullParameter(toCanonicalHost, "$this$toCanonicalHost");
        int i = 0;
        int i2 = -1;
        if (!StringsKt__StringsKt.contains$default(toCanonicalHost, ":")) {
            try {
                String ascii = IDN.toASCII(toCanonicalHost);
                Intrinsics.checkNotNullExpressionValue(ascii, "IDN.toASCII(host)");
                Locale locale = Locale.US;
                Intrinsics.checkNotNullExpressionValue(locale, "Locale.US");
                String lowerCase = ascii.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                if (lowerCase.length() == 0) {
                    return null;
                }
                int length = lowerCase.length();
                for (int i3 = 0; i3 < length; i3++) {
                    char cCharAt = lowerCase.charAt(i3);
                    if (Intrinsics.compare(cCharAt, 31) <= 0 || Intrinsics.compare(cCharAt, 127) >= 0 || StringsKt__StringsKt.indexOf$default((CharSequence) " #%/:?@[\\]", cCharAt, 0, false, 6) != -1) {
                        return null;
                    }
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        InetAddress inetAddressDecodeIpv6 = (StringsKt__StringsKt.startsWith(toCanonicalHost, "[", false) && toCanonicalHost.endsWith("]")) ? decodeIpv6(1, toCanonicalHost.length() - 1, toCanonicalHost) : decodeIpv6(0, toCanonicalHost.length(), toCanonicalHost);
        if (inetAddressDecodeIpv6 == null) {
            return null;
        }
        byte[] address = inetAddressDecodeIpv6.getAddress();
        if (address.length != 16) {
            if (address.length == 4) {
                return inetAddressDecodeIpv6.getHostAddress();
            }
            throw new AssertionError("Invalid IPv6 address: '" + toCanonicalHost + '\'');
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < address.length) {
            int i6 = i4;
            while (i6 < 16 && address[i6] == 0 && address[i6 + 1] == 0) {
                i6 += 2;
            }
            int i7 = i6 - i4;
            if (i7 > i5 && i7 >= 4) {
                i2 = i4;
                i5 = i7;
            }
            i4 = i6 + 2;
        }
        Buffer buffer = new Buffer();
        while (i < address.length) {
            if (i == i2) {
                buffer.writeByte(58);
                i += i5;
                if (i == 16) {
                    buffer.writeByte(58);
                }
            } else {
                if (i > 0) {
                    buffer.writeByte(58);
                }
                byte b = address[i];
                byte[] bArr = Util.EMPTY_BYTE_ARRAY;
                buffer.writeHexadecimalUnsignedLong(((b & 255) << 8) | (address[i + 1] & 255));
                i += 2;
            }
        }
        return buffer.readString(buffer.size, Charsets.UTF_8);
    }

    /* JADX WARN: Code duplicated, block: B:53:0x00ab A[Catch: all -> 0x00a7, PHI: r1
  0x00ab: PHI (r1v4 java.lang.Thread) = (r1v3 java.lang.Thread), (r1v15 java.lang.Thread) binds: [B:7:0x000a, B:47:0x00a4] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #4 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000c, B:46:0x00a2, B:61:0x00d1, B:12:0x001f, B:52:0x00aa, B:53:0x00ab, B:64:0x00d5, B:65:0x00d6, B:54:0x00ac, B:60:0x00d0, B:59:0x00b6, B:13:0x0020, B:15:0x002d, B:25:0x0047, B:26:0x004e, B:28:0x0059, B:34:0x006e, B:35:0x0075, B:43:0x0086, B:44:0x00a0, B:18:0x003c), top: B:77:0x0003, inners: #2, #6 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x00ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static synchronized ClassLoader zza() {
        SecurityException e;
        Thread thread;
        ThreadGroup threadGroup;
        if (zza == null) {
            Thread thread2 = zzb;
            ClassLoader contextClassLoader = null;
            if (thread2 != null) {
                synchronized (thread2) {
                    try {
                        contextClassLoader = zzb.getContextClassLoader();
                    } catch (SecurityException e2) {
                        Log.w("DynamiteLoaderV2CL", "Failed to get thread context classloader " + e2.getMessage());
                    }
                }
                zza = contextClassLoader;
            } else {
                ThreadGroup threadGroup2 = Looper.getMainLooper().getThread().getThreadGroup();
                if (threadGroup2 == null) {
                    thread2 = null;
                } else {
                    synchronized (Void.class) {
                        try {
                            try {
                                int iActiveGroupCount = threadGroup2.activeGroupCount();
                                ThreadGroup[] threadGroupArr = new ThreadGroup[iActiveGroupCount];
                                threadGroup2.enumerate(threadGroupArr);
                                int i = 0;
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= iActiveGroupCount) {
                                        threadGroup = null;
                                        break;
                                    }
                                    threadGroup = threadGroupArr[i2];
                                    if ("dynamiteLoader".equals(threadGroup.getName())) {
                                        break;
                                    }
                                    i2++;
                                }
                                if (threadGroup == null) {
                                    threadGroup = new ThreadGroup(threadGroup2, "dynamiteLoader");
                                }
                                int iActiveCount = threadGroup.activeCount();
                                Thread[] threadArr = new Thread[iActiveCount];
                                threadGroup.enumerate(threadArr);
                                while (true) {
                                    if (i >= iActiveCount) {
                                        thread = null;
                                        break;
                                    }
                                    thread = threadArr[i];
                                    if ("GmsDynamite".equals(thread.getName())) {
                                        break;
                                    }
                                    i++;
                                }
                                if (thread == null) {
                                    try {
                                        AsyncTimeout.Watchdog watchdog = new AsyncTimeout.Watchdog(threadGroup, "GmsDynamite");
                                        try {
                                            watchdog.setContextClassLoader(null);
                                            watchdog.start();
                                            thread = watchdog;
                                        } catch (SecurityException e3) {
                                            e = e3;
                                            thread = watchdog;
                                            Log.w("DynamiteLoaderV2CL", "Failed to enumerate thread/threadgroup " + e.getMessage());
                                        }
                                    } catch (SecurityException e4) {
                                        e = e4;
                                    }
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        } catch (SecurityException e5) {
                            e = e5;
                            thread = null;
                        }
                    }
                    thread2 = thread;
                }
                zzb = thread2;
                if (thread2 != null) {
                    synchronized (thread2) {
                        contextClassLoader = zzb.getContextClassLoader();
                    }
                }
                zza = contextClassLoader;
            }
        }
        return zza;
    }
}
