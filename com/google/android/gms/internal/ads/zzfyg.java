package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzfyg extends zzfyh implements Map {
    @Override // java.util.Map
    public final void clear() {
        zzb().clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return zzb().containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return zzb().containsValue(obj);
    }

    @Override // java.util.Map
    public Set entrySet() {
        return zzb().entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return obj == this || zzb().equals(obj);
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        return zzb().get(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return zzb().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return zzb().isEmpty();
    }

    @Override // java.util.Map
    public Set keySet() {
        return zzb().keySet();
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        return zzb().put(obj, obj2);
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        zzb().putAll(map);
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        return zzb().remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return zzb().size();
    }

    @Override // java.util.Map
    public final Collection values() {
        return zzb().values();
    }

    @Override // com.google.android.gms.internal.ads.zzfyh
    public /* bridge */ /* synthetic */ Object zza() {
        throw null;
    }

    public abstract Map zzb();

    public final int zzc() {
        return zzgas.zza(entrySet());
    }

    public final boolean zzd(Object obj) {
        zzfzi zzfziVar = new zzfzi(entrySet().iterator());
        if (obj == null) {
            while (zzfziVar.hasNext()) {
                if (zzfziVar.next() == null) {
                }
            }
            return false;
        }
        while (zzfziVar.hasNext()) {
            if (obj.equals(zzfziVar.next())) {
            }
        }
        return false;
        return true;
    }

    public final boolean zze(Object obj) {
        return zzfzn.zzb(this, obj);
    }
}
