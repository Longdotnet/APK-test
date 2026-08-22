package androidx.arch.core.executor;

import android.os.Looper;
import kotlin.io.TextStreamsKt;

/* JADX INFO: loaded from: classes.dex */
public final class ArchTaskExecutor extends TextStreamsKt {
    public static final ArchTaskExecutor$$ExternalSyntheticLambda0 sIOThreadExecutor = new ArchTaskExecutor$$ExternalSyntheticLambda0(0);
    public static volatile ArchTaskExecutor sInstance;
    public final DefaultTaskExecutor mDelegate = new DefaultTaskExecutor();

    public static ArchTaskExecutor getInstance() {
        if (sInstance != null) {
            return sInstance;
        }
        synchronized (ArchTaskExecutor.class) {
            try {
                if (sInstance == null) {
                    sInstance = new ArchTaskExecutor();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sInstance;
    }

    public final void postToMainThread(Runnable runnable) {
        DefaultTaskExecutor defaultTaskExecutor = this.mDelegate;
        if (defaultTaskExecutor.mMainHandler == null) {
            synchronized (defaultTaskExecutor.mLock) {
                try {
                    if (defaultTaskExecutor.mMainHandler == null) {
                        defaultTaskExecutor.mMainHandler = DefaultTaskExecutor.createAsync(Looper.getMainLooper());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        defaultTaskExecutor.mMainHandler.post(runnable);
    }
}
