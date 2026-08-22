package androidx.work.impl.foreground;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleService;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.utils.CancelWorkRunnable;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class SystemForegroundService extends LifecycleService {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("SystemFgService");
    public SystemForegroundDispatcher mDispatcher;
    public Handler mHandler;
    public boolean mIsShutdown;
    public NotificationManager mNotificationManager;

    public final void initializeDispatcher$1() {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mNotificationManager = (NotificationManager) getApplicationContext().getSystemService("notification");
        SystemForegroundDispatcher systemForegroundDispatcher = new SystemForegroundDispatcher(getApplicationContext());
        this.mDispatcher = systemForegroundDispatcher;
        if (systemForegroundDispatcher.mCallback == null) {
            systemForegroundDispatcher.mCallback = this;
        } else {
            Logger$LogcatLogger.get().error(SystemForegroundDispatcher.TAG, "A callback already exists.", new Throwable[0]);
        }
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public final void onCreate() {
        super.onCreate();
        initializeDispatcher$1();
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        this.mDispatcher.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        boolean z = this.mIsShutdown;
        String str = TAG;
        if (z) {
            Logger$LogcatLogger.get().info(str, "Re-initializing SystemForegroundService after a request to shut-down.", new Throwable[0]);
            this.mDispatcher.onDestroy();
            initializeDispatcher$1();
            this.mIsShutdown = false;
        }
        if (intent == null) {
            return 3;
        }
        SystemForegroundDispatcher systemForegroundDispatcher = this.mDispatcher;
        systemForegroundDispatcher.getClass();
        String action = intent.getAction();
        boolean zEquals = "ACTION_START_FOREGROUND".equals(action);
        String str2 = SystemForegroundDispatcher.TAG;
        final WorkManagerImpl workManagerImpl = systemForegroundDispatcher.mWorkManagerImpl;
        if (zEquals) {
            Logger$LogcatLogger.get().info(str2, String.format("Started foreground service %s", intent), new Throwable[0]);
            systemForegroundDispatcher.mTaskExecutor.executeOnBackgroundThread(new WorkerWrapper.AnonymousClass1(systemForegroundDispatcher, workManagerImpl.mWorkDatabase, intent.getStringExtra("KEY_WORKSPEC_ID"), 6));
            systemForegroundDispatcher.handleNotify(intent);
            return 3;
        }
        if ("ACTION_NOTIFY".equals(action)) {
            systemForegroundDispatcher.handleNotify(intent);
            return 3;
        }
        if ("ACTION_CANCEL_WORK".equals(action)) {
            Logger$LogcatLogger.get().info(str2, String.format("Stopping foreground work for %s", intent), new Throwable[0]);
            String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
            if (stringExtra == null || TextUtils.isEmpty(stringExtra)) {
                return 3;
            }
            final UUID uuidFromString = UUID.fromString(stringExtra);
            workManagerImpl.getClass();
            workManagerImpl.mWorkTaskExecutor.executeOnBackgroundThread(new CancelWorkRunnable() { // from class: androidx.work.impl.utils.CancelWorkRunnable.1
                public final /* synthetic */ UUID val$id;

                public AnonymousClass1() {
                    uuid = uuidFromString;
                }

                @Override // androidx.work.impl.utils.CancelWorkRunnable
                public final void runInternal() {
                    WorkManagerImpl workManagerImpl2 = workManagerImpl;
                    WorkDatabase workDatabase = workManagerImpl2.mWorkDatabase;
                    workDatabase.beginTransaction();
                    try {
                        CancelWorkRunnable.cancel(workManagerImpl2, uuid.toString());
                        workDatabase.setTransactionSuccessful();
                        workDatabase.endTransaction();
                        Schedulers.schedule(workManagerImpl2.mConfiguration, workManagerImpl2.mWorkDatabase, workManagerImpl2.mSchedulers);
                    } catch (Throwable th) {
                        workDatabase.endTransaction();
                        throw th;
                    }
                }
            });
            return 3;
        }
        if (!"ACTION_STOP_FOREGROUND".equals(action)) {
            return 3;
        }
        Logger$LogcatLogger.get().info(str2, "Stopping foreground service", new Throwable[0]);
        SystemForegroundService systemForegroundService = systemForegroundDispatcher.mCallback;
        if (systemForegroundService == null) {
            return 3;
        }
        systemForegroundService.mIsShutdown = true;
        Logger$LogcatLogger.get().debug(str, "All commands completed.", new Throwable[0]);
        if (Build.VERSION.SDK_INT >= 26) {
            systemForegroundService.stopForeground(true);
        }
        systemForegroundService.stopSelf();
        return 3;
    }
}
