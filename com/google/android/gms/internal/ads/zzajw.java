package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
final class zzajw implements zzakc {
    private final zzakb zza;
    private final long zzb;
    private final long zzc;
    private final zzakh zzd;
    private int zze;
    private long zzf;
    private long zzg;
    private long zzh;
    private long zzi;
    private long zzj;
    private long zzk;
    private long zzl;

    public zzajw(zzakh zzakhVar, long j, long j2, long j3, long j4, boolean z) {
        zzdd.zzd(j >= 0 && j2 > j);
        this.zzd = zzakhVar;
        this.zzb = j;
        this.zzc = j2;
        if (j3 == j2 - j || z) {
            this.zzf = j4;
            this.zze = 4;
        } else {
            this.zze = 0;
        }
        this.zza = new zzakb();
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001e  */
    @Override // com.google.android.gms.internal.ads.zzakc
    public final long zzd(zzadw zzadwVar) throws IOException {
        long jMax;
        int i = this.zze;
        if (i == 0) {
            long jZzf = zzadwVar.zzf();
            this.zzg = jZzf;
            this.zze = 1;
            long j = this.zzc - 65307;
            if (j > jZzf) {
                return j;
            }
        } else if (i != 1) {
            if (i == 2) {
                long j2 = this.zzi;
                long j3 = this.zzj;
                if (j2 == j3) {
                    jMax = -1;
                } else {
                    long jZzf2 = zzadwVar.zzf();
                    zzakb zzakbVar = this.zza;
                    if (zzakbVar.zzc(zzadwVar, j3)) {
                        zzakbVar.zzb(zzadwVar, false);
                        zzadwVar.zzj();
                        long j4 = this.zzh;
                        long j5 = zzakbVar.zzb;
                        long j6 = j4 - j5;
                        int i2 = zzakbVar.zzd + zzakbVar.zze;
                        if (j6 < 0 || j6 >= 72000) {
                            if (j6 < 0) {
                                this.zzj = jZzf2;
                                this.zzl = j5;
                            } else {
                                this.zzi = ((long) i2) + zzadwVar.zzf();
                                this.zzk = j5;
                            }
                            long j7 = this.zzj;
                            long j8 = this.zzi;
                            long j9 = j7 - j8;
                            if (j9 < 100000) {
                                this.zzj = j8;
                                jMax = j8;
                            } else {
                                long jZzf3 = zzadwVar.zzf() - (((long) i2) * (j6 <= 0 ? 2L : 1L));
                                String str = zzex.zza;
                                jMax = Math.max(j8, Math.min(((j6 * j9) / (this.zzl - this.zzk)) + jZzf3, j7 - 1));
                            }
                        } else {
                            jMax = -1;
                        }
                    } else {
                        jMax = this.zzi;
                        if (jMax == jZzf2) {
                            throw new IOException("No ogg page can be found.");
                        }
                    }
                }
                if (jMax != -1) {
                    return jMax;
                }
                this.zze = 3;
            } else if (i != 3) {
                return -1L;
            }
            while (true) {
                zzakb zzakbVar2 = this.zza;
                zzakbVar2.zzc(zzadwVar, -1L);
                zzakbVar2.zzb(zzadwVar, false);
                if (zzakbVar2.zzb > this.zzh) {
                    zzadwVar.zzj();
                    this.zze = 4;
                    return -(this.zzk + 2);
                }
                zzadwVar.zzk(zzakbVar2.zzd + zzakbVar2.zze);
                this.zzi = zzadwVar.zzf();
                this.zzk = zzakbVar2.zzb;
            }
        }
        zzakb zzakbVar3 = this.zza;
        zzakbVar3.zza();
        if (!zzakbVar3.zzc(zzadwVar, -1L)) {
            throw new EOFException();
        }
        zzakbVar3.zzb(zzadwVar, false);
        zzadwVar.zzk(zzakbVar3.zzd + zzakbVar3.zze);
        long j10 = zzakbVar3.zzb;
        while ((zzakbVar3.zza & 4) != 4 && zzakbVar3.zzc(zzadwVar, -1L) && zzadwVar.zzf() < this.zzc && zzakbVar3.zzb(zzadwVar, true) && zzadz.zzf(zzadwVar, zzakbVar3.zzd + zzakbVar3.zze)) {
            j10 = zzakbVar3.zzb;
        }
        this.zzf = j10;
        this.zze = 4;
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzakc
    public final /* bridge */ /* synthetic */ zzaeu zze() {
        zzajv zzajvVar = null;
        if (this.zzf != 0) {
            return new zzaju(this, zzajvVar);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzakc
    public final void zzg(long j) {
        long j2 = this.zzf - 1;
        String str = zzex.zza;
        this.zzh = Math.max(0L, Math.min(j, j2));
        this.zze = 2;
        this.zzi = this.zzb;
        this.zzj = this.zzc;
        this.zzk = 0L;
        this.zzl = this.zzf;
    }
}
