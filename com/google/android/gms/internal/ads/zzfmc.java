package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzfmc implements Runnable {
    final /* synthetic */ float zza;
    final /* synthetic */ zzfmd zzb;

    public zzfmc(zzfmd zzfmdVar, float f) {
        this.zza = f;
        Objects.requireNonNull(zzfmdVar);
        this.zzb = zzfmdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzg.zze(this.zza);
    }
}
