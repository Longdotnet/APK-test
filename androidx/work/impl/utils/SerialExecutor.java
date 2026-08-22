package androidx.work.impl.utils;

import com.google.android.gms.ads.zza;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class SerialExecutor implements Executor {
    public volatile Runnable mActive;
    public final ExecutorService mExecutor;
    public final ArrayDeque mTasks = new ArrayDeque();
    public final Object mLock = new Object();

    public SerialExecutor(ExecutorService executorService) {
        this.mExecutor = executorService;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        synchronized (this.mLock) {
            try {
                this.mTasks.add(new zza(this, runnable, 10));
                if (this.mActive == null) {
                    scheduleNext();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean hasPendingTasks() {
        boolean z;
        synchronized (this.mLock) {
            z = !this.mTasks.isEmpty();
        }
        return z;
    }

    public final void scheduleNext() {
        synchronized (this.mLock) {
            try {
                Runnable runnable = (Runnable) this.mTasks.poll();
                this.mActive = runnable;
                if (runnable != null) {
                    this.mExecutor.execute(this.mActive);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
