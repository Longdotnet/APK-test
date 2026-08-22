package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: loaded from: classes.dex */
public interface zzgdx extends ScheduledFuture, ListenableFuture {
    @Override // com.google.common.util.concurrent.ListenableFuture
    /* synthetic */ void addListener(Runnable runnable, Executor executor);
}
