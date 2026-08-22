package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.ads.internal.gMU.QTaELkFI;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

/* JADX INFO: loaded from: classes2.dex */
public final class LeaderboardScoreRef extends DataBufferRef implements LeaderboardScore {
    public final PlayerRef zza;

    public LeaderboardScoreRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
        this.zza = new PlayerRef(dataHolder, i, null);
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(Object obj) {
        return LeaderboardScoreEntity.zzb(this, obj);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final /* synthetic */ Object freeze() {
        return new LeaderboardScoreEntity(this);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final String getDisplayRank() {
        return getString("display_rank");
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final String getDisplayScore() {
        return getString("display_score");
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final long getRank() {
        return getLong("rank");
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final Player getScoreHolder() {
        if (hasNull("external_player_id")) {
            return null;
        }
        return this.zza;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final String getScoreHolderDisplayName() {
        return hasNull("external_player_id") ? getString("default_display_name") : this.zza.getDisplayName();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final Uri getScoreHolderHiResImageUri() {
        if (hasNull("external_player_id")) {
            return null;
        }
        return this.zza.getHiResImageUri();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public String getScoreHolderHiResImageUrl() {
        if (hasNull("external_player_id")) {
            return null;
        }
        return this.zza.getHiResImageUrl();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final Uri getScoreHolderIconImageUri() {
        return hasNull("external_player_id") ? parseUri("default_display_image_uri") : this.zza.getIconImageUri();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public String getScoreHolderIconImageUrl() {
        return hasNull("external_player_id") ? getString("default_display_image_url") : this.zza.getIconImageUrl();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final String getScoreTag() {
        return getString("score_tag");
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final long getTimestampMillis() {
        return getLong("achieved_timestamp");
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return LeaderboardScoreEntity.zza(this);
    }

    public final String toString() {
        return LeaderboardScoreEntity.zzc(this);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final void getDisplayRank(CharArrayBuffer charArrayBuffer) {
        copyToBuffer("display_rank", charArrayBuffer);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final void getDisplayScore(CharArrayBuffer charArrayBuffer) {
        copyToBuffer("display_score", charArrayBuffer);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final long getRawScore() {
        return getLong(QTaELkFI.wLEEeTOVQwxKXCj);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final void getScoreHolderDisplayName(CharArrayBuffer charArrayBuffer) {
        if (hasNull("external_player_id")) {
            copyToBuffer("default_display_name", charArrayBuffer);
        } else {
            this.zza.getDisplayName(charArrayBuffer);
        }
    }
}
