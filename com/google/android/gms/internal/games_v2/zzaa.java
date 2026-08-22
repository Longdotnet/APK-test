package com.google.android.gms.internal.games_v2;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzaa implements Runnable {
    final /* synthetic */ zzab zza;

    public zzaa(zzab zzabVar) {
        Objects.requireNonNull(zzabVar);
        this.zza = zzabVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzd();
    }
}
