package androidx.work.impl.background.greedy;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.work.Configuration;
import androidx.work.Constraints;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.ProcessUtils;
import com.facebook.AccessTokenCache;
import com.google.android.gms.ads.zza;
import com.google.android.gms.internal.common.Ko.TSDAbK;
import com.google.firebase.auth.zzaa;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class GreedyScheduler implements Scheduler, WorkConstraintsCallback, ExecutionListener {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("GreedyScheduler");
    public final Context mContext;
    public final DelayedWorkTracker mDelayedWorkTracker;
    public Boolean mInDefaultProcess;
    public boolean mRegisteredExecutionListener;
    public final WorkConstraintsTracker mWorkConstraintsTracker;
    public final WorkManagerImpl mWorkManagerImpl;
    public final HashSet mConstrainedWorkSpecs = new HashSet();
    public final Object mLock = new Object();

    public GreedyScheduler(Context context, Configuration configuration, zzaa zzaaVar, WorkManagerImpl workManagerImpl) {
        this.mContext = context;
        this.mWorkManagerImpl = workManagerImpl;
        this.mWorkConstraintsTracker = new WorkConstraintsTracker(context, zzaaVar, this);
        this.mDelayedWorkTracker = new DelayedWorkTracker(this, configuration.mRunnableScheduler);
    }

    @Override // androidx.work.impl.Scheduler
    public final boolean hasLimitedSchedulingSlots() {
        return false;
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public final void onAllConstraintsMet(List list) {
        for (String str : (ArrayList) list) {
            Logger$LogcatLogger.get().debug(TAG, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Constraints met: Scheduling work ID ", str), new Throwable[0]);
            this.mWorkManagerImpl.startWork(str, null);
        }
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public final void onAllConstraintsNotMet(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Logger$LogcatLogger.get().debug(TAG, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Constraints not met: Cancelling work ID ", str), new Throwable[0]);
            this.mWorkManagerImpl.stopWork(str);
        }
    }

    @Override // androidx.work.impl.ExecutionListener
    public final void onExecuted(String str, boolean z) {
        synchronized (this.mLock) {
            try {
                for (WorkSpec workSpec : this.mConstrainedWorkSpecs) {
                    if (workSpec.id.equals(str)) {
                        Logger$LogcatLogger.get().debug(TAG, "Stopping tracking for " + str, new Throwable[0]);
                        this.mConstrainedWorkSpecs.remove(workSpec);
                        this.mWorkConstraintsTracker.replace(this.mConstrainedWorkSpecs);
                        break;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.work.impl.Scheduler
    public final void schedule(WorkSpec... workSpecArr) {
        if (this.mInDefaultProcess == null) {
            this.mInDefaultProcess = Boolean.valueOf(ProcessUtils.isDefaultProcess(this.mContext, this.mWorkManagerImpl.mConfiguration));
        }
        if (!this.mInDefaultProcess.booleanValue()) {
            Logger$LogcatLogger.get().info(TAG, "Ignoring schedule request in a secondary process", new Throwable[0]);
            return;
        }
        if (!this.mRegisteredExecutionListener) {
            this.mWorkManagerImpl.mProcessor.addExecutionListener(this);
            this.mRegisteredExecutionListener = true;
        }
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (WorkSpec workSpec : workSpecArr) {
            long jCalculateNextRunTime = workSpec.calculateNextRunTime();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (workSpec.state == 1) {
                if (jCurrentTimeMillis < jCalculateNextRunTime) {
                    DelayedWorkTracker delayedWorkTracker = this.mDelayedWorkTracker;
                    if (delayedWorkTracker != null) {
                        HashMap map = delayedWorkTracker.mRunnables;
                        Runnable runnable = (Runnable) map.remove(workSpec.id);
                        AccessTokenCache accessTokenCache = delayedWorkTracker.mRunnableScheduler;
                        if (runnable != null) {
                            ((Handler) accessTokenCache.sharedPreferences).removeCallbacks(runnable);
                        }
                        zza zzaVar = new zza((Object) delayedWorkTracker, (Object) workSpec, 8, false);
                        map.put(workSpec.id, zzaVar);
                        ((Handler) accessTokenCache.sharedPreferences).postDelayed(zzaVar, workSpec.calculateNextRunTime() - System.currentTimeMillis());
                    }
                } else if (workSpec.hasConstraints()) {
                    int i = Build.VERSION.SDK_INT;
                    Constraints constraints = workSpec.constraints;
                    if (constraints.mRequiresDeviceIdle) {
                        Logger$LogcatLogger.get().debug(TAG, "Ignoring WorkSpec " + workSpec + ", Requires device idle.", new Throwable[0]);
                    } else if (i < 24 || constraints.mContentUriTriggers.mTriggers.size() <= 0) {
                        hashSet.add(workSpec);
                        hashSet2.add(workSpec.id);
                    } else {
                        Logger$LogcatLogger.get().debug(TAG, "Ignoring WorkSpec " + workSpec + ", Requires ContentUri triggers.", new Throwable[0]);
                    }
                } else {
                    Logger$LogcatLogger.get().debug(TAG, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Starting work for ", workSpec.id), new Throwable[0]);
                    this.mWorkManagerImpl.startWork(workSpec.id, null);
                }
            }
        }
        synchronized (this.mLock) {
            try {
                if (!hashSet.isEmpty()) {
                    Logger$LogcatLogger.get().debug(TAG, "Starting tracking for [" + TextUtils.join(",", hashSet2) + "]", new Throwable[0]);
                    this.mConstrainedWorkSpecs.addAll(hashSet);
                    this.mWorkConstraintsTracker.replace(this.mConstrainedWorkSpecs);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.work.impl.Scheduler
    public final void cancel(String str) {
        Runnable runnable;
        Boolean bool = this.mInDefaultProcess;
        WorkManagerImpl workManagerImpl = this.mWorkManagerImpl;
        if (bool == null) {
            this.mInDefaultProcess = Boolean.valueOf(ProcessUtils.isDefaultProcess(this.mContext, workManagerImpl.mConfiguration));
        }
        boolean zBooleanValue = this.mInDefaultProcess.booleanValue();
        String str2 = TAG;
        if (!zBooleanValue) {
            Logger$LogcatLogger.get().info(str2, TSDAbK.zPcOCYxFW, new Throwable[0]);
            return;
        }
        if (!this.mRegisteredExecutionListener) {
            workManagerImpl.mProcessor.addExecutionListener(this);
            this.mRegisteredExecutionListener = true;
        }
        Logger$LogcatLogger.get().debug(str2, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Cancelling work ID ", str), new Throwable[0]);
        DelayedWorkTracker delayedWorkTracker = this.mDelayedWorkTracker;
        if (delayedWorkTracker != null && (runnable = (Runnable) delayedWorkTracker.mRunnables.remove(str)) != null) {
            ((Handler) delayedWorkTracker.mRunnableScheduler.sharedPreferences).removeCallbacks(runnable);
        }
        workManagerImpl.stopWork(str);
    }
}
