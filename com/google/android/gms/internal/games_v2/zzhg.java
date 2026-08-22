package com.google.android.gms.internal.games_v2;

import com.google.android.datatransport.runtime.synchronization.JDyk.FETmZwrVHuasmL;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzhg implements Map, Serializable {
    private transient zzhk zza;
    private transient zzhk zzb;
    private transient zzgy zzc;

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map
    public abstract Object get(Object obj);

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    public final int hashCode() {
        return zzih.zza(entrySet());
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        zzhk zzhkVar = this.zzb;
        if (zzhkVar != null) {
            return zzhkVar;
        }
        zzhk zzhkVarZzc = zzc();
        this.zzb = zzhkVarZzc;
        return zzhkVarZzc;
    }

    @Override // java.util.Map
    @Deprecated
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: zza */
    public final zzhk entrySet() {
        zzhk zzhkVar = this.zza;
        if (zzhkVar != null) {
            return zzhkVar;
        }
        zzhk zzhkVarZzb = zzb();
        this.zza = zzhkVarZzb;
        return zzhkVarZzb;
    }

    public abstract zzhk zzb();

    public abstract zzhk zzc();

    @Override // java.util.Map
    /* JADX INFO: renamed from: zzd */
    public final zzgy values() {
        zzgy zzgyVar = this.zzc;
        if (zzgyVar != null) {
            return zzgyVar;
        }
        zzgy zzgyVarZze = zze();
        this.zzc = zzgyVarZze;
        return zzgyVarZze;
    }

    public abstract zzgy zze();

    public final String toString() {
        int size = size();
        zzgn.zzb(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(((long) size) * 8, 1073741824L));
        sb.append('{');
        boolean z = true;
        for (Map.Entry entry : entrySet()) {
            if (!z) {
                sb.append(FETmZwrVHuasmL.qPb);
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            z = false;
        }
        sb.append('}');
        return sb.toString();
    }
}
