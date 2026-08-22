package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzbmf extends zzayt implements zzbmh {
    public zzbmf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.initialization.IAdapterInitializationCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbmh
    public final void zze(String str) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzdb(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbmh
    public final void zzf() {
        zzdb(2, zza());
    }
}
