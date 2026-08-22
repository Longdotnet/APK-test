package com.google.android.gms.internal.ads;

import android.os.Build;
import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
final class zzgee extends zzgeb implements AutoCloseable, zzgdz {
    final ScheduledExecutorService zza;

    public zzgee(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        scheduledExecutorService.getClass();
        this.zza = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzgch, java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        if ((Build.VERSION.SDK_INT <= 23 || this != ForkJoinPool.commonPool()) && !isTerminated()) {
            shutdown();
            boolean zAwaitTermination = false;
            boolean z = false;
            while (!zAwaitTermination) {
                try {
                    zAwaitTermination = awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z) {
                        shutdownNow();
                    }
                    z = true;
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        ScheduledExecutorService scheduledExecutorService = this.zza;
        zzgeo zzgeoVarZze = zzgeo.zze(runnable, null);
        return new zzgec(zzgeoVarZze, scheduledExecutorService.schedule(zzgeoVarZze, j, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzged zzgedVar = new zzged(runnable);
        return new zzgec(zzgedVar, this.zza.scheduleAtFixedRate(zzgedVar, j, j2, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzged zzgedVar = new zzged(runnable);
        return new zzgec(zzgedVar, this.zza.scheduleWithFixedDelay(zzgedVar, j, j2, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzgdx schedule(Callable callable, long j, TimeUnit timeUnit) {
        zzgeo zzgeoVar = new zzgeo(callable);
        return new zzgec(zzgeoVar, this.zza.schedule(zzgeoVar, j, timeUnit));
    }
}
