package androidx.sqlite.db;

import androidx.sqlite.db.framework.FrameworkSQLiteProgram;
import com.android.billingclient.api.BillingFlowParams;
import java.io.Closeable;

/* JADX INFO: loaded from: classes.dex */
public interface SupportSQLiteOpenHelper extends Closeable {

    public interface Factory {
        SupportSQLiteOpenHelper create(BillingFlowParams billingFlowParams);
    }

    FrameworkSQLiteProgram getWritableDatabase();

    void setWriteAheadLoggingEnabled(boolean z);
}
