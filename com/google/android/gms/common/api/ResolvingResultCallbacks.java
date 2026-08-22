package com.google.android.gms.common.api;

import android.app.Activity;
import android.content.IntentSender;
import android.util.Log;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.zzah;

/* JADX INFO: loaded from: classes.dex */
public abstract class ResolvingResultCallbacks<R extends Result> extends ResultCallbacks<R> {
    public final Activity zza;
    public final int zzb;

    public ResolvingResultCallbacks(Activity activity, int i) {
        zzah.checkNotNull(activity, "Activity must not be null");
        this.zza = activity;
        this.zzb = i;
    }

    @Override // com.google.android.gms.common.api.ResultCallbacks
    public final void onFailure(Status status) {
        if (!status.hasResolution()) {
            onUnresolvableFailure(status);
            return;
        }
        try {
            status.startResolutionForResult(this.zza, this.zzb);
        } catch (IntentSender.SendIntentException e) {
            Log.e("ResolvingResultCallback", "Failed to start resolution", e);
            onUnresolvableFailure(new Status(8));
        }
    }

    @Override // com.google.android.gms.common.api.ResultCallbacks
    public abstract void onSuccess(R r);

    public abstract void onUnresolvableFailure(Status status);
}
