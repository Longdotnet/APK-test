package kotlinx.coroutines.scheduling;

import androidx.work.Logger$LogcatLogger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Task implements Runnable {
    public long submissionTime;
    public Logger$LogcatLogger taskContext;

    public Task(long j, Logger$LogcatLogger logger$LogcatLogger) {
        this.submissionTime = j;
        this.taskContext = logger$LogcatLogger;
    }
}
