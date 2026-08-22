package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzt implements Executor {
    public final /* synthetic */ int $r8$classId;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.$r8$classId) {
            case 0:
                runnable.run();
                break;
            default:
                new Thread(runnable).start();
                break;
        }
    }
}
