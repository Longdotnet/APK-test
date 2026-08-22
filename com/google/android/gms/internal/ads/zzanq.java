package com.google.android.gms.internal.ads;

import com.google.protobuf.DescriptorProtos;

/* JADX INFO: loaded from: classes.dex */
final class zzanq {
    public static zzano zza(zzem zzemVar) throws zzaz {
        int iZzd;
        int i;
        char c;
        int i2;
        int iZzd2;
        char c2;
        int iZzd3 = zzemVar.zzd(8);
        int i3 = 5;
        int iZzd4 = zzemVar.zzd(5);
        if (iZzd4 != 31) {
            switch (iZzd4) {
                case 0:
                    iZzd = 96000;
                    break;
                case 1:
                    iZzd = 88200;
                    break;
                case 2:
                    iZzd = 64000;
                    break;
                case 3:
                    iZzd = 48000;
                    break;
                case 4:
                    iZzd = 44100;
                    break;
                case 5:
                    iZzd = 32000;
                    break;
                case 6:
                    iZzd = 24000;
                    break;
                case 7:
                    iZzd = 22050;
                    break;
                case 8:
                    iZzd = 16000;
                    break;
                case 9:
                    iZzd = 12000;
                    break;
                case 10:
                    iZzd = 11025;
                    break;
                case 11:
                    iZzd = 8000;
                    break;
                case 12:
                    iZzd = 7350;
                    break;
                case 13:
                case 14:
                default:
                    throw zzaz.zzc("Unsupported sampling rate index " + iZzd4);
                case 15:
                    iZzd = 57600;
                    break;
                case 16:
                    iZzd = 51200;
                    break;
                case 17:
                    iZzd = 40000;
                    break;
                case 18:
                    iZzd = 38400;
                    break;
                case 19:
                    iZzd = 34150;
                    break;
                case 20:
                    iZzd = 28800;
                    break;
                case 21:
                    iZzd = 25600;
                    break;
                case 22:
                    iZzd = 20000;
                    break;
                case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                    iZzd = 19200;
                    break;
                case 24:
                    iZzd = 17075;
                    break;
                case 25:
                    iZzd = 14400;
                    break;
                case 26:
                    iZzd = 12800;
                    break;
                case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                    iZzd = 9600;
                    break;
            }
        } else {
            iZzd = zzemVar.zzd(24);
        }
        int iZzd5 = zzemVar.zzd(3);
        int i4 = 1;
        if (iZzd5 == 0) {
            i = 768;
        } else if (iZzd5 == 1) {
            i = 1024;
        } else if (iZzd5 == 2 || iZzd5 == 3) {
            i = 2048;
        } else {
            if (iZzd5 != 4) {
                throw zzaz.zzc("Unsupported coreSbrFrameLengthIndex " + iZzd5);
            }
            i = 4096;
        }
        if (iZzd5 == 0 || iZzd5 == 1) {
            c = 0;
        } else if (iZzd5 == 2) {
            c = 2;
        } else if (iZzd5 == 3) {
            c = 3;
        } else {
            if (iZzd5 != 4) {
                throw zzaz.zzc("Unsupported coreSbrFrameLengthIndex " + iZzd5);
            }
            c = 1;
        }
        zzemVar.zzn(2);
        zze(zzemVar);
        int iZzd6 = zzemVar.zzd(5);
        int i5 = 0;
        int iZzc = 0;
        while (true) {
            int i6 = 16;
            if (i5 < iZzd6 + 1) {
                int iZzd7 = zzemVar.zzd(3);
                iZzc += zzc(zzemVar, 5, 8, 16) + 1;
                if ((iZzd7 == 0 || iZzd7 == 2) && zzemVar.zzp()) {
                    zze(zzemVar);
                }
                i5++;
            } else {
                int iZzc2 = zzc(zzemVar, 4, 8, 16) + 1;
                zzemVar.zzm();
                int i7 = 0;
                while (true) {
                    double d = 2.0d;
                    if (i7 >= iZzc2) {
                        int i8 = iZzd3;
                        byte[] bArr = null;
                        if (zzemVar.zzp()) {
                            int iZzc3 = zzc(zzemVar, 2, 4, 8) + 1;
                            for (int i9 = 0; i9 < iZzc3; i9++) {
                                int iZzc4 = zzc(zzemVar, 4, 8, 16);
                                int iZzc5 = zzc(zzemVar, 4, 8, 16);
                                if (iZzc4 == 7) {
                                    int iZzd8 = zzemVar.zzd(4) + 1;
                                    zzemVar.zzn(4);
                                    byte[] bArr2 = new byte[iZzd8];
                                    for (int i10 = 0; i10 < iZzd8; i10++) {
                                        bArr2[i10] = (byte) zzemVar.zzd(8);
                                    }
                                    bArr = bArr2;
                                } else {
                                    zzemVar.zzn(iZzc5 * 8);
                                }
                            }
                        }
                        byte[] bArr3 = bArr;
                        switch (iZzd) {
                            case 14700:
                            case 16000:
                                d = 3.0d;
                                break;
                            case 22050:
                            case 24000:
                                break;
                            case 29400:
                            case 32000:
                            case 58800:
                            case 64000:
                                d = 1.5d;
                                break;
                            case 44100:
                            case 48000:
                            case 88200:
                            case 96000:
                                d = 1.0d;
                                break;
                            default:
                                throw zzaz.zzc("Unsupported sampling rate " + iZzd);
                        }
                        return new zzano(i8, (int) (((double) iZzd) * d), (int) (((double) i) * d), bArr3, null);
                    }
                    int iZzd9 = zzemVar.zzd(2);
                    if (iZzd9 == 0) {
                        i2 = iZzd3;
                        zzf(zzemVar);
                        if (c > 0) {
                            zzd(zzemVar);
                        }
                    } else if (iZzd9 != i4) {
                        if (iZzd9 == 3) {
                            zzc(zzemVar, 4, 8, i6);
                            int iZzc6 = zzc(zzemVar, 4, 8, i6);
                            if (zzemVar.zzp()) {
                                zzc(zzemVar, 8, i6, 0);
                            }
                            zzemVar.zzm();
                            if (iZzc6 > 0) {
                                zzemVar.zzn(iZzc6 * 8);
                            }
                        }
                        i2 = iZzd3;
                    } else {
                        if (zzf(zzemVar)) {
                            zzemVar.zzm();
                        }
                        if (c > 0) {
                            zzd(zzemVar);
                            iZzd2 = zzemVar.zzd(2);
                            c2 = c;
                        } else {
                            iZzd2 = 0;
                            c2 = 0;
                        }
                        if (iZzd2 > 0) {
                            zzemVar.zzn(6);
                            int iZzd10 = zzemVar.zzd(2);
                            zzemVar.zzn(4);
                            if (zzemVar.zzp()) {
                                zzemVar.zzn(i3);
                            }
                            if (iZzd2 == 2 || iZzd2 == 3) {
                                zzemVar.zzn(6);
                            }
                            if (iZzd10 == 2) {
                                zzemVar.zzm();
                            }
                        }
                        i2 = iZzd3;
                        int iFloor = ((int) Math.floor(Math.log(iZzc - 1) / Math.log(2.0d))) + 1;
                        int iZzd11 = zzemVar.zzd(2);
                        if (iZzd11 > 0 && zzemVar.zzp()) {
                            zzemVar.zzn(iFloor);
                        }
                        if (zzemVar.zzp()) {
                            zzemVar.zzn(iFloor);
                        }
                        if (c2 == 0 && iZzd11 == 0) {
                            zzemVar.zzm();
                        }
                    }
                    i7++;
                    iZzd3 = i2;
                    i3 = 5;
                    i4 = 1;
                    i6 = 16;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0042  */
    public static boolean zzb(zzem zzemVar, zzann zzannVar) throws zzaz {
        long jZze;
        zzemVar.zzb();
        int iZzc = zzc(zzemVar, 3, 8, 8);
        zzannVar.zza = iZzc;
        if (iZzc == -1) {
            return false;
        }
        zzdd.zzd(Math.max(Math.max(2, 8), 32) <= 63);
        zzgbo.zza(zzgbo.zza(3L, 255L), 4294967296L);
        if (zzemVar.zza() < 2) {
            jZze = -1;
        } else {
            jZze = zzemVar.zze(2);
            if (jZze == 3) {
                if (zzemVar.zza() < 8) {
                    jZze = -1;
                } else {
                    long jZze2 = zzemVar.zze(8);
                    long j = 3 + jZze2;
                    if (jZze2 != 255) {
                        jZze = j;
                    } else if (zzemVar.zza() < 32) {
                        jZze = -1;
                    } else {
                        jZze = zzemVar.zze(32) + j;
                    }
                }
            }
        }
        zzannVar.zzb = jZze;
        if (jZze == -1) {
            return false;
        }
        if (jZze > 16) {
            throw zzaz.zzc("Contains sub-stream with an invalid packet label " + jZze);
        }
        if (jZze == 0) {
            int i = zzannVar.zza;
            if (i == 1) {
                throw zzaz.zza("Mpegh3daConfig packet with invalid packet label 0", null);
            }
            if (i == 2) {
                throw zzaz.zza("Mpegh3daFrame packet with invalid packet label 0", null);
            }
            if (i == 17) {
                throw zzaz.zza("AudioTruncation packet with invalid packet label 0", null);
            }
        }
        int iZzc2 = zzc(zzemVar, 11, 24, 24);
        zzannVar.zzc = iZzc2;
        return iZzc2 != -1;
    }

    private static int zzc(zzem zzemVar, int i, int i2, int i3) {
        zzdd.zzd(Math.max(Math.max(i, i2), i3) <= 31);
        int i4 = (1 << i) - 1;
        int i5 = (1 << i2) - 1;
        zzgbm.zza(zzgbm.zza(i4, i5), 1 << i3);
        if (zzemVar.zza() < i) {
            return -1;
        }
        int iZzd = zzemVar.zzd(i);
        if (iZzd != i4) {
            return iZzd;
        }
        if (zzemVar.zza() < i2) {
            return -1;
        }
        int iZzd2 = zzemVar.zzd(i2);
        int i6 = iZzd + iZzd2;
        if (iZzd2 != i5) {
            return i6;
        }
        if (zzemVar.zza() < i3) {
            return -1;
        }
        return i6 + zzemVar.zzd(i3);
    }

    private static void zzd(zzem zzemVar) {
        zzemVar.zzn(3);
        zzemVar.zzn(8);
        boolean zZzp = zzemVar.zzp();
        boolean zZzp2 = zzemVar.zzp();
        if (zZzp) {
            zzemVar.zzn(5);
        }
        if (zZzp2) {
            zzemVar.zzn(6);
        }
    }

    private static void zze(zzem zzemVar) {
        int iZzd;
        int iZzd2 = zzemVar.zzd(2);
        if (iZzd2 == 0) {
            zzemVar.zzn(6);
            return;
        }
        int iZzc = zzc(zzemVar, 5, 8, 16) + 1;
        if (iZzd2 == 1) {
            zzemVar.zzn(iZzc * 7);
            return;
        }
        if (iZzd2 == 2) {
            boolean zZzp = zzemVar.zzp();
            int i = true != zZzp ? 5 : 1;
            int i2 = true == zZzp ? 7 : 5;
            int i3 = true == zZzp ? 8 : 6;
            int i4 = 0;
            while (i4 < iZzc) {
                if (zzemVar.zzp()) {
                    zzemVar.zzn(7);
                    iZzd = 0;
                } else {
                    if (zzemVar.zzd(2) == 3 && zzemVar.zzd(i2) * i != 0) {
                        zzemVar.zzm();
                    }
                    iZzd = zzemVar.zzd(i3) * i;
                    if (iZzd != 0 && iZzd != 180) {
                        zzemVar.zzm();
                    }
                    zzemVar.zzm();
                }
                if (iZzd != 0 && iZzd != 180 && zzemVar.zzp()) {
                    i4++;
                }
                i4++;
            }
        }
    }

    private static boolean zzf(zzem zzemVar) {
        zzemVar.zzn(3);
        boolean zZzp = zzemVar.zzp();
        if (zZzp) {
            zzemVar.zzn(13);
        }
        return zZzp;
    }
}
