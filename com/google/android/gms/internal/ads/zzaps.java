package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class zzaps implements Executor {
    final /* synthetic */ Handler zza;

    public zzaps(zzapu zzapuVar, Handler handler) {
        this.zza = handler;
        Objects.requireNonNull(zzapuVar);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.zza.post(runnable);
    }
}
