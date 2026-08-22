package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlinx.coroutines.internal.Jbo.ygoi;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzfyt implements Map, Serializable {
    private transient zzfyv zza;
    private transient zzfyv zzb;
    private transient zzfyl zzc;

    public static zzfyt zzc(Map map) {
        Set setEntrySet = map.entrySet();
        zzfys zzfysVar = new zzfys(setEntrySet instanceof Collection ? setEntrySet.size() : 4);
        zzfysVar.zzb(setEntrySet);
        return zzfysVar.zzc();
    }

    public static zzfyt zzd() {
        return zzgah.zza;
    }

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
        return zzfzn.zzb(this, obj);
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
        return zzgas.zza(entrySet());
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
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

    public final String toString() {
        int size = size();
        zzfxn.zza(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(((long) size) * 8, 1073741824L));
        sb.append('{');
        boolean z = true;
        for (Map.Entry entry : entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            z = false;
        }
        sb.append('}');
        return sb.toString();
    }

    public abstract zzfyl zza();

    @Override // java.util.Map
    /* JADX INFO: renamed from: zzb */
    public final zzfyl values() {
        zzfyl zzfylVar = this.zzc;
        if (zzfylVar != null) {
            return zzfylVar;
        }
        zzfyl zzfylVarZza = zza();
        this.zzc = zzfylVarZza;
        return zzfylVarZza;
    }

    public abstract zzfyv zzf();

    public abstract zzfyv zzg();

    @Override // java.util.Map
    /* JADX INFO: renamed from: zzh */
    public final zzfyv entrySet() {
        zzfyv zzfyvVar = this.zza;
        if (zzfyvVar != null) {
            return zzfyvVar;
        }
        zzfyv zzfyvVarZzf = zzf();
        this.zza = zzfyvVarZzf;
        return zzfyvVarZzf;
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: zzi */
    public final zzfyv keySet() {
        zzfyv zzfyvVar = this.zzb;
        if (zzfyvVar != null) {
            return zzfyvVar;
        }
        zzfyv zzfyvVarZzg = zzg();
        this.zzb = zzfyvVarZzg;
        return zzfyvVarZzg;
    }

    public static zzfyt zze(Object obj, Object obj2) {
        String str = ygoi.aMQSoBfhgvLba;
        zzfxn.zzb(str, obj2);
        return zzgah.zzj(1, new Object[]{str, obj2}, null);
    }
}
