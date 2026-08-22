package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class zzw extends zza {
    public final TaskCompletionSource zza;

    public zzw(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzaj
    public final void zze(DataHolder dataHolder) {
        int i = dataHolder.zai;
        boolean z = i == 3;
        TaskCompletionSource taskCompletionSource = this.zza;
        if (i != 0 && !z) {
            GamesStatusUtils.zzb(taskCompletionSource, i);
            dataHolder.close();
            return;
        }
        LeaderboardBuffer leaderboardBuffer = new LeaderboardBuffer(dataHolder);
        try {
            Leaderboard leaderboard = leaderboardBuffer.getCount() > 0 ? (Leaderboard) ((Leaderboard) leaderboardBuffer.get(0)).freeze() : null;
            leaderboardBuffer.close();
            taskCompletionSource.setResult(new AnnotatedData(leaderboard, z));
        } catch (Throwable th) {
            try {
                leaderboardBuffer.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
