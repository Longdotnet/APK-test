package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzevy implements zzeuc {
    public zzevy(zzbzg zzbzgVar, zzgdy zzgdyVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 47;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        final ListenableFuture listenableFutureZzh = zzgdn.zzh(null);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzgd)).booleanValue()) {
            listenableFutureZzh = zzgdn.zzh(null);
        }
        final ListenableFuture listenableFutureZzh2 = zzgdn.zzh(null);
        return zzgdn.zzc(listenableFutureZzh, listenableFutureZzh2).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzevx
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzevz((String) listenableFutureZzh.get(), (String) listenableFutureZzh2.get());
            }
        }, zzcaf.zza);
    }
}
