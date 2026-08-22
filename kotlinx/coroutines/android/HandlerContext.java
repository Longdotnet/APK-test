package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: loaded from: classes3.dex */
public final class HandlerContext extends CoroutineDispatcher implements Delay {
    private volatile HandlerContext _immediate;
    public final Handler handler;
    public final HandlerContext immediate;
    public final boolean invokeImmediately;
    public final String name;

    public HandlerContext(Handler handler, String str, boolean z) {
        this.handler = handler;
        this.name = str;
        this.invokeImmediately = z;
        this._immediate = z ? this : null;
        HandlerContext handlerContext = this._immediate;
        if (handlerContext == null) {
            handlerContext = new HandlerContext(handler, str, true);
            this._immediate = handlerContext;
        }
        this.immediate = handlerContext;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        if (this.handler.post(runnable)) {
            return;
        }
        CancellationException cancellationException = new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed");
        Job job = (Job) coroutineContext.get(Job.Key.$$INSTANCE);
        if (job != null) {
            ((JobSupport) job).cancelImpl$kotlinx_coroutines_core(cancellationException);
        }
        Dispatchers.IO.dispatch(coroutineContext, runnable);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof HandlerContext) && ((HandlerContext) obj).handler == this.handler;
    }

    public final int hashCode() {
        return System.identityHashCode(this.handler);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final boolean isDispatchNeeded() {
        return (this.invokeImmediately && Intrinsics.areEqual(Looper.myLooper(), this.handler.getLooper())) ? false : true;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        HandlerContext handlerContext;
        String str;
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        HandlerContext handlerContext2 = MainDispatcherLoader.dispatcher;
        if (this == handlerContext2) {
            str = "Dispatchers.Main";
        } else {
            try {
                handlerContext = handlerContext2.immediate;
            } catch (UnsupportedOperationException unused) {
                handlerContext = null;
            }
            str = this == handlerContext ? "Dispatchers.Main.immediate" : null;
        }
        if (str != null) {
            return str;
        }
        String string = this.name;
        if (string == null) {
            string = this.handler.toString();
        }
        return this.invokeImmediately ? CoroutineAdapterKt$$ExternalSyntheticLambda0.m(string, ".immediate") : string;
    }

    public HandlerContext(Handler handler) {
        this(handler, null, false);
    }
}
