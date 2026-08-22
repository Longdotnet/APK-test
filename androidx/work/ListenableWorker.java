package androidx.work;

import android.content.Context;
import android.net.Network;
import android.net.Uri;
import androidx.work.impl.utils.WorkForegroundUpdater;
import androidx.work.impl.utils.WorkProgressUpdater;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.facebook.appevents.suggestedevents.naLU.DaWYVMJ;
import com.google.common.util.concurrent.ListenableFuture;
import com.yoyogames.runner.RunnerJNILib;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ListenableWorker {
    public final Context mAppContext;
    public boolean mRunInForeground;
    public volatile boolean mStopped;
    public boolean mUsed;
    public final WorkerParameters mWorkerParams;

    /* JADX INFO: loaded from: classes.dex */
    public abstract class Result {

        public final class Failure extends Result {
            public final Data mOutputData = Data.EMPTY;

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || Failure.class != obj.getClass()) {
                    return false;
                }
                return this.mOutputData.equals(((Failure) obj).mOutputData);
            }

            public final int hashCode() {
                return this.mOutputData.hashCode() + 846803280;
            }

            public final String toString() {
                return "Failure {mOutputData=" + this.mOutputData + '}';
            }
        }

        public final class Retry extends Result {
            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && Retry.class == obj.getClass();
            }

            public final int hashCode() {
                return 25945934;
            }

            public final String toString() {
                return "Retry";
            }
        }

        public final class Success extends Result {
            public final Data mOutputData;

            public Success(Data data) {
                this.mOutputData = data;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || Success.class != obj.getClass()) {
                    return false;
                }
                return this.mOutputData.equals(((Success) obj).mOutputData);
            }

            public final int hashCode() {
                return this.mOutputData.hashCode() - 1876823561;
            }

            public final String toString() {
                return "Success {mOutputData=" + this.mOutputData + '}';
            }
        }
    }

    public final Context getApplicationContext() {
        return this.mAppContext;
    }

    public Executor getBackgroundExecutor() {
        return this.mWorkerParams.mBackgroundExecutor;
    }

    public ListenableFuture getForegroundInfoAsync() {
        SettableFuture settableFuture = new SettableFuture();
        settableFuture.setException(new IllegalStateException("Expedited WorkRequests require a ListenableWorker to provide an implementation for `getForegroundInfoAsync()`"));
        return settableFuture;
    }

    public final UUID getId() {
        return this.mWorkerParams.mId;
    }

    public final Data getInputData() {
        return this.mWorkerParams.mInputData;
    }

    public final Network getNetwork() {
        return (Network) this.mWorkerParams.mRuntimeExtras.zzc;
    }

    public final int getRunAttemptCount() {
        return this.mWorkerParams.mRunAttemptCount;
    }

    public final Set<String> getTags() {
        return this.mWorkerParams.mTags;
    }

    public TaskExecutor getTaskExecutor() {
        return this.mWorkerParams.mWorkTaskExecutor;
    }

    public final List<String> getTriggeredContentAuthorities() {
        return (List) this.mWorkerParams.mRuntimeExtras.zza;
    }

    public final List<Uri> getTriggeredContentUris() {
        return (List) this.mWorkerParams.mRuntimeExtras.zzb;
    }

    public WorkerFactory getWorkerFactory() {
        return this.mWorkerParams.mWorkerFactory;
    }

    public boolean isRunInForeground() {
        return this.mRunInForeground;
    }

    public final boolean isStopped() {
        return this.mStopped;
    }

    public final boolean isUsed() {
        return this.mUsed;
    }

    public void onStopped() {
    }

    public final ListenableFuture setForegroundAsync(ForegroundInfo foregroundInfo) {
        this.mRunInForeground = true;
        WorkForegroundUpdater workForegroundUpdater = this.mWorkerParams.mForegroundUpdater;
        Context applicationContext = getApplicationContext();
        UUID id = getId();
        workForegroundUpdater.getClass();
        SettableFuture settableFuture = new SettableFuture();
        workForegroundUpdater.mTaskExecutor.executeOnBackgroundThread(new WorkForegroundUpdater.AnonymousClass1(workForegroundUpdater, settableFuture, id, foregroundInfo, applicationContext, 0));
        return settableFuture;
    }

    public ListenableFuture setProgressAsync(Data data) {
        WorkProgressUpdater workProgressUpdater = this.mWorkerParams.mProgressUpdater;
        getApplicationContext();
        UUID id = getId();
        workProgressUpdater.getClass();
        SettableFuture settableFuture = new SettableFuture();
        workProgressUpdater.mTaskExecutor.executeOnBackgroundThread(new RunnerJNILib.AnonymousClass2(workProgressUpdater, id, data, settableFuture, 2));
        return settableFuture;
    }

    public void setRunInForeground(boolean z) {
        this.mRunInForeground = z;
    }

    public final void setUsed() {
        this.mUsed = true;
    }

    public abstract ListenableFuture startWork();

    public final void stop() {
        this.mStopped = true;
        onStopped();
    }

    public ListenableWorker(Context context, WorkerParameters workerParameters) {
        if (context != null) {
            if (workerParameters != null) {
                this.mAppContext = context;
                this.mWorkerParams = workerParameters;
                return;
            }
            throw new IllegalArgumentException("WorkerParameters is null");
        }
        throw new IllegalArgumentException(DaWYVMJ.NGzVd);
    }
}
