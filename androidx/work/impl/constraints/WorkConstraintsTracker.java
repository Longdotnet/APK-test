package androidx.work.impl.constraints;

import android.content.Context;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.constraints.controllers.BatteryNotLowController;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.constraints.controllers.NetworkMeteredController;
import androidx.work.impl.constraints.controllers.NetworkNotRoamingController;
import androidx.work.impl.constraints.trackers.BatteryChargingTracker;
import androidx.work.impl.constraints.trackers.BatteryNotLowTracker;
import androidx.work.impl.constraints.trackers.NetworkStateTracker;
import androidx.work.impl.constraints.trackers.StorageNotLowTracker;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.Collection;
import okhttp3.Dispatcher;

/* JADX INFO: loaded from: classes.dex */
public final class WorkConstraintsTracker {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("WorkConstraintsTracker");
    public final WorkConstraintsCallback mCallback;
    public final ConstraintController[] mConstraintControllers;
    public final Object mLock;

    public WorkConstraintsTracker(Context context, TaskExecutor taskExecutor, WorkConstraintsCallback workConstraintsCallback) {
        Context applicationContext = context.getApplicationContext();
        this.mCallback = workConstraintsCallback;
        this.mConstraintControllers = new ConstraintController[]{new BatteryNotLowController((BatteryChargingTracker) Dispatcher.getInstance(applicationContext, taskExecutor).executorServiceOrNull, 1), new BatteryNotLowController((BatteryNotLowTracker) Dispatcher.getInstance(applicationContext, taskExecutor).readyAsyncCalls, 0), new BatteryNotLowController((StorageNotLowTracker) Dispatcher.getInstance(applicationContext, taskExecutor).runningSyncCalls, 4), new BatteryNotLowController((NetworkStateTracker) Dispatcher.getInstance(applicationContext, taskExecutor).runningAsyncCalls, 2), new BatteryNotLowController((NetworkStateTracker) Dispatcher.getInstance(applicationContext, taskExecutor).runningAsyncCalls, 3), new NetworkNotRoamingController((NetworkStateTracker) Dispatcher.getInstance(applicationContext, taskExecutor).runningAsyncCalls), new NetworkMeteredController((NetworkStateTracker) Dispatcher.getInstance(applicationContext, taskExecutor).runningAsyncCalls)};
        this.mLock = new Object();
    }

    public final boolean areAllConstraintsMet(String str) {
        synchronized (this.mLock) {
            try {
                for (ConstraintController constraintController : this.mConstraintControllers) {
                    Object obj = constraintController.mCurrentValue;
                    if (obj != null && constraintController.isConstrained(obj) && constraintController.mMatchingWorkSpecIds.contains(str)) {
                        Logger$LogcatLogger.get().debug(TAG, "Work " + str + " constrained by " + constraintController.getClass().getSimpleName(), new Throwable[0]);
                        return false;
                    }
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void onConstraintNotMet(ArrayList arrayList) {
        synchronized (this.mLock) {
            WorkConstraintsCallback workConstraintsCallback = this.mCallback;
            if (workConstraintsCallback != null) {
                workConstraintsCallback.onAllConstraintsNotMet(arrayList);
            }
        }
    }

    public final void replace(Collection collection) {
        synchronized (this.mLock) {
            try {
                for (ConstraintController constraintController : this.mConstraintControllers) {
                    if (constraintController.mCallback != null) {
                        constraintController.mCallback = null;
                        constraintController.updateCallback(null, constraintController.mCurrentValue);
                    }
                }
                for (ConstraintController constraintController2 : this.mConstraintControllers) {
                    constraintController2.replace(collection);
                }
                for (ConstraintController constraintController3 : this.mConstraintControllers) {
                    if (constraintController3.mCallback != this) {
                        constraintController3.mCallback = this;
                        constraintController3.updateCallback(this, constraintController3.mCurrentValue);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void reset() {
        synchronized (this.mLock) {
            try {
                for (ConstraintController constraintController : this.mConstraintControllers) {
                    ArrayList arrayList = constraintController.mMatchingWorkSpecIds;
                    if (!arrayList.isEmpty()) {
                        arrayList.clear();
                        constraintController.mTracker.removeListener(constraintController);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
