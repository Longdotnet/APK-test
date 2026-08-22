package kotlinx.coroutines;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;
import androidx.startup.StartupException;
import com.facebook.login.vu.dLDI;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.android.AndroidExceptionPreHandler;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.MediaType;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BuildersKt {
    public static final Symbol CLOSED_EMPTY = new Symbol(dLDI.FXVHNVaAr, 0);
    public static final Symbol COMPLETING_ALREADY = new Symbol("COMPLETING_ALREADY", 0);
    public static final Symbol COMPLETING_WAITING_CHILDREN = new Symbol("COMPLETING_WAITING_CHILDREN", 0);
    public static final Symbol COMPLETING_RETRY = new Symbol("COMPLETING_RETRY", 0);
    public static final Symbol TOO_LATE_TO_CANCEL = new Symbol("TOO_LATE_TO_CANCEL", 0);
    public static final Symbol SEALED = new Symbol("SEALED", 0);
    public static final Empty EMPTY_NEW = new Empty(false);
    public static final Empty EMPTY_ACTIVE = new Empty(true);

    public static final ContextScope CoroutineScope(CoroutineDispatcher coroutineDispatcher) {
        CoroutineContext.Element element = coroutineDispatcher.get(Job.Key.$$INSTANCE);
        CoroutineContext coroutineContextPlus = coroutineDispatcher;
        if (element == null) {
            coroutineContextPlus = MediaType.Companion.plus(coroutineDispatcher, new JobImpl(null));
        }
        return new ContextScope(coroutineContextPlus);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static DeferredCoroutine async$default(ContextScope contextScope, Function2 function2) {
        CoroutineContext coroutineContextPlus;
        int arity;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        Boolean bool = Boolean.FALSE;
        CoroutineContextKt$foldCopies$1 coroutineContextKt$foldCopies$1 = CoroutineContextKt$foldCopies$1.INSTANCE$1;
        CoroutineContext coroutineContext = contextScope.coroutineContext;
        boolean zBooleanValue = ((Boolean) coroutineContext.fold(bool, coroutineContextKt$foldCopies$1)).booleanValue();
        boolean zBooleanValue2 = bool.booleanValue();
        if (zBooleanValue || zBooleanValue2) {
            CoroutineContext coroutineContext2 = (CoroutineContext) coroutineContext.fold(emptyCoroutineContext, new CoroutineContextKt$foldCopies$1(2, 2));
            Object objFold = emptyCoroutineContext;
            if (zBooleanValue2) {
                objFold = emptyCoroutineContext.fold(emptyCoroutineContext, CoroutineContextKt$foldCopies$1.INSTANCE);
            }
            coroutineContextPlus = coroutineContext2.plus((CoroutineContext) objFold);
        } else {
            coroutineContextPlus = coroutineContext.plus(emptyCoroutineContext);
        }
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        if (coroutineContextPlus != defaultScheduler && coroutineContextPlus.get(ContinuationInterceptor.Key.$$INSTANCE) == null) {
            coroutineContextPlus = coroutineContextPlus.plus(defaultScheduler);
        }
        DeferredCoroutine deferredCoroutine = new DeferredCoroutine(coroutineContextPlus, true);
        int iOrdinal = Fragment$$ExternalSyntheticOutline0.ordinal(1);
        Unit unit = Unit.INSTANCE;
        if (iOrdinal == 0) {
            try {
                AtomicKt.resumeCancellableWith(Protocol.Companion.intercepted(((ContinuationImpl) function2).create(deferredCoroutine)), null);
            } catch (Throwable th) {
                deferredCoroutine.resumeWith(StringsKt__IndentKt.createFailure(th));
                throw th;
            }
        } else if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                Protocol.Companion.intercepted(((ContinuationImpl) function2).create(deferredCoroutine)).resumeWith(unit);
            } else {
                if (iOrdinal != 3) {
                    throw new StartupException();
                }
                try {
                    CoroutineContext coroutineContext3 = deferredCoroutine.context;
                    Object objUpdateThreadContext = AtomicKt.updateThreadContext(coroutineContext3, null);
                    try {
                        if (function2 instanceof FunctionBase) {
                            arity = ((FunctionBase) function2).getArity();
                        } else if (function2 instanceof Function0) {
                            arity = 0;
                        } else {
                            arity = function2 instanceof Function1 ? 1 : 2;
                        }
                        if (arity != 2) {
                            TypeIntrinsics.throwCce(function2, "kotlin.jvm.functions.Function2");
                            throw null;
                        }
                        Object objInvoke = function2.invoke(deferredCoroutine, deferredCoroutine);
                        AtomicKt.restoreThreadContext(coroutineContext3, objUpdateThreadContext);
                        if (objInvoke != CoroutineSingletons.COROUTINE_SUSPENDED) {
                            deferredCoroutine.resumeWith(objInvoke);
                        }
                    } catch (Throwable th2) {
                        AtomicKt.restoreThreadContext(coroutineContext3, objUpdateThreadContext);
                        throw th2;
                    }
                } catch (Throwable th3) {
                    deferredCoroutine.resumeWith(StringsKt__IndentKt.createFailure(th3));
                }
            }
        }
        return deferredCoroutine;
    }

    public static final String getHexAddress(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final void handleCoroutineException(CoroutineContext coroutineContext, Throwable th) {
        try {
            AndroidExceptionPreHandler androidExceptionPreHandler = (AndroidExceptionPreHandler) coroutineContext.get(Job.Key.$$INSTANCE$1);
            if (androidExceptionPreHandler != null) {
                androidExceptionPreHandler.handleException(coroutineContext, th);
            } else {
                AtomicKt.handleUncaughtCoroutineException(coroutineContext, th);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                ExceptionsKt.addSuppressed(runtimeException, th);
                th = runtimeException;
            }
            AtomicKt.handleUncaughtCoroutineException(coroutineContext, th);
        }
    }

    public static /* synthetic */ DisposableHandle invokeOnCompletion$default(Job job, boolean z, JobNode jobNode, int i) {
        if ((i & 1) != 0) {
            z = false;
        }
        return ((JobSupport) job).invokeOnCompletion(z, (i & 2) != 0, jobNode);
    }

    public static final void resume(CancellableContinuationImpl cancellableContinuationImpl, Continuation continuation, boolean z) {
        Object obj = CancellableContinuationImpl._state$FU.get(cancellableContinuationImpl);
        Throwable exceptionalResult$kotlinx_coroutines_core = cancellableContinuationImpl.getExceptionalResult$kotlinx_coroutines_core(obj);
        Object objCreateFailure = exceptionalResult$kotlinx_coroutines_core != null ? StringsKt__IndentKt.createFailure(exceptionalResult$kotlinx_coroutines_core) : cancellableContinuationImpl.getSuccessfulResult$kotlinx_coroutines_core(obj);
        if (!z) {
            continuation.resumeWith(objCreateFailure);
            return;
        }
        Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        ContinuationImpl continuationImpl = dispatchedContinuation.continuation;
        CoroutineContext coroutineContext = continuationImpl._context;
        Intrinsics.checkNotNull(coroutineContext);
        Object objUpdateThreadContext = AtomicKt.updateThreadContext(coroutineContext, dispatchedContinuation.countOrElement);
        if (objUpdateThreadContext != AtomicKt.NO_THREAD_ELEMENTS) {
            updateUndispatchedCompletion(continuationImpl, coroutineContext);
        }
        try {
            continuationImpl.resumeWith(objCreateFailure);
        } finally {
            AtomicKt.restoreThreadContext(coroutineContext, objUpdateThreadContext);
        }
    }

    public static final String toDebugString(Continuation continuation) {
        Object objCreateFailure;
        if (continuation instanceof DispatchedContinuation) {
            return continuation.toString();
        }
        try {
            objCreateFailure = continuation + '@' + getHexAddress(continuation);
        } catch (Throwable th) {
            objCreateFailure = StringsKt__IndentKt.createFailure(th);
        }
        if (Result.m120exceptionOrNullimpl(objCreateFailure) != null) {
            objCreateFailure = continuation.getClass().getName() + '@' + getHexAddress(continuation);
        }
        return (String) objCreateFailure;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.coroutines.jvm.internal.ContinuationImpl] */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.coroutines.jvm.internal.CoroutineStackFrame] */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlin.coroutines.jvm.internal.CoroutineStackFrame] */
    public static final void updateUndispatchedCompletion(ContinuationImpl continuationImpl, CoroutineContext coroutineContext) {
        if ((continuationImpl instanceof CoroutineStackFrame) && coroutineContext.get(UndispatchedMarker.INSTANCE) != null) {
            do {
                continuationImpl = continuationImpl.getCallerFrame();
            } while (continuationImpl != 0);
        }
    }
}
