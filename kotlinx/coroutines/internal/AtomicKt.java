package kotlinx.coroutines.internal;

import com.google.zxing.BarcodeFormat$EnumUnboxingLocalUtility;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CompletedWithCancellation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.EventLoopImplPlatform;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.ThreadContextElement;
import kotlinx.coroutines.ThreadLocalEventLoop;
import kotlinx.coroutines.android.AndroidExceptionPreHandler;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AtomicKt {
    public static final Symbol NO_DECISION = new Symbol("NO_DECISION", 0);
    public static final Symbol UNDEFINED = new Symbol("UNDEFINED", 0);
    public static final Symbol REUSABLE_CLAIMED = new Symbol("REUSABLE_CLAIMED", 0);
    public static final Symbol CONDITION_FALSE = new Symbol("CONDITION_FALSE", 0);
    public static final Symbol NO_THREAD_ELEMENTS = new Symbol("NO_THREAD_ELEMENTS", 0);

    public static final void handleUncaughtCoroutineException(CoroutineContext coroutineContext, Throwable th) {
        Throwable runtimeException;
        Iterator it = CoroutineExceptionHandlerImplKt.platformExceptionHandlers.iterator();
        while (it.hasNext()) {
            try {
                ((AndroidExceptionPreHandler) it.next()).handleException(coroutineContext, th);
            } catch (Throwable th2) {
                if (th == th2) {
                    runtimeException = th;
                } else {
                    runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                    ExceptionsKt.addSuppressed(runtimeException, th);
                }
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, runtimeException);
            }
        }
        try {
            ExceptionsKt.addSuppressed(th, new DiagnosticCoroutineContextException(coroutineContext));
        } catch (Throwable unused) {
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
    }

    public static final void restoreThreadContext(CoroutineContext coroutineContext, Object obj) {
        if (obj == NO_THREAD_ELEMENTS) {
            return;
        }
        if (!(obj instanceof ThreadState)) {
            Object objFold = coroutineContext.fold(null, ThreadContextKt$findOne$1.INSTANCE);
            Intrinsics.checkNotNull(objFold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            BarcodeFormat$EnumUnboxingLocalUtility.m(objFold);
            throw null;
        }
        ThreadState threadState = (ThreadState) obj;
        ThreadContextElement[] threadContextElementArr = threadState.elements;
        int length = threadContextElementArr.length - 1;
        if (length < 0) {
            return;
        }
        ThreadContextElement threadContextElement = threadContextElementArr[length];
        Intrinsics.checkNotNull(null);
        Object obj2 = threadState.values[length];
        throw null;
    }

    public static final void resumeCancellableWith(Continuation continuation, Function1 function1) {
        Object completedExceptionally;
        Unit unit = Unit.INSTANCE;
        if (!(continuation instanceof DispatchedContinuation)) {
            continuation.resumeWith(unit);
            return;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        Throwable thM120exceptionOrNullimpl = Result.m120exceptionOrNullimpl(unit);
        if (thM120exceptionOrNullimpl == null) {
            completedExceptionally = function1 != null ? new CompletedWithCancellation(unit, function1) : unit;
        } else {
            completedExceptionally = new CompletedExceptionally(false, thM120exceptionOrNullimpl);
        }
        ContinuationImpl continuationImpl = dispatchedContinuation.continuation;
        continuationImpl.getContext();
        CoroutineDispatcher coroutineDispatcher = dispatchedContinuation.dispatcher;
        boolean zIsDispatchNeeded = coroutineDispatcher.isDispatchNeeded();
        CoroutineContext coroutineContext = continuationImpl._context;
        if (zIsDispatchNeeded) {
            dispatchedContinuation._state = completedExceptionally;
            dispatchedContinuation.resumeMode = 1;
            Intrinsics.checkNotNull(coroutineContext);
            coroutineDispatcher.dispatch(coroutineContext, dispatchedContinuation);
            return;
        }
        EventLoopImplPlatform eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$kotlinx_coroutines_core.useCount >= 4294967296L) {
            dispatchedContinuation._state = completedExceptionally;
            dispatchedContinuation.resumeMode = 1;
            ArrayDeque arrayDeque = eventLoop$kotlinx_coroutines_core.unconfinedQueue;
            if (arrayDeque == null) {
                arrayDeque = new ArrayDeque();
                eventLoop$kotlinx_coroutines_core.unconfinedQueue = arrayDeque;
            }
            arrayDeque.addLast(dispatchedContinuation);
            return;
        }
        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
        try {
            Intrinsics.checkNotNull(coroutineContext);
            Job job = (Job) coroutineContext.get(Job.Key.$$INSTANCE);
            if (job == null || job.isActive()) {
                Object obj = dispatchedContinuation.countOrElement;
                Intrinsics.checkNotNull(coroutineContext);
                Object objUpdateThreadContext = updateThreadContext(coroutineContext, obj);
                if (objUpdateThreadContext != NO_THREAD_ELEMENTS) {
                    BuildersKt.updateUndispatchedCompletion(continuationImpl, coroutineContext);
                }
                try {
                    continuationImpl.resumeWith(unit);
                    restoreThreadContext(coroutineContext, objUpdateThreadContext);
                } catch (Throwable th) {
                    restoreThreadContext(coroutineContext, objUpdateThreadContext);
                    throw th;
                }
            } else {
                CancellationException cancellationException = ((JobSupport) job).getCancellationException();
                dispatchedContinuation.cancelCompletedResult$kotlinx_coroutines_core(completedExceptionally, cancellationException);
                dispatchedContinuation.resumeWith(StringsKt__IndentKt.createFailure(cancellationException));
            }
            while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent()) {
            }
        } catch (Throwable th2) {
            try {
                dispatchedContinuation.handleFatalException(th2, null);
            } finally {
                eventLoop$kotlinx_coroutines_core.decrementUseCount();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0054  */
    /* JADX WARN: Code duplicated, block: B:27:0x005f  */
    /* JADX WARN: Code duplicated, block: B:29:0x0063  */
    /* JADX WARN: Code duplicated, block: B:31:0x0067  */
    /* JADX WARN: Code duplicated, block: B:34:0x006f A[PHI: r18
  0x006f: PHI (r18v2 long) = (r18v1 long), (r18v4 long) binds: [B:28:0x0061, B:32:0x006c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:37:0x0079 A[LOOP:0: B:23:0x0052->B:37:0x0079, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:39:0x0081  */
    /* JADX WARN: Code duplicated, block: B:41:0x0087  */
    /* JADX WARN: Code duplicated, block: B:56:0x0020 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x0020 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x007f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x0020 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x0020 A[SYNTHETIC] */
    public static final long systemProp(String str, long j, long j2, long j3) {
        String property;
        int i;
        long j4;
        long j5;
        Long lValueOf;
        Long l;
        int iDigit;
        long j6;
        long j7;
        long j8;
        int i2 = SystemPropsKt__SystemPropsKt.AVAILABLE_PROCESSORS;
        try {
            property = System.getProperty(str);
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            return j;
        }
        ExceptionsKt.checkRadix(10);
        int length = property.length();
        if (length != 0) {
            int i3 = 0;
            char cCharAt = property.charAt(0);
            long j9 = -9223372036854775807L;
            if (Intrinsics.compare(cCharAt, 48) < 0) {
                if (length != 1) {
                    if (cCharAt != '-') {
                        if (cCharAt == '+') {
                            i = 0;
                            i3 = 1;
                            j4 = 0;
                            j5 = -256204778801521550L;
                            while (true) {
                                if (i3 >= length) {
                                    if (i != 0) {
                                        lValueOf = Long.valueOf(j4);
                                    } else {
                                        lValueOf = Long.valueOf(-j4);
                                    }
                                    l = lValueOf;
                                    break;
                                }
                                iDigit = Character.digit((int) property.charAt(i3), 10);
                                if (iDigit >= 0) {
                                    if (j4 >= j5) {
                                        j6 = j4 * ((long) 10);
                                        j7 = iDigit;
                                        if (j6 < j9 + j7) {
                                            j4 = j6 - j7;
                                            i3++;
                                        }
                                    } else if (j5 == -256204778801521550L) {
                                        j5 = j9 / ((long) 10);
                                        if (j4 >= j5) {
                                            j6 = j4 * ((long) 10);
                                            j7 = iDigit;
                                            if (j6 < j9 + j7) {
                                                j4 = j6 - j7;
                                                i3++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        j9 = Long.MIN_VALUE;
                        i3 = 1;
                        i = i3;
                        j4 = 0;
                        j5 = -256204778801521550L;
                        while (true) {
                            if (i3 >= length) {
                                if (i != 0) {
                                    lValueOf = Long.valueOf(j4);
                                } else {
                                    lValueOf = Long.valueOf(-j4);
                                }
                                l = lValueOf;
                                break;
                            }
                            iDigit = Character.digit((int) property.charAt(i3), 10);
                            if (iDigit >= 0) {
                                if (j4 >= j5) {
                                    j6 = j4 * ((long) 10);
                                    j7 = iDigit;
                                    if (j6 < j9 + j7) {
                                        j4 = j6 - j7;
                                        i3++;
                                    }
                                } else if (j5 == -256204778801521550L) {
                                    j5 = j9 / ((long) 10);
                                    if (j4 >= j5) {
                                        j6 = j4 * ((long) 10);
                                        j7 = iDigit;
                                        if (j6 < j9 + j7) {
                                            j4 = j6 - j7;
                                            i3++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                i = i3;
                j4 = 0;
                j5 = -256204778801521550L;
                while (true) {
                    if (i3 >= length) {
                        if (i != 0) {
                            lValueOf = Long.valueOf(j4);
                        } else {
                            lValueOf = Long.valueOf(-j4);
                        }
                        l = lValueOf;
                        break;
                    }
                    iDigit = Character.digit((int) property.charAt(i3), 10);
                    if (iDigit >= 0) {
                        if (j4 >= j5) {
                            j6 = j4 * ((long) 10);
                            j7 = iDigit;
                            if (j6 < j9 + j7) {
                                j4 = j6 - j7;
                                i3++;
                            }
                        } else if (j5 == -256204778801521550L) {
                            j5 = j9 / ((long) 10);
                            if (j4 >= j5) {
                                j6 = j4 * ((long) 10);
                                j7 = iDigit;
                                if (j6 < j9 + j7) {
                                    j4 = j6 - j7;
                                    i3++;
                                }
                            }
                        }
                    }
                }
            }
            l = null;
            break;
        } else {
            l = null;
            break;
        }
        if (l == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + property + '\'').toString());
        }
        long jLongValue = l.longValue();
        if (j2 <= jLongValue) {
            j8 = j3;
            if (jLongValue <= j8) {
                return jLongValue;
            }
        } else {
            j8 = j3;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j2 + ".." + j8 + ", but is '" + jLongValue + '\'').toString());
    }

    public static int systemProp$default(String str, int i, int i2, int i3, int i4) {
        if ((i4 & 4) != 0) {
            i2 = 1;
        }
        if ((i4 & 8) != 0) {
            i3 = Integer.MAX_VALUE;
        }
        return (int) systemProp(str, i, i2, i3);
    }

    public static final Object updateThreadContext(CoroutineContext coroutineContext, Object obj) {
        if (obj == null) {
            obj = coroutineContext.fold(0, ThreadContextKt$findOne$1.INSTANCE$1);
            Intrinsics.checkNotNull(obj);
        }
        if (obj == 0) {
            return NO_THREAD_ELEMENTS;
        }
        if (obj instanceof Integer) {
            return coroutineContext.fold(new ThreadState(coroutineContext, ((Number) obj).intValue()), ThreadContextKt$findOne$1.INSTANCE$2);
        }
        BarcodeFormat$EnumUnboxingLocalUtility.m(obj);
        throw null;
    }
}
