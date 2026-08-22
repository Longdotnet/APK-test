package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzfgi {
    final /* synthetic */ zzfgs zza;
    private final Object zzb;
    private final List zzc;

    public /* synthetic */ zzfgi(zzfgs zzfgsVar, Object obj, List list, zzfgr zzfgrVar) {
        Objects.requireNonNull(zzfgsVar);
        this.zza = zzfgsVar;
        this.zzb = obj;
        this.zzc = list;
    }

    public final zzfgq zza(Callable callable) {
        List list = this.zzc;
        zzgdl zzgdlVarZzb = zzgdn.zzb(list);
        ListenableFuture listenableFutureZza = zzgdlVarZzb.zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzfgh
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return null;
            }
        }, zzcaf.zzg);
        zzfgs zzfgsVar = this.zza;
        return new zzfgq(zzfgsVar, this.zzb, listenableFutureZza, list, zzgdlVarZzb.zza(callable, zzfgsVar.zzb));
    }
}
