package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzblf extends zzayt implements zzblh {
    public zzblf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.h5.client.IH5AdsManager");
    }

    @Override // com.google.android.gms.internal.ads.zzblh
    public final void zze() {
        zzdb(2, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzblh
    public final void zzf(String str) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzdb(1, parcelZza);
    }
}
