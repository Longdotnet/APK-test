package com.google.common.collect;

import java.util.HashSet;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/* JADX INFO: loaded from: classes.dex */
public final class JdkBackedImmutableSet extends ImmutableSet.CachingAsList {
    public final HashSet delegate;
    public final ImmutableList delegateList;

    public JdkBackedImmutableSet(HashSet hashSet, ImmutableList immutableList) {
        this.delegate = hashSet;
        this.delegateList = immutableList;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return this.delegate.contains(obj);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int copyIntoArray(Object[] objArr) {
        return asList().copyIntoArray(objArr);
    }

    @Override // com.google.common.collect.ImmutableSet.CachingAsList
    public final ImmutableList createAsList() {
        return new ImmutableAsList() { // from class: com.google.common.collect.IndexedImmutableSet$1
            @Override // com.google.common.collect.ImmutableAsList
            public final ImmutableCollection delegateCollection() {
                return this.this$0;
            }

            @Override // java.util.List
            public final Object get(int i) {
                return this.this$0.get(i);
            }

            @Override // com.google.common.collect.ImmutableAsList, java.util.AbstractCollection, java.util.Collection, java.util.List
            public final int size() {
                return this.this$0.size();
            }
        };
    }

    @Override // java.lang.Iterable
    public final void forEach(Consumer consumer) {
        consumer.getClass();
        int size = this.delegateList.size();
        for (int i = 0; i < size; i++) {
            consumer.accept(get(i));
        }
    }

    public final Object get(int i) {
        return this.delegateList.get(i);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final UnmodifiableIterator iterator() {
        return asList().iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.delegateList.size();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public final Spliterator spliterator() {
        int size = this.delegateList.size();
        return new CollectSpliterators$1WithCharacteristics(IntStream.range(0, size).spliterator(), new ImmutableList$$ExternalSyntheticLambda0(this, 1), 1297);
    }
}
