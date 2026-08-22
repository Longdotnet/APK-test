package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreEntity;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzx extends zza {
    public final /* synthetic */ zzah zza;
    public final TaskCompletionSource zzb;

    public zzx(zzah zzahVar, TaskCompletionSource taskCompletionSource) {
        Objects.requireNonNull(zzahVar);
        this.zza = zzahVar;
        this.zzb = taskCompletionSource;
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzaj
    public final void zzk(DataHolder dataHolder) {
        int i = dataHolder.zai;
        TaskCompletionSource taskCompletionSource = this.zzb;
        if (i == 10003) {
            this.zza.zzT(taskCompletionSource);
            dataHolder.close();
            return;
        }
        boolean z = i == 3;
        if (i != 0 && !z) {
            GamesStatusUtils.zzb(taskCompletionSource, i);
            dataHolder.close();
            return;
        }
        LeaderboardScoreBuffer leaderboardScoreBuffer = new LeaderboardScoreBuffer(dataHolder);
        try {
            LeaderboardScoreEntity leaderboardScoreEntity = leaderboardScoreBuffer.getCount() > 0 ? new LeaderboardScoreEntity(leaderboardScoreBuffer.get(0)) : null;
            leaderboardScoreBuffer.close();
            taskCompletionSource.setResult(new AnnotatedData(leaderboardScoreEntity, z));
        } catch (Throwable th) {
            try {
                leaderboardScoreBuffer.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
