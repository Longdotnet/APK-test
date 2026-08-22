package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzgnv {
    private static final zzgnv zza = new zzgnv();
    private final AtomicReference zzb = new AtomicReference(new zzgov(new zzgos(null), null));

    public static zzgnv zza() {
        return zza;
    }

    public final Object zzb(zzgez zzgezVar, Class cls) {
        return ((zzgov) this.zzb.get()).zzb(zzgezVar, cls);
    }

    public final synchronized void zzc(zzgoq zzgoqVar) {
        AtomicReference atomicReference = this.zzb;
        zzgos zzgosVar = new zzgos((zzgov) atomicReference.get(), null);
        zzgosVar.zza(zzgoqVar);
        atomicReference.set(new zzgov(zzgosVar, null));
    }

    public final synchronized void zzd(zzgow zzgowVar) {
        AtomicReference atomicReference = this.zzb;
        zzgos zzgosVar = new zzgos((zzgov) atomicReference.get(), null);
        zzgosVar.zzb(zzgowVar);
        atomicReference.set(new zzgov(zzgosVar, null));
    }
}
