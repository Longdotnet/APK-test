package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
public final class zzbgx extends zzayt implements zzbgz {
    public zzbgx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzb(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzdb(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzc(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzdb(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzd() {
        zzdb(2, zza());
    }
}
