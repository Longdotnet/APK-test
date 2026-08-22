package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public class zzbu {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    public /* synthetic */ zzbu(zzbt zzbtVar) {
    }

    public static int zzb(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    public static long zzc(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }
}
