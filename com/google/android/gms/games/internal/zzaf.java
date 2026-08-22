package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class zzaf extends zza {
    public final TaskCompletionSource zza;

    public zzaf(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzaj
    public final void zzg(DataHolder dataHolder) {
        int i = dataHolder.zai;
        TaskCompletionSource taskCompletionSource = this.zza;
        if (i != 0 && i != 5) {
            GamesStatusUtils.zzb(taskCompletionSource, i);
            dataHolder.close();
        } else {
            try {
                taskCompletionSource.setResult(new ScoreSubmissionData(dataHolder));
            } finally {
                dataHolder.close();
            }
        }
    }
}
