package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes.dex */
abstract class zzgdv extends AtomicReference implements Runnable {
    private static final Runnable zza = new zzgdt(null);
    private static final Runnable zzb = new zzgdt(null);

    private final void zzc(Thread thread) {
        Runnable runnable = (Runnable) get();
        zzgds zzgdsVar = null;
        boolean z = false;
        int i = 0;
        while (true) {
            if (!(runnable instanceof zzgds)) {
                if (runnable != zzb) {
                    break;
                }
            } else {
                zzgdsVar = (zzgds) runnable;
            }
            i++;
            if (i > 1000) {
                Runnable runnable2 = zzb;
                if (runnable == runnable2 || compareAndSet(runnable, runnable2)) {
                    z = Thread.interrupted() || z;
                    LockSupport.park(zzgdsVar);
                }
            } else {
                Thread.yield();
            }
            runnable = (Runnable) get();
        }
        if (z) {
            thread.interrupt();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Thread threadCurrentThread = Thread.currentThread();
        Object objZza = null;
        if (compareAndSet(null, threadCurrentThread)) {
            boolean zZzg = zzg();
            if (!zZzg) {
                try {
                    objZza = zza();
                } catch (Throwable th) {
                    try {
                        zzgeg.zza(th);
                        if (!compareAndSet(threadCurrentThread, zza)) {
                            zzc(threadCurrentThread);
                        }
                        zzd(th);
                        return;
                    } catch (Throwable th2) {
                        if (!compareAndSet(threadCurrentThread, zza)) {
                            zzc(threadCurrentThread);
                        }
                        zze(null);
                        throw th2;
                    }
                }
            }
            if (!compareAndSet(threadCurrentThread, zza)) {
                zzc(threadCurrentThread);
            }
            if (zZzg) {
                return;
            }
            zze(objZza);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        String strM$1;
        Runnable runnable = (Runnable) get();
        if (runnable == zza) {
            strM$1 = "running=[DONE]";
        } else if (runnable instanceof zzgds) {
            strM$1 = "running=[INTERRUPTED]";
        } else {
            strM$1 = runnable instanceof Thread ? CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("running=[RUNNING ON ", ((Thread) runnable).getName(), "]") : "running=[NOT STARTED YET]";
        }
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(strM$1, ", ", zzb());
    }

    public abstract Object zza();

    public abstract String zzb();

    public abstract void zzd(Throwable th);

    public abstract void zze(Object obj);

    public abstract boolean zzg();

    public final void zzh() {
        Runnable runnable = (Runnable) get();
        if (runnable instanceof Thread) {
            zzgds zzgdsVar = new zzgds(this, null);
            zzgdsVar.setExclusiveOwnerThread(Thread.currentThread());
            if (compareAndSet(runnable, zzgdsVar)) {
                try {
                    ((Thread) runnable).interrupt();
                    if (((Runnable) getAndSet(zza)) == zzb) {
                    }
                } finally {
                    if (((Runnable) getAndSet(zza)) == zzb) {
                        LockSupport.unpark((Thread) runnable);
                    }
                }
            }
        }
    }
}
