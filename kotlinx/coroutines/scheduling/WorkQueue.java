package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes3.dex */
public final class WorkQueue {
    private volatile int blockingTasksInBuffer;
    public final AtomicReferenceArray buffer = new AtomicReferenceArray(128);
    private volatile int consumerIndex;
    private volatile Object lastScheduledTask;
    private volatile int producerIndex;
    public static final AtomicReferenceFieldUpdater lastScheduledTask$FU = AtomicReferenceFieldUpdater.newUpdater(WorkQueue.class, Object.class, "lastScheduledTask");
    public static final AtomicIntegerFieldUpdater producerIndex$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "producerIndex");
    public static final AtomicIntegerFieldUpdater consumerIndex$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "consumerIndex");
    public static final AtomicIntegerFieldUpdater blockingTasksInBuffer$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "blockingTasksInBuffer");

    public final Task addLast(Task task) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = producerIndex$FU;
        if (atomicIntegerFieldUpdater.get(this) - consumerIndex$FU.get(this) == 127) {
            return task;
        }
        if (task.taskContext.mLoggingLevel == 1) {
            blockingTasksInBuffer$FU.incrementAndGet(this);
        }
        int i = atomicIntegerFieldUpdater.get(this) & 127;
        while (true) {
            AtomicReferenceArray atomicReferenceArray = this.buffer;
            if (atomicReferenceArray.get(i) == null) {
                atomicReferenceArray.lazySet(i, task);
                atomicIntegerFieldUpdater.incrementAndGet(this);
                return null;
            }
            Thread.yield();
        }
    }

    public final Task pollBuffer() {
        Task task;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = consumerIndex$FU;
            int i = atomicIntegerFieldUpdater.get(this);
            if (i - producerIndex$FU.get(this) == 0) {
                return null;
            }
            int i2 = i & 127;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i, i + 1) && (task = (Task) this.buffer.getAndSet(i2, null)) != null) {
                if (task.taskContext.mLoggingLevel == 1) {
                    blockingTasksInBuffer$FU.decrementAndGet(this);
                }
                return task;
            }
        }
    }

    public final Task tryExtractFromTheMiddle(int i, boolean z) {
        int i2 = i & 127;
        AtomicReferenceArray atomicReferenceArray = this.buffer;
        Task task = (Task) atomicReferenceArray.get(i2);
        if (task != null) {
            if ((task.taskContext.mLoggingLevel == 1) == z) {
                while (!atomicReferenceArray.compareAndSet(i2, task, null)) {
                    if (atomicReferenceArray.get(i2) != task) {
                    }
                }
                if (z) {
                    blockingTasksInBuffer$FU.decrementAndGet(this);
                }
                return task;
            }
        }
        return null;
    }
}
