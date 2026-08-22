package com.google.android.gms.common.api.internal;

import android.app.Activity;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class ActivityLifecycleObserver {
    public static final ActivityLifecycleObserver of(Activity activity) {
        zaa zaaVar;
        synchronized (activity) {
            try {
                LifecycleFragment fragment = LifecycleCallback.getFragment(activity);
                zaaVar = (zaa) fragment.getCallbackOrNull("LifecycleObserverOnStop", zaa.class);
                if (zaaVar == null) {
                    zaaVar = new zaa(fragment);
                    zaaVar.zaa = new ArrayList();
                    zaaVar.mLifecycleFragment.addCallback("LifecycleObserverOnStop", zaaVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return new zab(zaaVar);
    }

    public abstract ActivityLifecycleObserver onStopCallOnce(Runnable runnable);
}
