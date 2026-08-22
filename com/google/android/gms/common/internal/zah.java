package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.safetynet.SafetyNetApi$AttestationResponse;

/* JADX INFO: loaded from: classes.dex */
public final class zah implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener, PendingResultUtil$ResultConverter {
    public static zah zza;
    public static final RootTelemetryConfiguration zzb = new RootTelemetryConfiguration(0, 0, 0, false, false);
    public Object zaa;

    public /* synthetic */ zah(Object obj) {
        this.zaa = obj;
    }

    public static synchronized zah getInstance() {
        try {
            if (zza == null) {
                zza = new zah();
            }
        } catch (Throwable th) {
            throw th;
        }
        return zza;
    }

    @Override // com.google.android.gms.common.internal.PendingResultUtil$ResultConverter
    public /* bridge */ /* synthetic */ Object convert(Result result) {
        SafetyNetApi$AttestationResponse safetyNetApi$AttestationResponse = (SafetyNetApi$AttestationResponse) this.zaa;
        safetyNetApi$AttestationResponse.setResult(result);
        return safetyNetApi$AttestationResponse;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public void onConnected(Bundle bundle) {
        ((ConnectionCallbacks) this.zaa).onConnected(bundle);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public void onConnectionFailed(ConnectionResult connectionResult) {
        ((OnConnectionFailedListener) this.zaa).onConnectionFailed(connectionResult);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public void onConnectionSuspended(int i) {
        ((ConnectionCallbacks) this.zaa).onConnectionSuspended(i);
    }
}
