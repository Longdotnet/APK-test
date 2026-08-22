package com.google.android.gms.internal.ads;

import java.math.RoundingMode;

/* JADX INFO: loaded from: classes.dex */
public final class zzgbj {
    public static final /* synthetic */ int zza = 0;

    static {
        Math.log(2.0d);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0067  */
    /* JADX WARN: Code duplicated, block: B:33:? A[RETURN, SYNTHETIC] */
    public static int zza(double d, RoundingMode roundingMode) {
        boolean zZzd;
        boolean z = false;
        zzfvp.zzf(d > 0.0d && zzgbk.zzb(d), "x must be positive and finite");
        int exponent = Math.getExponent(d);
        if (Math.getExponent(d) < -1022) {
            return zza(d * 4.503599627370496E15d, roundingMode) - 52;
        }
        switch (zzgbi.zza[roundingMode.ordinal()]) {
            case 1:
                zzgbp.zzb(zzd(d));
                return exponent;
            case 2:
                return exponent;
            case 3:
                z = !zzd(d);
                if (z) {
                    return exponent + 1;
                }
                return exponent;
            case 4:
                z = exponent < 0;
                zZzd = zzd(d);
                z &= !zZzd;
                if (z) {
                    return exponent + 1;
                }
                return exponent;
            case 5:
                z = exponent >= 0;
                zZzd = zzd(d);
                z &= !zZzd;
                if (z) {
                    return exponent + 1;
                }
                return exponent;
            case 6:
            case 7:
            case 8:
                double dLongBitsToDouble = Double.longBitsToDouble((Double.doubleToRawLongBits(d) & 4503599627370495L) | 4607182418800017408L);
                if (dLongBitsToDouble * dLongBitsToDouble > 2.0d) {
                    z = true;
                }
                if (z) {
                    return exponent + 1;
                }
                return exponent;
            default:
                throw new AssertionError();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:37:0x007e  */
    /* JADX WARN: Code duplicated, block: B:40:0x0089  */
    /* JADX WARN: Code duplicated, block: B:41:0x008b  */
    /* JADX WARN: Code duplicated, block: B:45:0x0093  */
    /* JADX WARN: Code duplicated, block: B:48:0x0097  */
    /* JADX WARN: Code duplicated, block: B:50:0x0099  */
    /* JADX WARN: Instruction removed from duplicated block: B:50:0x0099, please report this as an issue */
    public static long zzb(double d, RoundingMode roundingMode) {
        double dRint;
        long j;
        long j2;
        boolean z;
        if (!zzgbk.zzb(d)) {
            throw new ArithmeticException("input is infinite or NaN");
        }
        switch (zzgbi.zza[roundingMode.ordinal()]) {
            case 1:
                zzgbp.zzb(zzc(d));
                dRint = d;
                if ((-9.223372036854776E18d) - dRint < 1.0d) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && (dRint < 9.223372036854776E18d)) {
                    return (long) dRint;
                }
                throw new ArithmeticException("rounded value is out of range for input " + d + " and rounding mode " + String.valueOf(roundingMode));
            case 2:
                if (d >= 0.0d || zzc(d)) {
                    dRint = d;
                } else {
                    j = (long) d;
                    j2 = -1;
                    dRint = j + j2;
                }
                if ((-9.223372036854776E18d) - dRint < 1.0d) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && (dRint < 9.223372036854776E18d)) {
                    return (long) dRint;
                }
                throw new ArithmeticException("rounded value is out of range for input " + d + " and rounding mode " + String.valueOf(roundingMode));
            case 3:
                if (d <= 0.0d || zzc(d)) {
                    dRint = d;
                } else {
                    j = (long) d;
                    j2 = 1;
                    dRint = j + j2;
                }
                if ((-9.223372036854776E18d) - dRint < 1.0d) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && (dRint < 9.223372036854776E18d)) {
                    return (long) dRint;
                }
                throw new ArithmeticException("rounded value is out of range for input " + d + " and rounding mode " + String.valueOf(roundingMode));
            case 4:
                dRint = d;
                if ((-9.223372036854776E18d) - dRint < 1.0d) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && (dRint < 9.223372036854776E18d)) {
                    return (long) dRint;
                }
                throw new ArithmeticException("rounded value is out of range for input " + d + " and rounding mode " + String.valueOf(roundingMode));
            case 5:
                if (zzc(d)) {
                    dRint = d;
                } else {
                    dRint = ((long) d) + ((long) (d > 0.0d ? 1 : -1));
                }
                if ((-9.223372036854776E18d) - dRint < 1.0d) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && (dRint < 9.223372036854776E18d)) {
                    return (long) dRint;
                }
                throw new ArithmeticException("rounded value is out of range for input " + d + " and rounding mode " + String.valueOf(roundingMode));
            case 6:
                dRint = Math.rint(d);
                if ((-9.223372036854776E18d) - dRint < 1.0d) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && (dRint < 9.223372036854776E18d)) {
                    return (long) dRint;
                }
                throw new ArithmeticException("rounded value is out of range for input " + d + " and rounding mode " + String.valueOf(roundingMode));
            case 7:
                dRint = Math.rint(d);
                if (Math.abs(d - dRint) == 0.5d) {
                    dRint = Math.copySign(0.5d, d) + d;
                }
                if ((-9.223372036854776E18d) - dRint < 1.0d) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && (dRint < 9.223372036854776E18d)) {
                    return (long) dRint;
                }
                throw new ArithmeticException("rounded value is out of range for input " + d + " and rounding mode " + String.valueOf(roundingMode));
            case 8:
                dRint = Math.rint(d);
                if (Math.abs(d - dRint) == 0.5d) {
                    dRint = d;
                }
                if ((-9.223372036854776E18d) - dRint < 1.0d) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && (dRint < 9.223372036854776E18d)) {
                    return (long) dRint;
                }
                throw new ArithmeticException("rounded value is out of range for input " + d + " and rounding mode " + String.valueOf(roundingMode));
            default:
                throw new AssertionError();
        }
    }

    public static boolean zzc(double d) {
        if (zzgbk.zzb(d)) {
            return d == 0.0d || 52 - Long.numberOfTrailingZeros(zzgbk.zza(d)) <= Math.getExponent(d);
        }
        return false;
    }

    public static boolean zzd(double d) {
        if (d > 0.0d && zzgbk.zzb(d)) {
            long jZza = zzgbk.zza(d);
            if ((jZza & ((-1) + jZza)) == 0) {
                return true;
            }
        }
        return false;
    }
}
