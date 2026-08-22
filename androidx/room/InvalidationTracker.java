package androidx.room;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.sqlite.db.framework.FrameworkSQLiteProgram;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import androidx.work.Worker;
import androidx.work.impl.WorkDatabase_Impl;
import com.google.android.gms.ads.internal.util.zzci;
import com.google.android.gms.internal.common.Ko.TSDAbK;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes2.dex */
public final class InvalidationTracker {
    public static final String[] TRIGGERS = {"UPDATE", "DELETE", "INSERT"};
    public volatile FrameworkSQLiteStatement mCleanupStatement;
    public final WorkDatabase_Impl mDatabase;
    public final zzci mObservedTableTracker;
    public final String[] mTableNames;
    public final AtomicBoolean mPendingRefresh = new AtomicBoolean(false);
    public volatile boolean mInitialized = false;
    public final SafeIterableMap mObserverMap = new SafeIterableMap();
    public final Worker.AnonymousClass1 mRefreshRunnable = new Worker.AnonymousClass1(this, 14);
    public final HashMap mTableIdLookup = new HashMap();

    /* JADX INFO: loaded from: classes.dex */
    public abstract class ObserverWrapper {
    }

    public InvalidationTracker(WorkDatabase_Impl workDatabase_Impl, HashMap map, HashMap map2, String... strArr) {
        this.mDatabase = workDatabase_Impl;
        this.mObservedTableTracker = new zzci(strArr.length);
        Collections.newSetFromMap(new IdentityHashMap());
        int length = strArr.length;
        this.mTableNames = new String[length];
        for (int i = 0; i < length; i++) {
            String str = strArr[i];
            Locale locale = Locale.US;
            String lowerCase = str.toLowerCase(locale);
            this.mTableIdLookup.put(lowerCase, Integer.valueOf(i));
            String str2 = (String) map.get(strArr[i]);
            if (str2 != null) {
                this.mTableNames[i] = str2.toLowerCase(locale);
            } else {
                this.mTableNames[i] = lowerCase;
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            String str3 = (String) entry.getValue();
            Locale locale2 = Locale.US;
            String lowerCase2 = str3.toLowerCase(locale2);
            if (this.mTableIdLookup.containsKey(lowerCase2)) {
                String lowerCase3 = ((String) entry.getKey()).toLowerCase(locale2);
                HashMap map3 = this.mTableIdLookup;
                map3.put(lowerCase3, map3.get(lowerCase2));
            }
        }
    }

    public final boolean ensureInitialization() {
        FrameworkSQLiteProgram frameworkSQLiteProgram = this.mDatabase.mDatabase;
        if (!(frameworkSQLiteProgram != null && ((SQLiteDatabase) frameworkSQLiteProgram.mDelegate).isOpen())) {
            return false;
        }
        if (!this.mInitialized) {
            this.mDatabase.mOpenHelper.getWritableDatabase();
        }
        if (this.mInitialized) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    public final void syncTriggers(FrameworkSQLiteProgram frameworkSQLiteProgram) {
        if (((SQLiteDatabase) frameworkSQLiteProgram.mDelegate).inTransaction()) {
            return;
        }
        while (true) {
            try {
                ReentrantReadWriteLock.ReadLock lock = this.mDatabase.mCloseLock.readLock();
                lock.lock();
                try {
                    int[] tablesToSync = this.mObservedTableTracker.getTablesToSync();
                    if (tablesToSync == null) {
                        lock.unlock();
                        return;
                    }
                    int length = tablesToSync.length;
                    frameworkSQLiteProgram.beginTransaction();
                    for (int i = 0; i < length; i++) {
                        try {
                            int i2 = tablesToSync[i];
                            if (i2 == 1) {
                                startTrackingTable(frameworkSQLiteProgram, i);
                            } else if (i2 == 2) {
                                String str = this.mTableNames[i];
                                StringBuilder sb = new StringBuilder();
                                String[] strArr = TRIGGERS;
                                for (int i3 = 0; i3 < 3; i3++) {
                                    String str2 = strArr[i3];
                                    sb.setLength(0);
                                    sb.append("DROP TRIGGER IF EXISTS ");
                                    sb.append("`");
                                    sb.append("room_table_modification_trigger_");
                                    sb.append(str);
                                    sb.append("_");
                                    sb.append(str2);
                                    sb.append("`");
                                    frameworkSQLiteProgram.execSQL(sb.toString());
                                }
                            }
                        } catch (Throwable th) {
                            frameworkSQLiteProgram.endTransaction();
                            throw th;
                        }
                    }
                    frameworkSQLiteProgram.setTransactionSuccessful();
                    frameworkSQLiteProgram.endTransaction();
                    zzci zzciVar = this.mObservedTableTracker;
                    synchronized (zzciVar) {
                        zzciVar.zzd = false;
                    }
                    lock.unlock();
                } catch (Throwable th2) {
                    lock.unlock();
                    throw th2;
                }
            } catch (SQLiteException | IllegalStateException e) {
                Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e);
                return;
            }
        }
    }

    public final void startTrackingTable(FrameworkSQLiteProgram frameworkSQLiteProgram, int i) {
        frameworkSQLiteProgram.execSQL(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "INSERT OR IGNORE INTO room_table_modification_log VALUES(", ", 0)"));
        String str = this.mTableNames[i];
        StringBuilder sb = new StringBuilder();
        String[] strArr = TRIGGERS;
        for (int i2 = 0; i2 < 3; i2++) {
            String str2 = strArr[i2];
            sb.setLength(0);
            sb.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            sb.append("`");
            sb.append("room_table_modification_trigger_");
            sb.append(str);
            sb.append("_");
            sb.append(str2);
            sb.append("`");
            sb.append(" AFTER ");
            sb.append(str2);
            sb.append(" ON `");
            sb.append(str);
            sb.append("` BEGIN UPDATE ");
            sb.append(TSDAbK.kNaVUNqk);
            sb.append(" SET ");
            sb.append("invalidated");
            sb.append(" = 1");
            sb.append(" WHERE ");
            sb.append("table_id");
            sb.append(" = ");
            sb.append(i);
            sb.append(" AND ");
            sb.append("invalidated");
            sb.append(" = 0");
            sb.append("; END");
            frameworkSQLiteProgram.execSQL(sb.toString());
        }
    }
}
