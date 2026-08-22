package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
class zzfxe implements Iterator {
    final Iterator zza;
    final Collection zzb;
    final /* synthetic */ zzfxf zzc;

    public zzfxe(zzfxf zzfxfVar) {
        Objects.requireNonNull(zzfxfVar);
        this.zzc = zzfxfVar;
        Collection collection = zzfxfVar.zzb;
        this.zzb = collection;
        this.zza = collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        zza();
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        zza();
        return this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.zza.remove();
        zzfxf zzfxfVar = this.zzc;
        zzfxfVar.zze.zzb--;
        zzfxfVar.zzc();
    }

    public final void zza() {
        zzfxf zzfxfVar = this.zzc;
        zzfxfVar.zzb();
        if (zzfxfVar.zzb != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }

    public zzfxe(zzfxf zzfxfVar, Iterator it) {
        Objects.requireNonNull(zzfxfVar);
        this.zzc = zzfxfVar;
        this.zzb = zzfxfVar.zzb;
        this.zza = it;
    }
}
