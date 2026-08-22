package com.google.android.gms.games.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Looper;
import com.google.android.gms.tasks.TaskExecutors;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzf {
    public static final /* synthetic */ int zza = 0;
    public static final AtomicReference zzb = new AtomicReference();
    public final Application zzc;
    public WeakReference zzg;
    public final Application.ActivityLifecycleCallbacks zzd = new zze(this);
    public final Object zze = new Object();
    public final Set zzf = Collections.newSetFromMap(new WeakHashMap());
    public boolean zzh = false;

    public zzf(Application application) {
        this.zzc = application;
    }

    public static zzf zza(Application application) {
        com.google.android.gms.common.internal.zzah.checkNotNull(application);
        AtomicReference atomicReference = zzb;
        zzf zzfVar = (zzf) atomicReference.get();
        if (zzfVar != null) {
            return zzfVar;
        }
        zzf zzfVar2 = new zzf(application);
        while (!atomicReference.compareAndSet(null, zzfVar2) && atomicReference.get() == null) {
        }
        return (zzf) atomicReference.get();
    }

    public final void zzb() {
        synchronized (this.zze) {
            try {
                if (!this.zzh) {
                    this.zzc.registerActivityLifecycleCallbacks(this.zzd);
                    this.zzh = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzc(final zzc zzcVar) {
        com.google.android.gms.common.internal.zzah.checkNotNull(zzcVar);
        synchronized (this.zze) {
            this.zzf.add(zzcVar);
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            TaskExecutors.MAIN_THREAD.execute(new Runnable() { // from class: com.google.android.gms.games.internal.zzd
                @Override // java.lang.Runnable
                public final void run() {
                    Activity activityZzd = this.zza.zzd();
                    if (activityZzd == null) {
                        return;
                    }
                    zzcVar.zza(activityZzd);
                }
            });
            return;
        }
        Activity activityZzd = zzd();
        if (activityZzd == null) {
            return;
        }
        zzcVar.zza(activityZzd);
    }

    public final Activity zzd() {
        Activity activity;
        synchronized (this.zze) {
            WeakReference weakReference = this.zzg;
            activity = weakReference == null ? null : (Activity) weakReference.get();
        }
        return activity;
    }

    public final /* synthetic */ void zzf(Activity activity) {
        com.google.android.gms.common.internal.zzah.checkNotNull(activity);
        synchronized (this.zze) {
            try {
                if (zzd() == activity) {
                    return;
                }
                this.zzg = new WeakReference(activity);
                Iterator it = this.zzf.iterator();
                while (it.hasNext()) {
                    ((zzc) it.next()).zza(activity);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
