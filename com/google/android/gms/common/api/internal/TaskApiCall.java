package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public abstract class TaskApiCall<A extends Api.AnyClient, ResultT> {
    public final Feature[] zaa;
    public final boolean zab;
    public final int zac;

    public static class Builder<A extends Api.AnyClient, ResultT> {
        public RemoteCall zaa;
        public boolean zab;
        public Feature[] zac;
        public int zad;

        public TaskApiCall<A, ResultT> build() {
            zzah.checkArgument(this.zaa != null, "execute parameter required");
            return new zacv(this, this.zac, this.zab, this.zad);
        }

        @Deprecated
        public Builder<A, ResultT> execute(final BiConsumer biConsumer) {
            this.zaa = new RemoteCall(biConsumer) { // from class: com.google.android.gms.common.api.internal.zacu
                public final /* synthetic */ BiConsumer zaa;

                @Override // com.google.android.gms.common.api.internal.RemoteCall
                public final void accept(Object obj, Object obj2) {
                    throw null;
                }
            };
            return this;
        }

        public Builder<A, ResultT> run(RemoteCall<A, TaskCompletionSource> remoteCall) {
            this.zaa = remoteCall;
            return this;
        }

        public Builder<A, ResultT> setAutoResolveMissingFeatures(boolean z) {
            this.zab = z;
            return this;
        }

        public Builder<A, ResultT> setFeatures(Feature... featureArr) {
            this.zac = featureArr;
            return this;
        }

        public Builder<A, ResultT> setMethodKey(int i) {
            this.zad = i;
            return this;
        }
    }

    @Deprecated
    public TaskApiCall() {
        this.zaa = null;
        this.zab = false;
        this.zac = 0;
    }

    public static <A extends Api.AnyClient, ResultT> Builder<A, ResultT> builder() {
        Builder<A, ResultT> builder = new Builder<>();
        builder.zab = true;
        builder.zad = 0;
        return builder;
    }

    public abstract void doExecute(A a, TaskCompletionSource taskCompletionSource);

    public boolean shouldAutoResolveMissingFeatures() {
        return this.zab;
    }

    public final int zaa() {
        return this.zac;
    }

    public final Feature[] zab() {
        return this.zaa;
    }

    public TaskApiCall(Feature[] featureArr, boolean z, int i) {
        this.zaa = featureArr;
        boolean z2 = false;
        if (featureArr != null && z) {
            z2 = true;
        }
        this.zab = z2;
        this.zac = i;
    }
}
