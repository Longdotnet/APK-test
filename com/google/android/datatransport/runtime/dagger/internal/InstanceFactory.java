package com.google.android.datatransport.runtime.dagger.internal;

/* JADX INFO: loaded from: classes.dex */
public final class InstanceFactory implements Factory {
    public final Object instance;

    @Override // javax.inject.Provider
    public Object get() {
        return this.instance;
    }
}
