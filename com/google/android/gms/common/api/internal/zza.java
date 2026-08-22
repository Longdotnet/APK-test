package com.google.android.gms.common.api.internal;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
final class zza implements Runnable {
    public final /* synthetic */ LifecycleCallback zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzb zzc;

    public zza(zzb zzbVar, LifecycleCallback lifecycleCallback, String str) {
        this.zzc = zzbVar;
        this.zza = lifecycleCallback;
        this.zzb = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzb zzbVar = this.zzc;
        int i = zzbVar.zzc;
        LifecycleCallback lifecycleCallback = this.zza;
        if (i > 0) {
            Bundle bundle = zzbVar.zzd;
            lifecycleCallback.onCreate(bundle != null ? bundle.getBundle(this.zzb) : null);
        }
        if (zzbVar.zzc >= 2) {
            lifecycleCallback.onStart();
        }
        if (zzbVar.zzc >= 3) {
            lifecycleCallback.onResume();
        }
        if (zzbVar.zzc >= 4) {
            lifecycleCallback.onStop();
        }
        if (zzbVar.zzc >= 5) {
            lifecycleCallback.onDestroy();
        }
    }
}
