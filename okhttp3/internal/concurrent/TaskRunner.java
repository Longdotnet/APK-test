package okhttp3.internal.concurrent;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.work.Configuration;
import com.google.android.gms.games.snapshot.Xa.JrbhsraGtto;
import com.google.android.gms.tasks.zzg;
import com.google.firebase.auth.zzr;
import com.google.firebase.auth.zzy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes3.dex */
public final class TaskRunner {
    public static final zzr Companion = new zzr(28);
    public static final TaskRunner INSTANCE;
    public static final Logger logger;
    public final zzy backend;
    public boolean coordinatorWaiting;
    public long coordinatorWakeUpAt;
    public int nextQueueName = 10000;
    public final ArrayList busyQueues = new ArrayList();
    public final ArrayList readyQueues = new ArrayList();
    public final zzg runnable = new zzg(this, 4);

    static {
        String name = Util.okHttpName + " TaskRunner";
        Intrinsics.checkNotNullParameter(name, "name");
        INSTANCE = new TaskRunner(new zzy(new Configuration.AnonymousClass1(name, true)));
        Logger logger2 = Logger.getLogger(TaskRunner.class.getName());
        Intrinsics.checkNotNullExpressionValue(logger2, "Logger.getLogger(TaskRunner::class.java.name)");
        logger = logger2;
    }

    public TaskRunner(zzy zzyVar) {
        this.backend = zzyVar;
    }

    public static final void access$runTask(TaskRunner taskRunner, Task task) {
        taskRunner.getClass();
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, "currentThread");
        String name = currentThread.getName();
        currentThread.setName(task.name);
        try {
            long jRunOnce = task.runOnce();
            synchronized (taskRunner) {
                taskRunner.afterRun(task, jRunOnce);
            }
        } finally {
            synchronized (taskRunner) {
                taskRunner.afterRun(task, -1L);
                currentThread.setName(name);
            }
        }
    }

    public final void afterRun(Task task, long j) {
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        TaskQueue taskQueue = task.queue;
        Intrinsics.checkNotNull(taskQueue);
        if (taskQueue.activeTask != task) {
            throw new IllegalStateException("Check failed.");
        }
        boolean z = taskQueue.cancelActiveTask;
        taskQueue.cancelActiveTask = false;
        taskQueue.activeTask = null;
        this.busyQueues.remove(taskQueue);
        if (j != -1 && !z && !taskQueue.shutdown) {
            taskQueue.scheduleAndDecide$okhttp(task, j, true);
        }
        if (taskQueue.futureTasks.isEmpty()) {
            return;
        }
        this.readyQueues.add(taskQueue);
    }

    public final Task awaitTaskToRun() {
        boolean z;
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        while (true) {
            ArrayList arrayList = this.readyQueues;
            if (arrayList.isEmpty()) {
                return null;
            }
            zzy zzyVar = this.backend;
            long jNanoTime = System.nanoTime();
            Iterator it = arrayList.iterator();
            long jMin = Long.MAX_VALUE;
            Task task = null;
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                Task task2 = (Task) ((TaskQueue) it.next()).futureTasks.get(0);
                long jMax = Math.max(0L, task2.nextExecuteNanoTime - jNanoTime);
                if (jMax > 0) {
                    jMin = Math.min(jMax, jMin);
                } else {
                    if (task != null) {
                        z = true;
                        break;
                    }
                    task = task2;
                }
            }
            ArrayList arrayList2 = this.busyQueues;
            if (task != null) {
                byte[] bArr2 = Util.EMPTY_BYTE_ARRAY;
                task.nextExecuteNanoTime = -1L;
                TaskQueue taskQueue = task.queue;
                Intrinsics.checkNotNull(taskQueue);
                taskQueue.futureTasks.remove(task);
                arrayList.remove(taskQueue);
                taskQueue.activeTask = task;
                arrayList2.add(taskQueue);
                if (z || (!this.coordinatorWaiting && !arrayList.isEmpty())) {
                    zzg runnable = this.runnable;
                    Intrinsics.checkNotNullParameter(runnable, "runnable");
                    ((ThreadPoolExecutor) zzyVar.zza).execute(runnable);
                }
                return task;
            }
            if (this.coordinatorWaiting) {
                if (jMin < this.coordinatorWakeUpAt - jNanoTime) {
                    notify();
                }
                return null;
            }
            this.coordinatorWaiting = true;
            this.coordinatorWakeUpAt = jNanoTime + jMin;
            try {
                try {
                    long j = jMin / 1000000;
                    Long.signum(j);
                    long j2 = jMin - (1000000 * j);
                    if (j > 0 || jMin > 0) {
                        wait(j, (int) j2);
                    }
                } catch (InterruptedException unused) {
                    for (int size = arrayList2.size() - 1; size >= 0; size--) {
                        ((TaskQueue) arrayList2.get(size)).cancelAllAndDecide$okhttp();
                    }
                    for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                        TaskQueue taskQueue2 = (TaskQueue) arrayList.get(size2);
                        taskQueue2.cancelAllAndDecide$okhttp();
                        if (taskQueue2.futureTasks.isEmpty()) {
                            arrayList.remove(size2);
                        }
                    }
                }
                this.coordinatorWaiting = false;
            } catch (Throwable th) {
                this.coordinatorWaiting = false;
                throw th;
            }
        }
    }

    public final void kickCoordinator$okhttp(TaskQueue taskQueue) {
        Intrinsics.checkNotNullParameter(taskQueue, "taskQueue");
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        if (taskQueue.activeTask == null) {
            boolean zIsEmpty = taskQueue.futureTasks.isEmpty();
            ArrayList addIfAbsent = this.readyQueues;
            if (zIsEmpty) {
                addIfAbsent.remove(taskQueue);
            } else {
                Intrinsics.checkNotNullParameter(addIfAbsent, "$this$addIfAbsent");
                if (!addIfAbsent.contains(taskQueue)) {
                    addIfAbsent.add(taskQueue);
                }
            }
        }
        boolean z = this.coordinatorWaiting;
        zzy zzyVar = this.backend;
        if (z) {
            notify();
            return;
        }
        zzg runnable = this.runnable;
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        ((ThreadPoolExecutor) zzyVar.zza).execute(runnable);
    }

    public final TaskQueue newQueue() {
        int i;
        synchronized (this) {
            i = this.nextQueueName;
            this.nextQueueName = i + 1;
        }
        return new TaskQueue(this, CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, JrbhsraGtto.Opv));
    }
}
