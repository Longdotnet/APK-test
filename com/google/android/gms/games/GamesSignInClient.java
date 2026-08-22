package com.google.android.gms.games;

import com.google.android.gms.games.gamessignin.AuthScope;
import com.google.android.gms.tasks.Task;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface GamesSignInClient {
    Task isAuthenticated();

    Task requestServerSideAccess(String str, boolean z);

    Task requestServerSideAccess(String str, boolean z, List<AuthScope> list);

    Task signIn();
}
