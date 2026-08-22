package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStreamReader;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class zzdxt implements zzdyw {
    private static final Pattern zza = Pattern.compile("Received error HTTP response code: (.*)");
    private final zzdwu zzb;
    private final zzgdy zzc;
    private final zzfcw zzd;
    private final ScheduledExecutorService zze;
    private final zzeaw zzf;
    private final zzfhu zzg;
    private final Context zzh;

    public zzdxt(Context context, zzfcw zzfcwVar, zzdwu zzdwuVar, zzgdy zzgdyVar, ScheduledExecutorService scheduledExecutorService, zzeaw zzeawVar, zzfhu zzfhuVar) {
        this.zzh = context;
        this.zzd = zzfcwVar;
        this.zzb = zzdwuVar;
        this.zzc = zzgdyVar;
        this.zze = scheduledExecutorService;
        this.zzf = zzeawVar;
        this.zzg = zzfhuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyw
    public final ListenableFuture zzc(zzbvq zzbvqVar) {
        Context context = this.zzh;
        ListenableFuture listenableFutureZzc = this.zzb.zzc(zzbvqVar);
        zzfhj zzfhjVarZza = zzfhi.zza(context, 11);
        zzfht.zzd(listenableFutureZzc, zzfhjVarZza);
        ListenableFuture listenableFutureZzn = zzgdn.zzn(listenableFutureZzc, new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdxq
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                zzdyy zzdyyVar = (zzdyy) obj;
                return zzgdn.zzh(new zzfcn(new zzfck(this.zza.zzd), zzfcm.zza(new InputStreamReader(zzdyyVar.zzb()), zzdyyVar.zza().zzm)));
            }
        }, this.zzc);
        zzbcv zzbcvVar = zzbde.zzfR;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            listenableFutureZzn = zzgdn.zzf(zzgdn.zzo(listenableFutureZzn, ((Integer) zzbdVar.zzd.zzb(zzbde.zzfS)).intValue(), TimeUnit.SECONDS, this.zze), TimeoutException.class, new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdxr
                @Override // com.google.android.gms.internal.ads.zzgcu
                public final ListenableFuture zza(Object obj) {
                    return zzgdn.zzg(new zzdwm(5));
                }
            }, zzcaf.zzg);
        }
        zzfht.zza(listenableFutureZzn, this.zzg, zzfhjVarZza);
        zzgdn.zzr(listenableFutureZzn, new zzdxs(this), zzcaf.zzg);
        return listenableFutureZzn;
    }
}
