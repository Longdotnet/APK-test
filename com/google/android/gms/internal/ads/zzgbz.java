package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
final class zzgbz extends zzgca {
    public zzgbz(ListenableFuture listenableFuture, Class cls, zzfve zzfveVar) {
        super(listenableFuture, cls, zzfveVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgca
    public final /* synthetic */ Object zze(Object obj, Throwable th) {
        return ((zzfve) obj).apply(th);
    }

    @Override // com.google.android.gms.internal.ads.zzgca
    public final void zzf(Object obj) {
        zzc(obj);
    }
}
