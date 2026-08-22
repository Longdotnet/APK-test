package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class zzu extends zza {
    public final TaskCompletionSource zza;

    public zzu(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzaj
    public final void zzr(Status status, String str) {
        boolean zIsSuccess = status.isSuccess();
        TaskCompletionSource taskCompletionSource = this.zza;
        if (zIsSuccess) {
            taskCompletionSource.setResult(str);
        } else {
            taskCompletionSource.setException(com.google.android.gms.common.internal.zzah.fromStatus(status));
        }
    }
}
