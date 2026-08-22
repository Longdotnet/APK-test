package androidx.work.impl.utils;

import android.database.Cursor;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.internal.view.Oteb.nYVxXTZQ;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger$LogcatLogger;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.Operation$State$FAILURE;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.model.Dependency;
import androidx.work.impl.model.WorkName;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTag;
import androidx.work.impl.model.WorkTagDao_Impl$1;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import com.facebook.ProfileCache;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;
import kotlin.text.StringsKt__IndentKt;
import okhttp3.MediaType;

/* JADX INFO: loaded from: classes2.dex */
public final class EnqueueRunnable implements Runnable {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("EnqueueRunnable");
    public final RoomOpenHelper mOperation = new RoomOpenHelper();
    public final WorkContinuationImpl mWorkContinuation;

    public EnqueueRunnable(WorkContinuationImpl workContinuationImpl) {
        this.mWorkContinuation = workContinuationImpl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RoomOpenHelper roomOpenHelper = this.mOperation;
        WorkContinuationImpl workContinuationImpl = this.mWorkContinuation;
        try {
            if (WorkContinuationImpl.hasCycles(workContinuationImpl, new HashSet())) {
                throw new IllegalStateException("WorkContinuation has cycles (" + workContinuationImpl + ")");
            }
            WorkManagerImpl workManagerImpl = workContinuationImpl.mWorkManagerImpl;
            WorkDatabase workDatabase = workManagerImpl.mWorkDatabase;
            workDatabase.beginTransaction();
            try {
                boolean zProcessContinuation = processContinuation(workContinuationImpl);
                workDatabase.setTransactionSuccessful();
                workDatabase.endTransaction();
                if (zProcessContinuation) {
                    PackageManagerHelper.setComponentEnabled(workManagerImpl.mContext, RescheduleReceiver.class, true);
                    Schedulers.schedule(workManagerImpl.mConfiguration, workManagerImpl.mWorkDatabase, workManagerImpl.mSchedulers);
                }
                roomOpenHelper.setState(Operation.SUCCESS);
            } catch (Throwable th) {
                workDatabase.endTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            roomOpenHelper.setState(new Operation$State$FAILURE(th2));
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:108:0x022e  */
    /* JADX WARN: Code duplicated, block: B:112:0x0240  */
    /* JADX WARN: Code duplicated, block: B:119:0x0272  */
    /* JADX WARN: Code duplicated, block: B:156:0x029c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x0155  */
    /* JADX WARN: Code duplicated, block: B:79:0x0174  */
    /* JADX WARN: Code duplicated, block: B:81:0x017c  */
    /* JADX WARN: Code duplicated, block: B:82:0x017f  */
    /* JADX WARN: Code duplicated, block: B:85:0x0189  */
    /* JADX WARN: Code duplicated, block: B:94:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:99:0x01ed  */
    public static boolean processContinuation(WorkContinuationImpl workContinuationImpl) throws Throwable {
        boolean z;
        boolean z2;
        boolean z3;
        String[] strArr;
        boolean z4;
        boolean z5;
        Iterator it;
        boolean z6;
        WorkSpec workSpec;
        WorkDatabase_Impl workDatabase_Impl;
        UUID uuid;
        Iterator it2;
        long j;
        String[] strArr2;
        WorkDatabase_Impl workDatabase_Impl2;
        WorkDatabase_Impl workDatabase_Impl3;
        int length;
        int i;
        WorkDatabase_Impl workDatabase_Impl4;
        String str;
        boolean z7;
        boolean z8 = false;
        String[] strArr3 = (String[]) WorkContinuationImpl.prerequisitesFor(workContinuationImpl).toArray(new String[0]);
        long jCurrentTimeMillis = System.currentTimeMillis();
        WorkManagerImpl workManagerImpl = workContinuationImpl.mWorkManagerImpl;
        WorkDatabase workDatabase = workManagerImpl.mWorkDatabase;
        boolean z9 = strArr3 != null && strArr3.length > 0;
        if (z9) {
            int length2 = strArr3.length;
            int i2 = 0;
            z = false;
            z2 = false;
            z3 = true;
            while (true) {
                if (i2 < length2) {
                    String str2 = strArr3[i2];
                    WorkSpec workSpec2 = workDatabase.workSpecDao().getWorkSpec(str2);
                    if (workSpec2 == null) {
                        Logger$LogcatLogger.get().error(TAG, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Prerequisite ", str2, " doesn't exist; not enqueuing"), new Throwable[0]);
                    } else {
                        int i3 = workSpec2.state;
                        z3 &= i3 == 3;
                        if (i3 == 4) {
                            z2 = true;
                        } else if (i3 == 6) {
                            z = true;
                        }
                        i2++;
                    }
                }
                z7 = true;
                workContinuationImpl.mEnqueued = z7;
                return z8;
            }
        }
        z = false;
        z2 = false;
        z3 = true;
        boolean zIsEmpty = TextUtils.isEmpty(null);
        if (!zIsEmpty && !z9) {
            WorkSpecDao_Impl workSpecDao_ImplWorkSpecDao = workDatabase.workSpecDao();
            workSpecDao_ImplWorkSpecDao.getClass();
            RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(1, "SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)");
            roomSQLiteQueryAcquire.bindNull(1);
            WorkDatabase_Impl workDatabase_Impl5 = workSpecDao_ImplWorkSpecDao.__db;
            workDatabase_Impl5.assertNotSuspendingTransaction();
            Cursor cursorQuery = workDatabase_Impl5.query(roomSQLiteQueryAcquire);
            try {
                int columnIndexOrThrow = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, nYVxXTZQ.xmrNTce);
                int columnIndexOrThrow2 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "state");
                z4 = zIsEmpty;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    WorkSpec.IdAndState idAndState = new WorkSpec.IdAndState();
                    String[] strArr4 = strArr3;
                    idAndState.id = cursorQuery.getString(columnIndexOrThrow);
                    idAndState.state = StringsKt__IndentKt.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                    arrayList.add(idAndState);
                    strArr3 = strArr4;
                }
                strArr = strArr3;
                cursorQuery.close();
                roomSQLiteQueryAcquire.release();
                if (!arrayList.isEmpty()) {
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        int i4 = ((WorkSpec.IdAndState) it3.next()).state;
                        if (i4 == 1 || i4 == 2) {
                            z7 = true;
                            z8 = false;
                            workContinuationImpl.mEnqueued = z7;
                            return z8;
                        }
                    }
                    new CancelWorkRunnable.AnonymousClass2(workManagerImpl, 1).run();
                    WorkSpecDao_Impl workSpecDao_ImplWorkSpecDao2 = workDatabase.workSpecDao();
                    Iterator it4 = arrayList.iterator();
                    while (it4.hasNext()) {
                        String str3 = ((WorkSpec.IdAndState) it4.next()).id;
                        WorkDatabase_Impl workDatabase_Impl6 = workSpecDao_ImplWorkSpecDao2.__db;
                        workDatabase_Impl6.assertNotSuspendingTransaction();
                        WorkSpecDao_Impl.AnonymousClass2 anonymousClass2 = workSpecDao_ImplWorkSpecDao2.__preparedStmtOfDelete;
                        FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = anonymousClass2.acquire();
                        if (str3 == null) {
                            frameworkSQLiteStatementAcquire.bindNull(1);
                        } else {
                            frameworkSQLiteStatementAcquire.bindString(1, str3);
                        }
                        workDatabase_Impl6.beginTransaction();
                        try {
                            frameworkSQLiteStatementAcquire.executeUpdateDelete();
                            workDatabase_Impl6.setTransactionSuccessful();
                            workDatabase_Impl6.endTransaction();
                            anonymousClass2.release(frameworkSQLiteStatementAcquire);
                        } catch (Throwable th) {
                            workDatabase_Impl6.endTransaction();
                            anonymousClass2.release(frameworkSQLiteStatementAcquire);
                            throw th;
                        }
                    }
                    z5 = true;
                }
                it = workContinuationImpl.mWork.iterator();
                z6 = z5;
                while (it.hasNext()) {
                    OneTimeWorkRequest oneTimeWorkRequest = (OneTimeWorkRequest) it.next();
                    workSpec = oneTimeWorkRequest.mWorkSpec;
                    if (z9 || z3) {
                        if (workSpec.isPeriodic()) {
                            workSpec.periodStartTime = 0L;
                        } else {
                            workSpec.periodStartTime = jCurrentTimeMillis;
                        }
                    } else if (z2) {
                        workSpec.state = 4;
                    } else if (z) {
                        workSpec.state = 6;
                    } else {
                        workSpec.state = 5;
                    }
                    if (Build.VERSION.SDK_INT <= 25) {
                        Constraints constraints = workSpec.constraints;
                        str = workSpec.workerClassName;
                        if (!str.equals(ConstraintTrackingWorker.class.getName()) && (constraints.mRequiresBatteryNotLow || constraints.mRequiresStorageNotLow)) {
                            ProfileCache profileCache = new ProfileCache(15);
                            profileCache.putAll(workSpec.input.mValues);
                            ((HashMap) profileCache.sharedPreferences).put("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME", str);
                            workSpec.workerClassName = ConstraintTrackingWorker.class.getName();
                            Data data = new Data((HashMap) profileCache.sharedPreferences);
                            Data.toByteArrayInternal(data);
                            workSpec.input = data;
                        }
                    }
                    if (workSpec.state == 1) {
                        z6 = true;
                    }
                    WorkSpecDao_Impl workSpecDao_ImplWorkSpecDao3 = workDatabase.workSpecDao();
                    workDatabase_Impl = workSpecDao_ImplWorkSpecDao3.__db;
                    workDatabase_Impl.assertNotSuspendingTransaction();
                    workDatabase_Impl.beginTransaction();
                    try {
                        workSpecDao_ImplWorkSpecDao3.__insertionAdapterOfWorkSpec.insert(workSpec);
                        workDatabase_Impl.setTransactionSuccessful();
                        workDatabase_Impl.endTransaction();
                        uuid = oneTimeWorkRequest.mId;
                        if (z9) {
                            strArr2 = strArr;
                            length = strArr2.length;
                            i = 0;
                            while (i < length) {
                                Iterator it5 = it;
                                long j2 = jCurrentTimeMillis;
                                Dependency dependency = new Dependency(uuid.toString(), strArr2[i]);
                                RoomOpenHelper roomOpenHelperDependencyDao = workDatabase.dependencyDao();
                                workDatabase_Impl4 = (WorkDatabase_Impl) roomOpenHelperDependencyDao.mConfiguration;
                                workDatabase_Impl4.assertNotSuspendingTransaction();
                                workDatabase_Impl4.beginTransaction();
                                try {
                                    ((WorkTagDao_Impl$1) roomOpenHelperDependencyDao.mDelegate).insert(dependency);
                                    workDatabase_Impl4.setTransactionSuccessful();
                                    workDatabase_Impl4.endTransaction();
                                    i++;
                                    it = it5;
                                    jCurrentTimeMillis = j2;
                                } catch (Throwable th2) {
                                    workDatabase_Impl4.endTransaction();
                                    throw th2;
                                }
                            }
                            it2 = it;
                            j = jCurrentTimeMillis;
                        } else {
                            it2 = it;
                            j = jCurrentTimeMillis;
                            strArr2 = strArr;
                        }
                        for (String str4 : oneTimeWorkRequest.mTags) {
                            RoomOpenHelper roomOpenHelperWorkTagDao = workDatabase.workTagDao();
                            WorkTag workTag = new WorkTag(str4, uuid.toString());
                            workDatabase_Impl3 = (WorkDatabase_Impl) roomOpenHelperWorkTagDao.mConfiguration;
                            workDatabase_Impl3.assertNotSuspendingTransaction();
                            workDatabase_Impl3.beginTransaction();
                            try {
                                ((WorkTagDao_Impl$1) roomOpenHelperWorkTagDao.mDelegate).insert(workTag);
                                workDatabase_Impl3.setTransactionSuccessful();
                                workDatabase_Impl3.endTransaction();
                            } catch (Throwable th3) {
                                workDatabase_Impl3.endTransaction();
                                throw th3;
                            }
                        }
                        if (!z4) {
                            RoomOpenHelper roomOpenHelperWorkNameDao = workDatabase.workNameDao();
                            WorkName workName = new WorkName(uuid.toString());
                            workDatabase_Impl2 = (WorkDatabase_Impl) roomOpenHelperWorkNameDao.mConfiguration;
                            workDatabase_Impl2.assertNotSuspendingTransaction();
                            workDatabase_Impl2.beginTransaction();
                            try {
                                ((WorkTagDao_Impl$1) roomOpenHelperWorkNameDao.mDelegate).insert(workName);
                                workDatabase_Impl2.setTransactionSuccessful();
                                workDatabase_Impl2.endTransaction();
                            } catch (Throwable th4) {
                                workDatabase_Impl2.endTransaction();
                                throw th4;
                            }
                        }
                        strArr = strArr2;
                        it = it2;
                        jCurrentTimeMillis = j;
                    } catch (Throwable th5) {
                        workDatabase_Impl.endTransaction();
                        throw th5;
                    }
                }
                z8 = z6;
                z7 = true;
                workContinuationImpl.mEnqueued = z7;
                return z8;
            } catch (Throwable th6) {
                cursorQuery.close();
                roomSQLiteQueryAcquire.release();
                throw th6;
            }
        }
        strArr = strArr3;
        z4 = zIsEmpty;
        z5 = false;
        it = workContinuationImpl.mWork.iterator();
        z6 = z5;
        while (it.hasNext()) {
            OneTimeWorkRequest oneTimeWorkRequest2 = (OneTimeWorkRequest) it.next();
            workSpec = oneTimeWorkRequest2.mWorkSpec;
            if (z9) {
                if (workSpec.isPeriodic()) {
                    workSpec.periodStartTime = jCurrentTimeMillis;
                } else {
                    workSpec.periodStartTime = 0L;
                }
            } else if (workSpec.isPeriodic()) {
                workSpec.periodStartTime = jCurrentTimeMillis;
            } else {
                workSpec.periodStartTime = 0L;
            }
            if (Build.VERSION.SDK_INT <= 25) {
                Constraints constraints2 = workSpec.constraints;
                str = workSpec.workerClassName;
                if (!str.equals(ConstraintTrackingWorker.class.getName())) {
                    ProfileCache profileCache2 = new ProfileCache(15);
                    profileCache2.putAll(workSpec.input.mValues);
                    ((HashMap) profileCache2.sharedPreferences).put("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME", str);
                    workSpec.workerClassName = ConstraintTrackingWorker.class.getName();
                    Data data2 = new Data((HashMap) profileCache2.sharedPreferences);
                    Data.toByteArrayInternal(data2);
                    workSpec.input = data2;
                }
            }
            if (workSpec.state == 1) {
                z6 = true;
            }
            WorkSpecDao_Impl workSpecDao_ImplWorkSpecDao4 = workDatabase.workSpecDao();
            workDatabase_Impl = workSpecDao_ImplWorkSpecDao4.__db;
            workDatabase_Impl.assertNotSuspendingTransaction();
            workDatabase_Impl.beginTransaction();
            workSpecDao_ImplWorkSpecDao4.__insertionAdapterOfWorkSpec.insert(workSpec);
            workDatabase_Impl.setTransactionSuccessful();
            workDatabase_Impl.endTransaction();
            uuid = oneTimeWorkRequest2.mId;
            if (z9) {
                strArr2 = strArr;
                length = strArr2.length;
                i = 0;
                while (i < length) {
                    Iterator it6 = it;
                    long j3 = jCurrentTimeMillis;
                    Dependency dependency2 = new Dependency(uuid.toString(), strArr2[i]);
                    RoomOpenHelper roomOpenHelperDependencyDao2 = workDatabase.dependencyDao();
                    workDatabase_Impl4 = (WorkDatabase_Impl) roomOpenHelperDependencyDao2.mConfiguration;
                    workDatabase_Impl4.assertNotSuspendingTransaction();
                    workDatabase_Impl4.beginTransaction();
                    ((WorkTagDao_Impl$1) roomOpenHelperDependencyDao2.mDelegate).insert(dependency2);
                    workDatabase_Impl4.setTransactionSuccessful();
                    workDatabase_Impl4.endTransaction();
                    i++;
                    it = it6;
                    jCurrentTimeMillis = j3;
                }
                it2 = it;
                j = jCurrentTimeMillis;
            } else {
                it2 = it;
                j = jCurrentTimeMillis;
                strArr2 = strArr;
            }
            while (r1.hasNext()) {
                RoomOpenHelper roomOpenHelperWorkTagDao2 = workDatabase.workTagDao();
                WorkTag workTag2 = new WorkTag(str4, uuid.toString());
                workDatabase_Impl3 = (WorkDatabase_Impl) roomOpenHelperWorkTagDao2.mConfiguration;
                workDatabase_Impl3.assertNotSuspendingTransaction();
                workDatabase_Impl3.beginTransaction();
                ((WorkTagDao_Impl$1) roomOpenHelperWorkTagDao2.mDelegate).insert(workTag2);
                workDatabase_Impl3.setTransactionSuccessful();
                workDatabase_Impl3.endTransaction();
            }
            if (!z4) {
                RoomOpenHelper roomOpenHelperWorkNameDao2 = workDatabase.workNameDao();
                WorkName workName2 = new WorkName(uuid.toString());
                workDatabase_Impl2 = (WorkDatabase_Impl) roomOpenHelperWorkNameDao2.mConfiguration;
                workDatabase_Impl2.assertNotSuspendingTransaction();
                workDatabase_Impl2.beginTransaction();
                ((WorkTagDao_Impl$1) roomOpenHelperWorkNameDao2.mDelegate).insert(workName2);
                workDatabase_Impl2.setTransactionSuccessful();
                workDatabase_Impl2.endTransaction();
            }
            strArr = strArr2;
            it = it2;
            jCurrentTimeMillis = j;
        }
        z8 = z6;
        z7 = true;
        workContinuationImpl.mEnqueued = z7;
        return z8;
    }
}
