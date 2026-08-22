package androidx.work.impl.model;

import android.os.Build;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import androidx.work.Constraints;
import androidx.work.ContentUriTriggers;
import androidx.work.Data;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: loaded from: classes.dex */
public final class WorkTagDao_Impl$1 extends SharedSQLiteStatement {
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WorkTagDao_Impl$1(RoomDatabase roomDatabase, int i) {
        super(roomDatabase);
        this.$r8$classId = i;
    }

    public final void bind(FrameworkSQLiteStatement frameworkSQLiteStatement, Object obj) throws Throwable {
        int i;
        int i2;
        Throwable th;
        switch (this.$r8$classId) {
            case 0:
                WorkTag workTag = (WorkTag) obj;
                String str = workTag.tag;
                if (str == null) {
                    frameworkSQLiteStatement.bindNull(1);
                } else {
                    frameworkSQLiteStatement.bindString(1, str);
                }
                String str2 = workTag.workSpecId;
                if (str2 == null) {
                    frameworkSQLiteStatement.bindNull(2);
                    return;
                } else {
                    frameworkSQLiteStatement.bindString(2, str2);
                    return;
                }
            case 1:
                Dependency dependency = (Dependency) obj;
                String str3 = dependency.workSpecId;
                if (str3 == null) {
                    frameworkSQLiteStatement.bindNull(1);
                } else {
                    frameworkSQLiteStatement.bindString(1, str3);
                }
                String str4 = dependency.prerequisiteId;
                if (str4 == null) {
                    frameworkSQLiteStatement.bindNull(2);
                    return;
                } else {
                    frameworkSQLiteStatement.bindString(2, str4);
                    return;
                }
            case 2:
                Preference preference = (Preference) obj;
                String str5 = preference.mKey;
                if (str5 == null) {
                    frameworkSQLiteStatement.bindNull(1);
                } else {
                    frameworkSQLiteStatement.bindString(1, str5);
                }
                Long l = preference.mValue;
                if (l == null) {
                    frameworkSQLiteStatement.bindNull(2);
                    return;
                } else {
                    frameworkSQLiteStatement.bindLong(2, l.longValue());
                    return;
                }
            case 3:
                SystemIdInfo systemIdInfo = (SystemIdInfo) obj;
                String str6 = systemIdInfo.workSpecId;
                if (str6 == null) {
                    frameworkSQLiteStatement.bindNull(1);
                } else {
                    frameworkSQLiteStatement.bindString(1, str6);
                }
                frameworkSQLiteStatement.bindLong(2, systemIdInfo.systemId);
                return;
            case 4:
                WorkName workName = (WorkName) obj;
                workName.getClass();
                frameworkSQLiteStatement.bindNull(1);
                String str7 = workName.workSpecId;
                if (str7 == null) {
                    frameworkSQLiteStatement.bindNull(2);
                    return;
                } else {
                    frameworkSQLiteStatement.bindString(2, str7);
                    return;
                }
            case 5:
                WorkProgress workProgress = (WorkProgress) obj;
                String str8 = workProgress.mWorkSpecId;
                if (str8 == null) {
                    frameworkSQLiteStatement.bindNull(1);
                } else {
                    frameworkSQLiteStatement.bindString(1, str8);
                }
                byte[] byteArrayInternal = Data.toByteArrayInternal(workProgress.mProgress);
                if (byteArrayInternal == null) {
                    frameworkSQLiteStatement.bindNull(2);
                    return;
                } else {
                    frameworkSQLiteStatement.bindBlob(2, byteArrayInternal);
                    return;
                }
            default:
                WorkSpec workSpec = (WorkSpec) obj;
                String str9 = workSpec.id;
                int i3 = 1;
                if (str9 == null) {
                    frameworkSQLiteStatement.bindNull(1);
                } else {
                    frameworkSQLiteStatement.bindString(1, str9);
                }
                frameworkSQLiteStatement.bindLong(2, StringsKt__IndentKt.stateToInt(workSpec.state));
                String str10 = workSpec.workerClassName;
                if (str10 == null) {
                    frameworkSQLiteStatement.bindNull(3);
                } else {
                    frameworkSQLiteStatement.bindString(3, str10);
                }
                String str11 = workSpec.inputMergerClassName;
                if (str11 == null) {
                    frameworkSQLiteStatement.bindNull(4);
                } else {
                    frameworkSQLiteStatement.bindString(4, str11);
                }
                byte[] byteArrayInternal2 = Data.toByteArrayInternal(workSpec.input);
                if (byteArrayInternal2 == null) {
                    frameworkSQLiteStatement.bindNull(5);
                } else {
                    frameworkSQLiteStatement.bindBlob(5, byteArrayInternal2);
                }
                byte[] byteArrayInternal3 = Data.toByteArrayInternal(workSpec.output);
                if (byteArrayInternal3 == null) {
                    frameworkSQLiteStatement.bindNull(6);
                } else {
                    frameworkSQLiteStatement.bindBlob(6, byteArrayInternal3);
                }
                frameworkSQLiteStatement.bindLong(7, workSpec.initialDelay);
                frameworkSQLiteStatement.bindLong(8, workSpec.intervalDuration);
                frameworkSQLiteStatement.bindLong(9, workSpec.flexDuration);
                frameworkSQLiteStatement.bindLong(10, workSpec.runAttemptCount);
                int i4 = workSpec.backoffPolicy;
                int iOrdinal = Fragment$$ExternalSyntheticOutline0.ordinal(i4);
                if (iOrdinal == 0) {
                    i = 0;
                } else {
                    if (iOrdinal != 1) {
                        StringBuilder sb = new StringBuilder("Could not convert ");
                        sb.append(i4 != 1 ? i4 != 2 ? "null" : "LINEAR" : "EXPONENTIAL");
                        sb.append(" to int");
                        throw new IllegalArgumentException(sb.toString());
                    }
                    i = 1;
                }
                frameworkSQLiteStatement.bindLong(11, i);
                frameworkSQLiteStatement.bindLong(12, workSpec.backoffDelayDuration);
                frameworkSQLiteStatement.bindLong(13, workSpec.periodStartTime);
                frameworkSQLiteStatement.bindLong(14, workSpec.minimumRetentionDuration);
                frameworkSQLiteStatement.bindLong(15, workSpec.scheduleRequestedAt);
                frameworkSQLiteStatement.bindLong(16, workSpec.expedited ? 1L : 0L);
                int i5 = workSpec.outOfQuotaPolicy;
                int iOrdinal2 = Fragment$$ExternalSyntheticOutline0.ordinal(i5);
                if (iOrdinal2 == 0) {
                    i2 = 0;
                } else {
                    if (iOrdinal2 != 1) {
                        StringBuilder sb2 = new StringBuilder("Could not convert ");
                        sb2.append(i5 != 1 ? i5 != 2 ? "null" : "DROP_WORK_REQUEST" : "RUN_AS_NON_EXPEDITED_WORK_REQUEST");
                        sb2.append(" to int");
                        throw new IllegalArgumentException(sb2.toString());
                    }
                    i2 = 1;
                }
                frameworkSQLiteStatement.bindLong(17, i2);
                Constraints constraints = workSpec.constraints;
                if (constraints == null) {
                    frameworkSQLiteStatement.bindNull(18);
                    frameworkSQLiteStatement.bindNull(19);
                    frameworkSQLiteStatement.bindNull(20);
                    frameworkSQLiteStatement.bindNull(21);
                    frameworkSQLiteStatement.bindNull(22);
                    frameworkSQLiteStatement.bindNull(23);
                    frameworkSQLiteStatement.bindNull(24);
                    frameworkSQLiteStatement.bindNull(25);
                    return;
                }
                int i6 = constraints.mRequiredNetworkType;
                int iOrdinal3 = Fragment$$ExternalSyntheticOutline0.ordinal(i6);
                if (iOrdinal3 == 0) {
                    i3 = 0;
                } else if (iOrdinal3 != 1) {
                    if (iOrdinal3 == 2) {
                        i3 = 2;
                    } else if (iOrdinal3 == 3) {
                        i3 = 3;
                    } else if (iOrdinal3 == 4) {
                        i3 = 4;
                    } else {
                        if (Build.VERSION.SDK_INT < 30 || i6 != 6) {
                            throw new IllegalArgumentException("Could not convert " + CoroutineAdapterKt$$ExternalSyntheticLambda0.stringValueOf$1(i6) + " to int");
                        }
                        i3 = 5;
                    }
                }
                frameworkSQLiteStatement.bindLong(18, i3);
                frameworkSQLiteStatement.bindLong(19, constraints.mRequiresCharging ? 1L : 0L);
                frameworkSQLiteStatement.bindLong(20, constraints.mRequiresDeviceIdle ? 1L : 0L);
                frameworkSQLiteStatement.bindLong(21, constraints.mRequiresBatteryNotLow ? 1L : 0L);
                frameworkSQLiteStatement.bindLong(22, constraints.mRequiresStorageNotLow ? 1L : 0L);
                frameworkSQLiteStatement.bindLong(23, constraints.mTriggerContentUpdateDelay);
                frameworkSQLiteStatement.bindLong(24, constraints.mTriggerMaxContentDelay);
                ContentUriTriggers contentUriTriggers = constraints.mContentUriTriggers;
                byte[] byteArray = null;
                objectOutputStream = null;
                ObjectOutputStream objectOutputStream = null;
                if (contentUriTriggers.mTriggers.size() != 0) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        try {
                            try {
                                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                                HashSet<ContentUriTriggers.Trigger> hashSet = contentUriTriggers.mTriggers;
                                try {
                                    objectOutputStream2.writeInt(hashSet.size());
                                    for (ContentUriTriggers.Trigger trigger : hashSet) {
                                        objectOutputStream2.writeUTF(trigger.mUri.toString());
                                        objectOutputStream2.writeBoolean(trigger.mTriggerForDescendants);
                                    }
                                    try {
                                        objectOutputStream2.close();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    byteArrayOutputStream.close();
                                } catch (IOException e2) {
                                    e = e2;
                                    objectOutputStream = objectOutputStream2;
                                    e.printStackTrace();
                                    if (objectOutputStream != null) {
                                        try {
                                            objectOutputStream.close();
                                        } catch (IOException e3) {
                                            e3.printStackTrace();
                                        }
                                    }
                                    byteArrayOutputStream.close();
                                } catch (Throwable th2) {
                                    th = th2;
                                    objectOutputStream = objectOutputStream2;
                                    if (objectOutputStream != null) {
                                        try {
                                            objectOutputStream.close();
                                        } catch (IOException e4) {
                                            e4.printStackTrace();
                                        }
                                    }
                                    try {
                                        byteArrayOutputStream.close();
                                        throw th;
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                        throw th;
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } catch (IOException e6) {
                            e = e6;
                        }
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                    byteArray = byteArrayOutputStream.toByteArray();
                }
                if (byteArray == null) {
                    frameworkSQLiteStatement.bindNull(25);
                    return;
                } else {
                    frameworkSQLiteStatement.bindBlob(25, byteArray);
                    return;
                }
        }
    }

    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        switch (this.$r8$classId) {
            case 0:
                return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
            case 1:
                return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
            case 2:
                return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
            case 3:
                return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`system_id`) VALUES (?,?)";
            case 4:
                return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
            case 5:
                return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
            default:
                return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    public final void insert(Object obj) {
        FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = acquire();
        try {
            bind(frameworkSQLiteStatementAcquire, obj);
            frameworkSQLiteStatementAcquire.mDelegate.executeInsert();
        } finally {
            release(frameworkSQLiteStatementAcquire);
        }
    }
}
