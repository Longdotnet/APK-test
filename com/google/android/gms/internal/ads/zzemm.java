package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public final class zzemm implements zzeuc {
    private final ListenableFuture zza;
    private final Executor zzb;
    private final ScheduledExecutorService zzc;

    public zzemm(ListenableFuture listenableFuture, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        this.zza = listenableFuture;
        this.zzb = executor;
        this.zzc = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 6;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        zzgcu zzgcuVar = new zzgcu() { // from class: com.google.android.gms.internal.ads.zzemk
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzgdn.zzh(new zzemn((String) obj));
            }
        };
        ListenableFuture listenableFuture = this.zza;
        Executor executor = this.zzb;
        ListenableFuture listenableFutureZzn = zzgdn.zzn(listenableFuture, zzgcuVar, executor);
        zzbcv zzbcvVar = zzbde.zzmS;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Integer) zzbdVar.zzd.zzb(zzbcvVar)).intValue() > 0) {
            listenableFutureZzn = zzgdn.zzo(listenableFutureZzn, ((Integer) zzbdVar.zzd.zzb(zzbcvVar)).intValue(), TimeUnit.MILLISECONDS, this.zzc);
        }
        return zzgdn.zzf(listenableFutureZzn, Throwable.class, new zzgcu() { // from class: com.google.android.gms.internal.ads.zzeml
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return ((Throwable) obj) instanceof TimeoutException ? zzgdn.zzh(new zzemn(Integer.toString(17))) : zzgdn.zzh(new zzemn(null));
            }
        }, executor);
    }
}
