package com.google.android.gms.games;

import android.view.View;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface GamesClient {
    @Deprecated
    Task getActivationHint();

    @Deprecated
    Task getAppId();

    @Deprecated
    Task getCurrentAccountName();

    @Deprecated
    Task getSettingsIntent();

    @Deprecated
    Task setGravityForPopups(int i);

    @Deprecated
    Task setViewForPopups(View view);
}
