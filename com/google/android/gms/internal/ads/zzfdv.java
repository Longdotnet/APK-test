package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Deque;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: loaded from: classes.dex */
public final class zzfdv {
    private final Deque zza = new LinkedBlockingDeque();
    private final Callable zzb;
    private final zzgdy zzc;

    public zzfdv(Callable callable, zzgdy zzgdyVar) {
        this.zzb = callable;
        this.zzc = zzgdyVar;
    }

    public final synchronized ListenableFuture zza() {
        zzc(1);
        return (ListenableFuture) this.zza.poll();
    }

    public final synchronized void zzb(ListenableFuture listenableFuture) {
        this.zza.addFirst(listenableFuture);
    }

    public final synchronized void zzc(int i) {
        Deque deque = this.zza;
        int size = i - deque.size();
        for (int i2 = 0; i2 < size; i2++) {
            deque.add(this.zzc.zzb(this.zzb));
        }
    }
}
