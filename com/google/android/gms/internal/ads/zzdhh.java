package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzdhh implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;
    private final zzhha zzc;
    private final zzhha zzd;
    private final zzhha zze;
    private final zzhha zzf;

    private zzdhh(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5, zzhha zzhhaVar6) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
        this.zzc = zzhhaVar3;
        this.zzd = zzhhaVar4;
        this.zze = zzhhaVar5;
        this.zzf = zzhhaVar6;
    }

    public static zzdhh zza(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5, zzhha zzhhaVar6) {
        return new zzdhh(zzhhaVar, zzhhaVar2, zzhhaVar3, zzhhaVar4, zzhhaVar5, zzhhaVar6);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final Object zzb() {
        zzche zzcheVar = (zzche) this.zza.zzb();
        zzcvf zzcvfVarZza = ((zzcvq) this.zzb).zza();
        zzdbw zzdbwVarZza = ((zzdcr) this.zzc).zza();
        zzdgw zzdgwVarZza = ((zzdgy) this.zzd).zza();
        zzcyv zzcyvVarZzb = ((zzcor) this.zze).zzb();
        zzehb zzehbVar = (zzehb) this.zzf.zzb();
        zzcpw zzcpwVarZzd = zzcheVar.zzd();
        zzcpwVarZzd.zzi(zzcvfVarZza.zzl());
        zzcpwVarZzd.zzf(zzdbwVarZza);
        zzcpwVarZzd.zzd(zzdgwVarZza);
        zzcpwVarZzd.zze(new zzejh(null));
        zzcpwVarZzd.zzg(new zzcqs(zzcyvVarZzb, null));
        zzcpwVarZzd.zzc(new zzcop(null));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzdU)).booleanValue()) {
            zzcpwVarZzd.zzj(zzehk.zzb(zzehbVar));
        }
        zzcrd zzcrdVarZzb = zzcpwVarZzd.zzh().zzb();
        zzhgz.zzb(zzcrdVarZzb);
        return zzcrdVarZzb;
    }
}
