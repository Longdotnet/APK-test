package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzgxo {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    public static int zza(byte[] bArr, int i, zzgxn zzgxnVar) throws zzgzw {
        int iZzh = zzh(bArr, i, zzgxnVar);
        int i2 = zzgxnVar.zza;
        if (i2 < 0) {
            throw new zzgzw("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i2 > bArr.length - iZzh) {
            throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (i2 == 0) {
            zzgxnVar.zzc = zzgxz.zzb;
            return iZzh;
        }
        zzgxnVar.zzc = zzgxz.zzv(bArr, iZzh, i2);
        return iZzh + i2;
    }

    public static int zzb(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    public static int zzc(zzhbl zzhblVar, byte[] bArr, int i, int i2, int i3, zzgxn zzgxnVar) throws zzgzw {
        Object objZze = zzhblVar.zze();
        int iZzl = zzl(objZze, zzhblVar, bArr, i, i2, i3, zzgxnVar);
        zzhblVar.zzf(objZze);
        zzgxnVar.zzc = objZze;
        return iZzl;
    }

    public static int zzd(zzhbl zzhblVar, byte[] bArr, int i, int i2, zzgxn zzgxnVar) throws zzgzw {
        Object objZze = zzhblVar.zze();
        int iZzm = zzm(objZze, zzhblVar, bArr, i, i2, zzgxnVar);
        zzhblVar.zzf(objZze);
        zzgxnVar.zzc = objZze;
        return iZzm;
    }

    public static int zze(zzhbl zzhblVar, int i, byte[] bArr, int i2, int i3, zzgzt zzgztVar, zzgxn zzgxnVar) throws zzgzw {
        int iZzd = zzd(zzhblVar, bArr, i2, i3, zzgxnVar);
        zzgztVar.add(zzgxnVar.zzc);
        while (iZzd < i3) {
            int iZzh = zzh(bArr, iZzd, zzgxnVar);
            if (i != zzgxnVar.zza) {
                break;
            }
            iZzd = zzd(zzhblVar, bArr, iZzh, i3, zzgxnVar);
            zzgztVar.add(zzgxnVar.zzc);
        }
        return iZzd;
    }

    public static int zzf(byte[] bArr, int i, zzgzt zzgztVar, zzgxn zzgxnVar) throws zzgzw {
        zzgzi zzgziVar = (zzgzi) zzgztVar;
        int iZzh = zzh(bArr, i, zzgxnVar);
        int i2 = zzgxnVar.zza + iZzh;
        while (iZzh < i2) {
            iZzh = zzh(bArr, iZzh, zzgxnVar);
            zzgziVar.zzi(zzgxnVar.zza);
        }
        if (iZzh == i2) {
            return iZzh;
        }
        throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static int zzg(int i, byte[] bArr, int i2, int i3, zzhby zzhbyVar, zzgxn zzgxnVar) throws zzgzw {
        if ((i >>> 3) == 0) {
            throw new zzgzw("Protocol message contained an invalid tag (zero).");
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZzk = zzk(bArr, i2, zzgxnVar);
            zzhbyVar.zzj(i, Long.valueOf(zzgxnVar.zzb));
            return iZzk;
        }
        if (i4 == 1) {
            zzhbyVar.zzj(i, Long.valueOf(zzn(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZzh = zzh(bArr, i2, zzgxnVar);
            int i5 = zzgxnVar.zza;
            if (i5 < 0) {
                throw new zzgzw("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i5 > bArr.length - iZzh) {
                throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i5 == 0) {
                zzhbyVar.zzj(i, zzgxz.zzb);
            } else {
                zzhbyVar.zzj(i, zzgxz.zzv(bArr, iZzh, i5));
            }
            return iZzh + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw new zzgzw("Protocol message contained an invalid tag (zero).");
            }
            zzhbyVar.zzj(i, Integer.valueOf(zzb(bArr, i2)));
            return i2 + 4;
        }
        int i6 = (i & (-8)) | 4;
        zzhby zzhbyVarZzf = zzhby.zzf();
        int i7 = zzgxnVar.zze + 1;
        zzgxnVar.zze = i7;
        zzo(i7);
        int i8 = 0;
        while (i2 < i3) {
            int iZzh2 = zzh(bArr, i2, zzgxnVar);
            i8 = zzgxnVar.zza;
            if (i8 == i6) {
                i2 = iZzh2;
                break;
            }
            i2 = zzg(i8, bArr, iZzh2, i3, zzhbyVarZzf, zzgxnVar);
        }
        zzgxnVar.zze--;
        if (i2 > i3 || i8 != i6) {
            throw new zzgzw("Failed to parse the message.");
        }
        zzhbyVar.zzj(i, zzhbyVarZzf);
        return i2;
    }

    public static int zzh(byte[] bArr, int i, zzgxn zzgxnVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzi(b, bArr, i2, zzgxnVar);
        }
        zzgxnVar.zza = b;
        return i2;
    }

    public static int zzi(int i, byte[] bArr, int i2, zzgxn zzgxnVar) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            zzgxnVar.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & 127) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzgxnVar.zza = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & 127) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzgxnVar.zza = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & 127) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzgxnVar.zza = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzgxnVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    public static int zzj(int i, byte[] bArr, int i2, int i3, zzgzt zzgztVar, zzgxn zzgxnVar) {
        zzgzi zzgziVar = (zzgzi) zzgztVar;
        int iZzh = zzh(bArr, i2, zzgxnVar);
        zzgziVar.zzi(zzgxnVar.zza);
        while (iZzh < i3) {
            int iZzh2 = zzh(bArr, iZzh, zzgxnVar);
            if (i != zzgxnVar.zza) {
                break;
            }
            iZzh = zzh(bArr, iZzh2, zzgxnVar);
            zzgziVar.zzi(zzgxnVar.zza);
        }
        return iZzh;
    }

    public static int zzk(byte[] bArr, int i, zzgxn zzgxnVar) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzgxnVar.zzb = j;
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
        zzgxnVar.zzb = j2;
        return i3;
    }

    public static int zzl(Object obj, zzhbl zzhblVar, byte[] bArr, int i, int i2, int i3, zzgxn zzgxnVar) throws zzgzw {
        zzhav zzhavVar = (zzhav) zzhblVar;
        int i4 = zzgxnVar.zze + 1;
        zzgxnVar.zze = i4;
        zzo(i4);
        int iZzc = zzhavVar.zzc(obj, bArr, i, i2, i3, zzgxnVar);
        zzgxnVar.zze--;
        zzgxnVar.zzc = obj;
        return iZzc;
    }

    public static int zzm(Object obj, zzhbl zzhblVar, byte[] bArr, int i, int i2, zzgxn zzgxnVar) throws zzgzw {
        int iZzi = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZzi = zzi(i3, bArr, iZzi, zzgxnVar);
            i3 = zzgxnVar.zza;
        }
        int i4 = iZzi;
        if (i3 < 0 || i3 > i2 - i4) {
            throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i5 = zzgxnVar.zze + 1;
        zzgxnVar.zze = i5;
        zzo(i5);
        int i6 = i3 + i4;
        zzhblVar.zzi(obj, bArr, i4, i6, zzgxnVar);
        zzgxnVar.zze--;
        zzgxnVar.zzc = obj;
        return i6;
    }

    public static long zzn(byte[] bArr, int i) {
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    private static void zzo(int i) throws zzgzw {
        if (i >= zzb) {
            throw new zzgzw("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
