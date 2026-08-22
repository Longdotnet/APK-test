package kotlinx.coroutines.scheduling;

import androidx.work.Logger$LogcatLogger;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes3.dex */
public final class TaskImpl extends Task {
    public final Runnable block;

    public TaskImpl(Runnable runnable, long j, Logger$LogcatLogger logger$LogcatLogger) {
        super(j, logger$LogcatLogger);
        this.block = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.block.run();
        } finally {
            this.taskContext.getClass();
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Task[");
        Runnable runnable = this.block;
        sb.append(runnable.getClass().getSimpleName());
        sb.append('@');
        sb.append(BuildersKt.getHexAddress(runnable));
        sb.append(", ");
        sb.append(this.submissionTime);
        sb.append(", ");
        sb.append(this.taskContext);
        sb.append(']');
        return sb.toString();
    }
}
