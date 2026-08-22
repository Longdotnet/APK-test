package com.google.android.gms.games.internal;

import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class zzo extends zza {
    public final TaskCompletionSource zza;

    public zzo(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzaj
    public final void zzd(int i, String str) {
        TaskCompletionSource taskCompletionSource = this.zza;
        if (i == 0 || i == 3003) {
            taskCompletionSource.setResult(null);
        } else {
            GamesStatusUtils.zzb(taskCompletionSource, i);
        }
    }
}
