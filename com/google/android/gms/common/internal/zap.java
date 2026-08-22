package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zap implements PendingResult.StatusListener {
    public final /* synthetic */ PendingResult zaa;
    public final /* synthetic */ TaskCompletionSource zab;
    public final /* synthetic */ PendingResultUtil$ResultConverter zac;

    public zap(PendingResult pendingResult, TaskCompletionSource taskCompletionSource, PendingResultUtil$ResultConverter pendingResultUtil$ResultConverter) {
        this.zaa = pendingResult;
        this.zab = taskCompletionSource;
        this.zac = pendingResultUtil$ResultConverter;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void onComplete(Status status) {
        boolean zIsSuccess = status.isSuccess();
        TaskCompletionSource taskCompletionSource = this.zab;
        if (!zIsSuccess) {
            taskCompletionSource.setException(zzah.fromStatus(status));
            return;
        }
        taskCompletionSource.setResult(this.zac.convert(this.zaa.await(0L, TimeUnit.MILLISECONDS)));
    }
}
