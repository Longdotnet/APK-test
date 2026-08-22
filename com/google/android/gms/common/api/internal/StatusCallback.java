package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public class StatusCallback extends IStatusCallback.Stub {
    public final BaseImplementation.ResultHolder resultHolder;

    public StatusCallback(BaseImplementation.ResultHolder<Status> resultHolder) {
        this.resultHolder = resultHolder;
    }

    @Override // com.google.android.gms.common.api.internal.IStatusCallback
    public void onResult(Status status) {
        this.resultHolder.setResult(status);
    }
}
