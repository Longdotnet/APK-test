package androidx.work.impl.utils;

import androidx.loader.app.gv.DYYbQc;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.background.systemalarm.DelayMetCommandHandler;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class WorkTimer {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("WorkTimer");
    public final ScheduledExecutorService mExecutorService;
    public final HashMap mListeners;
    public final Object mLock;
    public final HashMap mTimerMap;

    /* JADX INFO: renamed from: androidx.work.impl.utils.WorkTimer$1 */
    public final class AnonymousClass1 implements ThreadFactory {
        public int mThreadsCreated;

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread threadNewThread = Executors.defaultThreadFactory().newThread(runnable);
            threadNewThread.setName("WorkManager-WorkTimer-thread-" + this.mThreadsCreated);
            this.mThreadsCreated = this.mThreadsCreated + 1;
            return threadNewThread;
        }
    }

    public interface TimeLimitExceededListener {
    }

    /* JADX INFO: loaded from: classes2.dex */
    public final class WorkTimerRunnable implements Runnable {
        public final String mWorkSpecId;
        public final WorkTimer mWorkTimer;

        public WorkTimerRunnable(WorkTimer workTimer, String str) {
            this.mWorkTimer = workTimer;
            this.mWorkSpecId = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (this.mWorkTimer.mLock) {
                try {
                    if (((WorkTimerRunnable) this.mWorkTimer.mTimerMap.remove(this.mWorkSpecId)) != null) {
                        TimeLimitExceededListener timeLimitExceededListener = (TimeLimitExceededListener) this.mWorkTimer.mListeners.remove(this.mWorkSpecId);
                        if (timeLimitExceededListener != null) {
                            String str = this.mWorkSpecId;
                            Logger$LogcatLogger.get().debug(DelayMetCommandHandler.TAG, "Exceeded time limits on execution for " + str, new Throwable[0]);
                            ((DelayMetCommandHandler) timeLimitExceededListener).stopWork();
                        }
                    } else {
                        Logger$LogcatLogger.get().debug("WrkTimerRunnable", "Timer with " + this.mWorkSpecId + DYYbQc.Zvwjr, new Throwable[0]);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public WorkTimer() {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        anonymousClass1.mThreadsCreated = 0;
        this.mTimerMap = new HashMap();
        this.mListeners = new HashMap();
        this.mLock = new Object();
        this.mExecutorService = Executors.newSingleThreadScheduledExecutor(anonymousClass1);
    }

    public final void startTimer(String str, DelayMetCommandHandler delayMetCommandHandler) {
        synchronized (this.mLock) {
            Logger$LogcatLogger.get().debug(TAG, "Starting timer for " + str, new Throwable[0]);
            stopTimer(str);
            WorkTimerRunnable workTimerRunnable = new WorkTimerRunnable(this, str);
            this.mTimerMap.put(str, workTimerRunnable);
            this.mListeners.put(str, delayMetCommandHandler);
            this.mExecutorService.schedule(workTimerRunnable, 600000L, TimeUnit.MILLISECONDS);
        }
    }

    public final void stopTimer(String str) {
        synchronized (this.mLock) {
            try {
                if (((WorkTimerRunnable) this.mTimerMap.remove(str)) != null) {
                    Logger$LogcatLogger.get().debug(TAG, "Stopping timer for " + str, new Throwable[0]);
                    this.mListeners.remove(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
