package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
final class zzgdk implements Runnable {
    final Future zza;
    final zzgdj zzb;

    public zzgdk(Future future, zzgdj zzgdjVar) {
        this.zza = future;
        this.zzb = zzgdjVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        Throwable thZza;
        Future future = this.zza;
        if ((future instanceof zzger) && (thZza = zzges.zza((zzger) future)) != null) {
            this.zzb.zza(thZza);
            return;
        }
        try {
            this.zzb.zzb(zzgdn.zzp(future));
        } catch (ExecutionException e) {
            this.zzb.zza(e.getCause());
        } catch (Throwable th) {
            this.zzb.zza(th);
        }
    }

    public final String toString() {
        zzfvj zzfvjVarZza = zzfvl.zza(this);
        zzfvjVarZza.zza(this.zzb);
        return zzfvjVarZza.toString();
    }
}
