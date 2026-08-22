package com.google.android.gms.internal.p001authapiphone;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class zzo extends IStatusCallback.Stub {
    final /* synthetic */ TaskCompletionSource zza;

    public zzo(zzr zzrVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.IStatusCallback
    public final void onResult(Status status) {
        if (status.getStatusCode() == 6) {
            this.zza.trySetException(zzah.fromStatus(status));
        } else {
            TaskUtil.setResultOrApiException(status, this.zza);
        }
    }
}
