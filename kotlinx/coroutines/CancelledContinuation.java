package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes3.dex */
public final class CancelledContinuation extends CompletedExceptionally {
    public static final AtomicIntegerFieldUpdater _resumed$FU = AtomicIntegerFieldUpdater.newUpdater(CancelledContinuation.class, "_resumed");
    private volatile int _resumed;

    public CancelledContinuation(CancellableContinuationImpl cancellableContinuationImpl, Throwable th) {
        super(false, th);
        this._resumed = 0;
    }
}
