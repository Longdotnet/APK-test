package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public final class zzdm {
    private boolean zza;

    public zzdm() {
        throw null;
    }

    public final synchronized void zza() {
        while (!this.zza) {
            wait();
        }
    }

    public final synchronized void zzb() {
        boolean z = false;
        while (!this.zza) {
            try {
                wait();
            } catch (InterruptedException unused) {
                z = true;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public final synchronized boolean zzc(long j) {
        if (j > 0) {
            try {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                long j2 = j + jElapsedRealtime;
                if (j2 < jElapsedRealtime) {
                    zzb();
                } else {
                    boolean z = false;
                    while (!this.zza && jElapsedRealtime < j2) {
                        try {
                            wait(j2 - jElapsedRealtime);
                        } catch (InterruptedException unused) {
                            z = true;
                        }
                        jElapsedRealtime = SystemClock.elapsedRealtime();
                    }
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.zza;
    }

    public final synchronized boolean zzd() {
        boolean z;
        z = this.zza;
        this.zza = false;
        return z;
    }

    public final synchronized boolean zze() {
        return this.zza;
    }

    public final synchronized boolean zzf() {
        if (this.zza) {
            return false;
        }
        this.zza = true;
        notifyAll();
        return true;
    }

    public zzdm(zzdj zzdjVar) {
    }
}
