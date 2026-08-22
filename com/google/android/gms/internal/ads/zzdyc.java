package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzdyc implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;
    private final zzhha zzc;
    private final zzhha zzd;
    private final zzhha zze;
    private final zzhha zzf;
    private final zzhha zzg;
    private final zzhha zzh;
    private final zzhha zzi;
    private final zzhha zzj;

    private zzdyc(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5, zzhha zzhhaVar6, zzhha zzhhaVar7, zzhha zzhhaVar8, zzhha zzhhaVar9, zzhha zzhhaVar10, zzhha zzhhaVar11, zzhha zzhhaVar12, zzhha zzhhaVar13) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
        this.zzc = zzhhaVar3;
        this.zzd = zzhhaVar4;
        this.zze = zzhhaVar6;
        this.zzf = zzhhaVar7;
        this.zzg = zzhhaVar8;
        this.zzh = zzhhaVar11;
        this.zzi = zzhhaVar12;
        this.zzj = zzhhaVar13;
    }

    public static zzdyc zzc(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5, zzhha zzhhaVar6, zzhha zzhhaVar7, zzhha zzhhaVar8, zzhha zzhhaVar9, zzhha zzhhaVar10, zzhha zzhhaVar11, zzhha zzhhaVar12, zzhha zzhhaVar13) {
        return new zzdyc(zzhhaVar, zzhhaVar2, zzhhaVar3, zzhhaVar4, zzhhaVar5, zzhhaVar6, zzhhaVar7, zzhhaVar8, zzhhaVar9, zzhhaVar10, zzhhaVar11, zzhhaVar12, zzhhaVar13);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdyb zzb() {
        return new zzdyb((zzche) this.zza.zzb(), ((zzchl) this.zzb).zza(), ((zzchz) this.zzc).zza(), ((zzcvp) this.zzd).zzc(), zzffu.zzc(), (String) this.zze.zzb(), (zzfhu) this.zzf.zzb(), (zzdsd) this.zzg.zzb(), zzcij.zza(), zzcig.zza(), (ScheduledExecutorService) this.zzh.zzb(), (zzfjy) this.zzi.zzb(), ((zzcyz) this.zzj).zzb());
    }
}
