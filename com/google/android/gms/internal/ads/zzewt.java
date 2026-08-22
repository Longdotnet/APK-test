package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzewt implements zzeuc {
    private final zzbzs zza;
    private final boolean zzb;
    private final ScheduledExecutorService zzc;
    private final zzgdy zzd;
    private final int zze;
    private final int zzf;

    public zzewt(zzbzs zzbzsVar, boolean z, zzbzh zzbzhVar, zzgdy zzgdyVar, String str, ScheduledExecutorService scheduledExecutorService, int i, int i2) {
        this.zza = zzbzsVar;
        this.zzb = z;
        this.zzd = zzgdyVar;
        this.zzc = scheduledExecutorService;
        this.zze = i;
        this.zzf = i2;
    }

    public static /* synthetic */ zzewu zzc(zzewt zzewtVar, Exception exc) {
        zzewtVar.zza.zzw(exc, "TrustlessTokenSignal");
        return new zzewu(null);
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 50;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        zzbcv zzbcvVar = zzbde.zzhk;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() && this.zzb) {
            return zzgdn.zzh(new zzewu(null));
        }
        if (this.zzf == 2) {
            return zzgdn.zzh(new zzewu(null));
        }
        if (!Arrays.asList(((String) zzbdVar.zzd.zzb(zzbde.zzhm)).split(",")).contains(String.valueOf(this.zze))) {
            return zzgdn.zzh(new zzewu(null));
        }
        ListenableFuture listenableFutureZzh = zzgdn.zzh(null);
        zzfve zzfveVar = new zzfve() { // from class: com.google.android.gms.internal.ads.zzewr
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj) {
                return new zzewu((String) obj);
            }
        };
        zzgdy zzgdyVar = this.zzd;
        return zzgdn.zze(zzgdn.zzo(zzgdn.zzm(listenableFutureZzh, zzfveVar, zzgdyVar), ((Long) zzbfs.zzb.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzc), Exception.class, new zzfve() { // from class: com.google.android.gms.internal.ads.zzews
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj) {
                return zzewt.zzc(this.zza, (Exception) obj);
            }
        }, zzgdyVar);
    }
}
