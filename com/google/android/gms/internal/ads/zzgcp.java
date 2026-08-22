package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
final class zzgcp extends zzgco {
    private static final AtomicReferenceFieldUpdater zza = AtomicReferenceFieldUpdater.newUpdater(zzgcs.class, Set.class, "seenExceptionsField");
    private static final AtomicIntegerFieldUpdater zzb = AtomicIntegerFieldUpdater.newUpdater(zzgcs.class, "remainingField");

    private zzgcp() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgco
    public final int zza(zzgcs zzgcsVar) {
        return zzb.decrementAndGet(zzgcsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgco
    public final void zzb(zzgcs zzgcsVar, Set set, Set set2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = zza;
        while (!atomicReferenceFieldUpdater.compareAndSet(zzgcsVar, null, set2)) {
            if (atomicReferenceFieldUpdater.get(zzgcsVar) != null && atomicReferenceFieldUpdater.get(zzgcsVar) != null) {
                return;
            }
        }
    }

    public /* synthetic */ zzgcp(zzgcr zzgcrVar) {
        super(null);
    }
}
