package com.google.firebase.heartbeatinfo;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DefaultHeartBeatController$$ExternalSyntheticLambda1 implements Callable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ DefaultHeartBeatController f$0;

    public /* synthetic */ DefaultHeartBeatController$$ExternalSyntheticLambda1(DefaultHeartBeatController defaultHeartBeatController, int i) {
        this.$r8$classId = i;
        this.f$0 = defaultHeartBeatController;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.$r8$classId) {
            case 0:
                return this.f$0.lambda$getHeartBeatsHeader$2();
            default:
                return this.f$0.lambda$registerHeartBeat$1();
        }
    }
}
