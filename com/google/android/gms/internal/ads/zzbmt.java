package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzbmt extends zzayt implements zzbmv {
    public zzbmt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbmv
    public final void zze(int i) {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        zzdb(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbmv
    public final void zzf() {
        zzdb(1, zza());
    }
}
