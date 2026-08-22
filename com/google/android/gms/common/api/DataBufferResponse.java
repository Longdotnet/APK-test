package com.google.android.gms.common.api;

import android.os.Bundle;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataBuffer;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class DataBufferResponse<T, R extends AbstractDataBuffer & Result> extends Response<R> implements DataBuffer {
    public DataBufferResponse() {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        getResult().close();
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public final T get(int i) {
        return (T) getResult().get(i);
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public final int getCount() {
        return getResult().getCount();
    }

    public final Bundle getMetadata() {
        return getResult().getMetadata();
    }

    public final boolean isClosed() {
        return getResult().isClosed();
    }

    @Override // java.lang.Iterable
    public final Iterator<T> iterator() {
        return (Iterator<T>) getResult().iterator();
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final void release() {
        getResult().release();
    }

    public final Iterator<T> singleRefIterator() {
        return (Iterator<T>) getResult().singleRefIterator();
    }

    public DataBufferResponse(R r) {
        super(r);
    }
}
