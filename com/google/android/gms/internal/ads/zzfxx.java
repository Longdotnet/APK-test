package com.google.android.gms.internal.ads;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzfxx extends AbstractCollection {
    final /* synthetic */ zzfxz zza;

    public zzfxx(zzfxz zzfxzVar) {
        Objects.requireNonNull(zzfxzVar);
        this.zza = zzfxzVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.zza.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        zzfxz zzfxzVar = this.zza;
        Map mapZzl = zzfxzVar.zzl();
        return mapZzl != null ? mapZzl.values().iterator() : new zzfxs(zzfxzVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.zza.size();
    }
}
