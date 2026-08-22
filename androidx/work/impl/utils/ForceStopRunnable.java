package androidx.work.impl.utils;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.core.os.BuildCompat;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import androidx.work.Configuration;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabasePathHelper;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.model.Preference;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao_Impl;
import com.daerisoft.thespikerm.RunnerActivity$$ExternalSyntheticApiModelOutline7;
import com.google.android.gms.games.snapshot.Xa.JrbhsraGtto;
import com.google.firebase.auth.zzaa;
import com.pairip.VMRunner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Dispatcher;

/* JADX INFO: loaded from: classes2.dex */
public final class ForceStopRunnable implements Runnable {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("ForceStopRunnable");
    public static final long TEN_YEARS = TimeUnit.DAYS.toMillis(3650);
    public final Context mContext;
    public int mRetryCount = 0;
    public final WorkManagerImpl mWorkManager;

    public class BroadcastReceiver extends android.content.BroadcastReceiver {
        public static final String TAG = Logger$LogcatLogger.tagWithPrefix("ForceStopRunnable$Rcvr");

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            VMRunner.invoke("F2G6LwVwJ6yXD9K6", new Object[]{this, context, intent});
        }
    }

    public ForceStopRunnable(Context context, WorkManagerImpl workManagerImpl) {
        this.mContext = context.getApplicationContext();
        this.mWorkManager = workManagerImpl;
    }

    public static void setAlarm(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        int i = BuildCompat.isAtLeastS() ? 167772160 : 134217728;
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, -1, intent, i);
        long jCurrentTimeMillis = System.currentTimeMillis() + TEN_YEARS;
        if (alarmManager != null) {
            alarmManager.setExact(0, jCurrentTimeMillis, broadcast);
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:140:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:27:0x0086  */
    public final void forceStopRunnable() {
        boolean z;
        String string;
        String str = SystemJobScheduler.TAG;
        Context context = this.mContext;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        ArrayList<JobInfo> pendingJobs = SystemJobScheduler.getPendingJobs(context, jobScheduler);
        WorkManagerImpl workManagerImpl = this.mWorkManager;
        zzaa zzaaVarSystemIdInfoDao = workManagerImpl.mWorkDatabase.systemIdInfoDao();
        zzaaVarSystemIdInfoDao.getClass();
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(0, "SELECT DISTINCT work_spec_id FROM SystemIdInfo");
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) zzaaVarSystemIdInfoDao.zza;
        workDatabase_Impl.assertNotSuspendingTransaction();
        Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.getString(0));
            }
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            HashSet hashSet = new HashSet(pendingJobs != null ? pendingJobs.size() : 0);
            if (pendingJobs != null && !pendingJobs.isEmpty()) {
                for (JobInfo jobInfo : pendingJobs) {
                    PersistableBundle extras = jobInfo.getExtras();
                    if (extras != null) {
                        try {
                            if (extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                                string = extras.getString("EXTRA_WORK_SPEC_ID");
                            } else {
                                string = null;
                            }
                        } catch (NullPointerException unused) {
                        }
                    } else {
                        string = null;
                    }
                    if (TextUtils.isEmpty(string)) {
                        SystemJobScheduler.cancelJobById(jobScheduler, jobInfo.getId());
                    } else {
                        hashSet.add(string);
                    }
                }
            }
            Iterator it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (!hashSet.contains((String) it.next())) {
                        Logger$LogcatLogger.get().debug(SystemJobScheduler.TAG, "Reconciling jobs", new Throwable[0]);
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (z) {
                WorkDatabase workDatabase = workManagerImpl.mWorkDatabase;
                workDatabase.beginTransaction();
                try {
                    WorkSpecDao_Impl workSpecDao_ImplWorkSpecDao = workDatabase.workSpecDao();
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        workSpecDao_ImplWorkSpecDao.markWorkSpecScheduled(-1L, (String) it2.next());
                    }
                    workDatabase.setTransactionSuccessful();
                    workDatabase.endTransaction();
                } catch (Throwable th) {
                    workDatabase.endTransaction();
                    throw th;
                }
            }
            WorkDatabase workDatabase2 = workManagerImpl.mWorkDatabase;
            WorkSpecDao_Impl workSpecDao_ImplWorkSpecDao2 = workDatabase2.workSpecDao();
            Dispatcher dispatcherWorkProgressDao = workDatabase2.workProgressDao();
            workDatabase2.beginTransaction();
            try {
                ArrayList<WorkSpec> runningWork = workSpecDao_ImplWorkSpecDao2.getRunningWork();
                boolean zIsEmpty = runningWork.isEmpty();
                if (!zIsEmpty) {
                    for (WorkSpec workSpec : runningWork) {
                        workSpecDao_ImplWorkSpecDao2.setState(1, workSpec.id);
                        workSpecDao_ImplWorkSpecDao2.markWorkSpecScheduled(-1L, workSpec.id);
                    }
                }
                WorkDatabase_Impl workDatabase_Impl2 = (WorkDatabase_Impl) dispatcherWorkProgressDao.executorServiceOrNull;
                workDatabase_Impl2.assertNotSuspendingTransaction();
                WorkSpecDao_Impl.AnonymousClass2 anonymousClass2 = (WorkSpecDao_Impl.AnonymousClass2) dispatcherWorkProgressDao.runningSyncCalls;
                FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = anonymousClass2.acquire();
                workDatabase_Impl2.beginTransaction();
                try {
                    frameworkSQLiteStatementAcquire.executeUpdateDelete();
                    workDatabase_Impl2.setTransactionSuccessful();
                    workDatabase_Impl2.endTransaction();
                    anonymousClass2.release(frameworkSQLiteStatementAcquire);
                    workDatabase2.setTransactionSuccessful();
                    workDatabase2.endTransaction();
                    boolean z2 = !zIsEmpty || z;
                    Long longValue = workManagerImpl.mPreferenceUtils.mWorkDatabase.preferenceDao().getLongValue("reschedule_needed");
                    String str2 = TAG;
                    if (longValue != null && longValue.longValue() == 1) {
                        Logger$LogcatLogger.get().debug(str2, "Rescheduling Workers.", new Throwable[0]);
                        workManagerImpl.rescheduleEligibleWork();
                        IdGenerator idGenerator = workManagerImpl.mPreferenceUtils;
                        idGenerator.getClass();
                        idGenerator.mWorkDatabase.preferenceDao().insertPreference(new Preference("reschedule_needed", 0L));
                        return;
                    }
                    try {
                        int i = BuildCompat.isAtLeastS() ? 570425344 : 536870912;
                        Intent intent = new Intent();
                        intent.setComponent(new ComponentName(context, (Class<?>) BroadcastReceiver.class));
                        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
                        PendingIntent broadcast = PendingIntent.getBroadcast(context, -1, intent, i);
                        if (Build.VERSION.SDK_INT < 30) {
                            if (broadcast == null) {
                                setAlarm(context);
                                Logger$LogcatLogger.get().debug(str2, "Application was force-stopped, rescheduling.", new Throwable[0]);
                                workManagerImpl.rescheduleEligibleWork();
                                return;
                            }
                            if (z2) {
                                Logger$LogcatLogger.get().debug(str2, "Found unfinished work, scheduling it.", new Throwable[0]);
                                Schedulers.schedule(workManagerImpl.mConfiguration, workManagerImpl.mWorkDatabase, workManagerImpl.mSchedulers);
                            }
                        }
                        if (broadcast != null) {
                            broadcast.cancel();
                        }
                        List historicalProcessExitReasons = ((ActivityManager) context.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);
                        if (historicalProcessExitReasons != null && !historicalProcessExitReasons.isEmpty()) {
                            for (int i2 = 0; i2 < historicalProcessExitReasons.size(); i2++) {
                                if (RunnerActivity$$ExternalSyntheticApiModelOutline7.m(historicalProcessExitReasons.get(i2)).getReason() == 10) {
                                    Logger$LogcatLogger.get().debug(str2, "Application was force-stopped, rescheduling.", new Throwable[0]);
                                    workManagerImpl.rescheduleEligibleWork();
                                    return;
                                }
                            }
                        }
                        if (z2) {
                            Logger$LogcatLogger.get().debug(str2, "Found unfinished work, scheduling it.", new Throwable[0]);
                            Schedulers.schedule(workManagerImpl.mConfiguration, workManagerImpl.mWorkDatabase, workManagerImpl.mSchedulers);
                        }
                    } catch (IllegalArgumentException e) {
                        e = e;
                        Logger$LogcatLogger.get().warning(str2, "Ignoring exception", e);
                    } catch (SecurityException e2) {
                        e = e2;
                        Logger$LogcatLogger.get().warning(str2, "Ignoring exception", e);
                    }
                } catch (Throwable th2) {
                    workDatabase_Impl2.endTransaction();
                    anonymousClass2.release(frameworkSQLiteStatementAcquire);
                    throw th2;
                }
            } catch (Throwable th3) {
                workDatabase2.endTransaction();
                throw th3;
            }
        } catch (Throwable th4) {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            throw th4;
        }
    }

    public final boolean multiProcessChecks() {
        Configuration configuration = this.mWorkManager.mConfiguration;
        configuration.getClass();
        boolean zIsEmpty = TextUtils.isEmpty(null);
        String str = TAG;
        if (zIsEmpty) {
            Logger$LogcatLogger.get().debug(str, "The default process name was not specified.", new Throwable[0]);
            return true;
        }
        boolean zIsDefaultProcess = ProcessUtils.isDefaultProcess(this.mContext, configuration);
        Logger$LogcatLogger.get().debug(str, "Is default app process = " + zIsDefaultProcess, new Throwable[0]);
        return zIsDefaultProcess;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = TAG;
        WorkManagerImpl workManagerImpl = this.mWorkManager;
        try {
            if (!multiProcessChecks()) {
                workManagerImpl.onForceStopRunnableCompleted();
                return;
            }
            while (true) {
                WorkDatabasePathHelper.migrateDatabase(this.mContext);
                Logger$LogcatLogger.get().debug(str, JrbhsraGtto.BuQMu, new Throwable[0]);
                try {
                    forceStopRunnable();
                    workManagerImpl.onForceStopRunnableCompleted();
                    return;
                } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteTableLockedException e) {
                    int i = this.mRetryCount + 1;
                    this.mRetryCount = i;
                    if (i >= 3) {
                        Logger$LogcatLogger.get().error(str, "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e);
                        IllegalStateException illegalStateException = new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e);
                        workManagerImpl.mConfiguration.getClass();
                        throw illegalStateException;
                    }
                    Logger$LogcatLogger.get().debug(str, "Retrying after " + (((long) i) * 300), e);
                    try {
                        Thread.sleep(((long) this.mRetryCount) * 300);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        } catch (Throwable th) {
            workManagerImpl.onForceStopRunnableCompleted();
            throw th;
        }
    }
}
