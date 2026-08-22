package kotlinx.coroutines.scheduling;

import androidx.loader.app.gv.DYYbQc;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.LimitedDispatcher;
import kotlinx.coroutines.internal.SystemPropsKt__SystemPropsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultIoScheduler extends ExecutorCoroutineDispatcher implements Executor {
    public static final DefaultIoScheduler INSTANCE = new DefaultIoScheduler();

    /* JADX INFO: renamed from: default, reason: not valid java name */
    public static final CoroutineDispatcher f4default;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        f4default.dispatch(coroutineContext, runnable);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        dispatch(EmptyCoroutineContext.INSTANCE, runnable);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        return "Dispatchers.IO";
    }

    static {
        CoroutineDispatcher limitedDispatcher;
        UnlimitedIoScheduler unlimitedIoScheduler = UnlimitedIoScheduler.INSTANCE;
        int i = SystemPropsKt__SystemPropsKt.AVAILABLE_PROCESSORS;
        if (64 >= i) {
            i = 64;
        }
        int iSystemProp$default = AtomicKt.systemProp$default(DYYbQc.VMrtGL, i, 0, 0, 12);
        unlimitedIoScheduler.getClass();
        if (iSystemProp$default < 1) {
            throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iSystemProp$default, "Expected positive parallelism level, but got ").toString());
        }
        if (iSystemProp$default < TasksKt.MAX_POOL_SIZE) {
            if (iSystemProp$default < 1) {
                throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iSystemProp$default, "Expected positive parallelism level, but got ").toString());
            }
            limitedDispatcher = new LimitedDispatcher(unlimitedIoScheduler, iSystemProp$default);
        }
        limitedDispatcher = unlimitedIoScheduler;
        f4default = limitedDispatcher;
    }
}
