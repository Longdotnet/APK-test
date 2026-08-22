package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzewc implements zzeuc {
    final zzgdy zza;
    final List zzb;

    public zzewc(zzbcn zzbcnVar, zzgdy zzgdyVar, List list) {
        this.zza = zzgdyVar;
        this.zzb = list;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 48;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzewb
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzewd(this.zza.zzb);
            }
        });
    }
}
