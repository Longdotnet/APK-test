package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public class zzadk implements zzaeu {
    private final long zza;
    private final long zzb;
    private final int zzc;
    private final long zzd;
    private final int zze;
    private final long zzf;

    public zzadk(long j, long j2, int i, int i2, boolean z) {
        long jZzc;
        this.zza = j;
        this.zzb = j2;
        this.zzc = i2 == -1 ? 1 : i2;
        this.zze = i;
        if (j == -1) {
            this.zzd = -1L;
            jZzc = -9223372036854775807L;
        } else {
            this.zzd = j - j2;
            jZzc = zzc(j, j2, i);
        }
        this.zzf = jZzc;
    }

    private static long zzc(long j, long j2, int i) {
        return (Math.max(0L, j - j2) * 8000000) / ((long) i);
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final long zza() {
        return this.zzf;
    }

    public final long zzb(long j) {
        return zzc(j, this.zzb, this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final zzaes zzg(long j) {
        long j2 = this.zzd;
        if (j2 == -1) {
            zzaev zzaevVar = new zzaev(0L, this.zzb);
            return new zzaes(zzaevVar, zzaevVar);
        }
        long j3 = ((long) this.zze) * j;
        long j4 = this.zzc;
        long jMin = ((j3 / 8000000) / j4) * j4;
        if (j2 != -1) {
            jMin = Math.min(jMin, j2 - j4);
        }
        long jMax = this.zzb + Math.max(jMin, 0L);
        long jZzb = zzb(jMax);
        zzaev zzaevVar2 = new zzaev(jZzb, jMax);
        if (j2 != -1 && jZzb < j) {
            long j5 = jMax + j4;
            if (j5 < this.zza) {
                return new zzaes(zzaevVar2, new zzaev(zzb(j5), j5));
            }
        }
        return new zzaes(zzaevVar2, zzaevVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final boolean zzh() {
        return this.zzd != -1;
    }
}
