package androidx.work.impl.workers;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomSQLiteQuery;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.Logger$LogcatLogger;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao_Impl;
import com.google.firebase.auth.zzaa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.text.StringsKt__IndentKt;
import okhttp3.MediaType;
import okhttp3.internal.concurrent.onZL.mnwSv;

/* JADX INFO: loaded from: classes2.dex */
public class DiagnosticsWorker extends Worker {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("DiagnosticsWrkr");

    public DiagnosticsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public static String workSpecRows(RoomOpenHelper roomOpenHelper, RoomOpenHelper roomOpenHelper2, zzaa zzaaVar, ArrayList arrayList) {
        String str;
        StringBuilder sb = new StringBuilder("\n Id \t Class Name\t Job Id\t State\t Unique Name\t Tags\t");
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            WorkSpec workSpec = (WorkSpec) it.next();
            SystemIdInfo systemIdInfo = zzaaVar.getSystemIdInfo(workSpec.id);
            Integer numValueOf = systemIdInfo != null ? Integer.valueOf(systemIdInfo.systemId) : null;
            String str2 = workSpec.id;
            roomOpenHelper.getClass();
            RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(1, "SELECT name FROM workname WHERE work_spec_id=?");
            if (str2 == null) {
                roomSQLiteQueryAcquire.bindNull(1);
            } else {
                roomSQLiteQueryAcquire.bindString(1, str2);
            }
            WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) roomOpenHelper.mConfiguration;
            workDatabase_Impl.assertNotSuspendingTransaction();
            Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
            try {
                ArrayList arrayList2 = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    arrayList2.add(cursorQuery.getString(0));
                }
                cursorQuery.close();
                roomSQLiteQueryAcquire.release();
                ArrayList tagsForWorkSpecId = roomOpenHelper2.getTagsForWorkSpecId(workSpec.id);
                String strJoin = TextUtils.join(",", arrayList2);
                String strJoin2 = TextUtils.join(",", tagsForWorkSpecId);
                String str3 = workSpec.id;
                String str4 = workSpec.workerClassName;
                switch (workSpec.state) {
                    case 1:
                        str = "ENQUEUED";
                        break;
                    case 2:
                        str = "RUNNING";
                        break;
                    case 3:
                        str = "SUCCEEDED";
                        break;
                    case 4:
                        str = "FAILED";
                        break;
                    case 5:
                        str = "BLOCKED";
                        break;
                    case 6:
                        str = "CANCELLED";
                        break;
                    default:
                        throw null;
                }
                StringBuilder sbM22m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m22m("\n", str3, "\t ", str4, "\t ");
                sbM22m.append(numValueOf);
                sbM22m.append("\t ");
                sbM22m.append(str);
                sbM22m.append("\t ");
                sbM22m.append(strJoin);
                sbM22m.append("\t ");
                sbM22m.append(strJoin2);
                sbM22m.append("\t");
                sb.append(sbM22m.toString());
            } catch (Throwable th) {
                cursorQuery.close();
                roomSQLiteQueryAcquire.release();
                throw th;
            }
        }
        return sb.toString();
    }

    @Override // androidx.work.Worker
    public final ListenableWorker.Result doWork() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        ArrayList arrayList;
        zzaa zzaaVar;
        RoomOpenHelper roomOpenHelper;
        RoomOpenHelper roomOpenHelper2;
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        WorkDatabase workDatabase = WorkManagerImpl.getInstance(getApplicationContext()).mWorkDatabase;
        WorkSpecDao_Impl workSpecDao_ImplWorkSpecDao = workDatabase.workSpecDao();
        RoomOpenHelper roomOpenHelperWorkNameDao = workDatabase.workNameDao();
        RoomOpenHelper roomOpenHelperWorkTagDao = workDatabase.workTagDao();
        zzaa zzaaVarSystemIdInfoDao = workDatabase.systemIdInfoDao();
        long jCurrentTimeMillis = System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1L);
        workSpecDao_ImplWorkSpecDao.getClass();
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(1, "SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE period_start_time >= ? AND state IN (2, 3, 5) ORDER BY period_start_time DESC");
        roomSQLiteQueryAcquire.bindLong(1, jCurrentTimeMillis);
        WorkDatabase_Impl workDatabase_Impl = workSpecDao_ImplWorkSpecDao.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
        try {
            int columnIndexOrThrow = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "required_network_type");
            int columnIndexOrThrow2 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "requires_charging");
            int columnIndexOrThrow3 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "requires_device_idle");
            int columnIndexOrThrow4 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "requires_battery_not_low");
            int columnIndexOrThrow5 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "requires_storage_not_low");
            int columnIndexOrThrow6 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "trigger_content_update_delay");
            int columnIndexOrThrow7 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "trigger_max_content_delay");
            int columnIndexOrThrow8 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "content_uri_triggers");
            int columnIndexOrThrow9 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow10 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "state");
            int columnIndexOrThrow11 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, mnwSv.VptV);
            int columnIndexOrThrow12 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "input_merger_class_name");
            int columnIndexOrThrow13 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "input");
            int columnIndexOrThrow14 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "output");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "initial_delay");
                int columnIndexOrThrow16 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "interval_duration");
                int columnIndexOrThrow17 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "flex_duration");
                int columnIndexOrThrow18 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "run_attempt_count");
                int columnIndexOrThrow19 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "backoff_policy");
                int columnIndexOrThrow20 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "backoff_delay_duration");
                int columnIndexOrThrow21 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "period_start_time");
                int columnIndexOrThrow22 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "minimum_retention_duration");
                int columnIndexOrThrow23 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "schedule_requested_at");
                int columnIndexOrThrow24 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "run_in_foreground");
                int columnIndexOrThrow25 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "out_of_quota_policy");
                int i2 = columnIndexOrThrow14;
                ArrayList arrayList2 = new ArrayList(cursorQuery.getCount());
                while (true) {
                    arrayList = arrayList2;
                    if (!cursorQuery.moveToNext()) {
                        break;
                    }
                    String string = cursorQuery.getString(columnIndexOrThrow9);
                    String string2 = cursorQuery.getString(columnIndexOrThrow11);
                    int i3 = columnIndexOrThrow11;
                    Constraints constraints = new Constraints();
                    int i4 = columnIndexOrThrow;
                    constraints.mRequiredNetworkType = StringsKt__IndentKt.intToNetworkType(cursorQuery.getInt(columnIndexOrThrow));
                    if (cursorQuery.getInt(columnIndexOrThrow2) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    constraints.mRequiresCharging = z;
                    if (cursorQuery.getInt(columnIndexOrThrow3) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    constraints.mRequiresDeviceIdle = z2;
                    if (cursorQuery.getInt(columnIndexOrThrow4) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    constraints.mRequiresBatteryNotLow = z3;
                    if (cursorQuery.getInt(columnIndexOrThrow5) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    constraints.mRequiresStorageNotLow = z4;
                    int i5 = columnIndexOrThrow2;
                    int i6 = columnIndexOrThrow3;
                    constraints.mTriggerContentUpdateDelay = cursorQuery.getLong(columnIndexOrThrow6);
                    constraints.mTriggerMaxContentDelay = cursorQuery.getLong(columnIndexOrThrow7);
                    constraints.mContentUriTriggers = StringsKt__IndentKt.byteArrayToContentUriTriggers(cursorQuery.getBlob(columnIndexOrThrow8));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = StringsKt__IndentKt.intToState(cursorQuery.getInt(columnIndexOrThrow10));
                    workSpec.inputMergerClassName = cursorQuery.getString(columnIndexOrThrow12);
                    workSpec.input = Data.fromByteArray(cursorQuery.getBlob(columnIndexOrThrow13));
                    int i7 = i2;
                    workSpec.output = Data.fromByteArray(cursorQuery.getBlob(i7));
                    i2 = i7;
                    int i8 = columnIndexOrThrow12;
                    int i9 = columnIndexOrThrow15;
                    workSpec.initialDelay = cursorQuery.getLong(i9);
                    int i10 = columnIndexOrThrow13;
                    int i11 = columnIndexOrThrow16;
                    workSpec.intervalDuration = cursorQuery.getLong(i11);
                    int i12 = columnIndexOrThrow17;
                    workSpec.flexDuration = cursorQuery.getLong(i12);
                    int i13 = columnIndexOrThrow18;
                    workSpec.runAttemptCount = cursorQuery.getInt(i13);
                    int i14 = columnIndexOrThrow19;
                    workSpec.backoffPolicy = StringsKt__IndentKt.intToBackoffPolicy(cursorQuery.getInt(i14));
                    columnIndexOrThrow17 = i12;
                    int i15 = columnIndexOrThrow20;
                    workSpec.backoffDelayDuration = cursorQuery.getLong(i15);
                    int i16 = columnIndexOrThrow21;
                    workSpec.periodStartTime = cursorQuery.getLong(i16);
                    columnIndexOrThrow21 = i16;
                    int i17 = columnIndexOrThrow22;
                    workSpec.minimumRetentionDuration = cursorQuery.getLong(i17);
                    int i18 = columnIndexOrThrow23;
                    workSpec.scheduleRequestedAt = cursorQuery.getLong(i18);
                    int i19 = columnIndexOrThrow24;
                    if (cursorQuery.getInt(i19) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    workSpec.expedited = z5;
                    int i20 = columnIndexOrThrow25;
                    workSpec.outOfQuotaPolicy = StringsKt__IndentKt.intToOutOfQuotaPolicy(cursorQuery.getInt(i20));
                    workSpec.constraints = constraints;
                    arrayList.add(workSpec);
                    columnIndexOrThrow25 = i20;
                    columnIndexOrThrow13 = i10;
                    columnIndexOrThrow15 = i9;
                    columnIndexOrThrow16 = i11;
                    columnIndexOrThrow2 = i5;
                    columnIndexOrThrow19 = i14;
                    columnIndexOrThrow18 = i13;
                    columnIndexOrThrow23 = i18;
                    columnIndexOrThrow24 = i19;
                    columnIndexOrThrow22 = i17;
                    columnIndexOrThrow20 = i15;
                    columnIndexOrThrow12 = i8;
                    columnIndexOrThrow3 = i6;
                    columnIndexOrThrow = i4;
                    arrayList2 = arrayList;
                    columnIndexOrThrow11 = i3;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                ArrayList runningWork = workSpecDao_ImplWorkSpecDao.getRunningWork();
                ArrayList allEligibleWorkSpecsForScheduling = workSpecDao_ImplWorkSpecDao.getAllEligibleWorkSpecsForScheduling();
                boolean zIsEmpty = arrayList.isEmpty();
                String str = TAG;
                if (!zIsEmpty) {
                    i = 0;
                    Logger$LogcatLogger.get().info(str, "Recently completed work:\n\n", new Throwable[0]);
                    zzaaVar = zzaaVarSystemIdInfoDao;
                    roomOpenHelper = roomOpenHelperWorkNameDao;
                    roomOpenHelper2 = roomOpenHelperWorkTagDao;
                    Logger$LogcatLogger.get().info(str, workSpecRows(roomOpenHelper, roomOpenHelper2, zzaaVar, arrayList), new Throwable[0]);
                } else {
                    zzaaVar = zzaaVarSystemIdInfoDao;
                    roomOpenHelper = roomOpenHelperWorkNameDao;
                    roomOpenHelper2 = roomOpenHelperWorkTagDao;
                    i = 0;
                }
                if (!runningWork.isEmpty()) {
                    Logger$LogcatLogger.get().info(str, "Running work:\n\n", new Throwable[i]);
                    Logger$LogcatLogger.get().info(str, workSpecRows(roomOpenHelper, roomOpenHelper2, zzaaVar, runningWork), new Throwable[i]);
                }
                if (!allEligibleWorkSpecsForScheduling.isEmpty()) {
                    Logger$LogcatLogger.get().info(str, "Enqueued work:\n\n", new Throwable[i]);
                    Logger$LogcatLogger.get().info(str, workSpecRows(roomOpenHelper, roomOpenHelper2, zzaaVar, allEligibleWorkSpecsForScheduling), new Throwable[i]);
                }
                return new ListenableWorker.Result.Success(Data.EMPTY);
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }
}
