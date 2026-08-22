package okhttp3.internal.concurrent;

import com.google.firebase.auth.zzy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes3.dex */
public final class TaskQueue {
    public Task activeTask;
    public boolean cancelActiveTask;
    public final ArrayList futureTasks;
    public final String name;
    public boolean shutdown;
    public final TaskRunner taskRunner;

    public TaskQueue(TaskRunner taskRunner, String name) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(name, "name");
        this.taskRunner = taskRunner;
        this.name = name;
        this.futureTasks = new ArrayList();
    }

    public final void cancelAll() {
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        synchronized (this.taskRunner) {
            if (cancelAllAndDecide$okhttp()) {
                this.taskRunner.kickCoordinator$okhttp(this);
            }
        }
    }

    public final boolean cancelAllAndDecide$okhttp() {
        Task task = this.activeTask;
        if (task != null && task.cancelable) {
            this.cancelActiveTask = true;
        }
        ArrayList arrayList = this.futureTasks;
        boolean z = false;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((Task) arrayList.get(size)).cancelable) {
                Task task2 = (Task) arrayList.get(size);
                TaskRunner taskRunner = TaskRunner.INSTANCE;
                if (TaskRunner.logger.isLoggable(Level.FINE)) {
                    JvmClassMappingKt.access$log(task2, this, "canceled");
                }
                arrayList.remove(size);
                z = true;
            }
        }
        return z;
    }

    public final void schedule(Task task, long j) {
        Intrinsics.checkNotNullParameter(task, "task");
        synchronized (this.taskRunner) {
            if (!this.shutdown) {
                if (scheduleAndDecide$okhttp(task, j, false)) {
                    this.taskRunner.kickCoordinator$okhttp(this);
                }
            } else if (task.cancelable) {
                TaskRunner taskRunner = TaskRunner.INSTANCE;
                if (TaskRunner.logger.isLoggable(Level.FINE)) {
                    JvmClassMappingKt.access$log(task, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                TaskRunner taskRunner2 = TaskRunner.INSTANCE;
                if (TaskRunner.logger.isLoggable(Level.FINE)) {
                    JvmClassMappingKt.access$log(task, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        }
    }

    public final boolean scheduleAndDecide$okhttp(Task task, long j, boolean z) {
        Intrinsics.checkNotNullParameter(task, "task");
        TaskQueue taskQueue = task.queue;
        if (taskQueue != this) {
            if (taskQueue != null) {
                throw new IllegalStateException("task is in multiple queues");
            }
            task.queue = this;
        }
        zzy zzyVar = this.taskRunner.backend;
        long jNanoTime = System.nanoTime();
        long j2 = jNanoTime + j;
        ArrayList arrayList = this.futureTasks;
        int iIndexOf = arrayList.indexOf(task);
        if (iIndexOf != -1) {
            if (task.nextExecuteNanoTime <= j2) {
                TaskRunner taskRunner = TaskRunner.INSTANCE;
                if (TaskRunner.logger.isLoggable(Level.FINE)) {
                    JvmClassMappingKt.access$log(task, this, "already scheduled");
                }
                return false;
            }
            arrayList.remove(iIndexOf);
        }
        task.nextExecuteNanoTime = j2;
        TaskRunner taskRunner2 = TaskRunner.INSTANCE;
        if (TaskRunner.logger.isLoggable(Level.FINE)) {
            JvmClassMappingKt.access$log(task, this, z ? "run again after ".concat(JvmClassMappingKt.formatDuration(j2 - jNanoTime)) : "scheduled after ".concat(JvmClassMappingKt.formatDuration(j2 - jNanoTime)));
        }
        Iterator it = arrayList.iterator();
        int size = 0;
        while (true) {
            if (!it.hasNext()) {
                size = -1;
                break;
            }
            if (((Task) it.next()).nextExecuteNanoTime - jNanoTime > j) {
                break;
            }
            size++;
        }
        if (size == -1) {
            size = arrayList.size();
        }
        arrayList.add(size, task);
        return size == 0;
    }

    public final void shutdown() {
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        synchronized (this.taskRunner) {
            this.shutdown = true;
            if (cancelAllAndDecide$okhttp()) {
                this.taskRunner.kickCoordinator$okhttp(this);
            }
        }
    }

    public final String toString() {
        return this.name;
    }
}
