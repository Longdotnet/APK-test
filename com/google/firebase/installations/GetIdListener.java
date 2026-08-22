package com.google.firebase.installations;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.installations.local.PersistedInstallationEntry;

/* JADX INFO: loaded from: classes.dex */
public final class GetIdListener implements StateListener {
    public final TaskCompletionSource taskCompletionSource;

    public GetIdListener(TaskCompletionSource taskCompletionSource) {
        this.taskCompletionSource = taskCompletionSource;
    }

    @Override // com.google.firebase.installations.StateListener
    public final boolean onException(Exception exc) {
        return false;
    }

    @Override // com.google.firebase.installations.StateListener
    public final boolean onStateReached(PersistedInstallationEntry persistedInstallationEntry) {
        if (!persistedInstallationEntry.isUnregistered() && !persistedInstallationEntry.isRegistered() && !persistedInstallationEntry.isErrored()) {
            return false;
        }
        this.taskCompletionSource.trySetResult(persistedInstallationEntry.getFirebaseInstallationId());
        return true;
    }
}
