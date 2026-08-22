package com.google.common.collect;

import java.util.Spliterator;
import java.util.Spliterators;
import kotlin.collections.MapsKt__MapsKt;
import okio.Okio;

/* JADX INFO: loaded from: classes.dex */
public final class RegularImmutableSet extends ImmutableSet.CachingAsList {
    public static final RegularImmutableSet EMPTY;
    public static final Object[] EMPTY_ARRAY;
    public final transient Object[] elements;
    public final transient int hashCode;
    public final transient int mask;
    public final transient Object[] table;

    static {
        Object[] objArr = new Object[0];
        EMPTY_ARRAY = objArr;
        EMPTY = new RegularImmutableSet(objArr, 0, objArr, 0);
    }

    public RegularImmutableSet(Object[] objArr, int i, Object[] objArr2, int i2) {
        this.elements = objArr;
        this.hashCode = i;
        this.table = objArr2;
        this.mask = i2;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (obj != null) {
            Object[] objArr = this.table;
            if (objArr.length != 0) {
                int iSmear = Okio.smear(obj.hashCode());
                while (true) {
                    int i = iSmear & this.mask;
                    Object obj2 = objArr[i];
                    if (obj2 == null) {
                        return false;
                    }
                    if (obj2.equals(obj)) {
                        return true;
                    }
                    iSmear = i + 1;
                }
            }
        }
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int copyIntoArray(Object[] objArr) {
        Object[] objArr2 = this.elements;
        System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
        return objArr2.length;
    }

    @Override // com.google.common.collect.ImmutableSet.CachingAsList
    public final ImmutableList createAsList() {
        return this.table.length == 0 ? RegularImmutableList.EMPTY : new RegularImmutableAsList(this, this.elements);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.hashCode;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final Object[] internalArray() {
        return this.elements;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int internalArrayEnd() {
        return this.elements.length;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int internalArrayStart() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableSet
    public final boolean isHashCodeFast() {
        return true;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final UnmodifiableIterator iterator() {
        Object[] objArr = this.elements;
        return MapsKt__MapsKt.forArray(objArr, objArr.length, 0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.elements.length;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public final Spliterator spliterator() {
        return Spliterators.spliterator(this.elements, 1297);
    }
}
