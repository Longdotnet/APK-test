package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.IdGenerator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class SystemJobScheduler implements Scheduler {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("SystemJobScheduler");
    public final Context mContext;
    public final JobScheduler mJobScheduler;
    public final SystemJobInfoConverter mSystemJobInfoConverter;
    public final WorkManagerImpl mWorkManager;

    public SystemJobScheduler(Context context, WorkManagerImpl workManagerImpl) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        SystemJobInfoConverter systemJobInfoConverter = new SystemJobInfoConverter(context);
        this.mContext = context;
        this.mWorkManager = workManagerImpl;
        this.mJobScheduler = jobScheduler;
        this.mSystemJobInfoConverter = systemJobInfoConverter;
    }

    public static void cancelJobById(JobScheduler jobScheduler, int i) {
        try {
            jobScheduler.cancel(i);
        } catch (Throwable th) {
            Logger$LogcatLogger.get().error(TAG, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", Integer.valueOf(i)), th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0031  */
    public static ArrayList getPendingJobIds(Context context, JobScheduler jobScheduler, String str) {
        String string;
        ArrayList<JobInfo> pendingJobs = getPendingJobs(context, jobScheduler);
        if (pendingJobs == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
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
            if (str.equals(string)) {
                arrayList.add(Integer.valueOf(jobInfo.getId()));
            }
        }
        return arrayList;
    }

    public static ArrayList getPendingJobs(Context context, JobScheduler jobScheduler) {
        List<JobInfo> allPendingJobs;
        try {
            allPendingJobs = jobScheduler.getAllPendingJobs();
        } catch (Throwable th) {
            Logger$LogcatLogger.get().error(TAG, "getAllPendingJobs() is not reliable on this device.", th);
            allPendingJobs = null;
        }
        if (allPendingJobs == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(allPendingJobs.size());
        ComponentName componentName = new ComponentName(context, (Class<?>) SystemJobService.class);
        for (JobInfo jobInfo : allPendingJobs) {
            if (componentName.equals(jobInfo.getService())) {
                arrayList.add(jobInfo);
            }
        }
        return arrayList;
    }

    @Override // androidx.work.impl.Scheduler
    public final void cancel(String str) {
        Context context = this.mContext;
        JobScheduler jobScheduler = this.mJobScheduler;
        ArrayList pendingJobIds = getPendingJobIds(context, jobScheduler, str);
        if (pendingJobIds == null || pendingJobIds.isEmpty()) {
            return;
        }
        Iterator it = pendingJobIds.iterator();
        while (it.hasNext()) {
            cancelJobById(jobScheduler, ((Integer) it.next()).intValue());
        }
        this.mWorkManager.mWorkDatabase.systemIdInfoDao().removeSystemIdInfo(str);
    }

    @Override // androidx.work.impl.Scheduler
    public final boolean hasLimitedSchedulingSlots() {
        return true;
    }

    @Override // androidx.work.impl.Scheduler
    public final void schedule(WorkSpec... workSpecArr) {
        int iNextJobSchedulerIdWithRange;
        ArrayList pendingJobIds;
        int iNextJobSchedulerIdWithRange2;
        WorkManagerImpl workManagerImpl = this.mWorkManager;
        WorkDatabase workDatabase = workManagerImpl.mWorkDatabase;
        IdGenerator idGenerator = new IdGenerator(workDatabase);
        for (WorkSpec workSpec : workSpecArr) {
            workDatabase.beginTransaction();
            try {
                WorkSpec workSpec2 = workDatabase.workSpecDao().getWorkSpec(workSpec.id);
                String str = TAG;
                if (workSpec2 == null) {
                    Logger$LogcatLogger.get().warning(str, "Skipping scheduling " + workSpec.id + " because it's no longer in the DB", new Throwable[0]);
                    workDatabase.setTransactionSuccessful();
                } else if (workSpec2.state != 1) {
                    Logger$LogcatLogger.get().warning(str, "Skipping scheduling " + workSpec.id + " because it is no longer enqueued", new Throwable[0]);
                    workDatabase.setTransactionSuccessful();
                } else {
                    SystemIdInfo systemIdInfo = workDatabase.systemIdInfoDao().getSystemIdInfo(workSpec.id);
                    if (systemIdInfo != null) {
                        iNextJobSchedulerIdWithRange = systemIdInfo.systemId;
                    } else {
                        workManagerImpl.mConfiguration.getClass();
                        iNextJobSchedulerIdWithRange = idGenerator.nextJobSchedulerIdWithRange(workManagerImpl.mConfiguration.mMaxJobSchedulerId);
                    }
                    if (systemIdInfo == null) {
                        workManagerImpl.mWorkDatabase.systemIdInfoDao().insertSystemIdInfo(new SystemIdInfo(workSpec.id, iNextJobSchedulerIdWithRange));
                    }
                    scheduleInternal(workSpec, iNextJobSchedulerIdWithRange);
                    if (Build.VERSION.SDK_INT == 23 && (pendingJobIds = getPendingJobIds(this.mContext, this.mJobScheduler, workSpec.id)) != null) {
                        int iIndexOf = pendingJobIds.indexOf(Integer.valueOf(iNextJobSchedulerIdWithRange));
                        if (iIndexOf >= 0) {
                            pendingJobIds.remove(iIndexOf);
                        }
                        if (pendingJobIds.isEmpty()) {
                            workManagerImpl.mConfiguration.getClass();
                            iNextJobSchedulerIdWithRange2 = idGenerator.nextJobSchedulerIdWithRange(workManagerImpl.mConfiguration.mMaxJobSchedulerId);
                        } else {
                            iNextJobSchedulerIdWithRange2 = ((Integer) pendingJobIds.get(0)).intValue();
                        }
                        scheduleInternal(workSpec, iNextJobSchedulerIdWithRange2);
                    }
                    workDatabase.setTransactionSuccessful();
                }
                workDatabase.endTransaction();
            } catch (Throwable th) {
                workDatabase.endTransaction();
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0071, code lost:
    
        if (r11 < 26) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void scheduleInternal(androidx.work.impl.model.WorkSpec r19, int r20) {
        /*
            Method dump skipped, instruction units count: 545
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.background.systemjob.SystemJobScheduler.scheduleInternal(androidx.work.impl.model.WorkSpec, int):void");
    }
}
