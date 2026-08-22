package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzbzq {
    private final Object zza = new Object();
    private volatile int zzc = 1;
    private volatile long zzb = 0;

    private zzbzq() {
    }

    public final void zza() {
        com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
        zzvVar.zzl.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this.zza) {
            try {
                if (this.zzc == 3) {
                    if (this.zzb + ((Long) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzgj)).longValue() <= jCurrentTimeMillis) {
                        this.zzc = 1;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        zzvVar.zzl.getClass();
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        synchronized (this.zza) {
            try {
                if (this.zzc != 2) {
                    return;
                }
                this.zzc = 3;
                if (this.zzc == 3) {
                    this.zzb = jCurrentTimeMillis2;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public /* synthetic */ zzbzq(zzbzr zzbzrVar) {
    }
}
