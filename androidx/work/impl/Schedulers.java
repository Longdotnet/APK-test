package androidx.work.impl;

import android.os.Build;
import androidx.work.Configuration;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao_Impl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class Schedulers {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("Schedulers");

    public static void schedule(Configuration configuration, WorkDatabase workDatabase, List list) {
        if (list == null || list.size() == 0) {
            return;
        }
        WorkSpecDao_Impl workSpecDao_ImplWorkSpecDao = workDatabase.workSpecDao();
        workDatabase.beginTransaction();
        try {
            int i = Build.VERSION.SDK_INT;
            int i2 = configuration.mMaxSchedulerLimit;
            if (i == 23) {
                i2 /= 2;
            }
            ArrayList eligibleWorkForScheduling = workSpecDao_ImplWorkSpecDao.getEligibleWorkForScheduling(i2);
            ArrayList allEligibleWorkSpecsForScheduling = workSpecDao_ImplWorkSpecDao.getAllEligibleWorkSpecsForScheduling();
            if (eligibleWorkForScheduling.size() > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                Iterator it = eligibleWorkForScheduling.iterator();
                while (it.hasNext()) {
                    workSpecDao_ImplWorkSpecDao.markWorkSpecScheduled(jCurrentTimeMillis, ((WorkSpec) it.next()).id);
                }
            }
            workDatabase.setTransactionSuccessful();
            workDatabase.endTransaction();
            if (eligibleWorkForScheduling.size() > 0) {
                WorkSpec[] workSpecArr = (WorkSpec[]) eligibleWorkForScheduling.toArray(new WorkSpec[eligibleWorkForScheduling.size()]);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    Scheduler scheduler = (Scheduler) it2.next();
                    if (scheduler.hasLimitedSchedulingSlots()) {
                        scheduler.schedule(workSpecArr);
                    }
                }
            }
            if (allEligibleWorkSpecsForScheduling.size() > 0) {
                WorkSpec[] workSpecArr2 = (WorkSpec[]) allEligibleWorkSpecsForScheduling.toArray(new WorkSpec[allEligibleWorkSpecsForScheduling.size()]);
                Iterator it3 = list.iterator();
                while (it3.hasNext()) {
                    Scheduler scheduler2 = (Scheduler) it3.next();
                    if (!scheduler2.hasLimitedSchedulingSlots()) {
                        scheduler2.schedule(workSpecArr2);
                    }
                }
            }
        } catch (Throwable th) {
            workDatabase.endTransaction();
            throw th;
        }
    }
}
