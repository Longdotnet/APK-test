package com.google.android.gms.ads.internal.util;

import androidx.work.Worker;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzb {
    private final Runnable zza = new Worker.AnonymousClass1(this);
    private volatile Thread zzb;

    public abstract void zza();

    public ListenableFuture zzb() {
        return zzcaf.zza.zza(this.zza);
    }
}
