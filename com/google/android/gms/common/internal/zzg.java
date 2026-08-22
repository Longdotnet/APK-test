package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes.dex */
public final class zzg extends zza {
    public final /* synthetic */ BaseGmsClient zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzg(BaseGmsClient baseGmsClient, int i) {
        super(baseGmsClient, i, null);
        this.zze = baseGmsClient;
    }

    @Override // com.google.android.gms.common.internal.zza
    public final void zzb(ConnectionResult connectionResult) {
        BaseGmsClient baseGmsClient = this.zze;
        if (baseGmsClient.enableLocalFallback() && BaseGmsClient.zzo(baseGmsClient)) {
            BaseGmsClient.zzk(baseGmsClient, 16);
        } else {
            baseGmsClient.zzc.onReportServiceBinding(connectionResult);
            baseGmsClient.onConnectionFailed(connectionResult);
        }
    }

    @Override // com.google.android.gms.common.internal.zza
    public final boolean zzd() {
        this.zze.zzc.onReportServiceBinding(ConnectionResult.RESULT_SUCCESS);
        return true;
    }
}
