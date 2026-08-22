package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class zzkt extends zzip implements RandomAccess, zzku {
    public static final zzku zza;
    private static final zzkt zzb;
    private final List zzc;

    static {
        zzkt zzktVar = new zzkt(10);
        zzb = zzktVar;
        zzktVar.zzb();
        zza = zzktVar;
    }

    public zzkt() {
        this(10);
    }

    private static String zzj(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        return obj instanceof zzje ? ((zzje) obj).zzn(zzkn.zzb) : zzkn.zzg((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzip, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        zzbT();
        this.zzc.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzip, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        zzbT();
        if (collection instanceof zzku) {
            collection = ((zzku) collection).zzh();
        }
        boolean zAddAll = this.zzc.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // com.google.android.gms.internal.measurement.zzip, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zzbT();
        this.zzc.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzip, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zzbT();
        Object objRemove = this.zzc.remove(i);
        ((AbstractList) this).modCount++;
        return zzj(objRemove);
    }

    @Override // com.google.android.gms.internal.measurement.zzip, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        zzbT();
        return zzj(this.zzc.set(i, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc.size();
    }

    @Override // com.google.android.gms.internal.measurement.zzkm
    public final /* bridge */ /* synthetic */ zzkm zzd(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.zzc);
        return new zzkt(arrayList);
    }

    @Override // com.google.android.gms.internal.measurement.zzku
    public final zzku zze() {
        return zzc() ? new zzmt(this) : this;
    }

    @Override // com.google.android.gms.internal.measurement.zzku
    public final Object zzf(int i) {
        return this.zzc.get(i);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: zzg */
    public final String get(int i) {
        Object obj = this.zzc.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzje) {
            zzje zzjeVar = (zzje) obj;
            String strZzn = zzjeVar.zzn(zzkn.zzb);
            if (zzjeVar.zzi()) {
                this.zzc.set(i, strZzn);
            }
            return strZzn;
        }
        byte[] bArr = (byte[]) obj;
        String strZzg = zzkn.zzg(bArr);
        if (zzkn.zzh(bArr)) {
            this.zzc.set(i, strZzg);
        }
        return strZzg;
    }

    @Override // com.google.android.gms.internal.measurement.zzku
    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    @Override // com.google.android.gms.internal.measurement.zzku
    public final void zzi(zzje zzjeVar) {
        zzbT();
        this.zzc.add(zzjeVar);
        ((AbstractList) this).modCount++;
    }

    public zzkt(int i) {
        this.zzc = new ArrayList(i);
    }

    private zzkt(ArrayList arrayList) {
        this.zzc = arrayList;
    }

    @Override // com.google.android.gms.internal.measurement.zzip, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
