package com.google.firebase.internal;

import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes.dex */
public interface InternalTokenProvider {
    Task getAccessToken(boolean z);

    String getUid();
}
