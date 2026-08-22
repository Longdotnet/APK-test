package androidx.room;

import android.database.sqlite.SQLiteDatabase;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public abstract class SharedSQLiteStatement {
    public final RoomDatabase mDatabase;
    public final AtomicBoolean mLock = new AtomicBoolean(false);
    public volatile FrameworkSQLiteStatement mStmt;

    public SharedSQLiteStatement(RoomDatabase roomDatabase) {
        this.mDatabase = roomDatabase;
    }

    public final FrameworkSQLiteStatement acquire() {
        this.mDatabase.assertNotMainThread();
        if (!this.mLock.compareAndSet(false, true)) {
            String strCreateQuery = createQuery();
            RoomDatabase roomDatabase = this.mDatabase;
            roomDatabase.assertNotMainThread();
            roomDatabase.assertNotSuspendingTransaction();
            return new FrameworkSQLiteStatement(((SQLiteDatabase) roomDatabase.mOpenHelper.getWritableDatabase().mDelegate).compileStatement(strCreateQuery));
        }
        if (this.mStmt == null) {
            String strCreateQuery2 = createQuery();
            RoomDatabase roomDatabase2 = this.mDatabase;
            roomDatabase2.assertNotMainThread();
            roomDatabase2.assertNotSuspendingTransaction();
            this.mStmt = new FrameworkSQLiteStatement(((SQLiteDatabase) roomDatabase2.mOpenHelper.getWritableDatabase().mDelegate).compileStatement(strCreateQuery2));
        }
        return this.mStmt;
    }

    public abstract String createQuery();

    public final void release(FrameworkSQLiteStatement frameworkSQLiteStatement) {
        if (frameworkSQLiteStatement == this.mStmt) {
            this.mLock.set(false);
        }
    }
}
