package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzfnn implements Runnable {
    final /* synthetic */ zzfns zza;

    public zzfnn(zzfns zzfnsVar) {
        Objects.requireNonNull(zzfnsVar);
        this.zza = zzfnsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzl.zzb();
    }
}
