package com.google.android.gms.internal.ads;

import com.google.firebase.inject.PVS.jIKWv;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class zzacy {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {2002, 2000, 1920, 1601, 1600, 1001, 1000, 960, 800, 800, 480, 400, 400, 2048};

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:140:0x01ea A[LOOP:1: B:139:0x01e8->B:140:0x01ea, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:156:0x0233  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c6 A[PHI: r1
  0x00c6: PHI (r1v61 int) = (r1v33 int), (r1v29 int) binds: [B:136:0x01df, B:43:0x00c2] A[DONT_GENERATE, DONT_INLINE]] */
    public static zzz zza(zzen zzenVar, String str, String str2, zzs zzsVar) throws zzaz {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        boolean zZzp;
        int iZzd;
        int iZzd2;
        int iZzd3;
        int iZza;
        boolean z;
        int i6;
        int i7;
        int i8;
        int iZzd4;
        int i9;
        zzem zzemVar = new zzem();
        zzemVar.zzj(zzenVar);
        int iZza2 = zzemVar.zza();
        int iZzd5 = zzemVar.zzd(3);
        if (iZzd5 > 1) {
            throw zzaz.zzc("Unsupported AC-4 DSI version: " + iZzd5);
        }
        int iZzd6 = zzemVar.zzd(7);
        int i10 = true != zzemVar.zzp() ? 44100 : 48000;
        zzemVar.zzn(4);
        int iZzd7 = zzemVar.zzd(9);
        if (iZzd6 > 1) {
            if (iZzd5 == 0) {
                throw zzaz.zzc("Invalid AC-4 DSI version: 0");
            }
            if (zzemVar.zzp()) {
                zzemVar.zzn(16);
                if (zzemVar.zzp()) {
                    zzemVar.zzn(128);
                }
            }
        }
        if (iZzd5 == 1) {
            if (!zzg(zzemVar)) {
                throw zzaz.zzc("Invalid AC-4 DSI bitrate.");
            }
            zzemVar.zzf();
        }
        zzacv zzacvVar = new zzacv(null);
        int i11 = 0;
        while (true) {
            if (i11 < iZzd7) {
                if (iZzd5 == 0) {
                    zZzp = zzemVar.zzp();
                    iZzd = zzemVar.zzd(5);
                    iZzd2 = zzemVar.zzd(5);
                    iZzd3 = 0;
                    iZza = 0;
                    z = false;
                } else {
                    int iZzd8 = zzemVar.zzd(8);
                    iZzd3 = zzemVar.zzd(8);
                    if (iZzd3 == 255) {
                        iZzd3 = zzemVar.zzd(16) + 255;
                    }
                    if (iZzd8 > 2) {
                        zzemVar.zzn(iZzd3 * 8);
                        i11++;
                    } else {
                        iZza = (iZza2 - zzemVar.zza()) / 8;
                        int iZzd9 = zzemVar.zzd(5);
                        z = iZzd9 == 31;
                        iZzd2 = iZzd8;
                        iZzd = iZzd9;
                        zZzp = false;
                    }
                }
                zzacvVar.zzf = iZzd2;
                if (zZzp || z || iZzd != 6) {
                    zzacvVar.zzg = zzemVar.zzd(3);
                    if (zzemVar.zzp()) {
                        zzemVar.zzn(5);
                    }
                    zzemVar.zzn(2);
                    if (iZzd5 == 1) {
                        if (iZzd2 == 1) {
                            zzemVar.zzn(2);
                        } else if (iZzd2 == 2) {
                            iZzd2 = 2;
                            zzemVar.zzn(2);
                        }
                    }
                    zzemVar.zzn(5);
                    zzemVar.zzn(10);
                    if (iZzd5 == 1) {
                        if (iZzd2 > 0) {
                            zzacvVar.zza = zzemVar.zzp();
                        }
                        if (zzacvVar.zza) {
                            if (iZzd2 != 1) {
                                if (iZzd2 == 2) {
                                    i8 = 2;
                                } else {
                                    i6 = 2;
                                    i8 = iZzd2;
                                }
                                zzemVar.zzn(24);
                                i7 = 1;
                            } else {
                                i8 = 1;
                            }
                            int iZzd10 = zzemVar.zzd(5);
                            if (iZzd10 >= 0 && iZzd10 <= 15) {
                                zzacvVar.zzb = iZzd10;
                            }
                            if (iZzd10 < 11 || iZzd10 > 14) {
                                i6 = 2;
                            } else {
                                zzacvVar.zzd = zzemVar.zzp();
                                i6 = 2;
                                zzacvVar.zze = zzemVar.zzd(2);
                            }
                            zzemVar.zzn(24);
                            i7 = 1;
                        } else {
                            i6 = 2;
                            i7 = 1;
                            i8 = iZzd2;
                        }
                        if (iZzd2 == i7 || iZzd2 == i6) {
                            if (zzemVar.zzp() && zzemVar.zzp()) {
                                zzemVar.zzn(i6);
                            }
                            if (zzemVar.zzp()) {
                                zzemVar.zzm();
                                int i12 = 8;
                                int iZzd11 = zzemVar.zzd(8);
                                int i13 = 0;
                                while (i13 < iZzd11) {
                                    zzemVar.zzn(i12);
                                    i13++;
                                    i12 = 8;
                                }
                            }
                        }
                        iZzd2 = i8;
                    }
                    if (!zZzp && !z) {
                        zzemVar.zzm();
                        if (iZzd == 0 || iZzd == 1 || iZzd == 2) {
                            if (iZzd2 == 0) {
                                for (int i14 = 0; i14 < 2; i14++) {
                                    zzd(zzemVar, zzacvVar);
                                }
                                iZzd2 = 0;
                            } else {
                                int i15 = 0;
                                for (int i16 = 2; i15 < i16; i16 = 2) {
                                    zze(zzemVar, zzacvVar);
                                    i15++;
                                }
                            }
                        } else if (iZzd == 3 || iZzd == 4) {
                            if (iZzd2 == 0) {
                                for (int i17 = 0; i17 < 3; i17++) {
                                    zzd(zzemVar, zzacvVar);
                                }
                                iZzd2 = 0;
                            } else {
                                int i18 = 0;
                                for (int i19 = 3; i18 < i19; i19 = 3) {
                                    zze(zzemVar, zzacvVar);
                                    i18++;
                                }
                            }
                        } else if (iZzd != 5) {
                            int iZzd12 = zzemVar.zzd(7);
                            for (int i20 = 0; i20 < iZzd12; i20++) {
                                zzemVar.zzn(8);
                            }
                        } else if (iZzd2 == 0) {
                            zzd(zzemVar, zzacvVar);
                            iZzd2 = 0;
                        } else {
                            int iZzd13 = zzemVar.zzd(3);
                            for (int i21 = 0; i21 < iZzd13 + 2; i21++) {
                                zze(zzemVar, zzacvVar);
                            }
                        }
                    } else if (iZzd2 == 0) {
                        zzd(zzemVar, zzacvVar);
                        iZzd2 = 0;
                    } else {
                        zze(zzemVar, zzacvVar);
                    }
                    zzemVar.zzm();
                    if (zzemVar.zzp()) {
                        i = 7;
                        iZzd4 = zzemVar.zzd(7);
                        for (i9 = 0; i9 < iZzd4; i9++) {
                            zzemVar.zzn(15);
                        }
                    } else {
                        i = 7;
                    }
                } else {
                    i = 7;
                    iZzd4 = zzemVar.zzd(7);
                    while (i9 < iZzd4) {
                        zzemVar.zzn(15);
                    }
                }
                if (iZzd2 <= 0) {
                    i4 = 5;
                } else {
                    if (zzemVar.zzp() && !zzg(zzemVar)) {
                        throw zzaz.zzc("Can't parse bitrate DSI.");
                    }
                    if (zzemVar.zzp()) {
                        zzemVar.zzf();
                        zzemVar.zzo(zzemVar.zzd(16));
                        i4 = 5;
                        int iZzd14 = zzemVar.zzd(5);
                        for (int i22 = 0; i22 < iZzd14; i22++) {
                            zzemVar.zzn(3);
                            zzemVar.zzn(8);
                        }
                    } else {
                        i4 = 5;
                    }
                }
                i3 = 8;
                zzemVar.zzf();
                if (iZzd5 == 1) {
                    int iZza3 = ((iZza2 - zzemVar.zza()) / 8) - iZza;
                    if (iZzd3 < iZza3) {
                        throw zzaz.zzc("pres_bytes is smaller than presentation bytes read.");
                    }
                    zzemVar.zzo(iZzd3 - iZza3);
                }
                if (zzacvVar.zza) {
                    i2 = -1;
                    if (zzacvVar.zzb == -1) {
                        throw zzaz.zzc(jIKWv.kwPxQccaeKXBjQm + i11);
                    }
                } else {
                    i2 = -1;
                }
            } else {
                i = 7;
                i2 = -1;
                i3 = 8;
                i4 = 5;
            }
            if (zzacvVar.zza) {
                int i23 = zzacvVar.zzb;
                boolean z2 = zzacvVar.zzd;
                int i24 = zzacvVar.zze;
                switch (i23) {
                    case 0:
                        i5 = 11;
                        i4 = 1;
                        break;
                    case 1:
                        i5 = 11;
                        i4 = 2;
                        break;
                    case 2:
                        i5 = 11;
                        i4 = 3;
                        break;
                    case 3:
                        i5 = 11;
                        break;
                    case 4:
                        i5 = 11;
                        i4 = 6;
                        break;
                    case 5:
                    case 7:
                    case 9:
                        i4 = i;
                        i5 = 11;
                        break;
                    case 6:
                    case 8:
                    case 10:
                        i4 = i3;
                        i5 = 11;
                        break;
                    case 11:
                        i5 = 11;
                        i4 = 11;
                        break;
                    case 12:
                        i4 = 12;
                        i5 = 11;
                        break;
                    case 13:
                        i4 = 13;
                        i5 = 11;
                        break;
                    case 14:
                        i5 = 11;
                        i4 = 14;
                        break;
                    case 15:
                        i5 = 11;
                        i4 = 24;
                        break;
                    default:
                        i4 = i2;
                        i5 = 11;
                        break;
                }
                if (i23 == i5 || i23 == 12 || i23 == 13 || i23 == 14) {
                    if (!z2) {
                        i4 -= 2;
                    }
                    if (i24 == 0) {
                        i4 -= 4;
                    } else if (i24 == 1) {
                        i4 -= 2;
                    }
                }
            } else {
                i4 = zzacvVar.zzc + 1;
                if (zzacvVar.zzg == 4 && i4 == 17) {
                    i4 = 21;
                }
            }
            if (i4 <= 0) {
                throw zzaz.zzc("Can't determine channel count of presentation.");
            }
            Object[] objArr = {Integer.valueOf(iZzd6), Integer.valueOf(zzacvVar.zzf), Integer.valueOf(zzacvVar.zzg)};
            String str3 = zzex.zza;
            String str4 = String.format(Locale.US, "ac-4.%02d.%02d.%02d", objArr);
            zzx zzxVar = new zzx();
            zzxVar.zzS(str);
            zzxVar.zzah("audio/ac4");
            zzxVar.zzD(i4);
            zzxVar.zzai(i10);
            zzxVar.zzL(zzsVar);
            zzxVar.zzW(str2);
            zzxVar.zzE(str4);
            return zzxVar.zzan();
        }
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0093  */
    /* JADX WARN: Code duplicated, block: B:49:0x009c  */
    public static zzacw zzb(zzem zzemVar) {
        int i;
        int i2;
        int i3;
        int iZzd;
        int iZzd2 = zzemVar.zzd(16);
        int iZzd3 = zzemVar.zzd(16);
        if (iZzd3 == 65535) {
            iZzd3 = zzemVar.zzd(24);
            i = 7;
        } else {
            i = 4;
        }
        int i4 = iZzd3 + i;
        if (iZzd2 == 44097) {
            i4 += 2;
        }
        int i5 = i4;
        int iZzd4 = zzemVar.zzd(2);
        int i6 = 0;
        if (iZzd4 == 3) {
            int i7 = 0;
            while (true) {
                iZzd = zzemVar.zzd(2) + i7;
                if (!zzemVar.zzp()) {
                    break;
                }
                i7 = (iZzd + 1) << 2;
            }
            i2 = iZzd + 3;
        } else {
            i2 = iZzd4;
        }
        int iZzd5 = zzemVar.zzd(10);
        if (zzemVar.zzp() && zzemVar.zzd(3) > 0) {
            zzemVar.zzn(2);
        }
        int i8 = true != zzemVar.zzp() ? 44100 : 48000;
        int iZzd6 = zzemVar.zzd(4);
        if (i8 == 44100 && iZzd6 == 13) {
            i3 = zzb[13];
        } else {
            if (i8 == 48000 && iZzd6 < 14) {
                i6 = zzb[iZzd6];
                int i9 = iZzd5 % 5;
                if (i9 == 1) {
                    if (iZzd6 != 3 || iZzd6 == 8) {
                        i6++;
                    }
                } else if (i9 != 2) {
                    if (i9 != 3) {
                        if (i9 == 4 && (iZzd6 == 3 || iZzd6 == 8 || iZzd6 == 11)) {
                            i6++;
                        }
                    } else if (iZzd6 != 3) {
                        i6++;
                    } else {
                        i6++;
                    }
                } else if (iZzd6 == 8 || iZzd6 == 11) {
                    i6++;
                }
            }
            i3 = i6;
        }
        return new zzacw(i2, 2, i8, i5, i3, null);
    }

    public static void zzc(int i, zzen zzenVar) {
        zzenVar.zzI(7);
        byte[] bArrZzN = zzenVar.zzN();
        bArrZzN[0] = -84;
        bArrZzN[1] = 64;
        bArrZzN[2] = -1;
        bArrZzN[3] = -1;
        bArrZzN[4] = (byte) ((i >> 16) & 255);
        bArrZzN[5] = (byte) ((i >> 8) & 255);
        bArrZzN[6] = (byte) (i & 255);
    }

    private static void zzd(zzem zzemVar, zzacv zzacvVar) throws zzaz {
        int iZzd = zzemVar.zzd(5);
        zzemVar.zzn(2);
        if (zzemVar.zzp()) {
            zzemVar.zzn(5);
        }
        if (iZzd >= 7 && iZzd <= 10) {
            zzemVar.zzm();
        }
        if (zzemVar.zzp()) {
            int iZzd2 = zzemVar.zzd(3);
            if (zzacvVar.zzb == -1 && iZzd >= 0 && iZzd <= 15 && (iZzd2 == 0 || iZzd2 == 1)) {
                zzacvVar.zzb = iZzd;
            }
            if (zzemVar.zzp()) {
                zzf(zzemVar);
            }
        }
    }

    private static void zze(zzem zzemVar, zzacv zzacvVar) throws zzaz {
        zzemVar.zzn(2);
        boolean zZzp = zzemVar.zzp();
        int iZzd = zzemVar.zzd(8);
        for (int i = 0; i < iZzd; i++) {
            zzemVar.zzn(2);
            if (zzemVar.zzp()) {
                zzemVar.zzn(5);
            }
            if (zZzp) {
                zzemVar.zzn(24);
            } else {
                if (zzemVar.zzp()) {
                    if (!zzemVar.zzp()) {
                        zzemVar.zzn(4);
                    }
                    zzacvVar.zzc = zzemVar.zzd(6) + 1;
                }
                zzemVar.zzn(4);
            }
        }
        if (zzemVar.zzp()) {
            zzemVar.zzn(3);
            if (zzemVar.zzp()) {
                zzf(zzemVar);
            }
        }
    }

    private static void zzf(zzem zzemVar) throws zzaz {
        int iZzd = zzemVar.zzd(6);
        if (iZzd < 2 || iZzd > 42) {
            throw zzaz.zzc(String.format("Invalid language tag bytes number: %d. Must be between 2 and 42.", Integer.valueOf(iZzd)));
        }
        zzemVar.zzn(iZzd * 8);
    }

    private static boolean zzg(zzem zzemVar) {
        if (zzemVar.zza() < 66) {
            return false;
        }
        zzemVar.zzn(66);
        return true;
    }
}
