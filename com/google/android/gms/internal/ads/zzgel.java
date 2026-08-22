package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
final class zzgel extends zzgdd {
    private ListenableFuture zza;
    private ScheduledFuture zzb;

    private zzgel(ListenableFuture listenableFuture) {
        listenableFuture.getClass();
        this.zza = listenableFuture;
    }

    public static ListenableFuture zzf(ListenableFuture listenableFuture, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        zzgel zzgelVar = new zzgel(listenableFuture);
        zzgei zzgeiVar = new zzgei(zzgelVar);
        zzgelVar.zzb = scheduledExecutorService.schedule(zzgeiVar, j, timeUnit);
        listenableFuture.addListener(zzgeiVar, zzgdb.INSTANCE);
        return zzgelVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcb
    public final String zza() {
        ListenableFuture listenableFuture = this.zza;
        ScheduledFuture scheduledFuture = this.zzb;
        if (listenableFuture == null) {
            return null;
        }
        String strM$1 = CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("inputFuture=[", listenableFuture.toString(), "]");
        if (scheduledFuture == null) {
            return strM$1;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return strM$1;
        }
        return strM$1 + ", remaining delay=[" + delay + " ms]";
    }

    @Override // com.google.android.gms.internal.ads.zzgcb
    public final void zzb() {
        zzl(this.zza);
        ScheduledFuture scheduledFuture = this.zzb;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.zza = null;
        this.zzb = null;
    }
}
