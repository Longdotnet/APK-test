package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzeuz implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;
    private final zzhha zzc;
    private final zzhha zzd;
    private final zzhha zze;
    private final zzhha zzf;

    private zzeuz(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5, zzhha zzhhaVar6, zzhha zzhhaVar7) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
        this.zzc = zzhhaVar4;
        this.zzd = zzhhaVar5;
        this.zze = zzhhaVar6;
        this.zzf = zzhhaVar7;
    }

    public static zzeuz zza(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5, zzhha zzhhaVar6, zzhha zzhhaVar7) {
        return new zzeuz(zzhhaVar, zzhhaVar2, zzhhaVar3, zzhhaVar4, zzhhaVar5, zzhhaVar6, zzhhaVar7);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzeuw(((zzchi) this.zza).zzb(), ((zzchl) this.zzb).zza(), zzffu.zzc(), (ScheduledExecutorService) this.zzc.zzb(), ((zzedl) this.zzd).zzb(), ((zzcvp) this.zze).zzc(), ((zzchz) this.zzf).zza());
    }
}
