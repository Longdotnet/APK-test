package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzah;

/* JADX INFO: loaded from: classes.dex */
public final class zat implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    public final Api zaa;
    public final boolean zab;
    public zau zac;

    public zat(Api api, boolean z) {
        this.zaa = api;
        this.zab = z;
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzah.checkNotNull(this.zac, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
        this.zac.onConnected(bundle);
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        Api api = this.zaa;
        zzah.checkNotNull(this.zac, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
        this.zac.zaa(connectionResult, api, this.zab);
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        zzah.checkNotNull(this.zac, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
        this.zac.onConnectionSuspended(i);
    }

    public final void zaa(zau zauVar) {
        this.zac = zauVar;
    }
}
