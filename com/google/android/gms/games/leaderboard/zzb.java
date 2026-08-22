package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataBufferRef;

/* JADX INFO: loaded from: classes.dex */
public final class zzb extends DataBufferRef implements LeaderboardVariant {
    @Override // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(Object obj) {
        return LeaderboardVariantEntity.zze(this, obj);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final /* synthetic */ Object freeze() {
        return new LeaderboardVariantEntity(this);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final int getCollection() {
        return getInteger("collection");
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final String getDisplayPlayerRank() {
        return getString("player_display_rank");
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final String getDisplayPlayerScore() {
        return getString("player_display_score");
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final long getNumScores() {
        if (hasNull("total_scores")) {
            return -1L;
        }
        return getLong("total_scores");
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final long getPlayerRank() {
        if (hasNull("player_rank")) {
            return -1L;
        }
        return getLong("player_rank");
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final String getPlayerScoreTag() {
        return getString("player_score_tag");
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final long getRawPlayerScore() {
        if (hasNull("player_raw_score")) {
            return -1L;
        }
        return getLong("player_raw_score");
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final int getTimeSpan() {
        return getInteger("timespan");
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final boolean hasPlayerInfo() {
        return !hasNull("player_raw_score");
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return LeaderboardVariantEntity.zzd(this);
    }

    public final String toString() {
        return LeaderboardVariantEntity.zzf(this);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final String zza() {
        return getString("top_page_token_next");
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final String zzb() {
        return getString("window_page_token_prev");
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final String zzc() {
        return getString("window_page_token_next");
    }
}
