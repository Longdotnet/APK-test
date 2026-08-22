package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzcrp {
    private final Executor zza;
    private final ScheduledExecutorService zzb;
    private final ListenableFuture zzc;
    private volatile boolean zzd = true;

    public zzcrp(Executor executor, ScheduledExecutorService scheduledExecutorService, ListenableFuture listenableFuture) {
        this.zza = executor;
        this.zzb = scheduledExecutorService;
        this.zzc = listenableFuture;
    }

    public static /* synthetic */ ListenableFuture zza(zzcrp zzcrpVar, zzgdj zzgdjVar, ListenableFuture listenableFuture, zzcra zzcraVar) {
        if (zzcraVar != null) {
            zzgdjVar.zzb(zzcraVar);
        }
        return zzgdn.zzo(listenableFuture, ((Long) zzbfr.zza.zze()).longValue(), TimeUnit.MILLISECONDS, zzcrpVar.zzb);
    }

    public static /* bridge */ /* synthetic */ void zzc(final zzcrp zzcrpVar, List list, final zzgdj zzgdjVar) {
        if (list == null || list.isEmpty()) {
            zzcrpVar.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcrk
                @Override // java.lang.Runnable
                public final void run() {
                    zzgdjVar.zza(new zzdwm(3));
                }
            });
            return;
        }
        ListenableFuture listenableFutureZzh = zzgdn.zzh(null);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            final ListenableFuture listenableFuture = (ListenableFuture) it.next();
            zzgcu zzgcuVar = new zzgcu() { // from class: com.google.android.gms.internal.ads.zzcrl
                @Override // com.google.android.gms.internal.ads.zzgcu
                public final ListenableFuture zza(Object obj) {
                    zzgdjVar.zza((Throwable) obj);
                    return zzgdn.zzh(null);
                }
            };
            Executor executor = zzcrpVar.zza;
            listenableFutureZzh = zzgdn.zzn(zzgdn.zzf(listenableFutureZzh, Throwable.class, zzgcuVar, executor), new zzgcu() { // from class: com.google.android.gms.internal.ads.zzcrm
                @Override // com.google.android.gms.internal.ads.zzgcu
                public final ListenableFuture zza(Object obj) {
                    return zzcrp.zza(this.zza, zzgdjVar, listenableFuture, (zzcra) obj);
                }
            }, executor);
        }
        zzgdn.zzr(listenableFutureZzh, new zzcro(zzcrpVar, zzgdjVar), zzcrpVar.zza);
    }

    public final void zze(zzgdj zzgdjVar) {
        zzgdn.zzr(this.zzc, new zzcrn(this, zzgdjVar), this.zza);
    }

    public final boolean zzf() {
        return this.zzd;
    }
}
