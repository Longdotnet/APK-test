package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzazj implements zzazp {
    final /* synthetic */ Activity zza;

    public zzazj(zzazq zzazqVar, Activity activity) {
        this.zza = activity;
        Objects.requireNonNull(zzazqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzazp
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStarted(this.zza);
    }
}
