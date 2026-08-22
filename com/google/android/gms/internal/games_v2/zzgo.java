package com.google.android.gms.internal.games_v2;

/* JADX INFO: loaded from: classes.dex */
final class zzgo extends zzgq {
    public zzgo() {
        super(null);
    }

    @Override // com.google.android.gms.internal.games_v2.zzgq
    public final zzgq zza(Comparable comparable, Comparable comparable2) {
        int iCompareTo = comparable.compareTo(comparable2);
        if (iCompareTo < 0) {
            return zzgq.zzb;
        }
        return iCompareTo > 0 ? zzgq.zzc : zzgq.zza;
    }

    @Override // com.google.android.gms.internal.games_v2.zzgq
    public final int zzb() {
        return 0;
    }
}
