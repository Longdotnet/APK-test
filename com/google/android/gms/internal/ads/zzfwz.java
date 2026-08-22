package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes.dex */
final class zzfwz extends zzfxc implements NavigableMap {
    final /* synthetic */ zzfxi zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfwz(zzfxi zzfxiVar, NavigableMap navigableMap) {
        super(zzfxiVar, navigableMap);
        Objects.requireNonNull(zzfxiVar);
        this.zzc = zzfxiVar;
    }

    @Override // java.util.NavigableMap
    public final Map.Entry ceilingEntry(Object obj) {
        Map.Entry entryCeilingEntry = ((NavigableMap) ((SortedMap) ((zzfwv) this).zza)).ceilingEntry(obj);
        if (entryCeilingEntry == null) {
            return null;
        }
        return zza(entryCeilingEntry);
    }

    @Override // java.util.NavigableMap
    public final Object ceilingKey(Object obj) {
        return ((NavigableMap) ((SortedMap) ((zzfwv) this).zza)).ceilingKey(obj);
    }

    @Override // java.util.NavigableMap
    public final NavigableSet descendingKeySet() {
        return (NavigableSet) super.keySet();
    }

    @Override // java.util.NavigableMap
    public final NavigableMap descendingMap() {
        return new zzfwz(this.zzc, ((NavigableMap) ((SortedMap) ((zzfwv) this).zza)).descendingMap());
    }

    @Override // java.util.NavigableMap
    public final Map.Entry firstEntry() {
        Map.Entry entryFirstEntry = ((NavigableMap) ((SortedMap) ((zzfwv) this).zza)).firstEntry();
        if (entryFirstEntry == null) {
            return null;
        }
        return zza(entryFirstEntry);
    }

    @Override // java.util.NavigableMap
    public final Map.Entry floorEntry(Object obj) {
        Map.Entry entryFloorEntry = ((NavigableMap) ((SortedMap) ((zzfwv) this).zza)).floorEntry(obj);
        if (entryFloorEntry == null) {
            return null;
        }
        return zza(entryFloorEntry);
    }

    @Override // java.util.NavigableMap
    public final Object floorKey(Object obj) {
        return ((NavigableMap) ((SortedMap) ((zzfwv) this).zza)).floorKey(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzfxc, java.util.SortedMap, java.util.NavigableMap
    public final /* synthetic */ SortedMap headMap(Object obj) {
        return headMap(obj, false);
    }

    @Override // java.util.NavigableMap
    public final Map.Entry higherEntry(Object obj) {
        Map.Entry entryHigherEntry = ((NavigableMap) ((SortedMap) ((zzfwv) this).zza)).higherEntry(obj);
        if (entryHigherEntry == null) {
            return null;
        }
        return zza(entryHigherEntry);
    }

    @Override // java.util.NavigableMap
    public final Object higherKey(Object obj) {
        return ((NavigableMap) ((SortedMap) ((zzfwv) this).zza)).higherKey(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzfxc, com.google.android.gms.internal.ads.zzfwv, com.google.android.gms.internal.ads.zzfzm, java.util.AbstractMap, java.util.Map
    public final /* synthetic */ Set keySet() {
        return (NavigableSet) super.keySet();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry lastEntry() {
        Map.Entry entryLastEntry = ((NavigableMap) ((SortedMap) ((zzfwv) this).zza)).lastEntry();
        if (entryLastEntry == null) {
            return null;
        }
        return zza(entryLastEntry);
    }

    @Override // java.util.NavigableMap
    public final Map.Entry lowerEntry(Object obj) {
        Map.Entry entryLowerEntry = ((NavigableMap) ((SortedMap) ((zzfwv) this).zza)).lowerEntry(obj);
        if (entryLowerEntry == null) {
            return null;
        }
        return zza(entryLowerEntry);
    }

    @Override // java.util.NavigableMap
    public final Object lowerKey(Object obj) {
        return ((NavigableMap) ((SortedMap) ((zzfwv) this).zza)).lowerKey(obj);
    }

    @Override // java.util.NavigableMap
    public final NavigableSet navigableKeySet() {
        return (NavigableSet) super.keySet();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry pollFirstEntry() {
        return zzc(entrySet().iterator());
    }

    @Override // java.util.NavigableMap
    public final Map.Entry pollLastEntry() {
        return zzc(descendingMap().entrySet().iterator());
    }

    @Override // com.google.android.gms.internal.ads.zzfxc, java.util.SortedMap, java.util.NavigableMap
    public final /* bridge */ /* synthetic */ SortedMap subMap(Object obj, Object obj2) {
        return subMap(obj, true, obj2, false);
    }

    @Override // com.google.android.gms.internal.ads.zzfxc, java.util.SortedMap, java.util.NavigableMap
    public final /* synthetic */ SortedMap tailMap(Object obj) {
        return tailMap(obj, true);
    }

    public final Map.Entry zzc(Iterator it) {
        if (!it.hasNext()) {
            return null;
        }
        Map.Entry entry = (Map.Entry) it.next();
        zzfxi zzfxiVar = this.zzc;
        Collection collectionZza = zzfxiVar.zza();
        collectionZza.addAll((Collection) entry.getValue());
        it.remove();
        return new zzfym(entry.getKey(), zzfxiVar.zzb(collectionZza));
    }

    @Override // com.google.android.gms.internal.ads.zzfxc
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final NavigableSet zzg() {
        return new zzfxa(this.zzc, (NavigableMap) ((SortedMap) ((zzfwv) this).zza));
    }

    @Override // com.google.android.gms.internal.ads.zzfxc
    public final /* synthetic */ SortedMap zzf() {
        return (NavigableMap) ((SortedMap) ((zzfwv) this).zza);
    }

    @Override // com.google.android.gms.internal.ads.zzfxc
    /* JADX INFO: renamed from: zzh */
    public final /* synthetic */ SortedSet keySet() {
        return (NavigableSet) super.keySet();
    }

    @Override // java.util.NavigableMap
    public final NavigableMap headMap(Object obj, boolean z) {
        return new zzfwz(this.zzc, ((NavigableMap) ((SortedMap) ((zzfwv) this).zza)).headMap(obj, z));
    }

    @Override // java.util.NavigableMap
    public final NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
        return new zzfwz(this.zzc, ((NavigableMap) ((SortedMap) ((zzfwv) this).zza)).subMap(obj, z, obj2, z2));
    }

    @Override // java.util.NavigableMap
    public final NavigableMap tailMap(Object obj, boolean z) {
        return new zzfwz(this.zzc, ((NavigableMap) ((SortedMap) ((zzfwv) this).zza)).tailMap(obj, z));
    }
}
