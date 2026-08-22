package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteStatement;

/* JADX INFO: loaded from: classes.dex */
public final class FrameworkSQLiteStatement extends FrameworkSQLiteProgram {
    public final SQLiteStatement mDelegate;

    public FrameworkSQLiteStatement(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement, 0);
        this.mDelegate = sQLiteStatement;
    }

    public final void executeUpdateDelete() {
        this.mDelegate.executeUpdateDelete();
    }
}
