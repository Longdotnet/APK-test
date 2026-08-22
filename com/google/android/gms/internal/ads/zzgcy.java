package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class zzgcy extends zzgcz {
    final /* synthetic */ zzgda zza;
    private final Callable zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgcy(zzgda zzgdaVar, Callable callable, Executor executor) {
        super(zzgdaVar, executor);
        Objects.requireNonNull(zzgdaVar);
        this.zza = zzgdaVar;
        this.zzc = callable;
    }

    @Override // com.google.android.gms.internal.ads.zzgdv
    public final Object zza() {
        return this.zzc.call();
    }

    @Override // com.google.android.gms.internal.ads.zzgdv
    public final String zzb() {
        return this.zzc.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgcz
    public final void zzc(Object obj) {
        this.zza.zzc(obj);
    }
}
