package com.google.android.gms.internal.ads;

import android.os.Build;
import android.os.ext.SdkExtensions;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzeob implements zzeub {
    private final Integer zza;

    private zzeob(Integer num) {
        this.zza = num;
    }

    public static zzeob zzc(VersionInfoParcel versionInfoParcel) {
        zzbcv zzbcvVar = zzbde.zzkx;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        zzbdc zzbdcVar = zzbdVar.zzd;
        zzbdc zzbdcVar2 = zzbdVar.zzd;
        if (!((Boolean) zzbdcVar.zzb(zzbcvVar)).booleanValue()) {
            return new zzeob(null);
        }
        com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
        int extensionVersion = 0;
        try {
            int i = Build.VERSION.SDK_INT;
            if (i >= 30 && SdkExtensions.getExtensionVersion(30) > 3) {
                extensionVersion = SdkExtensions.getExtensionVersion(1000000);
            } else if (((Boolean) zzbdcVar2.zzb(zzbde.zzkA)).booleanValue() && versionInfoParcel.clientJarVersion >= ((Integer) zzbdcVar2.zzb(zzbde.zzkz)).intValue() && i >= 31 && SdkExtensions.getExtensionVersion(31) >= 9) {
                extensionVersion = SdkExtensions.getExtensionVersion(31);
            }
        } catch (Exception e) {
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "AdUtil.getAdServicesExtensionVersion");
        }
        return new zzeob(Integer.valueOf(extensionVersion));
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* synthetic */ void zza(Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Integer num = this.zza;
        zzcva zzcvaVar = (zzcva) obj;
        if (num != null) {
            zzcvaVar.zza.putInt("aos", num.intValue());
        }
    }
}
