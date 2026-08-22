package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzdoa implements zzhgr {
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

    private zzdoa(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5, zzhha zzhhaVar6, zzhha zzhhaVar7, zzhha zzhhaVar8, zzhha zzhhaVar9, zzhha zzhhaVar10, zzhha zzhhaVar11) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
        this.zzc = zzhhaVar3;
        this.zzd = zzhhaVar4;
        this.zze = zzhhaVar5;
        this.zzf = zzhhaVar7;
        this.zzg = zzhhaVar8;
        this.zzh = zzhhaVar9;
        this.zzi = zzhhaVar10;
        this.zzj = zzhhaVar11;
    }

    public static zzdoa zza(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5, zzhha zzhhaVar6, zzhha zzhhaVar7, zzhha zzhhaVar8, zzhha zzhhaVar9, zzhha zzhhaVar10, zzhha zzhhaVar11) {
        return new zzdoa(zzhhaVar, zzhhaVar2, zzhhaVar3, zzhhaVar4, zzhhaVar5, zzhhaVar6, zzhhaVar7, zzhhaVar8, zzhhaVar9, zzhhaVar10, zzhhaVar11);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdnv(((zzchl) this.zza).zza(), (Executor) this.zzb.zzb(), (zzavu) this.zzc.zzb(), ((zzchz) this.zzd).zza(), ((zzcju) this.zze).zza(), zzckm.zza(), (zzeca) this.zzf.zzb(), (zzfjy) this.zzg.zzb(), (zzdsj) this.zzh.zzb(), (zzecl) this.zzi.zzb(), (zzfda) this.zzj.zzb());
    }
}
