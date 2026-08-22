package androidx.work.impl;

import android.content.Context;
import androidx.work.Logger$LogcatLogger;
import java.io.File;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class WorkDatabasePathHelper {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("WrkDbPathHelper");
    public static final String[] DATABASE_EXTRA_FILES = {"-journal", "-shm", "-wal"};

    public static void migrateDatabase(Context context) {
        if (context.getDatabasePath("androidx.work.workdb").exists()) {
            String str = TAG;
            Logger$LogcatLogger.get().debug(str, "Migrating WorkDatabase to the no-backup directory", new Throwable[0]);
            HashMap map = new HashMap();
            File databasePath = context.getDatabasePath("androidx.work.workdb");
            File file = new File(context.getNoBackupFilesDir(), "androidx.work.workdb");
            map.put(databasePath, file);
            for (String str2 : DATABASE_EXTRA_FILES) {
                map.put(new File(databasePath.getPath() + str2), new File(file.getPath() + str2));
            }
            for (File file2 : map.keySet()) {
                File file3 = (File) map.get(file2);
                if (file2.exists() && file3 != null) {
                    if (file3.exists()) {
                        Logger$LogcatLogger.get().warning(str, String.format("Over-writing contents of %s", file3), new Throwable[0]);
                    }
                    Logger$LogcatLogger.get().debug(str, file2.renameTo(file3) ? String.format("Migrated %s to %s", file2, file3) : String.format("Renaming %s to %s failed", file2, file3), new Throwable[0]);
                }
            }
        }
    }
}
