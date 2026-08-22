package androidx.work;

import com.facebook.AccessTokenCache;
import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class Configuration {
    public final InputMergerFactory$1 mInputMergerFactory;
    public final int mLoggingLevel;
    public final int mMaxJobSchedulerId;
    public final int mMaxSchedulerLimit;
    public final AccessTokenCache mRunnableScheduler;
    public final WorkerFactory.AnonymousClass1 mWorkerFactory;
    public final ExecutorService mExecutor = Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), new AnonymousClass1(false));
    public final ExecutorService mTaskExecutor = Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), new AnonymousClass1(true));

    /* JADX INFO: renamed from: androidx.work.Configuration$1, reason: invalid class name */
    public final class AnonymousClass1 implements ThreadFactory {
        public final /* synthetic */ int $r8$classId;
        public final Serializable mThreadCount;
        public final /* synthetic */ boolean val$isTaskExecutor;

        public AnonymousClass1(String str, boolean z) {
            this.$r8$classId = 1;
            this.mThreadCount = str;
            this.val$isTaskExecutor = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            switch (this.$r8$classId) {
                case 0:
                    return new Thread(runnable, (this.val$isTaskExecutor ? "WM.task-" : "androidx.work-") + ((AtomicInteger) this.mThreadCount).incrementAndGet());
                default:
                    Thread thread = new Thread(runnable, (String) this.mThreadCount);
                    thread.setDaemon(this.val$isTaskExecutor);
                    return thread;
            }
        }

        public AnonymousClass1(boolean z) {
            this.$r8$classId = 0;
            this.val$isTaskExecutor = z;
            this.mThreadCount = new AtomicInteger(0);
        }
    }

    public Configuration(InputMergerFactory$1 inputMergerFactory$1) {
        String str = WorkerFactory.TAG;
        this.mWorkerFactory = new WorkerFactory.AnonymousClass1();
        this.mInputMergerFactory = new InputMergerFactory$1(0);
        this.mRunnableScheduler = new AccessTokenCache(11);
        this.mLoggingLevel = 4;
        this.mMaxJobSchedulerId = Integer.MAX_VALUE;
        this.mMaxSchedulerLimit = 20;
    }
}
