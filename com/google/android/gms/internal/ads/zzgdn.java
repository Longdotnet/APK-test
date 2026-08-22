package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzgdn extends zzgdp {
    public static zzgdl zza(Iterable iterable) {
        return new zzgdl(false, zzfyq.zzk(iterable), null);
    }

    public static zzgdl zzb(Iterable iterable) {
        return new zzgdl(true, zzfyq.zzk(iterable), null);
    }

    @SafeVarargs
    public static zzgdl zzc(ListenableFuture... listenableFutureArr) {
        return new zzgdl(true, zzfyq.zzm(listenableFutureArr), null);
    }

    public static ListenableFuture zzd(Iterable iterable) {
        return new zzgcv(zzfyq.zzk(iterable), true);
    }

    public static ListenableFuture zze(ListenableFuture listenableFuture, Class cls, zzfve zzfveVar, Executor executor) {
        int i = zzgca.zzd;
        zzgbz zzgbzVar = new zzgbz(listenableFuture, cls, zzfveVar);
        listenableFuture.addListener(zzgbzVar, zzgef.zzd(executor, zzgbzVar));
        return zzgbzVar;
    }

    public static ListenableFuture zzf(ListenableFuture listenableFuture, Class cls, zzgcu zzgcuVar, Executor executor) {
        int i = zzgca.zzd;
        zzgby zzgbyVar = new zzgby(listenableFuture, cls, zzgcuVar);
        listenableFuture.addListener(zzgbyVar, zzgef.zzd(executor, zzgbyVar));
        return zzgbyVar;
    }

    public static ListenableFuture zzg(Throwable th) {
        th.getClass();
        return new zzgdq(th);
    }

    public static ListenableFuture zzh(Object obj) {
        return obj == null ? zzgdr.zza : new zzgdr(obj);
    }

    public static ListenableFuture zzi() {
        return zzgdr.zza;
    }

    public static ListenableFuture zzj(Callable callable, Executor executor) {
        zzgeo zzgeoVar = new zzgeo(callable);
        executor.execute(zzgeoVar);
        return zzgeoVar;
    }

    public static ListenableFuture zzk(zzgct zzgctVar, Executor executor) {
        zzgeo zzgeoVar = new zzgeo(zzgctVar);
        executor.execute(zzgeoVar);
        return zzgeoVar;
    }

    @SafeVarargs
    public static ListenableFuture zzl(ListenableFuture... listenableFutureArr) {
        return new zzgcv(zzfyq.zzm(listenableFutureArr), false);
    }

    public static ListenableFuture zzm(ListenableFuture listenableFuture, zzfve zzfveVar, Executor executor) {
        int i = zzgck.zzc;
        zzgcj zzgcjVar = new zzgcj(listenableFuture, zzfveVar);
        listenableFuture.addListener(zzgcjVar, zzgef.zzd(executor, zzgcjVar));
        return zzgcjVar;
    }

    public static ListenableFuture zzn(ListenableFuture listenableFuture, zzgcu zzgcuVar, Executor executor) {
        int i = zzgck.zzc;
        zzgci zzgciVar = new zzgci(listenableFuture, zzgcuVar);
        listenableFuture.addListener(zzgciVar, zzgef.zzd(executor, zzgciVar));
        return zzgciVar;
    }

    public static ListenableFuture zzo(ListenableFuture listenableFuture, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return listenableFuture.isDone() ? listenableFuture : zzgel.zzf(listenableFuture, j, timeUnit, scheduledExecutorService);
    }

    public static Object zzp(Future future) {
        if (future.isDone()) {
            return zzgeq.zza(future);
        }
        throw new IllegalStateException(zzfwg.zzb("Future was expected to be done: %s", future));
    }

    public static Object zzq(Future future) {
        try {
            return zzgeq.zza(future);
        } catch (ExecutionException e) {
            if (e.getCause() instanceof Error) {
                throw new zzgdc((Error) e.getCause());
            }
            throw new zzgep(e.getCause());
        }
    }

    public static void zzr(ListenableFuture listenableFuture, zzgdj zzgdjVar, Executor executor) {
        zzgdjVar.getClass();
        listenableFuture.addListener(new zzgdk(listenableFuture, zzgdjVar), executor);
    }
}
