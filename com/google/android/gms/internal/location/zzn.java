package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.location.LocationCallback;

/* JADX INFO: loaded from: classes.dex */
final class zzn extends zzx {
    final /* synthetic */ LocationCallback zza;

    public zzn(zzz zzzVar, GoogleApiClient googleApiClient, LocationCallback locationCallback) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        ((zzaz) anyClient).zzH(ListenerHolders.createListenerKey(null, "LocationCallback"), new zzy(this));
    }
}
