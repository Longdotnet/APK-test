package com.google.common.collect;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public abstract class ImmutableAsList extends ImmutableList {

    public final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        public final ImmutableCollection collection;

        public SerializedForm(ImmutableCollection immutableCollection) {
            this.collection = immutableCollection;
        }

        public Object readResolve() {
            return this.collection.asList();
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return delegateCollection().contains(obj);
    }

    public abstract ImmutableCollection delegateCollection();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return delegateCollection().isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return delegateCollection().size();
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(delegateCollection());
    }
}
