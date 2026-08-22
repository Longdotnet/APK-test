package androidx.work.impl;

import android.content.Context;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.VERT.YcVWhnLsj;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTagDao_Impl$1;
import com.android.billingclient.api.BillingFlowParams;
import com.facebook.ProfileCache;
import com.google.firebase.auth.zzaa;
import java.util.HashMap;
import okhttp3.Dispatcher;

/* JADX INFO: loaded from: classes2.dex */
public final class WorkDatabase_Impl extends WorkDatabase {
    public static final /* synthetic */ int $r8$clinit = 0;
    public volatile RoomOpenHelper _dependencyDao;
    public volatile RoomOpenHelper _preferenceDao;
    public volatile zzaa _systemIdInfoDao;
    public volatile RoomOpenHelper _workNameDao;
    public volatile Dispatcher _workProgressDao;
    public volatile WorkSpecDao_Impl _workSpecDao;
    public volatile RoomOpenHelper _workTagDao;

    @Override // androidx.room.RoomDatabase
    public final InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference");
    }

    @Override // androidx.work.impl.WorkDatabase
    public final RoomOpenHelper dependencyDao() {
        RoomOpenHelper roomOpenHelper;
        if (this._dependencyDao != null) {
            return this._dependencyDao;
        }
        synchronized (this) {
            try {
                if (this._dependencyDao == null) {
                    this._dependencyDao = new RoomOpenHelper(this, 13);
                }
                roomOpenHelper = this._dependencyDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return roomOpenHelper;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final RoomOpenHelper preferenceDao() {
        RoomOpenHelper roomOpenHelper;
        if (this._preferenceDao != null) {
            return this._preferenceDao;
        }
        synchronized (this) {
            try {
                if (this._preferenceDao == null) {
                    this._preferenceDao = new RoomOpenHelper(this, 14);
                }
                roomOpenHelper = this._preferenceDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return roomOpenHelper;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final zzaa systemIdInfoDao() {
        zzaa zzaaVar;
        if (this._systemIdInfoDao != null) {
            return this._systemIdInfoDao;
        }
        synchronized (this) {
            try {
                if (this._systemIdInfoDao == null) {
                    this._systemIdInfoDao = new zzaa(this);
                }
                zzaaVar = this._systemIdInfoDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzaaVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final RoomOpenHelper workNameDao() {
        RoomOpenHelper roomOpenHelper;
        if (this._workNameDao != null) {
            return this._workNameDao;
        }
        synchronized (this) {
            try {
                if (this._workNameDao == null) {
                    this._workNameDao = new RoomOpenHelper(this, 15);
                }
                roomOpenHelper = this._workNameDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return roomOpenHelper;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final Dispatcher workProgressDao() {
        Dispatcher dispatcher;
        if (this._workProgressDao != null) {
            return this._workProgressDao;
        }
        synchronized (this) {
            try {
                if (this._workProgressDao == null) {
                    Dispatcher dispatcher2 = new Dispatcher();
                    dispatcher2.executorServiceOrNull = this;
                    dispatcher2.readyAsyncCalls = new WorkTagDao_Impl$1(this, 5);
                    dispatcher2.runningAsyncCalls = new WorkSpecDao_Impl.AnonymousClass2(this, 2);
                    dispatcher2.runningSyncCalls = new WorkSpecDao_Impl.AnonymousClass2(this, 3);
                    this._workProgressDao = dispatcher2;
                }
                dispatcher = this._workProgressDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dispatcher;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final WorkSpecDao_Impl workSpecDao() {
        WorkSpecDao_Impl workSpecDao_Impl;
        if (this._workSpecDao != null) {
            return this._workSpecDao;
        }
        synchronized (this) {
            try {
                if (this._workSpecDao == null) {
                    this._workSpecDao = new WorkSpecDao_Impl(this);
                }
                workSpecDao_Impl = this._workSpecDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return workSpecDao_Impl;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final RoomOpenHelper workTagDao() {
        RoomOpenHelper roomOpenHelper;
        if (this._workTagDao != null) {
            return this._workTagDao;
        }
        synchronized (this) {
            try {
                if (this._workTagDao == null) {
                    this._workTagDao = new RoomOpenHelper(this, 16);
                }
                roomOpenHelper = this._workTagDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return roomOpenHelper;
    }

    @Override // androidx.room.RoomDatabase
    public final SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        RoomOpenHelper roomOpenHelper = new RoomOpenHelper(databaseConfiguration, new ProfileCache(this, 16), 0, false);
        Context context = databaseConfiguration.context;
        if (context == null) {
            throw new IllegalArgumentException(YcVWhnLsj.BtJFONgtaWlz);
        }
        return databaseConfiguration.sqliteOpenHelperFactory.create(new BillingFlowParams(context, databaseConfiguration.name, roomOpenHelper, false));
    }
}
