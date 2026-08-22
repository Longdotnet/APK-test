package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
final class zzgmd implements zzgmf {
    private final AtomicBoolean zza = new AtomicBoolean(false);

    public zzgmd(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzgmf
    public final boolean zza() {
        return this.zza.get();
    }
}
