package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SchedulerCoroutineDispatcher extends ExecutorCoroutineDispatcher {
    public CoroutineScheduler coroutineScheduler;

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        CoroutineScheduler coroutineScheduler = this.coroutineScheduler;
        AtomicLongFieldUpdater atomicLongFieldUpdater = CoroutineScheduler.parkedWorkersStack$FU;
        coroutineScheduler.dispatch(runnable, TasksKt.NonBlockingContext, false);
    }
}
