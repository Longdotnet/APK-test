package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;

/* JADX INFO: loaded from: classes.dex */
abstract class zzfxi extends zzfxl implements Serializable {
    private final transient Map zza;
    private transient int zzb;

    public zzfxi(Map map) {
        zzfvp.zze(map.isEmpty());
        this.zza = map;
    }

    public static /* bridge */ /* synthetic */ void zzo(zzfxi zzfxiVar, Object obj) {
        Object objRemove;
        try {
            objRemove = zzfxiVar.zza.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            objRemove = null;
        }
        Collection collection = (Collection) objRemove;
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            zzfxiVar.zzb -= size;
        }
    }

    public abstract Collection zza();

    public Collection zzb(Collection collection) {
        throw null;
    }

    public Collection zzc(Object obj, Collection collection) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzfzo
    public final int zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfxl
    public final Collection zzf() {
        return new zzfxk(this);
    }

    @Override // com.google.android.gms.internal.ads.zzfxl
    public final Iterator zzg() {
        return new zzfws(this);
    }

    public final List zzh(Object obj, List list, zzfxf zzfxfVar) {
        return list instanceof RandomAccess ? new zzfxb(this, obj, list, zzfxfVar) : new zzfxh(this, obj, list, zzfxfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfxl
    public Map zzj() {
        throw null;
    }

    public final Map zzk() {
        Map map = this.zza;
        if (map instanceof NavigableMap) {
            return new zzfwz(this, (NavigableMap) map);
        }
        return map instanceof SortedMap ? new zzfxc(this, (SortedMap) map) : new zzfwv(this, map);
    }

    @Override // com.google.android.gms.internal.ads.zzfxl
    public Set zzl() {
        throw null;
    }

    public final Set zzm() {
        Map map = this.zza;
        if (map instanceof NavigableMap) {
            return new zzfxa(this, (NavigableMap) map);
        }
        return map instanceof SortedMap ? new zzfxd(this, (SortedMap) map) : new zzfwy(this, map);
    }

    @Override // com.google.android.gms.internal.ads.zzfzo
    public final void zzp() {
        Map map = this.zza;
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).clear();
        }
        map.clear();
        this.zzb = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzfxl, com.google.android.gms.internal.ads.zzfzo
    public final boolean zzq(Object obj, Object obj2) {
        Map map = this.zza;
        Collection collection = (Collection) map.get(obj);
        if (collection != null) {
            if (!collection.add(obj2)) {
                return false;
            }
            this.zzb++;
            return true;
        }
        Collection collectionZza = zza();
        if (!collectionZza.add(obj2)) {
            throw new AssertionError("New Collection violated the Collection spec");
        }
        this.zzb++;
        map.put(obj, collectionZza);
        return true;
    }
}
