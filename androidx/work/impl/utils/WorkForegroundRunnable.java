package androidx.work.impl.utils;

import android.content.Context;
import androidx.core.os.BuildCompat;
import androidx.work.ForegroundInfo;
import androidx.work.ListenableWorker;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.android.gms.tasks.zzu;
import com.google.firebase.auth.zzaa;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class WorkForegroundRunnable implements Runnable {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("WorkForegroundRunnable");
    public final Context mContext;
    public final WorkForegroundUpdater mForegroundUpdater;
    public final SettableFuture mFuture = new SettableFuture();
    public final zzaa mTaskExecutor;
    public final WorkSpec mWorkSpec;
    public final ListenableWorker mWorker;

    public WorkForegroundRunnable(Context context, WorkSpec workSpec, ListenableWorker listenableWorker, WorkForegroundUpdater workForegroundUpdater, zzaa zzaaVar) {
        this.mContext = context;
        this.mWorkSpec = workSpec;
        this.mWorker = listenableWorker;
        this.mForegroundUpdater = workForegroundUpdater;
        this.mTaskExecutor = zzaaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.mWorkSpec.expedited || BuildCompat.isAtLeastS()) {
            this.mFuture.set(null);
            return;
        }
        final SettableFuture settableFuture = new SettableFuture();
        zzaa zzaaVar = this.mTaskExecutor;
        final int i = 0;
        ((zzu) zzaaVar.zzc).execute(new Runnable(this) { // from class: androidx.work.impl.utils.WorkForegroundRunnable.1
            public final /* synthetic */ WorkForegroundRunnable this$0;

            {
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i) {
                    case 0:
                        settableFuture.setFuture(this.this$0.mWorker.getForegroundInfoAsync());
                        return;
                    default:
                        WorkForegroundRunnable workForegroundRunnable = this.this$0;
                        try {
                            ForegroundInfo foregroundInfo = (ForegroundInfo) settableFuture.get();
                            if (foregroundInfo == null) {
                                throw new IllegalStateException("Worker was marked important (" + workForegroundRunnable.mWorkSpec.workerClassName + ") but did not provide ForegroundInfo");
                            }
                            Logger$LogcatLogger logger$LogcatLogger = Logger$LogcatLogger.get();
                            String str = WorkForegroundRunnable.TAG;
                            WorkSpec workSpec = workForegroundRunnable.mWorkSpec;
                            ListenableWorker listenableWorker = workForegroundRunnable.mWorker;
                            logger$LogcatLogger.debug(str, "Updating notification for " + workSpec.workerClassName, new Throwable[0]);
                            listenableWorker.setRunInForeground(true);
                            SettableFuture settableFuture2 = workForegroundRunnable.mFuture;
                            WorkForegroundUpdater workForegroundUpdater = workForegroundRunnable.mForegroundUpdater;
                            Context context = workForegroundRunnable.mContext;
                            UUID id = listenableWorker.getId();
                            workForegroundUpdater.getClass();
                            SettableFuture settableFuture3 = new SettableFuture();
                            workForegroundUpdater.mTaskExecutor.executeOnBackgroundThread(new WorkForegroundUpdater.AnonymousClass1(workForegroundUpdater, settableFuture3, id, foregroundInfo, context, 0));
                            settableFuture2.setFuture(settableFuture3);
                            return;
                        } catch (Throwable th) {
                            workForegroundRunnable.mFuture.setException(th);
                            return;
                        }
                }
            }
        });
        final int i2 = 1;
        settableFuture.addListener(new Runnable(this) { // from class: androidx.work.impl.utils.WorkForegroundRunnable.1
            public final /* synthetic */ WorkForegroundRunnable this$0;

            {
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i2) {
                    case 0:
                        settableFuture.setFuture(this.this$0.mWorker.getForegroundInfoAsync());
                        return;
                    default:
                        WorkForegroundRunnable workForegroundRunnable = this.this$0;
                        try {
                            ForegroundInfo foregroundInfo = (ForegroundInfo) settableFuture.get();
                            if (foregroundInfo == null) {
                                throw new IllegalStateException("Worker was marked important (" + workForegroundRunnable.mWorkSpec.workerClassName + ") but did not provide ForegroundInfo");
                            }
                            Logger$LogcatLogger logger$LogcatLogger = Logger$LogcatLogger.get();
                            String str = WorkForegroundRunnable.TAG;
                            WorkSpec workSpec = workForegroundRunnable.mWorkSpec;
                            ListenableWorker listenableWorker = workForegroundRunnable.mWorker;
                            logger$LogcatLogger.debug(str, "Updating notification for " + workSpec.workerClassName, new Throwable[0]);
                            listenableWorker.setRunInForeground(true);
                            SettableFuture settableFuture2 = workForegroundRunnable.mFuture;
                            WorkForegroundUpdater workForegroundUpdater = workForegroundRunnable.mForegroundUpdater;
                            Context context = workForegroundRunnable.mContext;
                            UUID id = listenableWorker.getId();
                            workForegroundUpdater.getClass();
                            SettableFuture settableFuture3 = new SettableFuture();
                            workForegroundUpdater.mTaskExecutor.executeOnBackgroundThread(new WorkForegroundUpdater.AnonymousClass1(workForegroundUpdater, settableFuture3, id, foregroundInfo, context, 0));
                            settableFuture2.setFuture(settableFuture3);
                            return;
                        } catch (Throwable th) {
                            workForegroundRunnable.mFuture.setException(th);
                            return;
                        }
                }
            }
        }, (zzu) zzaaVar.zzc);
    }
}
