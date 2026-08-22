package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzaij implements zzaig {
    private final long zza;
    private final int zzb;
    private final long zzc;
    private final int zzd;
    private final long zze;
    private final long zzf;
    private final long[] zzg;

    private zzaij(long j, int i, long j2, int i2, long j3, long[] jArr) {
        this.zza = j;
        this.zzb = i;
        this.zzc = j2;
        this.zzd = i2;
        this.zze = j3;
        this.zzg = jArr;
        this.zzf = j3 != -1 ? j + j3 : -1L;
    }

    public static zzaij zzb(zzaii zzaiiVar, long j) {
        long jZza = zzaiiVar.zza();
        if (jZza == -9223372036854775807L) {
            return null;
        }
        zzaen zzaenVar = zzaiiVar.zza;
        return new zzaij(j, zzaenVar.zzc, jZza, zzaenVar.zzf, zzaiiVar.zzc, zzaiiVar.zzf);
    }

    private final long zzf(int i) {
        return (this.zzc * ((long) i)) / 100;
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzaig
    public final int zzc() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzaig
    public final long zzd() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzaig
    public final long zze(long j) {
        if (!zzh()) {
            return 0L;
        }
        long j2 = j - this.zza;
        if (j2 <= this.zzb) {
            return 0L;
        }
        long[] jArr = this.zzg;
        zzdd.zzb(jArr);
        double d = (j2 * 256.0d) / this.zze;
        int iZzd = zzex.zzd(jArr, (long) d, true, true);
        long jZzf = zzf(iZzd);
        long j3 = jArr[iZzd];
        int i = iZzd + 1;
        long jZzf2 = zzf(i);
        long j4 = iZzd == 99 ? 256L : jArr[i];
        return Math.round((j3 == j4 ? 0.0d : (d - j3) / (j4 - j3)) * (jZzf2 - jZzf)) + jZzf;
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final zzaes zzg(long j) {
        if (!zzh()) {
            zzaev zzaevVar = new zzaev(0L, this.zza + ((long) this.zzb));
            return new zzaes(zzaevVar, zzaevVar);
        }
        long j2 = this.zzc;
        String str = zzex.zza;
        long jMax = Math.max(0L, Math.min(j, j2));
        double d = (jMax * 100.0d) / j2;
        double d2 = 0.0d;
        if (d > 0.0d) {
            if (d >= 100.0d) {
                d2 = 256.0d;
            } else {
                int i = (int) d;
                long[] jArr = this.zzg;
                zzdd.zzb(jArr);
                double d3 = jArr[i];
                d2 = (((i == 99 ? 256.0d : jArr[i + 1]) - d3) * (d - ((double) i))) + d3;
            }
        }
        long j3 = this.zze;
        zzaev zzaevVar2 = new zzaev(jMax, this.zza + Math.max(this.zzb, Math.min(Math.round((d2 / 256.0d) * j3), j3 - 1)));
        return new zzaes(zzaevVar2, zzaevVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final boolean zzh() {
        return this.zzg != null;
    }
}
