package com.google.android.gms.internal.measurement;

import androidx.lifecycle.hSi.sgtsHsWT;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes2.dex */
final class zzdi implements ThreadFactory {
    private final ThreadFactory zza = Executors.defaultThreadFactory();

    public zzdi(zzef zzefVar) {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.zza.newThread(runnable);
        threadNewThread.setName(sgtsHsWT.zjyvAqt);
        return threadNewThread;
    }
}
