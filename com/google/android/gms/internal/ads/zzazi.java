package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzazi implements zzazp {
    final /* synthetic */ Activity zza;
    final /* synthetic */ Bundle zzb;

    public zzazi(zzazq zzazqVar, Activity activity, Bundle bundle) {
        this.zza = activity;
        this.zzb = bundle;
        Objects.requireNonNull(zzazqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzazp
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityCreated(this.zza, this.zzb);
    }
}
