package com.google.android.gms.common.api.internal;

import android.app.Activity;
import androidx.collection.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.zzah;

/* JADX INFO: loaded from: classes.dex */
public final class zaae extends zap {
    public final ArraySet zad;
    public final GoogleApiManager zae;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zaae(LifecycleFragment lifecycleFragment, GoogleApiManager googleApiManager) {
        super(lifecycleFragment);
        Object obj = GoogleApiAvailability.zaa;
        this.zad = new ArraySet(0);
        this.zae = googleApiManager;
        this.mLifecycleFragment.addCallback("ConnectionlessLifecycleHelper", this);
    }

    public static void zad(Activity activity, GoogleApiManager googleApiManager, ApiKey apiKey) {
        LifecycleFragment fragment = LifecycleCallback.getFragment(activity);
        zaae zaaeVar = (zaae) fragment.getCallbackOrNull("ConnectionlessLifecycleHelper", zaae.class);
        if (zaaeVar == null) {
            Object obj = GoogleApiAvailability.zaa;
            zaaeVar = new zaae(fragment, googleApiManager);
        }
        zzah.checkNotNull(apiKey, "ApiKey cannot be null");
        zaaeVar.zad.add(apiKey);
        googleApiManager.zaA(zaaeVar);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onResume() {
        super.onResume();
        if (this.zad.isEmpty()) {
            return;
        }
        this.zae.zaA(this);
    }

    @Override // com.google.android.gms.common.api.internal.zap, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onStart() {
        super.onStart();
        if (this.zad.isEmpty()) {
            return;
        }
        this.zae.zaA(this);
    }

    @Override // com.google.android.gms.common.api.internal.zap, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onStop() {
        super.onStop();
        GoogleApiManager googleApiManager = this.zae;
        googleApiManager.getClass();
        synchronized (GoogleApiManager.zac) {
            try {
                if (googleApiManager.zao == this) {
                    googleApiManager.zao = null;
                    googleApiManager.zap.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zap
    public final void zab(ConnectionResult connectionResult, int i) {
        this.zae.zax(connectionResult, i);
    }

    @Override // com.google.android.gms.common.api.internal.zap
    public final void zac() {
        this.zae.zay();
    }
}
