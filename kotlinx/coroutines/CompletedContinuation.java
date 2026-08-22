package kotlinx.coroutines;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class CompletedContinuation {
    public final Throwable cancelCause;
    public final Object idempotentResume;
    public final Function1 onCancellation;
    public final Object result;

    public CompletedContinuation(Object obj, Function1 function1, Object obj2, Throwable th) {
        this.result = obj;
        this.onCancellation = function1;
        this.idempotentResume = obj2;
        this.cancelCause = th;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompletedContinuation)) {
            return false;
        }
        CompletedContinuation completedContinuation = (CompletedContinuation) obj;
        return Intrinsics.areEqual(this.result, completedContinuation.result) && Intrinsics.areEqual(null, null) && Intrinsics.areEqual(this.onCancellation, completedContinuation.onCancellation) && Intrinsics.areEqual(this.idempotentResume, completedContinuation.idempotentResume) && Intrinsics.areEqual(this.cancelCause, completedContinuation.cancelCause);
    }

    public final int hashCode() {
        Object obj = this.result;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 961;
        Function1 function1 = this.onCancellation;
        int iHashCode2 = (iHashCode + (function1 == null ? 0 : function1.hashCode())) * 31;
        Object obj2 = this.idempotentResume;
        int iHashCode3 = (iHashCode2 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.cancelCause;
        return iHashCode3 + (th != null ? th.hashCode() : 0);
    }

    public final String toString() {
        return "CompletedContinuation(result=" + this.result + ", cancelHandler=null, onCancellation=" + this.onCancellation + ", idempotentResume=" + this.idempotentResume + ", cancelCause=" + this.cancelCause + ')';
    }
}
