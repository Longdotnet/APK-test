package kotlinx.coroutines.scheduling;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.work.Logger$LogcatLogger;
import com.google.firebase.inject.PVS.jIKWv;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.InitializedLazyImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.internal.ResizableAtomicArray;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: loaded from: classes3.dex */
public final class CoroutineScheduler implements Executor, Closeable {
    private volatile int _isTerminated;
    private volatile long controlState;
    public final int corePoolSize;
    public final GlobalQueue globalBlockingQueue;
    public final GlobalQueue globalCpuQueue;
    public final long idleWorkerKeepAliveNs;
    public final int maxPoolSize;
    private volatile long parkedWorkersStack;
    public final String schedulerName;
    public final ResizableAtomicArray workers;
    public static final AtomicLongFieldUpdater parkedWorkersStack$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");
    public static final AtomicLongFieldUpdater controlState$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");
    public static final AtomicIntegerFieldUpdater _isTerminated$FU = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");
    public static final Symbol NOT_IN_STACK = new Symbol("NOT_IN_STACK", 0);

    public final class Worker extends Thread {
        public static final AtomicIntegerFieldUpdater workerCtl$FU = AtomicIntegerFieldUpdater.newUpdater(Worker.class, "workerCtl");
        private volatile int indexInArray;
        public final WorkQueue localQueue;
        public boolean mayHaveLocalTasks;
        public long minDelayUntilStealableTaskNs;
        private volatile Object nextParkedWorker;
        public int rngState;
        public int state;
        public final InitializedLazyImpl stolenTask;
        public long terminationDeadline;
        private volatile int workerCtl;

        public Worker(int i) {
            setDaemon(true);
            this.localQueue = new WorkQueue();
            this.stolenTask = new InitializedLazyImpl();
            this.state = 4;
            this.nextParkedWorker = CoroutineScheduler.NOT_IN_STACK;
            Random.Default.getClass();
            this.rngState = Random.defaultRandom.nextInt();
            setIndexInArray(i);
        }

        public final Task findTask(boolean z) {
            Task taskPollGlobalQueues;
            Task taskPollGlobalQueues2;
            CoroutineScheduler coroutineScheduler;
            long j;
            int i = this.state;
            Task task = null;
            WorkQueue workQueue = this.localQueue;
            CoroutineScheduler coroutineScheduler2 = CoroutineScheduler.this;
            if (i != 1) {
                AtomicLongFieldUpdater atomicLongFieldUpdater = CoroutineScheduler.controlState$FU;
                do {
                    coroutineScheduler = CoroutineScheduler.this;
                    j = atomicLongFieldUpdater.get(coroutineScheduler);
                    if (((int) ((9223367638808264704L & j) >> 42)) == 0) {
                        workQueue.getClass();
                        loop1: while (true) {
                            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = WorkQueue.lastScheduledTask$FU;
                            Task task2 = (Task) atomicReferenceFieldUpdater.get(workQueue);
                            if (task2 == null || task2.taskContext.mLoggingLevel != 1) {
                                int i2 = WorkQueue.consumerIndex$FU.get(workQueue);
                                int i3 = WorkQueue.producerIndex$FU.get(workQueue);
                                while (i2 != i3 && WorkQueue.blockingTasksInBuffer$FU.get(workQueue) != 0) {
                                    i3--;
                                    Task taskTryExtractFromTheMiddle = workQueue.tryExtractFromTheMiddle(i3, true);
                                    if (taskTryExtractFromTheMiddle != null) {
                                        task = taskTryExtractFromTheMiddle;
                                        break;
                                    }
                                }
                                break;
                            }
                            do {
                                if (atomicReferenceFieldUpdater.compareAndSet(workQueue, task2, null)) {
                                    task = task2;
                                    break loop1;
                                }
                            } while (atomicReferenceFieldUpdater.get(workQueue) == task2);
                        }
                        if (task != null) {
                            return task;
                        }
                        Task task3 = (Task) coroutineScheduler2.globalBlockingQueue.removeFirstOrNull();
                        return task3 == null ? trySteal(1) : task3;
                    }
                } while (!CoroutineScheduler.controlState$FU.compareAndSet(coroutineScheduler, j, j - 4398046511104L));
                this.state = 1;
            }
            if (z) {
                boolean z2 = nextInt(coroutineScheduler2.corePoolSize * 2) == 0;
                if (z2 && (taskPollGlobalQueues2 = pollGlobalQueues()) != null) {
                    return taskPollGlobalQueues2;
                }
                workQueue.getClass();
                Task taskPollBuffer = (Task) WorkQueue.lastScheduledTask$FU.getAndSet(workQueue, null);
                if (taskPollBuffer == null) {
                    taskPollBuffer = workQueue.pollBuffer();
                }
                if (taskPollBuffer != null) {
                    return taskPollBuffer;
                }
                if (!z2 && (taskPollGlobalQueues = pollGlobalQueues()) != null) {
                    return taskPollGlobalQueues;
                }
            } else {
                Task taskPollGlobalQueues3 = pollGlobalQueues();
                if (taskPollGlobalQueues3 != null) {
                    return taskPollGlobalQueues3;
                }
            }
            return trySteal(3);
        }

        public final int getIndexInArray() {
            return this.indexInArray;
        }

        public final Object getNextParkedWorker() {
            return this.nextParkedWorker;
        }

        public final int nextInt(int i) {
            int i2 = this.rngState;
            int i3 = i2 ^ (i2 << 13);
            int i4 = i3 ^ (i3 >> 17);
            int i5 = i4 ^ (i4 << 5);
            this.rngState = i5;
            int i6 = i - 1;
            return (i6 & i) == 0 ? i5 & i6 : (i5 & Integer.MAX_VALUE) % i;
        }

        public final Task pollGlobalQueues() {
            int iNextInt = nextInt(2);
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            if (iNextInt == 0) {
                Task task = (Task) coroutineScheduler.globalCpuQueue.removeFirstOrNull();
                return task != null ? task : (Task) coroutineScheduler.globalBlockingQueue.removeFirstOrNull();
            }
            Task task2 = (Task) coroutineScheduler.globalBlockingQueue.removeFirstOrNull();
            return task2 != null ? task2 : (Task) coroutineScheduler.globalCpuQueue.removeFirstOrNull();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            AtomicLongFieldUpdater atomicLongFieldUpdater;
            long j;
            int i;
            loop0: while (true) {
                boolean z = false;
                while (true) {
                    CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
                    coroutineScheduler.getClass();
                    int i2 = 5;
                    if (CoroutineScheduler._isTerminated$FU.get(coroutineScheduler) != 0 || this.state == 5) {
                        break loop0;
                    }
                    Task taskFindTask = findTask(this.mayHaveLocalTasks);
                    int i3 = 3;
                    if (taskFindTask == null) {
                        this.mayHaveLocalTasks = false;
                        if (this.minDelayUntilStealableTaskNs == 0) {
                            Object obj = this.nextParkedWorker;
                            Symbol symbol = CoroutineScheduler.NOT_IN_STACK;
                            if (obj != symbol) {
                                workerCtl$FU.set(this, -1);
                                while (this.nextParkedWorker != CoroutineScheduler.NOT_IN_STACK) {
                                    AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = workerCtl$FU;
                                    if (atomicIntegerFieldUpdater.get(this) != -1) {
                                        break;
                                    }
                                    CoroutineScheduler coroutineScheduler2 = CoroutineScheduler.this;
                                    coroutineScheduler2.getClass();
                                    AtomicIntegerFieldUpdater atomicIntegerFieldUpdater2 = CoroutineScheduler._isTerminated$FU;
                                    if (atomicIntegerFieldUpdater2.get(coroutineScheduler2) != 0 || this.state == i2) {
                                        break;
                                    }
                                    tryReleaseCpu(i3);
                                    Thread.interrupted();
                                    if (this.terminationDeadline == 0) {
                                        this.terminationDeadline = System.nanoTime() + CoroutineScheduler.this.idleWorkerKeepAliveNs;
                                    }
                                    LockSupport.parkNanos(CoroutineScheduler.this.idleWorkerKeepAliveNs);
                                    if (System.nanoTime() - this.terminationDeadline >= 0) {
                                        this.terminationDeadline = 0L;
                                        CoroutineScheduler coroutineScheduler3 = CoroutineScheduler.this;
                                        synchronized (coroutineScheduler3.workers) {
                                            try {
                                                if (!(atomicIntegerFieldUpdater2.get(coroutineScheduler3) != 0)) {
                                                    AtomicLongFieldUpdater atomicLongFieldUpdater2 = CoroutineScheduler.controlState$FU;
                                                    if (((int) (atomicLongFieldUpdater2.get(coroutineScheduler3) & 2097151)) > coroutineScheduler3.corePoolSize) {
                                                        if (atomicIntegerFieldUpdater.compareAndSet(this, -1, 1)) {
                                                            int i4 = this.indexInArray;
                                                            setIndexInArray(0);
                                                            coroutineScheduler3.parkedWorkersStackTopUpdate(this, i4, 0);
                                                            int andDecrement = (int) (atomicLongFieldUpdater2.getAndDecrement(coroutineScheduler3) & 2097151);
                                                            if (andDecrement != i4) {
                                                                Object obj2 = coroutineScheduler3.workers.get(andDecrement);
                                                                Intrinsics.checkNotNull(obj2);
                                                                Worker worker = (Worker) obj2;
                                                                coroutineScheduler3.workers.setSynchronized(i4, worker);
                                                                worker.setIndexInArray(i4);
                                                                coroutineScheduler3.parkedWorkersStackTopUpdate(worker, andDecrement, i4);
                                                            }
                                                            coroutineScheduler3.workers.setSynchronized(andDecrement, null);
                                                            this.state = 5;
                                                        }
                                                    }
                                                }
                                            } catch (Throwable th) {
                                                throw th;
                                            }
                                        }
                                    }
                                    i2 = 5;
                                    i3 = 3;
                                }
                            } else {
                                CoroutineScheduler coroutineScheduler4 = CoroutineScheduler.this;
                                coroutineScheduler4.getClass();
                                if (this.nextParkedWorker == symbol) {
                                    do {
                                        atomicLongFieldUpdater = CoroutineScheduler.parkedWorkersStack$FU;
                                        j = atomicLongFieldUpdater.get(coroutineScheduler4);
                                        i = this.indexInArray;
                                        this.nextParkedWorker = coroutineScheduler4.workers.get((int) (j & 2097151));
                                    } while (!atomicLongFieldUpdater.compareAndSet(coroutineScheduler4, j, ((j + 2097152) & (-2097152)) | ((long) i)));
                                }
                            }
                        } else {
                            if (z) {
                                tryReleaseCpu(3);
                                Thread.interrupted();
                                LockSupport.parkNanos(this.minDelayUntilStealableTaskNs);
                                this.minDelayUntilStealableTaskNs = 0L;
                                break;
                            }
                            z = true;
                        }
                    } else {
                        this.minDelayUntilStealableTaskNs = 0L;
                        int i5 = taskFindTask.taskContext.mLoggingLevel;
                        this.terminationDeadline = 0L;
                        if (this.state == 3) {
                            this.state = 2;
                        }
                        CoroutineScheduler coroutineScheduler5 = CoroutineScheduler.this;
                        if (i5 != 0 && tryReleaseCpu(2) && !coroutineScheduler5.tryUnpark() && !coroutineScheduler5.tryCreateWorker(CoroutineScheduler.controlState$FU.get(coroutineScheduler5))) {
                            coroutineScheduler5.tryUnpark();
                        }
                        coroutineScheduler5.getClass();
                        try {
                            taskFindTask.run();
                        } catch (Throwable th2) {
                            Thread threadCurrentThread = Thread.currentThread();
                            threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th2);
                        }
                        if (i5 != 0) {
                            CoroutineScheduler.controlState$FU.addAndGet(coroutineScheduler5, -2097152L);
                            if (this.state == 5) {
                                break;
                            }
                            this.state = 4;
                            break;
                        }
                        break;
                    }
                }
            }
            tryReleaseCpu(5);
        }

        public final void setIndexInArray(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.schedulerName);
            sb.append("-worker-");
            sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
            setName(sb.toString());
            this.indexInArray = i;
        }

        public final void setNextParkedWorker(Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean tryReleaseCpu(int i) {
            int i2 = this.state;
            boolean z = i2 == 1;
            if (z) {
                CoroutineScheduler.controlState$FU.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (i2 != i) {
                this.state = i;
            }
            return z;
        }

        /* JADX WARN: Code duplicated, block: B:53:0x00c4  */
        /* JADX WARN: Code duplicated, block: B:55:0x00ca  */
        /* JADX WARN: Code duplicated, block: B:68:0x00bd A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:70:0x00df A[SYNTHETIC] */
        public final Task trySteal(int i) {
            int i2;
            Task taskTryExtractFromTheMiddle;
            long j;
            AtomicLongFieldUpdater atomicLongFieldUpdater = CoroutineScheduler.controlState$FU;
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            int i3 = (int) (atomicLongFieldUpdater.get(coroutineScheduler) & 2097151);
            Task task = null;
            if (i3 < 2) {
                return null;
            }
            int iNextInt = nextInt(i3);
            int i4 = 0;
            long jMin = Long.MAX_VALUE;
            while (i4 < i3) {
                int i5 = iNextInt + 1;
                if (i5 > i3) {
                    i5 = 1;
                }
                Worker worker = (Worker) coroutineScheduler.workers.get(i5);
                if (worker == null || worker == this) {
                    i2 = i5;
                } else {
                    WorkQueue workQueue = worker.localQueue;
                    if (i != 3) {
                        workQueue.getClass();
                        int i6 = WorkQueue.consumerIndex$FU.get(workQueue);
                        int i7 = WorkQueue.producerIndex$FU.get(workQueue);
                        boolean z = i == 1;
                        while (true) {
                            if (i6 != i7 && (!z || WorkQueue.blockingTasksInBuffer$FU.get(workQueue) != 0)) {
                                int i8 = i6 + 1;
                                taskTryExtractFromTheMiddle = workQueue.tryExtractFromTheMiddle(i6, z);
                                if (taskTryExtractFromTheMiddle != null) {
                                    break;
                                }
                                i6 = i8;
                            } else {
                                taskTryExtractFromTheMiddle = task;
                                break;
                            }
                        }
                    } else {
                        taskTryExtractFromTheMiddle = workQueue.pollBuffer();
                    }
                    InitializedLazyImpl initializedLazyImpl = this.stolenTask;
                    if (taskTryExtractFromTheMiddle != null) {
                        initializedLazyImpl.value = taskTryExtractFromTheMiddle;
                        i2 = i5;
                    } else {
                        while (true) {
                            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = WorkQueue.lastScheduledTask$FU;
                            Task task2 = (Task) atomicReferenceFieldUpdater.get(workQueue);
                            if (task2 != null) {
                                if (((task2.taskContext.mLoggingLevel == 1 ? 1 : 2) & i) != 0) {
                                    TasksKt.schedulerTimeSource.getClass();
                                    i2 = i5;
                                    long jNanoTime = System.nanoTime() - task2.submissionTime;
                                    long j2 = TasksKt.WORK_STEALING_TIME_RESOLUTION_NS;
                                    if (jNanoTime < j2) {
                                        j = j2 - jNanoTime;
                                        task = null;
                                        break;
                                    }
                                    while (true) {
                                        task = null;
                                        if (atomicReferenceFieldUpdater.compareAndSet(workQueue, task2, null)) {
                                            initializedLazyImpl.value = task2;
                                        } else if (atomicReferenceFieldUpdater.get(workQueue) != task2) {
                                            i5 = i2;
                                            task = null;
                                        }
                                    }
                                }
                            }
                            i2 = i5;
                            j = -2;
                            break;
                        }
                        if (j == -1) {
                            Task task3 = (Task) initializedLazyImpl.value;
                            initializedLazyImpl.value = task;
                            return task3;
                        }
                        if (j > 0) {
                            jMin = Math.min(jMin, j);
                        }
                    }
                    j = -1;
                    if (j == -1) {
                        Task task4 = (Task) initializedLazyImpl.value;
                        initializedLazyImpl.value = task;
                        return task4;
                    }
                    if (j > 0) {
                        jMin = Math.min(jMin, j);
                    }
                }
                i4++;
                iNextInt = i2;
                task = null;
            }
            if (jMin == Long.MAX_VALUE) {
                jMin = 0;
            }
            this.minDelayUntilStealableTaskNs = jMin;
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0089  */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws InterruptedException {
        int i;
        Task taskFindTask;
        if (_isTerminated$FU.compareAndSet(this, 0, 1)) {
            Thread threadCurrentThread = Thread.currentThread();
            Worker worker = threadCurrentThread instanceof Worker ? (Worker) threadCurrentThread : null;
            if (worker == null || !Intrinsics.areEqual(CoroutineScheduler.this, this)) {
                worker = null;
            }
            synchronized (this.workers) {
                i = (int) (controlState$FU.get(this) & 2097151);
            }
            if (1 <= i) {
                int i2 = 1;
                while (true) {
                    Object obj = this.workers.get(i2);
                    Intrinsics.checkNotNull(obj);
                    Worker worker2 = (Worker) obj;
                    if (worker2 != worker) {
                        while (worker2.isAlive()) {
                            LockSupport.unpark(worker2);
                            worker2.join(10000L);
                        }
                        WorkQueue workQueue = worker2.localQueue;
                        GlobalQueue globalQueue = this.globalBlockingQueue;
                        workQueue.getClass();
                        Task task = (Task) WorkQueue.lastScheduledTask$FU.getAndSet(workQueue, null);
                        if (task != null) {
                            globalQueue.addLast(task);
                        }
                        while (true) {
                            Task taskPollBuffer = workQueue.pollBuffer();
                            if (taskPollBuffer == null) {
                                break;
                            } else {
                                globalQueue.addLast(taskPollBuffer);
                            }
                        }
                    }
                    if (i2 == i) {
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            this.globalBlockingQueue.close();
            this.globalCpuQueue.close();
            while (true) {
                if (worker != null) {
                    taskFindTask = worker.findTask(true);
                    if (taskFindTask == null) {
                        taskFindTask = (Task) this.globalCpuQueue.removeFirstOrNull();
                        if (taskFindTask == null) {
                            break;
                            break;
                        }
                    }
                } else {
                    taskFindTask = (Task) this.globalCpuQueue.removeFirstOrNull();
                    if (taskFindTask == null && (taskFindTask = (Task) this.globalBlockingQueue.removeFirstOrNull()) == null) {
                        break;
                    }
                }
                try {
                    taskFindTask.run();
                } catch (Throwable th) {
                    Thread threadCurrentThread2 = Thread.currentThread();
                    threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
                }
            }
            if (worker != null) {
                worker.tryReleaseCpu(5);
            }
            parkedWorkersStack$FU.set(this, 0L);
            controlState$FU.set(this, 0L);
        }
    }

    public final int createNewWorker() {
        synchronized (this.workers) {
            try {
                if (_isTerminated$FU.get(this) != 0) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = controlState$FU;
                long j = atomicLongFieldUpdater.get(this);
                int i = (int) (j & 2097151);
                int i2 = i - ((int) ((j & 4398044413952L) >> 21));
                if (i2 < 0) {
                    i2 = 0;
                }
                if (i2 >= this.corePoolSize) {
                    return 0;
                }
                if (i >= this.maxPoolSize) {
                    return 0;
                }
                int i3 = ((int) (atomicLongFieldUpdater.get(this) & 2097151)) + 1;
                if (i3 <= 0 || this.workers.get(i3) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                Worker worker = new Worker(i3);
                this.workers.setSynchronized(i3, worker);
                if (i3 != ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                int i4 = i2 + 1;
                worker.start();
                return i4;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void dispatch(Runnable runnable, Logger$LogcatLogger logger$LogcatLogger, boolean z) {
        Task taskImpl;
        int i;
        TasksKt.schedulerTimeSource.getClass();
        long jNanoTime = System.nanoTime();
        if (runnable instanceof Task) {
            taskImpl = (Task) runnable;
            taskImpl.submissionTime = jNanoTime;
            taskImpl.taskContext = logger$LogcatLogger;
        } else {
            taskImpl = new TaskImpl(runnable, jNanoTime, logger$LogcatLogger);
        }
        boolean z2 = false;
        boolean z3 = taskImpl.taskContext.mLoggingLevel == 1;
        AtomicLongFieldUpdater atomicLongFieldUpdater = controlState$FU;
        long jAddAndGet = z3 ? atomicLongFieldUpdater.addAndGet(this, 2097152L) : 0L;
        Thread threadCurrentThread = Thread.currentThread();
        Worker worker = threadCurrentThread instanceof Worker ? (Worker) threadCurrentThread : null;
        if (worker == null || !Intrinsics.areEqual(CoroutineScheduler.this, this)) {
            worker = null;
        }
        if (worker != null && (i = worker.state) != 5 && (taskImpl.taskContext.mLoggingLevel != 0 || i != 2)) {
            worker.mayHaveLocalTasks = true;
            WorkQueue workQueue = worker.localQueue;
            if (z) {
                taskImpl = workQueue.addLast(taskImpl);
            } else {
                workQueue.getClass();
                Task task = (Task) WorkQueue.lastScheduledTask$FU.getAndSet(workQueue, taskImpl);
                taskImpl = task == null ? null : workQueue.addLast(task);
            }
        }
        if (taskImpl != null) {
            if (!(taskImpl.taskContext.mLoggingLevel == 1 ? this.globalBlockingQueue.addLast(taskImpl) : this.globalCpuQueue.addLast(taskImpl))) {
                throw new RejectedExecutionException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(new StringBuilder(), this.schedulerName, " was terminated"));
            }
        }
        if (z && worker != null) {
            z2 = true;
        }
        if (z3) {
            if (z2 || tryUnpark() || tryCreateWorker(jAddAndGet)) {
                return;
            }
            tryUnpark();
            return;
        }
        if (z2 || tryUnpark() || tryCreateWorker(atomicLongFieldUpdater.get(this))) {
            return;
        }
        tryUnpark();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        dispatch(runnable, TasksKt.NonBlockingContext, false);
    }

    public final void parkedWorkersStackTopUpdate(Worker worker, int i, int i2) {
        while (true) {
            long j = parkedWorkersStack$FU.get(this);
            int i3 = (int) (2097151 & j);
            long j2 = (2097152 + j) & (-2097152);
            if (i3 == i) {
                if (i2 == 0) {
                    Object nextParkedWorker = worker.getNextParkedWorker();
                    while (true) {
                        if (nextParkedWorker == NOT_IN_STACK) {
                            i3 = -1;
                            break;
                        }
                        if (nextParkedWorker == null) {
                            i3 = 0;
                            break;
                        }
                        Worker worker2 = (Worker) nextParkedWorker;
                        int indexInArray = worker2.getIndexInArray();
                        if (indexInArray != 0) {
                            i3 = indexInArray;
                            break;
                        }
                        nextParkedWorker = worker2.getNextParkedWorker();
                    }
                } else {
                    i3 = i2;
                }
            }
            if (i3 >= 0) {
                if (parkedWorkersStack$FU.compareAndSet(this, j, ((long) i3) | j2)) {
                    return;
                }
            }
        }
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        ResizableAtomicArray resizableAtomicArray = this.workers;
        int iCurrentLength = resizableAtomicArray.currentLength();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 1; i6 < iCurrentLength; i6++) {
            Worker worker = (Worker) resizableAtomicArray.get(i6);
            if (worker != null) {
                WorkQueue workQueue = worker.localQueue;
                workQueue.getClass();
                int i7 = WorkQueue.lastScheduledTask$FU.get(workQueue) != null ? (WorkQueue.producerIndex$FU.get(workQueue) - WorkQueue.consumerIndex$FU.get(workQueue)) + 1 : WorkQueue.producerIndex$FU.get(workQueue) - WorkQueue.consumerIndex$FU.get(workQueue);
                int iOrdinal = Fragment$$ExternalSyntheticOutline0.ordinal(worker.state);
                if (iOrdinal == 0) {
                    i++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i7);
                    sb.append('c');
                    arrayList.add(sb.toString());
                } else if (iOrdinal == 1) {
                    i2++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i7);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (iOrdinal == 2) {
                    i3++;
                } else if (iOrdinal == 3) {
                    i4++;
                    if (i7 > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(i7);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else if (iOrdinal == 4) {
                    i5++;
                }
            }
        }
        long j = controlState$FU.get(this);
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.schedulerName);
        sb4.append('@');
        sb4.append(BuildersKt.getHexAddress(this));
        sb4.append("[Pool Size {core = ");
        int i8 = this.corePoolSize;
        sb4.append(i8);
        sb4.append(", max = ");
        sb4.append(this.maxPoolSize);
        sb4.append("}, Worker States {CPU = ");
        sb4.append(i);
        sb4.append(", blocking = ");
        sb4.append(i2);
        sb4.append(", parked = ");
        sb4.append(i3);
        sb4.append(", dormant = ");
        sb4.append(i4);
        sb4.append(", terminated = ");
        sb4.append(i5);
        sb4.append("}, running workers queues = ");
        sb4.append(arrayList);
        sb4.append(", global CPU queue size = ");
        sb4.append(this.globalCpuQueue.getSize());
        sb4.append(", global blocking queue size = ");
        sb4.append(this.globalBlockingQueue.getSize());
        sb4.append(", Control State {created workers= ");
        sb4.append((int) (2097151 & j));
        sb4.append(", blocking tasks = ");
        sb4.append((int) ((4398044413952L & j) >> 21));
        sb4.append(", CPUs acquired = ");
        sb4.append(i8 - ((int) ((j & 9223367638808264704L) >> 42)));
        sb4.append("}]");
        return sb4.toString();
    }

    public final boolean tryCreateWorker(long j) {
        int i = ((int) (2097151 & j)) - ((int) ((j & 4398044413952L) >> 21));
        if (i < 0) {
            i = 0;
        }
        int i2 = this.corePoolSize;
        if (i < i2) {
            int iCreateNewWorker = createNewWorker();
            if (iCreateNewWorker == 1 && i2 > 1) {
                createNewWorker();
            }
            if (iCreateNewWorker > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean tryUnpark() {
        Symbol symbol;
        int indexInArray;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = parkedWorkersStack$FU;
            long j = atomicLongFieldUpdater.get(this);
            Worker worker = (Worker) this.workers.get((int) (2097151 & j));
            if (worker == null) {
                worker = null;
            } else {
                long j2 = (2097152 + j) & (-2097152);
                Object nextParkedWorker = worker.getNextParkedWorker();
                while (true) {
                    symbol = NOT_IN_STACK;
                    if (nextParkedWorker == symbol) {
                        indexInArray = -1;
                        break;
                    }
                    if (nextParkedWorker == null) {
                        indexInArray = 0;
                        break;
                    }
                    Worker worker2 = (Worker) nextParkedWorker;
                    indexInArray = worker2.getIndexInArray();
                    if (indexInArray != 0) {
                        break;
                    }
                    nextParkedWorker = worker2.getNextParkedWorker();
                }
                if (indexInArray >= 0 && atomicLongFieldUpdater.compareAndSet(this, j, j2 | ((long) indexInArray))) {
                    worker.setNextParkedWorker(symbol);
                }
            }
            if (worker == null) {
                return false;
            }
            if (Worker.workerCtl$FU.compareAndSet(worker, -1, 0)) {
                LockSupport.unpark(worker);
                return true;
            }
        }
    }

    public CoroutineScheduler(int i, int i2, long j, String str) {
        this.corePoolSize = i;
        this.maxPoolSize = i2;
        this.idleWorkerKeepAliveNs = j;
        this.schedulerName = str;
        if (i >= 1) {
            if (i2 >= i) {
                if (i2 <= 2097150) {
                    if (j > 0) {
                        this.globalCpuQueue = new GlobalQueue();
                        this.globalBlockingQueue = new GlobalQueue();
                        this.workers = new ResizableAtomicArray((i + 1) * 2);
                        this.controlState = ((long) i) << 42;
                        this._isTerminated = 0;
                        return;
                    }
                    throw new IllegalArgumentException((jIKWv.WSsj + j + " must be positive").toString());
                }
                throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i2, "Max pool size ", " should not exceed maximal supported number of threads 2097150").toString());
            }
            throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i2, i, "Max pool size ", " should be greater than or equals to core pool size ").toString());
        }
        throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "Core pool size ", " should be at least 1").toString());
    }
}
