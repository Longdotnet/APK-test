package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzanx {
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private final zzeu zza = new zzeu(0);
    private long zzf = -9223372036854775807L;
    private long zzg = -9223372036854775807L;
    private long zzh = -9223372036854775807L;
    private final zzen zzb = new zzen();

    public static long zzc(zzen zzenVar) {
        int iZzc = zzenVar.zzc();
        if (zzenVar.zza() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        zzenVar.zzH(bArr, 0, 9);
        zzenVar.zzL(iZzc);
        byte b = bArr[0];
        if ((b & 196) != 68) {
            return -9223372036854775807L;
        }
        byte b2 = bArr[2];
        if ((b2 & 4) != 4) {
            return -9223372036854775807L;
        }
        byte b3 = bArr[4];
        if ((b3 & 4) != 4 || (bArr[5] & 1) != 1 || (bArr[8] & 3) != 3) {
            return -9223372036854775807L;
        }
        long j = b;
        long j2 = b2;
        long j3 = (248 & j2) >> 3;
        long j4 = (j2 & 3) << 13;
        return j4 | ((bArr[1] & 255) << 20) | ((j & 3) << 28) | (((j & 56) >> 3) << 30) | (j3 << 15) | ((((long) bArr[3]) & 255) << 5) | ((((long) b3) & 248) >> 3);
    }

    private final int zzf(zzadw zzadwVar) {
        byte[] bArr = zzex.zzb;
        int length = bArr.length;
        this.zzb.zzJ(bArr, 0);
        this.zzc = true;
        zzadwVar.zzj();
        return 0;
    }

    private static final int zzg(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public final int zza(zzadw zzadwVar, zzaer zzaerVar) {
        long j = -9223372036854775807L;
        if (!this.zze) {
            long jZzd = zzadwVar.zzd();
            int iMin = (int) Math.min(20000L, jZzd);
            long j2 = jZzd - ((long) iMin);
            if (zzadwVar.zzf() != j2) {
                zzaerVar.zza = j2;
                return 1;
            }
            zzen zzenVar = this.zzb;
            zzenVar.zzI(iMin);
            zzadwVar.zzj();
            zzadwVar.zzh(zzenVar.zzN(), 0, iMin);
            int iZzc = zzenVar.zzc();
            for (int iZzd = zzenVar.zzd() - 4; iZzd >= iZzc; iZzd--) {
                if (zzg(zzenVar.zzN(), iZzd) == 442) {
                    zzenVar.zzL(iZzd + 4);
                    long jZzc = zzc(zzenVar);
                    if (jZzc != -9223372036854775807L) {
                        j = jZzc;
                        break;
                    }
                }
            }
            this.zzg = j;
            this.zze = true;
        } else {
            if (this.zzg == -9223372036854775807L) {
                zzf(zzadwVar);
                return 0;
            }
            if (this.zzd) {
                long j3 = this.zzf;
                if (j3 == -9223372036854775807L) {
                    zzf(zzadwVar);
                    return 0;
                }
                zzeu zzeuVar = this.zza;
                this.zzh = zzeuVar.zzc(this.zzg) - zzeuVar.zzb(j3);
                zzf(zzadwVar);
                return 0;
            }
            int iMin2 = (int) Math.min(20000L, zzadwVar.zzd());
            if (zzadwVar.zzf() != 0) {
                zzaerVar.zza = 0L;
                return 1;
            }
            zzen zzenVar2 = this.zzb;
            zzenVar2.zzI(iMin2);
            zzadwVar.zzj();
            zzadwVar.zzh(zzenVar2.zzN(), 0, iMin2);
            int iZzd2 = zzenVar2.zzd();
            for (int iZzc2 = zzenVar2.zzc(); iZzc2 < iZzd2 - 3; iZzc2++) {
                if (zzg(zzenVar2.zzN(), iZzc2) == 442) {
                    zzenVar2.zzL(iZzc2 + 4);
                    long jZzc2 = zzc(zzenVar2);
                    if (jZzc2 != -9223372036854775807L) {
                        j = jZzc2;
                        break;
                    }
                }
            }
            this.zzf = j;
            this.zzd = true;
        }
        return 0;
    }

    public final long zzb() {
        return this.zzh;
    }

    public final zzeu zzd() {
        return this.zza;
    }

    public final boolean zze() {
        return this.zzc;
    }
}
