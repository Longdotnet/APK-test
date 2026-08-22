package com.google.firebase.heartbeatinfo;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DefaultHeartBeatController$$ExternalSyntheticLambda3 implements ThreadFactory {
    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return DefaultHeartBeatController.lambda$static$0(runnable);
    }
}
