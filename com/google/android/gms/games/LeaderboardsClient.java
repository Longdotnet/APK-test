package com.google.android.gms.games;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes.dex */
public interface LeaderboardsClient {

    public static class LeaderboardScores implements Releasable {
        public final Leaderboard zza;
        public final LeaderboardScoreBuffer zzb;

        public LeaderboardScores(Leaderboard leaderboard, LeaderboardScoreBuffer leaderboardScoreBuffer) {
            this.zza = leaderboard;
            this.zzb = leaderboardScoreBuffer;
        }

        public Leaderboard getLeaderboard() {
            return this.zza;
        }

        public LeaderboardScoreBuffer getScores() {
            return this.zzb;
        }

        @Override // com.google.android.gms.common.api.Releasable
        public void release() {
            this.zzb.release();
        }
    }

    Task getAllLeaderboardsIntent();

    Task getLeaderboardIntent(String str);

    Task getLeaderboardIntent(String str, int i);

    Task getLeaderboardIntent(String str, int i, int i2);

    Task loadCurrentPlayerLeaderboardScore(String str, int i, int i2);

    Task loadLeaderboardMetadata(String str, boolean z);

    Task loadLeaderboardMetadata(boolean z);

    Task loadMoreScores(LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2);

    Task loadPlayerCenteredScores(String str, int i, int i2, int i3);

    Task loadPlayerCenteredScores(String str, int i, int i2, int i3, boolean z);

    Task loadTopScores(String str, int i, int i2, int i3);

    Task loadTopScores(String str, int i, int i2, int i3, boolean z);

    void submitScore(String str, long j);

    void submitScore(String str, long j, String str2);

    Task submitScoreImmediate(String str, long j);

    Task submitScoreImmediate(String str, long j, String str2);
}
