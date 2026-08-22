package com.google.android.datatransport.runtime.dagger.internal;

import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class DoubleCheck implements Provider {
    public static final Object UNINITIALIZED = new Object();
    public volatile Object instance;
    public volatile Factory provider;

    public static Provider provider(Factory factory) {
        if (factory instanceof DoubleCheck) {
            return factory;
        }
        DoubleCheck doubleCheck = new DoubleCheck();
        doubleCheck.instance = UNINITIALIZED;
        doubleCheck.provider = factory;
        return doubleCheck;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        Object obj = this.instance;
        Object obj2 = UNINITIALIZED;
        if (obj == obj2) {
            synchronized (this) {
                try {
                    obj = this.instance;
                    if (obj == obj2) {
                        obj = this.provider.get();
                        Object obj3 = this.instance;
                        if (obj3 != obj2 && obj3 != obj) {
                            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj3 + " & " + obj + ". This is likely due to a circular dependency.");
                        }
                        this.instance = obj;
                        this.provider = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return obj;
    }
}
