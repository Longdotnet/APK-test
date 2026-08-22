package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* JADX INFO: loaded from: classes.dex */
final class zzqq {
    private final zzqp zza;
    private final int zzb;
    private final zzqr zzc;
    private int zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private long zzh;
    private long zzi;

    public zzqq(AudioTrack audioTrack, zzqr zzqrVar) {
        this.zza = new zzqp(audioTrack);
        this.zzb = audioTrack.getSampleRate();
        this.zzc = zzqrVar;
        zzh(0);
    }

    private final long zzf(long j, float f) {
        zzqp zzqpVar = this.zza;
        return zzg(zzqpVar.zza(), zzqpVar.zzb(), j, f);
    }

    private final long zzg(long j, long j2, long j3, float f) {
        long j4 = j3 - j2;
        return zzex.zzq(j4, f) + zzex.zzt(j, this.zzb);
    }

    private final void zzh(int i) {
        this.zzd = i;
        long j = 10000;
        if (i == 0) {
            this.zzg = 0L;
            this.zzh = -1L;
            this.zzi = -9223372036854775807L;
            this.zze = System.nanoTime() / 1000;
        } else {
            if (i == 1) {
                this.zzf = 10000L;
                return;
            }
            j = (i == 2 || i == 3) ? 10000000L : 500000L;
        }
        this.zzf = j;
    }

    public final long zza(long j, float f) {
        return zzf(j, f);
    }

    public final void zzb(long j, float f, long j2) {
        if (j - this.zzg < this.zzf) {
            return;
        }
        this.zzg = j;
        zzqp zzqpVar = this.zza;
        boolean zZzc = zzqpVar.zzc();
        if (zZzc) {
            long jZzb = zzqpVar.zzb();
            long jZzf = zzf(j, f);
            if (Math.abs(jZzb - j) > 5000000) {
                this.zzc.zzd(zzqpVar.zza(), jZzb, j, j2);
                zzh(4);
            } else if (Math.abs(jZzf - j2) > 5000000) {
                this.zzc.zzc(zzqpVar.zza(), jZzb, j, j2);
                zzh(4);
            } else if (this.zzd == 4) {
                zzh(0);
            }
        }
        int i = this.zzd;
        if (i == 0) {
            if (!zZzc) {
                if (j - this.zze > 500000) {
                    zzh(3);
                    return;
                }
                return;
            } else {
                if (zzqpVar.zzb() >= this.zze) {
                    this.zzh = zzqpVar.zza();
                    this.zzi = zzqpVar.zzb();
                    zzh(1);
                    return;
                }
                return;
            }
        }
        if (i != 1) {
            if (i == 2) {
                if (zZzc) {
                    return;
                }
                zzh(0);
                return;
            } else {
                if (i == 3 && zZzc) {
                    zzh(0);
                    return;
                }
                return;
            }
        }
        if (!zZzc) {
            zzh(0);
            return;
        }
        long jZza = zzqpVar.zza();
        long j3 = this.zzh;
        if (jZza > j3) {
            if (Math.abs(zzf(j, f) - zzg(j3, this.zzi, j, f)) < 1000) {
                zzh(2);
                return;
            }
        }
        if (j - this.zze > 2000000) {
            zzh(3);
        } else {
            this.zzh = zzqpVar.zza();
            this.zzi = zzqpVar.zzb();
        }
    }

    public final void zzc() {
        zzh(0);
    }

    public final boolean zzd() {
        return this.zzd == 2;
    }

    public final boolean zze() {
        int i = this.zzd;
        return i == 0 || i == 1;
    }
}
