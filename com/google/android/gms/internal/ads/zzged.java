package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes.dex */
final class zzged extends zzgcb.zzf implements Runnable {
    private final Runnable zza;

    public zzged(Runnable runnable) {
        runnable.getClass();
        this.zza = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zza.run();
        } catch (Throwable th) {
            zzd(th);
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcb
    public final String zza() {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("task=[", this.zza.toString(), "]");
    }
}
