package com.google.common.collect;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class Iterators$9 extends UnmodifiableIterator {
    public boolean done;
    public final /* synthetic */ Object val$value;

    public Iterators$9(Object obj) {
        this.val$value = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.done;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.done) {
            throw new NoSuchElementException();
        }
        this.done = true;
        return this.val$value;
    }
}
