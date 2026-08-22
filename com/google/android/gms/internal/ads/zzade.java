package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzade {
    public static final zzade zza = new zzade(-3, -9223372036854775807L, -1);
    private final int zzb;
    private final long zzc;
    private final long zzd;

    private zzade(int i, long j, long j2) {
        this.zzb = i;
        this.zzc = j;
        this.zzd = j2;
    }

    public static zzade zzd(long j, long j2) {
        return new zzade(-1, j, j2);
    }

    public static zzade zze(long j) {
        return new zzade(0, -9223372036854775807L, j);
    }

    public static zzade zzf(long j, long j2) {
        return new zzade(-2, j, j2);
    }
}
