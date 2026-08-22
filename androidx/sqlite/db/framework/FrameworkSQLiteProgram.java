package androidx.sqlite.db.framework;

import android.database.Cursor;
import android.database.sqlite.SQLiteClosable;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteProgram;
import android.database.sqlite.SQLiteQuery;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.io.Closeable;

/* JADX INFO: loaded from: classes.dex */
public class FrameworkSQLiteProgram implements Closeable {
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public final /* synthetic */ int $r8$classId;
    public final SQLiteClosable mDelegate;

    public /* synthetic */ FrameworkSQLiteProgram(SQLiteClosable sQLiteClosable, int i) {
        this.$r8$classId = i;
        this.mDelegate = sQLiteClosable;
    }

    public void beginTransaction() {
        ((SQLiteDatabase) this.mDelegate).beginTransaction();
    }

    public void bindBlob(int i, byte[] bArr) {
        ((SQLiteProgram) this.mDelegate).bindBlob(i, bArr);
    }

    public void bindLong(int i, long j) {
        ((SQLiteProgram) this.mDelegate).bindLong(i, j);
    }

    public void bindNull(int i) {
        ((SQLiteProgram) this.mDelegate).bindNull(i);
    }

    public void bindString(int i, String str) {
        ((SQLiteProgram) this.mDelegate).bindString(i, str);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        switch (this.$r8$classId) {
            case 0:
                ((SQLiteProgram) this.mDelegate).close();
                break;
            default:
                ((SQLiteDatabase) this.mDelegate).close();
                break;
        }
    }

    public void endTransaction() {
        ((SQLiteDatabase) this.mDelegate).endTransaction();
    }

    public void execSQL(String str) {
        ((SQLiteDatabase) this.mDelegate).execSQL(str);
    }

    public Cursor query(String str) {
        return query(new SimpleSQLiteQuery(str));
    }

    public void setTransactionSuccessful() {
        ((SQLiteDatabase) this.mDelegate).setTransactionSuccessful();
    }

    public Cursor query(final SupportSQLiteQuery supportSQLiteQuery) {
        return ((SQLiteDatabase) this.mDelegate).rawQueryWithFactory(new SQLiteDatabase.CursorFactory() { // from class: androidx.sqlite.db.framework.FrameworkSQLiteDatabase$1
            @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
            public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                supportSQLiteQuery.bindTo(new FrameworkSQLiteProgram(sQLiteQuery, 0));
                return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
            }
        }, supportSQLiteQuery.getSql(), EMPTY_STRING_ARRAY, null);
    }
}
