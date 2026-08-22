package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
final class zzabq {
    public static int zza(byte[] bArr, int i, zzabp zzabpVar) {
        int iZzj = zzj(bArr, i, zzabpVar);
        int i2 = zzabpVar.zza;
        if (i2 < 0) {
            throw zzadn.zzf();
        }
        if (i2 > bArr.length - iZzj) {
            throw zzadn.zzi();
        }
        if (i2 == 0) {
            zzabpVar.zzc = zzacc.zzb;
            return iZzj;
        }
        zzabpVar.zzc = zzacc.zzo(bArr, iZzj, i2);
        return iZzj + i2;
    }

    public static int zzb(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static int zzc(zzaew zzaewVar, byte[] bArr, int i, int i2, int i3, zzabp zzabpVar) {
        Object objZze = zzaewVar.zze();
        int iZzn = zzn(objZze, zzaewVar, bArr, i, i2, i3, zzabpVar);
        zzaewVar.zzf(objZze);
        zzabpVar.zzc = objZze;
        return iZzn;
    }

    public static int zzd(zzaew zzaewVar, byte[] bArr, int i, int i2, zzabp zzabpVar) {
        Object objZze = zzaewVar.zze();
        int iZzo = zzo(objZze, zzaewVar, bArr, i, i2, zzabpVar);
        zzaewVar.zzf(objZze);
        zzabpVar.zzc = objZze;
        return iZzo;
    }

    public static int zze(zzaew zzaewVar, int i, byte[] bArr, int i2, int i3, zzadk zzadkVar, zzabp zzabpVar) {
        int iZzd = zzd(zzaewVar, bArr, i2, i3, zzabpVar);
        zzadkVar.add(zzabpVar.zzc);
        while (iZzd < i3) {
            int iZzj = zzj(bArr, iZzd, zzabpVar);
            if (i != zzabpVar.zza) {
                break;
            }
            iZzd = zzd(zzaewVar, bArr, iZzj, i3, zzabpVar);
            zzadkVar.add(zzabpVar.zzc);
        }
        return iZzd;
    }

    public static int zzf(byte[] bArr, int i, zzadk zzadkVar, zzabp zzabpVar) {
        zzadg zzadgVar = (zzadg) zzadkVar;
        int iZzj = zzj(bArr, i, zzabpVar);
        int i2 = zzabpVar.zza + iZzj;
        while (iZzj < i2) {
            iZzj = zzj(bArr, iZzj, zzabpVar);
            zzadgVar.zzf(zzabpVar.zza);
        }
        if (iZzj == i2) {
            return iZzj;
        }
        throw zzadn.zzi();
    }

    public static int zzg(byte[] bArr, int i, zzabp zzabpVar) throws zzadn {
        int iZzj = zzj(bArr, i, zzabpVar);
        int i2 = zzabpVar.zza;
        if (i2 < 0) {
            throw zzadn.zzf();
        }
        if (i2 == 0) {
            zzabpVar.zzc = "";
            return iZzj;
        }
        zzabpVar.zzc = new String(bArr, iZzj, i2, zzadl.zzb);
        return iZzj + i2;
    }

    public static int zzh(byte[] bArr, int i, zzabp zzabpVar) throws zzadn {
        int iZzj = zzj(bArr, i, zzabpVar);
        int i2 = zzabpVar.zza;
        if (i2 < 0) {
            throw zzadn.zzf();
        }
        if (i2 == 0) {
            zzabpVar.zzc = "";
            return iZzj;
        }
        zzabpVar.zzc = zzagc.zzd(bArr, iZzj, i2);
        return iZzj + i2;
    }

    public static int zzi(int i, byte[] bArr, int i2, int i3, zzafo zzafoVar, zzabp zzabpVar) {
        if ((i >>> 3) == 0) {
            throw zzadn.zzc();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZzm = zzm(bArr, i2, zzabpVar);
            zzafoVar.zzj(i, Long.valueOf(zzabpVar.zzb));
            return iZzm;
        }
        if (i4 == 1) {
            zzafoVar.zzj(i, Long.valueOf(zzp(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZzj = zzj(bArr, i2, zzabpVar);
            int i5 = zzabpVar.zza;
            if (i5 < 0) {
                throw zzadn.zzf();
            }
            if (i5 > bArr.length - iZzj) {
                throw zzadn.zzi();
            }
            if (i5 == 0) {
                zzafoVar.zzj(i, zzacc.zzb);
            } else {
                zzafoVar.zzj(i, zzacc.zzo(bArr, iZzj, i5));
            }
            return iZzj + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw zzadn.zzc();
            }
            zzafoVar.zzj(i, Integer.valueOf(zzb(bArr, i2)));
            return i2 + 4;
        }
        int i6 = (i & (-8)) | 4;
        zzafo zzafoVarZzf = zzafo.zzf();
        int i7 = 0;
        while (i2 < i3) {
            int iZzj2 = zzj(bArr, i2, zzabpVar);
            int i8 = zzabpVar.zza;
            if (i8 == i6) {
                i7 = i8;
                i2 = iZzj2;
                break;
            }
            i7 = i8;
            i2 = zzi(i8, bArr, iZzj2, i3, zzafoVarZzf, zzabpVar);
        }
        if (i2 > i3 || i7 != i6) {
            throw zzadn.zzg();
        }
        zzafoVar.zzj(i, zzafoVarZzf);
        return i2;
    }

    public static int zzj(byte[] bArr, int i, zzabp zzabpVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzk(b, bArr, i2, zzabpVar);
        }
        zzabpVar.zza = b;
        return i2;
    }

    public static int zzk(int i, byte[] bArr, int i2, zzabp zzabpVar) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzabpVar.zza = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & 127) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzabpVar.zza = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & 127) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzabpVar.zza = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & 127) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzabpVar.zza = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzabpVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    public static int zzl(int i, byte[] bArr, int i2, int i3, zzadk zzadkVar, zzabp zzabpVar) {
        zzadg zzadgVar = (zzadg) zzadkVar;
        int iZzj = zzj(bArr, i2, zzabpVar);
        zzadgVar.zzf(zzabpVar.zza);
        while (iZzj < i3) {
            int iZzj2 = zzj(bArr, iZzj, zzabpVar);
            if (i != zzabpVar.zza) {
                break;
            }
            iZzj = zzj(bArr, iZzj2, zzabpVar);
            zzadgVar.zzf(zzabpVar.zza);
        }
        return iZzj;
    }

    public static int zzm(byte[] bArr, int i, zzabp zzabpVar) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            zzabpVar.zzb = j;
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
        zzabpVar.zzb = j2;
        return i3;
    }

    public static int zzn(Object obj, zzaew zzaewVar, byte[] bArr, int i, int i2, int i3, zzabp zzabpVar) {
        int iZzc = ((zzaen) zzaewVar).zzc(obj, bArr, i, i2, i3, zzabpVar);
        zzabpVar.zzc = obj;
        return iZzc;
    }

    public static int zzo(Object obj, zzaew zzaewVar, byte[] bArr, int i, int i2, zzabp zzabpVar) {
        int iZzk = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZzk = zzk(i3, bArr, iZzk, zzabpVar);
            i3 = zzabpVar.zza;
        }
        int i4 = iZzk;
        if (i3 < 0 || i3 > i2 - i4) {
            throw zzadn.zzi();
        }
        int i5 = i3 + i4;
        zzaewVar.zzi(obj, bArr, i4, i5, zzabpVar);
        zzabpVar.zzc = obj;
        return i5;
    }

    public static long zzp(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }
}
