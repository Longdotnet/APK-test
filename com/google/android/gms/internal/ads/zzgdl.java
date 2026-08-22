package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzgdl {
    private final boolean zza;
    private final zzfyq zzb;

    public /* synthetic */ zzgdl(boolean z, zzfyq zzfyqVar, zzgdm zzgdmVar) {
        this.zza = z;
        this.zzb = zzfyqVar;
    }

    public final ListenableFuture zza(Callable callable, Executor executor) {
        return new zzgda(this.zzb, this.zza, executor, callable);
    }
}
