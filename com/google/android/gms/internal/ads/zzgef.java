package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzgef {
    public static zzgdy zza(ExecutorService executorService) {
        if (executorService instanceof zzgdy) {
            return (zzgdy) executorService;
        }
        return executorService instanceof ScheduledExecutorService ? new zzgee((ScheduledExecutorService) executorService) : new zzgeb(executorService);
    }

    public static zzgdz zzb(ScheduledExecutorService scheduledExecutorService) {
        return new zzgee(scheduledExecutorService);
    }

    public static Executor zzc() {
        return zzgdb.INSTANCE;
    }

    public static Executor zzd(final Executor executor, final zzgcb zzgcbVar) {
        executor.getClass();
        return executor == zzgdb.INSTANCE ? executor : new Executor() { // from class: com.google.android.gms.internal.ads.zzgea
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                zzgef.zze(executor, zzgcbVar, runnable);
            }
        };
    }

    public static /* synthetic */ void zze(Executor executor, zzgcb zzgcbVar, Runnable runnable) {
        try {
            executor.execute(runnable);
        } catch (RejectedExecutionException e) {
            zzgcbVar.zzd(e);
        }
    }
}
