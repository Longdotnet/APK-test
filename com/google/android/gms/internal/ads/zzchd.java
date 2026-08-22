package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzchd {
    public final int zza;
    public final int zzb;
    private final int zzc;

    private zzchd(int i, int i2, int i3) {
        this.zzc = i;
        this.zzb = i2;
        this.zza = i3;
    }

    public static zzchd zza() {
        return new zzchd(0, 0, 0);
    }

    public static zzchd zzb(int i, int i2) {
        return new zzchd(1, i, i2);
    }

    public static zzchd zzc(com.google.android.gms.ads.internal.client.zzr zzrVar) {
        if (zzrVar.zzd) {
            return new zzchd(3, 0, 0);
        }
        if (zzrVar.zzi) {
            return new zzchd(2, 0, 0);
        }
        return zzrVar.zzh ? new zzchd(0, 0, 0) : new zzchd(1, zzrVar.zzf, zzrVar.zzc);
    }

    public static zzchd zzd() {
        return new zzchd(5, 0, 0);
    }

    public static zzchd zze() {
        return new zzchd(4, 0, 0);
    }

    public final boolean zzf() {
        return this.zzc == 0;
    }

    public final boolean zzg() {
        return this.zzc == 2;
    }

    public final boolean zzh() {
        return this.zzc == 5;
    }

    public final boolean zzi() {
        return this.zzc == 3;
    }

    public final boolean zzj() {
        return this.zzc == 4;
    }
}
