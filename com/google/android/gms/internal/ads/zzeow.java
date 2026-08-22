package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzeow implements zzeuc {
    private final zzgdy zza;

    public zzeow(zzgdy zzgdyVar) {
        this.zza = zzgdyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 55;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzeov
            @Override // java.util.concurrent.Callable
            public final Object call() {
                com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
                zzvVar.zzl.getClass();
                return new zzeox(System.currentTimeMillis() - ((com.google.android.gms.ads.internal.util.zzj) zzvVar.zzi.zzi()).zzg().zza());
            }
        });
    }
}
