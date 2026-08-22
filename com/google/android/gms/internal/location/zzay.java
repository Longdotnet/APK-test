package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.location.LocationSettingsResult;

/* JADX INFO: loaded from: classes.dex */
final class zzay extends zzan {
    private BaseImplementation.ResultHolder<LocationSettingsResult> zza;

    public zzay(BaseImplementation.ResultHolder<LocationSettingsResult> resultHolder) {
        com.google.android.gms.common.internal.zzah.checkArgument(resultHolder != null, "listener can't be null.");
        this.zza = resultHolder;
    }

    @Override // com.google.android.gms.internal.location.zzao
    public final void zzb(LocationSettingsResult locationSettingsResult) {
        this.zza.setResult(locationSettingsResult);
        this.zza = null;
    }
}
