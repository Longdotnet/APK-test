package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzeso implements zzeuc {
    private final zzeuc zza;
    private final long zzb;
    private final ScheduledExecutorService zzc;

    public zzeso(zzeuc zzeucVar, long j, ScheduledExecutorService scheduledExecutorService) {
        this.zza = zzeucVar;
        this.zzb = j;
        this.zzc = scheduledExecutorService;
    }

    public static ListenableFuture zzc(zzeso zzesoVar, Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcz)).booleanValue()) {
            zzeuc zzeucVar = zzesoVar.zza;
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(th, "OptionalSignalTimeout:" + zzeucVar.zza());
        }
        return zzgdn.zzh(null);
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        ListenableFuture listenableFutureZzb = this.zza.zzb();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcA)).booleanValue()) {
            timeUnit = TimeUnit.MICROSECONDS;
        }
        long j = this.zzb;
        if (j > 0) {
            listenableFutureZzb = zzgdn.zzo(listenableFutureZzb, j, timeUnit, this.zzc);
        }
        return zzgdn.zzf(listenableFutureZzb, Throwable.class, new zzgcu() { // from class: com.google.android.gms.internal.ads.zzesn
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzeso.zzc(this.zza, (Throwable) obj);
            }
        }, zzcaf.zzg);
    }
}
