package androidx.work.impl.workers;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Logger$LogcatLogger;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintTrackingWorker extends ListenableWorker implements WorkConstraintsCallback {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("ConstraintTrkngWrkr");
    public volatile boolean mAreConstraintsUnmet;
    public ListenableWorker mDelegate;
    public final SettableFuture mFuture;
    public final Object mLock;
    public final WorkerParameters mWorkerParameters;

    public ConstraintTrackingWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.mWorkerParameters = workerParameters;
        this.mLock = new Object();
        this.mAreConstraintsUnmet = false;
        this.mFuture = new SettableFuture();
    }

    @Override // androidx.work.ListenableWorker
    public final TaskExecutor getTaskExecutor() {
        return WorkManagerImpl.getInstance(getApplicationContext()).mWorkTaskExecutor;
    }

    @Override // androidx.work.ListenableWorker
    public final boolean isRunInForeground() {
        ListenableWorker listenableWorker = this.mDelegate;
        return listenableWorker != null && listenableWorker.isRunInForeground();
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public final void onAllConstraintsMet(List list) {
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public final void onAllConstraintsNotMet(ArrayList arrayList) {
        Logger$LogcatLogger.get().debug(TAG, String.format("Constraints changed for %s", arrayList), new Throwable[0]);
        synchronized (this.mLock) {
            this.mAreConstraintsUnmet = true;
        }
    }

    @Override // androidx.work.ListenableWorker
    public final void onStopped() {
        super.onStopped();
        ListenableWorker listenableWorker = this.mDelegate;
        if (listenableWorker == null || listenableWorker.isStopped()) {
            return;
        }
        this.mDelegate.stop();
    }

    @Override // androidx.work.ListenableWorker
    public final ListenableFuture startWork() {
        getBackgroundExecutor().execute(new Worker.AnonymousClass1(this, 15));
        return this.mFuture;
    }
}
