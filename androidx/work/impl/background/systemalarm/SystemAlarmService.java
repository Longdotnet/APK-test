package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import android.os.PowerManager;
import androidx.lifecycle.LifecycleService;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.utils.WakeLocks;
import java.util.HashMap;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class SystemAlarmService extends LifecycleService {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("SystemAlarmService");
    public SystemAlarmDispatcher mDispatcher;
    public boolean mIsShutdown;

    public final void onAllCommandsCompleted() {
        this.mIsShutdown = true;
        Logger$LogcatLogger.get().debug(TAG, "All commands completed in dispatcher", new Throwable[0]);
        String str = WakeLocks.TAG;
        HashMap map = new HashMap();
        WeakHashMap weakHashMap = WakeLocks.sWakeLocks;
        synchronized (weakHashMap) {
            map.putAll(weakHashMap);
        }
        for (PowerManager.WakeLock wakeLock : map.keySet()) {
            if (wakeLock != null && wakeLock.isHeld()) {
                Logger$LogcatLogger.get().warning(WakeLocks.TAG, String.format("WakeLock held for %s", map.get(wakeLock)), new Throwable[0]);
            }
        }
        stopSelf();
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public final void onCreate() {
        super.onCreate();
        SystemAlarmDispatcher systemAlarmDispatcher = new SystemAlarmDispatcher(this);
        this.mDispatcher = systemAlarmDispatcher;
        if (systemAlarmDispatcher.mCompletedListener != null) {
            Logger$LogcatLogger.get().error(SystemAlarmDispatcher.TAG, "A completion listener for SystemAlarmDispatcher already exists.", new Throwable[0]);
        } else {
            systemAlarmDispatcher.mCompletedListener = this;
        }
        this.mIsShutdown = false;
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        this.mIsShutdown = true;
        this.mDispatcher.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (this.mIsShutdown) {
            Logger$LogcatLogger.get().info(TAG, "Re-initializing SystemAlarmDispatcher after a request to shut-down.", new Throwable[0]);
            this.mDispatcher.onDestroy();
            SystemAlarmDispatcher systemAlarmDispatcher = new SystemAlarmDispatcher(this);
            this.mDispatcher = systemAlarmDispatcher;
            if (systemAlarmDispatcher.mCompletedListener != null) {
                Logger$LogcatLogger.get().error(SystemAlarmDispatcher.TAG, "A completion listener for SystemAlarmDispatcher already exists.", new Throwable[0]);
            } else {
                systemAlarmDispatcher.mCompletedListener = this;
            }
            this.mIsShutdown = false;
        }
        if (intent == null) {
            return 3;
        }
        this.mDispatcher.add(i2, intent);
        return 3;
    }
}
