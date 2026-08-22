package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: loaded from: classes.dex */
public final class zzdka implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzdka(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzdka zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzdka(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdjz(((zzdhu) this.zza).zzc(), (Clock) this.zzb.zzb());
    }
}
