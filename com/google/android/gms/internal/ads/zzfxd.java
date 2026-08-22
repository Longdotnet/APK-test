package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.Objects;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes.dex */
class zzfxd extends zzfwy implements SortedSet {
    final /* synthetic */ zzfxi zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfxd(zzfxi zzfxiVar, SortedMap sortedMap) {
        super(zzfxiVar, sortedMap);
        Objects.requireNonNull(zzfxiVar);
        this.zzc = zzfxiVar;
    }

    @Override // java.util.SortedSet
    public final Comparator comparator() {
        return zza().comparator();
    }

    @Override // java.util.SortedSet
    public final Object first() {
        return zza().firstKey();
    }

    public SortedSet headSet(Object obj) {
        return new zzfxd(this.zzc, zza().headMap(obj));
    }

    @Override // java.util.SortedSet
    public final Object last() {
        return zza().lastKey();
    }

    public SortedSet subSet(Object obj, Object obj2) {
        return new zzfxd(this.zzc, zza().subMap(obj, obj2));
    }

    public SortedSet tailSet(Object obj) {
        return new zzfxd(this.zzc, zza().tailMap(obj));
    }

    public SortedMap zza() {
        return (SortedMap) this.zzd;
    }
}
