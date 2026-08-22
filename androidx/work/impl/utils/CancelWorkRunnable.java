package androidx.work.impl.utils;

import androidx.room.RoomOpenHelper;
import androidx.work.Logger$LogcatLogger;
import androidx.work.Operation;
import androidx.work.Operation$State$FAILURE;
import androidx.work.impl.Processor;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.model.WorkSpecDao_Impl;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public abstract class CancelWorkRunnable implements Runnable {
    public final RoomOpenHelper mOperation = new RoomOpenHelper();

    /* JADX INFO: renamed from: androidx.work.impl.utils.CancelWorkRunnable$2, reason: invalid class name */
    public final class AnonymousClass2 extends CancelWorkRunnable {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ WorkManagerImpl val$workManagerImpl;

        public /* synthetic */ AnonymousClass2(WorkManagerImpl workManagerImpl, int i) {
            this.$r8$classId = i;
            this.val$workManagerImpl = workManagerImpl;
        }

        @Override // androidx.work.impl.utils.CancelWorkRunnable
        public final void runInternal() {
            switch (this.$r8$classId) {
                case 0:
                    WorkManagerImpl workManagerImpl = this.val$workManagerImpl;
                    WorkDatabase workDatabase = workManagerImpl.mWorkDatabase;
                    workDatabase.beginTransaction();
                    try {
                        Iterator it = workDatabase.workSpecDao().getUnfinishedWorkWithTag().iterator();
                        while (it.hasNext()) {
                            CancelWorkRunnable.cancel(workManagerImpl, (String) it.next());
                        }
                        workDatabase.setTransactionSuccessful();
                        workDatabase.endTransaction();
                        Schedulers.schedule(workManagerImpl.mConfiguration, workManagerImpl.mWorkDatabase, workManagerImpl.mSchedulers);
                        return;
                    } catch (Throwable th) {
                        workDatabase.endTransaction();
                        throw th;
                    }
                default:
                    WorkManagerImpl workManagerImpl2 = this.val$workManagerImpl;
                    WorkDatabase workDatabase2 = workManagerImpl2.mWorkDatabase;
                    workDatabase2.beginTransaction();
                    try {
                        Iterator it2 = workDatabase2.workSpecDao().getUnfinishedWorkWithName().iterator();
                        while (it2.hasNext()) {
                            CancelWorkRunnable.cancel(workManagerImpl2, (String) it2.next());
                        }
                        workDatabase2.setTransactionSuccessful();
                        return;
                    } finally {
                        workDatabase2.endTransaction();
                    }
            }
        }
    }

    public static void cancel(WorkManagerImpl workManagerImpl, String str) {
        WorkDatabase workDatabase = workManagerImpl.mWorkDatabase;
        WorkSpecDao_Impl workSpecDao_ImplWorkSpecDao = workDatabase.workSpecDao();
        RoomOpenHelper roomOpenHelperDependencyDao = workDatabase.dependencyDao();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            int state = workSpecDao_ImplWorkSpecDao.getState(str2);
            if (state != 3 && state != 4) {
                workSpecDao_ImplWorkSpecDao.setState(6, str2);
            }
            linkedList.addAll(roomOpenHelperDependencyDao.getDependentWorkIds(str2));
        }
        Processor processor = workManagerImpl.mProcessor;
        synchronized (processor.mLock) {
            try {
                Logger$LogcatLogger.get().debug(Processor.TAG, "Processor cancelling " + str, new Throwable[0]);
                processor.mCancelledIds.add(str);
                WorkerWrapper workerWrapper = (WorkerWrapper) processor.mForegroundWorkMap.remove(str);
                boolean z = workerWrapper != null;
                if (workerWrapper == null) {
                    workerWrapper = (WorkerWrapper) processor.mEnqueuedWorkMap.remove(str);
                }
                Processor.interrupt(str, workerWrapper);
                if (z) {
                    processor.stopForegroundService();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Iterator it = workManagerImpl.mSchedulers.iterator();
        while (it.hasNext()) {
            ((Scheduler) it.next()).cancel(str);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        RoomOpenHelper roomOpenHelper = this.mOperation;
        try {
            runInternal();
            roomOpenHelper.setState(Operation.SUCCESS);
        } catch (Throwable th) {
            roomOpenHelper.setState(new Operation$State$FAILURE(th));
        }
    }

    public abstract void runInternal();
}
