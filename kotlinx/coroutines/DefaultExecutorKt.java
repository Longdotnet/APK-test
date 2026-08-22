package kotlinx.coroutines;

import kotlinx.coroutines.android.HandlerContext;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.internal.SystemPropsKt__SystemPropsKt;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DefaultExecutorKt {
    public static final /* synthetic */ int $r8$clinit = 0;

    static {
        String property;
        int i = SystemPropsKt__SystemPropsKt.AVAILABLE_PROCESSORS;
        try {
            property = System.getProperty("kotlinx.coroutines.main.delay");
        } catch (SecurityException unused) {
            property = null;
        }
        if (!(property != null ? Boolean.parseBoolean(property) : false)) {
            DefaultExecutor defaultExecutor = DefaultExecutor.INSTANCE;
            return;
        }
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        HandlerContext handlerContext = MainDispatcherLoader.dispatcher;
        HandlerContext handlerContext2 = handlerContext.immediate;
        if (handlerContext instanceof Delay) {
            return;
        }
        DefaultExecutor defaultExecutor2 = DefaultExecutor.INSTANCE;
    }
}
