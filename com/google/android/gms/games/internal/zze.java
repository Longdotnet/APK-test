package com.google.android.gms.games.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zze implements Application.ActivityLifecycleCallbacks {
    public final /* synthetic */ zzf zza;

    public /* synthetic */ zze(zzf zzfVar) {
        Objects.requireNonNull(zzfVar);
        this.zza = zzfVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        zzf zzfVar = this.zza;
        synchronized (zzfVar.zze) {
            try {
                WeakReference weakReference = zzfVar.zzg;
                if (weakReference == null) {
                    return;
                }
                if (weakReference.get() == activity) {
                    zzfVar.zzg = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        this.zza.zzf(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        this.zza.zzf(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
