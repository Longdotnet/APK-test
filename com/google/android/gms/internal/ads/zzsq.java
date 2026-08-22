package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzsq {
    public static /* synthetic */ boolean zza(AtomicReference atomicReference, Object obj, Object obj2) {
        while (!atomicReference.compareAndSet(null, obj2)) {
            if (atomicReference.get() != null && atomicReference.get() != null) {
                return false;
            }
        }
        return true;
    }
}
