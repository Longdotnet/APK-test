package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzah;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
final class zaat implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    public final /* synthetic */ zaaw zaa;

    public /* synthetic */ zaat(zaaw zaawVar) {
        this.zaa = zaawVar;
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zaaw zaawVar = this.zaa;
        zzah.checkNotNull(zaawVar.zar);
        com.google.android.gms.signin.zae zaeVar = zaawVar.zak;
        zzah.checkNotNull(zaeVar);
        zaeVar.zad(new zaar(zaawVar));
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zaaw zaawVar = this.zaa;
        Lock lock = zaawVar.zab;
        Lock lock2 = zaawVar.zab;
        lock.lock();
        try {
            if (zaawVar.zal && !connectionResult.hasResolution()) {
                zaawVar.zaA();
                zaawVar.zaF();
            } else {
                zaawVar.zaD(connectionResult);
            }
        } finally {
            lock2.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }
}
