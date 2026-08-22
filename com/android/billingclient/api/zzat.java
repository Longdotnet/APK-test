package com.android.billingclient.api;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class zzat implements ThreadFactory {
    public final /* synthetic */ int $r8$classId;
    public final Object zza;
    public final AtomicInteger zzb;

    public zzat() {
        this.$r8$classId = 0;
        this.zza = Executors.defaultThreadFactory();
        this.zzb = new AtomicInteger(1);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        switch (this.$r8$classId) {
            case 0:
                AtomicInteger atomicInteger = this.zzb;
                Thread threadNewThread = ((ThreadFactory) this.zza).newThread(runnable);
                threadNewThread.setName("PlayBillingLibrary-" + atomicInteger.getAndIncrement());
                return threadNewThread;
            default:
                return new Thread(runnable, "AdWorker(" + ((String) this.zza) + ") #" + this.zzb.getAndIncrement());
        }
    }

    public zzat(String str) {
        this.$r8$classId = 1;
        this.zza = str;
        this.zzb = new AtomicInteger(1);
    }
}
