package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzfxv extends AbstractSet {
    final /* synthetic */ zzfxz zza;

    public zzfxv(zzfxz zzfxzVar) {
        Objects.requireNonNull(zzfxzVar);
        this.zza = zzfxzVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.zza.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.zza.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        zzfxz zzfxzVar = this.zza;
        Map mapZzl = zzfxzVar.zzl();
        return mapZzl != null ? mapZzl.keySet().iterator() : new zzfxq(zzfxzVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        zzfxz zzfxzVar = this.zza;
        Map mapZzl = zzfxzVar.zzl();
        if (mapZzl != null) {
            return mapZzl.keySet().remove(obj);
        }
        return zzfxzVar.zzy(obj) != zzfxz.zzd;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }
}
