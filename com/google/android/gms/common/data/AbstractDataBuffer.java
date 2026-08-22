package com.google.android.gms.common.data;

import android.os.Bundle;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractDataBuffer implements DataBuffer {
    protected final DataHolder mDataHolder;

    public AbstractDataBuffer(DataHolder dataHolder) {
        this.mDataHolder = dataHolder;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        release();
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public int getCount() {
        DataHolder dataHolder = this.mDataHolder;
        if (dataHolder == null) {
            return 0;
        }
        return dataHolder.zad;
    }

    public final Bundle getMetadata() {
        DataHolder dataHolder = this.mDataHolder;
        if (dataHolder == null) {
            return null;
        }
        return dataHolder.zaj;
    }

    @Deprecated
    public boolean isClosed() {
        DataHolder dataHolder = this.mDataHolder;
        return dataHolder == null || dataHolder.isClosed();
    }

    @Override // java.lang.Iterable
    public Iterator<Object> iterator() {
        return new DataBufferIterator(this);
    }

    @Override // com.google.android.gms.common.api.Releasable
    public void release() {
        DataHolder dataHolder = this.mDataHolder;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }

    public Iterator<Object> singleRefIterator() {
        return new SingleRefDataBufferIterator(this);
    }
}
