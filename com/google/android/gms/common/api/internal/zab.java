package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class zab extends ActivityLifecycleObserver {
    public final WeakReference zaa;

    public zab(zaa zaaVar) {
        this.zaa = new WeakReference(zaaVar);
    }

    @Override // com.google.android.gms.common.api.internal.ActivityLifecycleObserver
    public final ActivityLifecycleObserver onStopCallOnce(Runnable runnable) {
        zaa zaaVar = (zaa) this.zaa.get();
        if (zaaVar == null) {
            throw new IllegalStateException("The target activity has already been GC'd");
        }
        synchronized (zaaVar) {
            zaaVar.zaa.add(runnable);
        }
        return this;
    }
}
