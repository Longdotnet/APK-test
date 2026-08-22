package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzdju implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;
    private final zzhha zzc;
    private final zzhha zzd;
    private final zzhha zze;
    private final zzhha zzf;
    private final zzhha zzg;
    private final zzhha zzh;

    private zzdju(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5, zzhha zzhhaVar6, zzhha zzhhaVar7, zzhha zzhhaVar8, zzhha zzhhaVar9) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
        this.zzc = zzhhaVar3;
        this.zzd = zzhhaVar4;
        this.zze = zzhhaVar5;
        this.zzf = zzhhaVar6;
        this.zzg = zzhhaVar7;
        this.zzh = zzhhaVar9;
    }

    public static zzdju zzc(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5, zzhha zzhhaVar6, zzhha zzhhaVar7, zzhha zzhhaVar8, zzhha zzhhaVar9) {
        return new zzdju(zzhhaVar, zzhhaVar2, zzhhaVar3, zzhhaVar4, zzhhaVar5, zzhhaVar6, zzhhaVar7, zzhhaVar8, zzhhaVar9);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdjt zzb() {
        return new zzdjt(((zzchi) this.zza).zzb(), ((zzcvp) this.zzb).zzc(), (zzdiy) this.zzc.zzb(), ((zzdjm) this.zzd).zza(), (zzdkh) this.zze.zzb(), (zzdkp) this.zzf.zzb(), (Executor) this.zzg.zzb(), zzffu.zzc(), (zzdiq) this.zzh.zzb());
    }
}
