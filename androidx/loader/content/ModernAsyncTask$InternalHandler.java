package androidx.loader.content;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.loader.app.LoaderManagerImpl;
import com.google.android.gms.auth.api.signin.internal.zbc;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
public final class ModernAsyncTask$InternalHandler extends Handler {
    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        ModernAsyncTask$AsyncTaskResult modernAsyncTask$AsyncTaskResult = (ModernAsyncTask$AsyncTaskResult) message.obj;
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                return;
            }
            modernAsyncTask$AsyncTaskResult.mTask.getClass();
            return;
        }
        AsyncTaskLoader$LoadTask asyncTaskLoader$LoadTask = modernAsyncTask$AsyncTaskResult.mTask;
        Object obj = modernAsyncTask$AsyncTaskResult.mData[0];
        if (asyncTaskLoader$LoadTask.mCancelled.get()) {
            CountDownLatch countDownLatch = asyncTaskLoader$LoadTask.mDone;
            try {
                zbc zbcVar = asyncTaskLoader$LoadTask.this$0;
                if (zbcVar.mCancellingTask == asyncTaskLoader$LoadTask) {
                    SystemClock.uptimeMillis();
                    zbcVar.mCancellingTask = null;
                    zbcVar.executePendingTask();
                }
                countDownLatch.countDown();
            } catch (Throwable th) {
                countDownLatch.countDown();
                throw th;
            }
        } else {
            try {
                zbc zbcVar2 = asyncTaskLoader$LoadTask.this$0;
                if (zbcVar2.mTask != asyncTaskLoader$LoadTask) {
                    if (zbcVar2.mCancellingTask == asyncTaskLoader$LoadTask) {
                        SystemClock.uptimeMillis();
                        zbcVar2.mCancellingTask = null;
                        zbcVar2.executePendingTask();
                    }
                } else if (!zbcVar2.mAbandoned) {
                    SystemClock.uptimeMillis();
                    zbcVar2.mTask = null;
                    LoaderManagerImpl.LoaderInfo loaderInfo = zbcVar2.mListener;
                    if (loaderInfo != null) {
                        if (Looper.myLooper() == Looper.getMainLooper()) {
                            loaderInfo.setValue(obj);
                        } else {
                            loaderInfo.postValue(obj);
                        }
                    }
                }
                asyncTaskLoader$LoadTask.mDone.countDown();
            } catch (Throwable th2) {
                asyncTaskLoader$LoadTask.mDone.countDown();
                throw th2;
            }
        }
        asyncTaskLoader$LoadTask.mStatus = 3;
    }
}
