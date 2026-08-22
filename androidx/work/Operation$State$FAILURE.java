package androidx.work;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
public final class Operation$State$FAILURE extends RangesKt {
    public final Throwable mThrowable;

    public Operation$State$FAILURE(Throwable th) {
        this.mThrowable = th;
    }

    public final String toString() {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("FAILURE (", this.mThrowable.getMessage(), ")");
    }
}
