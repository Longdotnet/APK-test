package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzwi implements zzwz {
    final /* synthetic */ zzwl zza;
    private final int zzb;

    public zzwi(zzwl zzwlVar, int i) {
        Objects.requireNonNull(zzwlVar);
        this.zza = zzwlVar;
        this.zzb = i;
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final int zza(zzkv zzkvVar, zzhs zzhsVar, int i) {
        return this.zza.zzj(this.zzb, zzkvVar, zzhsVar, i);
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final int zzb(long j) {
        return this.zza.zzl(this.zzb, j);
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void zzd() {
        this.zza.zzI(this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final boolean zze() {
        return this.zza.zzQ(this.zzb);
    }
}
