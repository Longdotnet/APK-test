package com.google.android.gms.internal.ads;

import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class zzadu {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] zzc = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
    private static final int[] zzd = {64, 112, 128, 192, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};
    private static final int[] zze = {8000, 16000, 32000, 64000, 128000, 22050, 44100, 88200, 176400, 352800, 12000, 24000, 48000, 96000, 192000, 384000};
    private static final int[] zzf = {5, 8, 10, 12};
    private static final int[] zzg = {6, 9, 12, 15};
    private static final int[] zzh = {2, 4, 6, 8};
    private static final int[] zzi = {9, 11, 13, 16};
    private static final int[] zzj = {5, 8, 10, 12};

    public static int zza(byte[] bArr) {
        zzem zzemVarZzg = zzg(bArr);
        zzemVarZzg.zzn(42);
        return zzemVarZzg.zzd(true != zzemVarZzg.zzp() ? 8 : 12) + 1;
    }

    public static int zzb(byte[] bArr) {
        zzem zzemVarZzg = zzg(bArr);
        zzemVarZzg.zzn(32);
        return zzf(zzemVarZzg, zzj, true) + 1;
    }

    public static zzz zzc(byte[] bArr, String str, String str2, int i, String str3, zzs zzsVar) {
        zzem zzemVarZzg = zzg(bArr);
        zzemVarZzg.zzn(60);
        int i2 = zzb[zzemVarZzg.zzd(6)];
        int i3 = zzc[zzemVarZzg.zzd(4)];
        int iZzd = zzemVarZzg.zzd(5);
        int i4 = iZzd >= 29 ? -1 : (zzd[iZzd] * 1000) / 2;
        zzemVarZzg.zzn(10);
        int i5 = i2 + (zzemVarZzg.zzd(2) > 0 ? 1 : 0);
        zzx zzxVar = new zzx();
        zzxVar.zzS(str);
        zzxVar.zzG("video/mp2t");
        zzxVar.zzah("audio/vnd.dts");
        zzxVar.zzC(i4);
        zzxVar.zzD(i5);
        zzxVar.zzai(i3);
        zzxVar.zzL(null);
        zzxVar.zzW(str2);
        zzxVar.zzaf(i);
        return zzxVar.zzan();
    }

    public static zzads zzd(byte[] bArr) throws zzaz {
        int iZzd;
        int i;
        int iZzd2;
        long jZzu;
        int i2;
        zzem zzemVarZzg = zzg(bArr);
        zzemVarZzg.zzn(40);
        int iZzd3 = zzemVarZzg.zzd(2);
        boolean zZzp = zzemVarZzg.zzp();
        int i3 = true != zZzp ? 16 : 20;
        zzemVarZzg.zzn(true != zZzp ? 8 : 12);
        int iZzd4 = zzemVarZzg.zzd(i3) + 1;
        boolean zZzp2 = zzemVarZzg.zzp();
        int i4 = 0;
        if (zZzp2) {
            iZzd = zzemVarZzg.zzd(2);
            int iZzd5 = zzemVarZzg.zzd(3) + 1;
            if (zzemVarZzg.zzp()) {
                zzemVarZzg.zzn(36);
            }
            int iZzd6 = zzemVarZzg.zzd(3) + 1;
            int iZzd7 = zzemVarZzg.zzd(3) + 1;
            if (iZzd6 != 1 || iZzd7 != 1) {
                throw zzaz.zzc("Multiple audio presentations or assets not supported");
            }
            int i5 = iZzd3 + 1;
            int iZzd8 = zzemVarZzg.zzd(i5);
            for (int i6 = 0; i6 < i5; i6++) {
                if (((iZzd8 >> i6) & 1) == 1) {
                    zzemVarZzg.zzn(8);
                }
            }
            int i7 = iZzd5 * 512;
            if (zzemVarZzg.zzp()) {
                zzemVarZzg.zzn(2);
                int iZzd9 = (zzemVarZzg.zzd(2) + 1) << 2;
                int iZzd10 = zzemVarZzg.zzd(2) + 1;
                while (i4 < iZzd10) {
                    zzemVarZzg.zzn(iZzd9);
                    i4++;
                }
            }
            i4 = i7;
        } else {
            iZzd = -1;
        }
        zzemVarZzg.zzn(i3);
        zzemVarZzg.zzn(12);
        if (zZzp2) {
            if (zzemVarZzg.zzp()) {
                zzemVarZzg.zzn(4);
            }
            if (zzemVarZzg.zzp()) {
                zzemVarZzg.zzn(24);
            }
            if (zzemVarZzg.zzp()) {
                zzemVarZzg.zzo(zzemVarZzg.zzd(10) + 1);
            }
            zzemVarZzg.zzn(5);
            int i8 = zze[zzemVarZzg.zzd(4)];
            iZzd2 = zzemVarZzg.zzd(8) + 1;
            i = i8;
        } else {
            i = -2147483647;
            iZzd2 = -1;
        }
        if (zZzp2) {
            if (iZzd == 0) {
                i2 = 32000;
            } else if (iZzd == 1) {
                i2 = 44100;
            } else {
                if (iZzd != 2) {
                    throw zzaz.zza("Unsupported reference clock code in DTS HD header: " + iZzd, null);
                }
                i2 = 48000;
            }
            jZzu = zzex.zzu(i4, 1000000L, i2, RoundingMode.DOWN);
        } else {
            jZzu = -9223372036854775807L;
        }
        return new zzads("audio/vnd.dts.hd;profile=lbr", iZzd2, i, iZzd4, jZzu, 0, null);
    }

    public static zzads zze(byte[] bArr, AtomicInteger atomicInteger) throws zzaz {
        long jZzu;
        int iZzd;
        int i;
        int i2;
        zzem zzemVarZzg = zzg(bArr);
        int iZzd2 = zzemVarZzg.zzd(32);
        int iZzf = zzf(zzemVarZzg, zzf, true);
        int i3 = iZzf + 1;
        char c = iZzd2 == 1078008818 ? (char) 1 : (char) 0;
        if (c == 0) {
            jZzu = -9223372036854775807L;
            iZzd = -2147483647;
        } else {
            if (!zzemVarZzg.zzp()) {
                throw zzaz.zzc("Only supports full channel mask-based audio presentation");
            }
            int i4 = iZzf - 1;
            if (((bArr[iZzf] & 255) | ((char) (bArr[i4] << 8))) != zzex.zze(bArr, 0, i4, 65535)) {
                throw zzaz.zza("CRC check failed", null);
            }
            int iZzd3 = zzemVarZzg.zzd(2);
            if (iZzd3 == 0) {
                i = 512;
            } else if (iZzd3 == 1) {
                i = 480;
            } else {
                if (iZzd3 != 2) {
                    throw zzaz.zza("Unsupported base duration index in DTS UHD header: " + iZzd3, null);
                }
                i = 384;
            }
            int iZzd4 = zzemVarZzg.zzd(3) + 1;
            int iZzd5 = zzemVarZzg.zzd(2);
            if (iZzd5 == 0) {
                i2 = 32000;
            } else if (iZzd5 == 1) {
                i2 = 44100;
            } else {
                if (iZzd5 != 2) {
                    throw zzaz.zza("Unsupported clock rate index in DTS UHD header: " + iZzd5, null);
                }
                i2 = 48000;
            }
            if (zzemVarZzg.zzp()) {
                zzemVarZzg.zzn(36);
            }
            iZzd = (1 << zzemVarZzg.zzd(2)) * i2;
            jZzu = zzex.zzu(i * iZzd4, 1000000L, i2, RoundingMode.DOWN);
        }
        int i5 = iZzd;
        long j = jZzu;
        int iZzf2 = 0;
        for (char c2 = 0; c2 < c; c2 = 1) {
            iZzf2 += zzf(zzemVarZzg, zzg, true);
        }
        for (int i6 = 0; i6 <= 0; i6++) {
            if (c != 0) {
                atomicInteger.set(zzf(zzemVarZzg, zzh, true));
            }
            iZzf2 += atomicInteger.get() != 0 ? zzf(zzemVarZzg, zzi, true) : 0;
        }
        return new zzads("audio/vnd.dts.uhd;profile=p2", 2, i5, i3 + iZzf2, j, 0, null);
    }

    private static int zzf(zzem zzemVar, int[] iArr, boolean z) {
        int i = 0;
        for (int i2 = 0; i2 < 3 && zzemVar.zzp(); i2++) {
            i++;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            i3 += 1 << iArr[i4];
        }
        return zzemVar.zzd(iArr[i]) + i3;
    }

    private static zzem zzg(byte[] bArr) {
        byte b = bArr[0];
        if (b == 127 || b == 100 || b == 64 || b == 113) {
            return new zzem(bArr, bArr.length);
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        byte b2 = bArrCopyOf[0];
        if (b2 == -2 || b2 == -1 || b2 == 37 || b2 == -14 || b2 == -24) {
            for (int i = 0; i < bArrCopyOf.length - 1; i += 2) {
                byte b3 = bArrCopyOf[i];
                int i2 = i + 1;
                bArrCopyOf[i] = bArrCopyOf[i2];
                bArrCopyOf[i2] = b3;
            }
        }
        int length = bArrCopyOf.length;
        zzem zzemVar = new zzem(bArrCopyOf, length);
        if (bArrCopyOf[0] == 31) {
            zzem zzemVar2 = new zzem(bArrCopyOf, length);
            while (zzemVar2.zza() >= 16) {
                zzemVar2.zzn(2);
                zzemVar.zzg(zzemVar2.zzd(14), 14);
            }
        }
        zzemVar.zzk(bArrCopyOf, bArrCopyOf.length);
        return zzemVar;
    }
}
