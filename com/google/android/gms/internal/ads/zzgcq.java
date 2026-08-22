package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class zzgcq extends zzgco {
    private zzgcq() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgco
    public final int zza(zzgcs zzgcsVar) {
        int i;
        synchronized (zzgcsVar) {
            i = zzgcsVar.remainingField - 1;
            zzgcsVar.remainingField = i;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzgco
    public final void zzb(zzgcs zzgcsVar, Set set, Set set2) {
        synchronized (zzgcsVar) {
            try {
                if (zzgcsVar.seenExceptionsField == null) {
                    zzgcsVar.seenExceptionsField = set2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public /* synthetic */ zzgcq(zzgcr zzgcrVar) {
        super(null);
    }
}
