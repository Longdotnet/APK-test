package androidx.loader.content;

import android.os.Looper;
import android.util.Log;
import com.android.billingclient.api.zzaz;
import com.google.android.gms.ads.rewarded.zQ.yzwzcWHcnH;
import com.google.android.gms.auth.api.signin.internal.zbc;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class AsyncTaskLoader$LoadTask implements Runnable {
    public static final ThreadPoolExecutor THREAD_POOL_EXECUTOR;
    public static volatile ThreadPoolExecutor sDefaultExecutor;
    public static ModernAsyncTask$InternalHandler sHandler;
    public final CountDownLatch mDone;
    public final ModernAsyncTask$3 mFuture;
    public final zzaz mWorker;
    public final /* synthetic */ zbc this$0;
    public volatile int mStatus = 1;
    public final AtomicBoolean mCancelled = new AtomicBoolean();
    public final AtomicBoolean mTaskInvoked = new AtomicBoolean();

    static {
        ModernAsyncTask$1 modernAsyncTask$1 = new ModernAsyncTask$1(0);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(10), modernAsyncTask$1);
        THREAD_POOL_EXECUTOR = threadPoolExecutor;
        sDefaultExecutor = threadPoolExecutor;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.loader.content.ModernAsyncTask$3] */
    public AsyncTaskLoader$LoadTask(zbc zbcVar) {
        this.this$0 = zbcVar;
        final zzaz zzazVar = new zzaz(this, 1);
        this.mWorker = zzazVar;
        this.mFuture = new FutureTask(zzazVar) { // from class: androidx.loader.content.ModernAsyncTask$3
            @Override // java.util.concurrent.FutureTask
            public final void done() {
                AsyncTaskLoader$LoadTask asyncTaskLoader$LoadTask = this.this$0;
                try {
                    Object obj = get();
                    if (asyncTaskLoader$LoadTask.mTaskInvoked.get()) {
                        return;
                    }
                    asyncTaskLoader$LoadTask.postResult(obj);
                } catch (InterruptedException e) {
                    Log.w(yzwzcWHcnH.eqKkWHHUVo, e);
                } catch (CancellationException unused) {
                    if (asyncTaskLoader$LoadTask.mTaskInvoked.get()) {
                        return;
                    }
                    asyncTaskLoader$LoadTask.postResult(null);
                } catch (ExecutionException e2) {
                    throw new RuntimeException("An error occurred while executing doInBackground()", e2.getCause());
                } catch (Throwable th) {
                    throw new RuntimeException("An error occurred while executing doInBackground()", th);
                }
            }
        };
        this.mDone = new CountDownLatch(1);
    }

    public final void doInBackground() {
        zbc zbcVar = this.this$0;
        Iterator it = zbcVar.zbb.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (((GoogleApiClient) it.next()).maybeSignIn(zbcVar)) {
                i++;
            }
        }
        try {
            zbcVar.zba.tryAcquire(i, 5L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Log.i("GACSignInLoader", "Unexpected InterruptedException", e);
            Thread.currentThread().interrupt();
        }
    }

    public final void postResult(Object obj) {
        ModernAsyncTask$InternalHandler modernAsyncTask$InternalHandler;
        synchronized (AsyncTaskLoader$LoadTask.class) {
            try {
                if (sHandler == null) {
                    sHandler = new ModernAsyncTask$InternalHandler(Looper.getMainLooper());
                }
                modernAsyncTask$InternalHandler = sHandler;
            } catch (Throwable th) {
                throw th;
            }
        }
        modernAsyncTask$InternalHandler.obtainMessage(1, new ModernAsyncTask$AsyncTaskResult(this, obj)).sendToTarget();
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.this$0.executePendingTask();
    }
}
