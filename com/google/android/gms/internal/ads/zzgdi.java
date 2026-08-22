package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzgdi extends zzgdg implements ListenableFuture {
    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void addListener(Runnable runnable, Executor executor) {
        zzc().addListener(runnable, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzgdg
    public /* bridge */ /* synthetic */ Future zzb() {
        throw null;
    }

    public abstract ListenableFuture zzc();
}
