package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Result implements Serializable {

    public final class Failure implements Serializable {
        public final Throwable exception;

        public Failure(Throwable exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            this.exception = exception;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof Failure) {
                if (Intrinsics.areEqual(this.exception, ((Failure) obj).exception)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return this.exception.hashCode();
        }

        public final String toString() {
            return "Failure(" + this.exception + ')';
        }
    }

    /* JADX INFO: renamed from: exceptionOrNull-impl, reason: not valid java name */
    public static final Throwable m120exceptionOrNullimpl(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).exception;
        }
        return null;
    }
}
