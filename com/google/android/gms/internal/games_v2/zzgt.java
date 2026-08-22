package com.google.android.gms.internal.games_v2;

/* JADX INFO: loaded from: classes.dex */
final class zzgt extends zzgu {
    private static final zzgt zzb = new zzgt();

    private zzgt() {
        super("");
    }

    @Override // com.google.android.gms.internal.games_v2.zzgu
    public final int hashCode() {
        return System.identityHashCode(this);
    }

    public final String toString() {
        return "-∞";
    }

    @Override // com.google.android.gms.internal.games_v2.zzgu
    public final void zza(StringBuilder sb) {
        sb.append("(-∞");
    }

    @Override // com.google.android.gms.internal.games_v2.zzgu
    public final void zzb(StringBuilder sb) {
        throw new AssertionError();
    }

    @Override // com.google.android.gms.internal.games_v2.zzgu, java.lang.Comparable
    /* JADX INFO: renamed from: zzc */
    public final int compareTo(zzgu zzguVar) {
        return zzguVar == this ? 0 : -1;
    }
}
