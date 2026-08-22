package com.google.android.gms.common.api.internal;

import android.app.Activity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes.dex */
public final class zacc extends zap {
    public TaskCompletionSource zad;

    public static zacc zaa(Activity activity) {
        LifecycleFragment fragment = LifecycleCallback.getFragment(activity);
        zacc zaccVar = (zacc) fragment.getCallbackOrNull("GmsAvailabilityHelper", zacc.class);
        if (zaccVar != null) {
            if (zaccVar.zad.zza.isComplete()) {
                zaccVar.zad = new TaskCompletionSource();
            }
            return zaccVar;
        }
        Object obj = GoogleApiAvailability.zaa;
        zacc zaccVar2 = new zacc(fragment);
        zaccVar2.zad = new TaskCompletionSource();
        zaccVar2.mLifecycleFragment.addCallback("GmsAvailabilityHelper", zaccVar2);
        return zaccVar2;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onDestroy() {
        super.onDestroy();
        this.zad.trySetException(new CancellationException("Host activity was destroyed before Google Play services could be made available."));
    }

    @Override // com.google.android.gms.common.api.internal.zap
    public final void zab(ConnectionResult connectionResult, int i) {
        String str = connectionResult.zzd;
        if (str == null) {
            str = "Error connecting to Google Play services";
        }
        this.zad.setException(new ApiException(new Status(connectionResult, str, connectionResult.zzb)));
    }

    @Override // com.google.android.gms.common.api.internal.zap
    public final void zac() {
        Activity lifecycleActivity = this.mLifecycleFragment.getLifecycleActivity();
        if (lifecycleActivity == null) {
            this.zad.trySetException(new ApiException(new Status(8)));
            return;
        }
        int iIsGooglePlayServicesAvailable = this.zac.isGooglePlayServicesAvailable(lifecycleActivity, GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        if (iIsGooglePlayServicesAvailable == 0) {
            this.zad.trySetResult(null);
        } else {
            if (this.zad.zza.isComplete()) {
                return;
            }
            zah(new ConnectionResult(iIsGooglePlayServicesAvailable, null), 0);
        }
    }

    public final Task zad() {
        return this.zad.zza;
    }
}
