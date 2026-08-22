package com.google.android.gms.internal.ads;

import android.os.Build;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzgch extends AbstractExecutorService implements AutoCloseable, zzgdy {
    @Override // java.lang.AutoCloseable
    public /* synthetic */ void close() {
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

    @Override // java.util.concurrent.AbstractExecutorService
    public final RunnableFuture newTaskFor(Runnable runnable, Object obj) {
        return zzgeo.zze(runnable, obj);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public final /* synthetic */ Future submit(Runnable runnable) {
        return (ListenableFuture) super.submit(runnable);
    }

    @Override // com.google.android.gms.internal.ads.zzgdy
    public final ListenableFuture zza(Runnable runnable) {
        return (ListenableFuture) super.submit(runnable);
    }

    @Override // com.google.android.gms.internal.ads.zzgdy
    public final ListenableFuture zzb(Callable callable) {
        return (ListenableFuture) super.submit(callable);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public final RunnableFuture newTaskFor(Callable callable) {
        return new zzgeo(callable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public final /* synthetic */ Future submit(Runnable runnable, Object obj) {
        return (ListenableFuture) super.submit(runnable, obj);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public final /* synthetic */ Future submit(Callable callable) {
        return (ListenableFuture) super.submit(callable);
    }
}
