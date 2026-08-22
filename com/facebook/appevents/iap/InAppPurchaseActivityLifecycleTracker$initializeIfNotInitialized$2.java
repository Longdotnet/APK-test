package com.facebook.appevents.iap;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.sqlite.db.framework.VERT.YcVWhnLsj;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventQueue$$ExternalSyntheticLambda0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class InAppPurchaseActivityLifecycleTracker$initializeIfNotInitialized$2 implements Application.ActivityLifecycleCallbacks {
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        try {
            FacebookSdk.getExecutor().execute(new AppEventQueue$$ExternalSyntheticLambda0(6));
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        try {
            if (Intrinsics.areEqual(InAppPurchaseActivityLifecycleTracker.hasBillingActivity, Boolean.TRUE) && Intrinsics.areEqual(activity.getLocalClassName(), YcVWhnLsj.djDgdQI)) {
                FacebookSdk.getExecutor().execute(new AppEventQueue$$ExternalSyntheticLambda0(5));
            }
        } catch (Exception unused) {
        }
    }
}
