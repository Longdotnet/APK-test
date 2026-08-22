package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzdqi implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;
    private final zzhha zzc;
    private final zzhha zzd;
    private final zzhha zze;

    private zzdqi(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
        this.zzc = zzhhaVar3;
        this.zzd = zzhhaVar4;
        this.zze = zzhhaVar5;
    }

    public static zzdqi zza(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5) {
        return new zzdqi(zzhhaVar, zzhhaVar2, zzhhaVar3, zzhhaVar4, zzhhaVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        Context contextZza = ((zzchl) this.zza).zza();
        final String strZzb = ((zzdxh) this.zzb).zzb();
        VersionInfoParcel versionInfoParcelZza = ((zzchz) this.zzc).zza();
        final zzbcj.zza.EnumC0001zza enumC0001zza = (zzbcj.zza.EnumC0001zza) this.zzd.zzb();
        final String str = (String) this.zze.zzb();
        zzbcc zzbccVar = new zzbcc(new zzbci(contextZza));
        zzbcj.zzar.zza zzaVarZzd = zzbcj.zzar.zzd();
        zzaVarZzd.zzg(versionInfoParcelZza.buddyApkVersion);
        zzaVarZzd.zzi(versionInfoParcelZza.clientJarVersion);
        zzaVarZzd.zzh(true != versionInfoParcelZza.isClientJar ? 2 : 0);
        final zzbcj.zzar zzarVarZzbr = zzaVarZzd.zzbr();
        zzbccVar.zzb(new zzbcb() { // from class: com.google.android.gms.internal.ads.zzdqh
            @Override // com.google.android.gms.internal.ads.zzbcb
            public final void zza(zzbcj.zzt.zza zzaVar) {
                zzbcj.zza.zzb zzbVarZzbM = zzaVar.zze().zzbM();
                zzbVarZzbM.zzH(enumC0001zza);
                zzaVar.zzG(zzbVarZzbM);
                zzbcj.zzm.zza zzaVarZzbM = zzaVar.zzg().zzbM();
                zzaVarZzbM.zzm(strZzb);
                zzaVarZzbM.zzw(zzarVarZzbr);
                zzaVar.zzK(zzaVarZzbM);
                zzaVar.zzO(str);
            }
        });
        return zzbccVar;
    }
}
