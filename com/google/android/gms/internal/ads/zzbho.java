package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzbho extends zzayt implements zzbhq {
    public zzbho(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbhq
    public final void zze(zzbhg zzbhgVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, zzbhgVar);
        zzdb(1, parcelZza);
    }
}
