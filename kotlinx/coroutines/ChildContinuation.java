package kotlinx.coroutines;

import androidx.emoji2.text.flatbuffer.bs.bUqMCsuPSX;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: loaded from: classes3.dex */
public final class ChildContinuation extends JobCancellingNode {
    public final CancellableContinuationImpl child;

    public ChildContinuation(CancellableContinuationImpl cancellableContinuationImpl) {
        this.child = cancellableContinuationImpl;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.JobNode
    public final void invoke(Throwable th) {
        JobSupport job = getJob();
        CancellableContinuationImpl cancellableContinuationImpl = this.child;
        cancellableContinuationImpl.getClass();
        CancellationException cancellationException = job.getCancellationException();
        if (cancellableContinuationImpl.isReusable()) {
            Continuation continuation = cancellableContinuationImpl.delegate;
            Intrinsics.checkNotNull(continuation, bUqMCsuPSX.wsBhEStgHM);
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            loop0: while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = DispatchedContinuation._reusableCancellableContinuation$FU;
                Object obj = atomicReferenceFieldUpdater.get(dispatchedContinuation);
                Symbol symbol = AtomicKt.REUSABLE_CLAIMED;
                if (Intrinsics.areEqual(obj, symbol)) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(dispatchedContinuation, symbol, cancellationException)) {
                        if (atomicReferenceFieldUpdater.get(dispatchedContinuation) != symbol) {
                        }
                    }
                    return;
                } else {
                    if (obj instanceof Throwable) {
                        return;
                    }
                    do {
                        if (atomicReferenceFieldUpdater.compareAndSet(dispatchedContinuation, obj, null)) {
                            break loop0;
                        }
                    } while (atomicReferenceFieldUpdater.get(dispatchedContinuation) == obj);
                }
            }
        }
        cancellableContinuationImpl.cancel(cancellationException);
        if (cancellableContinuationImpl.isReusable()) {
            return;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = CancellableContinuationImpl._parentHandle$FU;
        DisposableHandle disposableHandle = (DisposableHandle) atomicReferenceFieldUpdater2.get(cancellableContinuationImpl);
        if (disposableHandle == null) {
            return;
        }
        disposableHandle.dispose();
        atomicReferenceFieldUpdater2.set(cancellableContinuationImpl, NonDisposableHandle.INSTANCE);
    }
}
