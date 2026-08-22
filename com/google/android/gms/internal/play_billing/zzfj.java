package com.google.android.gms.internal.play_billing;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class zzfj implements Iterator {
    final Iterator zza;
    final /* synthetic */ zzfk zzb;

    public zzfj(zzfk zzfkVar) {
        this.zzb = zzfkVar;
        this.zza = zzfkVar.zza.iterator();
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
