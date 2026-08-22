package com.google.android.gms.games;

import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes.dex */
public interface EventsClient {
    void increment(String str, int i);

    Task load(boolean z);

    Task loadByIds(boolean z, String... strArr);
}
