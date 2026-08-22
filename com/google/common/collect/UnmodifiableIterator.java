package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class UnmodifiableIterator implements Iterator {
    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
