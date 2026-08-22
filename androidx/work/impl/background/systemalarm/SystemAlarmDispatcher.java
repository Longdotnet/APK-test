package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.appcompat.widget.AppCompatTextHelper;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.utils.SerialExecutor;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.WorkTimer;
import com.google.firebase.auth.zzaa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class SystemAlarmDispatcher implements ExecutionListener {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("SystemAlarmDispatcher");
    public final CommandHandler mCommandHandler;
    public SystemAlarmService mCompletedListener;
    public final Context mContext;
    public Intent mCurrentIntent;
    public final ArrayList mIntents;
    public final Handler mMainHandler;
    public final Processor mProcessor;
    public final zzaa mTaskExecutor;
    public final WorkManagerImpl mWorkManager;
    public final WorkTimer mWorkTimer;

    /* JADX INFO: renamed from: androidx.work.impl.background.systemalarm.SystemAlarmDispatcher$1, reason: invalid class name */
    public final class AnonymousClass1 implements Runnable {
        public final /* synthetic */ int $r8$classId;
        public final SystemAlarmDispatcher this$0;

        public /* synthetic */ AnonymousClass1(SystemAlarmDispatcher systemAlarmDispatcher, int i) {
            this.$r8$classId = i;
            this.this$0 = systemAlarmDispatcher;
        }

        private final void run$androidx$work$impl$background$systemalarm$SystemAlarmDispatcher$1() {
            SystemAlarmDispatcher systemAlarmDispatcher;
            AnonymousClass1 anonymousClass1;
            int i = 1;
            synchronized (this.this$0.mIntents) {
                SystemAlarmDispatcher systemAlarmDispatcher2 = this.this$0;
                systemAlarmDispatcher2.mCurrentIntent = (Intent) systemAlarmDispatcher2.mIntents.get(0);
            }
            Intent intent = this.this$0.mCurrentIntent;
            if (intent != null) {
                String action = intent.getAction();
                int intExtra = this.this$0.mCurrentIntent.getIntExtra("KEY_START_ID", 0);
                Logger$LogcatLogger logger$LogcatLogger = Logger$LogcatLogger.get();
                String str = SystemAlarmDispatcher.TAG;
                logger$LogcatLogger.debug(str, String.format("Processing command %s, %s", this.this$0.mCurrentIntent, Integer.valueOf(intExtra)), new Throwable[0]);
                PowerManager.WakeLock wakeLockNewWakeLock = WakeLocks.newWakeLock(this.this$0.mContext, action + " (" + intExtra + ")");
                try {
                    Logger$LogcatLogger.get().debug(str, "Acquiring operation wake lock (" + action + ") " + wakeLockNewWakeLock, new Throwable[0]);
                    wakeLockNewWakeLock.acquire();
                    SystemAlarmDispatcher systemAlarmDispatcher3 = this.this$0;
                    systemAlarmDispatcher3.mCommandHandler.onHandleIntent(systemAlarmDispatcher3.mCurrentIntent, intExtra, systemAlarmDispatcher3);
                    Logger$LogcatLogger.get().debug(str, "Releasing operation wake lock (" + action + ") " + wakeLockNewWakeLock, new Throwable[0]);
                    wakeLockNewWakeLock.release();
                    systemAlarmDispatcher = this.this$0;
                    anonymousClass1 = new AnonymousClass1(systemAlarmDispatcher, i);
                } catch (Throwable th) {
                    try {
                        Logger$LogcatLogger logger$LogcatLogger2 = Logger$LogcatLogger.get();
                        String str2 = SystemAlarmDispatcher.TAG;
                        logger$LogcatLogger2.error(str2, "Unexpected error in onHandleIntent", th);
                        Logger$LogcatLogger.get().debug(str2, "Releasing operation wake lock (" + action + ") " + wakeLockNewWakeLock, new Throwable[0]);
                        wakeLockNewWakeLock.release();
                        systemAlarmDispatcher = this.this$0;
                        anonymousClass1 = new AnonymousClass1(systemAlarmDispatcher, i);
                    } catch (Throwable th2) {
                        Logger$LogcatLogger.get().debug(SystemAlarmDispatcher.TAG, "Releasing operation wake lock (" + action + ") " + wakeLockNewWakeLock, new Throwable[0]);
                        wakeLockNewWakeLock.release();
                        SystemAlarmDispatcher systemAlarmDispatcher4 = this.this$0;
                        systemAlarmDispatcher4.postOnMainThread(new AnonymousClass1(systemAlarmDispatcher4, i));
                        throw th2;
                    }
                }
                systemAlarmDispatcher.postOnMainThread(anonymousClass1);
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            switch (this.$r8$classId) {
                case 0:
                    run$androidx$work$impl$background$systemalarm$SystemAlarmDispatcher$1();
                    return;
                default:
                    SystemAlarmDispatcher systemAlarmDispatcher = this.this$0;
                    systemAlarmDispatcher.getClass();
                    Logger$LogcatLogger logger$LogcatLogger = Logger$LogcatLogger.get();
                    String str = SystemAlarmDispatcher.TAG;
                    logger$LogcatLogger.debug(str, "Checking if commands are complete.", new Throwable[0]);
                    systemAlarmDispatcher.assertMainThread();
                    synchronized (systemAlarmDispatcher.mIntents) {
                        try {
                            if (systemAlarmDispatcher.mCurrentIntent != null) {
                                Logger$LogcatLogger.get().debug(str, String.format("Removing command %s", systemAlarmDispatcher.mCurrentIntent), new Throwable[0]);
                                if (!((Intent) systemAlarmDispatcher.mIntents.remove(0)).equals(systemAlarmDispatcher.mCurrentIntent)) {
                                    throw new IllegalStateException("Dequeue-d command is not the first.");
                                }
                                systemAlarmDispatcher.mCurrentIntent = null;
                            }
                            SerialExecutor serialExecutor = (SerialExecutor) systemAlarmDispatcher.mTaskExecutor.zza;
                            if (!systemAlarmDispatcher.mCommandHandler.hasPendingCommands() && systemAlarmDispatcher.mIntents.isEmpty() && !serialExecutor.hasPendingTasks()) {
                                Logger$LogcatLogger.get().debug(str, "No more commands & intents.", new Throwable[0]);
                                SystemAlarmService systemAlarmService = systemAlarmDispatcher.mCompletedListener;
                                if (systemAlarmService != null) {
                                    systemAlarmService.onAllCommandsCompleted();
                                }
                            } else if (!systemAlarmDispatcher.mIntents.isEmpty()) {
                                systemAlarmDispatcher.processCommand();
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return;
            }
        }
    }

    public SystemAlarmDispatcher(SystemAlarmService systemAlarmService) {
        Context applicationContext = systemAlarmService.getApplicationContext();
        this.mContext = applicationContext;
        this.mCommandHandler = new CommandHandler(applicationContext);
        this.mWorkTimer = new WorkTimer();
        WorkManagerImpl workManagerImpl = WorkManagerImpl.getInstance(systemAlarmService);
        this.mWorkManager = workManagerImpl;
        Processor processor = workManagerImpl.mProcessor;
        this.mProcessor = processor;
        this.mTaskExecutor = workManagerImpl.mWorkTaskExecutor;
        processor.addExecutionListener(this);
        this.mIntents = new ArrayList();
        this.mCurrentIntent = null;
        this.mMainHandler = new Handler(Looper.getMainLooper());
    }

    public final void add(int i, Intent intent) {
        Logger$LogcatLogger logger$LogcatLogger = Logger$LogcatLogger.get();
        String str = TAG;
        logger$LogcatLogger.debug(str, String.format("Adding command %s (%s)", intent, Integer.valueOf(i)), new Throwable[0]);
        assertMainThread();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            Logger$LogcatLogger.get().warning(str, "Unknown command. Ignoring", new Throwable[0]);
            return;
        }
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action) && hasIntentWithAction()) {
            return;
        }
        intent.putExtra("KEY_START_ID", i);
        synchronized (this.mIntents) {
            try {
                boolean zIsEmpty = this.mIntents.isEmpty();
                this.mIntents.add(intent);
                if (zIsEmpty) {
                    processCommand();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void assertMainThread() {
        if (this.mMainHandler.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    public final boolean hasIntentWithAction() {
        assertMainThread();
        synchronized (this.mIntents) {
            try {
                Iterator it = this.mIntents.iterator();
                while (it.hasNext()) {
                    if ("ACTION_CONSTRAINTS_CHANGED".equals(((Intent) it.next()).getAction())) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void onDestroy() {
        Logger$LogcatLogger.get().debug(TAG, "Destroying SystemAlarmDispatcher", new Throwable[0]);
        this.mProcessor.removeExecutionListener(this);
        ScheduledExecutorService scheduledExecutorService = this.mWorkTimer.mExecutorService;
        if (!scheduledExecutorService.isShutdown()) {
            scheduledExecutorService.shutdownNow();
        }
        this.mCompletedListener = null;
    }

    @Override // androidx.work.impl.ExecutionListener
    public final void onExecuted(String str, boolean z) {
        String str2 = CommandHandler.TAG;
        Intent intent = new Intent(this.mContext, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z);
        postOnMainThread(new AppCompatTextHelper.AnonymousClass2(this, 0, 2, intent));
    }

    public final void postOnMainThread(Runnable runnable) {
        this.mMainHandler.post(runnable);
    }

    public final void processCommand() {
        assertMainThread();
        PowerManager.WakeLock wakeLockNewWakeLock = WakeLocks.newWakeLock(this.mContext, "ProcessCommand");
        try {
            wakeLockNewWakeLock.acquire();
            this.mWorkManager.mWorkTaskExecutor.executeOnBackgroundThread(new AnonymousClass1(this, 0));
        } finally {
            wakeLockNewWakeLock.release();
        }
    }
}
