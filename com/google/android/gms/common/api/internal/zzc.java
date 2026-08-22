package com.google.android.gms.common.api.internal;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
final class zzc implements Runnable {
    public final /* synthetic */ LifecycleCallback zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzd zzc;

    public zzc(zzd zzdVar, LifecycleCallback lifecycleCallback, String str) {
        this.zzc = zzdVar;
        this.zza = lifecycleCallback;
        this.zzb = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzd zzdVar = this.zzc;
        int i = zzdVar.zzc;
        LifecycleCallback lifecycleCallback = this.zza;
        if (i > 0) {
            Bundle bundle = zzdVar.zzd;
            lifecycleCallback.onCreate(bundle != null ? bundle.getBundle(this.zzb) : null);
        }
        if (zzdVar.zzc >= 2) {
            lifecycleCallback.onStart();
        }
        if (zzdVar.zzc >= 3) {
            lifecycleCallback.onResume();
        }
        if (zzdVar.zzc >= 4) {
            lifecycleCallback.onStop();
        }
        if (zzdVar.zzc >= 5) {
            lifecycleCallback.onDestroy();
        }
    }
}
