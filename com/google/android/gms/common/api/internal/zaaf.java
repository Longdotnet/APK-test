package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class zaaf {
    public final ApiKey zaa;
    public final TaskCompletionSource zab = new TaskCompletionSource();

    public zaaf(ApiKey apiKey) {
        this.zaa = apiKey;
    }

    public final ApiKey zaa() {
        return this.zaa;
    }

    public final TaskCompletionSource zab() {
        return this.zab;
    }
}
