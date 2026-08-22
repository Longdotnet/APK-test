package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.WorkManagerImpl;

/* JADX INFO: loaded from: classes.dex */
public class RescheduleReceiver extends BroadcastReceiver {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("RescheduleReceiver");

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Logger$LogcatLogger.get().debug(TAG, String.format("Received intent %s", intent), new Throwable[0]);
        try {
            WorkManagerImpl workManagerImpl = WorkManagerImpl.getInstance(context);
            BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
            synchronized (WorkManagerImpl.sLock) {
                try {
                    workManagerImpl.mRescheduleReceiverResult = pendingResultGoAsync;
                    if (workManagerImpl.mForceStopRunnableCompleted) {
                        pendingResultGoAsync.finish();
                        workManagerImpl.mRescheduleReceiverResult = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (IllegalStateException e) {
            Logger$LogcatLogger.get().error(TAG, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e);
        }
    }
}
