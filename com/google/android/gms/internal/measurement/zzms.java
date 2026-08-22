package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class zzms implements Iterator {
    final Iterator zza;
    final /* synthetic */ zzmt zzb;

    public zzms(zzmt zzmtVar) {
        this.zzb = zzmtVar;
        this.zza = zzmtVar.zza.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
