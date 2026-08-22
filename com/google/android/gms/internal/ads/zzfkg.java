package com.google.android.gms.internal.ads;

import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public final class zzfkg {
    private final long zza;
    private final long zzb;
    private long zze;
    private long zzd = 5;
    private final Random zzf = new Random();
    private long zzc = 0;

    public zzfkg(long j, double d, long j2, double d2) {
        this.zza = j;
        this.zzb = j2;
        zzc();
    }

    public final long zza() {
        double d = this.zze;
        double d2 = 0.2d * d;
        long j = (long) (d + d2);
        long j2 = (long) (d - d2);
        return j2 + ((long) (this.zzf.nextDouble() * ((j - j2) + 1)));
    }

    public final void zzb() {
        double d = this.zze;
        this.zze = Math.min((long) (d + d), this.zzb);
        this.zzc++;
    }

    public final void zzc() {
        this.zze = this.zza;
        this.zzc = 0L;
    }

    public final synchronized void zzd(int i) {
        com.google.android.gms.common.internal.zzah.checkArgument(i > 0);
        this.zzd = i;
    }

    public final boolean zze() {
        return this.zzc > Math.max(this.zzd, (long) ((Integer) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzE)).intValue()) && this.zze >= this.zzb;
    }
}
