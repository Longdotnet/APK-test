package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes.dex */
final class zav implements Runnable {
    public final /* synthetic */ zaaa zaa;

    public zav(zaaa zaaaVar) {
        this.zaa = zaaaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zaaa zaaaVar = this.zaa;
        zaaaVar.zam.lock();
        try {
            zaaa.zap(zaaaVar);
        } finally {
            zaaaVar.zam.unlock();
        }
    }
}
