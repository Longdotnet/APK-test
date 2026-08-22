package com.google.android.gms.internal.ads;

import java.math.RoundingMode;

/* JADX INFO: loaded from: classes.dex */
final class zzaoz implements zzaeu {
    private final zzaow zza;
    private final int zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;

    public zzaoz(zzaow zzaowVar, int i, long j, long j2) {
        this.zza = zzaowVar;
        this.zzb = i;
        this.zzc = j;
        long j3 = (j2 - j) / ((long) zzaowVar.zzd);
        this.zzd = j3;
        this.zze = zzb(j3);
    }

    private final long zzb(long j) {
        return zzex.zzu(j * ((long) this.zzb), 1000000L, this.zza.zzc, RoundingMode.DOWN);
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final long zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final zzaes zzg(long j) {
        long j2 = this.zzb;
        zzaow zzaowVar = this.zza;
        long j3 = (((long) zzaowVar.zzc) * j) / (j2 * 1000000);
        String str = zzex.zza;
        long j4 = this.zzd - 1;
        long jMax = Math.max(0L, Math.min(j3, j4));
        long j5 = zzaowVar.zzd;
        long jZzb = zzb(jMax);
        long j6 = this.zzc;
        zzaev zzaevVar = new zzaev(jZzb, (jMax * j5) + j6);
        if (jZzb >= j || jMax == j4) {
            return new zzaes(zzaevVar, zzaevVar);
        }
        long j7 = jMax + 1;
        return new zzaes(zzaevVar, new zzaev(zzb(j7), (j5 * j7) + j6));
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final boolean zzh() {
        return true;
    }
}
