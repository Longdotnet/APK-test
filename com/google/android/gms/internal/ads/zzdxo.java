package com.google.android.gms.internal.ads;

import android.os.Binder;
import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzdxo {
    private final ScheduledExecutorService zza;
    private final zzgdy zzb;
    private final zzgdy zzc;
    private final zzdyk zzd;
    private final zzhgl zze;

    public zzdxo(ScheduledExecutorService scheduledExecutorService, zzgdy zzgdyVar, zzgdy zzgdyVar2, zzdyk zzdykVar, zzhgl zzhglVar) {
        this.zza = scheduledExecutorService;
        this.zzb = zzgdyVar;
        this.zzc = zzgdyVar2;
        this.zzd = zzdykVar;
        this.zze = zzhglVar;
    }

    public static zzdyy zza(zzdxo zzdxoVar, zzbvq zzbvqVar) {
        return (zzdyy) zzdxoVar.zzd.zza(zzbvqVar).get(((Integer) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzfS)).intValue(), TimeUnit.SECONDS);
    }

    public static /* synthetic */ ListenableFuture zzb(zzdxo zzdxoVar, final zzbvq zzbvqVar, int i, Throwable th) {
        Bundle bundle;
        if (zzbvqVar != null && (bundle = zzbvqVar.zzm) != null) {
            bundle.putBoolean("ls", true);
        }
        return zzgdn.zzn(((zzeab) zzdxoVar.zze.zzb()).zzd(zzbvqVar, i), new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdxl
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzgdn.zzh(new zzdyy((InputStream) obj, zzbvqVar));
            }
        }, zzdxoVar.zzb);
    }

    public final ListenableFuture zzc(final zzbvq zzbvqVar) {
        ListenableFuture listenableFutureZzb;
        String str = zzbvqVar.zzd;
        com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
        if (com.google.android.gms.ads.internal.util.zzs.zzD(str)) {
            listenableFutureZzb = zzgdn.zzg(new zzdyx(1));
        } else {
            listenableFutureZzb = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzhK)).booleanValue() ? this.zzc.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzdxm
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return zzdxo.zza(this.zza, zzbvqVar);
                }
            }) : this.zzd.zza(zzbvqVar);
        }
        final int callingUid = Binder.getCallingUid();
        return (zzgde) zzgdn.zzf((zzgde) zzgdn.zzo(zzgde.zzw(listenableFutureZzb), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzfS)).intValue(), TimeUnit.SECONDS, this.zza), Throwable.class, new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdxn
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzdxo.zzb(this.zza, zzbvqVar, callingUid, (Throwable) obj);
            }
        }, this.zzb);
    }
}
