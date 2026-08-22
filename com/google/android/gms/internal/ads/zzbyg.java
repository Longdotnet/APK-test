package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: loaded from: classes.dex */
public final class zzbyg implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzbyg(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzbyg zzc(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzbyg(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzbyf zzb() {
        return new zzbyf((Clock) this.zza.zzb(), (zzbyd) this.zzb.zzb());
    }
}
