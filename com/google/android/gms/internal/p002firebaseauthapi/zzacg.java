package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzacg {
    public static final /* synthetic */ int zzd = 0;
    private static volatile int zze = 100;
    int zza;
    final int zzb = zze;
    zzach zzc;

    public /* synthetic */ zzacg(zzacf zzacfVar) {
    }

    public static int zzs(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long zzt(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static zzacg zzu(byte[] bArr, int i, int i2, boolean z) {
        zzace zzaceVar = new zzace(bArr, 0, i2, z, null);
        try {
            zzaceVar.zzc(i2);
            return zzaceVar;
        } catch (zzadn e) {
            throw new IllegalArgumentException(e);
        }
    }

    public abstract int zzb();

    public abstract int zzc(int i);

    public abstract int zzf();

    public abstract zzacc zzj();

    public abstract String zzk();

    public abstract String zzl();

    public abstract void zzm(int i);

    public abstract void zzn(int i);

    public abstract boolean zzp();

    public abstract boolean zzq();

    public abstract boolean zzr(int i);
}
