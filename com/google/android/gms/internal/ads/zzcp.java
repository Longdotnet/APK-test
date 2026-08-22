package com.google.android.gms.internal.ads;

import java.nio.ShortBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class zzcp {
    private final int zza;
    private final int zzb;
    private final float zzc;
    private final float zzd;
    private final float zze;
    private final int zzf;
    private final int zzg;
    private final int zzh;
    private final short[] zzi;
    private short[] zzj;
    private int zzk;
    private short[] zzl;
    private int zzm;
    private short[] zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private int zzt;
    private int zzu;
    private int zzv;
    private double zzw;

    public zzcp(int i, int i2, float f, float f2, int i3) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = f;
        this.zzd = f2;
        this.zze = i / i3;
        this.zzf = i / 400;
        int i4 = i / 65;
        this.zzg = i4;
        int i5 = i4 + i4;
        this.zzh = i5;
        this.zzi = new short[i5];
        int i6 = i5 * i2;
        this.zzj = new short[i6];
        this.zzl = new short[i6];
        this.zzn = new short[i6];
    }

    private final int zzg(short[] sArr, int i, int i2, int i3) {
        int i4 = 1;
        int i5 = 255;
        int i6 = 0;
        int i7 = 0;
        while (i2 <= i3) {
            int iAbs = 0;
            for (int i8 = 0; i8 < i2; i8++) {
                int i9 = this.zzb * i;
                iAbs += Math.abs(sArr[i9 + i8] - sArr[(i9 + i2) + i8]);
            }
            int i10 = iAbs * i6;
            int i11 = i4 * i2;
            if (i10 < i11) {
                i4 = iAbs;
            }
            if (i10 < i11) {
                i6 = i2;
            }
            int i12 = iAbs * i5;
            int i13 = i7 * i2;
            if (i12 > i13) {
                i7 = iAbs;
            }
            if (i12 > i13) {
                i5 = i2;
            }
            i2++;
        }
        this.zzu = i4 / i6;
        this.zzv = i7 / i5;
        return i6;
    }

    private final void zzh(short[] sArr, int i, int i2) {
        short[] sArrZzl = zzl(this.zzl, this.zzm, i2);
        this.zzl = sArrZzl;
        int i3 = this.zzm;
        int i4 = this.zzb;
        System.arraycopy(sArr, i * i4, sArrZzl, i3 * i4, i2 * i4);
        this.zzm += i2;
    }

    private final void zzi(short[] sArr, int i, int i2) {
        int i3;
        for (int i4 = 0; i4 < this.zzh / i2; i4++) {
            int i5 = 0;
            int i6 = 0;
            while (true) {
                int i7 = this.zzb;
                i3 = i7 * i2;
                if (i5 < i3) {
                    i6 += sArr[(i3 * i4) + (i7 * i) + i5];
                    i5++;
                }
            }
            this.zzi[i4] = (short) (i6 / i3);
        }
    }

    private static void zzj(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i4 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i3 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i9] = (short) (((sArr3[i8] * i10) + ((i - i10) * sArr2[i7])) / i);
                i9 += i2;
                i7 += i2;
                i8 += i2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0082  */
    /* JADX WARN: Code duplicated, block: B:30:0x008a  */
    /* JADX WARN: Code duplicated, block: B:34:0x0090  */
    /* JADX WARN: Code duplicated, block: B:36:0x0094  */
    /* JADX WARN: Code duplicated, block: B:38:0x009a  */
    /* JADX WARN: Code duplicated, block: B:39:0x00a2  */
    private final void zzk() {
        short[] sArr;
        int i;
        int i2;
        int iZzg;
        int iZzg2;
        int i3;
        int i4;
        int i5;
        int iRound;
        int i6;
        int i7;
        int i8;
        float f;
        int i9;
        int i10;
        int i11;
        int i12;
        long j;
        long j2;
        float f2 = this.zzc;
        float f3 = this.zzd;
        double d = f2 / f3;
        int i13 = this.zzm;
        int i14 = 0;
        int i15 = 1;
        if (d > 1.0000100135803223d || d < 0.9999899864196777d) {
            int i16 = this.zzk;
            int i17 = this.zzh;
            if (i16 >= i17) {
                int i18 = 0;
                while (true) {
                    int i19 = this.zzr;
                    if (i19 > 0) {
                        int iMin = Math.min(i17, i19);
                        zzh(this.zzj, i18, iMin);
                        this.zzr -= iMin;
                        i18 += iMin;
                        d = d;
                        i13 = i13;
                    } else {
                        short[] sArr2 = this.zzj;
                        int i20 = this.zza;
                        int i21 = i20 > 4000 ? i20 / 4000 : i15;
                        int i22 = this.zzb;
                        if (i22 != i15) {
                            zzi(sArr2, i18, i21);
                            sArr = this.zzi;
                            i = this.zzf;
                            i2 = this.zzg;
                            iZzg = zzg(sArr, i14, i / i21, i2 / i21);
                            if (i21 != 1) {
                                int i23 = iZzg * i21;
                                int i24 = i21 * 4;
                                i4 = i23 - i24;
                                if (i4 >= i) {
                                    i = i4;
                                }
                                i5 = i23 + i24;
                                if (i5 <= i2) {
                                    i2 = i5;
                                }
                                if (i22 == 1) {
                                    iZzg2 = zzg(sArr2, i18, i, i2);
                                } else {
                                    zzi(sArr2, i18, 1);
                                    iZzg2 = zzg(sArr, i14, i, i2);
                                }
                            } else {
                                iZzg2 = iZzg;
                            }
                            i3 = i22;
                        } else if (i21 == i15) {
                            iZzg2 = zzg(sArr2, i18, this.zzf, this.zzg);
                            i3 = i15;
                        } else {
                            i22 = i15;
                            zzi(sArr2, i18, i21);
                            sArr = this.zzi;
                            i = this.zzf;
                            i2 = this.zzg;
                            iZzg = zzg(sArr, i14, i / i21, i2 / i21);
                            if (i21 != 1) {
                                int i25 = iZzg * i21;
                                int i26 = i21 * 4;
                                i4 = i25 - i26;
                                if (i4 >= i) {
                                    i = i4;
                                }
                                i5 = i25 + i26;
                                if (i5 <= i2) {
                                    i2 = i5;
                                }
                                if (i22 == 1) {
                                    iZzg2 = zzg(sArr2, i18, i, i2);
                                } else {
                                    zzi(sArr2, i18, 1);
                                    iZzg2 = zzg(sArr, i14, i, i2);
                                }
                            } else {
                                iZzg2 = iZzg;
                            }
                            i3 = i22;
                        }
                        int i27 = this.zzu;
                        int i28 = (i27 == 0 || (i8 = this.zzs) == 0 || this.zzv > i27 * 3 || i27 + i27 <= this.zzt * 3) ? iZzg2 : i8;
                        int i29 = i18 + i28;
                        this.zzt = i27;
                        this.zzs = iZzg2;
                        double d2 = i28;
                        if (d > 1.0d) {
                            short[] sArr3 = this.zzj;
                            double d3 = d - 1.0d;
                            if (d >= 2.0d) {
                                double d4 = (d2 / d3) + this.zzw;
                                int iRound2 = (int) Math.round(d4);
                                this.zzw = d4 - ((double) iRound2);
                                i6 = i28;
                                i7 = iRound2;
                            } else {
                                i6 = i28;
                                double d5 = ((d2 * (2.0d - d)) / d3) + this.zzw;
                                int iRound3 = (int) Math.round(d5);
                                this.zzr = iRound3;
                                this.zzw = d5 - ((double) iRound3);
                                i7 = i6;
                            }
                            short[] sArrZzl = zzl(this.zzl, this.zzm, i7);
                            this.zzl = sArrZzl;
                            zzj(i7, i3, sArrZzl, this.zzm, sArr3, i18, sArr3, i29);
                            this.zzm += i7;
                            d = d;
                            i18 = i6 + i7 + i18;
                        } else {
                            int i30 = i28;
                            int i31 = i18;
                            short[] sArr4 = this.zzj;
                            double d6 = 1.0d - d;
                            if (d < 0.5d) {
                                double d7 = ((d2 * d) / d6) + this.zzw;
                                iRound = (int) Math.round(d7);
                                this.zzw = d7 - ((double) iRound);
                            } else {
                                double d8 = ((d2 * ((d + d) - 1.0d)) / d6) + this.zzw;
                                int iRound4 = (int) Math.round(d8);
                                this.zzr = iRound4;
                                this.zzw = d8 - ((double) iRound4);
                                iRound = i30;
                            }
                            int i32 = i30 + iRound;
                            short[] sArrZzl2 = zzl(this.zzl, this.zzm, i32);
                            this.zzl = sArrZzl2;
                            System.arraycopy(sArr4, i31 * i3, sArrZzl2, this.zzm * i3, i30 * i3);
                            zzj(iRound, i3, this.zzl, this.zzm + i30, sArr4, i29, sArr4, i31);
                            this.zzm += i32;
                            i18 = i31 + iRound;
                        }
                    }
                    if (i18 + i17 > i16) {
                        break;
                    }
                    i13 = i13;
                    d = d;
                    i14 = 0;
                    i15 = 1;
                }
                int i33 = this.zzk - i18;
                short[] sArr5 = this.zzj;
                int i34 = this.zzb;
                System.arraycopy(sArr5, i18 * i34, sArr5, 0, i34 * i33);
                this.zzk = i33;
            }
            f = this.zze * f3;
            if (f != 1.0f || this.zzm == (i9 = i13)) {
            }
            int i35 = this.zza;
            float f4 = i35 / f;
            long j3 = i35;
            long j4 = (long) f4;
            while (j4 != 0 && j3 != 0 && j4 % 2 == 0 && j3 % 2 == 0) {
                j4 /= 2;
                j3 /= 2;
            }
            int i36 = this.zzm - i9;
            short[] sArrZzl3 = zzl(this.zzn, this.zzo, i36);
            this.zzn = sArrZzl3;
            short[] sArr6 = this.zzl;
            int i37 = this.zzb;
            System.arraycopy(sArr6, i9 * i37, sArrZzl3, this.zzo * i37, i36 * i37);
            this.zzm = i9;
            this.zzo += i36;
            int i38 = 0;
            while (true) {
                i10 = this.zzo;
                i11 = i10 - 1;
                if (i38 >= i11) {
                    break;
                }
                while (true) {
                    i12 = this.zzp + 1;
                    j = i12;
                    long j5 = j * j4;
                    j2 = this.zzq;
                    if (j5 <= j2 * j3) {
                        break;
                    }
                    this.zzl = zzl(this.zzl, this.zzm, 1);
                    int i39 = 0;
                    while (i39 < i37) {
                        short[] sArr7 = this.zzl;
                        int i40 = this.zzm * i37;
                        short[] sArr8 = this.zzn;
                        int i41 = (i38 * i37) + i39;
                        short s = sArr8[i41];
                        short s2 = sArr8[i41 + i37];
                        long j6 = ((long) this.zzq) * j3;
                        int i42 = this.zzp;
                        long j7 = j3;
                        int i43 = i39;
                        long j8 = ((long) (i42 + 1)) * j4;
                        long j9 = j8 - (((long) i42) * j4);
                        long j10 = j8 - j6;
                        sArr7[i40 + i43] = (short) ((((j9 - j10) * ((long) s2)) + (j10 * ((long) s))) / j9);
                        i39 = i43 + 1;
                        j3 = j7;
                        i37 = i37;
                    }
                    this.zzq++;
                    this.zzm++;
                    j3 = j3;
                    i37 = i37;
                }
                long j11 = j3;
                int i44 = i37;
                this.zzp = i12;
                if (j == j11) {
                    this.zzp = 0;
                    zzdd.zzf(j2 == j4);
                    this.zzq = 0;
                }
                i38++;
                j3 = j11;
                i37 = i44;
            }
            int i45 = i37;
            if (i11 != 0) {
                short[] sArr9 = this.zzn;
                System.arraycopy(sArr9, i11 * i45, sArr9, 0, (i10 - i11) * i45);
                this.zzo -= i11;
                return;
            }
            return;
        }
        zzh(this.zzj, 0, this.zzk);
        this.zzk = 0;
        i13 = i13;
        f = this.zze * f3;
        if (f != 1.0f) {
        }
    }

    private final short[] zzl(short[] sArr, int i, int i2) {
        int length = sArr.length;
        int i3 = this.zzb;
        int i4 = length / i3;
        return i + i2 <= i4 ? sArr : Arrays.copyOf(sArr, (((i4 * 3) / 2) + i2) * i3);
    }

    public final int zza() {
        zzdd.zzf(this.zzm >= 0);
        int i = this.zzm * this.zzb;
        return i + i;
    }

    public final int zzb() {
        int i = this.zzk * this.zzb;
        return i + i;
    }

    public final void zzc() {
        this.zzk = 0;
        this.zzm = 0;
        this.zzo = 0;
        this.zzp = 0;
        this.zzq = 0;
        this.zzr = 0;
        this.zzs = 0;
        this.zzt = 0;
        this.zzu = 0;
        this.zzv = 0;
        this.zzw = 0.0d;
    }

    public final void zzd(ShortBuffer shortBuffer) {
        zzdd.zzf(this.zzm >= 0);
        int iRemaining = shortBuffer.remaining();
        int i = this.zzb;
        int iMin = Math.min(iRemaining / i, this.zzm);
        int i2 = iMin * i;
        shortBuffer.put(this.zzl, 0, i2);
        int i3 = this.zzm - iMin;
        this.zzm = i3;
        short[] sArr = this.zzl;
        System.arraycopy(sArr, i2, sArr, 0, i3 * i);
    }

    public final void zze() {
        int i = this.zzk;
        int i2 = this.zzr;
        int i3 = this.zzm;
        float f = this.zzc;
        float f2 = this.zzd;
        int i4 = i3 + ((int) ((((((((double) (i - i2)) / ((double) (f / f2))) + ((double) i2)) + this.zzw) + ((double) this.zzo)) / ((double) (this.zze * f2))) + 0.5d));
        this.zzw = 0.0d;
        int i5 = this.zzh;
        int i6 = i5 + i5;
        this.zzj = zzl(this.zzj, i, i + i6);
        int i7 = 0;
        while (true) {
            int i8 = this.zzb;
            if (i7 >= i6 * i8) {
                break;
            }
            this.zzj[(i8 * i) + i7] = 0;
            i7++;
        }
        this.zzk += i6;
        zzk();
        if (this.zzm > i4) {
            this.zzm = Math.max(i4, 0);
        }
        this.zzk = 0;
        this.zzr = 0;
        this.zzo = 0;
    }

    public final void zzf(ShortBuffer shortBuffer) {
        int iRemaining = shortBuffer.remaining();
        int i = this.zzb;
        int i2 = iRemaining / i;
        int i3 = i2 * i;
        short[] sArrZzl = zzl(this.zzj, this.zzk, i2);
        this.zzj = sArrZzl;
        shortBuffer.get(sArrZzl, this.zzk * i, (i3 + i3) / 2);
        this.zzk += i2;
        zzk();
    }
}
