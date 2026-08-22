package com.google.android.gms.games.internal.v2.appshortcuts;

import android.content.Intent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes2.dex */
public class zzn extends zzw {
    public final TaskCompletionSource zza;

    public zzn(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public void zzb(zzg zzgVar) {
        zzd(new Status(10));
    }

    public void zzc(Intent intent) {
        zzd(new Status(10));
    }

    @Override // com.google.android.gms.games.internal.v2.appshortcuts.zzx
    public final void zzd(Status status) {
        this.zza.trySetException(zzah.fromStatus(status));
    }
}
