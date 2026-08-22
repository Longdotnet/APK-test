package com.google.common.collect;

import java.util.Spliterator;
import java.util.Spliterators;
import kotlin.collections.MapsKt__MapsKt;

/* JADX INFO: loaded from: classes.dex */
public final class RegularImmutableList extends ImmutableList {
    public static final RegularImmutableList EMPTY = new RegularImmutableList(new Object[0]);
    public final transient Object[] array;

    public RegularImmutableList(Object[] objArr) {
        this.array = objArr;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    public final int copyIntoArray(Object[] objArr) {
        Object[] objArr2 = this.array;
        System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
        return objArr2.length;
    }

    @Override // java.util.List
    public final Object get(int i) {
        return this.array[i];
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final Object[] internalArray() {
        return this.array;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int internalArrayEnd() {
        return this.array.length;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int internalArrayStart() {
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.array.length;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public final Spliterator spliterator() {
        return Spliterators.spliterator(this.array, 1296);
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public final AbstractIndexedListIterator listIterator(int i) {
        Object[] objArr = this.array;
        return MapsKt__MapsKt.forArray(objArr, objArr.length, i);
    }
}
