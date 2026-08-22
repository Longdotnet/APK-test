package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzblw extends zzayt implements IInterface {
    public zzblw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
    }

    public final void zze(zzblq zzblqVar, zzblv zzblvVar) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, zzblqVar);
        zzayv.zzg(parcelZza, zzblvVar);
        zzdc(2, parcelZza);
    }
}
