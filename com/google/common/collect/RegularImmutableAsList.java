package com.google.common.collect;

import java.util.ListIterator;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
public final class RegularImmutableAsList extends ImmutableAsList {
    public final ImmutableCollection delegate;
    public final ImmutableList delegateList;

    public RegularImmutableAsList(ImmutableCollection immutableCollection, Object[] objArr) {
        ImmutableList immutableListAsImmutableList = ImmutableList.asImmutableList(objArr, objArr.length);
        this.delegate = immutableCollection;
        this.delegateList = immutableListAsImmutableList;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    public final int copyIntoArray(Object[] objArr) {
        return this.delegateList.copyIntoArray(objArr);
    }

    @Override // com.google.common.collect.ImmutableAsList
    public final ImmutableCollection delegateCollection() {
        return this.delegate;
    }

    @Override // com.google.common.collect.ImmutableList, java.lang.Iterable
    public final void forEach(Consumer consumer) {
        this.delegateList.forEach(consumer);
    }

    @Override // java.util.List
    public final Object get(int i) {
        return this.delegateList.get(i);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final Object[] internalArray() {
        return this.delegateList.internalArray();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int internalArrayEnd() {
        return this.delegateList.internalArrayEnd();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int internalArrayStart() {
        return this.delegateList.internalArrayStart();
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public final AbstractIndexedListIterator listIterator(int i) {
        return this.delegateList.listIterator(i);
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public final ListIterator listIterator(int i) {
        return this.delegateList.listIterator(i);
    }
}
