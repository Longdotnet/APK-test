package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.service.Common;
import com.google.android.gms.common.internal.zzah;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
final class zaaz implements GoogleApiClient.ConnectionCallbacks {
    public final /* synthetic */ AtomicReference zaa;
    public final /* synthetic */ StatusPendingResult zab;
    public final /* synthetic */ zabe zac;

    public zaaz(zabe zabeVar, AtomicReference atomicReference, StatusPendingResult statusPendingResult) {
        this.zac = zabeVar;
        this.zaa = atomicReference;
        this.zab = statusPendingResult;
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        GoogleApiClient googleApiClient = (GoogleApiClient) this.zaa.get();
        zzah.checkNotNull(googleApiClient);
        int i = zabe.$r8$clinit;
        StatusPendingResult statusPendingResult = this.zab;
        zabe zabeVar = this.zac;
        zabeVar.getClass();
        Common.zaa.getClass();
        googleApiClient.execute(new com.google.android.gms.common.internal.service.zac(googleApiClient)).setResultCallback(new zabb(zabeVar, statusPendingResult, true, googleApiClient));
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }
}
