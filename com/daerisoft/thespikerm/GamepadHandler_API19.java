package com.daerisoft.thespikerm;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.util.Log;
import android.util.LongSparseArray;
import androidx.multidex.ZipUtil$CentralDirectory;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.InstrumentData;
import com.google.android.gms.ads.internal.util.client.zzl;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.ads.internal.util.zzc;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzbfa;
import com.google.android.gms.internal.ads.zzcai;
import com.google.common.math.IntMath$1;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.math.RoundingMode;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.zip.ZipException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import kotlin.collections.ArraysKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.CipherSuite;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.TlsVersion;
import okhttp3.internal.Util;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class GamepadHandler_API19 {
    public static Field sDrawableCacheField;
    public static boolean sDrawableCacheFieldFetched;
    public static Field sResourcesImplField;
    public static boolean sResourcesImplFieldFetched;
    public static Class sThemedResourceCacheClazz;
    public static boolean sThemedResourceCacheClazzFetched;
    public static Field sThemedResourceCache_mUnthemedEntriesField;
    public static boolean sThemedResourceCache_mUnthemedEntriesFieldFetched;
    public ArrayList m_Gamepads;

    public static final InstrumentData build(Throwable th, InstrumentData.Type type) {
        String str;
        String string;
        String str2;
        InstrumentData instrumentData = new InstrumentData();
        instrumentData.type = type;
        Context applicationContext = FacebookSdk.getApplicationContext();
        String string2 = null;
        Throwable th2 = null;
        try {
            PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0);
            str = packageInfo == null ? null : packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException unused) {
        }
        instrumentData.appVersion = str;
        if (th == null) {
            string = null;
        } else {
            string = th.getCause() == null ? th.toString() : String.valueOf(th.getCause());
        }
        instrumentData.cause = string;
        if (th != null) {
            JSONArray jSONArray = new JSONArray();
            while (th != null && th != th2) {
                StackTraceElement[] stackTrace = th.getStackTrace();
                Intrinsics.checkNotNullExpressionValue(stackTrace, "t.stackTrace");
                int length = stackTrace.length;
                int i = 0;
                while (i < length) {
                    StackTraceElement stackTraceElement = stackTrace[i];
                    i++;
                    jSONArray.put(stackTraceElement.toString());
                }
                th2 = th;
                th = th.getCause();
            }
            string2 = jSONArray.toString();
        }
        instrumentData.stackTrace = string2;
        Long lValueOf = Long.valueOf(System.currentTimeMillis() / ((long) 1000));
        instrumentData.timestamp = lValueOf;
        StringBuffer stringBuffer = new StringBuffer();
        int iOrdinal = type.ordinal();
        if (iOrdinal == 1) {
            str2 = "analysis_log_";
        } else if (iOrdinal == 2) {
            str2 = "anr_log_";
        } else if (iOrdinal == 3) {
            str2 = "crash_log_";
        } else if (iOrdinal != 4) {
            str2 = iOrdinal != 5 ? "Unknown" : "thread_check_log_";
        } else {
            str2 = "shield_log_";
        }
        stringBuffer.append(str2);
        stringBuffer.append(String.valueOf(lValueOf));
        stringBuffer.append(".json");
        String string3 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(string3, "StringBuffer().append(t.logPrefix).append(timestamp.toString()).append(\".json\").toString()");
        instrumentData.filename = string3;
        return instrumentData;
    }

    public static void checkNotNull(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static int checkedSubtract(int i, int i2) {
        long j = ((long) i) - ((long) i2);
        int i3 = (int) j;
        MediaType.Companion.checkNoOverflow(j == ((long) i3), "checkedSubtract", i, i2);
        return i3;
    }

    public static int divide(int i, int i2, RoundingMode roundingMode) {
        roundingMode.getClass();
        if (i2 == 0) {
            throw new ArithmeticException("/ by zero");
        }
        int i3 = i / i2;
        int i4 = i - (i2 * i3);
        if (i4 == 0) {
            return i3;
        }
        int i5 = ((i ^ i2) >> 31) | 1;
        switch (IntMath$1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                if (i4 == 0) {
                    return i3;
                }
                throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
            case 2:
                return i3;
            case 3:
                if (i5 >= 0) {
                    return i3;
                }
                break;
            case 4:
                break;
            case 5:
                if (i5 <= 0) {
                    return i3;
                }
                break;
            case 6:
            case 7:
            case 8:
                int iAbs = Math.abs(i4);
                int iAbs2 = iAbs - (Math.abs(i2) - iAbs);
                if (iAbs2 == 0) {
                    if (roundingMode != RoundingMode.HALF_UP) {
                        if (!((roundingMode == RoundingMode.HALF_EVEN) & ((i3 & 1) != 0))) {
                            return i3;
                        }
                    }
                } else if (iAbs2 <= 0) {
                    return i3;
                }
            default:
                throw new AssertionError();
        }
        return i3 + i5;
    }

    public static ZipUtil$CentralDirectory findCentralDirectory(RandomAccessFile randomAccessFile) throws IOException {
        long length = randomAccessFile.length();
        long j = length - 22;
        if (j < 0) {
            throw new ZipException("File too short to be a zip file: " + randomAccessFile.length());
        }
        long j2 = length - 65558;
        long j3 = j2 >= 0 ? j2 : 0L;
        int iReverseBytes = Integer.reverseBytes(101010256);
        do {
            randomAccessFile.seek(j);
            if (randomAccessFile.readInt() == iReverseBytes) {
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                ZipUtil$CentralDirectory zipUtil$CentralDirectory = new ZipUtil$CentralDirectory();
                zipUtil$CentralDirectory.size = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                zipUtil$CentralDirectory.offset = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                return zipUtil$CentralDirectory;
            }
            j--;
        } while (j >= j3);
        throw new ZipException("End Of Central Directory signature not found");
    }

    public static void flushThemedResourcesCache(Object obj) {
        LongSparseArray longSparseArray;
        if (!sThemedResourceCacheClazzFetched) {
            try {
                sThemedResourceCacheClazz = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e);
            }
            sThemedResourceCacheClazzFetched = true;
        }
        Class cls = sThemedResourceCacheClazz;
        if (cls == null) {
            return;
        }
        if (!sThemedResourceCache_mUnthemedEntriesFieldFetched) {
            try {
                Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                sThemedResourceCache_mUnthemedEntriesField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e2);
            }
            sThemedResourceCache_mUnthemedEntriesFieldFetched = true;
        }
        Field field = sThemedResourceCache_mUnthemedEntriesField;
        if (field == null) {
            return;
        }
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException e3) {
            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e3);
            longSparseArray = null;
        }
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }

    public static Handshake get(SSLSession sSLSession) throws IOException {
        List listImmutableListOf;
        List listImmutableListOf2 = EmptyList.INSTANCE;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        int iHashCode = cipherSuite.hashCode();
        if (iHashCode == 1019404634 ? cipherSuite.equals("TLS_NULL_WITH_NULL_NULL") : iHashCode == 1208658923 && cipherSuite.equals("SSL_NULL_WITH_NULL_NULL")) {
            throw new IOException("cipherSuite == ".concat(cipherSuite));
        }
        CipherSuite cipherSuiteForJavaName = CipherSuite.Companion.forJavaName(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        if ("NONE".equals(protocol)) {
            throw new IOException("tlsVersion == NONE");
        }
        TlsVersion tlsVersionForJavaName = CloseableKt.forJavaName(protocol);
        try {
            Certificate[] peerCertificates = sSLSession.getPeerCertificates();
            listImmutableListOf = peerCertificates != null ? Util.immutableListOf((Certificate[]) Arrays.copyOf(peerCertificates, peerCertificates.length)) : listImmutableListOf2;
        } catch (SSLPeerUnverifiedException unused) {
        }
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        if (localCertificates != null) {
            listImmutableListOf2 = Util.immutableListOf((Certificate[]) Arrays.copyOf(localCertificates, localCertificates.length));
        }
        return new Handshake(tlsVersionForJavaName, cipherSuiteForJavaName, listImmutableListOf2, new Handshake.AnonymousClass2(listImmutableListOf, 2));
    }

    public static HashSet hashSetOf(Object... objArr) {
        HashSet hashSet = new HashSet(MapsKt__MapsKt.mapCapacity(objArr.length));
        ArraysKt.toCollection(objArr, hashSet);
        return hashSet;
    }

    public static final InstrumentData load(File file) {
        InstrumentData.Type type;
        Intrinsics.checkNotNullParameter(file, "file");
        InstrumentData instrumentData = new InstrumentData();
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "file.name");
        instrumentData.filename = name;
        if (StringsKt__StringsKt.startsWith(name, "crash_log_", false)) {
            type = InstrumentData.Type.CrashReport;
        } else if (StringsKt__StringsKt.startsWith(name, "shield_log_", false)) {
            type = InstrumentData.Type.CrashShield;
        } else if (StringsKt__StringsKt.startsWith(name, "thread_check_log_", false)) {
            type = InstrumentData.Type.ThreadCheck;
        } else if (StringsKt__StringsKt.startsWith(name, "analysis_log_", false)) {
            type = InstrumentData.Type.Analysis;
        } else {
            type = StringsKt__StringsKt.startsWith(name, "anr_log_", false) ? InstrumentData.Type.AnrReport : InstrumentData.Type.Unknown;
        }
        instrumentData.type = type;
        JSONObject file2 = Headers.Companion.readFile(name);
        if (file2 != null) {
            instrumentData.timestamp = Long.valueOf(file2.optLong("timestamp", 0L));
            instrumentData.appVersion = file2.optString("app_version", null);
            instrumentData.cause = file2.optString("reason", null);
            instrumentData.stackTrace = file2.optString("callstack", null);
            instrumentData.featureNames = file2.optJSONArray("feature_names");
        }
        return instrumentData;
    }

    public static int log2(int i, RoundingMode roundingMode) {
        if (i <= 0) {
            throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "x (", ") must be > 0"));
        }
        switch (IntMath$1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                if (!((i > 0) & (((i + (-1)) & i) == 0))) {
                    throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
                }
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(i - 1);
            case 6:
            case 7:
            case 8:
                int iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(i);
                return ((~(~(((-1257966797) >>> iNumberOfLeadingZeros) - i))) >>> 31) + (31 - iNumberOfLeadingZeros);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    public static Set setOf(Object... objArr) {
        int length;
        int length2 = objArr.length;
        EmptySet emptySet = EmptySet.INSTANCE;
        if (length2 <= 0 || (length = objArr.length) == 0) {
            return emptySet;
        }
        if (length != 1) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsKt.mapCapacity(objArr.length));
            ArraysKt.toCollection(objArr, linkedHashSet);
            return linkedHashSet;
        }
        Set setSingleton = Collections.singleton(objArr[0]);
        Intrinsics.checkNotNullExpressionValue(setSingleton, "singleton(element)");
        return setSingleton;
    }

    public static void zza(Context context) {
        boolean z;
        Object obj = zzl.zzb;
        if (((Boolean) zzbfa.zza.zze()).booleanValue()) {
            try {
                if (Settings.Global.getInt(context.getContentResolver(), "development_settings_enabled", 0) != 0) {
                    synchronized (zzl.zzb) {
                        z = zzl.zzc;
                    }
                    if (z) {
                        return;
                    }
                    ListenableFuture listenableFutureZzb = new zzc(context).zzb();
                    int i = zze.$r8$clinit;
                    zzo.zzi("Updating ad debug logging enablement.");
                    zzcai.zza(listenableFutureZzb, "AdDebugLogUpdater.updateEnablement");
                }
            } catch (Exception e) {
                zzo.zzk("Fail to determine debug setting.", e);
            }
        }
    }

    public final GamepadHandler_API12$GamepadInstance GetGamepad(int i) {
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.m_Gamepads;
            if (i2 >= arrayList.size()) {
                return null;
            }
            GamepadHandler_API12$GamepadInstance gamepadHandler_API12$GamepadInstance = (GamepadHandler_API12$GamepadInstance) arrayList.get(i2);
            if (gamepadHandler_API12$GamepadInstance.idDevice == i) {
                return gamepadHandler_API12$GamepadInstance;
            }
            i2++;
        }
    }

    public static final InstrumentData build(String str, String str2) {
        InstrumentData instrumentData = new InstrumentData();
        instrumentData.type = InstrumentData.Type.AnrReport;
        Context applicationContext = FacebookSdk.getApplicationContext();
        String str3 = null;
        try {
            PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0);
            if (packageInfo != null) {
                str3 = packageInfo.versionName;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        instrumentData.appVersion = str3;
        instrumentData.cause = str;
        instrumentData.stackTrace = str2;
        Long lValueOf = Long.valueOf(System.currentTimeMillis() / ((long) 1000));
        instrumentData.timestamp = lValueOf;
        StringBuffer stringBuffer = new StringBuffer("anr_log_");
        stringBuffer.append(String.valueOf(lValueOf));
        stringBuffer.append(".json");
        String string = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuffer()\n            .append(InstrumentUtility.ANR_REPORT_PREFIX)\n            .append(timestamp.toString())\n            .append(\".json\")\n            .toString()");
        instrumentData.filename = string;
        return instrumentData;
    }
}
