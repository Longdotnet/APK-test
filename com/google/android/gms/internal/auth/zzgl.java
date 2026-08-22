package com.google.android.gms.internal.auth;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
class zzgl<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private final int zza;
    private boolean zzd;
    private volatile zzgk zze;
    private List<zzgi> zzb = Collections.emptyList();
    private Map<K, V> zzc = Collections.emptyMap();
    private Map<K, V> zzf = Collections.emptyMap();

    private final int zzk(K k) {
        int size = this.zzb.size();
        int i = size - 1;
        int i2 = 0;
        if (i >= 0) {
            int iCompareTo = k.compareTo(this.zzb.get(i).zza());
            if (iCompareTo > 0) {
                return -(size + 1);
            }
            if (iCompareTo == 0) {
                return i;
            }
        }
        while (i2 <= i) {
            int i3 = (i2 + i) / 2;
            int iCompareTo2 = k.compareTo(this.zzb.get(i3).zza());
            if (iCompareTo2 < 0) {
                i = i3 - 1;
            } else {
                if (iCompareTo2 <= 0) {
                    return i3;
                }
                i2 = i3 + 1;
            }
        }
        return -(i2 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V zzl(int i) {
        zzn();
        V v = (V) this.zzb.remove(i).getValue();
        if (!this.zzc.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = zzm().entrySet().iterator();
            List<zzgi> list = this.zzb;
            Map.Entry<K, V> next = it.next();
            list.add(new zzgi(this, next.getKey(), next.getValue()));
            it.remove();
        }
        return v;
    }

    private final SortedMap<K, V> zzm() {
        zzn();
        if (this.zzc.isEmpty() && !(this.zzc instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzc = treeMap;
            this.zzf = treeMap.descendingMap();
        }
        return (SortedMap) this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzn() {
        if (this.zzd) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        zzn();
        if (!this.zzb.isEmpty()) {
            this.zzb.clear();
        }
        if (this.zzc.isEmpty()) {
            return;
        }
        this.zzc.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zzk(comparable) >= 0 || this.zzc.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        if (this.zze == null) {
            this.zze = new zzgk(this, null);
        }
        return this.zze;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgl)) {
            return super.equals(obj);
        }
        zzgl zzglVar = (zzgl) obj;
        int size = size();
        if (size != zzglVar.size()) {
            return false;
        }
        int iZzb = zzb();
        if (iZzb != zzglVar.zzb()) {
            return entrySet().equals(zzglVar.entrySet());
        }
        for (int i = 0; i < iZzb; i++) {
            if (!zzg(i).equals(zzglVar.zzg(i))) {
                return false;
            }
        }
        if (iZzb != size) {
            return this.zzc.equals(zzglVar.zzc);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iZzk = zzk(comparable);
        return iZzk >= 0 ? (V) this.zzb.get(iZzk).getValue() : this.zzc.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int iZzb = zzb();
        int iHashCode = 0;
        for (int i = 0; i < iZzb; i++) {
            iHashCode += this.zzb.get(i).hashCode();
        }
        return this.zzc.size() > 0 ? this.zzc.hashCode() + iHashCode : iHashCode;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        zzn();
        Comparable comparable = (Comparable) obj;
        int iZzk = zzk(comparable);
        if (iZzk >= 0) {
            return zzl(iZzk);
        }
        if (this.zzc.isEmpty()) {
            return null;
        }
        return this.zzc.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.zzc.size() + this.zzb.size();
    }

    public void zza() {
        if (this.zzd) {
            return;
        }
        this.zzc = this.zzc.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzc);
        this.zzf = this.zzf.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzf);
        this.zzd = true;
    }

    public final int zzb() {
        return this.zzb.size();
    }

    public final Iterable<Map.Entry<K, V>> zzc() {
        return this.zzc.isEmpty() ? zzgh.zza() : this.zzc.entrySet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
    public final V put(K k, V v) {
        zzn();
        int iZzk = zzk(k);
        if (iZzk >= 0) {
            return (V) this.zzb.get(iZzk).setValue(v);
        }
        zzn();
        if (this.zzb.isEmpty() && !(this.zzb instanceof ArrayList)) {
            this.zzb = new ArrayList(this.zza);
        }
        int i = -(iZzk + 1);
        if (i >= this.zza) {
            return zzm().put(k, v);
        }
        int size = this.zzb.size();
        int i2 = this.zza;
        if (size == i2) {
            zzgi zzgiVarRemove = this.zzb.remove(i2 - 1);
            zzm().put(zzgiVarRemove.zza(), zzgiVarRemove.getValue());
        }
        this.zzb.add(i, new zzgi(this, k, v));
        return null;
    }

    public final Map.Entry<K, V> zzg(int i) {
        return this.zzb.get(i);
    }

    public final boolean zzj() {
        return this.zzd;
    }
}
