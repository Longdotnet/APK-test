package kotlinx.coroutines;

import androidx.startup.StartupException;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes3.dex */
public class DeferredCoroutine extends JobSupport implements Continuation, CoroutineScope {
    public final CoroutineContext context;

    public DeferredCoroutine(CoroutineContext coroutineContext, boolean z) {
        super(z);
        initParentJob((Job) coroutineContext.get(Job.Key.$$INSTANCE));
        this.context = coroutineContext.plus(this);
    }

    @Override // kotlinx.coroutines.JobSupport
    public final String cancellationExceptionMessage() {
        return getClass().getSimpleName().concat(" was cancelled");
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void handleOnCompletionException$kotlinx_coroutines_core(StartupException startupException) {
        BuildersKt.handleCoroutineException(this.context, startupException);
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void onCompletionInternal(Object obj) {
        if (obj instanceof CompletedExceptionally) {
            CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
            Throwable th = completedExceptionally.cause;
            completedExceptionally.getClass();
            CompletedExceptionally._handled$FU.get(completedExceptionally);
        }
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Object objTryMakeCompleting;
        Throwable thM120exceptionOrNullimpl = Result.m120exceptionOrNullimpl(obj);
        if (thM120exceptionOrNullimpl != null) {
            obj = new CompletedExceptionally(false, thM120exceptionOrNullimpl);
        }
        do {
            objTryMakeCompleting = tryMakeCompleting(getState$kotlinx_coroutines_core(), obj);
            if (objTryMakeCompleting == BuildersKt.COMPLETING_ALREADY) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
                throw new IllegalStateException(str, completedExceptionally != null ? completedExceptionally.cause : null);
            }
        } while (objTryMakeCompleting == BuildersKt.COMPLETING_RETRY);
    }
}
