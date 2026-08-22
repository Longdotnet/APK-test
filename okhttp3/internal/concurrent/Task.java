package okhttp3.internal.concurrent;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Task {
    public final boolean cancelable;
    public final String name;
    public long nextExecuteNanoTime;
    public TaskQueue queue;

    public Task(String name, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.cancelable = z;
        this.nextExecuteNanoTime = -1L;
    }

    public abstract long runOnce();

    public final String toString() {
        return this.name;
    }
}
