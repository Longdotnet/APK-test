package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzbbx implements BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzcak zza;
    final /* synthetic */ zzbby zzb;

    public zzbbx(zzbby zzbbyVar, zzcak zzcakVar) {
        this.zza = zzcakVar;
        Objects.requireNonNull(zzbbyVar);
        this.zzb = zzbbyVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        synchronized (this.zzb.zzd) {
            this.zza.zzd(new RuntimeException("Connection failed."));
        }
    }
}
