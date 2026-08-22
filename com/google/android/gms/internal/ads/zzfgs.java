package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzfgs {
    private static final ListenableFuture zza = zzgdn.zzh(null);
    private final zzgdy zzb;
    private final ScheduledExecutorService zzc;
    private final zzfgt zzd;

    public zzfgs(zzgdy zzgdyVar, ScheduledExecutorService scheduledExecutorService, zzfgt zzfgtVar) {
        this.zzb = zzgdyVar;
        this.zzc = scheduledExecutorService;
        this.zzd = zzfgtVar;
    }

    public final zzfgi zza(Object obj, ListenableFuture... listenableFutureArr) {
        return new zzfgi(this, obj, Arrays.asList(listenableFutureArr), null);
    }

    public final zzfgq zzb(Object obj, ListenableFuture listenableFuture) {
        return new zzfgq(this, obj, listenableFuture, Collections.singletonList(listenableFuture), listenableFuture);
    }

    public abstract String zzf(Object obj);
}
