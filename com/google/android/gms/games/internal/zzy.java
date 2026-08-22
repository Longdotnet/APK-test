package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.LeaderboardsClient;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzy extends zza {
    public final /* synthetic */ zzah zza;
    public final TaskCompletionSource zzb;

    public zzy(zzah zzahVar, TaskCompletionSource taskCompletionSource) {
        Objects.requireNonNull(zzahVar);
        this.zza = zzahVar;
        this.zzb = taskCompletionSource;
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzaj
    public final void zzf(DataHolder dataHolder, DataHolder dataHolder2) {
        int i = dataHolder2.zai;
        TaskCompletionSource taskCompletionSource = this.zzb;
        if (i == 10003) {
            this.zza.zzT(taskCompletionSource);
            dataHolder.close();
            dataHolder2.close();
            return;
        }
        boolean z = i == 3;
        if (i != 0 && !z) {
            GamesStatusUtils.zzb(taskCompletionSource, i);
            dataHolder.close();
            dataHolder2.close();
            return;
        }
        LeaderboardBuffer leaderboardBuffer = new LeaderboardBuffer(dataHolder);
        try {
            Leaderboard leaderboard = leaderboardBuffer.getCount() > 0 ? (Leaderboard) ((Leaderboard) leaderboardBuffer.get(0)).freeze() : null;
            leaderboardBuffer.close();
            taskCompletionSource.setResult(new AnnotatedData(new LeaderboardsClient.LeaderboardScores(leaderboard, new LeaderboardScoreBuffer(dataHolder2)), z));
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
