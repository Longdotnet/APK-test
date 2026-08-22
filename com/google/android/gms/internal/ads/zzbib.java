package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzbib extends zzayt implements zzbid {
    public zzbib(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnUnifiedNativeAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbid
    public final void zze(zzbij zzbijVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, zzbijVar);
        zzdb(1, parcelZza);
    }
}
