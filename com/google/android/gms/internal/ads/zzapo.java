package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzapo implements Runnable {
    final /* synthetic */ zzaqd zza;
    final /* synthetic */ zzapp zzb;

    public zzapo(zzapp zzappVar, zzaqd zzaqdVar) {
        this.zza = zzaqdVar;
        Objects.requireNonNull(zzappVar);
        this.zzb = zzappVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzb.zzc.put(this.zza);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
