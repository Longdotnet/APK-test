package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class zzaah implements zzaai {
    final /* synthetic */ Executor zza;
    final /* synthetic */ zzdn zzb;

    public zzaah(Executor executor, zzdn zzdnVar) {
        this.zza = executor;
        this.zzb = zzdnVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.zza.execute(runnable);
    }

    @Override // com.google.android.gms.internal.ads.zzaai
    public final void zza() {
        this.zzb.zza(this.zza);
    }
}
