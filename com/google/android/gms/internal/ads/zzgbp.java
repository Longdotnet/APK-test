package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzgbp {
    public static long zza(String str, long j) {
        if (j >= 0) {
            return j;
        }
        throw new IllegalArgumentException(str + " (" + j + ") must be >= 0");
    }

    public static void zzb(boolean z) {
        if (!z) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
