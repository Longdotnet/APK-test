package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzbbi implements BaseGmsClient.BaseConnectionCallbacks {
    final /* synthetic */ zzbbk zza;

    public zzbbi(zzbbk zzbbkVar) {
        Objects.requireNonNull(zzbbkVar);
        this.zza = zzbbkVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzbbk zzbbkVar = this.zza;
        synchronized (zzbbkVar.zzc) {
            try {
                if (zzbbkVar.zzd != null) {
                    zzbbkVar.zzf = zzbbkVar.zzd.zzq();
                }
            } catch (DeadObjectException e) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Unable to obtain a cache service instance.", e);
                zzbbk.zzh(this.zza);
            }
            this.zza.zzc.notifyAll();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        zzbbk zzbbkVar = this.zza;
        synchronized (zzbbkVar.zzc) {
            zzbbkVar.zzf = null;
            zzbbkVar.zzc.notifyAll();
        }
    }
}
