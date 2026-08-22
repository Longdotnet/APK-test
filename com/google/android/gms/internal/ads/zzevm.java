package com.google.android.gms.internal.ads;

import androidx.work.WorkContinuation;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzevm implements zzeuc {
    private final zzbzs zza;
    private final ScheduledExecutorService zzb;
    private final zzgdy zzc;

    public zzevm(String str, zzbbf zzbbfVar, zzbzs zzbzsVar, ScheduledExecutorService scheduledExecutorService, zzgdy zzgdyVar) {
        this.zza = zzbzsVar;
        this.zzb = scheduledExecutorService;
        this.zzc = zzgdyVar;
    }

    public static /* synthetic */ zzevn zzc(zzevm zzevmVar, Exception exc) {
        zzevmVar.zza.zzw(exc, "AppSetIdInfoGmscoreSignal");
        return new zzevn(null, -1);
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 43;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        zzbcv zzbcvVar = zzbde.zzdh;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzdm)).booleanValue()) {
                ListenableFuture listenableFutureZza = zzfsj.zza(WorkContinuation.forResult(null), null);
                zzgcu zzgcuVar = new zzgcu() { // from class: com.google.android.gms.internal.ads.zzevk
                    @Override // com.google.android.gms.internal.ads.zzgcu
                    public final ListenableFuture zza(Object obj) {
                        AppSetIdInfo appSetIdInfo = (AppSetIdInfo) obj;
                        return appSetIdInfo == null ? zzgdn.zzh(new zzevn(null, -1)) : zzgdn.zzh(new zzevn(appSetIdInfo.zza, appSetIdInfo.zzb));
                    }
                };
                zzgdy zzgdyVar = this.zzc;
                ListenableFuture listenableFutureZzn = zzgdn.zzn(listenableFutureZza, zzgcuVar, zzgdyVar);
                if (((Boolean) zzber.zza.zze()).booleanValue()) {
                    listenableFutureZzn = zzgdn.zzo(listenableFutureZzn, ((Long) zzber.zzb.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzb);
                }
                return zzgdn.zze(listenableFutureZzn, Exception.class, new zzfve() { // from class: com.google.android.gms.internal.ads.zzevl
                    @Override // com.google.android.gms.internal.ads.zzfve
                    public final Object apply(Object obj) {
                        return zzevm.zzc(this.zza, (Exception) obj);
                    }
                }, zzgdyVar);
            }
        }
        return zzgdn.zzh(new zzevn(null, -1));
    }
}
