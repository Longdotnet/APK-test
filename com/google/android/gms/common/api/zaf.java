package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BasePendingResult;

/* JADX INFO: loaded from: classes.dex */
final class zaf<R extends Result> extends BasePendingResult<R> {
    public final Result zae;

    public zaf(Result result) {
        super(Looper.getMainLooper());
        this.zae = result;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final R createFailedResult(Status status) {
        int statusCode = status.getStatusCode();
        R r = (R) this.zae;
        if (statusCode == r.getStatus().getStatusCode()) {
            return r;
        }
        throw new UnsupportedOperationException("Creating failed results is not supported");
    }
}
