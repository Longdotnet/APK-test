package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzewv implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;
    private final zzhha zzc;
    private final zzhha zzd;
    private final zzhha zze;
    private final zzhha zzf;

    private zzewv(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5, zzhha zzhhaVar6, zzhha zzhhaVar7, zzhha zzhhaVar8) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
        this.zzc = zzhhaVar5;
        this.zzd = zzhhaVar6;
        this.zze = zzhhaVar7;
        this.zzf = zzhhaVar8;
    }

    public static zzewv zza(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5, zzhha zzhhaVar6, zzhha zzhhaVar7, zzhha zzhhaVar8) {
        return new zzewv(zzhhaVar, zzhhaVar2, zzhhaVar3, zzhhaVar4, zzhhaVar5, zzhhaVar6, zzhhaVar7, zzhhaVar8);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzewt((zzbzs) this.zza.zzb(), ((zzewm) this.zzb).zzb().booleanValue(), zzclb.zza(), zzffu.zzc(), ((zzewj) this.zzc).zzc(), (ScheduledExecutorService) this.zzd.zzb(), ((zzewo) this.zze).zzb().intValue(), ((zzewp) this.zzf).zzb().intValue());
    }
}
