package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.gamessignin.AuthResponse;
import com.google.android.gms.games.gamessignin.AuthScope;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzv extends zza {
    public final TaskCompletionSource zza;

    public zzv(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzaj
    public final void zzs(Status status, String str, List list) {
        boolean zIsSuccess = status.isSuccess();
        TaskCompletionSource taskCompletionSource = this.zza;
        if (zIsSuccess) {
            taskCompletionSource.setResult(new AuthResponse(str, AuthScope.zzb(list)));
        } else {
            taskCompletionSource.setException(com.google.android.gms.common.internal.zzah.fromStatus(status));
        }
    }
}
