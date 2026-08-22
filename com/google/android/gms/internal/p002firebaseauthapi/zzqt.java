package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.InvalidKeyException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzqt {
    public static byte[] zza(byte[] bArr, byte[] bArr2) throws InvalidKeyException {
        if (bArr.length != 32) {
            throw new InvalidKeyException("Private key must have 32 bytes.");
        }
        long[] jArr = new long[11];
        byte[] bArrCopyOf = Arrays.copyOf(bArr, 32);
        int i = 0;
        bArrCopyOf[0] = (byte) (bArrCopyOf[0] & 248);
        int i2 = bArrCopyOf[31] & 127;
        bArrCopyOf[31] = (byte) i2;
        bArrCopyOf[31] = (byte) (i2 | 64);
        if (bArr2.length != 32) {
            throw new InvalidKeyException("Public key length is not 32-byte");
        }
        byte[] bArrCopyOf2 = Arrays.copyOf(bArr2, 32);
        bArrCopyOf2[31] = (byte) (bArrCopyOf2[31] & 127);
        for (int i3 = 0; i3 < 7; i3++) {
            byte[][] bArr3 = zzpr.zza;
            if (zzpp.zzb(bArr3[i3], bArrCopyOf2)) {
                throw new InvalidKeyException("Banned public key: ".concat(zzqj.zza(bArr3[i3])));
            }
        }
        long[] jArrZzk = zzqi.zzk(bArrCopyOf2);
        long[] jArr2 = new long[19];
        long[] jArr3 = new long[19];
        jArr3[0] = 1;
        long[] jArr4 = new long[19];
        jArr4[0] = 1;
        long[] jArr5 = new long[19];
        long[] jArr6 = new long[19];
        long[] jArr7 = new long[19];
        jArr7[0] = 1;
        long[] jArr8 = new long[19];
        long[] jArr9 = new long[19];
        jArr9[0] = 1;
        int i4 = 10;
        System.arraycopy(jArrZzk, 0, jArr2, 0, 10);
        while (i < 32) {
            int i5 = bArrCopyOf[31 - i] & 255;
            int i6 = 0;
            while (i6 < 8) {
                int i7 = (i5 >> (7 - i6)) & 1;
                zzpr.zza(jArr4, jArr2, i7);
                zzpr.zza(jArr5, jArr3, i7);
                byte[] bArr4 = bArrCopyOf;
                long[] jArrCopyOf = Arrays.copyOf(jArr4, 10);
                int i8 = i5;
                long[] jArr10 = new long[19];
                long[] jArr11 = jArr;
                long[] jArr12 = new long[19];
                int i9 = i;
                long[] jArr13 = new long[19];
                int i10 = i6;
                long[] jArr14 = new long[19];
                long[] jArr15 = new long[19];
                long[] jArr16 = jArr9;
                long[] jArr17 = new long[19];
                long[] jArr18 = new long[19];
                zzqi.zzi(jArr4, jArr4, jArr5);
                zzqi.zzh(jArr5, jArrCopyOf, jArr5);
                long[] jArrCopyOf2 = Arrays.copyOf(jArr2, 10);
                zzqi.zzi(jArr2, jArr2, jArr3);
                zzqi.zzh(jArr3, jArrCopyOf2, jArr3);
                zzqi.zzb(jArr14, jArr2, jArr5);
                zzqi.zzb(jArr15, jArr4, jArr3);
                zzqi.zze(jArr14);
                zzqi.zzd(jArr14);
                zzqi.zze(jArr15);
                zzqi.zzd(jArr15);
                long[] jArr19 = jArr2;
                System.arraycopy(jArr14, 0, jArrCopyOf2, 0, 10);
                zzqi.zzi(jArr14, jArr14, jArr15);
                zzqi.zzh(jArr15, jArrCopyOf2, jArr15);
                zzqi.zzg(jArr18, jArr14);
                zzqi.zzg(jArr17, jArr15);
                zzqi.zzb(jArr15, jArr17, jArrZzk);
                zzqi.zze(jArr15);
                zzqi.zzd(jArr15);
                System.arraycopy(jArr18, 0, jArr6, 0, 10);
                System.arraycopy(jArr15, 0, jArr7, 0, 10);
                zzqi.zzg(jArr12, jArr4);
                zzqi.zzg(jArr13, jArr5);
                zzqi.zzb(jArr8, jArr12, jArr13);
                zzqi.zze(jArr8);
                zzqi.zzd(jArr8);
                zzqi.zzh(jArr13, jArr12, jArr13);
                Arrays.fill(jArr10, 10, 18, 0L);
                zzqi.zzf(jArr10, jArr13, 121665L);
                zzqi.zzd(jArr10);
                zzqi.zzi(jArr10, jArr10, jArr12);
                zzqi.zzb(jArr16, jArr13, jArr10);
                zzqi.zze(jArr16);
                zzqi.zzd(jArr16);
                zzpr.zza(jArr8, jArr6, i7);
                zzpr.zza(jArr16, jArr7, i7);
                i6 = i10 + 1;
                jArr9 = jArr5;
                jArr2 = jArr6;
                i5 = i8;
                jArr = jArr11;
                i = i9;
                jArr6 = jArr19;
                jArr5 = jArr16;
                bArrCopyOf = bArr4;
                long[] jArr20 = jArr4;
                jArr4 = jArr8;
                jArr8 = jArr20;
                long[] jArr21 = jArr7;
                jArr7 = jArr3;
                jArr3 = jArr21;
            }
            i++;
            bArrCopyOf = bArrCopyOf;
            i4 = 10;
        }
        long[] jArr22 = jArr;
        int i11 = i4;
        long[] jArr23 = new long[i11];
        long[] jArr24 = new long[i11];
        long[] jArr25 = new long[i11];
        long[] jArr26 = new long[i11];
        long[] jArr27 = new long[i11];
        long[] jArr28 = new long[i11];
        long[] jArr29 = new long[i11];
        long[] jArr30 = new long[i11];
        long[] jArr31 = new long[i11];
        long[] jArr32 = new long[i11];
        long[] jArr33 = jArr2;
        long[] jArr34 = new long[i11];
        zzqi.zzg(jArr24, jArr5);
        zzqi.zzg(jArr34, jArr24);
        zzqi.zzg(jArr32, jArr34);
        zzqi.zza(jArr25, jArr32, jArr5);
        zzqi.zza(jArr26, jArr25, jArr24);
        zzqi.zzg(jArr32, jArr26);
        zzqi.zza(jArr27, jArr32, jArr25);
        zzqi.zzg(jArr32, jArr27);
        zzqi.zzg(jArr34, jArr32);
        zzqi.zzg(jArr32, jArr34);
        zzqi.zzg(jArr34, jArr32);
        zzqi.zzg(jArr32, jArr34);
        zzqi.zza(jArr28, jArr32, jArr27);
        zzqi.zzg(jArr32, jArr28);
        zzqi.zzg(jArr34, jArr32);
        for (int i12 = 2; i12 < 10; i12 += 2) {
            zzqi.zzg(jArr32, jArr34);
            zzqi.zzg(jArr34, jArr32);
        }
        zzqi.zza(jArr29, jArr34, jArr28);
        zzqi.zzg(jArr32, jArr29);
        zzqi.zzg(jArr34, jArr32);
        for (int i13 = 2; i13 < 20; i13 += 2) {
            zzqi.zzg(jArr32, jArr34);
            zzqi.zzg(jArr34, jArr32);
        }
        zzqi.zza(jArr32, jArr34, jArr29);
        zzqi.zzg(jArr34, jArr32);
        zzqi.zzg(jArr32, jArr34);
        for (int i14 = 2; i14 < 10; i14 += 2) {
            zzqi.zzg(jArr34, jArr32);
            zzqi.zzg(jArr32, jArr34);
        }
        zzqi.zza(jArr30, jArr32, jArr28);
        zzqi.zzg(jArr32, jArr30);
        zzqi.zzg(jArr34, jArr32);
        for (int i15 = 2; i15 < 50; i15 += 2) {
            zzqi.zzg(jArr32, jArr34);
            zzqi.zzg(jArr34, jArr32);
        }
        zzqi.zza(jArr31, jArr34, jArr30);
        zzqi.zzg(jArr34, jArr31);
        zzqi.zzg(jArr32, jArr34);
        for (int i16 = 2; i16 < 100; i16 += 2) {
            zzqi.zzg(jArr34, jArr32);
            zzqi.zzg(jArr32, jArr34);
        }
        zzqi.zza(jArr34, jArr32, jArr31);
        zzqi.zzg(jArr32, jArr34);
        zzqi.zzg(jArr34, jArr32);
        for (int i17 = 2; i17 < 50; i17 += 2) {
            zzqi.zzg(jArr32, jArr34);
            zzqi.zzg(jArr34, jArr32);
        }
        zzqi.zza(jArr32, jArr34, jArr30);
        zzqi.zzg(jArr34, jArr32);
        zzqi.zzg(jArr32, jArr34);
        zzqi.zzg(jArr34, jArr32);
        zzqi.zzg(jArr32, jArr34);
        zzqi.zzg(jArr34, jArr32);
        zzqi.zza(jArr23, jArr34, jArr26);
        zzqi.zza(jArr22, jArr4, jArr23);
        long[] jArr35 = new long[10];
        long[] jArr36 = new long[10];
        long[] jArr37 = new long[11];
        long[] jArr38 = new long[11];
        long[] jArr39 = new long[11];
        zzqi.zza(jArr35, jArrZzk, jArr22);
        zzqi.zzi(jArr36, jArrZzk, jArr22);
        long[] jArr40 = new long[10];
        jArr40[0] = 486662;
        zzqi.zzi(jArr38, jArr36, jArr40);
        zzqi.zza(jArr38, jArr38, jArr3);
        zzqi.zzi(jArr38, jArr38, jArr33);
        zzqi.zza(jArr38, jArr38, jArr35);
        zzqi.zza(jArr38, jArr38, jArr33);
        zzqi.zzf(jArr37, jArr38, 4L);
        zzqi.zzd(jArr37);
        zzqi.zza(jArr38, jArr35, jArr3);
        zzqi.zzh(jArr38, jArr38, jArr3);
        zzqi.zza(jArr39, jArr36, jArr33);
        zzqi.zzi(jArr38, jArr38, jArr39);
        zzqi.zzg(jArr38, jArr38);
        if (zzpp.zzb(zzqi.zzj(jArr37), zzqi.zzj(jArr38))) {
            return zzqi.zzj(jArr22);
        }
        throw new IllegalStateException("Arithmetic error in curve multiplication with the public key: ".concat(zzqj.zza(bArr2)));
    }

    public static byte[] zzb(byte[] bArr) throws InvalidKeyException {
        if (bArr.length != 32) {
            throw new InvalidKeyException("Private key must have 32 bytes.");
        }
        byte[] bArr2 = new byte[32];
        bArr2[0] = 9;
        return zza(bArr, bArr2);
    }
}
