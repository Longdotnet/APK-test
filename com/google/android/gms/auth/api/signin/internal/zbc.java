package com.google.android.gms.auth.api.signin.internal;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;
import androidx.loader.app.LoaderManagerImpl;
import androidx.loader.content.AsyncTaskLoader$LoadTask;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import com.google.android.gms.signin.internal.FVfQ.GsPcpBmONXh;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.collections.MapsKt__MapsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class zbc implements SignInConnectionListener {
    public boolean mAbandoned;
    public volatile AsyncTaskLoader$LoadTask mCancellingTask;
    public boolean mContentChanged;
    public final ThreadPoolExecutor mExecutor;
    public LoaderManagerImpl.LoaderInfo mListener;
    public boolean mReset;
    public boolean mStarted;
    public volatile AsyncTaskLoader$LoadTask mTask;
    public final Semaphore zba;
    public final Set zbb;

    public zbc(SignInHubActivity signInHubActivity, Set set) {
        ThreadPoolExecutor threadPoolExecutor = AsyncTaskLoader$LoadTask.THREAD_POOL_EXECUTOR;
        this.mStarted = false;
        this.mAbandoned = false;
        this.mReset = true;
        this.mContentChanged = false;
        signInHubActivity.getApplicationContext();
        this.mExecutor = threadPoolExecutor;
        this.zba = new Semaphore(0);
        this.zbb = set;
    }

    public final void cancelLoad() {
        if (this.mTask != null) {
            if (!this.mStarted) {
                this.mContentChanged = true;
            }
            if (this.mCancellingTask != null) {
                this.mTask.getClass();
                this.mTask = null;
                return;
            }
            this.mTask.getClass();
            AsyncTaskLoader$LoadTask asyncTaskLoader$LoadTask = this.mTask;
            asyncTaskLoader$LoadTask.mCancelled.set(true);
            if (asyncTaskLoader$LoadTask.mFuture.cancel(false)) {
                this.mCancellingTask = this.mTask;
            }
            this.mTask = null;
        }
    }

    @Override // com.google.android.gms.common.api.internal.SignInConnectionListener
    public final void onComplete() {
        this.zba.release();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(64);
        MapsKt__MapsKt.buildShortClassTag(this, sb);
        sb.append(" id=");
        sb.append(0);
        sb.append("}");
        return sb.toString();
    }

    public final void executePendingTask() {
        if (this.mCancellingTask != null || this.mTask == null) {
            return;
        }
        this.mTask.getClass();
        AsyncTaskLoader$LoadTask asyncTaskLoader$LoadTask = this.mTask;
        ThreadPoolExecutor threadPoolExecutor = this.mExecutor;
        if (asyncTaskLoader$LoadTask.mStatus == 1) {
            asyncTaskLoader$LoadTask.mStatus = 2;
            asyncTaskLoader$LoadTask.mWorker.getClass();
            threadPoolExecutor.execute(asyncTaskLoader$LoadTask.mFuture);
        } else {
            int iOrdinal = Fragment$$ExternalSyntheticOutline0.ordinal(asyncTaskLoader$LoadTask.mStatus);
            if (iOrdinal == 1) {
                throw new IllegalStateException(GsPcpBmONXh.NoVBHUCSM);
            }
            if (iOrdinal == 2) {
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
            throw new IllegalStateException("We should never reach this state");
        }
    }
}
