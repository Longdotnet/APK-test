package kotlinx.coroutines;

import androidx.work.Logger$LogcatLogger;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.scheduling.Task;
import kotlinx.coroutines.scheduling.TasksKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DispatchedTask extends Task {
    public int resumeMode;

    public DispatchedTask(int i) {
        super(0L, TasksKt.NonBlockingContext);
        this.resumeMode = i;
    }

    public abstract void cancelCompletedResult$kotlinx_coroutines_core(Object obj, CancellationException cancellationException);

    public abstract Continuation getDelegate$kotlinx_coroutines_core();

    public Throwable getExceptionalResult$kotlinx_coroutines_core(Object obj) {
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        if (completedExceptionally != null) {
            return completedExceptionally.cause;
        }
        return null;
    }

    public Object getSuccessfulResult$kotlinx_coroutines_core(Object obj) {
        return obj;
    }

    public final void handleFatalException(Throwable th, Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            ExceptionsKt.addSuppressed(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        Intrinsics.checkNotNull(th);
        BuildersKt.handleCoroutineException(getDelegate$kotlinx_coroutines_core().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    /* JADX WARN: Code duplicated, block: B:18:0x004a  */
    @Override // java.lang.Runnable
    public final void run() {
        Job job;
        Object objCreateFailure = Unit.INSTANCE;
        Logger$LogcatLogger logger$LogcatLogger = this.taskContext;
        try {
            Continuation delegate$kotlinx_coroutines_core = getDelegate$kotlinx_coroutines_core();
            Intrinsics.checkNotNull(delegate$kotlinx_coroutines_core, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) delegate$kotlinx_coroutines_core;
            ContinuationImpl continuationImpl = dispatchedContinuation.continuation;
            Object obj = dispatchedContinuation.countOrElement;
            CoroutineContext coroutineContext = continuationImpl._context;
            Intrinsics.checkNotNull(coroutineContext);
            Object objUpdateThreadContext = AtomicKt.updateThreadContext(coroutineContext, obj);
            if (objUpdateThreadContext != AtomicKt.NO_THREAD_ELEMENTS) {
                BuildersKt.updateUndispatchedCompletion(continuationImpl, coroutineContext);
            }
            try {
                CoroutineContext coroutineContext2 = continuationImpl._context;
                Intrinsics.checkNotNull(coroutineContext2);
                Object objTakeState$kotlinx_coroutines_core = takeState$kotlinx_coroutines_core();
                Throwable exceptionalResult$kotlinx_coroutines_core = getExceptionalResult$kotlinx_coroutines_core(objTakeState$kotlinx_coroutines_core);
                if (exceptionalResult$kotlinx_coroutines_core == null) {
                    int i = this.resumeMode;
                    boolean z = true;
                    if (i != 1 && i != 2) {
                        z = false;
                    }
                    if (z) {
                        job = (Job) coroutineContext2.get(Job.Key.$$INSTANCE);
                    } else {
                        job = null;
                    }
                } else {
                    job = null;
                }
                if (job != null && !job.isActive()) {
                    CancellationException cancellationException = ((JobSupport) job).getCancellationException();
                    cancelCompletedResult$kotlinx_coroutines_core(objTakeState$kotlinx_coroutines_core, cancellationException);
                    continuationImpl.resumeWith(StringsKt__IndentKt.createFailure(cancellationException));
                } else if (exceptionalResult$kotlinx_coroutines_core != null) {
                    continuationImpl.resumeWith(StringsKt__IndentKt.createFailure(exceptionalResult$kotlinx_coroutines_core));
                } else {
                    continuationImpl.resumeWith(getSuccessfulResult$kotlinx_coroutines_core(objTakeState$kotlinx_coroutines_core));
                }
                AtomicKt.restoreThreadContext(coroutineContext, objUpdateThreadContext);
                try {
                    logger$LogcatLogger.getClass();
                } catch (Throwable th) {
                    objCreateFailure = StringsKt__IndentKt.createFailure(th);
                }
                handleFatalException(null, Result.m120exceptionOrNullimpl(objCreateFailure));
            } catch (Throwable th2) {
                AtomicKt.restoreThreadContext(coroutineContext, objUpdateThreadContext);
                throw th2;
            }
        } catch (Throwable th3) {
            try {
                logger$LogcatLogger.getClass();
            } catch (Throwable th4) {
                objCreateFailure = StringsKt__IndentKt.createFailure(th4);
            }
            handleFatalException(th3, Result.m120exceptionOrNullimpl(objCreateFailure));
        }
    }

    public abstract Object takeState$kotlinx_coroutines_core();
}
