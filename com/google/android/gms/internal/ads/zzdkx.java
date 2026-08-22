package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class zzdkx implements zzhgr {
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

    private zzdkx(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5, zzhha zzhhaVar6, zzhha zzhhaVar7, zzhha zzhhaVar8, zzhha zzhhaVar9, zzhha zzhhaVar10, zzhha zzhhaVar11) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
        this.zzc = zzhhaVar3;
        this.zzd = zzhhaVar4;
        this.zze = zzhhaVar5;
        this.zzf = zzhhaVar6;
        this.zzg = zzhhaVar7;
        this.zzh = zzhhaVar8;
        this.zzi = zzhhaVar9;
        this.zzj = zzhhaVar10;
        this.zzk = zzhhaVar11;
    }

    public static zzdkx zza(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5, zzhha zzhhaVar6, zzhha zzhhaVar7, zzhha zzhhaVar8, zzhha zzhhaVar9, zzhha zzhhaVar10, zzhha zzhhaVar11) {
        return new zzdkx(zzhhaVar, zzhhaVar2, zzhhaVar3, zzhhaVar4, zzhhaVar5, zzhhaVar6, zzhhaVar7, zzhhaVar8, zzhhaVar9, zzhhaVar10, zzhhaVar11);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdkw(((zzdla) this.zza).zzc(), ((zzdlb) this.zzb).zzc(), ((zzdlf) this.zzc).zza(), (zzcwq) this.zzd.zzb(), (zzcym) this.zze.zzb(), (zzcvw) this.zzf.zzb(), (zzdeb) this.zzg.zzb(), (Context) this.zzh.zzb(), ((zzcrr) this.zzi).zzc(), ((zzchz) this.zzj).zza(), ((zzcvp) this.zzk).zzc());
    }
}
