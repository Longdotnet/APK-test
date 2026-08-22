package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzfgk {
    public static final zzfgq zza(Callable callable, Object obj, zzfgs zzfgsVar) {
        return zzb(callable, zzfgsVar.zzb, obj, zzfgsVar);
    }

    public static final zzfgq zzb(Callable callable, zzgdy zzgdyVar, Object obj, zzfgs zzfgsVar) {
        return new zzfgq(zzfgsVar, obj, zzfgs.zza, Collections.emptyList(), zzgdyVar.zzb(callable));
    }

    public static final zzfgq zzc(ListenableFuture listenableFuture, Object obj, zzfgs zzfgsVar) {
        return new zzfgq(zzfgsVar, obj, zzfgs.zza, Collections.emptyList(), listenableFuture);
    }

    public static final zzfgq zzd(final zzfgf zzfgfVar, zzgdy zzgdyVar, Object obj, zzfgs zzfgsVar) {
        return zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzfgj
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzfgfVar.zza();
                return null;
            }
        }, zzgdyVar, obj, zzfgsVar);
    }
}
