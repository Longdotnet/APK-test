package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;

/* JADX INFO: loaded from: classes.dex */
final class zzar extends com.google.android.gms.location.zzaz {
    private final ListenerHolder<LocationCallback> zza;

    public zzar(ListenerHolder<LocationCallback> listenerHolder) {
        super("com.google.android.gms.location.ILocationCallback");
        this.zza = listenerHolder;
    }

    public final synchronized void zzc() {
        this.zza.clear();
    }

    @Override // com.google.android.gms.location.zzba
    public final void zzd(LocationResult locationResult) {
        this.zza.notifyListener(new zzap(this, locationResult));
    }

    @Override // com.google.android.gms.location.zzba
    public final void zze(LocationAvailability locationAvailability) {
        this.zza.notifyListener(new zzaq(this, locationAvailability));
    }
}
