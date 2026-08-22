package androidx.work.impl.background.systemalarm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.widget.AppCompatTextHelper;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.work.Constraints;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.WorkSpec;
import com.google.android.gms.games.event.AfJ.oKjScaD;
import com.google.firebase.auth.zzaa;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class CommandHandler implements ExecutionListener {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("CommandHandler");
    public final Context mContext;
    public final HashMap mPendingDelayMet = new HashMap();
    public final Object mLock = new Object();

    public CommandHandler(Context context) {
        this.mContext = context;
    }

    public static Intent createDelayMetIntent(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent createScheduleWorkIntent(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_SCHEDULE_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public final boolean hasPendingCommands() {
        boolean z;
        synchronized (this.mLock) {
            z = !this.mPendingDelayMet.isEmpty();
        }
        return z;
    }

    @Override // androidx.work.impl.ExecutionListener
    public final void onExecuted(String str, boolean z) {
        synchronized (this.mLock) {
            try {
                ExecutionListener executionListener = (ExecutionListener) this.mPendingDelayMet.remove(str);
                if (executionListener != null) {
                    executionListener.onExecuted(str, z);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void onHandleIntent(Intent intent, int i, SystemAlarmDispatcher systemAlarmDispatcher) throws Throwable {
        String action = intent.getAction();
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            Logger$LogcatLogger.get().debug(TAG, String.format("Handling constraints changed %s", intent), new Throwable[0]);
            ConstraintsCommandHandler constraintsCommandHandler = new ConstraintsCommandHandler(this.mContext, i, systemAlarmDispatcher);
            ArrayList<WorkSpec> scheduledWork = systemAlarmDispatcher.mWorkManager.mWorkDatabase.workSpecDao().getScheduledWork();
            String str = ConstraintProxy.TAG;
            Iterator it = scheduledWork.iterator();
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            while (it.hasNext()) {
                Constraints constraints = ((WorkSpec) it.next()).constraints;
                z |= constraints.mRequiresBatteryNotLow;
                z2 |= constraints.mRequiresCharging;
                z3 |= constraints.mRequiresStorageNotLow;
                z4 |= constraints.mRequiredNetworkType != 1;
                if (z && z2 && z3 && z4) {
                    break;
                }
            }
            String str2 = ConstraintProxyUpdateReceiver.TAG;
            Intent intent2 = new Intent("androidx.work.impl.background.systemalarm.UpdateProxies");
            Context context = constraintsCommandHandler.mContext;
            intent2.setComponent(new ComponentName(context, (Class<?>) ConstraintProxyUpdateReceiver.class));
            intent2.putExtra(oKjScaD.DjqPvb, z).putExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", z2).putExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", z3).putExtra("KEY_NETWORK_STATE_PROXY_ENABLED", z4);
            context.sendBroadcast(intent2);
            WorkConstraintsTracker workConstraintsTracker = constraintsCommandHandler.mWorkConstraintsTracker;
            workConstraintsTracker.replace(scheduledWork);
            ArrayList arrayList = new ArrayList(scheduledWork.size());
            long jCurrentTimeMillis = System.currentTimeMillis();
            for (WorkSpec workSpec : scheduledWork) {
                String str3 = workSpec.id;
                if (jCurrentTimeMillis >= workSpec.calculateNextRunTime() && (!workSpec.hasConstraints() || workConstraintsTracker.areAllConstraintsMet(str3))) {
                    arrayList.add(workSpec);
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                String str4 = ((WorkSpec) it2.next()).id;
                Intent intentCreateDelayMetIntent = createDelayMetIntent(context, str4);
                Logger$LogcatLogger.get().debug(ConstraintsCommandHandler.TAG, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Creating a delay_met command for workSpec with id (", str4, ")"), new Throwable[0]);
                systemAlarmDispatcher.postOnMainThread(new AppCompatTextHelper.AnonymousClass2(systemAlarmDispatcher, constraintsCommandHandler.mStartId, 2, intentCreateDelayMetIntent));
            }
            workConstraintsTracker.reset();
            return;
        }
        if ("ACTION_RESCHEDULE".equals(action)) {
            Logger$LogcatLogger.get().debug(TAG, String.format("Handling reschedule %s, %s", intent, Integer.valueOf(i)), new Throwable[0]);
            systemAlarmDispatcher.mWorkManager.rescheduleEligibleWork();
            return;
        }
        Bundle extras = intent.getExtras();
        String[] strArr = {"KEY_WORKSPEC_ID"};
        if (extras == null || extras.isEmpty() || extras.get(strArr[0]) == null) {
            Logger$LogcatLogger.get().error(TAG, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Invalid request for ", action, ", requires KEY_WORKSPEC_ID."), new Throwable[0]);
            return;
        }
        if (!"ACTION_SCHEDULE_WORK".equals(action)) {
            if ("ACTION_DELAY_MET".equals(action)) {
                Bundle extras2 = intent.getExtras();
                synchronized (this.mLock) {
                    try {
                        String string = extras2.getString("KEY_WORKSPEC_ID");
                        Logger$LogcatLogger logger$LogcatLogger = Logger$LogcatLogger.get();
                        String str5 = TAG;
                        logger$LogcatLogger.debug(str5, "Handing delay met for " + string, new Throwable[0]);
                        if (this.mPendingDelayMet.containsKey(string)) {
                            Logger$LogcatLogger.get().debug(str5, "WorkSpec " + string + " is already being handled for ACTION_DELAY_MET", new Throwable[0]);
                        } else {
                            DelayMetCommandHandler delayMetCommandHandler = new DelayMetCommandHandler(this.mContext, i, string, systemAlarmDispatcher);
                            this.mPendingDelayMet.put(string, delayMetCommandHandler);
                            delayMetCommandHandler.handleProcessWork();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            }
            if (!"ACTION_STOP_WORK".equals(action)) {
                if (!"ACTION_EXECUTION_COMPLETED".equals(action)) {
                    Logger$LogcatLogger.get().warning(TAG, String.format("Ignoring intent %s", intent), new Throwable[0]);
                    return;
                }
                Bundle extras3 = intent.getExtras();
                String string2 = extras3.getString("KEY_WORKSPEC_ID");
                boolean z5 = extras3.getBoolean("KEY_NEEDS_RESCHEDULE");
                Logger$LogcatLogger.get().debug(TAG, String.format("Handling onExecutionCompleted %s, %s", intent, Integer.valueOf(i)), new Throwable[0]);
                onExecuted(string2, z5);
                return;
            }
            String string3 = intent.getExtras().getString("KEY_WORKSPEC_ID");
            Logger$LogcatLogger.get().debug(TAG, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Handing stopWork work for ", string3), new Throwable[0]);
            systemAlarmDispatcher.mWorkManager.stopWork(string3);
            String str6 = Alarms.TAG;
            zzaa zzaaVarSystemIdInfoDao = systemAlarmDispatcher.mWorkManager.mWorkDatabase.systemIdInfoDao();
            SystemIdInfo systemIdInfo = zzaaVarSystemIdInfoDao.getSystemIdInfo(string3);
            if (systemIdInfo != null) {
                Alarms.cancelExactAlarm(this.mContext, string3, systemIdInfo.systemId);
                Logger$LogcatLogger.get().debug(Alarms.TAG, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Removing SystemIdInfo for workSpecId (", string3, ")"), new Throwable[0]);
                zzaaVarSystemIdInfoDao.removeSystemIdInfo(string3);
            }
            systemAlarmDispatcher.onExecuted(string3, false);
            return;
        }
        String string4 = intent.getExtras().getString("KEY_WORKSPEC_ID");
        String str7 = TAG;
        Logger$LogcatLogger.get().debug(str7, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Handling schedule work for ", string4), new Throwable[0]);
        WorkDatabase workDatabase = systemAlarmDispatcher.mWorkManager.mWorkDatabase;
        workDatabase.beginTransaction();
        try {
            WorkSpec workSpec2 = workDatabase.workSpecDao().getWorkSpec(string4);
            if (workSpec2 == null) {
                Logger$LogcatLogger.get().warning(str7, "Skipping scheduling " + string4 + " because it's no longer in the DB", new Throwable[0]);
            } else if (CoroutineAdapterKt$$ExternalSyntheticLambda0._isFinished(workSpec2.state)) {
                Logger$LogcatLogger.get().warning(str7, "Skipping scheduling " + string4 + "because it is finished.", new Throwable[0]);
            } else {
                long jCalculateNextRunTime = workSpec2.calculateNextRunTime();
                boolean zHasConstraints = workSpec2.hasConstraints();
                Context context2 = this.mContext;
                WorkManagerImpl workManagerImpl = systemAlarmDispatcher.mWorkManager;
                if (zHasConstraints) {
                    Logger$LogcatLogger.get().debug(str7, "Opportunistically setting an alarm for " + string4 + " at " + jCalculateNextRunTime, new Throwable[0]);
                    Alarms.setAlarm(context2, workManagerImpl, string4, jCalculateNextRunTime);
                    Intent intent3 = new Intent(context2, (Class<?>) SystemAlarmService.class);
                    intent3.setAction("ACTION_CONSTRAINTS_CHANGED");
                    systemAlarmDispatcher.postOnMainThread(new AppCompatTextHelper.AnonymousClass2(systemAlarmDispatcher, i, 2, intent3));
                } else {
                    Logger$LogcatLogger.get().debug(str7, "Setting up Alarms for " + string4 + " at " + jCalculateNextRunTime, new Throwable[0]);
                    Alarms.setAlarm(context2, workManagerImpl, string4, jCalculateNextRunTime);
                }
                workDatabase.setTransactionSuccessful();
            }
        } finally {
            workDatabase.endTransaction();
        }
    }
}
