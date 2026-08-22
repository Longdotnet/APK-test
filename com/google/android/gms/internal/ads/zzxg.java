package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzxg implements zzwz {
    private final zzwz zza;
    private final long zzb;

    public zzxg(zzwz zzwzVar, long j) {
        this.zza = zzwzVar;
        this.zzb = j;
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final int zza(zzkv zzkvVar, zzhs zzhsVar, int i) {
        int iZza = this.zza.zza(zzkvVar, zzhsVar, i);
        if (iZza != -4) {
            return iZza;
        }
        zzhsVar.zze += this.zzb;
        return -4;
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final int zzb(long j) {
        return this.zza.zzb(j - this.zzb);
    }

    public final zzwz zzc() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void zzd() {
        this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final boolean zze() {
        return this.zza.zze();
    }
}
