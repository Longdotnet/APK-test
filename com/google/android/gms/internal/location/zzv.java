package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.location.LocationListener;

/* JADX INFO: loaded from: classes.dex */
final class zzv extends zzx {
    final /* synthetic */ LocationListener zza;

    public zzv(zzz zzzVar, GoogleApiClient googleApiClient, LocationListener locationListener) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        ((zzaz) anyClient).zzF(ListenerHolders.createListenerKey(null, "LocationListener"), new zzy(this));
    }
}
