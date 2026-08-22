package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzevi implements zzeuc {
    private final Executor zza;
    private final String zzb;

    public zzevi(zzbzj zzbzjVar, Executor executor, String str, PackageInfo packageInfo, int i) {
        this.zza = executor;
        this.zzb = str;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 41;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        ListenableFuture listenableFutureZzh = zzgdn.zzh(this.zzb);
        zzfve zzfveVar = new zzfve() { // from class: com.google.android.gms.internal.ads.zzevg
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj) {
                return new zzevj((String) obj);
            }
        };
        Executor executor = this.zza;
        return zzgdn.zzf(zzgdn.zzm(listenableFutureZzh, zzfveVar, executor), Throwable.class, new zzgcu() { // from class: com.google.android.gms.internal.ads.zzevh
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzgdn.zzh(new zzevj(this.zza.zzb));
            }
        }, executor);
    }
}
