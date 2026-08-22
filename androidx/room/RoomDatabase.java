package androidx.room;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Looper;
import android.util.Log;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.framework.FrameworkSQLiteProgram;
import com.facebook.appevents.AppEventCollection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes.dex */
public abstract class RoomDatabase {
    public boolean mAllowMainThreadQueries;
    public ArrayList mCallbacks;
    public volatile FrameworkSQLiteProgram mDatabase;
    public final InvalidationTracker mInvalidationTracker;
    public SupportSQLiteOpenHelper mOpenHelper;
    public Executor mQueryExecutor;
    public boolean mWriteAheadLoggingEnabled;
    public final ReentrantReadWriteLock mCloseLock = new ReentrantReadWriteLock();
    public final ThreadLocal mSuspendingTransactionId = new ThreadLocal();

    public final class Builder {
        public boolean mAllowDestructiveMigrationOnDowngrade;
        public boolean mAllowMainThreadQueries;
        public ArrayList mCallbacks;
        public final Context mContext;
        public SupportSQLiteOpenHelper.Factory mFactory;
        public final AppEventCollection mMigrationContainer;
        public HashSet mMigrationStartAndEndVersions;
        public final String mName;
        public Executor mQueryExecutor;
        public boolean mRequireMigration = true;
        public Executor mTransactionExecutor;

        public Builder(Context context, String str) {
            this.mContext = context;
            this.mName = str;
            AppEventCollection appEventCollection = new AppEventCollection();
            appEventCollection.stateMap = new HashMap();
            this.mMigrationContainer = appEventCollection;
        }

        public final void addMigrations(Migration... migrationArr) {
            if (this.mMigrationStartAndEndVersions == null) {
                this.mMigrationStartAndEndVersions = new HashSet();
            }
            for (Migration migration : migrationArr) {
                this.mMigrationStartAndEndVersions.add(Integer.valueOf(migration.startVersion));
                this.mMigrationStartAndEndVersions.add(Integer.valueOf(migration.endVersion));
            }
            AppEventCollection appEventCollection = this.mMigrationContainer;
            appEventCollection.getClass();
            for (Migration migration2 : migrationArr) {
                int i = migration2.startVersion;
                HashMap map = appEventCollection.stateMap;
                TreeMap treeMap = (TreeMap) map.get(Integer.valueOf(i));
                if (treeMap == null) {
                    treeMap = new TreeMap();
                    map.put(Integer.valueOf(i), treeMap);
                }
                int i2 = migration2.endVersion;
                Migration migration3 = (Migration) treeMap.get(Integer.valueOf(i2));
                if (migration3 != null) {
                    Log.w("ROOM", "Overriding migration " + migration3 + " with " + migration2);
                }
                treeMap.put(Integer.valueOf(i2), migration2);
            }
        }
    }

    public RoomDatabase() {
        new ConcurrentHashMap();
        this.mInvalidationTracker = createInvalidationTracker();
    }

    public final void assertNotMainThread() {
        if (!this.mAllowMainThreadQueries && Looper.getMainLooper().getThread() == Thread.currentThread()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public final void assertNotSuspendingTransaction() {
        if (!((SQLiteDatabase) this.mOpenHelper.getWritableDatabase().mDelegate).inTransaction() && this.mSuspendingTransactionId.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    public final void beginTransaction() {
        assertNotMainThread();
        FrameworkSQLiteProgram writableDatabase = this.mOpenHelper.getWritableDatabase();
        this.mInvalidationTracker.syncTriggers(writableDatabase);
        writableDatabase.beginTransaction();
    }

    public abstract InvalidationTracker createInvalidationTracker();

    public abstract SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration);

    public final void endTransaction() {
        this.mOpenHelper.getWritableDatabase().endTransaction();
        if (((SQLiteDatabase) this.mOpenHelper.getWritableDatabase().mDelegate).inTransaction()) {
            return;
        }
        InvalidationTracker invalidationTracker = this.mInvalidationTracker;
        if (invalidationTracker.mPendingRefresh.compareAndSet(false, true)) {
            invalidationTracker.mDatabase.mQueryExecutor.execute(invalidationTracker.mRefreshRunnable);
        }
    }

    public final Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return this.mOpenHelper.getWritableDatabase().query(supportSQLiteQuery);
    }

    public final void setTransactionSuccessful() {
        this.mOpenHelper.getWritableDatabase().setTransactionSuccessful();
    }
}
