package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public final class zzcuu {
    private final AtomicLong zza;

    public zzcuu(zzfcn zzfcnVar) {
        AtomicLong atomicLong = new AtomicLong();
        this.zza = atomicLong;
        atomicLong.set(zzfcnVar.zza.zza.zzt.get());
    }

    public final long zza() {
        return this.zza.get();
    }

    public final void zzb(long j) {
        this.zza.set(j);
    }
}
