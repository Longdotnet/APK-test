package androidx.work.impl.utils;

import android.content.Context;
import android.os.PowerManager;
import androidx.work.Logger$LogcatLogger;
import java.util.WeakHashMap;
import okhttp3.internal.concurrent.onZL.mnwSv;

/* JADX INFO: loaded from: classes2.dex */
public abstract class WakeLocks {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix(mnwSv.YmJdw);
    public static final WeakHashMap sWakeLocks = new WeakHashMap();

    public static PowerManager.WakeLock newWakeLock(Context context, String str) {
        PowerManager powerManager = (PowerManager) context.getApplicationContext().getSystemService("power");
        String strConcat = "WorkManager: ".concat(str);
        PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, strConcat);
        WeakHashMap weakHashMap = sWakeLocks;
        synchronized (weakHashMap) {
            weakHashMap.put(wakeLockNewWakeLock, strConcat);
        }
        return wakeLockNewWakeLock;
    }
}
