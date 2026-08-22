package com.google.common.collect;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractIndexedListIterator extends UnmodifiableIterator implements ListIterator {
    public int position;
    public final int size;

    public AbstractIndexedListIterator(int i, int i2) {
        StringsKt__IndentKt.checkPositionIndex(i2, i);
        this.size = i;
        this.position = i2;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public abstract Object get(int i);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.position < this.size;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.position > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.position;
        this.position = i + 1;
        return get(i);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.position;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.position - 1;
        this.position = i;
        return get(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.position - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
