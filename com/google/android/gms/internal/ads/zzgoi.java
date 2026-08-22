package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzgoi implements Iterable {
    final /* synthetic */ List zza;
    final /* synthetic */ List zzb;

    public zzgoi(zzgom zzgomVar, List list, List list2) {
        this.zza = list;
        this.zzb = list2;
        Objects.requireNonNull(zzgomVar);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new zzgok(this.zza.iterator(), this.zzb.iterator(), null);
    }
}
