package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import kotlinx.coroutines.internal.Jbo.ygoi;

/* JADX INFO: loaded from: classes2.dex */
public final class zzfm extends FutureTask implements Comparable {
    public final boolean zza;
    public final /* synthetic */ zzfo zzb;
    public final long zzc;
    public final String zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfm(zzfo zzfoVar, Runnable runnable, boolean z, String str) {
        super(runnable, null);
        this.zzb = zzfoVar;
        long andIncrement = zzfo.zza.getAndIncrement();
        this.zzc = andIncrement;
        this.zzd = str;
        this.zza = z;
        if (andIncrement == Long.MAX_VALUE) {
            zzeh zzehVar = ((zzfr) zzfoVar.mBuilder).zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zza("Tasks index overflow");
        }
    }

    @Override // java.util.concurrent.FutureTask
    public final void setException(Throwable th) {
        zzeh zzehVar = ((zzfr) this.zzb.mBuilder).zzm;
        zzfr.zzR(zzehVar);
        zzehVar.zzd.zzb(th, this.zzd);
        super.setException(th);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        zzfm zzfmVar = (zzfm) obj;
        boolean z = zzfmVar.zza;
        boolean z2 = this.zza;
        if (z2 == z) {
            long j = this.zzc;
            long j2 = zzfmVar.zzc;
            if (j < j2) {
                return -1;
            }
            if (j <= j2) {
                zzeh zzehVar = ((zzfr) this.zzb.mBuilder).zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zze.zzb(Long.valueOf(j), ygoi.qsWUOXtS);
                return 0;
            }
        } else if (z2) {
            return -1;
        }
        return 1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfm(zzfo zzfoVar, Callable callable, boolean z) {
        super(callable);
        this.zzb = zzfoVar;
        long andIncrement = zzfo.zza.getAndIncrement();
        this.zzc = andIncrement;
        this.zzd = "Task exception on worker thread";
        this.zza = z;
        if (andIncrement == Long.MAX_VALUE) {
            zzeh zzehVar = ((zzfr) zzfoVar.mBuilder).zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zza("Tasks index overflow");
        }
    }
}
