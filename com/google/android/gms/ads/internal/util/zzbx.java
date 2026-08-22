package com.google.android.gms.ads.internal.util;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public final class zzbx {
    public long zza;
    public long zzb = Long.MIN_VALUE;
    public final Object zzc = new Object();

    public zzbx(long j) {
        this.zza = j;
    }

    public final boolean zzb() {
        synchronized (this.zzc) {
            try {
                com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                if (this.zzb + this.zza > jElapsedRealtime) {
                    return false;
                }
                this.zzb = jElapsedRealtime;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
