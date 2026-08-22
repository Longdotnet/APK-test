package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.auth.api.LNi.xPQrbOSWiEdU;
import com.google.android.gms.common.internal.zzae;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.common.zzc;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.ranges.RangesKt;
import okhttp3.internal.concurrent.onZL.mnwSv;

/* JADX INFO: loaded from: classes2.dex */
public final class GoogleSignatureVerifier {
    public static GoogleSignatureVerifier zza;
    public final Context zzc;
    public volatile String zzd;

    public GoogleSignatureVerifier(Context context) {
        this.zzc = context.getApplicationContext();
    }

    public static GoogleSignatureVerifier getInstance(Context context) {
        zzah.checkNotNull(context);
        synchronized (GoogleSignatureVerifier.class) {
            try {
                if (zza == null) {
                    zzn.zze(context);
                    zza = new GoogleSignatureVerifier(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zza;
    }

    public static final zzj zza(PackageInfo packageInfo, zzj... zzjVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            zzk zzkVar = new zzk(packageInfo.signatures[0].toByteArray());
            for (int i = 0; i < zzjVarArr.length; i++) {
                if (zzjVarArr[i].equals(zzkVar)) {
                    return zzjVarArr[i];
                }
            }
        }
        return null;
    }

    public static final boolean zzb(PackageInfo packageInfo, boolean z) {
        PackageInfo packageInfo2;
        if (!z) {
            packageInfo2 = packageInfo;
        } else if (packageInfo != null) {
            if ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName)) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                z = (applicationInfo == null || (applicationInfo.flags & 129) == 0) ? false : true;
            }
            packageInfo2 = packageInfo;
        } else {
            packageInfo2 = null;
        }
        if (packageInfo != null && packageInfo2.signatures != null) {
            if ((z ? zza(packageInfo2, zzm.zza) : zza(packageInfo2, zzm.zza[0])) != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:80:0x0182  */
    public final boolean isUidGoogleSigned(int i) {
        zzx zzxVar;
        int length;
        boolean zZzf;
        ApplicationInfo applicationInfo;
        zzx zzxVar2;
        String[] packagesForUid = this.zzc.getPackageManager().getPackagesForUid(i);
        if (packagesForUid != null && (length = packagesForUid.length) != 0) {
            zzxVar = null;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    zzah.checkNotNull(zzxVar);
                    break;
                }
                String str = packagesForUid[i2];
                String str2 = xPQrbOSWiEdU.iyuTnKsFyh;
                if (str == null) {
                    zzxVar = new zzx(false, "null pkg", null);
                } else if (str.equals(this.zzd)) {
                    zzxVar = zzx.zze;
                } else {
                    zzf zzfVar = zzn.zzc;
                    StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        try {
                            zzn.zzj();
                            zzae zzaeVar = (zzae) zzn.zze;
                            Parcel parcelZzB = zzaeVar.zzB(7, zzaeVar.zza());
                            zZzf = zzc.zzf(parcelZzB);
                            parcelZzB.recycle();
                        } catch (RemoteException | DynamiteModule.LoadingException e) {
                            Log.e(str2, "Failed to get Google certificates from remote", e);
                            zZzf = false;
                        }
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        if (zZzf) {
                            boolean zHonorsDebugCertificates = GooglePlayServicesUtil.honorsDebugCertificates(this.zzc);
                            StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads2 = StrictMode.allowThreadDiskReads();
                            try {
                                zzah.checkNotNull(zzn.zzg);
                                try {
                                    zzn.zzj();
                                    zzo zzoVar = new zzo(str, zHonorsDebugCertificates, false, new ObjectWrapper(zzn.zzg), false, true);
                                    try {
                                        zzae zzaeVar2 = (zzae) zzn.zze;
                                        Parcel parcelZza = zzaeVar2.zza();
                                        zzc.zzc(parcelZza, zzoVar);
                                        Parcel parcelZzB2 = zzaeVar2.zzB(6, parcelZza);
                                        zzq zzqVar = (zzq) zzc.zza(parcelZzB2, zzq.CREATOR);
                                        parcelZzB2.recycle();
                                        if (zzqVar.zza) {
                                            JvmClassMappingKt.zza(zzqVar.zzd);
                                            zzxVar = new zzx(true, null, null);
                                        } else {
                                            String str3 = zzqVar.zzb;
                                            PackageManager.NameNotFoundException nameNotFoundException = RangesKt.zza(zzqVar.zzc) == 4 ? new PackageManager.NameNotFoundException() : null;
                                            if (str3 == null) {
                                                str3 = "error checking package certificate";
                                            }
                                            JvmClassMappingKt.zza(zzqVar.zzd);
                                            RangesKt.zza(zzqVar.zzc);
                                            zzxVar2 = new zzx(false, str3, nameNotFoundException);
                                            zzxVar = zzxVar2;
                                        }
                                    } catch (RemoteException e2) {
                                        Log.e(str2, "Failed to get Google certificates from remote", e2);
                                        zzxVar = new zzx(false, "module call", e2);
                                    }
                                } catch (DynamiteModule.LoadingException e3) {
                                    Log.e(str2, "Failed to get Google certificates from remote", e3);
                                    zzxVar2 = new zzx(false, "module init: ".concat(String.valueOf(e3.getMessage())), e3);
                                }
                                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads2);
                            } catch (Throwable th) {
                                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads2);
                                throw th;
                            }
                        } else {
                            try {
                                PackageInfo packageInfo = this.zzc.getPackageManager().getPackageInfo(str, 64);
                                boolean zHonorsDebugCertificates2 = GooglePlayServicesUtil.honorsDebugCertificates(this.zzc);
                                if (packageInfo == null) {
                                    zzxVar = new zzx(false, "null pkg", null);
                                } else {
                                    Signature[] signatureArr = packageInfo.signatures;
                                    if (signatureArr == null || signatureArr.length != 1) {
                                        zzxVar = new zzx(false, "single cert required", null);
                                    } else {
                                        zzk zzkVar = new zzk(packageInfo.signatures[0].toByteArray());
                                        String str4 = packageInfo.packageName;
                                        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads3 = StrictMode.allowThreadDiskReads();
                                        try {
                                            zzx zzxVarZzh = zzn.zzh(str4, zzkVar, zHonorsDebugCertificates2, false);
                                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads3);
                                            if (!zzxVarZzh.zza || (applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 2) == 0) {
                                                zzxVar = zzxVarZzh;
                                            } else {
                                                StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads4 = StrictMode.allowThreadDiskReads();
                                                try {
                                                    zzx zzxVarZzh2 = zzn.zzh(str4, zzkVar, false, true);
                                                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads4);
                                                    if (zzxVarZzh2.zza) {
                                                        zzxVar = new zzx(false, "debuggable release cert app rejected", null);
                                                    } else {
                                                        zzxVar = zzxVarZzh;
                                                    }
                                                } catch (Throwable th2) {
                                                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads4);
                                                    throw th2;
                                                }
                                            }
                                        } catch (Throwable th3) {
                                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads3);
                                            throw th3;
                                        }
                                    }
                                }
                            } catch (PackageManager.NameNotFoundException e4) {
                                zzxVar = new zzx(false, mnwSv.zXxlvnGVzC.concat(str), e4);
                            }
                        }
                        if (zzxVar.zza) {
                            this.zzd = str;
                        }
                    } catch (Throwable th4) {
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        throw th4;
                    }
                }
                if (zzxVar.zza) {
                    break;
                }
                i2++;
            }
        } else {
            zzxVar = new zzx(false, "no pkgs", null);
        }
        if (!zzxVar.zza && Log.isLoggable("GoogleCertificatesRslt", 3)) {
            Exception exc = zzxVar.zzc;
            if (exc != null) {
                Log.d("GoogleCertificatesRslt", zzxVar.zza(), exc);
            } else {
                Log.d("GoogleCertificatesRslt", zzxVar.zza());
            }
        }
        return zzxVar.zza;
    }
}
