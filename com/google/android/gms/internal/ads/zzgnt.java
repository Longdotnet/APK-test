package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzgnt {
    private static final zzgnt zza = new zzgnt();
    private static final zzgnr zzb = new zzgnr(null);
    private final AtomicReference zzc = new AtomicReference();

    public static zzgnt zzb() {
        return zza;
    }

    public final zzgnj zza() {
        zzgnj zzgnjVar = (zzgnj) this.zzc.get();
        return zzgnjVar == null ? zzb : zzgnjVar;
    }
}
