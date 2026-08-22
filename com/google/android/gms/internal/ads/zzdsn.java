package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: loaded from: classes.dex */
public final class zzdsn implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;
    private final zzhha zzc;

    private zzdsn(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
        this.zzc = zzhhaVar3;
    }

    public static zzdsn zza(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3) {
        return new zzdsn(zzhhaVar, zzhhaVar2, zzhhaVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdsm((zzdsd) this.zza.zzb(), ((zzhhd) this.zzb).zzb(), (Clock) this.zzc.zzb());
    }
}
