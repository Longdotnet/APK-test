package androidx.sqlite.db;

import androidx.sqlite.db.framework.FrameworkSQLiteProgram;

/* JADX INFO: loaded from: classes.dex */
public interface SupportSQLiteQuery {
    void bindTo(FrameworkSQLiteProgram frameworkSQLiteProgram);

    String getSql();
}
