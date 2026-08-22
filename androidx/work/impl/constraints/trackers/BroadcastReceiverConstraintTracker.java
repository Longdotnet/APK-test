package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.android.gms.ads.internal.util.zzq;
import com.google.android.gms.games.snapshot.Xa.JrbhsraGtto;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BroadcastReceiverConstraintTracker extends ConstraintTracker {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("BrdcstRcvrCnstrntTrckr");
    public final zzq mBroadcastReceiver;

    public BroadcastReceiverConstraintTracker(Context context, TaskExecutor taskExecutor) {
        super(context, taskExecutor);
        this.mBroadcastReceiver = new zzq(this, 3);
    }

    public abstract IntentFilter getIntentFilter();

    public abstract void onBroadcastReceive(Intent intent);

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public final void startTracking() {
        Logger$LogcatLogger.get().debug(TAG, getClass().getSimpleName().concat(": registering receiver"), new Throwable[0]);
        this.mAppContext.registerReceiver(this.mBroadcastReceiver, getIntentFilter());
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public final void stopTracking() {
        Logger$LogcatLogger.get().debug(TAG, getClass().getSimpleName().concat(JrbhsraGtto.ZJNbDhxqPB), new Throwable[0]);
        this.mAppContext.unregisterReceiver(this.mBroadcastReceiver);
    }
}
