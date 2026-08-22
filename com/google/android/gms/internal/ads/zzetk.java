package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzetk implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;
    private final zzhha zzc;
    private final zzhha zzd;
    private final zzhha zze;
    private final zzhha zzf;
    private final zzhha zzg;
    private final zzhha zzh;
    private final zzhha zzi;

    private zzetk(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5, zzhha zzhhaVar6, zzhha zzhhaVar7, zzhha zzhhaVar8, zzhha zzhhaVar9, zzhha zzhhaVar10) {
        this.zza = zzhhaVar2;
        this.zzb = zzhhaVar3;
        this.zzc = zzhhaVar4;
        this.zzd = zzhhaVar5;
        this.zze = zzhhaVar6;
        this.zzf = zzhhaVar7;
        this.zzg = zzhhaVar8;
        this.zzh = zzhhaVar9;
        this.zzi = zzhhaVar10;
    }

    public static zzetk zza(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5, zzhha zzhhaVar6, zzhha zzhhaVar7, zzhha zzhhaVar8, zzhha zzhhaVar9, zzhha zzhhaVar10) {
        return new zzetk(zzhhaVar, zzhhaVar2, zzhhaVar3, zzhhaVar4, zzhhaVar5, zzhhaVar6, zzhhaVar7, zzhhaVar8, zzhhaVar9, zzhhaVar10);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzeti(zzffu.zzc(), (ScheduledExecutorService) this.zza.zzb(), (String) this.zzb.zzb(), (zzeju) this.zzc.zzb(), (Context) this.zzd.zzb(), ((zzcvp) this.zze).zzc(), (zzejq) this.zzf.zzb(), (zzdpz) this.zzg.zzb(), (zzdup) this.zzh.zzb(), ((Integer) this.zzi.zzb()).intValue());
    }
}
