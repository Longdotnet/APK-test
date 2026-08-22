package com.google.gson.internal;

/* JADX INFO: loaded from: classes3.dex */
public final class UnsafeAllocator$4 extends Streams {
    @Override // com.google.gson.internal.Streams
    public final Object newInstance(Class cls) {
        throw new UnsupportedOperationException("Cannot allocate " + cls);
    }
}
