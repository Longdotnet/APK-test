package kotlinx.coroutines;

import androidx.startup.StartupException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: loaded from: classes3.dex */
public final class CancellableContinuationImpl extends DispatchedTask implements Continuation, CoroutineStackFrame {
    private volatile int _decisionAndIndex;
    private volatile Object _parentHandle;
    private volatile Object _state;
    public final CoroutineContext context;
    public final Continuation delegate;
    public static final AtomicIntegerFieldUpdater _decisionAndIndex$FU = AtomicIntegerFieldUpdater.newUpdater(CancellableContinuationImpl.class, "_decisionAndIndex");
    public static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_state");
    public static final AtomicReferenceFieldUpdater _parentHandle$FU = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_parentHandle");

    public CancellableContinuationImpl(Continuation continuation) {
        super(1);
        this.delegate = continuation;
        this.context = continuation.getContext();
        this._decisionAndIndex = 536870911;
        this._state = Active.INSTANCE;
    }

    public final void cancel(Throwable th) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof Active)) {
                return;
            }
            CancelledContinuation cancelledContinuation = new CancelledContinuation(this, th);
            do {
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, cancelledContinuation)) {
                    if (!isReusable()) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = _parentHandle$FU;
                        DisposableHandle disposableHandle = (DisposableHandle) atomicReferenceFieldUpdater2.get(this);
                        if (disposableHandle != null) {
                            disposableHandle.dispose();
                            atomicReferenceFieldUpdater2.set(this, NonDisposableHandle.INSTANCE);
                        }
                    }
                    dispatchResume(this.resumeMode);
                    return;
                }
            } while (atomicReferenceFieldUpdater.get(this) == obj);
        }
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final void cancelCompletedResult$kotlinx_coroutines_core(Object obj, CancellationException cancellationException) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof Active) {
                throw new IllegalStateException("Not completed");
            }
            if (obj2 instanceof CompletedExceptionally) {
                return;
            }
            if (!(obj2 instanceof CompletedContinuation)) {
                CompletedContinuation completedContinuation = new CompletedContinuation(obj2, null, null, cancellationException);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, completedContinuation)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                    }
                }
                return;
            }
            CompletedContinuation completedContinuation2 = (CompletedContinuation) obj2;
            if (completedContinuation2.cancelCause != null) {
                throw new IllegalStateException("Must be called at most once");
            }
            Object obj3 = completedContinuation2.result;
            Function1 function1 = completedContinuation2.onCancellation;
            CompletedContinuation completedContinuation3 = new CompletedContinuation(obj3, function1, completedContinuation2.idempotentResume, cancellationException);
            do {
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, completedContinuation3)) {
                    if (function1 != null) {
                        try {
                            function1.invoke(cancellationException);
                            return;
                        } catch (Throwable th) {
                            BuildersKt.handleCoroutineException(this.context, new StartupException("Exception in resume onCancellation handler for " + this, th));
                            return;
                        }
                    }
                    return;
                }
            } while (atomicReferenceFieldUpdater.get(this) == obj2);
        }
    }

    public final void dispatchResume(int i) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i2;
        do {
            atomicIntegerFieldUpdater = _decisionAndIndex$FU;
            i2 = atomicIntegerFieldUpdater.get(this);
            int i3 = i2 >> 29;
            if (i3 != 0) {
                if (i3 != 1) {
                    throw new IllegalStateException("Already resumed");
                }
                boolean z = i == 4;
                Continuation continuation = this.delegate;
                if (!z && (continuation instanceof DispatchedContinuation)) {
                    boolean z2 = i == 1 || i == 2;
                    int i4 = this.resumeMode;
                    if (z2 == (i4 == 1 || i4 == 2)) {
                        CoroutineDispatcher coroutineDispatcher = ((DispatchedContinuation) continuation).dispatcher;
                        CoroutineContext coroutineContext = ((DispatchedContinuation) continuation).continuation._context;
                        Intrinsics.checkNotNull(coroutineContext);
                        if (coroutineDispatcher.isDispatchNeeded()) {
                            coroutineDispatcher.dispatch(coroutineContext, this);
                            return;
                        }
                        EventLoopImplPlatform eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.getEventLoop$kotlinx_coroutines_core();
                        if (eventLoop$kotlinx_coroutines_core.useCount >= 4294967296L) {
                            ArrayDeque arrayDeque = eventLoop$kotlinx_coroutines_core.unconfinedQueue;
                            if (arrayDeque == null) {
                                arrayDeque = new ArrayDeque();
                                eventLoop$kotlinx_coroutines_core.unconfinedQueue = arrayDeque;
                            }
                            arrayDeque.addLast(this);
                            return;
                        }
                        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
                        try {
                            BuildersKt.resume(this, continuation, true);
                            do {
                            } while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent());
                        } catch (Throwable th) {
                            try {
                                handleFatalException(th, null);
                            } finally {
                                eventLoop$kotlinx_coroutines_core.decrementUseCount();
                            }
                        }
                        return;
                    }
                }
                BuildersKt.resume(this, continuation, z);
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i2, 1073741824 + (536870911 & i2)));
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation continuation = this.delegate;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final Continuation getDelegate$kotlinx_coroutines_core() {
        return this.delegate;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final Throwable getExceptionalResult$kotlinx_coroutines_core(Object obj) {
        Throwable exceptionalResult$kotlinx_coroutines_core = super.getExceptionalResult$kotlinx_coroutines_core(obj);
        if (exceptionalResult$kotlinx_coroutines_core != null) {
            return exceptionalResult$kotlinx_coroutines_core;
        }
        return null;
    }

    public final Object getResult() throws Throwable {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i;
        boolean zIsReusable = isReusable();
        do {
            atomicIntegerFieldUpdater = _decisionAndIndex$FU;
            i = atomicIntegerFieldUpdater.get(this);
            int i2 = i >> 29;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new IllegalStateException("Already suspended");
                }
                if (zIsReusable) {
                    releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                }
                Object obj = _state$FU.get(this);
                if (obj instanceof CompletedExceptionally) {
                    throw ((CompletedExceptionally) obj).cause;
                }
                int i3 = this.resumeMode;
                if (i3 == 1 || i3 == 2) {
                    Job job = (Job) this.context.get(Job.Key.$$INSTANCE);
                    if (job != null && !job.isActive()) {
                        CancellationException cancellationException = ((JobSupport) job).getCancellationException();
                        cancelCompletedResult$kotlinx_coroutines_core(obj, cancellationException);
                        throw cancellationException;
                    }
                }
                return getSuccessfulResult$kotlinx_coroutines_core(obj);
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, 536870912 + (536870911 & i)));
        if (((DisposableHandle) _parentHandle$FU.get(this)) == null) {
            installParentHandle();
        }
        if (zIsReusable) {
            releaseClaimedReusableContinuation$kotlinx_coroutines_core();
        }
        return CoroutineSingletons.COROUTINE_SUSPENDED;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final Object getSuccessfulResult$kotlinx_coroutines_core(Object obj) {
        return obj instanceof CompletedContinuation ? ((CompletedContinuation) obj).result : obj;
    }

    public final void initCancellability() {
        DisposableHandle disposableHandleInstallParentHandle = installParentHandle();
        if (disposableHandleInstallParentHandle == null || (_state$FU.get(this) instanceof Active)) {
            return;
        }
        disposableHandleInstallParentHandle.dispose();
        _parentHandle$FU.set(this, NonDisposableHandle.INSTANCE);
    }

    public final DisposableHandle installParentHandle() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Job job = (Job) this.context.get(Job.Key.$$INSTANCE);
        if (job == null) {
            return null;
        }
        DisposableHandle disposableHandleInvokeOnCompletion$default = BuildersKt.invokeOnCompletion$default(job, true, new ChildContinuation(this), 2);
        do {
            atomicReferenceFieldUpdater = _parentHandle$FU;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, disposableHandleInvokeOnCompletion$default)) {
                break;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        return disposableHandleInvokeOnCompletion$default;
    }

    public final boolean isReusable() {
        if (this.resumeMode == 2) {
            Continuation continuation = this.delegate;
            Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            if (DispatchedContinuation._reusableCancellableContinuation$FU.get((DispatchedContinuation) continuation) != null) {
                return true;
            }
        }
        return false;
    }

    public final void releaseClaimedReusableContinuation$kotlinx_coroutines_core() {
        Continuation continuation = this.delegate;
        Throwable th = null;
        DispatchedContinuation dispatchedContinuation = continuation instanceof DispatchedContinuation ? (DispatchedContinuation) continuation : null;
        if (dispatchedContinuation != null) {
            loop0: while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = DispatchedContinuation._reusableCancellableContinuation$FU;
                Object obj = atomicReferenceFieldUpdater.get(dispatchedContinuation);
                Symbol symbol = AtomicKt.REUSABLE_CLAIMED;
                if (obj != symbol) {
                    if (!(obj instanceof Throwable)) {
                        throw new IllegalStateException(("Inconsistent state " + obj).toString());
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(dispatchedContinuation, obj, null)) {
                        if (atomicReferenceFieldUpdater.get(dispatchedContinuation) != obj) {
                            throw new IllegalArgumentException("Failed requirement.");
                        }
                    }
                    th = (Throwable) obj;
                    break;
                }
                do {
                    if (atomicReferenceFieldUpdater.compareAndSet(dispatchedContinuation, symbol, this)) {
                        break loop0;
                    }
                } while (atomicReferenceFieldUpdater.get(dispatchedContinuation) == symbol);
            }
            if (th == null) {
                return;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = _parentHandle$FU;
            DisposableHandle disposableHandle = (DisposableHandle) atomicReferenceFieldUpdater2.get(this);
            if (disposableHandle != null) {
                disposableHandle.dispose();
                atomicReferenceFieldUpdater2.set(this, NonDisposableHandle.INSTANCE);
            }
            cancel(th);
        }
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Throwable thM120exceptionOrNullimpl = Result.m120exceptionOrNullimpl(obj);
        if (thM120exceptionOrNullimpl != null) {
            obj = new CompletedExceptionally(false, thM120exceptionOrNullimpl);
        }
        int i = this.resumeMode;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof Active)) {
                if (obj2 instanceof CancelledContinuation) {
                    CancelledContinuation cancelledContinuation = (CancelledContinuation) obj2;
                    cancelledContinuation.getClass();
                    if (CancelledContinuation._resumed$FU.compareAndSet(cancelledContinuation, 0, 1)) {
                        return;
                    }
                }
                throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
            }
            boolean z = obj instanceof CompletedExceptionally;
            do {
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, obj)) {
                    if (!isReusable()) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = _parentHandle$FU;
                        DisposableHandle disposableHandle = (DisposableHandle) atomicReferenceFieldUpdater2.get(this);
                        if (disposableHandle != null) {
                            disposableHandle.dispose();
                            atomicReferenceFieldUpdater2.set(this, NonDisposableHandle.INSTANCE);
                        }
                    }
                    dispatchResume(i);
                    return;
                }
            } while (atomicReferenceFieldUpdater.get(this) == obj2);
        }
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final Object takeState$kotlinx_coroutines_core() {
        return _state$FU.get(this);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("CancellableContinuation(");
        sb.append(BuildersKt.toDebugString(this.delegate));
        sb.append("){");
        Object obj = _state$FU.get(this);
        if (obj instanceof Active) {
            str = "Active";
        } else {
            str = obj instanceof CancelledContinuation ? "Cancelled" : "Completed";
        }
        sb.append(str);
        sb.append("}@");
        sb.append(BuildersKt.getHexAddress(this));
        return sb.toString();
    }
}
