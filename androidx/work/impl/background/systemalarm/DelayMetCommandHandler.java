package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.appcompat.widget.AppCompatTextHelper;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.WorkTimer;
import com.google.android.gms.common.stats.ZnFR.FKidOcdAYt;
import com.google.android.gms.measurement.internal.RVw.ZRqOdXiy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class DelayMetCommandHandler implements WorkConstraintsCallback, ExecutionListener, WorkTimer.TimeLimitExceededListener {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("DelayMetCommandHandler");
    public final Context mContext;
    public final SystemAlarmDispatcher mDispatcher;
    public final int mStartId;
    public PowerManager.WakeLock mWakeLock;
    public final WorkConstraintsTracker mWorkConstraintsTracker;
    public final String mWorkSpecId;
    public boolean mHasConstraints = false;
    public int mCurrentState = 0;
    public final Object mLock = new Object();

    public DelayMetCommandHandler(Context context, int i, String str, SystemAlarmDispatcher systemAlarmDispatcher) {
        this.mContext = context;
        this.mStartId = i;
        this.mDispatcher = systemAlarmDispatcher;
        this.mWorkSpecId = str;
        this.mWorkConstraintsTracker = new WorkConstraintsTracker(context, systemAlarmDispatcher.mTaskExecutor, this);
    }

    public final void cleanUp() {
        synchronized (this.mLock) {
            try {
                this.mWorkConstraintsTracker.reset();
                this.mDispatcher.mWorkTimer.stopTimer(this.mWorkSpecId);
                PowerManager.WakeLock wakeLock = this.mWakeLock;
                if (wakeLock != null && wakeLock.isHeld()) {
                    Logger$LogcatLogger.get().debug(TAG, "Releasing wakelock " + this.mWakeLock + " for WorkSpec " + this.mWorkSpecId, new Throwable[0]);
                    this.mWakeLock.release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void handleProcessWork() {
        StringBuilder sb = new StringBuilder();
        String str = this.mWorkSpecId;
        sb.append(str);
        sb.append(" (");
        this.mWakeLock = WakeLocks.newWakeLock(this.mContext, CoroutineAdapterKt$$ExternalSyntheticLambda0.m(sb, this.mStartId, ")"));
        Logger$LogcatLogger logger$LogcatLogger = Logger$LogcatLogger.get();
        PowerManager.WakeLock wakeLock = this.mWakeLock;
        String str2 = TAG;
        logger$LogcatLogger.debug(str2, "Acquiring wakelock " + wakeLock + " for WorkSpec " + str, new Throwable[0]);
        this.mWakeLock.acquire();
        WorkSpec workSpec = this.mDispatcher.mWorkManager.mWorkDatabase.workSpecDao().getWorkSpec(str);
        if (workSpec == null) {
            stopWork();
            return;
        }
        boolean zHasConstraints = workSpec.hasConstraints();
        this.mHasConstraints = zHasConstraints;
        if (zHasConstraints) {
            this.mWorkConstraintsTracker.replace(Collections.singletonList(workSpec));
        } else {
            Logger$LogcatLogger.get().debug(str2, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("No constraints for ", str), new Throwable[0]);
            onAllConstraintsMet(Collections.singletonList(str));
        }
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public final void onAllConstraintsNotMet(ArrayList arrayList) {
        stopWork();
    }

    public final void stopWork() {
        synchronized (this.mLock) {
            try {
                if (this.mCurrentState < 2) {
                    this.mCurrentState = 2;
                    Logger$LogcatLogger logger$LogcatLogger = Logger$LogcatLogger.get();
                    String str = TAG;
                    logger$LogcatLogger.debug(str, "Stopping work for WorkSpec " + this.mWorkSpecId, new Throwable[0]);
                    Context context = this.mContext;
                    String str2 = this.mWorkSpecId;
                    Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
                    intent.setAction("ACTION_STOP_WORK");
                    intent.putExtra("KEY_WORKSPEC_ID", str2);
                    SystemAlarmDispatcher systemAlarmDispatcher = this.mDispatcher;
                    systemAlarmDispatcher.postOnMainThread(new AppCompatTextHelper.AnonymousClass2(systemAlarmDispatcher, this.mStartId, 2, intent));
                    if (this.mDispatcher.mProcessor.isEnqueued(this.mWorkSpecId)) {
                        Logger$LogcatLogger.get().debug(str, "WorkSpec " + this.mWorkSpecId + " needs to be rescheduled", new Throwable[0]);
                        Intent intentCreateScheduleWorkIntent = CommandHandler.createScheduleWorkIntent(this.mContext, this.mWorkSpecId);
                        SystemAlarmDispatcher systemAlarmDispatcher2 = this.mDispatcher;
                        systemAlarmDispatcher2.postOnMainThread(new AppCompatTextHelper.AnonymousClass2(systemAlarmDispatcher2, this.mStartId, 2, intentCreateScheduleWorkIntent));
                    } else {
                        Logger$LogcatLogger.get().debug(str, "Processor does not have WorkSpec " + this.mWorkSpecId + ". No need to reschedule ", new Throwable[0]);
                    }
                } else {
                    Logger$LogcatLogger.get().debug(TAG, "Already stopped work for " + this.mWorkSpecId, new Throwable[0]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public final void onAllConstraintsMet(List list) {
        String str = FKidOcdAYt.wHYjjNplrKb;
        if (list.contains(this.mWorkSpecId)) {
            synchronized (this.mLock) {
                try {
                    if (this.mCurrentState == 0) {
                        this.mCurrentState = 1;
                        Logger$LogcatLogger.get().debug(TAG, str + this.mWorkSpecId, new Throwable[0]);
                        if (this.mDispatcher.mProcessor.startWork(this.mWorkSpecId, null)) {
                            this.mDispatcher.mWorkTimer.startTimer(this.mWorkSpecId, this);
                        } else {
                            cleanUp();
                        }
                    } else {
                        Logger$LogcatLogger.get().debug(TAG, "Already started work for " + this.mWorkSpecId, new Throwable[0]);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // androidx.work.impl.ExecutionListener
    public final void onExecuted(String str, boolean z) {
        Logger$LogcatLogger.get().debug(TAG, "onExecuted " + str + ZRqOdXiy.rHXivcu + z, new Throwable[0]);
        cleanUp();
        int i = this.mStartId;
        SystemAlarmDispatcher systemAlarmDispatcher = this.mDispatcher;
        Context context = this.mContext;
        if (z) {
            systemAlarmDispatcher.postOnMainThread(new AppCompatTextHelper.AnonymousClass2(systemAlarmDispatcher, i, 2, CommandHandler.createScheduleWorkIntent(context, this.mWorkSpecId)));
        }
        if (this.mHasConstraints) {
            Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
            intent.setAction("ACTION_CONSTRAINTS_CHANGED");
            systemAlarmDispatcher.postOnMainThread(new AppCompatTextHelper.AnonymousClass2(systemAlarmDispatcher, i, 2, intent));
        }
    }
}
