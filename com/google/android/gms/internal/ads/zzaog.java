package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzaog {
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private final zzeu zza = new zzeu(0);
    private long zzf = -9223372036854775807L;
    private long zzg = -9223372036854775807L;
    private long zzh = -9223372036854775807L;
    private final zzen zzb = new zzen();

    public zzaog(int i) {
    }

    private final int zze(zzadw zzadwVar) {
        byte[] bArr = zzex.zzb;
        int length = bArr.length;
        this.zzb.zzJ(bArr, 0);
        this.zzc = true;
        zzadwVar.zzj();
        return 0;
    }

    public final int zza(zzadw zzadwVar, zzaer zzaerVar, int i) {
        if (i <= 0) {
            zze(zzadwVar);
            return 0;
        }
        long j = -9223372036854775807L;
        if (!this.zze) {
            long jZzd = zzadwVar.zzd();
            int iMin = (int) Math.min(112800L, jZzd);
            long j2 = jZzd - ((long) iMin);
            if (zzadwVar.zzf() == j2) {
                zzen zzenVar = this.zzb;
                zzenVar.zzI(iMin);
                zzadwVar.zzj();
                zzadwVar.zzh(zzenVar.zzN(), 0, iMin);
                int iZzc = zzenVar.zzc();
                int iZzd = zzenVar.zzd();
                for (int i2 = iZzd - 188; i2 >= iZzc; i2--) {
                    byte[] bArrZzN = zzenVar.zzN();
                    int i3 = 0;
                    for (int i4 = -4; i4 <= 4; i4++) {
                        int i5 = (i4 * 188) + i2;
                        if (i5 >= iZzc && i5 < iZzd && bArrZzN[i5] == 71) {
                            i3++;
                            if (i3 == 5) {
                                long jZzb = zzaop.zzb(zzenVar, i2, i);
                                if (jZzb == -9223372036854775807L) {
                                    break;
                                }
                                j = jZzb;
                                break;
                            }
                        } else {
                            i3 = 0;
                        }
                    }
                }
                this.zzg = j;
                this.zze = true;
                return 0;
            }
            zzaerVar.zza = j2;
        } else {
            if (this.zzg == -9223372036854775807L) {
                zze(zzadwVar);
                return 0;
            }
            if (this.zzd) {
                long j3 = this.zzf;
                if (j3 == -9223372036854775807L) {
                    zze(zzadwVar);
                    return 0;
                }
                zzeu zzeuVar = this.zza;
                this.zzh = zzeuVar.zzc(this.zzg) - zzeuVar.zzb(j3);
                zze(zzadwVar);
                return 0;
            }
            int iMin2 = (int) Math.min(112800L, zzadwVar.zzd());
            if (zzadwVar.zzf() == 0) {
                zzen zzenVar2 = this.zzb;
                zzenVar2.zzI(iMin2);
                zzadwVar.zzj();
                zzadwVar.zzh(zzenVar2.zzN(), 0, iMin2);
                int iZzd2 = zzenVar2.zzd();
                for (int iZzc2 = zzenVar2.zzc(); iZzc2 < iZzd2; iZzc2++) {
                    if (zzenVar2.zzN()[iZzc2] == 71) {
                        long jZzb2 = zzaop.zzb(zzenVar2, iZzc2, i);
                        if (jZzb2 != -9223372036854775807L) {
                            j = jZzb2;
                            break;
                        }
                    }
                }
                this.zzf = j;
                this.zzd = true;
                return 0;
            }
            zzaerVar.zza = 0L;
        }
        return 1;
    }

    public final long zzb() {
        return this.zzh;
    }

    public final zzeu zzc() {
        return this.zza;
    }

    public final boolean zzd() {
        return this.zzc;
    }
}
