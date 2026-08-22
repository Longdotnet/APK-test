package androidx.work.impl;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.core.content.ContextCompat;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.work.Configuration;
import androidx.work.ForegroundInfo;
import androidx.work.ListenableWorker;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.foreground.SystemForegroundService;
import androidx.work.impl.utils.SerialExecutor;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.android.gms.tasks.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.auth.zzaa;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class Processor implements ExecutionListener {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("Processor");
    public final Context mAppContext;
    public final Configuration mConfiguration;
    public final List mSchedulers;
    public final WorkDatabase mWorkDatabase;
    public final zzaa mWorkTaskExecutor;
    public final HashMap mEnqueuedWorkMap = new HashMap();
    public final HashMap mForegroundWorkMap = new HashMap();
    public final HashSet mCancelledIds = new HashSet();
    public final ArrayList mOuterListeners = new ArrayList();
    public PowerManager.WakeLock mForegroundLock = null;
    public final Object mLock = new Object();

    public Processor(Context context, Configuration configuration, zzaa zzaaVar, WorkDatabase workDatabase, List list) {
        this.mAppContext = context;
        this.mConfiguration = configuration;
        this.mWorkTaskExecutor = zzaaVar;
        this.mWorkDatabase = workDatabase;
        this.mSchedulers = list;
    }

    public static boolean interrupt(String str, WorkerWrapper workerWrapper) {
        boolean zIsDone;
        if (workerWrapper == null) {
            Logger$LogcatLogger.get().debug(TAG, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("WorkerWrapper could not be found for ", str), new Throwable[0]);
            return false;
        }
        workerWrapper.mInterrupted = true;
        workerWrapper.tryCheckForInterruptionAndResolve();
        ListenableFuture listenableFuture = workerWrapper.mInnerFuture;
        if (listenableFuture != null) {
            zIsDone = listenableFuture.isDone();
            workerWrapper.mInnerFuture.cancel(true);
        } else {
            zIsDone = false;
        }
        ListenableWorker listenableWorker = workerWrapper.mWorker;
        if (listenableWorker == null || zIsDone) {
            Logger$LogcatLogger.get().debug(WorkerWrapper.TAG, "WorkSpec " + workerWrapper.mWorkSpec + " is already done. Not interrupting.", new Throwable[0]);
        } else {
            listenableWorker.stop();
        }
        Logger$LogcatLogger.get().debug(TAG, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("WorkerWrapper interrupted for ", str), new Throwable[0]);
        return true;
    }

    public final void addExecutionListener(ExecutionListener executionListener) {
        synchronized (this.mLock) {
            this.mOuterListeners.add(executionListener);
        }
    }

    public final boolean isCancelled(String str) {
        boolean zContains;
        synchronized (this.mLock) {
            zContains = this.mCancelledIds.contains(str);
        }
        return zContains;
    }

    public final boolean isEnqueued(String str) {
        boolean z;
        synchronized (this.mLock) {
            try {
                z = this.mEnqueuedWorkMap.containsKey(str) || this.mForegroundWorkMap.containsKey(str);
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @Override // androidx.work.impl.ExecutionListener
    public final void onExecuted(String str, boolean z) {
        synchronized (this.mLock) {
            try {
                this.mEnqueuedWorkMap.remove(str);
                Logger$LogcatLogger.get().debug(TAG, "Processor " + str + " executed; reschedule = " + z, new Throwable[0]);
                Iterator it = this.mOuterListeners.iterator();
                while (it.hasNext()) {
                    ((ExecutionListener) it.next()).onExecuted(str, z);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void removeExecutionListener(ExecutionListener executionListener) {
        synchronized (this.mLock) {
            this.mOuterListeners.remove(executionListener);
        }
    }

    public final void startForeground(String str, ForegroundInfo foregroundInfo) {
        synchronized (this.mLock) {
            try {
                Logger$LogcatLogger.get().info(TAG, "Moving WorkSpec (" + str + ") to the foreground", new Throwable[0]);
                WorkerWrapper workerWrapper = (WorkerWrapper) this.mEnqueuedWorkMap.remove(str);
                if (workerWrapper != null) {
                    if (this.mForegroundLock == null) {
                        PowerManager.WakeLock wakeLockNewWakeLock = WakeLocks.newWakeLock(this.mAppContext, "ProcessorForegroundLck");
                        this.mForegroundLock = wakeLockNewWakeLock;
                        wakeLockNewWakeLock.acquire();
                    }
                    this.mForegroundWorkMap.put(str, workerWrapper);
                    ContextCompat.startForegroundService(this.mAppContext, SystemForegroundDispatcher.createStartForegroundIntent(this.mAppContext, str, foregroundInfo));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean startWork(String str, zzaa zzaaVar) {
        synchronized (this.mLock) {
            try {
                if (isEnqueued(str)) {
                    Logger$LogcatLogger.get().debug(TAG, "Work " + str + " is already enqueued for processing", new Throwable[0]);
                    return false;
                }
                Context context = this.mAppContext;
                Configuration configuration = this.mConfiguration;
                zzaa zzaaVar2 = this.mWorkTaskExecutor;
                WorkDatabase workDatabase = this.mWorkDatabase;
                zzaa zzaaVar3 = new zzaa();
                Context applicationContext = context.getApplicationContext();
                List list = this.mSchedulers;
                if (zzaaVar == null) {
                    zzaaVar = zzaaVar3;
                }
                WorkerWrapper workerWrapper = new WorkerWrapper();
                workerWrapper.mResult = new ListenableWorker.Result.Failure();
                workerWrapper.mFuture = new SettableFuture();
                workerWrapper.mInnerFuture = null;
                workerWrapper.mAppContext = applicationContext;
                workerWrapper.mWorkTaskExecutor = zzaaVar2;
                workerWrapper.mForegroundProcessor = this;
                workerWrapper.mWorkSpecId = str;
                workerWrapper.mSchedulers = list;
                workerWrapper.mRuntimeExtras = zzaaVar;
                workerWrapper.mWorker = null;
                workerWrapper.mConfiguration = configuration;
                workerWrapper.mWorkDatabase = workDatabase;
                workerWrapper.mWorkSpecDao = workDatabase.workSpecDao();
                workerWrapper.mDependencyDao = workDatabase.dependencyDao();
                workerWrapper.mWorkTagDao = workDatabase.workTagDao();
                SettableFuture settableFuture = workerWrapper.mFuture;
                WorkerWrapper.AnonymousClass1 anonymousClass1 = new WorkerWrapper.AnonymousClass1(3);
                anonymousClass1.val$future = this;
                anonymousClass1.this$0 = str;
                anonymousClass1.val$runExpedited = settableFuture;
                settableFuture.addListener(anonymousClass1, (zzu) this.mWorkTaskExecutor.zzc);
                this.mEnqueuedWorkMap.put(str, workerWrapper);
                ((SerialExecutor) this.mWorkTaskExecutor.zza).execute(workerWrapper);
                Logger$LogcatLogger.get().debug(TAG, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Processor: processing ", str), new Throwable[0]);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void stopForegroundService() {
        synchronized (this.mLock) {
            try {
                if (this.mForegroundWorkMap.isEmpty()) {
                    Context context = this.mAppContext;
                    String str = SystemForegroundDispatcher.TAG;
                    Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
                    intent.setAction("ACTION_STOP_FOREGROUND");
                    try {
                        this.mAppContext.startService(intent);
                    } catch (Throwable th) {
                        Logger$LogcatLogger.get().error(TAG, "Unable to stop foreground service", th);
                    }
                    PowerManager.WakeLock wakeLock = this.mForegroundLock;
                    if (wakeLock != null) {
                        wakeLock.release();
                        this.mForegroundLock = null;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean stopForegroundWork(String str) {
        boolean zInterrupt;
        synchronized (this.mLock) {
            Logger$LogcatLogger.get().debug(TAG, "Processor stopping foreground work " + str, new Throwable[0]);
            zInterrupt = interrupt(str, (WorkerWrapper) this.mForegroundWorkMap.remove(str));
        }
        return zInterrupt;
    }

    public final boolean stopWork(String str) {
        boolean zInterrupt;
        synchronized (this.mLock) {
            Logger$LogcatLogger.get().debug(TAG, "Processor stopping background work " + str, new Throwable[0]);
            zInterrupt = interrupt(str, (WorkerWrapper) this.mEnqueuedWorkMap.remove(str));
        }
        return zInterrupt;
    }
}
