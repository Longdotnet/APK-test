package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzcd extends zzbm implements zzcf {
    public zzcd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    @Override // com.google.android.gms.internal.measurement.zzcf
    public final void zze(Bundle bundle) {
        Parcel parcelZza = zza();
        zzbo.zze(parcelZza, bundle);
        zzc(1, parcelZza);
    }
}
