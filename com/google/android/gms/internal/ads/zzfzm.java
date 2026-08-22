package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
abstract class zzfzm extends AbstractMap {
    private transient Set zza;
    private transient Set zzb;
    private transient Collection zzc;

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        Set set = this.zza;
        if (set != null) {
            return set;
        }
        Set setZzb = zzb();
        this.zza = setZzb;
        return setZzb;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        Set set = this.zzb;
        if (set != null) {
            return set;
        }
        Set setZze = zze();
        this.zzb = setZze;
        return setZze;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        Collection collection = this.zzc;
        if (collection != null) {
            return collection;
        }
        zzfzl zzfzlVar = new zzfzl(this);
        this.zzc = zzfzlVar;
        return zzfzlVar;
    }

    public abstract Set zzb();

    public Set zze() {
        return new zzfzk(this);
    }
}
