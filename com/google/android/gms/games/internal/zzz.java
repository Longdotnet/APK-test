package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class zzz extends zza {
    public final TaskCompletionSource zza;

    public zzz(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzaj
    public final void zze(DataHolder dataHolder) {
        int i = dataHolder.zai;
        boolean z = i == 3;
        TaskCompletionSource taskCompletionSource = this.zza;
        if (i == 0 || z) {
            taskCompletionSource.setResult(new AnnotatedData(new LeaderboardBuffer(dataHolder), z));
        } else {
            GamesStatusUtils.zzb(taskCompletionSource, i);
            dataHolder.close();
        }
    }
}
