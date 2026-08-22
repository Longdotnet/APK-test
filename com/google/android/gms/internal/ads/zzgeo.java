package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;

/* JADX INFO: loaded from: classes.dex */
final class zzgeo extends zzgdd implements RunnableFuture {
    private volatile zzgdv zza;

    public zzgeo(zzgct zzgctVar) {
        this.zza = new zzgem(this, zzgctVar);
    }

    public static zzgeo zze(Runnable runnable, Object obj) {
        return new zzgeo(Executors.callable(runnable, obj));
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        zzgdv zzgdvVar = this.zza;
        if (zzgdvVar != null) {
            zzgdvVar.run();
        }
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.ads.zzgcb
    public final String zza() {
        zzgdv zzgdvVar = this.zza;
        return zzgdvVar != null ? CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("task=[", zzgdvVar.toString(), "]") : super.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzgcb
    public final void zzb() {
        zzgdv zzgdvVar;
        if (zzo() && (zzgdvVar = this.zza) != null) {
            zzgdvVar.zzh();
        }
        this.zza = null;
    }

    public zzgeo(Callable callable) {
        this.zza = new zzgen(this, callable);
    }
}
