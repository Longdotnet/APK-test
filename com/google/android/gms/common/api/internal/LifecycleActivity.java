package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.internal.zzah;

/* JADX INFO: loaded from: classes.dex */
public class LifecycleActivity {
    public final Activity zza;

    public LifecycleActivity(Activity activity) {
        zzah.checkNotNull(activity, "Activity must not be null");
        this.zza = activity;
    }

    public final Activity zza() {
        return this.zza;
    }

    public final FragmentActivity zzb() {
        return (FragmentActivity) this.zza;
    }

    public final boolean zzc() {
        return this.zza instanceof Activity;
    }

    public final boolean zzd() {
        return this.zza instanceof FragmentActivity;
    }

    public LifecycleActivity(ContextWrapper contextWrapper) {
        throw new UnsupportedOperationException();
    }
}
