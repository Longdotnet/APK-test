package kotlinx.coroutines.internal;

import com.google.android.gms.tasks.zzc;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DefaultExecutorKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.scheduling.UnlimitedIoScheduler;

/* JADX INFO: loaded from: classes3.dex */
public final class LimitedDispatcher extends CoroutineDispatcher implements Delay {
    public static final AtomicIntegerFieldUpdater runningWorkers$FU = AtomicIntegerFieldUpdater.newUpdater(LimitedDispatcher.class, "runningWorkers");
    public final UnlimitedIoScheduler dispatcher;
    public final int parallelism;
    public final LockFreeTaskQueue queue;
    private volatile int runningWorkers;
    public final Object workerAllocationLock;

    /* JADX WARN: Multi-variable type inference failed */
    public LimitedDispatcher(UnlimitedIoScheduler unlimitedIoScheduler, int i) {
        this.dispatcher = unlimitedIoScheduler;
        this.parallelism = i;
        if ((unlimitedIoScheduler instanceof Delay ? (Delay) unlimitedIoScheduler : null) == null) {
            int i2 = DefaultExecutorKt.$r8$clinit;
        }
        this.queue = new LockFreeTaskQueue();
        this.workerAllocationLock = new Object();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        this.queue.addLast(runnable);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = runningWorkers$FU;
        if (atomicIntegerFieldUpdater.get(this) < this.parallelism) {
            synchronized (this.workerAllocationLock) {
                if (atomicIntegerFieldUpdater.get(this) >= this.parallelism) {
                    return;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
                Runnable runnableObtainTaskOrDeallocateWorker = obtainTaskOrDeallocateWorker();
                if (runnableObtainTaskOrDeallocateWorker == null) {
                    return;
                }
                this.dispatcher.dispatch(this, new zzc(this, runnableObtainTaskOrDeallocateWorker, 16));
            }
        }
    }

    public final Runnable obtainTaskOrDeallocateWorker() {
        while (true) {
            Runnable runnable = (Runnable) this.queue.removeFirstOrNull();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.workerAllocationLock) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = runningWorkers$FU;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.queue.getSize() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }
}
