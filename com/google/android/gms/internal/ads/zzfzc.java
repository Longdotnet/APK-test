package com.google.android.gms.internal.ads;

import java.util.ListIterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzfzc extends zzgav {
    final /* synthetic */ zzfzd zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfzc(zzfzd zzfzdVar, ListIterator listIterator) {
        super(listIterator);
        Objects.requireNonNull(zzfzdVar);
        this.zza = zzfzdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgau
    public final Object zza(Object obj) {
        return this.zza.zzb.apply(obj);
    }
}
