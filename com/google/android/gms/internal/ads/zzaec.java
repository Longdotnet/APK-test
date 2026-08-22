package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzaec {
    public static int zza(zzen zzenVar, int i) {
        switch (i) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i - 2);
            case 6:
                return zzenVar.zzm() + 1;
            case 7:
                return zzenVar.zzq() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i - 8);
            default:
                return -1;
        }
    }

    public static long zzb(zzadw zzadwVar, zzaeg zzaegVar) throws zzaz {
        zzadwVar.zzj();
        zzadwVar.zzg(1);
        byte[] bArr = new byte[1];
        zzadwVar.zzh(bArr, 0, 1);
        int i = bArr[0] & 1;
        boolean z = 1 == i;
        zzadwVar.zzg(2);
        int i2 = 1 != i ? 6 : 7;
        zzen zzenVar = new zzen(i2);
        zzenVar.zzK(zzadz.zzb(zzadwVar, zzenVar.zzN(), 0, i2));
        zzadwVar.zzj();
        zzaeb zzaebVar = new zzaeb();
        if (zzd(zzenVar, zzaegVar, z, zzaebVar)) {
            return zzaebVar.zza;
        }
        throw zzaz.zza(null, null);
    }

    /* JADX WARN: Code duplicated, block: B:50:0x009b  */
    /* JADX WARN: Code duplicated, block: B:52:0x00ae A[RETURN] */
    public static boolean zzc(zzen zzenVar, zzaeg zzaegVar, int i, zzaeb zzaebVar) {
        int iZza;
        int iZzc = zzenVar.zzc();
        long jZzu = zzenVar.zzu();
        long j = jZzu >>> 16;
        if (j != i) {
            return false;
        }
        boolean z = (j & 1) == 1;
        long j2 = jZzu >> 12;
        long j3 = jZzu >> 8;
        long j4 = jZzu >> 4;
        long j5 = jZzu >> 1;
        long j6 = jZzu & 1;
        int i2 = (int) (j4 & 15);
        if (i2 > 7 ? !(i2 > 10 || zzaegVar.zzg != 2) : i2 == zzaegVar.zzg - 1) {
            int i3 = (int) (j5 & 7);
            if ((i3 == 0 || i3 == zzaegVar.zzi) && j6 != 1 && zzd(zzenVar, zzaegVar, z, zzaebVar) && (iZza = zza(zzenVar, (int) (j2 & 15))) != -1 && iZza <= zzaegVar.zzb) {
                int i4 = zzaegVar.zze;
                int i5 = (int) (j3 & 15);
                if (i5 != 0) {
                    if (i5 <= 11) {
                        if (i5 == zzaegVar.zzf) {
                            if (zzenVar.zzm() == zzex.zzg(zzenVar.zzN(), iZzc, zzenVar.zzc() - 1, 0)) {
                                return true;
                            }
                        }
                    } else if (i5 == 12) {
                        if (zzenVar.zzm() * 1000 == i4) {
                            if (zzenVar.zzm() == zzex.zzg(zzenVar.zzN(), iZzc, zzenVar.zzc() - 1, 0)) {
                                return true;
                            }
                        }
                    } else if (i5 <= 14) {
                        int iZzq = zzenVar.zzq();
                        if (i5 == 14) {
                            iZzq *= 10;
                        }
                        if (iZzq == i4) {
                            if (zzenVar.zzm() == zzex.zzg(zzenVar.zzN(), iZzc, zzenVar.zzc() - 1, 0)) {
                                return true;
                            }
                        }
                    }
                } else if (zzenVar.zzm() == zzex.zzg(zzenVar.zzN(), iZzc, zzenVar.zzc() - 1, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean zzd(zzen zzenVar, zzaeg zzaegVar, boolean z, zzaeb zzaebVar) {
        try {
            long jZzx = zzenVar.zzx();
            if (!z) {
                jZzx *= (long) zzaegVar.zzb;
            }
            zzaebVar.zza = jZzx;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }
}
