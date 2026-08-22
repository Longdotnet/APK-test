package androidx.core.os;

import android.os.OutcomeReceiver;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: loaded from: classes.dex */
public final class ContinuationOutcomeReceiver extends AtomicBoolean implements OutcomeReceiver {
    public final CancellableContinuationImpl continuation;

    public ContinuationOutcomeReceiver(CancellableContinuationImpl cancellableContinuationImpl) {
        super(false);
        this.continuation = cancellableContinuationImpl;
    }

    public final void onError(Throwable th) {
        if (compareAndSet(false, true)) {
            this.continuation.resumeWith(StringsKt__IndentKt.createFailure(th));
        }
    }

    public final void onResult(Object obj) {
        if (compareAndSet(false, true)) {
            this.continuation.resumeWith(obj);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public final String toString() {
        return "ContinuationOutcomeReceiver(outcomeReceived = " + get() + ')';
    }
}
