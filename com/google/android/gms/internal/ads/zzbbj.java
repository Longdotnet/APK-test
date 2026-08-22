package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzbbj implements BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzbbk zza;

    public zzbbj(zzbbk zzbbkVar) {
        Objects.requireNonNull(zzbbkVar);
        this.zza = zzbbkVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zzbbk zzbbkVar = this.zza;
        synchronized (zzbbkVar.zzc) {
            try {
                zzbbkVar.zzf = null;
                if (zzbbkVar.zzd != null) {
                    zzbbkVar.zzd = null;
                }
                zzbbkVar.zzc.notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
