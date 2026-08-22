package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzbxu implements zzgdj {
    final /* synthetic */ ListenableFuture zza;

    public zzbxu(zzbxv zzbxvVar, ListenableFuture listenableFuture) {
        this.zza = listenableFuture;
        Objects.requireNonNull(zzbxvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        zzbxv.zzc.remove(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzbxv.zzc.remove(this.zza);
    }
}
