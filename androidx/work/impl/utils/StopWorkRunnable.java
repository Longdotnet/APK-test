package androidx.work.impl.utils;

import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.Processor;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkSpecDao_Impl;
import com.google.android.gms.internal.common.Ko.TSDAbK;

/* JADX INFO: loaded from: classes2.dex */
public final class StopWorkRunnable implements Runnable {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("StopWorkRunnable");
    public final boolean mStopInForeground;
    public final WorkManagerImpl mWorkManagerImpl;
    public final String mWorkSpecId;

    public StopWorkRunnable(WorkManagerImpl workManagerImpl, String str, boolean z) {
        this.mWorkManagerImpl = workManagerImpl;
        this.mWorkSpecId = str;
        this.mStopInForeground = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zContainsKey;
        boolean zStopWork;
        String str = TSDAbK.eISodMwSQWEHa;
        WorkManagerImpl workManagerImpl = this.mWorkManagerImpl;
        WorkDatabase workDatabase = workManagerImpl.mWorkDatabase;
        Processor processor = workManagerImpl.mProcessor;
        WorkSpecDao_Impl workSpecDao_ImplWorkSpecDao = workDatabase.workSpecDao();
        workDatabase.beginTransaction();
        try {
            String str2 = this.mWorkSpecId;
            synchronized (processor.mLock) {
                zContainsKey = processor.mForegroundWorkMap.containsKey(str2);
            }
            if (this.mStopInForeground) {
                zStopWork = this.mWorkManagerImpl.mProcessor.stopForegroundWork(this.mWorkSpecId);
            } else {
                if (!zContainsKey && workSpecDao_ImplWorkSpecDao.getState(this.mWorkSpecId) == 2) {
                    workSpecDao_ImplWorkSpecDao.setState(1, this.mWorkSpecId);
                }
                zStopWork = this.mWorkManagerImpl.mProcessor.stopWork(this.mWorkSpecId);
            }
            Logger$LogcatLogger.get().debug(TAG, str + this.mWorkSpecId + "; Processor.stopWork = " + zStopWork, new Throwable[0]);
            workDatabase.setTransactionSuccessful();
            workDatabase.endTransaction();
        } catch (Throwable th) {
            workDatabase.endTransaction();
            throw th;
        }
    }
}
