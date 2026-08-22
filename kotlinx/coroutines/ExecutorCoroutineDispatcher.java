package kotlinx.coroutines;

import java.io.Closeable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ExecutorCoroutineDispatcher extends CoroutineDispatcher implements Closeable {
    static {
        CoroutineDispatcher.Key baseKey = CoroutineDispatcher.Key;
        Intrinsics.checkNotNullParameter(baseKey, "baseKey");
    }
}
