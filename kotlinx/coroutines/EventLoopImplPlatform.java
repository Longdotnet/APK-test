package kotlinx.coroutines;

import kotlin.collections.ArrayDeque;

/* JADX INFO: loaded from: classes3.dex */
public abstract class EventLoopImplPlatform extends CoroutineDispatcher {
    public boolean shared;
    public ArrayDeque unconfinedQueue;
    public long useCount;

    public final void decrementUseCount() {
        long j = this.useCount - 4294967296L;
        this.useCount = j;
        if (j <= 0 && this.shared) {
            shutdown();
        }
    }

    public abstract Thread getThread();

    public final void incrementUseCount(boolean z) {
        this.useCount = (z ? 4294967296L : 1L) + this.useCount;
        if (z) {
            return;
        }
        this.shared = true;
    }

    public final boolean processUnconfinedEvent() {
        ArrayDeque arrayDeque = this.unconfinedQueue;
        if (arrayDeque == null) {
            return false;
        }
        DispatchedTask dispatchedTask = (DispatchedTask) (arrayDeque.isEmpty() ? null : arrayDeque.removeFirst());
        if (dispatchedTask == null) {
            return false;
        }
        dispatchedTask.run();
        return true;
    }

    public abstract void shutdown();
}
