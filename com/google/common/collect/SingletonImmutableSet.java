package com.google.common.collect;

/* JADX INFO: loaded from: classes.dex */
public final class SingletonImmutableSet extends ImmutableSet {
    public final transient Object element;

    public SingletonImmutableSet(Object obj) {
        obj.getClass();
        this.element = obj;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final ImmutableList asList() {
        return new SingletonImmutableList(this.element);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return this.element.equals(obj);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int copyIntoArray(Object[] objArr) {
        objArr[0] = this.element;
        return 1;
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.element.hashCode();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final UnmodifiableIterator iterator() {
        return new Iterators$9(this.element);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return "[" + this.element.toString() + ']';
    }
}
