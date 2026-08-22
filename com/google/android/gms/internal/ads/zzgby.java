package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
final class zzgby extends zzgca {
    public zzgby(ListenableFuture listenableFuture, Class cls, zzgcu zzgcuVar) {
        super(listenableFuture, cls, zzgcuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgca
    public final /* bridge */ /* synthetic */ Object zze(Object obj, Throwable th) {
        zzgcu zzgcuVar = (zzgcu) obj;
        ListenableFuture listenableFutureZza = zzgcuVar.zza(th);
        zzfvp.zzd(listenableFutureZza, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzgcuVar);
        return listenableFutureZza;
    }

    @Override // com.google.android.gms.internal.ads.zzgca
    public final /* synthetic */ void zzf(Object obj) {
        zzn((ListenableFuture) obj);
    }
}
