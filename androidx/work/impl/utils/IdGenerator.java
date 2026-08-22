package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.Preference;

/* JADX INFO: loaded from: classes.dex */
public final class IdGenerator {
    public final WorkDatabase mWorkDatabase;

    public /* synthetic */ IdGenerator(WorkDatabase workDatabase) {
        this.mWorkDatabase = workDatabase;
    }

    public int nextJobSchedulerIdWithRange(int i) {
        int i2;
        synchronized (IdGenerator.class) {
            try {
                WorkDatabase workDatabase = this.mWorkDatabase;
                workDatabase.beginTransaction();
                try {
                    Long longValue = workDatabase.preferenceDao().getLongValue("next_job_scheduler_id");
                    i2 = 0;
                    int iIntValue = longValue != null ? longValue.intValue() : 0;
                    workDatabase.preferenceDao().insertPreference(new Preference("next_job_scheduler_id", iIntValue == Integer.MAX_VALUE ? 0 : iIntValue + 1));
                    workDatabase.setTransactionSuccessful();
                    workDatabase.endTransaction();
                    if (iIntValue < 0 || iIntValue > i) {
                        this.mWorkDatabase.preferenceDao().insertPreference(new Preference("next_job_scheduler_id", 1));
                    } else {
                        i2 = iIntValue;
                    }
                } catch (Throwable th) {
                    workDatabase.endTransaction();
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return i2;
    }
}
