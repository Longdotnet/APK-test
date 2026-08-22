package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class zzfwv extends zzfzm {
    final transient Map zza;
    final /* synthetic */ zzfxi zzb;

    public zzfwv(zzfxi zzfxiVar, Map map) {
        Objects.requireNonNull(zzfxiVar);
        this.zzb = zzfxiVar;
        this.zza = map;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        zzfxi zzfxiVar = this.zzb;
        if (this.zza == zzfxiVar.zza) {
            zzfxiVar.zzp();
        } else {
            zzfza.zzb(new zzfwu(this));
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Map map = this.zza;
        map.getClass();
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        return this == obj || this.zza.equals(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        Collection collection = (Collection) zzfzn.zza(this.zza, obj);
        if (collection == null) {
            return null;
        }
        return this.zzb.zzc(obj, collection);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // com.google.android.gms.internal.ads.zzfzm, java.util.AbstractMap, java.util.Map
    public Set keySet() {
        return this.zzb.zzt();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        Collection collection = (Collection) this.zza.remove(obj);
        if (collection == null) {
            return null;
        }
        zzfxi zzfxiVar = this.zzb;
        Collection collectionZza = zzfxiVar.zza();
        collectionZza.addAll(collection);
        zzfxiVar.zzb -= collection.size();
        collection.clear();
        return collectionZza;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.zza.size();
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        return this.zza.toString();
    }

    public final Map.Entry zza(Map.Entry entry) {
        Object key = entry.getKey();
        return new zzfym(key, this.zzb.zzc(key, (Collection) entry.getValue()));
    }

    @Override // com.google.android.gms.internal.ads.zzfzm
    public final Set zzb() {
        return new zzfwt(this);
    }
}
