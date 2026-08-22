package com.google.android.gms.common.util.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class NumberedThreadFactory implements ThreadFactory {
    public final String zza;
    public final AtomicInteger zzb = new AtomicInteger();
    public final ThreadFactory zzc = Executors.defaultThreadFactory();

    public NumberedThreadFactory(String str) {
        this.zza = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.zzc.newThread(new zza(0, runnable));
        threadNewThread.setName(this.zza + "[" + this.zzb.getAndIncrement() + "]");
        return threadNewThread;
    }
}
