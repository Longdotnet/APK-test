package com.google.firebase.auth.internal;

import com.google.android.gms.tasks.Task;
import com.google.firebase.internal.InternalTokenProvider;

/* JADX INFO: loaded from: classes.dex */
public interface InternalAuthProvider extends InternalTokenProvider {
    void addIdTokenListener(IdTokenListener idTokenListener);

    @Override // com.google.firebase.internal.InternalTokenProvider
    Task getAccessToken(boolean z);

    @Override // com.google.firebase.internal.InternalTokenProvider
    String getUid();

    void removeIdTokenListener(IdTokenListener idTokenListener);
}
