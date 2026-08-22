package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
class zzfxh extends zzfxf implements List {
    final /* synthetic */ zzfxi zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfxh(zzfxi zzfxiVar, Object obj, List list, zzfxf zzfxfVar) {
        super(zzfxiVar, obj, list, zzfxfVar);
        Objects.requireNonNull(zzfxiVar);
        this.zzf = zzfxiVar;
    }

    @Override // java.util.List
    public final void add(int i, Object obj) {
        zzb();
        boolean zIsEmpty = this.zzb.isEmpty();
        ((List) this.zzb).add(i, obj);
        this.zzf.zzb++;
        if (zIsEmpty) {
            zza();
        }
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zAddAll = ((List) this.zzb).addAll(i, collection);
        if (!zAddAll) {
            return zAddAll;
        }
        int size2 = this.zzb.size();
        this.zzf.zzb += size2 - size;
        if (size != 0) {
            return zAddAll;
        }
        zza();
        return true;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzb();
        return ((List) this.zzb).get(i);
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        zzb();
        return ((List) this.zzb).indexOf(obj);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        zzb();
        return ((List) this.zzb).lastIndexOf(obj);
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        zzb();
        return new zzfxg(this);
    }

    @Override // java.util.List
    public final Object remove(int i) {
        zzb();
        Object objRemove = ((List) this.zzb).remove(i);
        this.zzf.zzb--;
        zzc();
        return objRemove;
    }

    @Override // java.util.List
    public final Object set(int i, Object obj) {
        zzb();
        return ((List) this.zzb).set(i, obj);
    }

    @Override // java.util.List
    public final List subList(int i, int i2) {
        zzb();
        List listSubList = ((List) this.zzb).subList(i, i2);
        zzfxf zzfxfVar = this.zzc;
        if (zzfxfVar == null) {
            zzfxfVar = this;
        }
        return this.zzf.zzh(this.zza, listSubList, zzfxfVar);
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i) {
        zzb();
        return new zzfxg(this, i);
    }
}
