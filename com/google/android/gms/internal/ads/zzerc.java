package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzerc implements zzeuc {
    private final zzgdy zza;

    public zzerc(zzgdy zzgdyVar) {
        this.zza = zzgdyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 20;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzerb
            @Override // java.util.concurrent.Callable
            public final Object call() {
                String str;
                com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
                com.google.android.gms.ads.internal.util.zzay zzayVar = zzvVar.zzp;
                synchronized (zzayVar.zzb) {
                    str = zzayVar.zzd;
                }
                return new zzerd(str, zzvVar.zzp.zzm());
            }
        });
    }
}
