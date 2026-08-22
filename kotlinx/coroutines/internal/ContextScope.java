package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
public final class ContextScope implements CoroutineScope {
    public final CoroutineContext coroutineContext;

    public ContextScope(CoroutineContext coroutineContext) {
        this.coroutineContext = coroutineContext;
    }

    public final String toString() {
        return "CoroutineScope(coroutineContext=" + this.coroutineContext + ')';
    }
}
