package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
final class zzgen extends zzgdv {
    final /* synthetic */ zzgeo zza;
    private final Callable zzb;

    public zzgen(zzgeo zzgeoVar, Callable callable) {
        Objects.requireNonNull(zzgeoVar);
        this.zza = zzgeoVar;
        callable.getClass();
        this.zzb = callable;
    }

    @Override // com.google.android.gms.internal.ads.zzgdv
    public final Object zza() {
        return this.zzb.call();
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
    public final void zze(Object obj) {
        this.zza.zzc(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgdv
    public final boolean zzg() {
        return this.zza.isDone();
    }
}
