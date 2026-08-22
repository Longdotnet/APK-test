package com.google.common.collect;

/* JADX INFO: loaded from: classes.dex */
public final class Iterators$ArrayItr extends AbstractIndexedListIterator {
    public static final Iterators$ArrayItr EMPTY = new Iterators$ArrayItr(new Object[0], 0, 0);
    public final Object[] array;

    public Iterators$ArrayItr(Object[] objArr, int i, int i2) {
        super(i, i2);
        this.array = objArr;
    }

    @Override // com.google.common.collect.AbstractIndexedListIterator
    public final Object get(int i) {
        return this.array[i];
    }
}
