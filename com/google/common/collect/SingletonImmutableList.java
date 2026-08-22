package com.google.common.collect;

import java.util.Collections;
import java.util.Spliterator;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: loaded from: classes.dex */
public final class SingletonImmutableList extends ImmutableList {
    public final transient Object element;

    public SingletonImmutableList(Object obj) {
        obj.getClass();
        this.element = obj;
    }

    @Override // java.util.List
    public final Object get(int i) {
        StringsKt__IndentKt.checkElementIndex(i, 1);
        return this.element;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return 1;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public final Spliterator spliterator() {
        return Collections.singleton(this.element).spliterator();
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return "[" + this.element.toString() + ']';
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final UnmodifiableIterator iterator() {
        return new Iterators$9(this.element);
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public final ImmutableList subList(int i, int i2) {
        StringsKt__IndentKt.checkPositionIndexes(i, i2, 1);
        return i == i2 ? RegularImmutableList.EMPTY : this;
    }
}
