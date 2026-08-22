package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import androidx.fragment.app.Fragment;
import com.facebook.AccessTokenManager$$ExternalSyntheticLambda0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class ProcessLifecycleOwner implements LifecycleOwner {
    public static final ProcessLifecycleOwner newInstance = new ProcessLifecycleOwner();
    public Handler handler;
    public int resumedCounter;
    public int startedCounter;
    public boolean pauseSent = true;
    public boolean stopSent = true;
    public final LifecycleRegistry registry = new LifecycleRegistry(this);
    public final AccessTokenManager$$ExternalSyntheticLambda0 delayedPauseRunnable = new AccessTokenManager$$ExternalSyntheticLambda0(this, 6);
    public final Fragment.AnonymousClass7 initializationListener = new Fragment.AnonymousClass7(this, 12);

    public abstract class Api29Impl {
        public static final void registerActivityLifecycleCallbacks(Activity activity, Application.ActivityLifecycleCallbacks callback) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(callback, "callback");
            activity.registerActivityLifecycleCallbacks(callback);
        }
    }

    public final void activityResumed$lifecycle_process_release() {
        int i = this.resumedCounter + 1;
        this.resumedCounter = i;
        if (i == 1) {
            if (this.pauseSent) {
                this.registry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
                this.pauseSent = false;
            } else {
                Handler handler = this.handler;
                Intrinsics.checkNotNull(handler);
                handler.removeCallbacks(this.delayedPauseRunnable);
            }
        }
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return this.registry;
    }
}
