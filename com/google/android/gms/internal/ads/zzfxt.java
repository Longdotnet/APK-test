package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzfxt extends AbstractSet {
    final /* synthetic */ zzfxz zza;

    public zzfxt(zzfxz zzfxzVar) {
        Objects.requireNonNull(zzfxzVar);
        this.zza = zzfxzVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.zza.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        zzfxz zzfxzVar = this.zza;
        Map mapZzl = zzfxzVar.zzl();
        if (mapZzl != null) {
            return mapZzl.entrySet().contains(obj);
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            int iZzw = zzfxzVar.zzw(entry.getKey());
            if (iZzw != -1 && zzfvm.zza(zzfxz.zzj(zzfxzVar, iZzw), entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        zzfxz zzfxzVar = this.zza;
        Map mapZzl = zzfxzVar.zzl();
        return mapZzl != null ? mapZzl.entrySet().iterator() : new zzfxr(zzfxzVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        zzfxz zzfxzVar = this.zza;
        Map mapZzl = zzfxzVar.zzl();
        if (mapZzl != null) {
            return mapZzl.entrySet().remove(obj);
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (zzfxzVar.zzr()) {
            return false;
        }
        int iZzv = zzfxzVar.zzv();
        int iZzb = zzfya.zzb(entry.getKey(), entry.getValue(), iZzv, zzfxz.zzi(zzfxzVar), zzfxzVar.zzA(), zzfxzVar.zzB(), zzfxzVar.zzC());
        if (iZzb == -1) {
            return false;
        }
        zzfxzVar.zzq(iZzb, iZzv);
        zzfxzVar.zzg--;
        zzfxzVar.zzo();
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }
}
