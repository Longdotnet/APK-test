package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzah;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class BatchResult implements Result {
    public final Status zaa;
    public final PendingResult[] zab;

    public BatchResult(Status status, PendingResult[] pendingResultArr) {
        this.zaa = status;
        this.zab = pendingResultArr;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zaa;
    }

    @ResultIgnorabilityUnspecified
    public <R extends Result> R take(BatchResultToken<R> batchResultToken) {
        int i = batchResultToken.mId;
        PendingResult[] pendingResultArr = this.zab;
        zzah.checkArgument(i < pendingResultArr.length, "The result token does not belong to this batch");
        return (R) pendingResultArr[batchResultToken.mId].await(0L, TimeUnit.MILLISECONDS);
    }
}
