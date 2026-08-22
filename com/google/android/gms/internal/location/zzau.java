package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationListener;

/* JADX INFO: loaded from: classes.dex */
final class zzau extends com.google.android.gms.location.zzbc {
    private final ListenerHolder<LocationListener> zza;

    public zzau(ListenerHolder<LocationListener> listenerHolder) {
        super("com.google.android.gms.location.ILocationListener");
        this.zza = listenerHolder;
    }

    public final synchronized void zzc() {
        this.zza.clear();
    }

    @Override // com.google.android.gms.location.zzbd
    public final synchronized void zzd(Location location) {
        this.zza.notifyListener(new zzat(this, location));
    }
}
