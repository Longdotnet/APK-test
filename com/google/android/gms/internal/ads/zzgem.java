package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzgem extends zzgdv {
    final /* synthetic */ zzgeo zza;
    private final zzgct zzb;

    public zzgem(zzgeo zzgeoVar, zzgct zzgctVar) {
        Objects.requireNonNull(zzgeoVar);
        this.zza = zzgeoVar;
        this.zzb = zzgctVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdv
    public final /* bridge */ /* synthetic */ Object zza() {
        zzgct zzgctVar = this.zzb;
        ListenableFuture listenableFutureZza = zzgctVar.zza();
        zzfvp.zzd(listenableFutureZza, "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzgctVar);
        return listenableFutureZza;
    }

    @Override // com.google.android.gms.internal.ads.zzgdv
    public final String zzb() {
        return this.zzb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgdv
    public final void zzd(Throwable th) {
        this.zza.zzd(th);
    }

    @Override // com.google.android.gms.internal.ads.zzgdv
    public final /* synthetic */ void zze(Object obj) {
        this.zza.zzn((ListenableFuture) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgdv
    public final boolean zzg() {
        return this.zza.isDone();
    }
}
