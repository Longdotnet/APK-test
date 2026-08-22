package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
final class zzgci extends zzgck {
    public zzgci(ListenableFuture listenableFuture, zzgcu zzgcuVar) {
        super(listenableFuture, zzgcuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgck
    public final /* bridge */ /* synthetic */ Object zze(Object obj, Object obj2) {
        zzgcu zzgcuVar = (zzgcu) obj;
        ListenableFuture listenableFutureZza = zzgcuVar.zza(obj2);
        zzfvp.zzd(listenableFutureZza, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzgcuVar);
        return listenableFutureZza;
    }

    @Override // com.google.android.gms.internal.ads.zzgck
    public final /* synthetic */ void zzf(Object obj) {
        zzn((ListenableFuture) obj);
    }
}
