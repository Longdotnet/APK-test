package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public abstract class UnregisterListenerMethod<A extends Api.AnyClient, L> {
    public final ListenerHolder.ListenerKey zaa;

    public UnregisterListenerMethod(ListenerHolder.ListenerKey<L> listenerKey) {
        this.zaa = listenerKey;
    }

    public ListenerHolder.ListenerKey<L> getListenerKey() {
        return this.zaa;
    }

    public abstract void unregisterListener(A a, TaskCompletionSource taskCompletionSource);
}
