package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.games.Player;

/* JADX INFO: loaded from: classes.dex */
public interface LeaderboardScore {
    public static final int LEADERBOARD_RANK_UNKNOWN = -1;

    /* synthetic */ Object freeze();

    String getDisplayRank();

    void getDisplayRank(CharArrayBuffer charArrayBuffer);

    String getDisplayScore();

    void getDisplayScore(CharArrayBuffer charArrayBuffer);

    long getRank();

    long getRawScore();

    Player getScoreHolder();

    String getScoreHolderDisplayName();

    void getScoreHolderDisplayName(CharArrayBuffer charArrayBuffer);

    Uri getScoreHolderHiResImageUri();

    @Deprecated
    String getScoreHolderHiResImageUrl();

    Uri getScoreHolderIconImageUri();

    @Deprecated
    String getScoreHolderIconImageUrl();

    String getScoreTag();

    long getTimestampMillis();

    /* synthetic */ boolean isDataValid();
}
