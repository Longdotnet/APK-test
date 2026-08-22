package androidx.sqlite.db.framework;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.util.Pair;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import com.facebook.ProfileCache;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class FrameworkSQLiteOpenHelper implements SupportSQLiteOpenHelper {
    public final RoomOpenHelper mCallback;
    public final Context mContext;
    public OpenHelper mDelegate;
    public final Object mLock = new Object();
    public final String mName;
    public final boolean mUseNoBackupDirectory;
    public boolean mWriteAheadLoggingEnabled;

    public final class OpenHelper extends SQLiteOpenHelper {
        public final RoomOpenHelper mCallback;
        public final FrameworkSQLiteProgram[] mDbRef;
        public boolean mMigrated;

        /* JADX INFO: renamed from: androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$1 */
        public final class AnonymousClass1 implements DatabaseErrorHandler {
            public final /* synthetic */ FrameworkSQLiteProgram[] val$dbRef;

            public AnonymousClass1() {
                frameworkSQLiteProgramArr = frameworkSQLiteProgramArr;
            }

            @Override // android.database.DatabaseErrorHandler
            public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
                FrameworkSQLiteProgram wrappedDb = OpenHelper.getWrappedDb(frameworkSQLiteProgramArr, sQLiteDatabase);
                roomOpenHelper.getClass();
                Log.e("SupportSQLite", "Corruption reported by sqlite on database: " + ((SQLiteDatabase) wrappedDb.mDelegate).getPath());
                SQLiteDatabase sQLiteDatabase2 = (SQLiteDatabase) wrappedDb.mDelegate;
                if (!sQLiteDatabase2.isOpen()) {
                    RoomOpenHelper.deleteDatabaseFile(sQLiteDatabase2.getPath());
                    return;
                }
                List<Pair<String, String>> attachedDbs = null;
                try {
                    try {
                        attachedDbs = sQLiteDatabase2.getAttachedDbs();
                    } finally {
                        if (attachedDbs != null) {
                            Iterator<Pair<String, String>> it = attachedDbs.iterator();
                            while (it.hasNext()) {
                                RoomOpenHelper.deleteDatabaseFile((String) it.next().second);
                            }
                        } else {
                            RoomOpenHelper.deleteDatabaseFile(sQLiteDatabase2.getPath());
                        }
                    }
                } catch (SQLiteException unused) {
                }
                try {
                    wrappedDb.close();
                } catch (IOException unused2) {
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenHelper(Context context, String str, FrameworkSQLiteProgram[] frameworkSQLiteProgramArr, RoomOpenHelper roomOpenHelper) {
            super(context, str, null, 12, new DatabaseErrorHandler() { // from class: androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.1
                public final /* synthetic */ FrameworkSQLiteProgram[] val$dbRef;

                public AnonymousClass1() {
                    frameworkSQLiteProgramArr = frameworkSQLiteProgramArr;
                }

                @Override // android.database.DatabaseErrorHandler
                public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
                    FrameworkSQLiteProgram wrappedDb = OpenHelper.getWrappedDb(frameworkSQLiteProgramArr, sQLiteDatabase);
                    roomOpenHelper.getClass();
                    Log.e("SupportSQLite", "Corruption reported by sqlite on database: " + ((SQLiteDatabase) wrappedDb.mDelegate).getPath());
                    SQLiteDatabase sQLiteDatabase2 = (SQLiteDatabase) wrappedDb.mDelegate;
                    if (!sQLiteDatabase2.isOpen()) {
                        RoomOpenHelper.deleteDatabaseFile(sQLiteDatabase2.getPath());
                        return;
                    }
                    List<Pair<String, String>> attachedDbs = null;
                    try {
                        try {
                            attachedDbs = sQLiteDatabase2.getAttachedDbs();
                        } finally {
                            if (attachedDbs != null) {
                                Iterator<Pair<String, String>> it = attachedDbs.iterator();
                                while (it.hasNext()) {
                                    RoomOpenHelper.deleteDatabaseFile((String) it.next().second);
                                }
                            } else {
                                RoomOpenHelper.deleteDatabaseFile(sQLiteDatabase2.getPath());
                            }
                        }
                    } catch (SQLiteException unused) {
                    }
                    try {
                        wrappedDb.close();
                    } catch (IOException unused2) {
                    }
                }
            });
            roomOpenHelper.getClass();
            this.mCallback = roomOpenHelper;
            this.mDbRef = frameworkSQLiteProgramArr;
        }

        public static FrameworkSQLiteProgram getWrappedDb(FrameworkSQLiteProgram[] frameworkSQLiteProgramArr, SQLiteDatabase sQLiteDatabase) {
            FrameworkSQLiteProgram frameworkSQLiteProgram = frameworkSQLiteProgramArr[0];
            if (frameworkSQLiteProgram == null || ((SQLiteDatabase) frameworkSQLiteProgram.mDelegate) != sQLiteDatabase) {
                frameworkSQLiteProgramArr[0] = new FrameworkSQLiteProgram(sQLiteDatabase, 1);
            }
            return frameworkSQLiteProgramArr[0];
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public final synchronized void close() {
            super.close();
            this.mDbRef[0] = null;
        }

        public final synchronized FrameworkSQLiteProgram getWritableSupportDatabase() {
            this.mMigrated = false;
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (!this.mMigrated) {
                return getWrappedDb(this.mDbRef, writableDatabase);
            }
            close();
            return getWritableSupportDatabase();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onConfigure(SQLiteDatabase sQLiteDatabase) {
            getWrappedDb(this.mDbRef, sQLiteDatabase);
            this.mCallback.getClass();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            FrameworkSQLiteProgram wrappedDb = getWrappedDb(this.mDbRef, sQLiteDatabase);
            RoomOpenHelper roomOpenHelper = this.mCallback;
            roomOpenHelper.getClass();
            Cursor cursorQuery = wrappedDb.query("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
            try {
                boolean z = cursorQuery.moveToFirst() && cursorQuery.getInt(0) == 0;
                cursorQuery.close();
                ProfileCache profileCache = (ProfileCache) roomOpenHelper.mDelegate;
                ProfileCache.createAllTables(wrappedDb);
                if (!z) {
                    RoomOpenHelper.ValidationResult validationResultOnValidateSchema = ProfileCache.onValidateSchema(wrappedDb);
                    if (!validationResultOnValidateSchema.isValid) {
                        throw new IllegalStateException("Pre-packaged database has an invalid schema: " + validationResultOnValidateSchema.expectedFoundMsg);
                    }
                }
                roomOpenHelper.updateIdentity(wrappedDb);
                int i = WorkDatabase_Impl.$r8$clinit;
                WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) profileCache.sharedPreferences;
                ArrayList arrayList = workDatabase_Impl.mCallbacks;
                if (arrayList != null) {
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((WorkDatabase.AnonymousClass2) workDatabase_Impl.mCallbacks.get(i2)).getClass();
                    }
                }
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.mMigrated = true;
            this.mCallback.onUpgrade(getWrappedDb(this.mDbRef, sQLiteDatabase), i, i2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (this.mMigrated) {
                return;
            }
            RoomOpenHelper roomOpenHelper = this.mCallback;
            FrameworkSQLiteProgram wrappedDb = getWrappedDb(this.mDbRef, sQLiteDatabase);
            roomOpenHelper.getClass();
            Cursor cursorQuery = wrappedDb.query("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
            try {
                boolean z = cursorQuery.moveToFirst() && cursorQuery.getInt(0) != 0;
                cursorQuery.close();
                if (z) {
                    Cursor cursorQuery2 = wrappedDb.query(new SimpleSQLiteQuery("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
                    try {
                        String string = cursorQuery2.moveToFirst() ? cursorQuery2.getString(0) : null;
                        cursorQuery2.close();
                        if (!"c103703e120ae8cc73c9248622f3cd1e".equals(string) && !"49f946663a8deb7054212b8adda248c6".equals(string)) {
                            throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
                        }
                    } catch (Throwable th) {
                        cursorQuery2.close();
                        throw th;
                    }
                } else {
                    RoomOpenHelper.ValidationResult validationResultOnValidateSchema = ProfileCache.onValidateSchema(wrappedDb);
                    if (!validationResultOnValidateSchema.isValid) {
                        throw new IllegalStateException("Pre-packaged database has an invalid schema: " + validationResultOnValidateSchema.expectedFoundMsg);
                    }
                    roomOpenHelper.updateIdentity(wrappedDb);
                }
                ProfileCache profileCache = (ProfileCache) roomOpenHelper.mDelegate;
                WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) profileCache.sharedPreferences;
                int i = WorkDatabase_Impl.$r8$clinit;
                workDatabase_Impl.mDatabase = wrappedDb;
                wrappedDb.execSQL("PRAGMA foreign_keys = ON");
                InvalidationTracker invalidationTracker = ((WorkDatabase_Impl) profileCache.sharedPreferences).mInvalidationTracker;
                synchronized (invalidationTracker) {
                    try {
                        if (invalidationTracker.mInitialized) {
                            Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                        } else {
                            wrappedDb.execSQL("PRAGMA temp_store = MEMORY;");
                            wrappedDb.execSQL("PRAGMA recursive_triggers='ON';");
                            wrappedDb.execSQL("CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
                            invalidationTracker.syncTriggers(wrappedDb);
                            invalidationTracker.mCleanupStatement = new FrameworkSQLiteStatement(((SQLiteDatabase) wrappedDb.mDelegate).compileStatement("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 "));
                            invalidationTracker.mInitialized = true;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                ArrayList arrayList = ((WorkDatabase_Impl) profileCache.sharedPreferences).mCallbacks;
                if (arrayList != null) {
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((WorkDatabase.AnonymousClass2) ((WorkDatabase_Impl) profileCache.sharedPreferences).mCallbacks.get(i2)).getClass();
                        wrappedDb.beginTransaction();
                        try {
                            int i3 = WorkDatabase.$r8$clinit;
                            wrappedDb.execSQL("DELETE FROM workspec WHERE state IN (2, 3, 5) AND (period_start_time + minimum_retention_duration) < " + (System.currentTimeMillis() - WorkDatabase.PRUNE_THRESHOLD_MILLIS) + " AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))");
                            wrappedDb.setTransactionSuccessful();
                            wrappedDb.endTransaction();
                        } catch (Throwable th3) {
                            wrappedDb.endTransaction();
                            throw th3;
                        }
                    }
                }
                roomOpenHelper.mConfiguration = null;
            } catch (Throwable th4) {
                cursorQuery.close();
                throw th4;
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.mMigrated = true;
            this.mCallback.onUpgrade(getWrappedDb(this.mDbRef, sQLiteDatabase), i, i2);
        }
    }

    public FrameworkSQLiteOpenHelper(Context context, String str, RoomOpenHelper roomOpenHelper, boolean z) {
        this.mContext = context;
        this.mName = str;
        this.mCallback = roomOpenHelper;
        this.mUseNoBackupDirectory = z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        getDelegate().close();
    }

    public final OpenHelper getDelegate() {
        OpenHelper openHelper;
        synchronized (this.mLock) {
            try {
                if (this.mDelegate == null) {
                    FrameworkSQLiteProgram[] frameworkSQLiteProgramArr = new FrameworkSQLiteProgram[1];
                    if (this.mName == null || !this.mUseNoBackupDirectory) {
                        this.mDelegate = new OpenHelper(this.mContext, this.mName, frameworkSQLiteProgramArr, this.mCallback);
                    } else {
                        this.mDelegate = new OpenHelper(this.mContext, new File(this.mContext.getNoBackupFilesDir(), this.mName).getAbsolutePath(), frameworkSQLiteProgramArr, this.mCallback);
                    }
                    this.mDelegate.setWriteAheadLoggingEnabled(this.mWriteAheadLoggingEnabled);
                }
                openHelper = this.mDelegate;
            } catch (Throwable th) {
                throw th;
            }
        }
        return openHelper;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final FrameworkSQLiteProgram getWritableDatabase() {
        return getDelegate().getWritableSupportDatabase();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final void setWriteAheadLoggingEnabled(boolean z) {
        synchronized (this.mLock) {
            try {
                OpenHelper openHelper = this.mDelegate;
                if (openHelper != null) {
                    openHelper.setWriteAheadLoggingEnabled(z);
                }
                this.mWriteAheadLoggingEnabled = z;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
