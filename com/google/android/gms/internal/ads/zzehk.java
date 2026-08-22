package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: loaded from: classes.dex */
public final class zzehk {
    private zzehb zza;

    public zzehk() {
    }

    public static zzehk zzb(zzehb zzehbVar) {
        return new zzehk(zzehbVar);
    }

    public final zzehb zza(Clock clock, zzehd zzehdVar, zzedr zzedrVar, zzfjy zzfjyVar) {
        zzehb zzehbVar = this.zza;
        return zzehbVar != null ? zzehbVar : new zzehb(clock, zzehdVar, zzedrVar, zzfjyVar);
    }

    private zzehk(zzehb zzehbVar) {
        this.zza = zzehbVar;
    }
}
