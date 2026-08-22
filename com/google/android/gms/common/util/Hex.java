package com.google.android.gms.common.util;

import android.app.AppOpsManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.database.CharArrayBuffer;
import android.os.Build;
import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import androidx.work.impl.WorkDatabase;
import com.google.android.gms.auth.api.LNi.xPQrbOSWiEdU;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.wrappers.Wrappers;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Hex {
    public static String zza;
    public static int zzb;
    public static Boolean zze;
    public static Boolean zzf;
    public static Boolean zzg;
    public static Boolean zzh;
    public static Boolean zzj;
    public static Boolean zzm;

    /* JADX INFO: renamed from: zza, reason: collision with other field name */
    public static final char[] f1zza = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: zzb, reason: collision with other field name */
    public static final char[] f2zzb = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static void addDynamiteErrorToDropBox(Context context, Throwable th) {
        try {
            zzah.checkNotNull(context);
        } catch (Exception e) {
            Log.e("CrashUtils", "Error adding exception to DropBox!", e);
        }
    }

    public static String bytesToStringLowercase(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length + length];
        int i = 0;
        for (byte b : bArr) {
            char[] cArr2 = f2zzb;
            cArr[i] = cArr2[(b & 255) >>> 4];
            cArr[i + 1] = cArr2[b & 15];
            i += 2;
        }
        return new String(cArr);
    }

    public static String bytesToStringUppercase(byte[] bArr) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length + length);
        for (int i = 0; i < length; i++) {
            char[] cArr = f1zza;
            sb.append(cArr[(bArr[i] & 240) >>> 4]);
            sb.append(cArr[bArr[i] & 15]);
        }
        return sb.toString();
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static boolean contains(Object[] objArr, Feature feature) {
        int length = objArr != null ? objArr.length : 0;
        for (int i = 0; i < length; i++) {
            if (zzah.equal(objArr[i], feature)) {
                if (i >= 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static long copyStream(InputStream inputStream, OutputStream outputStream, boolean z) {
        byte[] bArr = new byte[1024];
        long j = 0;
        while (true) {
            try {
                int i = inputStream.read(bArr, 0, 1024);
                if (i == -1) {
                    break;
                }
                j += (long) i;
                outputStream.write(bArr, 0, i);
            } catch (Throwable th) {
                if (z) {
                    closeQuietly(inputStream);
                    closeQuietly(outputStream);
                }
                throw th;
            }
        }
        if (z) {
            closeQuietly(inputStream);
            closeQuietly(outputStream);
        }
        return j;
    }

    public static void copyStringToBuffer(String str, CharArrayBuffer charArrayBuffer) {
        if (TextUtils.isEmpty(str)) {
            charArrayBuffer.sizeCopied = 0;
            return;
        }
        char[] cArr = charArrayBuffer.data;
        if (cArr == null || cArr.length < str.length()) {
            charArrayBuffer.data = str.toCharArray();
        } else {
            str.getChars(0, str.length(), charArrayBuffer.data, 0);
        }
        charArrayBuffer.sizeCopied = str.length();
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0027  */
    public static byte[] getPackageCertificateHashBytes(Context context, String str) {
        MessageDigest messageDigest;
        PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(64, str);
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null && signatureArr.length == 1) {
            for (int i = 0; i < 2; i++) {
                try {
                    messageDigest = MessageDigest.getInstance("SHA1");
                    if (messageDigest != null) {
                        if (messageDigest != null) {
                            return messageDigest.digest(packageInfo.signatures[0].toByteArray());
                        }
                    }
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            messageDigest = null;
            if (messageDigest != null) {
                return messageDigest.digest(packageInfo.signatures[0].toByteArray());
            }
        }
        return null;
    }

    public static boolean isAtLeastO() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean isAtLeastR() {
        return Build.VERSION.SDK_INT >= 30;
    }

    public static boolean isGooglePlayServicesUid(Context context, int i) {
        if (uidHasPackageName(context, "com.google.android.gms", i)) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.google.android.gms", 64);
                GoogleSignatureVerifier googleSignatureVerifier = GoogleSignatureVerifier.getInstance(context);
                googleSignatureVerifier.getClass();
                if (packageInfo == null) {
                    return false;
                }
                if (!GoogleSignatureVerifier.zzb(packageInfo, false)) {
                    if (!GoogleSignatureVerifier.zzb(packageInfo, true)) {
                        return false;
                    }
                    if (!GooglePlayServicesUtil.honorsDebugCertificates(googleSignatureVerifier.zzc)) {
                        Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
                        return false;
                    }
                }
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
                if (Log.isLoggable("UidVerifier", 3)) {
                    Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
                }
            }
        }
        return false;
    }

    public static boolean isLatchsky(Context context) {
        if (zzg == null) {
            PackageManager packageManager = context.getPackageManager();
            boolean z = false;
            if (packageManager.hasSystemFeature("com.google.android.feature.services_updater") && packageManager.hasSystemFeature("cn.google.services")) {
                z = true;
            }
            zzg = Boolean.valueOf(z);
        }
        return zzg.booleanValue();
    }

    public static boolean isWearableWithoutPlayStore(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (zze == null) {
            zze = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        if (zze.booleanValue() && Build.VERSION.SDK_INT < 24) {
            return true;
        }
        if (zza(context)) {
            return !isAtLeastO() || isAtLeastR();
        }
        return false;
    }

    public static byte[] stringToBytes(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("Hex string has odd number of characters");
        }
        byte[] bArr = new byte[length / 2];
        int i = 0;
        while (i < length) {
            int i2 = i + 2;
            bArr[i / 2] = (byte) Integer.parseInt(str.substring(i, i2), 16);
            i = i2;
        }
        return bArr;
    }

    public static boolean uidHasPackageName(Context context, String str, int i) {
        WorkDatabase.AnonymousClass1 anonymousClass1PackageManager = Wrappers.packageManager(context);
        anonymousClass1PackageManager.getClass();
        try {
            AppOpsManager appOpsManager = (AppOpsManager) anonymousClass1PackageManager.val$context.getSystemService("appops");
            if (appOpsManager == null) {
                throw new NullPointerException("context.getSystemService(Context.APP_OPS_SERVICE) is null");
            }
            appOpsManager.checkPackage(i, str);
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }

    public static void writeStringMapToJson(StringBuilder sb, HashMap map) {
        sb.append("{");
        boolean z = true;
        for (String str : map.keySet()) {
            if (!z) {
                sb.append(",");
            }
            String str2 = (String) map.get(str);
            sb.append("\"");
            sb.append(str);
            sb.append("\":");
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append("\"");
                sb.append(str2);
                sb.append("\"");
            }
            z = false;
        }
        sb.append("}");
    }

    public static boolean zza(Context context) {
        if (zzf == null) {
            zzf = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return zzf.booleanValue();
    }

    public static String getMyProcessName() throws Throwable {
        BufferedReader bufferedReader;
        String str = xPQrbOSWiEdU.TCunYvzbT;
        if (zza == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                zza = Application.getProcessName();
            } else {
                int iMyPid = zzb;
                if (iMyPid == 0) {
                    iMyPid = Process.myPid();
                    zzb = iMyPid;
                }
                String strTrim = null;
                strTrim = null;
                strTrim = null;
                BufferedReader bufferedReader2 = null;
                if (iMyPid > 0) {
                    try {
                        String str2 = str + iMyPid + "/cmdline";
                        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                        try {
                            bufferedReader = new BufferedReader(new FileReader(str2));
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                            try {
                                String line = bufferedReader.readLine();
                                zzah.checkNotNull(line);
                                strTrim = line.trim();
                            } catch (IOException unused) {
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader2 = bufferedReader;
                                closeQuietly(bufferedReader2);
                                throw th;
                            }
                            closeQuietly(bufferedReader);
                        } catch (Throwable th2) {
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                            throw th2;
                        }
                    } catch (IOException unused2) {
                        bufferedReader = null;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                zza = strTrim;
            }
        }
        return zza;
    }
}
