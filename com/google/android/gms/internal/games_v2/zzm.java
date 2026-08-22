package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzm extends zzg {
    final /* synthetic */ TaskCompletionSource zza;

    public zzm(zzo zzoVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
        Objects.requireNonNull(zzoVar);
    }

    @Override // com.google.android.gms.internal.games_v2.zzg, com.google.android.gms.internal.games_v2.zzv
    public final void zzb(Status status, zzs zzsVar) {
        if (zzsVar == null) {
            this.zza.setException(new ApiException(status));
        } else {
            this.zza.setResult(zzsVar);
        }
    }
}
