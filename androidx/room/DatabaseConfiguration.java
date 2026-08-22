package androidx.room;

import android.content.Context;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.facebook.appevents.AppEventCollection;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class DatabaseConfiguration {
    public final boolean allowDestructiveMigrationOnDowngrade;
    public final Context context;
    public final AppEventCollection migrationContainer;
    public final String name;
    public final Executor queryExecutor;
    public final boolean requireMigration;
    public final SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory;
    public final Executor transactionExecutor;

    public DatabaseConfiguration(Context context, String str, SupportSQLiteOpenHelper.Factory factory, AppEventCollection appEventCollection, ArrayList arrayList, boolean z, int i, Executor executor, Executor executor2, boolean z2, boolean z3) {
        this.sqliteOpenHelperFactory = factory;
        this.context = context;
        this.name = str;
        this.migrationContainer = appEventCollection;
        this.queryExecutor = executor;
        this.transactionExecutor = executor2;
        this.requireMigration = z2;
        this.allowDestructiveMigrationOnDowngrade = z3;
    }
}
