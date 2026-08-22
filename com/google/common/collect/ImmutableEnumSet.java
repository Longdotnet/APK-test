package com.google.common.collect;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
public final class ImmutableEnumSet extends ImmutableSet {
    public final transient EnumSet delegate;
    public transient int hashCode;

    public final class EnumSerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        public final EnumSet delegate;

        public EnumSerializedForm(EnumSet enumSet) {
            this.delegate = enumSet;
        }

        public Object readResolve() {
            return new ImmutableEnumSet(this.delegate.clone());
        }
    }

    public ImmutableEnumSet(EnumSet enumSet) {
        this.delegate = enumSet;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return this.delegate.contains(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        if (collection instanceof ImmutableEnumSet) {
            collection = ((ImmutableEnumSet) collection).delegate;
        }
        return this.delegate.containsAll(collection);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableEnumSet) {
            obj = ((ImmutableEnumSet) obj).delegate;
        }
        return this.delegate.equals(obj);
    }

    @Override // java.lang.Iterable
    public final void forEach(Consumer consumer) {
        this.delegate.forEach(consumer);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = this.delegate.hashCode();
        this.hashCode = iHashCode;
        return iHashCode;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final UnmodifiableIterator iterator() {
        final Iterator it = this.delegate.iterator();
        it.getClass();
        return it instanceof UnmodifiableIterator ? (UnmodifiableIterator) it : new UnmodifiableIterator() { // from class: com.google.common.collect.Iterators$1
            @Override // java.util.Iterator
            public final boolean hasNext() {
                return it.hasNext();
            }

            @Override // java.util.Iterator
            public final Object next() {
                return it.next();
            }
        };
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.delegate.size();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public final Spliterator spliterator() {
        return this.delegate.spliterator();
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return this.delegate.toString();
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new EnumSerializedForm(this.delegate);
    }
}
