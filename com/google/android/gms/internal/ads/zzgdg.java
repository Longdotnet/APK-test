package com.google.android.gms.internal.ads;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzgdg extends zzfyh implements Future {
    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return zzb().cancel(z);
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return zzb().get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return zzb().isCancelled();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return zzb().isDone();
    }

    @Override // com.google.android.gms.internal.ads.zzfyh
    public /* bridge */ /* synthetic */ Object zza() {
        throw null;
    }

    public abstract Future zzb();

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) {
        return zzb().get(j, timeUnit);
    }
}
