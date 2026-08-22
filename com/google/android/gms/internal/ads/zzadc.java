package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzadc {
    private final long zza;
    private final long zzb;
    private final long zzc;
    private long zzd = 0;
    private long zze;
    private long zzf;
    private long zzg;
    private long zzh;

    public zzadc(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        this.zza = j;
        this.zzb = j2;
        this.zze = j4;
        this.zzf = j5;
        this.zzg = j6;
        this.zzc = j7;
        this.zzh = zzf(j2, 0L, j4, j5, j6, j7);
    }

    public static long zzf(long j, long j2, long j3, long j4, long j5, long j6) {
        if (j4 + 1 >= j5 || 1 + j2 >= j3) {
            return j4;
        }
        long j7 = (long) (((j5 - j4) / (j3 - j2)) * (j - j2));
        String str = zzex.zza;
        return Math.max(j4, Math.min(((j4 + j7) - j6) - (j7 / 20), j5 - 1));
    }

    public static /* bridge */ /* synthetic */ void zzg(zzadc zzadcVar, long j, long j2) {
        zzadcVar.zze = j;
        zzadcVar.zzg = j2;
        zzadcVar.zzi();
    }

    public static /* bridge */ /* synthetic */ void zzh(zzadc zzadcVar, long j, long j2) {
        zzadcVar.zzd = j;
        zzadcVar.zzf = j2;
        zzadcVar.zzi();
    }

    private final void zzi() {
        this.zzh = zzf(this.zzb, this.zzd, this.zze, this.zzf, this.zzg, this.zzc);
    }
}
