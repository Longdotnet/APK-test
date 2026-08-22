package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class zzena {
    private final AtomicBoolean zza = new AtomicBoolean(false);
    private zzemz zzb;

    public final zzemz zza() {
        return this.zzb;
    }

    public final void zzb(zzemz zzemzVar) {
        this.zzb = zzemzVar;
    }

    public final void zzc(boolean z) {
        this.zza.set(true);
    }

    public final boolean zzd() {
        return this.zza.get();
    }
}
