package androidx.work.impl.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import androidx.lifecycle.hSi.sgtsHsWT;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.impl.WorkDatabase_Impl;
import com.facebook.login.vu.dLDI;
import com.google.android.gms.ads.internal.offline.buffering.Dk.eoBKjVuj;
import com.google.android.gms.games.snapshot.Xa.JrbhsraGtto;
import com.google.android.gms.measurement.internal.RVw.ZRqOdXiy;
import com.google.gson.yWTz.kBfGXgdfpo;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.text.StringsKt__IndentKt;
import okhttp3.MediaType;

/* JADX INFO: loaded from: classes2.dex */
public final class WorkSpecDao_Impl {
    public final WorkDatabase_Impl __db;
    public final WorkTagDao_Impl$1 __insertionAdapterOfWorkSpec;
    public final AnonymousClass2 __preparedStmtOfDelete;
    public final AnonymousClass2 __preparedStmtOfIncrementWorkSpecRunAttemptCount;
    public final AnonymousClass2 __preparedStmtOfMarkWorkSpecScheduled;
    public final AnonymousClass2 __preparedStmtOfResetScheduledState;
    public final AnonymousClass2 __preparedStmtOfResetWorkSpecRunAttemptCount;
    public final AnonymousClass2 __preparedStmtOfSetOutput;
    public final AnonymousClass2 __preparedStmtOfSetPeriodStartTime;

    /* JADX INFO: renamed from: androidx.work.impl.model.WorkSpecDao_Impl$2 */
    public final class AnonymousClass2 extends SharedSQLiteStatement {
        public final /* synthetic */ int $r8$classId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass2(RoomDatabase roomDatabase, int i) {
            super(roomDatabase);
            this.$r8$classId = i;
        }

        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            switch (this.$r8$classId) {
                case 0:
                    return "DELETE FROM workspec WHERE id=?";
                case 1:
                    return "DELETE FROM SystemIdInfo where work_spec_id=?";
                case 2:
                    return "DELETE from WorkProgress where work_spec_id=?";
                case 3:
                    return "DELETE FROM WorkProgress";
                case 4:
                    return "UPDATE workspec SET output=? WHERE id=?";
                case 5:
                    return "UPDATE workspec SET period_start_time=? WHERE id=?";
                case 6:
                    return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
                case 7:
                    return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
                case 8:
                    return JrbhsraGtto.DSzoDGuCcgXNAR;
                default:
                    return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
            }
        }
    }

    public WorkSpecDao_Impl(WorkDatabase_Impl workDatabase_Impl) {
        this.__db = workDatabase_Impl;
        this.__insertionAdapterOfWorkSpec = new WorkTagDao_Impl$1(workDatabase_Impl, 6);
        this.__preparedStmtOfDelete = new AnonymousClass2(workDatabase_Impl, 0);
        this.__preparedStmtOfSetOutput = new AnonymousClass2(workDatabase_Impl, 4);
        this.__preparedStmtOfSetPeriodStartTime = new AnonymousClass2(workDatabase_Impl, 5);
        this.__preparedStmtOfIncrementWorkSpecRunAttemptCount = new AnonymousClass2(workDatabase_Impl, 6);
        this.__preparedStmtOfResetWorkSpecRunAttemptCount = new AnonymousClass2(workDatabase_Impl, 7);
        this.__preparedStmtOfMarkWorkSpecScheduled = new AnonymousClass2(workDatabase_Impl, 8);
        this.__preparedStmtOfResetScheduledState = new AnonymousClass2(workDatabase_Impl, 9);
        new AtomicBoolean(false);
    }

    public final ArrayList getRunningWork() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(0, "SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=1");
        WorkDatabase_Impl workDatabase_Impl = this.__db;
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
            int columnIndexOrThrow11 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "worker_class_name");
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
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(columnIndexOrThrow9);
                    int i2 = columnIndexOrThrow9;
                    String string2 = cursorQuery.getString(columnIndexOrThrow11);
                    int i3 = columnIndexOrThrow11;
                    Constraints constraints = new Constraints();
                    int i4 = columnIndexOrThrow;
                    constraints.mRequiredNetworkType = StringsKt__IndentKt.intToNetworkType(cursorQuery.getInt(columnIndexOrThrow));
                    constraints.mRequiresCharging = cursorQuery.getInt(columnIndexOrThrow2) != 0;
                    constraints.mRequiresDeviceIdle = cursorQuery.getInt(columnIndexOrThrow3) != 0;
                    constraints.mRequiresBatteryNotLow = cursorQuery.getInt(columnIndexOrThrow4) != 0;
                    constraints.mRequiresStorageNotLow = cursorQuery.getInt(columnIndexOrThrow5) != 0;
                    int i5 = columnIndexOrThrow2;
                    int i6 = columnIndexOrThrow3;
                    constraints.mTriggerContentUpdateDelay = cursorQuery.getLong(columnIndexOrThrow6);
                    constraints.mTriggerMaxContentDelay = cursorQuery.getLong(columnIndexOrThrow7);
                    constraints.mContentUriTriggers = StringsKt__IndentKt.byteArrayToContentUriTriggers(cursorQuery.getBlob(columnIndexOrThrow8));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = StringsKt__IndentKt.intToState(cursorQuery.getInt(columnIndexOrThrow10));
                    workSpec.inputMergerClassName = cursorQuery.getString(columnIndexOrThrow12);
                    workSpec.input = Data.fromByteArray(cursorQuery.getBlob(columnIndexOrThrow13));
                    int i7 = i;
                    workSpec.output = Data.fromByteArray(cursorQuery.getBlob(i7));
                    int i8 = columnIndexOrThrow13;
                    int i9 = columnIndexOrThrow15;
                    workSpec.initialDelay = cursorQuery.getLong(i9);
                    int i10 = columnIndexOrThrow4;
                    int i11 = columnIndexOrThrow16;
                    workSpec.intervalDuration = cursorQuery.getLong(i11);
                    int i12 = columnIndexOrThrow17;
                    workSpec.flexDuration = cursorQuery.getLong(i12);
                    int i13 = columnIndexOrThrow18;
                    workSpec.runAttemptCount = cursorQuery.getInt(i13);
                    int i14 = columnIndexOrThrow19;
                    workSpec.backoffPolicy = StringsKt__IndentKt.intToBackoffPolicy(cursorQuery.getInt(i14));
                    int i15 = columnIndexOrThrow20;
                    workSpec.backoffDelayDuration = cursorQuery.getLong(i15);
                    int i16 = columnIndexOrThrow21;
                    workSpec.periodStartTime = cursorQuery.getLong(i16);
                    int i17 = columnIndexOrThrow22;
                    workSpec.minimumRetentionDuration = cursorQuery.getLong(i17);
                    int i18 = columnIndexOrThrow23;
                    workSpec.scheduleRequestedAt = cursorQuery.getLong(i18);
                    int i19 = columnIndexOrThrow24;
                    workSpec.expedited = cursorQuery.getInt(i19) != 0;
                    int i20 = columnIndexOrThrow25;
                    workSpec.outOfQuotaPolicy = StringsKt__IndentKt.intToOutOfQuotaPolicy(cursorQuery.getInt(i20));
                    workSpec.constraints = constraints;
                    arrayList.add(workSpec);
                    i = i7;
                    columnIndexOrThrow2 = i5;
                    columnIndexOrThrow15 = i9;
                    columnIndexOrThrow16 = i11;
                    columnIndexOrThrow20 = i15;
                    columnIndexOrThrow21 = i16;
                    columnIndexOrThrow24 = i19;
                    columnIndexOrThrow11 = i3;
                    columnIndexOrThrow = i4;
                    columnIndexOrThrow25 = i20;
                    columnIndexOrThrow23 = i18;
                    columnIndexOrThrow13 = i8;
                    columnIndexOrThrow9 = i2;
                    columnIndexOrThrow3 = i6;
                    columnIndexOrThrow22 = i17;
                    columnIndexOrThrow4 = i10;
                    columnIndexOrThrow17 = i12;
                    columnIndexOrThrow18 = i13;
                    columnIndexOrThrow19 = i14;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
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

    public final ArrayList getUnfinishedWorkWithName() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(1, "SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)");
        roomSQLiteQueryAcquire.bindNull(1);
        WorkDatabase_Impl workDatabase_Impl = this.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.getString(0));
            }
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            return arrayList;
        } catch (Throwable th) {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            throw th;
        }
    }

    public final ArrayList getUnfinishedWorkWithTag() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(1, "SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)");
        roomSQLiteQueryAcquire.bindString(1, "offline_ping_sender_work");
        WorkDatabase_Impl workDatabase_Impl = this.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.getString(0));
            }
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            return arrayList;
        } catch (Throwable th) {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            throw th;
        }
    }

    public final WorkSpec getWorkSpec(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        WorkSpec workSpec;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(1, "SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE id=?");
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        WorkDatabase_Impl workDatabase_Impl = this.__db;
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
            int columnIndexOrThrow11 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "worker_class_name");
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
                if (cursorQuery.moveToFirst()) {
                    String string = cursorQuery.getString(columnIndexOrThrow9);
                    String string2 = cursorQuery.getString(columnIndexOrThrow11);
                    Constraints constraints = new Constraints();
                    constraints.mRequiredNetworkType = StringsKt__IndentKt.intToNetworkType(cursorQuery.getInt(columnIndexOrThrow));
                    constraints.mRequiresCharging = cursorQuery.getInt(columnIndexOrThrow2) != 0;
                    constraints.mRequiresDeviceIdle = cursorQuery.getInt(columnIndexOrThrow3) != 0;
                    constraints.mRequiresBatteryNotLow = cursorQuery.getInt(columnIndexOrThrow4) != 0;
                    constraints.mRequiresStorageNotLow = cursorQuery.getInt(columnIndexOrThrow5) != 0;
                    constraints.mTriggerContentUpdateDelay = cursorQuery.getLong(columnIndexOrThrow6);
                    constraints.mTriggerMaxContentDelay = cursorQuery.getLong(columnIndexOrThrow7);
                    constraints.mContentUriTriggers = StringsKt__IndentKt.byteArrayToContentUriTriggers(cursorQuery.getBlob(columnIndexOrThrow8));
                    workSpec = new WorkSpec(string, string2);
                    workSpec.state = StringsKt__IndentKt.intToState(cursorQuery.getInt(columnIndexOrThrow10));
                    workSpec.inputMergerClassName = cursorQuery.getString(columnIndexOrThrow12);
                    workSpec.input = Data.fromByteArray(cursorQuery.getBlob(columnIndexOrThrow13));
                    workSpec.output = Data.fromByteArray(cursorQuery.getBlob(columnIndexOrThrow14));
                    workSpec.initialDelay = cursorQuery.getLong(columnIndexOrThrow15);
                    workSpec.intervalDuration = cursorQuery.getLong(columnIndexOrThrow16);
                    workSpec.flexDuration = cursorQuery.getLong(columnIndexOrThrow17);
                    workSpec.runAttemptCount = cursorQuery.getInt(columnIndexOrThrow18);
                    workSpec.backoffPolicy = StringsKt__IndentKt.intToBackoffPolicy(cursorQuery.getInt(columnIndexOrThrow19));
                    workSpec.backoffDelayDuration = cursorQuery.getLong(columnIndexOrThrow20);
                    workSpec.periodStartTime = cursorQuery.getLong(columnIndexOrThrow21);
                    workSpec.minimumRetentionDuration = cursorQuery.getLong(columnIndexOrThrow22);
                    workSpec.scheduleRequestedAt = cursorQuery.getLong(columnIndexOrThrow23);
                    workSpec.expedited = cursorQuery.getInt(columnIndexOrThrow24) != 0;
                    workSpec.outOfQuotaPolicy = StringsKt__IndentKt.intToOutOfQuotaPolicy(cursorQuery.getInt(columnIndexOrThrow25));
                    workSpec.constraints = constraints;
                } else {
                    workSpec = null;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return workSpec;
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

    public final void incrementWorkSpecRunAttemptCount(String str) {
        WorkDatabase_Impl workDatabase_Impl = this.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        AnonymousClass2 anonymousClass2 = this.__preparedStmtOfIncrementWorkSpecRunAttemptCount;
        FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = anonymousClass2.acquire();
        if (str == null) {
            frameworkSQLiteStatementAcquire.bindNull(1);
        } else {
            frameworkSQLiteStatementAcquire.bindString(1, str);
        }
        workDatabase_Impl.beginTransaction();
        try {
            frameworkSQLiteStatementAcquire.mDelegate.executeUpdateDelete();
            workDatabase_Impl.setTransactionSuccessful();
        } finally {
            workDatabase_Impl.endTransaction();
            anonymousClass2.release(frameworkSQLiteStatementAcquire);
        }
    }

    public final void markWorkSpecScheduled(long j, String str) {
        WorkDatabase_Impl workDatabase_Impl = this.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        AnonymousClass2 anonymousClass2 = this.__preparedStmtOfMarkWorkSpecScheduled;
        FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = anonymousClass2.acquire();
        frameworkSQLiteStatementAcquire.bindLong(1, j);
        if (str == null) {
            frameworkSQLiteStatementAcquire.bindNull(2);
        } else {
            frameworkSQLiteStatementAcquire.bindString(2, str);
        }
        workDatabase_Impl.beginTransaction();
        try {
            frameworkSQLiteStatementAcquire.mDelegate.executeUpdateDelete();
            workDatabase_Impl.setTransactionSuccessful();
        } finally {
            workDatabase_Impl.endTransaction();
            anonymousClass2.release(frameworkSQLiteStatementAcquire);
        }
    }

    public final void resetWorkSpecRunAttemptCount(String str) {
        WorkDatabase_Impl workDatabase_Impl = this.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        AnonymousClass2 anonymousClass2 = this.__preparedStmtOfResetWorkSpecRunAttemptCount;
        FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = anonymousClass2.acquire();
        if (str == null) {
            frameworkSQLiteStatementAcquire.bindNull(1);
        } else {
            frameworkSQLiteStatementAcquire.bindString(1, str);
        }
        workDatabase_Impl.beginTransaction();
        try {
            frameworkSQLiteStatementAcquire.mDelegate.executeUpdateDelete();
            workDatabase_Impl.setTransactionSuccessful();
        } finally {
            workDatabase_Impl.endTransaction();
            anonymousClass2.release(frameworkSQLiteStatementAcquire);
        }
    }

    public final void setOutput(String str, Data data) throws Throwable {
        WorkDatabase_Impl workDatabase_Impl = this.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        AnonymousClass2 anonymousClass2 = this.__preparedStmtOfSetOutput;
        FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = anonymousClass2.acquire();
        byte[] byteArrayInternal = Data.toByteArrayInternal(data);
        if (byteArrayInternal == null) {
            frameworkSQLiteStatementAcquire.bindNull(1);
        } else {
            frameworkSQLiteStatementAcquire.bindBlob(1, byteArrayInternal);
        }
        if (str == null) {
            frameworkSQLiteStatementAcquire.bindNull(2);
        } else {
            frameworkSQLiteStatementAcquire.bindString(2, str);
        }
        workDatabase_Impl.beginTransaction();
        try {
            frameworkSQLiteStatementAcquire.executeUpdateDelete();
            workDatabase_Impl.setTransactionSuccessful();
        } finally {
            workDatabase_Impl.endTransaction();
            anonymousClass2.release(frameworkSQLiteStatementAcquire);
        }
    }

    public final void setPeriodStartTime(long j, String str) {
        WorkDatabase_Impl workDatabase_Impl = this.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        AnonymousClass2 anonymousClass2 = this.__preparedStmtOfSetPeriodStartTime;
        FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = anonymousClass2.acquire();
        frameworkSQLiteStatementAcquire.bindLong(1, j);
        if (str == null) {
            frameworkSQLiteStatementAcquire.bindNull(2);
        } else {
            frameworkSQLiteStatementAcquire.bindString(2, str);
        }
        workDatabase_Impl.beginTransaction();
        try {
            frameworkSQLiteStatementAcquire.executeUpdateDelete();
            workDatabase_Impl.setTransactionSuccessful();
        } finally {
            workDatabase_Impl.endTransaction();
            anonymousClass2.release(frameworkSQLiteStatementAcquire);
        }
    }

    public final void setState(int i, String... strArr) {
        WorkDatabase_Impl workDatabase_Impl = this.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        StringBuilder sb = new StringBuilder("UPDATE workspec SET state=? WHERE id IN (");
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append("?");
            if (i2 < length - 1) {
                sb.append(",");
            }
        }
        sb.append(")");
        String string = sb.toString();
        workDatabase_Impl.assertNotMainThread();
        workDatabase_Impl.assertNotSuspendingTransaction();
        SQLiteStatement sQLiteStatementCompileStatement = ((SQLiteDatabase) workDatabase_Impl.mOpenHelper.getWritableDatabase().mDelegate).compileStatement(string);
        sQLiteStatementCompileStatement.bindLong(1, StringsKt__IndentKt.stateToInt(i));
        int i3 = 2;
        for (String str : strArr) {
            if (str == null) {
                sQLiteStatementCompileStatement.bindNull(i3);
            } else {
                sQLiteStatementCompileStatement.bindString(i3, str);
            }
            i3++;
        }
        workDatabase_Impl.beginTransaction();
        try {
            sQLiteStatementCompileStatement.executeUpdateDelete();
            workDatabase_Impl.setTransactionSuccessful();
        } finally {
            workDatabase_Impl.endTransaction();
        }
    }

    public final ArrayList getAllEligibleWorkSpecsForScheduling() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(1, "SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 ORDER BY period_start_time LIMIT ?");
        roomSQLiteQueryAcquire.bindLong(1, 200);
        WorkDatabase_Impl workDatabase_Impl = this.__db;
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
            int columnIndexOrThrow11 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "worker_class_name");
            int columnIndexOrThrow12 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "input_merger_class_name");
            int columnIndexOrThrow13 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "input");
            int columnIndexOrThrow14 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "output");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "initial_delay");
                int columnIndexOrThrow16 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "interval_duration");
                int columnIndexOrThrow17 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "flex_duration");
                int columnIndexOrThrow18 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, kBfGXgdfpo.tfGmF);
                int columnIndexOrThrow19 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "backoff_policy");
                int columnIndexOrThrow20 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "backoff_delay_duration");
                int columnIndexOrThrow21 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "period_start_time");
                int columnIndexOrThrow22 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "minimum_retention_duration");
                int columnIndexOrThrow23 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, sgtsHsWT.uHgf);
                int columnIndexOrThrow24 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "run_in_foreground");
                int columnIndexOrThrow25 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "out_of_quota_policy");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(columnIndexOrThrow9);
                    int i2 = columnIndexOrThrow9;
                    String string2 = cursorQuery.getString(columnIndexOrThrow11);
                    int i3 = columnIndexOrThrow11;
                    Constraints constraints = new Constraints();
                    int i4 = columnIndexOrThrow;
                    constraints.mRequiredNetworkType = StringsKt__IndentKt.intToNetworkType(cursorQuery.getInt(columnIndexOrThrow));
                    constraints.mRequiresCharging = cursorQuery.getInt(columnIndexOrThrow2) != 0;
                    constraints.mRequiresDeviceIdle = cursorQuery.getInt(columnIndexOrThrow3) != 0;
                    constraints.mRequiresBatteryNotLow = cursorQuery.getInt(columnIndexOrThrow4) != 0;
                    constraints.mRequiresStorageNotLow = cursorQuery.getInt(columnIndexOrThrow5) != 0;
                    int i5 = columnIndexOrThrow2;
                    int i6 = columnIndexOrThrow3;
                    constraints.mTriggerContentUpdateDelay = cursorQuery.getLong(columnIndexOrThrow6);
                    constraints.mTriggerMaxContentDelay = cursorQuery.getLong(columnIndexOrThrow7);
                    constraints.mContentUriTriggers = StringsKt__IndentKt.byteArrayToContentUriTriggers(cursorQuery.getBlob(columnIndexOrThrow8));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = StringsKt__IndentKt.intToState(cursorQuery.getInt(columnIndexOrThrow10));
                    workSpec.inputMergerClassName = cursorQuery.getString(columnIndexOrThrow12);
                    workSpec.input = Data.fromByteArray(cursorQuery.getBlob(columnIndexOrThrow13));
                    int i7 = i;
                    workSpec.output = Data.fromByteArray(cursorQuery.getBlob(i7));
                    int i8 = columnIndexOrThrow13;
                    int i9 = columnIndexOrThrow15;
                    workSpec.initialDelay = cursorQuery.getLong(i9);
                    int i10 = columnIndexOrThrow4;
                    int i11 = columnIndexOrThrow16;
                    workSpec.intervalDuration = cursorQuery.getLong(i11);
                    int i12 = columnIndexOrThrow17;
                    workSpec.flexDuration = cursorQuery.getLong(i12);
                    int i13 = columnIndexOrThrow18;
                    workSpec.runAttemptCount = cursorQuery.getInt(i13);
                    int i14 = columnIndexOrThrow19;
                    workSpec.backoffPolicy = StringsKt__IndentKt.intToBackoffPolicy(cursorQuery.getInt(i14));
                    int i15 = columnIndexOrThrow20;
                    workSpec.backoffDelayDuration = cursorQuery.getLong(i15);
                    int i16 = columnIndexOrThrow21;
                    workSpec.periodStartTime = cursorQuery.getLong(i16);
                    int i17 = columnIndexOrThrow22;
                    workSpec.minimumRetentionDuration = cursorQuery.getLong(i17);
                    int i18 = columnIndexOrThrow23;
                    workSpec.scheduleRequestedAt = cursorQuery.getLong(i18);
                    int i19 = columnIndexOrThrow24;
                    workSpec.expedited = cursorQuery.getInt(i19) != 0;
                    int i20 = columnIndexOrThrow25;
                    workSpec.outOfQuotaPolicy = StringsKt__IndentKt.intToOutOfQuotaPolicy(cursorQuery.getInt(i20));
                    workSpec.constraints = constraints;
                    arrayList.add(workSpec);
                    i = i7;
                    columnIndexOrThrow2 = i5;
                    columnIndexOrThrow15 = i9;
                    columnIndexOrThrow16 = i11;
                    columnIndexOrThrow20 = i15;
                    columnIndexOrThrow21 = i16;
                    columnIndexOrThrow24 = i19;
                    columnIndexOrThrow11 = i3;
                    columnIndexOrThrow = i4;
                    columnIndexOrThrow25 = i20;
                    columnIndexOrThrow23 = i18;
                    columnIndexOrThrow13 = i8;
                    columnIndexOrThrow9 = i2;
                    columnIndexOrThrow3 = i6;
                    columnIndexOrThrow22 = i17;
                    columnIndexOrThrow4 = i10;
                    columnIndexOrThrow17 = i12;
                    columnIndexOrThrow18 = i13;
                    columnIndexOrThrow19 = i14;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
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

    public final ArrayList getEligibleWorkForScheduling(int i) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(1, "SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY period_start_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))");
        roomSQLiteQueryAcquire.bindLong(1, i);
        WorkDatabase_Impl workDatabase_Impl = this.__db;
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
            int columnIndexOrThrow11 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "worker_class_name");
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
                int columnIndexOrThrow22 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, eoBKjVuj.uqKzIhkWMG);
                int columnIndexOrThrow23 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "schedule_requested_at");
                int columnIndexOrThrow24 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "run_in_foreground");
                int columnIndexOrThrow25 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "out_of_quota_policy");
                int i2 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(columnIndexOrThrow9);
                    int i3 = columnIndexOrThrow9;
                    String string2 = cursorQuery.getString(columnIndexOrThrow11);
                    int i4 = columnIndexOrThrow11;
                    Constraints constraints = new Constraints();
                    int i5 = columnIndexOrThrow;
                    constraints.mRequiredNetworkType = StringsKt__IndentKt.intToNetworkType(cursorQuery.getInt(columnIndexOrThrow));
                    constraints.mRequiresCharging = cursorQuery.getInt(columnIndexOrThrow2) != 0;
                    constraints.mRequiresDeviceIdle = cursorQuery.getInt(columnIndexOrThrow3) != 0;
                    constraints.mRequiresBatteryNotLow = cursorQuery.getInt(columnIndexOrThrow4) != 0;
                    constraints.mRequiresStorageNotLow = cursorQuery.getInt(columnIndexOrThrow5) != 0;
                    int i6 = columnIndexOrThrow2;
                    int i7 = columnIndexOrThrow3;
                    constraints.mTriggerContentUpdateDelay = cursorQuery.getLong(columnIndexOrThrow6);
                    constraints.mTriggerMaxContentDelay = cursorQuery.getLong(columnIndexOrThrow7);
                    constraints.mContentUriTriggers = StringsKt__IndentKt.byteArrayToContentUriTriggers(cursorQuery.getBlob(columnIndexOrThrow8));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = StringsKt__IndentKt.intToState(cursorQuery.getInt(columnIndexOrThrow10));
                    workSpec.inputMergerClassName = cursorQuery.getString(columnIndexOrThrow12);
                    workSpec.input = Data.fromByteArray(cursorQuery.getBlob(columnIndexOrThrow13));
                    int i8 = i2;
                    workSpec.output = Data.fromByteArray(cursorQuery.getBlob(i8));
                    int i9 = columnIndexOrThrow15;
                    int i10 = columnIndexOrThrow13;
                    workSpec.initialDelay = cursorQuery.getLong(i9);
                    int i11 = columnIndexOrThrow4;
                    int i12 = columnIndexOrThrow16;
                    workSpec.intervalDuration = cursorQuery.getLong(i12);
                    int i13 = columnIndexOrThrow17;
                    workSpec.flexDuration = cursorQuery.getLong(i13);
                    int i14 = columnIndexOrThrow18;
                    workSpec.runAttemptCount = cursorQuery.getInt(i14);
                    int i15 = columnIndexOrThrow19;
                    workSpec.backoffPolicy = StringsKt__IndentKt.intToBackoffPolicy(cursorQuery.getInt(i15));
                    int i16 = columnIndexOrThrow20;
                    workSpec.backoffDelayDuration = cursorQuery.getLong(i16);
                    int i17 = columnIndexOrThrow21;
                    workSpec.periodStartTime = cursorQuery.getLong(i17);
                    int i18 = columnIndexOrThrow22;
                    workSpec.minimumRetentionDuration = cursorQuery.getLong(i18);
                    int i19 = columnIndexOrThrow23;
                    workSpec.scheduleRequestedAt = cursorQuery.getLong(i19);
                    int i20 = columnIndexOrThrow24;
                    workSpec.expedited = cursorQuery.getInt(i20) != 0;
                    int i21 = columnIndexOrThrow25;
                    workSpec.outOfQuotaPolicy = StringsKt__IndentKt.intToOutOfQuotaPolicy(cursorQuery.getInt(i21));
                    workSpec.constraints = constraints;
                    arrayList.add(workSpec);
                    i2 = i8;
                    columnIndexOrThrow2 = i6;
                    columnIndexOrThrow24 = i20;
                    columnIndexOrThrow9 = i3;
                    columnIndexOrThrow11 = i4;
                    columnIndexOrThrow = i5;
                    columnIndexOrThrow25 = i21;
                    columnIndexOrThrow13 = i10;
                    columnIndexOrThrow15 = i9;
                    columnIndexOrThrow16 = i12;
                    columnIndexOrThrow20 = i16;
                    columnIndexOrThrow21 = i17;
                    columnIndexOrThrow23 = i19;
                    columnIndexOrThrow3 = i7;
                    columnIndexOrThrow22 = i18;
                    columnIndexOrThrow4 = i11;
                    columnIndexOrThrow17 = i13;
                    columnIndexOrThrow18 = i14;
                    columnIndexOrThrow19 = i15;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
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

    public final ArrayList getScheduledWork() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(0, "SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at<>-1");
        WorkDatabase_Impl workDatabase_Impl = this.__db;
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
            int columnIndexOrThrow11 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "worker_class_name");
            int columnIndexOrThrow12 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "input_merger_class_name");
            int columnIndexOrThrow13 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "input");
            int columnIndexOrThrow14 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "output");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "initial_delay");
                int columnIndexOrThrow16 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "interval_duration");
                int columnIndexOrThrow17 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "flex_duration");
                int columnIndexOrThrow18 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, dLDI.rpVRjKBWpWKWoU);
                int columnIndexOrThrow19 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "backoff_policy");
                int columnIndexOrThrow20 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "backoff_delay_duration");
                int columnIndexOrThrow21 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "period_start_time");
                int columnIndexOrThrow22 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "minimum_retention_duration");
                int columnIndexOrThrow23 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "schedule_requested_at");
                int columnIndexOrThrow24 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "run_in_foreground");
                int columnIndexOrThrow25 = MediaType.Companion.getColumnIndexOrThrow(cursorQuery, "out_of_quota_policy");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(columnIndexOrThrow9);
                    int i2 = columnIndexOrThrow9;
                    String string2 = cursorQuery.getString(columnIndexOrThrow11);
                    int i3 = columnIndexOrThrow11;
                    Constraints constraints = new Constraints();
                    int i4 = columnIndexOrThrow;
                    constraints.mRequiredNetworkType = StringsKt__IndentKt.intToNetworkType(cursorQuery.getInt(columnIndexOrThrow));
                    constraints.mRequiresCharging = cursorQuery.getInt(columnIndexOrThrow2) != 0;
                    constraints.mRequiresDeviceIdle = cursorQuery.getInt(columnIndexOrThrow3) != 0;
                    constraints.mRequiresBatteryNotLow = cursorQuery.getInt(columnIndexOrThrow4) != 0;
                    constraints.mRequiresStorageNotLow = cursorQuery.getInt(columnIndexOrThrow5) != 0;
                    int i5 = columnIndexOrThrow2;
                    int i6 = columnIndexOrThrow3;
                    constraints.mTriggerContentUpdateDelay = cursorQuery.getLong(columnIndexOrThrow6);
                    constraints.mTriggerMaxContentDelay = cursorQuery.getLong(columnIndexOrThrow7);
                    constraints.mContentUriTriggers = StringsKt__IndentKt.byteArrayToContentUriTriggers(cursorQuery.getBlob(columnIndexOrThrow8));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = StringsKt__IndentKt.intToState(cursorQuery.getInt(columnIndexOrThrow10));
                    workSpec.inputMergerClassName = cursorQuery.getString(columnIndexOrThrow12);
                    workSpec.input = Data.fromByteArray(cursorQuery.getBlob(columnIndexOrThrow13));
                    int i7 = i;
                    workSpec.output = Data.fromByteArray(cursorQuery.getBlob(i7));
                    int i8 = columnIndexOrThrow13;
                    int i9 = columnIndexOrThrow15;
                    workSpec.initialDelay = cursorQuery.getLong(i9);
                    int i10 = columnIndexOrThrow4;
                    int i11 = columnIndexOrThrow16;
                    workSpec.intervalDuration = cursorQuery.getLong(i11);
                    int i12 = columnIndexOrThrow17;
                    workSpec.flexDuration = cursorQuery.getLong(i12);
                    int i13 = columnIndexOrThrow18;
                    workSpec.runAttemptCount = cursorQuery.getInt(i13);
                    int i14 = columnIndexOrThrow19;
                    workSpec.backoffPolicy = StringsKt__IndentKt.intToBackoffPolicy(cursorQuery.getInt(i14));
                    int i15 = columnIndexOrThrow20;
                    workSpec.backoffDelayDuration = cursorQuery.getLong(i15);
                    int i16 = columnIndexOrThrow21;
                    workSpec.periodStartTime = cursorQuery.getLong(i16);
                    int i17 = columnIndexOrThrow22;
                    workSpec.minimumRetentionDuration = cursorQuery.getLong(i17);
                    int i18 = columnIndexOrThrow23;
                    workSpec.scheduleRequestedAt = cursorQuery.getLong(i18);
                    int i19 = columnIndexOrThrow24;
                    workSpec.expedited = cursorQuery.getInt(i19) != 0;
                    int i20 = columnIndexOrThrow25;
                    workSpec.outOfQuotaPolicy = StringsKt__IndentKt.intToOutOfQuotaPolicy(cursorQuery.getInt(i20));
                    workSpec.constraints = constraints;
                    arrayList.add(workSpec);
                    i = i7;
                    columnIndexOrThrow2 = i5;
                    columnIndexOrThrow15 = i9;
                    columnIndexOrThrow16 = i11;
                    columnIndexOrThrow20 = i15;
                    columnIndexOrThrow21 = i16;
                    columnIndexOrThrow24 = i19;
                    columnIndexOrThrow11 = i3;
                    columnIndexOrThrow = i4;
                    columnIndexOrThrow25 = i20;
                    columnIndexOrThrow23 = i18;
                    columnIndexOrThrow13 = i8;
                    columnIndexOrThrow9 = i2;
                    columnIndexOrThrow3 = i6;
                    columnIndexOrThrow22 = i17;
                    columnIndexOrThrow4 = i10;
                    columnIndexOrThrow17 = i12;
                    columnIndexOrThrow18 = i13;
                    columnIndexOrThrow19 = i14;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
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

    public final int getState(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(1, ZRqOdXiy.qbqPA);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        WorkDatabase_Impl workDatabase_Impl = this.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
        try {
            return cursorQuery.moveToFirst() ? StringsKt__IndentKt.intToState(cursorQuery.getInt(0)) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }
}
