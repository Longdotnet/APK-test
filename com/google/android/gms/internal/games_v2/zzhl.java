package com.google.android.gms.internal.games_v2;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzhl extends zzhk implements NavigableSet, zzij {
    final transient Comparator zza;
    transient zzhl zzb;

    public zzhl(Comparator comparator) {
        this.zza = comparator;
    }

    public static zzig zzk(Comparator comparator) {
        if (zzhr.zza.equals(comparator)) {
            return zzig.zzc;
        }
        int i = zzhd.zzd;
        return new zzig(zzhz.zza, comparator);
    }

    @Deprecated
    public final void addFirst(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void addLast(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    public Object ceiling(Object obj) {
        obj.getClass();
        return zzhm.zza(zzo(obj, true), null);
    }

    @Override // java.util.SortedSet, com.google.android.gms.internal.games_v2.zzij
    public final Comparator comparator() {
        return this.zza;
    }

    @Override // java.util.NavigableSet
    public final /* bridge */ /* synthetic */ NavigableSet descendingSet() {
        zzhl zzhlVar = this.zzb;
        if (zzhlVar != null) {
            return zzhlVar;
        }
        zzhl zzhlVarZzp = zzp();
        this.zzb = zzhlVarZzp;
        zzhlVarZzp.zzb = this;
        return zzhlVarZzp;
    }

    @Override // java.util.SortedSet
    public Object first() {
        return iterator().next();
    }

    @Override // java.util.NavigableSet
    public Object floor(Object obj) {
        obj.getClass();
        return zzhp.zza(zzm(obj, true).descendingIterator(), null);
    }

    public final Object getFirst() {
        return first();
    }

    public final Object getLast() {
        return last();
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public final /* synthetic */ SortedSet headSet(Object obj) {
        obj.getClass();
        return zzm(obj, false);
    }

    @Override // java.util.NavigableSet
    public Object higher(Object obj) {
        obj.getClass();
        return zzhm.zza(zzo(obj, false), null);
    }

    @Override // java.util.SortedSet
    public Object last() {
        return descendingIterator().next();
    }

    @Override // java.util.NavigableSet
    public Object lower(Object obj) {
        obj.getClass();
        return zzhp.zza(zzm(obj, false).descendingIterator(), null);
    }

    @Override // java.util.NavigableSet
    @Deprecated
    public final Object pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    @Deprecated
    public final Object pollLast() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Object removeFirst() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Object removeLast() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public final /* bridge */ /* synthetic */ SortedSet subSet(Object obj, Object obj2) {
        return subSet(obj, true, obj2, false);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public final /* synthetic */ SortedSet tailSet(Object obj) {
        obj.getClass();
        return zzo(obj, true);
    }

    @Override // com.google.android.gms.internal.games_v2.zzhk, com.google.android.gms.internal.games_v2.zzgy, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: zza */
    public abstract zzil iterator();

    @Override // java.util.NavigableSet
    /* JADX INFO: renamed from: zzl */
    public final zzhl subSet(Object obj, boolean z, Object obj2, boolean z2) {
        obj.getClass();
        obj2.getClass();
        if (this.zza.compare(obj, obj2) <= 0) {
            return zzn(obj, z, obj2, z2);
        }
        throw new IllegalArgumentException();
    }

    public abstract zzhl zzm(Object obj, boolean z);

    public abstract zzhl zzn(Object obj, boolean z, Object obj2, boolean z2);

    public abstract zzhl zzo(Object obj, boolean z);

    public abstract zzhl zzp();

    @Override // java.util.NavigableSet
    /* JADX INFO: renamed from: zzq */
    public abstract zzil descendingIterator();

    @Override // java.util.NavigableSet
    public final /* synthetic */ NavigableSet headSet(Object obj, boolean z) {
        obj.getClass();
        return zzm(obj, z);
    }

    @Override // java.util.NavigableSet
    public final /* synthetic */ NavigableSet tailSet(Object obj, boolean z) {
        obj.getClass();
        return zzo(obj, z);
    }
}
