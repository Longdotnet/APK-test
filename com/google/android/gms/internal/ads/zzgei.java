package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
final class zzgei implements Runnable {
    zzgel zza;

    public zzgei(zzgel zzgelVar) {
        this.zza = zzgelVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ListenableFuture listenableFuture;
        zzgel zzgelVar = this.zza;
        if (zzgelVar == null || (listenableFuture = zzgelVar.zza) == null) {
            return;
        }
        this.zza = null;
        if (listenableFuture.isDone()) {
            zzgelVar.zzn(listenableFuture);
            return;
        }
        try {
            ScheduledFuture scheduledFuture = zzgelVar.zzb;
            zzgelVar.zzb = null;
            String str = "Timed out";
            if (scheduledFuture != null) {
                try {
                    long jAbs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                    if (jAbs > 10) {
                        str = "Timed out (timeout delayed by " + jAbs + " ms after scheduled time)";
                    }
                } catch (Throwable th) {
                    zzgelVar.zzd(new zzgej(str, null));
                    throw th;
                }
            }
            zzgelVar.zzd(new zzgej(str + ": " + listenableFuture.toString(), null));
            listenableFuture.cancel(true);
        } catch (Throwable th2) {
            listenableFuture.cancel(true);
            throw th2;
        }
    }
}
