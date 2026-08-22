package androidx.work.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.framework.FrameworkSQLiteProgram;

/* JADX INFO: loaded from: classes.dex */
public abstract class WorkDatabaseMigrations {
    public static final AnonymousClass1 MIGRATION_11_12;
    public static final AnonymousClass1 MIGRATION_1_2;
    public static final AnonymousClass1 MIGRATION_3_4;
    public static final AnonymousClass1 MIGRATION_4_5;
    public static final AnonymousClass1 MIGRATION_6_7;
    public static final AnonymousClass1 MIGRATION_7_8;
    public static final AnonymousClass1 MIGRATION_8_9;

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.work.impl.WorkDatabaseMigrations$1] */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.work.impl.WorkDatabaseMigrations$1] */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.work.impl.WorkDatabaseMigrations$1] */
    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.work.impl.WorkDatabaseMigrations$1] */
    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.work.impl.WorkDatabaseMigrations$1] */
    /* JADX WARN: Type inference failed for: r0v5, types: [androidx.work.impl.WorkDatabaseMigrations$1] */
    /* JADX WARN: Type inference failed for: r0v6, types: [androidx.work.impl.WorkDatabaseMigrations$1] */
    static {
        final int i = 0;
        MIGRATION_1_2 = new Migration(1, 2) { // from class: androidx.work.impl.WorkDatabaseMigrations.1
            @Override // androidx.room.migration.Migration
            public final void migrate(FrameworkSQLiteProgram frameworkSQLiteProgram) {
                switch (i) {
                    case 0:
                        frameworkSQLiteProgram.execSQL("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                        frameworkSQLiteProgram.execSQL("INSERT INTO SystemIdInfo(work_spec_id, system_id) SELECT work_spec_id, alarm_id AS system_id FROM alarmInfo");
                        frameworkSQLiteProgram.execSQL("DROP TABLE IF EXISTS alarmInfo");
                        frameworkSQLiteProgram.execSQL("INSERT OR IGNORE INTO worktag(tag, work_spec_id) SELECT worker_class_name AS tag, id AS work_spec_id FROM workspec");
                        break;
                    case 1:
                        frameworkSQLiteProgram.execSQL("UPDATE workspec SET schedule_requested_at=0 WHERE state NOT IN (2, 3, 5) AND schedule_requested_at=-1 AND interval_duration<>0");
                        break;
                    case 2:
                        frameworkSQLiteProgram.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_content_update_delay` INTEGER NOT NULL DEFAULT -1");
                        frameworkSQLiteProgram.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_max_content_delay` INTEGER NOT NULL DEFAULT -1");
                        break;
                    case 3:
                        frameworkSQLiteProgram.execSQL("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                        break;
                    case 4:
                        frameworkSQLiteProgram.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `workspec` (`period_start_time`)");
                        break;
                    case 5:
                        frameworkSQLiteProgram.execSQL("ALTER TABLE workspec ADD COLUMN `run_in_foreground` INTEGER NOT NULL DEFAULT 0");
                        break;
                    default:
                        frameworkSQLiteProgram.execSQL("ALTER TABLE workspec ADD COLUMN `out_of_quota_policy` INTEGER NOT NULL DEFAULT 0");
                        break;
                }
            }
        };
        int i2 = 4;
        final int i3 = 1;
        MIGRATION_3_4 = new Migration(3, i2) { // from class: androidx.work.impl.WorkDatabaseMigrations.1
            @Override // androidx.room.migration.Migration
            public final void migrate(FrameworkSQLiteProgram frameworkSQLiteProgram) {
                switch (i3) {
                    case 0:
                        frameworkSQLiteProgram.execSQL("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                        frameworkSQLiteProgram.execSQL("INSERT INTO SystemIdInfo(work_spec_id, system_id) SELECT work_spec_id, alarm_id AS system_id FROM alarmInfo");
                        frameworkSQLiteProgram.execSQL("DROP TABLE IF EXISTS alarmInfo");
                        frameworkSQLiteProgram.execSQL("INSERT OR IGNORE INTO worktag(tag, work_spec_id) SELECT worker_class_name AS tag, id AS work_spec_id FROM workspec");
                        break;
                    case 1:
                        frameworkSQLiteProgram.execSQL("UPDATE workspec SET schedule_requested_at=0 WHERE state NOT IN (2, 3, 5) AND schedule_requested_at=-1 AND interval_duration<>0");
                        break;
                    case 2:
                        frameworkSQLiteProgram.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_content_update_delay` INTEGER NOT NULL DEFAULT -1");
                        frameworkSQLiteProgram.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_max_content_delay` INTEGER NOT NULL DEFAULT -1");
                        break;
                    case 3:
                        frameworkSQLiteProgram.execSQL("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                        break;
                    case 4:
                        frameworkSQLiteProgram.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `workspec` (`period_start_time`)");
                        break;
                    case 5:
                        frameworkSQLiteProgram.execSQL("ALTER TABLE workspec ADD COLUMN `run_in_foreground` INTEGER NOT NULL DEFAULT 0");
                        break;
                    default:
                        frameworkSQLiteProgram.execSQL("ALTER TABLE workspec ADD COLUMN `out_of_quota_policy` INTEGER NOT NULL DEFAULT 0");
                        break;
                }
            }
        };
        final int i4 = 2;
        MIGRATION_4_5 = new Migration(i2, 5) { // from class: androidx.work.impl.WorkDatabaseMigrations.1
            @Override // androidx.room.migration.Migration
            public final void migrate(FrameworkSQLiteProgram frameworkSQLiteProgram) {
                switch (i4) {
                    case 0:
                        frameworkSQLiteProgram.execSQL("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                        frameworkSQLiteProgram.execSQL("INSERT INTO SystemIdInfo(work_spec_id, system_id) SELECT work_spec_id, alarm_id AS system_id FROM alarmInfo");
                        frameworkSQLiteProgram.execSQL("DROP TABLE IF EXISTS alarmInfo");
                        frameworkSQLiteProgram.execSQL("INSERT OR IGNORE INTO worktag(tag, work_spec_id) SELECT worker_class_name AS tag, id AS work_spec_id FROM workspec");
                        break;
                    case 1:
                        frameworkSQLiteProgram.execSQL("UPDATE workspec SET schedule_requested_at=0 WHERE state NOT IN (2, 3, 5) AND schedule_requested_at=-1 AND interval_duration<>0");
                        break;
                    case 2:
                        frameworkSQLiteProgram.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_content_update_delay` INTEGER NOT NULL DEFAULT -1");
                        frameworkSQLiteProgram.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_max_content_delay` INTEGER NOT NULL DEFAULT -1");
                        break;
                    case 3:
                        frameworkSQLiteProgram.execSQL("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                        break;
                    case 4:
                        frameworkSQLiteProgram.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `workspec` (`period_start_time`)");
                        break;
                    case 5:
                        frameworkSQLiteProgram.execSQL("ALTER TABLE workspec ADD COLUMN `run_in_foreground` INTEGER NOT NULL DEFAULT 0");
                        break;
                    default:
                        frameworkSQLiteProgram.execSQL("ALTER TABLE workspec ADD COLUMN `out_of_quota_policy` INTEGER NOT NULL DEFAULT 0");
                        break;
                }
            }
        };
        int i5 = 7;
        final int i6 = 3;
        MIGRATION_6_7 = new Migration(6, i5) { // from class: androidx.work.impl.WorkDatabaseMigrations.1
            @Override // androidx.room.migration.Migration
            public final void migrate(FrameworkSQLiteProgram frameworkSQLiteProgram) {
                switch (i6) {
                    case 0:
                        frameworkSQLiteProgram.execSQL("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                        frameworkSQLiteProgram.execSQL("INSERT INTO SystemIdInfo(work_spec_id, system_id) SELECT work_spec_id, alarm_id AS system_id FROM alarmInfo");
                        frameworkSQLiteProgram.execSQL("DROP TABLE IF EXISTS alarmInfo");
                        frameworkSQLiteProgram.execSQL("INSERT OR IGNORE INTO worktag(tag, work_spec_id) SELECT worker_class_name AS tag, id AS work_spec_id FROM workspec");
                        break;
                    case 1:
                        frameworkSQLiteProgram.execSQL("UPDATE workspec SET schedule_requested_at=0 WHERE state NOT IN (2, 3, 5) AND schedule_requested_at=-1 AND interval_duration<>0");
                        break;
                    case 2:
                        frameworkSQLiteProgram.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_content_update_delay` INTEGER NOT NULL DEFAULT -1");
                        frameworkSQLiteProgram.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_max_content_delay` INTEGER NOT NULL DEFAULT -1");
                        break;
                    case 3:
                        frameworkSQLiteProgram.execSQL("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                        break;
                    case 4:
                        frameworkSQLiteProgram.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `workspec` (`period_start_time`)");
                        break;
                    case 5:
                        frameworkSQLiteProgram.execSQL("ALTER TABLE workspec ADD COLUMN `run_in_foreground` INTEGER NOT NULL DEFAULT 0");
                        break;
                    default:
                        frameworkSQLiteProgram.execSQL("ALTER TABLE workspec ADD COLUMN `out_of_quota_policy` INTEGER NOT NULL DEFAULT 0");
                        break;
                }
            }
        };
        int i7 = 8;
        final int i8 = 4;
        MIGRATION_7_8 = new Migration(i5, i7) { // from class: androidx.work.impl.WorkDatabaseMigrations.1
            @Override // androidx.room.migration.Migration
            public final void migrate(FrameworkSQLiteProgram frameworkSQLiteProgram) {
                switch (i8) {
                    case 0:
                        frameworkSQLiteProgram.execSQL("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                        frameworkSQLiteProgram.execSQL("INSERT INTO SystemIdInfo(work_spec_id, system_id) SELECT work_spec_id, alarm_id AS system_id FROM alarmInfo");
                        frameworkSQLiteProgram.execSQL("DROP TABLE IF EXISTS alarmInfo");
                        frameworkSQLiteProgram.execSQL("INSERT OR IGNORE INTO worktag(tag, work_spec_id) SELECT worker_class_name AS tag, id AS work_spec_id FROM workspec");
                        break;
                    case 1:
                        frameworkSQLiteProgram.execSQL("UPDATE workspec SET schedule_requested_at=0 WHERE state NOT IN (2, 3, 5) AND schedule_requested_at=-1 AND interval_duration<>0");
                        break;
                    case 2:
                        frameworkSQLiteProgram.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_content_update_delay` INTEGER NOT NULL DEFAULT -1");
                        frameworkSQLiteProgram.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_max_content_delay` INTEGER NOT NULL DEFAULT -1");
                        break;
                    case 3:
                        frameworkSQLiteProgram.execSQL("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                        break;
                    case 4:
                        frameworkSQLiteProgram.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `workspec` (`period_start_time`)");
                        break;
                    case 5:
                        frameworkSQLiteProgram.execSQL("ALTER TABLE workspec ADD COLUMN `run_in_foreground` INTEGER NOT NULL DEFAULT 0");
                        break;
                    default:
                        frameworkSQLiteProgram.execSQL("ALTER TABLE workspec ADD COLUMN `out_of_quota_policy` INTEGER NOT NULL DEFAULT 0");
                        break;
                }
            }
        };
        final int i9 = 5;
        MIGRATION_8_9 = new Migration(i7, 9) { // from class: androidx.work.impl.WorkDatabaseMigrations.1
            @Override // androidx.room.migration.Migration
            public final void migrate(FrameworkSQLiteProgram frameworkSQLiteProgram) {
                switch (i9) {
                    case 0:
                        frameworkSQLiteProgram.execSQL("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                        frameworkSQLiteProgram.execSQL("INSERT INTO SystemIdInfo(work_spec_id, system_id) SELECT work_spec_id, alarm_id AS system_id FROM alarmInfo");
                        frameworkSQLiteProgram.execSQL("DROP TABLE IF EXISTS alarmInfo");
                        frameworkSQLiteProgram.execSQL("INSERT OR IGNORE INTO worktag(tag, work_spec_id) SELECT worker_class_name AS tag, id AS work_spec_id FROM workspec");
                        break;
                    case 1:
                        frameworkSQLiteProgram.execSQL("UPDATE workspec SET schedule_requested_at=0 WHERE state NOT IN (2, 3, 5) AND schedule_requested_at=-1 AND interval_duration<>0");
                        break;
                    case 2:
                        frameworkSQLiteProgram.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_content_update_delay` INTEGER NOT NULL DEFAULT -1");
                        frameworkSQLiteProgram.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_max_content_delay` INTEGER NOT NULL DEFAULT -1");
                        break;
                    case 3:
                        frameworkSQLiteProgram.execSQL("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                        break;
                    case 4:
                        frameworkSQLiteProgram.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `workspec` (`period_start_time`)");
                        break;
                    case 5:
                        frameworkSQLiteProgram.execSQL("ALTER TABLE workspec ADD COLUMN `run_in_foreground` INTEGER NOT NULL DEFAULT 0");
                        break;
                    default:
                        frameworkSQLiteProgram.execSQL("ALTER TABLE workspec ADD COLUMN `out_of_quota_policy` INTEGER NOT NULL DEFAULT 0");
                        break;
                }
            }
        };
        final int i10 = 6;
        MIGRATION_11_12 = new Migration(11, 12) { // from class: androidx.work.impl.WorkDatabaseMigrations.1
            @Override // androidx.room.migration.Migration
            public final void migrate(FrameworkSQLiteProgram frameworkSQLiteProgram) {
                switch (i10) {
                    case 0:
                        frameworkSQLiteProgram.execSQL("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                        frameworkSQLiteProgram.execSQL("INSERT INTO SystemIdInfo(work_spec_id, system_id) SELECT work_spec_id, alarm_id AS system_id FROM alarmInfo");
                        frameworkSQLiteProgram.execSQL("DROP TABLE IF EXISTS alarmInfo");
                        frameworkSQLiteProgram.execSQL("INSERT OR IGNORE INTO worktag(tag, work_spec_id) SELECT worker_class_name AS tag, id AS work_spec_id FROM workspec");
                        break;
                    case 1:
                        frameworkSQLiteProgram.execSQL("UPDATE workspec SET schedule_requested_at=0 WHERE state NOT IN (2, 3, 5) AND schedule_requested_at=-1 AND interval_duration<>0");
                        break;
                    case 2:
                        frameworkSQLiteProgram.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_content_update_delay` INTEGER NOT NULL DEFAULT -1");
                        frameworkSQLiteProgram.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_max_content_delay` INTEGER NOT NULL DEFAULT -1");
                        break;
                    case 3:
                        frameworkSQLiteProgram.execSQL("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                        break;
                    case 4:
                        frameworkSQLiteProgram.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `workspec` (`period_start_time`)");
                        break;
                    case 5:
                        frameworkSQLiteProgram.execSQL("ALTER TABLE workspec ADD COLUMN `run_in_foreground` INTEGER NOT NULL DEFAULT 0");
                        break;
                    default:
                        frameworkSQLiteProgram.execSQL("ALTER TABLE workspec ADD COLUMN `out_of_quota_policy` INTEGER NOT NULL DEFAULT 0");
                        break;
                }
            }
        };
    }

    public final class WorkMigration9To10 extends Migration {
        public final /* synthetic */ int $r8$classId = 0;
        public final Context mContext;

        public WorkMigration9To10(Context context, int i, int i2) {
            super(i, i2);
            this.mContext = context;
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(FrameworkSQLiteProgram frameworkSQLiteProgram) {
            Context context = this.mContext;
            switch (this.$r8$classId) {
                case 0:
                    frameworkSQLiteProgram.execSQL("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
                    SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.preferences", 0);
                    boolean zContains = sharedPreferences.contains("reschedule_needed");
                    SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) frameworkSQLiteProgram.mDelegate;
                    if (zContains || sharedPreferences.contains("last_cancel_all_time_ms")) {
                        long j = sharedPreferences.getLong("last_cancel_all_time_ms", 0L);
                        long j2 = sharedPreferences.getBoolean("reschedule_needed", false) ? 1L : 0L;
                        frameworkSQLiteProgram.beginTransaction();
                        try {
                            sQLiteDatabase.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"last_cancel_all_time_ms", Long.valueOf(j)});
                            sQLiteDatabase.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", Long.valueOf(j2)});
                            sharedPreferences.edit().clear().apply();
                            frameworkSQLiteProgram.setTransactionSuccessful();
                            frameworkSQLiteProgram.endTransaction();
                        } catch (Throwable th) {
                            frameworkSQLiteProgram.endTransaction();
                            throw th;
                        }
                    }
                    SharedPreferences sharedPreferences2 = context.getSharedPreferences("androidx.work.util.id", 0);
                    if (sharedPreferences2.contains("next_job_scheduler_id") || sharedPreferences2.contains("next_job_scheduler_id")) {
                        int i = sharedPreferences2.getInt("next_job_scheduler_id", 0);
                        int i2 = sharedPreferences2.getInt("next_alarm_manager_id", 0);
                        frameworkSQLiteProgram.beginTransaction();
                        try {
                            sQLiteDatabase.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_job_scheduler_id", Integer.valueOf(i)});
                            sQLiteDatabase.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_alarm_manager_id", Integer.valueOf(i2)});
                            sharedPreferences2.edit().clear().apply();
                            frameworkSQLiteProgram.setTransactionSuccessful();
                            return;
                        } finally {
                            frameworkSQLiteProgram.endTransaction();
                        }
                    }
                    return;
                default:
                    if (this.endVersion >= 10) {
                        ((SQLiteDatabase) frameworkSQLiteProgram.mDelegate).execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", 1});
                        return;
                    } else {
                        context.getSharedPreferences("androidx.work.util.preferences", 0).edit().putBoolean("reschedule_needed", true).apply();
                        return;
                    }
            }
        }

        public WorkMigration9To10(Context context) {
            super(9, 10);
            this.mContext = context;
        }
    }
}
