package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.internal.OptionalPendingResultImpl;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.internal.zzah;

/* JADX INFO: loaded from: classes.dex */
public final class PendingResults {
    public static PendingResult<Status> canceledPendingResult() {
        StatusPendingResult statusPendingResult = new StatusPendingResult(Looper.getMainLooper());
        statusPendingResult.cancel();
        return statusPendingResult;
    }

    public static <R extends Result> PendingResult<R> immediateFailedResult(R r, GoogleApiClient googleApiClient) {
        zzah.checkNotNull(r, "Result must not be null");
        zzah.checkArgument(!r.getStatus().isSuccess(), "Status code must not be SUCCESS");
        zag zagVar = new zag(googleApiClient, r);
        zagVar.setResult(r);
        return zagVar;
    }

    public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(R r) {
        zzah.checkNotNull(r, "Result must not be null");
        zah zahVar = new zah(null);
        zahVar.setResult(r);
        return new OptionalPendingResultImpl(zahVar);
    }

    public static <R extends Result> PendingResult<R> canceledPendingResult(R r) {
        zzah.checkNotNull(r, "Result must not be null");
        zzah.checkArgument(r.getStatus().getStatusCode() == 16, "Status code must be CommonStatusCodes.CANCELED");
        zaf zafVar = new zaf(r);
        zafVar.cancel();
        return zafVar;
    }

    public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(R r, GoogleApiClient googleApiClient) {
        zzah.checkNotNull(r, "Result must not be null");
        zah zahVar = new zah(googleApiClient);
        zahVar.setResult(r);
        return new OptionalPendingResultImpl(zahVar);
    }

    public static PendingResult<Status> immediatePendingResult(Status status) {
        zzah.checkNotNull(status, "Result must not be null");
        StatusPendingResult statusPendingResult = new StatusPendingResult(Looper.getMainLooper());
        statusPendingResult.setResult(status);
        return statusPendingResult;
    }

    public static PendingResult<Status> immediatePendingResult(Status status, GoogleApiClient googleApiClient) {
        zzah.checkNotNull(status, "Result must not be null");
        StatusPendingResult statusPendingResult = new StatusPendingResult(googleApiClient);
        statusPendingResult.setResult(status);
        return statusPendingResult;
    }
}
