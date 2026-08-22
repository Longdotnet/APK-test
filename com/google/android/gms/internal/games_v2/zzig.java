package com.google.android.gms.internal.games_v2;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class zzig extends zzhl {
    static final zzig zzc;
    final transient zzhd zzd;

    static {
        int i = zzhd.zzd;
        zzc = new zzig(zzhz.zza, zzhr.zza);
    }

    public zzig(zzhd zzhdVar, Comparator comparator) {
        super(comparator);
        this.zzd = zzhdVar;
    }

    @Override // com.google.android.gms.internal.games_v2.zzhl, java.util.NavigableSet
    public final Object ceiling(Object obj) {
        zzhd zzhdVar = this.zzd;
        int iZzs = zzs(obj, true);
        if (iZzs == zzhdVar.size()) {
            return null;
        }
        return zzhdVar.get(iZzs);
    }

    @Override // com.google.android.gms.internal.games_v2.zzgy, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj != null) {
            try {
                if (Collections.binarySearch(this.zzd, obj, ((zzhl) this).zza) >= 0) {
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        if (collection instanceof zzhq) {
            collection = ((zzhq) collection).zza();
        }
        Comparator comparator = ((zzhl) this).zza;
        if (!zzik.zza(comparator, collection) || collection.size() <= 1) {
            return super.containsAll(collection);
        }
        zzim zzimVarListIterator = this.zzd.listIterator(0);
        Iterator it = collection.iterator();
        if (!zzimVarListIterator.hasNext()) {
            return false;
        }
        Object next = it.next();
        E next2 = zzimVarListIterator.next();
        while (true) {
            try {
                int iCompare = comparator.compare(next2, next);
                if (iCompare < 0) {
                    if (!zzimVarListIterator.hasNext()) {
                        return false;
                    }
                    next2 = zzimVarListIterator.next();
                } else {
                    if (iCompare != 0) {
                        return false;
                    }
                    if (!it.hasNext()) {
                        return true;
                    }
                    next = it.next();
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
    }

    @Override // com.google.android.gms.internal.games_v2.zzhk, java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        zzhd zzhdVar = this.zzd;
        if (zzhdVar.size() != set.size()) {
            return false;
        }
        if (isEmpty()) {
            return true;
        }
        if (!zzik.zza(((zzhl) this).zza, set)) {
            return containsAll(set);
        }
        Iterator it = set.iterator();
        try {
            zzim zzimVarListIterator = zzhdVar.listIterator(0);
            while (zzimVarListIterator.hasNext()) {
                E next = zzimVarListIterator.next();
                Object next2 = it.next();
                if (next2 == null || ((zzhl) this).zza.compare(next, next2) != 0) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NoSuchElementException unused) {
            return false;
        }
    }

    @Override // com.google.android.gms.internal.games_v2.zzhl, java.util.SortedSet
    public final Object first() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.zzd.get(0);
    }

    @Override // com.google.android.gms.internal.games_v2.zzhl, java.util.NavigableSet
    public final Object floor(Object obj) {
        int iZzr = zzr(obj, true) - 1;
        if (iZzr == -1) {
            return null;
        }
        return this.zzd.get(iZzr);
    }

    @Override // com.google.android.gms.internal.games_v2.zzhl, java.util.NavigableSet
    public final Object higher(Object obj) {
        zzhd zzhdVar = this.zzd;
        int iZzs = zzs(obj, false);
        if (iZzs == zzhdVar.size()) {
            return null;
        }
        return zzhdVar.get(iZzs);
    }

    @Override // com.google.android.gms.internal.games_v2.zzhl, com.google.android.gms.internal.games_v2.zzhk, com.google.android.gms.internal.games_v2.zzgy, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return this.zzd.listIterator(0);
    }

    @Override // com.google.android.gms.internal.games_v2.zzhl, java.util.SortedSet
    public final Object last() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        zzhd zzhdVar = this.zzd;
        return zzhdVar.get(zzhdVar.size() - 1);
    }

    @Override // com.google.android.gms.internal.games_v2.zzhl, java.util.NavigableSet
    public final Object lower(Object obj) {
        int iZzr = zzr(obj, false) - 1;
        if (iZzr == -1) {
            return null;
        }
        return this.zzd.get(iZzr);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzd.size();
    }

    @Override // com.google.android.gms.internal.games_v2.zzhl, com.google.android.gms.internal.games_v2.zzhk, com.google.android.gms.internal.games_v2.zzgy
    /* JADX INFO: renamed from: zza */
    public final zzil iterator() {
        return this.zzd.listIterator(0);
    }

    @Override // com.google.android.gms.internal.games_v2.zzgy
    public final Object[] zzb() {
        return this.zzd.zzb();
    }

    @Override // com.google.android.gms.internal.games_v2.zzgy
    public final int zzc() {
        return this.zzd.zzc();
    }

    @Override // com.google.android.gms.internal.games_v2.zzgy
    public final int zzd() {
        return this.zzd.zzd();
    }

    @Override // com.google.android.gms.internal.games_v2.zzgy
    public final int zze(Object[] objArr, int i) {
        return this.zzd.zze(objArr, 0);
    }

    @Override // com.google.android.gms.internal.games_v2.zzhl
    public final zzhl zzm(Object obj, boolean z) {
        return zzt(0, zzr(obj, z));
    }

    @Override // com.google.android.gms.internal.games_v2.zzhl
    public final zzhl zzn(Object obj, boolean z, Object obj2, boolean z2) {
        return zzo(obj, z).zzm(obj2, z2);
    }

    @Override // com.google.android.gms.internal.games_v2.zzhl
    public final zzhl zzo(Object obj, boolean z) {
        return zzt(zzs(obj, z), this.zzd.size());
    }

    @Override // com.google.android.gms.internal.games_v2.zzhl
    public final zzhl zzp() {
        Comparator comparatorReverseOrder = Collections.reverseOrder(((zzhl) this).zza);
        return isEmpty() ? zzhl.zzk(comparatorReverseOrder) : new zzig(this.zzd.zzf(), comparatorReverseOrder);
    }

    @Override // com.google.android.gms.internal.games_v2.zzhl, java.util.NavigableSet
    /* JADX INFO: renamed from: zzq, reason: merged with bridge method [inline-methods] */
    public final zzil descendingIterator() {
        return this.zzd.zzf().listIterator(0);
    }

    public final int zzr(Object obj, boolean z) {
        obj.getClass();
        int iBinarySearch = Collections.binarySearch(this.zzd, obj, ((zzhl) this).zza);
        if (iBinarySearch >= 0) {
            return z ? iBinarySearch + 1 : iBinarySearch;
        }
        return ~iBinarySearch;
    }

    public final int zzs(Object obj, boolean z) {
        obj.getClass();
        int iBinarySearch = Collections.binarySearch(this.zzd, obj, ((zzhl) this).zza);
        if (iBinarySearch >= 0) {
            return z ? iBinarySearch : iBinarySearch + 1;
        }
        return ~iBinarySearch;
    }

    public final zzig zzt(int i, int i2) {
        if (i == 0) {
            if (i2 == this.zzd.size()) {
                return this;
            }
            i = 0;
        }
        if (i >= i2) {
            return zzhl.zzk(((zzhl) this).zza);
        }
        zzhd zzhdVar = this.zzd;
        return new zzig(zzhdVar.subList(i, i2), ((zzhl) this).zza);
    }
}
