package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class zack extends RegisterListenerMethod {
    public final /* synthetic */ RegistrationMethods.Builder zaa;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zack(RegistrationMethods.Builder builder, ListenerHolder listenerHolder, Feature[] featureArr, boolean z, int i) {
        super(listenerHolder, featureArr, z, i);
        this.zaa = builder;
    }

    @Override // com.google.android.gms.common.api.internal.RegisterListenerMethod
    public final void registerListener(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) {
        this.zaa.zaa.accept(anyClient, taskCompletionSource);
    }
}
