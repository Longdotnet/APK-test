package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class zzdpl implements zzhgr {
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

    private zzdpl(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5, zzhha zzhhaVar6, zzhha zzhhaVar7, zzhha zzhhaVar8, zzhha zzhhaVar9, zzhha zzhhaVar10, zzhha zzhhaVar11) {
        this.zza = zzhhaVar2;
        this.zzb = zzhhaVar3;
        this.zzc = zzhhaVar4;
        this.zzd = zzhhaVar5;
        this.zze = zzhhaVar6;
        this.zzf = zzhhaVar7;
        this.zzg = zzhhaVar8;
        this.zzh = zzhhaVar9;
        this.zzi = zzhhaVar10;
        this.zzj = zzhhaVar11;
    }

    public static zzdpl zza(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5, zzhha zzhhaVar6, zzhha zzhhaVar7, zzhha zzhhaVar8, zzhha zzhhaVar9, zzhha zzhhaVar10, zzhha zzhhaVar11) {
        return new zzdpl(zzhhaVar, zzhhaVar2, zzhhaVar3, zzhhaVar4, zzhhaVar5, zzhhaVar6, zzhhaVar7, zzhhaVar8, zzhhaVar9, zzhhaVar10, zzhhaVar11);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdpj(zzckm.zza(), (Context) this.zza.zzb(), (zzavu) this.zzb.zzb(), (zzbel) this.zzc.zzb(), ((zzchz) this.zzd).zza(), ((zzcju) this.zze).zza(), (zzbcc) this.zzf.zzb(), (zzcyv) this.zzg.zzb(), (zzecl) this.zzh.zzb(), (zzfda) this.zzi.zzb(), (zzdsj) this.zzj.zzb());
    }
}
