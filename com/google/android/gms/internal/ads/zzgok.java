package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class zzgok implements Iterator {
    private final Iterator zza;
    private final Iterator zzb;

    public /* synthetic */ zzgok(Iterator it, Iterator it2, zzgol zzgolVar) {
        this.zza = it;
        this.zzb = it2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext() || this.zzb.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Iterator it = this.zza;
        return it.hasNext() ? it.next() : this.zzb.next();
    }
}
