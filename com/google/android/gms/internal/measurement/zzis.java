package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
final class zzis {
    public static int zza(byte[] bArr, int i, zzir zzirVar) {
        int iZzj = zzj(bArr, i, zzirVar);
        int i2 = zzirVar.zza;
        if (i2 < 0) {
            throw zzkp.zzd();
        }
        if (i2 > bArr.length - iZzj) {
            throw zzkp.zzf();
        }
        if (i2 == 0) {
            zzirVar.zzc = zzje.zzb;
            return iZzj;
        }
        zzirVar.zzc = zzje.zzl(bArr, iZzj, i2);
        return iZzj + i2;
    }

    public static int zzb(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static int zzc(zzlx zzlxVar, byte[] bArr, int i, int i2, int i3, zzir zzirVar) {
        Object objZze = zzlxVar.zze();
        int iZzn = zzn(objZze, zzlxVar, bArr, i, i2, i3, zzirVar);
        zzlxVar.zzf(objZze);
        zzirVar.zzc = objZze;
        return iZzn;
    }

    public static int zzd(zzlx zzlxVar, byte[] bArr, int i, int i2, zzir zzirVar) {
        Object objZze = zzlxVar.zze();
        int iZzo = zzo(objZze, zzlxVar, bArr, i, i2, zzirVar);
        zzlxVar.zzf(objZze);
        zzirVar.zzc = objZze;
        return iZzo;
    }

    public static int zze(zzlx zzlxVar, int i, byte[] bArr, int i2, int i3, zzkm zzkmVar, zzir zzirVar) {
        int iZzd = zzd(zzlxVar, bArr, i2, i3, zzirVar);
        zzkmVar.add(zzirVar.zzc);
        while (iZzd < i3) {
            int iZzj = zzj(bArr, iZzd, zzirVar);
            if (i != zzirVar.zza) {
                break;
            }
            iZzd = zzd(zzlxVar, bArr, iZzj, i3, zzirVar);
            zzkmVar.add(zzirVar.zzc);
        }
        return iZzd;
    }

    public static int zzf(byte[] bArr, int i, zzkm zzkmVar, zzir zzirVar) {
        zzkg zzkgVar = (zzkg) zzkmVar;
        int iZzj = zzj(bArr, i, zzirVar);
        int i2 = zzirVar.zza + iZzj;
        while (iZzj < i2) {
            iZzj = zzj(bArr, iZzj, zzirVar);
            zzkgVar.zzh(zzirVar.zza);
        }
        if (iZzj == i2) {
            return iZzj;
        }
        throw zzkp.zzf();
    }

    public static int zzg(byte[] bArr, int i, zzir zzirVar) throws zzkp {
        int iZzj = zzj(bArr, i, zzirVar);
        int i2 = zzirVar.zza;
        if (i2 < 0) {
            throw zzkp.zzd();
        }
        if (i2 == 0) {
            zzirVar.zzc = "";
            return iZzj;
        }
        zzirVar.zzc = new String(bArr, iZzj, i2, zzkn.zzb);
        return iZzj + i2;
    }

    public static int zzh(byte[] bArr, int i, zzir zzirVar) throws zzkp {
        int iZzj = zzj(bArr, i, zzirVar);
        int i2 = zzirVar.zza;
        if (i2 < 0) {
            throw zzkp.zzd();
        }
        if (i2 == 0) {
            zzirVar.zzc = "";
            return iZzj;
        }
        zzirVar.zzc = zznd.zzd(bArr, iZzj, i2);
        return iZzj + i2;
    }

    public static int zzi(int i, byte[] bArr, int i2, int i3, zzmp zzmpVar, zzir zzirVar) {
        if ((i >>> 3) == 0) {
            throw zzkp.zzb();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZzm = zzm(bArr, i2, zzirVar);
            zzmpVar.zzj(i, Long.valueOf(zzirVar.zzb));
            return iZzm;
        }
        if (i4 == 1) {
            zzmpVar.zzj(i, Long.valueOf(zzp(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZzj = zzj(bArr, i2, zzirVar);
            int i5 = zzirVar.zza;
            if (i5 < 0) {
                throw zzkp.zzd();
            }
            if (i5 > bArr.length - iZzj) {
                throw zzkp.zzf();
            }
            if (i5 == 0) {
                zzmpVar.zzj(i, zzje.zzb);
            } else {
                zzmpVar.zzj(i, zzje.zzl(bArr, iZzj, i5));
            }
            return iZzj + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw zzkp.zzb();
            }
            zzmpVar.zzj(i, Integer.valueOf(zzb(bArr, i2)));
            return i2 + 4;
        }
        int i6 = (i & (-8)) | 4;
        zzmp zzmpVarZzf = zzmp.zzf();
        int i7 = 0;
        while (i2 < i3) {
            int iZzj2 = zzj(bArr, i2, zzirVar);
            int i8 = zzirVar.zza;
            if (i8 == i6) {
                i7 = i8;
                i2 = iZzj2;
                break;
            }
            i7 = i8;
            i2 = zzi(i8, bArr, iZzj2, i3, zzmpVarZzf, zzirVar);
        }
        if (i2 > i3 || i7 != i6) {
            throw zzkp.zze();
        }
        zzmpVar.zzj(i, zzmpVarZzf);
        return i2;
    }

    public static int zzj(byte[] bArr, int i, zzir zzirVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzk(b, bArr, i2, zzirVar);
        }
        zzirVar.zza = b;
        return i2;
    }

    public static int zzk(int i, byte[] bArr, int i2, zzir zzirVar) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzirVar.zza = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & 127) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzirVar.zza = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & 127) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzirVar.zza = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & 127) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzirVar.zza = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzirVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    public static int zzl(int i, byte[] bArr, int i2, int i3, zzkm zzkmVar, zzir zzirVar) {
        zzkg zzkgVar = (zzkg) zzkmVar;
        int iZzj = zzj(bArr, i2, zzirVar);
        zzkgVar.zzh(zzirVar.zza);
        while (iZzj < i3) {
            int iZzj2 = zzj(bArr, iZzj, zzirVar);
            if (i != zzirVar.zza) {
                break;
            }
            iZzj = zzj(bArr, iZzj2, zzirVar);
            zzkgVar.zzh(zzirVar.zza);
        }
        return iZzj;
    }

    public static int zzm(byte[] bArr, int i, zzir zzirVar) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            zzirVar.zzb = j;
            return i2;
        }
        int i3 = i + 2;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & 127)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & 127)) << i4;
            b = b2;
            i3 = i5;
        }
        zzirVar.zzb = j2;
        return i3;
    }

    public static int zzn(Object obj, zzlx zzlxVar, byte[] bArr, int i, int i2, int i3, zzir zzirVar) {
        int iZzc = ((zzlp) zzlxVar).zzc(obj, bArr, i, i2, i3, zzirVar);
        zzirVar.zzc = obj;
        return iZzc;
    }

    public static int zzo(Object obj, zzlx zzlxVar, byte[] bArr, int i, int i2, zzir zzirVar) {
        int iZzk = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZzk = zzk(i3, bArr, iZzk, zzirVar);
            i3 = zzirVar.zza;
        }
        int i4 = iZzk;
        if (i3 < 0 || i3 > i2 - i4) {
            throw zzkp.zzf();
        }
        int i5 = i3 + i4;
        zzlxVar.zzh(obj, bArr, i4, i5, zzirVar);
        zzirVar.zzc = obj;
        return i5;
    }

    public static long zzp(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }
}
