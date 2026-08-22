package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzent implements zzeuc {
    final zzbzs zza;
    AppSetIdClient zzb;
    private final ScheduledExecutorService zzc;
    private final zzgdy zzd;
    private final Context zze;

    public zzent(Context context, zzbzs zzbzsVar, ScheduledExecutorService scheduledExecutorService, zzgdy zzgdyVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzdl)).booleanValue()) {
            this.zzb = new com.google.android.gms.internal.appset.zzr(context);
        }
        this.zze = context;
        this.zza = zzbzsVar;
        this.zzc = scheduledExecutorService;
        this.zzd = zzgdyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 11;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        zzbcv zzbcvVar = zzbde.zzdh;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            if (!((Boolean) zzbdVar.zzd.zzb(zzbde.zzdm)).booleanValue()) {
                if (!((Boolean) zzbdVar.zzd.zzb(zzbde.zzdi)).booleanValue()) {
                    return zzgdn.zzm(zzfsj.zza(this.zzb.getAppSetIdInfo(), null), new zzfve() { // from class: com.google.android.gms.internal.ads.zzenq
                        @Override // com.google.android.gms.internal.ads.zzfve
                        public final Object apply(Object obj) {
                            AppSetIdInfo appSetIdInfo = (AppSetIdInfo) obj;
                            return new zzenu(appSetIdInfo.zza, appSetIdInfo.zzb);
                        }
                    }, zzcaf.zzg);
                }
                Task taskZza = ((Boolean) zzbdVar.zzd.zzb(zzbde.zzdl)).booleanValue() ? zzfea.zza(this.zze) : this.zzb.getAppSetIdInfo();
                if (taskZza == null) {
                    return zzgdn.zzh(new zzenu(null, -1));
                }
                ListenableFuture listenableFutureZzn = zzgdn.zzn(zzfsj.zza(taskZza, null), new zzgcu() { // from class: com.google.android.gms.internal.ads.zzenr
                    @Override // com.google.android.gms.internal.ads.zzgcu
                    public final ListenableFuture zza(Object obj) {
                        AppSetIdInfo appSetIdInfo = (AppSetIdInfo) obj;
                        return appSetIdInfo == null ? zzgdn.zzh(new zzenu(null, -1)) : zzgdn.zzh(new zzenu(appSetIdInfo.zza, appSetIdInfo.zzb));
                    }
                }, zzcaf.zzg);
                if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzdj)).booleanValue()) {
                    listenableFutureZzn = zzgdn.zzo(listenableFutureZzn, ((Long) zzbdVar.zzd.zzb(zzbde.zzdk)).longValue(), TimeUnit.MILLISECONDS, this.zzc);
                }
                return zzgdn.zze(listenableFutureZzn, Exception.class, new zzfve() { // from class: com.google.android.gms.internal.ads.zzens
                    @Override // com.google.android.gms.internal.ads.zzfve
                    public final Object apply(Object obj) {
                        this.zza.zza.zzw((Exception) obj, "AppSetIdInfoSignal");
                        return new zzenu(null, -1);
                    }
                }, this.zzd);
            }
        }
        return zzgdn.zzh(new zzenu(null, -1));
    }
}
