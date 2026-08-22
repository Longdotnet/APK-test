package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public abstract class RegisterListenerMethod<A extends Api.AnyClient, L> {
    public final ListenerHolder zaa;
    public final Feature[] zab;
    public final boolean zac;
    public final int zad;

    public RegisterListenerMethod(ListenerHolder<L> listenerHolder, Feature[] featureArr, boolean z, int i) {
        this.zaa = listenerHolder;
        this.zab = featureArr;
        this.zac = z;
        this.zad = i;
    }

    public void clearListener() {
        this.zaa.clear();
    }

    public ListenerHolder.ListenerKey<L> getListenerKey() {
        return this.zaa.getListenerKey();
    }

    public Feature[] getRequiredFeatures() {
        return this.zab;
    }

    public abstract void registerListener(A a, TaskCompletionSource taskCompletionSource);

    public final int zaa() {
        return this.zad;
    }

    public final boolean zab() {
        return this.zac;
    }

    public RegisterListenerMethod(ListenerHolder<L> listenerHolder) {
        this(listenerHolder, null, false, 0);
    }

    public RegisterListenerMethod(ListenerHolder<L> listenerHolder, Feature[] featureArr, boolean z) {
        this(listenerHolder, featureArr, z, 0);
    }
}
