package kotlinx.coroutines.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CompletedWithCancellation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DispatchedTask;
import kotlinx.coroutines.EventLoopImplPlatform;
import kotlinx.coroutines.ThreadLocalEventLoop;

/* JADX INFO: loaded from: classes3.dex */
public final class DispatchedContinuation extends DispatchedTask implements CoroutineStackFrame, Continuation {
    public static final AtomicReferenceFieldUpdater _reusableCancellableContinuation$FU = AtomicReferenceFieldUpdater.newUpdater(DispatchedContinuation.class, Object.class, "_reusableCancellableContinuation");
    private volatile Object _reusableCancellableContinuation;
    public Object _state;
    public final ContinuationImpl continuation;
    public final Object countOrElement;
    public final CoroutineDispatcher dispatcher;

    public DispatchedContinuation(CoroutineDispatcher coroutineDispatcher, ContinuationImpl continuationImpl) {
        super(-1);
        this.dispatcher = coroutineDispatcher;
        this.continuation = continuationImpl;
        this._state = AtomicKt.UNDEFINED;
        CoroutineContext coroutineContext = continuationImpl._context;
        Intrinsics.checkNotNull(coroutineContext);
        Object objFold = coroutineContext.fold(0, ThreadContextKt$findOne$1.INSTANCE$1);
        Intrinsics.checkNotNull(objFold);
        this.countOrElement = objFold;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final void cancelCompletedResult$kotlinx_coroutines_core(Object obj, CancellationException cancellationException) {
        if (obj instanceof CompletedWithCancellation) {
            ((CompletedWithCancellation) obj).onCancellation.invoke(cancellationException);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        ContinuationImpl continuationImpl = this.continuation;
        if (continuationImpl instanceof CoroutineStackFrame) {
            return continuationImpl;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        CoroutineContext coroutineContext = this.continuation._context;
        Intrinsics.checkNotNull(coroutineContext);
        return coroutineContext;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final Continuation getDelegate$kotlinx_coroutines_core() {
        return this;
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        ContinuationImpl continuationImpl = this.continuation;
        CoroutineContext coroutineContext = continuationImpl._context;
        Intrinsics.checkNotNull(coroutineContext);
        Throwable thM120exceptionOrNullimpl = Result.m120exceptionOrNullimpl(obj);
        Object completedExceptionally = thM120exceptionOrNullimpl == null ? obj : new CompletedExceptionally(false, thM120exceptionOrNullimpl);
        CoroutineDispatcher coroutineDispatcher = this.dispatcher;
        if (coroutineDispatcher.isDispatchNeeded()) {
            this._state = completedExceptionally;
            this.resumeMode = 0;
            coroutineDispatcher.dispatch(coroutineContext, this);
            return;
        }
        EventLoopImplPlatform eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$kotlinx_coroutines_core.useCount >= 4294967296L) {
            this._state = completedExceptionally;
            this.resumeMode = 0;
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
            CoroutineContext coroutineContext2 = continuationImpl._context;
            Intrinsics.checkNotNull(coroutineContext2);
            Object objUpdateThreadContext = AtomicKt.updateThreadContext(coroutineContext2, this.countOrElement);
            try {
                continuationImpl.resumeWith(obj);
                AtomicKt.restoreThreadContext(coroutineContext2, objUpdateThreadContext);
                while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent()) {
                }
            } catch (Throwable th) {
                AtomicKt.restoreThreadContext(coroutineContext2, objUpdateThreadContext);
                throw th;
            }
        } catch (Throwable th2) {
            try {
                handleFatalException(th2, null);
            } finally {
                eventLoop$kotlinx_coroutines_core.decrementUseCount();
            }
        }
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final Object takeState$kotlinx_coroutines_core() {
        Object obj = this._state;
        this._state = AtomicKt.UNDEFINED;
        return obj;
    }

    public final String toString() {
        return "DispatchedContinuation[" + this.dispatcher + ", " + BuildersKt.toDebugString(this.continuation) + ']';
    }
}
