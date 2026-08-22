package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.InstallSourceInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
public final class zzesp implements zzeuc {
    private final ApplicationInfo zza;
    private final PackageInfo zzb;
    private final Context zzc;

    public zzesp(ApplicationInfo applicationInfo, PackageInfo packageInfo, Context context) {
        this.zza = applicationInfo;
        this.zzb = packageInfo;
        this.zzc = context;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 29;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x007b  */
    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        String strValueOf;
        String installingPackageName;
        String str;
        PackageManager.NameNotFoundException e;
        String initiatingPackageName;
        String str2 = this.zza.packageName;
        PackageInfo packageInfo = this.zzb;
        Integer numValueOf = packageInfo == null ? null : Integer.valueOf(packageInfo.versionCode);
        String str3 = packageInfo == null ? null : packageInfo.versionName;
        try {
            Context context = this.zzc;
            com.google.android.gms.ads.internal.util.zzf zzfVar = com.google.android.gms.ads.internal.util.zzs.zza;
            strValueOf = String.valueOf(Wrappers.packageManager(context).getApplicationLabel(str2));
        } catch (PackageManager.NameNotFoundException unused) {
            strValueOf = null;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zznh)).booleanValue()) {
                try {
                    InstallSourceInfo installSourceInfo = this.zzc.getPackageManager().getInstallSourceInfo(str2);
                    if (installSourceInfo != null) {
                        installingPackageName = installSourceInfo.getInstallingPackageName();
                        try {
                            if (TextUtils.isEmpty(installingPackageName)) {
                                com.google.android.gms.ads.internal.util.zze.zza("No installing package name found");
                                installingPackageName = null;
                            }
                            initiatingPackageName = installSourceInfo.getInitiatingPackageName();
                            try {
                                if (TextUtils.isEmpty(initiatingPackageName)) {
                                    com.google.android.gms.ads.internal.util.zze.zza("No initiating package name found");
                                    str = null;
                                } else {
                                    str = initiatingPackageName;
                                }
                            } catch (PackageManager.NameNotFoundException e2) {
                                e = e2;
                                com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "PackageInfoSignalSource.getInstallSourceInfo");
                            }
                        } catch (PackageManager.NameNotFoundException e3) {
                            e = e3;
                            initiatingPackageName = null;
                        }
                    } else {
                        installingPackageName = null;
                        str = null;
                    }
                } catch (PackageManager.NameNotFoundException e4) {
                    installingPackageName = null;
                    e = e4;
                    initiatingPackageName = null;
                }
            } else {
                installingPackageName = null;
                str = null;
            }
        } else {
            installingPackageName = null;
            str = null;
        }
        return zzgdn.zzh(new zzesq(str2, numValueOf, str3, strValueOf, installingPackageName, str));
    }
}
