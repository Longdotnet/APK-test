package androidx.work.impl;

import android.app.ActivityManager;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.executor.ArchTaskExecutor$$ExternalSyntheticLambda0;
import androidx.loader.app.gv.DYYbQc;
import androidx.room.DatabaseConfiguration;
import androidx.room.RoomDatabase;
import androidx.room.SQLiteCopyOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import androidx.work.Configuration;
import androidx.work.InputMergerFactory$1;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.background.greedy.GreedyScheduler;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.utils.ForceStopRunnable;
import androidx.work.impl.utils.IdGenerator;
import androidx.work.impl.utils.PackageManagerHelper;
import androidx.work.impl.utils.SerialExecutor;
import androidx.work.impl.utils.StopWorkRunnable;
import com.daerisoft.thespikerm.R;
import com.google.firebase.auth.zzaa;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.ExceptionsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class WorkManagerImpl extends ExceptionsKt {
    public static WorkManagerImpl sDefaultInstance;
    public static WorkManagerImpl sDelegatedInstance;
    public static final Object sLock;
    public final Configuration mConfiguration;
    public final Context mContext;
    public boolean mForceStopRunnableCompleted;
    public final IdGenerator mPreferenceUtils;
    public final Processor mProcessor;
    public BroadcastReceiver.PendingResult mRescheduleReceiverResult;
    public final List mSchedulers;
    public final WorkDatabase mWorkDatabase;
    public final zzaa mWorkTaskExecutor;

    static {
        Logger$LogcatLogger.tagWithPrefix("WorkManagerImpl");
        sDelegatedInstance = null;
        sDefaultInstance = null;
        sLock = new Object();
    }

    public static WorkManagerImpl getInstance() {
        synchronized (sLock) {
            try {
                WorkManagerImpl workManagerImpl = sDelegatedInstance;
                if (workManagerImpl != null) {
                    return workManagerImpl;
                }
                return sDefaultInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void initialize(Context context, Configuration configuration) {
        synchronized (sLock) {
            try {
                WorkManagerImpl workManagerImpl = sDelegatedInstance;
                if (workManagerImpl != null && sDefaultInstance != null) {
                    throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
                }
                if (workManagerImpl == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (sDefaultInstance == null) {
                        sDefaultInstance = new WorkManagerImpl(applicationContext, configuration, new zzaa(configuration.mTaskExecutor));
                    }
                    sDelegatedInstance = sDefaultInstance;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void onForceStopRunnableCompleted() {
        synchronized (sLock) {
            try {
                this.mForceStopRunnableCompleted = true;
                BroadcastReceiver.PendingResult pendingResult = this.mRescheduleReceiverResult;
                if (pendingResult != null) {
                    pendingResult.finish();
                    this.mRescheduleReceiverResult = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void rescheduleEligibleWork() {
        ArrayList pendingJobs;
        WorkDatabase workDatabase = this.mWorkDatabase;
        Context context = this.mContext;
        String str = SystemJobScheduler.TAG;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null && (pendingJobs = SystemJobScheduler.getPendingJobs(context, jobScheduler)) != null && !pendingJobs.isEmpty()) {
            Iterator it = pendingJobs.iterator();
            while (it.hasNext()) {
                SystemJobScheduler.cancelJobById(jobScheduler, ((JobInfo) it.next()).getId());
            }
        }
        WorkSpecDao_Impl workSpecDao_ImplWorkSpecDao = workDatabase.workSpecDao();
        WorkDatabase_Impl workDatabase_Impl = workSpecDao_ImplWorkSpecDao.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        WorkSpecDao_Impl.AnonymousClass2 anonymousClass2 = workSpecDao_ImplWorkSpecDao.__preparedStmtOfResetScheduledState;
        FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = anonymousClass2.acquire();
        workDatabase_Impl.beginTransaction();
        try {
            frameworkSQLiteStatementAcquire.mDelegate.executeUpdateDelete();
            workDatabase_Impl.setTransactionSuccessful();
            workDatabase_Impl.endTransaction();
            anonymousClass2.release(frameworkSQLiteStatementAcquire);
            Schedulers.schedule(this.mConfiguration, workDatabase, this.mSchedulers);
        } catch (Throwable th) {
            workDatabase_Impl.endTransaction();
            anonymousClass2.release(frameworkSQLiteStatementAcquire);
            throw th;
        }
    }

    public final void startWork(String str, zzaa zzaaVar) {
        zzaa zzaaVar2 = this.mWorkTaskExecutor;
        WorkerWrapper.AnonymousClass1 anonymousClass1 = new WorkerWrapper.AnonymousClass1(7);
        anonymousClass1.val$runExpedited = this;
        anonymousClass1.val$future = str;
        anonymousClass1.this$0 = zzaaVar;
        zzaaVar2.executeOnBackgroundThread(anonymousClass1);
    }

    public final void stopWork(String str) {
        this.mWorkTaskExecutor.executeOnBackgroundThread(new StopWorkRunnable(this, str, false));
    }

    public WorkManagerImpl(Context context, Configuration configuration, zzaa zzaaVar) {
        RoomDatabase.Builder builder;
        Executor executor;
        String str;
        boolean z = context.getResources().getBoolean(R.bool.workmanager_test_configuration);
        Context applicationContext = context.getApplicationContext();
        SerialExecutor serialExecutor = (SerialExecutor) zzaaVar.zza;
        int i = WorkDatabase.$r8$clinit;
        if (z) {
            builder = new RoomDatabase.Builder(applicationContext, null);
            builder.mAllowMainThreadQueries = true;
        } else {
            String str2 = WorkDatabasePathHelper.TAG;
            builder = new RoomDatabase.Builder(applicationContext, "androidx.work.workdb");
            builder.mFactory = new WorkDatabase.AnonymousClass1(applicationContext);
        }
        builder.mQueryExecutor = serialExecutor;
        WorkDatabase.AnonymousClass2 anonymousClass2 = new WorkDatabase.AnonymousClass2();
        if (builder.mCallbacks == null) {
            builder.mCallbacks = new ArrayList();
        }
        builder.mCallbacks.add(anonymousClass2);
        builder.addMigrations(WorkDatabaseMigrations.MIGRATION_1_2);
        builder.addMigrations(new WorkDatabaseMigrations.WorkMigration9To10(applicationContext, 2, 3));
        builder.addMigrations(WorkDatabaseMigrations.MIGRATION_3_4);
        builder.addMigrations(WorkDatabaseMigrations.MIGRATION_4_5);
        builder.addMigrations(new WorkDatabaseMigrations.WorkMigration9To10(applicationContext, 5, 6));
        builder.addMigrations(WorkDatabaseMigrations.MIGRATION_6_7);
        builder.addMigrations(WorkDatabaseMigrations.MIGRATION_7_8);
        builder.addMigrations(WorkDatabaseMigrations.MIGRATION_8_9);
        builder.addMigrations(new WorkDatabaseMigrations.WorkMigration9To10(applicationContext));
        builder.addMigrations(new WorkDatabaseMigrations.WorkMigration9To10(applicationContext, 10, 11));
        builder.addMigrations(WorkDatabaseMigrations.MIGRATION_11_12);
        builder.mRequireMigration = false;
        builder.mAllowDestructiveMigrationOnDowngrade = true;
        Context context2 = builder.mContext;
        if (context2 == null) {
            throw new IllegalArgumentException("Cannot provide null context for the database.");
        }
        Executor executor2 = builder.mQueryExecutor;
        if (executor2 == null && builder.mTransactionExecutor == null) {
            ArchTaskExecutor$$ExternalSyntheticLambda0 archTaskExecutor$$ExternalSyntheticLambda0 = ArchTaskExecutor.sIOThreadExecutor;
            builder.mTransactionExecutor = archTaskExecutor$$ExternalSyntheticLambda0;
            builder.mQueryExecutor = archTaskExecutor$$ExternalSyntheticLambda0;
        } else if (executor2 != null && builder.mTransactionExecutor == null) {
            builder.mTransactionExecutor = executor2;
        } else if (executor2 == null && (executor = builder.mTransactionExecutor) != null) {
            builder.mQueryExecutor = executor;
        }
        if (builder.mFactory == null) {
            builder.mFactory = new InputMergerFactory$1(19);
        }
        SupportSQLiteOpenHelper.Factory factory = builder.mFactory;
        ArrayList arrayList = builder.mCallbacks;
        boolean z2 = builder.mAllowMainThreadQueries;
        ActivityManager activityManager = (ActivityManager) context2.getSystemService("activity");
        int i2 = (activityManager == null || activityManager.isLowRamDevice()) ? 2 : 3;
        Executor executor3 = builder.mQueryExecutor;
        int i3 = i2;
        DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration(context2, builder.mName, factory, builder.mMigrationContainer, arrayList, z2, i3, executor3, builder.mTransactionExecutor, builder.mRequireMigration, builder.mAllowDestructiveMigrationOnDowngrade);
        String name = WorkDatabase.class.getPackage().getName();
        String canonicalName = WorkDatabase.class.getCanonicalName();
        String str3 = (name.isEmpty() ? canonicalName : canonicalName.substring(name.length() + 1)).replace('.', '_') + "_Impl";
        try {
            if (name.isEmpty()) {
                str = str3;
            } else {
                str = name + "." + str3;
            }
            RoomDatabase roomDatabase = (RoomDatabase) Class.forName(str).newInstance();
            SupportSQLiteOpenHelper supportSQLiteOpenHelperCreateOpenHelper = roomDatabase.createOpenHelper(databaseConfiguration);
            roomDatabase.mOpenHelper = supportSQLiteOpenHelperCreateOpenHelper;
            if (supportSQLiteOpenHelperCreateOpenHelper instanceof SQLiteCopyOpenHelper) {
                ((SQLiteCopyOpenHelper) supportSQLiteOpenHelperCreateOpenHelper).getClass();
            }
            boolean z3 = i3 == 3;
            supportSQLiteOpenHelperCreateOpenHelper.setWriteAheadLoggingEnabled(z3);
            roomDatabase.mCallbacks = arrayList;
            roomDatabase.mQueryExecutor = executor3;
            new ArrayDeque();
            roomDatabase.mAllowMainThreadQueries = z2;
            roomDatabase.mWriteAheadLoggingEnabled = z3;
            WorkDatabase workDatabase = (WorkDatabase) roomDatabase;
            Context applicationContext2 = context.getApplicationContext();
            Logger$LogcatLogger logger$LogcatLogger = new Logger$LogcatLogger(configuration.mLoggingLevel);
            synchronized (Logger$LogcatLogger.class) {
                Logger$LogcatLogger.sLogger = logger$LogcatLogger;
            }
            String str4 = Schedulers.TAG;
            SystemJobScheduler systemJobScheduler = new SystemJobScheduler(applicationContext2, this);
            PackageManagerHelper.setComponentEnabled(applicationContext2, SystemJobService.class, true);
            Logger$LogcatLogger.get().debug(Schedulers.TAG, "Created SystemJobScheduler and enabled SystemJobService", new Throwable[0]);
            List listAsList = Arrays.asList(systemJobScheduler, new GreedyScheduler(applicationContext2, configuration, zzaaVar, this));
            Processor processor = new Processor(context, configuration, zzaaVar, workDatabase, listAsList);
            Context applicationContext3 = context.getApplicationContext();
            this.mContext = applicationContext3;
            this.mConfiguration = configuration;
            this.mWorkTaskExecutor = zzaaVar;
            this.mWorkDatabase = workDatabase;
            this.mSchedulers = listAsList;
            this.mProcessor = processor;
            this.mPreferenceUtils = new IdGenerator(workDatabase);
            this.mForceStopRunnableCompleted = false;
            if (Build.VERSION.SDK_INT >= 24 && applicationContext3.isDeviceProtectedStorage()) {
                throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
            }
            this.mWorkTaskExecutor.executeOnBackgroundThread(new ForceStopRunnable(applicationContext3, this));
        } catch (ClassNotFoundException unused) {
            throw new RuntimeException(DYYbQc.gzpArjVrgtwyvsG + WorkDatabase.class.getCanonicalName() + ". " + str3 + " does not exist");
        } catch (IllegalAccessException unused2) {
            throw new RuntimeException("Cannot access the constructor" + WorkDatabase.class.getCanonicalName());
        } catch (InstantiationException unused3) {
            throw new RuntimeException("Failed to create an instance of " + WorkDatabase.class.getCanonicalName());
        }
    }

    public static WorkManagerImpl getInstance(Context context) {
        WorkManagerImpl workManagerImpl;
        synchronized (sLock) {
            try {
                workManagerImpl = getInstance();
                if (workManagerImpl == null) {
                    context.getApplicationContext();
                    throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return workManagerImpl;
    }
}
