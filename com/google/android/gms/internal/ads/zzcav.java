package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
abstract class zzcav {
    private final WeakReference zza;

    public zzcav(View view) {
        this.zza = new WeakReference(view);
    }

    public abstract void zza(ViewTreeObserver viewTreeObserver);

    public abstract void zzb(ViewTreeObserver viewTreeObserver);

    public final ViewTreeObserver zzc() {
        ViewTreeObserver viewTreeObserver;
        View view = (View) this.zza.get();
        if (view == null || (viewTreeObserver = view.getViewTreeObserver()) == null || !viewTreeObserver.isAlive()) {
            return null;
        }
        return viewTreeObserver;
    }

    public final void zzd() {
        ViewTreeObserver viewTreeObserverZzc = zzc();
        if (viewTreeObserverZzc != null) {
            zza(viewTreeObserverZzc);
        }
    }

    public final void zze() {
        ViewTreeObserver viewTreeObserverZzc = zzc();
        if (viewTreeObserverZzc != null) {
            zzb(viewTreeObserverZzc);
        }
    }
}
