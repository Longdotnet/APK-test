package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes.dex */
abstract class zzgcz extends zzgdv {
    private final Executor zza;
    final /* synthetic */ zzgda zzb;

    public zzgcz(zzgda zzgdaVar, Executor executor) {
        Objects.requireNonNull(zzgdaVar);
        this.zzb = zzgdaVar;
        executor.getClass();
        this.zza = executor;
    }

    public abstract void zzc(Object obj);

    @Override // com.google.android.gms.internal.ads.zzgdv
    public final void zzd(Throwable th) {
        zzgda zzgdaVar = this.zzb;
        zzgdaVar.zza = null;
        if (th instanceof ExecutionException) {
            zzgdaVar.zzd(((ExecutionException) th).getCause());
        } else if (th instanceof CancellationException) {
            zzgdaVar.cancel(false);
        } else {
            zzgdaVar.zzd(th);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgdv
    public final void zze(Object obj) {
        this.zzb.zza = null;
        zzc(obj);
    }

    public final void zzf() {
        try {
            this.zza.execute(this);
        } catch (RejectedExecutionException e) {
            this.zzb.zzd(e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgdv
    public final boolean zzg() {
        return this.zzb.isDone();
    }
}
