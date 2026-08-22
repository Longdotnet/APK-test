package kotlinx.coroutines.scheduling;

import androidx.work.Logger$LogcatLogger;
import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.SystemPropsKt__SystemPropsKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TasksKt {
    public static final Logger$LogcatLogger BlockingContext;
    public static final int CORE_POOL_SIZE;
    public static final String DEFAULT_SCHEDULER_NAME;
    public static final long IDLE_WORKER_KEEP_ALIVE_NS;
    public static final int MAX_POOL_SIZE;
    public static final Logger$LogcatLogger NonBlockingContext;
    public static final long WORK_STEALING_TIME_RESOLUTION_NS;
    public static final NanoTimeSource schedulerTimeSource;

    static {
        String property;
        int i = SystemPropsKt__SystemPropsKt.AVAILABLE_PROCESSORS;
        try {
            property = System.getProperty("kotlinx.coroutines.scheduler.default.name");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            property = "DefaultDispatcher";
        }
        DEFAULT_SCHEDULER_NAME = property;
        WORK_STEALING_TIME_RESOLUTION_NS = AtomicKt.systemProp("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 1L, Long.MAX_VALUE);
        int i2 = SystemPropsKt__SystemPropsKt.AVAILABLE_PROCESSORS;
        if (i2 < 2) {
            i2 = 2;
        }
        CORE_POOL_SIZE = AtomicKt.systemProp$default("kotlinx.coroutines.scheduler.core.pool.size", i2, 1, 0, 8);
        MAX_POOL_SIZE = AtomicKt.systemProp$default("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4);
        IDLE_WORKER_KEEP_ALIVE_NS = TimeUnit.SECONDS.toNanos(AtomicKt.systemProp("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 1L, Long.MAX_VALUE));
        schedulerTimeSource = NanoTimeSource.INSTANCE;
        NonBlockingContext = new Logger$LogcatLogger(0);
        BlockingContext = new Logger$LogcatLogger(1);
    }
}
