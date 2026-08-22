package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public final class zzig {
    private final long zza;
    private final long zzb;
    private long zzc = -9223372036854775807L;
    private long zzd = -9223372036854775807L;
    private long zzf = -9223372036854775807L;
    private long zzg = -9223372036854775807L;
    private float zzj = 0.97f;
    private float zzi = 1.03f;
    private float zzk = 1.0f;
    private long zzl = -9223372036854775807L;
    private long zze = -9223372036854775807L;
    private long zzh = -9223372036854775807L;
    private long zzm = -9223372036854775807L;
    private long zzn = -9223372036854775807L;

    public /* synthetic */ zzig(float f, float f2, long j, float f3, long j2, long j3, float f4, zzif zzifVar) {
        this.zza = j2;
        this.zzb = j3;
    }

    private static long zzf(long j, long j2, float f) {
        return (long) ((j2 * 9.999871E-4f) + (j * 0.999f));
    }

    private final void zzg() {
        long j;
        long j2 = this.zzc;
        if (j2 != -9223372036854775807L) {
            j = this.zzd;
            if (j == -9223372036854775807L) {
                long j3 = this.zzf;
                if (j3 != -9223372036854775807L && j2 < j3) {
                    j2 = j3;
                }
                j = this.zzg;
                if (j == -9223372036854775807L || j2 <= j) {
                    j = j2;
                }
            }
        } else {
            j = -9223372036854775807L;
        }
        if (this.zze == j) {
            return;
        }
        this.zze = j;
        this.zzh = j;
        this.zzm = -9223372036854775807L;
        this.zzn = -9223372036854775807L;
        this.zzl = -9223372036854775807L;
    }

    public final float zza(long j, long j2) {
        long j3;
        if (this.zzc == -9223372036854775807L) {
            return 1.0f;
        }
        long j4 = j - j2;
        long j5 = this.zzm;
        if (j5 == -9223372036854775807L) {
            this.zzm = j4;
            this.zzn = 0L;
        } else {
            long jMax = Math.max(j4, zzf(j5, j4, 0.999f));
            this.zzm = jMax;
            this.zzn = zzf(this.zzn, Math.abs(j4 - jMax), 0.999f);
        }
        if (this.zzl != -9223372036854775807L && SystemClock.elapsedRealtime() - this.zzl < 1000) {
            return this.zzk;
        }
        this.zzl = SystemClock.elapsedRealtime();
        long j6 = (this.zzn * 3) + this.zzm;
        if (this.zzh > j6) {
            float fZzs = zzex.zzs(1000L);
            long[] jArr = {j6, this.zze, this.zzh - (((long) ((this.zzk - 1.0f) * fZzs)) + ((long) ((this.zzi - 1.0f) * fZzs)))};
            j3 = jArr[0];
            for (int i = 1; i < 3; i++) {
                long j7 = jArr[i];
                if (j7 > j3) {
                    j3 = j7;
                }
            }
            this.zzh = j3;
        } else {
            long jMax2 = j - ((long) (Math.max(0.0f, this.zzk - 1.0f) / 1.0E-7f));
            long j8 = this.zzh;
            String str = zzex.zza;
            long jMax3 = Math.max(j8, Math.min(jMax2, j6));
            this.zzh = jMax3;
            long j9 = this.zzg;
            if (j9 == -9223372036854775807L || jMax3 <= j9) {
                j3 = jMax3;
            } else {
                this.zzh = j9;
                j3 = j9;
            }
        }
        long j10 = j - j3;
        if (Math.abs(j10) < this.zza) {
            this.zzk = 1.0f;
            return 1.0f;
        }
        float fMax = Math.max(this.zzj, Math.min((j10 * 1.0E-7f) + 1.0f, this.zzi));
        this.zzk = fMax;
        return fMax;
    }

    public final long zzb() {
        return this.zzh;
    }

    public final void zzc() {
        long j = this.zzh;
        if (j == -9223372036854775807L) {
            return;
        }
        long j2 = j + this.zzb;
        this.zzh = j2;
        long j3 = this.zzg;
        if (j3 != -9223372036854775807L && j2 > j3) {
            this.zzh = j3;
        }
        this.zzl = -9223372036854775807L;
    }

    public final void zzd(zzaj zzajVar) {
        long j = zzajVar.zza;
        this.zzc = zzex.zzs(-9223372036854775807L);
        this.zzf = zzex.zzs(-9223372036854775807L);
        this.zzg = zzex.zzs(-9223372036854775807L);
        this.zzj = 0.97f;
        this.zzi = 1.03f;
        zzg();
    }

    public final void zze(long j) {
        this.zzd = j;
        zzg();
    }
}
