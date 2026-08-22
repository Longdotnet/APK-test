package com.google.android.gms.common.data;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public class DataBufferIterator implements Iterator {
    public final AbstractDataBuffer zaa;
    public int zab = -1;

    public DataBufferIterator(AbstractDataBuffer abstractDataBuffer) {
        this.zaa = abstractDataBuffer;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zab < this.zaa.getCount() + (-1);
    }

    @Override // java.util.Iterator
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(this.zab, "Cannot advance the iterator beyond "));
        }
        int i = this.zab + 1;
        this.zab = i;
        return this.zaa.get(i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
