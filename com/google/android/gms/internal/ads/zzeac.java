package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
public final class zzeac implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;
    private final zzhha zzc;
    private final zzhha zzd;
    private final zzhha zze;

    private zzeac(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5, zzhha zzhhaVar6, zzhha zzhhaVar7, zzhha zzhhaVar8) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar4;
        this.zzc = zzhhaVar5;
        this.zzd = zzhhaVar6;
        this.zze = zzhhaVar8;
    }

    public static zzeac zza(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5, zzhha zzhhaVar6, zzhha zzhhaVar7, zzhha zzhhaVar8) {
        return new zzeac(zzhhaVar, zzhhaVar2, zzhhaVar3, zzhhaVar4, zzhhaVar5, zzhhaVar6, zzhhaVar7, zzhhaVar8);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzeab(((zzchl) this.zza).zza(), zzffu.zzc(), zzcij.zza(), ((zzchw) this.zzb).zzb(), ((zzeak) this.zzc).zzb(), (ArrayDeque) this.zzd.zzb(), zzcig.zza(), (zzfhx) this.zze.zzb());
    }
}
