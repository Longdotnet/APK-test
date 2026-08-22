package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzeas {
    private final zzeao zza;
    private final zzgdy zzb;

    public zzeas(zzeao zzeaoVar, zzgdy zzgdyVar) {
        this.zza = zzeaoVar;
        this.zzb = zzgdyVar;
    }

    public final void zza(zzfge zzfgeVar) {
        final zzeao zzeaoVar = this.zza;
        Objects.requireNonNull(zzeaoVar);
        Callable callable = new Callable() { // from class: com.google.android.gms.internal.ads.zzeaq
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzeaoVar.getWritableDatabase();
            }
        };
        zzgdy zzgdyVar = this.zzb;
        zzgdn.zzr(zzgdyVar.zzb(callable), new zzear(this, zzfgeVar), zzgdyVar);
    }
}
