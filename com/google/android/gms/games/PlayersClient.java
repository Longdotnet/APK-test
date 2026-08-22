package com.google.android.gms.games;

import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes.dex */
public interface PlayersClient {
    public static final String EXTRA_PLAYER_SEARCH_RESULTS = "player_search_results";

    Task getCompareProfileIntent(Player player);

    Task getCompareProfileIntent(String str);

    Task getCompareProfileIntentWithAlternativeNameHints(String str, String str2, String str3);

    Task getCurrentPlayer();

    Task getCurrentPlayer(boolean z);

    Task getCurrentPlayerId();

    Task getPlayerSearchIntent();

    Task loadFriends(int i, boolean z);

    Task loadMoreFriends(int i);

    @Deprecated
    Task loadMoreRecentlyPlayedWithPlayers(int i);

    Task loadPlayer(String str);

    Task loadPlayer(String str, boolean z);

    @Deprecated
    Task loadRecentlyPlayedWithPlayers(int i, boolean z);
}
