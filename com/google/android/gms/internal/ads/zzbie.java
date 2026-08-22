package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzbie extends zzayt implements zzbig {
    public zzbie(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IUnconfirmedClickListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbig
    public final void zze() {
        zzdb(2, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbig
    public final void zzf(String str) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzdb(1, parcelZza);
    }
}
