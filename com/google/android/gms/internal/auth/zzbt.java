package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

/* JADX INFO: loaded from: classes.dex */
public final class zzbt {
    public final PendingResult<Object> getSpatulaHeader(GoogleApiClient googleApiClient) {
        com.google.android.gms.common.internal.zzah.checkNotNull(googleApiClient);
        return googleApiClient.execute(new zzbs(this, googleApiClient));
    }

    public final PendingResult<Object> performProxyRequest(GoogleApiClient googleApiClient, ProxyRequest proxyRequest) {
        com.google.android.gms.common.internal.zzah.checkNotNull(googleApiClient);
        com.google.android.gms.common.internal.zzah.checkNotNull(proxyRequest);
        return googleApiClient.execute(new zzbq(this, googleApiClient, proxyRequest));
    }
}
