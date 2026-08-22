package androidx.room;

import android.database.sqlite.SQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.framework.FrameworkSQLiteProgram;
import java.io.Closeable;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public final class RoomSQLiteQuery implements SupportSQLiteQuery, Closeable {
    public static final TreeMap sQueryPool = new TreeMap();
    public int mArgCount;
    public final int[] mBindingTypes;
    public final byte[][] mBlobBindings;
    public final int mCapacity;
    public final double[] mDoubleBindings;
    public final long[] mLongBindings;
    public volatile String mQuery;
    public final String[] mStringBindings;

    public RoomSQLiteQuery(int i) {
        this.mCapacity = i;
        int i2 = i + 1;
        this.mBindingTypes = new int[i2];
        this.mLongBindings = new long[i2];
        this.mDoubleBindings = new double[i2];
        this.mStringBindings = new String[i2];
        this.mBlobBindings = new byte[i2][];
    }

    public static RoomSQLiteQuery acquire(int i, String str) {
        TreeMap treeMap = sQueryPool;
        synchronized (treeMap) {
            try {
                Map.Entry entryCeilingEntry = treeMap.ceilingEntry(Integer.valueOf(i));
                if (entryCeilingEntry == null) {
                    RoomSQLiteQuery roomSQLiteQuery = new RoomSQLiteQuery(i);
                    roomSQLiteQuery.mQuery = str;
                    roomSQLiteQuery.mArgCount = i;
                    return roomSQLiteQuery;
                }
                treeMap.remove(entryCeilingEntry.getKey());
                RoomSQLiteQuery roomSQLiteQuery2 = (RoomSQLiteQuery) entryCeilingEntry.getValue();
                roomSQLiteQuery2.mQuery = str;
                roomSQLiteQuery2.mArgCount = i;
                return roomSQLiteQuery2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void bindLong(int i, long j) {
        this.mBindingTypes[i] = 2;
        this.mLongBindings[i] = j;
    }

    public final void bindNull(int i) {
        this.mBindingTypes[i] = 1;
    }

    public final void bindString(int i, String str) {
        this.mBindingTypes[i] = 4;
        this.mStringBindings[i] = str;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public final void bindTo(FrameworkSQLiteProgram frameworkSQLiteProgram) {
        for (int i = 1; i <= this.mArgCount; i++) {
            int i2 = this.mBindingTypes[i];
            if (i2 == 1) {
                frameworkSQLiteProgram.bindNull(i);
            } else if (i2 == 2) {
                frameworkSQLiteProgram.bindLong(i, this.mLongBindings[i]);
            } else if (i2 == 3) {
                ((SQLiteProgram) frameworkSQLiteProgram.mDelegate).bindDouble(i, this.mDoubleBindings[i]);
            } else if (i2 == 4) {
                frameworkSQLiteProgram.bindString(i, this.mStringBindings[i]);
            } else if (i2 == 5) {
                frameworkSQLiteProgram.bindBlob(i, this.mBlobBindings[i]);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public final String getSql() {
        return this.mQuery;
    }

    public final void release() {
        TreeMap treeMap = sQueryPool;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.mCapacity), this);
            if (treeMap.size() > 15) {
                int size = treeMap.size() - 10;
                Iterator it = treeMap.descendingKeySet().iterator();
                while (true) {
                    int i = size - 1;
                    if (size <= 0) {
                        break;
                    }
                    it.next();
                    it.remove();
                    size = i;
                }
            }
        }
    }
}
