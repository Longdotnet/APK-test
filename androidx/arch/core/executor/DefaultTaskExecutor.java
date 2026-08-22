package androidx.arch.core.executor;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.core.os.HandlerCompat$Api28Impl;
import androidx.loader.content.ModernAsyncTask$1;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.io.TextStreamsKt;

/* JADX INFO: loaded from: classes.dex */
public final class DefaultTaskExecutor extends TextStreamsKt {
    public volatile Handler mMainHandler;
    public final Object mLock = new Object();
    public final ExecutorService mDiskIO = Executors.newFixedThreadPool(4, new ModernAsyncTask$1(1));

    public static Handler createAsync(Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return HandlerCompat$Api28Impl.createAsync(looper);
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            return new Handler(looper);
        } catch (InvocationTargetException unused2) {
            return new Handler(looper);
        }
    }
}
