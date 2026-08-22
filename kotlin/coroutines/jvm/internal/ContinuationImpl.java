package kotlin.coroutines.jvm.internal;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.NonDisposableHandle;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.DispatchedContinuation;
import okhttp3.internal.platform.android.CloseGuard;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ContinuationImpl implements Continuation, CoroutineStackFrame, Serializable {
    public final CoroutineContext _context;
    public final Continuation completion;
    public transient Continuation intercepted;

    public ContinuationImpl(Continuation continuation) {
        CoroutineContext context = continuation != null ? continuation.getContext() : null;
        this.completion = continuation;
        this._context = context;
    }

    public Continuation create(Continuation continuation) {
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation continuation = this.completion;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        CoroutineContext coroutineContext = this._context;
        Intrinsics.checkNotNull(coroutineContext);
        return coroutineContext;
    }

    public abstract Object invokeSuspend(Object obj);

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Continuation continuation = this;
        while (true) {
            ContinuationImpl continuationImpl = (ContinuationImpl) continuation;
            Continuation continuation2 = continuationImpl.completion;
            Intrinsics.checkNotNull(continuation2);
            try {
                obj = continuationImpl.invokeSuspend(obj);
                if (obj == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return;
                }
            } catch (Throwable th) {
                obj = StringsKt__IndentKt.createFailure(th);
            }
            Continuation continuation3 = continuationImpl.intercepted;
            if (continuation3 != null && continuation3 != continuationImpl) {
                CoroutineContext coroutineContext = continuationImpl._context;
                Intrinsics.checkNotNull(coroutineContext);
                CoroutineContext.Element element = coroutineContext.get(ContinuationInterceptor.Key.$$INSTANCE);
                Intrinsics.checkNotNull(element);
                DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation3;
                do {
                    atomicReferenceFieldUpdater = DispatchedContinuation._reusableCancellableContinuation$FU;
                } while (atomicReferenceFieldUpdater.get(dispatchedContinuation) == AtomicKt.REUSABLE_CLAIMED);
                Object obj2 = atomicReferenceFieldUpdater.get(dispatchedContinuation);
                CancellableContinuationImpl cancellableContinuationImpl = obj2 instanceof CancellableContinuationImpl ? (CancellableContinuationImpl) obj2 : null;
                if (cancellableContinuationImpl != null) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = CancellableContinuationImpl._parentHandle$FU;
                    DisposableHandle disposableHandle = (DisposableHandle) atomicReferenceFieldUpdater2.get(cancellableContinuationImpl);
                    if (disposableHandle != null) {
                        disposableHandle.dispose();
                        atomicReferenceFieldUpdater2.set(cancellableContinuationImpl, NonDisposableHandle.INSTANCE);
                    }
                }
            }
            continuationImpl.intercepted = CompletedContinuation.INSTANCE;
            if (!(continuation2 instanceof ContinuationImpl)) {
                continuation2.resumeWith(obj);
                return;
            }
            continuation = continuation2;
        }
    }

    public String toString() {
        int iIntValue;
        String strC;
        StringBuilder sb = new StringBuilder("Continuation at ");
        DebugMetadata debugMetadata = (DebugMetadata) getClass().getAnnotation(DebugMetadata.class);
        Object name = null;
        str = null;
        str = null;
        str = null;
        String str = null;
        if (debugMetadata != null) {
            int iV = debugMetadata.v();
            if (iV > 1) {
                throw new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + iV + ". Please update the Kotlin standard library.").toString());
            }
            try {
                Field declaredField = getClass().getDeclaredField("label");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(this);
                Integer num = obj instanceof Integer ? (Integer) obj : null;
                iIntValue = (num != null ? num.intValue() : 0) - 1;
            } catch (Exception unused) {
                iIntValue = -1;
            }
            int i = iIntValue >= 0 ? debugMetadata.l()[iIntValue] : -1;
            CloseGuard closeGuard = ModuleNameRetriever.cache;
            CloseGuard closeGuard2 = ModuleNameRetriever.notOnJava9;
            if (closeGuard == null) {
                try {
                    CloseGuard closeGuard3 = new CloseGuard(Class.class.getDeclaredMethod("getModule", null), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));
                    ModuleNameRetriever.cache = closeGuard3;
                    closeGuard = closeGuard3;
                } catch (Exception unused2) {
                    ModuleNameRetriever.cache = closeGuard2;
                    closeGuard = closeGuard2;
                }
            }
            if (closeGuard != closeGuard2) {
                Method method = closeGuard.getMethod;
                Object objInvoke = method != null ? method.invoke(getClass(), null) : null;
                if (objInvoke != null) {
                    Method method2 = closeGuard.openMethod;
                    Object objInvoke2 = method2 != null ? method2.invoke(objInvoke, null) : null;
                    if (objInvoke2 != null) {
                        Method method3 = closeGuard.warnIfOpenMethod;
                        Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, null) : null;
                        if (objInvoke3 instanceof String) {
                            str = (String) objInvoke3;
                        }
                    }
                }
            }
            if (str == null) {
                strC = debugMetadata.c();
            } else {
                strC = str + '/' + debugMetadata.c();
            }
            name = new StackTraceElement(strC, debugMetadata.m(), debugMetadata.f(), i);
        }
        if (name == null) {
            name = getClass().getName();
        }
        sb.append(name);
        return sb.toString();
    }
}
