package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes.dex */
abstract class zaav implements Runnable {
    public final /* synthetic */ zaaw zab;

    public /* synthetic */ zaav(zaaw zaawVar) {
        this.zab = zaawVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.common.api.internal.zaaw] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.concurrent.locks.Lock] */
    @Override // java.lang.Runnable
    public final void run() {
        zaaw zaawVar = this.zab;
        zaawVar.zab.lock();
        try {
            try {
                if (!Thread.interrupted()) {
                    zaa();
                }
            } catch (RuntimeException e) {
                zabh zabhVar = zaawVar.zaa.zam;
                zabhVar.sendMessage(zabhVar.obtainMessage(2, e));
            }
        } finally {
            zaawVar.zab.unlock();
        }
    }

    public abstract void zaa();
}
