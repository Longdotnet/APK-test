package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzehj implements zzhgr {
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
    private final zzhha zzk;
    private final zzhha zzl;

    private zzehj(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5, zzhha zzhhaVar6, zzhha zzhhaVar7, zzhha zzhhaVar8, zzhha zzhhaVar9, zzhha zzhhaVar10, zzhha zzhhaVar11, zzhha zzhhaVar12, zzhha zzhhaVar13) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
        this.zzc = zzhhaVar3;
        this.zzd = zzhhaVar4;
        this.zze = zzhhaVar5;
        this.zzf = zzhhaVar6;
        this.zzg = zzhhaVar7;
        this.zzh = zzhhaVar9;
        this.zzi = zzhhaVar10;
        this.zzj = zzhhaVar11;
        this.zzk = zzhhaVar12;
        this.zzl = zzhhaVar13;
    }

    public static zzehj zzc(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5, zzhha zzhhaVar6, zzhha zzhhaVar7, zzhha zzhhaVar8, zzhha zzhhaVar9, zzhha zzhhaVar10, zzhha zzhhaVar11, zzhha zzhhaVar12, zzhha zzhhaVar13) {
        return new zzehj(zzhhaVar, zzhhaVar2, zzhhaVar3, zzhhaVar4, zzhhaVar5, zzhhaVar6, zzhhaVar7, zzhhaVar8, zzhhaVar9, zzhhaVar10, zzhhaVar11, zzhhaVar12, zzhhaVar13);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzehi zzb() {
        return new zzehi(((zzchl) this.zza).zza(), (zzfha) this.zzb.zzb(), (zzehb) this.zzc.zzb(), (zzcwa) this.zzd.zzb(), (zzfju) this.zze.zzb(), (zzfjy) this.zzf.zzb(), (zzcrd) this.zzg.zzb(), zzffu.zzc(), (ScheduledExecutorService) this.zzh.zzb(), (zzedr) this.zzi.zzb(), (zzfhu) this.zzj.zzb(), ((zzegn) this.zzk).zzb(), (zzdsd) this.zzl.zzb());
    }
}
