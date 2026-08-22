package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.google.android.gms.internal.ads.zzcas;

/* JADX INFO: loaded from: classes.dex */
public final class zzck {
    public final View zza;
    public Activity zzb;
    public boolean zzc;
    public boolean zzd;
    public boolean zze;
    public final ViewTreeObserver.OnGlobalLayoutListener zzf;

    public zzck(Activity activity, View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.zzb = activity;
        this.zza = view;
        this.zzf = onGlobalLayoutListener;
    }

    public final void zzg() {
        View decorView;
        if (this.zzc) {
            return;
        }
        Activity activity = this.zzb;
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.zzf;
        if (activity != null) {
            Window window = activity.getWindow();
            ViewTreeObserver viewTreeObserver = (window == null || (decorView = window.getDecorView()) == null) ? null : decorView.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
            }
        }
        zzcas zzcasVar = com.google.android.gms.ads.internal.zzv.zza.zzE;
        zzcas.zza(this.zza, onGlobalLayoutListener);
        this.zzc = true;
    }
}
