package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public class RegistrationMethods<A extends Api.AnyClient, L> {
    public final RegisterListenerMethod<A, L> register;
    public final UnregisterListenerMethod zaa;
    public final Runnable zab;

    public static class Builder<A extends Api.AnyClient, L> {
        public RemoteCall zaa;
        public RemoteCall zab;
        public Runnable zac;
        public ListenerHolder zad;
        public Feature[] zae;
        public boolean zaf;
        public int zag;

        public RegistrationMethods<A, L> build() {
            zzah.checkArgument(this.zaa != null, "Must set register function");
            zzah.checkArgument(this.zab != null, "Must set unregister function");
            zzah.checkArgument(this.zad != null, "Must set holder");
            ListenerHolder.ListenerKey<L> listenerKey = this.zad.getListenerKey();
            zzah.checkNotNull(listenerKey, "Key must not be null");
            return new RegistrationMethods<>(new zack(this, this.zad, this.zae, this.zaf, this.zag), new zacl(this, listenerKey), this.zac);
        }

        public Builder<A, L> onConnectionSuspended(Runnable runnable) {
            this.zac = runnable;
            return this;
        }

        public Builder<A, L> register(RemoteCall<A, TaskCompletionSource> remoteCall) {
            this.zaa = remoteCall;
            return this;
        }

        public Builder<A, L> setAutoResolveMissingFeatures(boolean z) {
            this.zaf = z;
            return this;
        }

        public Builder<A, L> setFeatures(Feature... featureArr) {
            this.zae = featureArr;
            return this;
        }

        public Builder<A, L> setMethodKey(int i) {
            this.zag = i;
            return this;
        }

        public Builder<A, L> unregister(RemoteCall<A, TaskCompletionSource> remoteCall) {
            this.zab = remoteCall;
            return this;
        }

        public Builder<A, L> withHolder(ListenerHolder<L> listenerHolder) {
            this.zad = listenerHolder;
            return this;
        }
    }

    public /* synthetic */ RegistrationMethods(RegisterListenerMethod registerListenerMethod, UnregisterListenerMethod unregisterListenerMethod, Runnable runnable) {
        this.register = registerListenerMethod;
        this.zaa = unregisterListenerMethod;
        this.zab = runnable;
    }

    public static <A extends Api.AnyClient, L> Builder<A, L> builder() {
        Builder<A, L> builder = new Builder<>();
        builder.zac = zacj.zaa;
        builder.zaf = true;
        return builder;
    }
}
