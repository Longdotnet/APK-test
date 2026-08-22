package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.Objects;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
final class zzbyn implements ThreadFactory {
    private final AtomicInteger zza;

    public zzbyn(zzbyo zzbyoVar) {
        Objects.requireNonNull(zzbyoVar);
        this.zza = new AtomicInteger(1);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, CoroutineAdapterKt$$ExternalSyntheticLambda0.m(this.zza.getAndIncrement(), "AdWorker(SCION_TASK_EXECUTOR) #"));
    }
}
