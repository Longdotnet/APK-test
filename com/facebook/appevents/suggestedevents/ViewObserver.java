package com.facebook.appevents.suggestedevents;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewTreeObserver;
import com.facebook.AccessTokenManager$$ExternalSyntheticLambda0;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class ViewObserver implements ViewTreeObserver.OnGlobalLayoutListener {
    public static final HashMap observers = new HashMap();
    public final WeakReference activityWeakReference;
    public final Handler uiThreadHandler = new Handler(Looper.getMainLooper());
    public final AtomicBoolean isTracking = new AtomicBoolean(false);

    public ViewObserver(Activity activity) {
        this.activityWeakReference = new WeakReference(activity);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            process();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
        }
    }

    public final void process() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            AccessTokenManager$$ExternalSyntheticLambda0 accessTokenManager$$ExternalSyntheticLambda0 = new AccessTokenManager$$ExternalSyntheticLambda0(this, 10);
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                accessTokenManager$$ExternalSyntheticLambda0.run();
            } else {
                this.uiThreadHandler.post(accessTokenManager$$ExternalSyntheticLambda0);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
        }
    }
}
