package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import kotlinx.coroutines.internal.Jbo.ygoi;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaxe implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, Application.ActivityLifecycleCallbacks {
    private static final Handler zza = new Handler(Looper.getMainLooper());
    private final Context zzb;
    private Application zzc;
    private final PowerManager zzd;
    private final KeyguardManager zze;
    private BroadcastReceiver zzf;
    private final zzawq zzg;
    private WeakReference zzh;
    private WeakReference zzi;
    private zzawm zzj;
    private byte zzk = -1;
    private int zzl = -1;
    private long zzm = -3;

    public zzaxe(Context context, zzawq zzawqVar) {
        Context applicationContext = context.getApplicationContext();
        this.zzb = applicationContext;
        this.zzg = zzawqVar;
        this.zzd = (PowerManager) applicationContext.getSystemService("power");
        this.zze = (KeyguardManager) applicationContext.getSystemService("keyguard");
        if (applicationContext instanceof Application) {
            this.zzc = (Application) applicationContext;
            this.zzj = new zzawm((Application) applicationContext, this);
        }
        zzd(null);
    }

    private final void zze(Activity activity, int i) {
        Window window;
        if (this.zzi == null || (window = activity.getWindow()) == null) {
            return;
        }
        View viewPeekDecorView = window.peekDecorView();
        View viewZzb = zzb();
        if (viewZzb == null || viewPeekDecorView == null || viewZzb.getRootView() != viewPeekDecorView.getRootView()) {
            return;
        }
        this.zzl = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:49:0x0082  */
    public final void zzf() {
        Activity activity;
        if (this.zzi == null) {
            return;
        }
        View viewZzb = zzb();
        if (viewZzb == null) {
            this.zzm = -3L;
            this.zzk = (byte) -1;
            return;
        }
        int i = 0;
        int i2 = viewZzb.getVisibility() != 0 ? 1 : 0;
        if (!viewZzb.isShown()) {
            i2 |= 2;
        }
        PowerManager powerManager = this.zzd;
        if (powerManager != null && !powerManager.isScreenOn()) {
            i2 |= 4;
        }
        if (!this.zzg.zza()) {
            KeyguardManager keyguardManager = this.zze;
            if (keyguardManager == null || !keyguardManager.inKeyguardRestrictedInputMode()) {
                i2 |= 8;
            } else {
                int i3 = zzaxa.zza;
                View rootView = viewZzb.getRootView();
                if (rootView == null) {
                    rootView = viewZzb;
                }
                Context context = rootView.getContext();
                while (true) {
                    if (!(context instanceof ContextWrapper) || i >= 10) {
                        activity = null;
                        break;
                    } else if (context instanceof Activity) {
                        activity = (Activity) context;
                        break;
                    } else {
                        context = ((ContextWrapper) context).getBaseContext();
                        i++;
                    }
                }
                if (activity != null) {
                    Window window = activity.getWindow();
                    WindowManager.LayoutParams attributes = window != null ? window.getAttributes() : null;
                    if (attributes == null || (attributes.flags & 524288) == 0) {
                        i2 |= 8;
                    }
                } else {
                    i2 |= 8;
                }
            }
        }
        if (!viewZzb.getGlobalVisibleRect(new Rect())) {
            i2 |= 16;
        }
        if (!viewZzb.getLocalVisibleRect(new Rect())) {
            i2 |= 32;
        }
        int windowVisibility = viewZzb.getWindowVisibility();
        int i4 = this.zzl;
        if (i4 != -1) {
            windowVisibility = i4;
        }
        if (windowVisibility != 0) {
            i2 |= 64;
        }
        if (this.zzk != i2) {
            this.zzk = (byte) i2;
            this.zzm = i2 == 0 ? SystemClock.elapsedRealtime() : (-3) - ((long) i2);
        }
    }

    private final void zzg() {
        zza.post(new zzaxc(this));
    }

    private final void zzi(View view) {
        try {
            WeakReference weakReference = this.zzh;
            if (weakReference != null) {
                ViewTreeObserver viewTreeObserver = (ViewTreeObserver) weakReference.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.zzh = null;
            }
        } catch (Exception unused) {
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception unused2) {
        }
        BroadcastReceiver broadcastReceiver = this.zzf;
        if (broadcastReceiver != null) {
            try {
                this.zzb.unregisterReceiver(broadcastReceiver);
            } catch (Exception unused3) {
            }
            this.zzf = null;
        }
        Application application = this.zzc;
        if (application != null) {
            try {
                application.unregisterActivityLifecycleCallbacks(this.zzj);
            } catch (Exception unused4) {
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zze(activity, 0);
        zzf();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        zzf();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        zze(activity, 4);
        zzf();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zze(activity, 0);
        zzf();
        zzg();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzf();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        zze(activity, 0);
        zzf();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        zzf();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        zzf();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        zzf();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.zzl = -1;
        zzh(view);
        zzf();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.zzl = -1;
        zzf();
        zzg();
        zzi(view);
    }

    public final long zza() {
        if (this.zzm <= -2 && zzb() == null) {
            this.zzm = -3L;
        }
        return this.zzm;
    }

    public final View zzb() {
        WeakReference weakReference = this.zzi;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    public final void zzd(View view) {
        long j;
        View viewZzb = zzb();
        if (viewZzb != null) {
            viewZzb.removeOnAttachStateChangeListener(this);
            zzi(viewZzb);
        }
        this.zzi = new WeakReference(view);
        if (view != null) {
            if (view.getWindowToken() != null || view.getWindowVisibility() != 8) {
                zzh(view);
            }
            view.addOnAttachStateChangeListener(this);
            j = -2;
        } else {
            j = -3;
        }
        this.zzm = j;
    }

    private final void zzh(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.zzh = new WeakReference(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.zzf == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction(ygoi.GlzeIRtiKzuWu);
            zzaxd zzaxdVar = new zzaxd(this);
            this.zzf = zzaxdVar;
            this.zzb.registerReceiver(zzaxdVar, intentFilter);
        }
        Application application = this.zzc;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.zzj);
            } catch (Exception unused) {
            }
        }
    }
}
