package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzci;

/* JADX INFO: loaded from: classes.dex */
public final class zzp implements zzgs {
    public final zzci zza;
    public final /* synthetic */ AppMeasurementDynamiteService zzb;

    public zzp(AppMeasurementDynamiteService appMeasurementDynamiteService, zzci zzciVar) {
        this.zzb = appMeasurementDynamiteService;
        this.zza = zzciVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        try {
            this.zza.zze(str, str2, bundle, j);
        } catch (RemoteException e) {
            zzfr zzfrVar = this.zzb.zza;
            if (zzfrVar != null) {
                zzeh zzehVar = zzfrVar.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzg.zzb(e, "Event listener threw exception");
            }
        }
    }
}
