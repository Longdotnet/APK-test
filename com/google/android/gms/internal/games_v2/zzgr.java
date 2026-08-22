package com.google.android.gms.internal.games_v2;

/* JADX INFO: loaded from: classes.dex */
final class zzgr extends zzgu {
    private static final zzgr zzb = new zzgr();

    private zzgr() {
        super("");
    }

    @Override // com.google.android.gms.internal.games_v2.zzgu
    public final int hashCode() {
        return System.identityHashCode(this);
    }

    public final String toString() {
        return "+∞";
    }

    @Override // com.google.android.gms.internal.games_v2.zzgu
    public final void zza(StringBuilder sb) {
        throw new AssertionError();
    }

    @Override // com.google.android.gms.internal.games_v2.zzgu
    public final void zzb(StringBuilder sb) {
        sb.append("+∞)");
    }

    @Override // com.google.android.gms.internal.games_v2.zzgu, java.lang.Comparable
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzgu zzguVar) {
        return zzguVar == this ? 0 : 1;
    }
}
