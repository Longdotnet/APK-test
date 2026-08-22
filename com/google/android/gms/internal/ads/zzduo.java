package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzduo implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;
    private final zzhha zzc;
    private final zzhha zzd;
    private final zzhha zze;
    private final zzhha zzf;
    private final zzhha zzg;
    private final zzhha zzh;
    private final zzhha zzi;

    private zzduo(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5, zzhha zzhhaVar6, zzhha zzhhaVar7, zzhha zzhhaVar8, zzhha zzhhaVar9, zzhha zzhhaVar10) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
        this.zzc = zzhhaVar3;
        this.zzd = zzhhaVar5;
        this.zze = zzhhaVar6;
        this.zzf = zzhhaVar7;
        this.zzg = zzhhaVar8;
        this.zzh = zzhhaVar9;
        this.zzi = zzhhaVar10;
    }

    public static zzduo zza(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5, zzhha zzhhaVar6, zzhha zzhhaVar7, zzhha zzhhaVar8, zzhha zzhhaVar9, zzhha zzhhaVar10) {
        return new zzduo(zzhhaVar, zzhhaVar2, zzhhaVar3, zzhhaVar4, zzhhaVar5, zzhhaVar6, zzhhaVar7, zzhhaVar8, zzhhaVar9, zzhhaVar10);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdun((Executor) this.zza.zzb(), ((zzchl) this.zzb).zza(), ((zzchm) this.zzc).zzc(), zzffu.zzc(), (zzdpz) this.zzd.zzb(), (ScheduledExecutorService) this.zze.zzb(), (zzdsu) this.zzf.zzb(), ((zzchz) this.zzg).zza(), ((zzddd) this.zzh).zzb(), (zzfhx) this.zzi.zzb());
    }
}
