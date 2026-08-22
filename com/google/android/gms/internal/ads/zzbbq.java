package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzbbq extends zzayt implements IInterface {
    public zzbbq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.cache.ICacheService");
    }

    public final long zze(zzbbo zzbboVar) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, zzbboVar);
        Parcel parcelZzda = zzda(3, parcelZza);
        long j = parcelZzda.readLong();
        parcelZzda.recycle();
        return j;
    }

    public final zzbbl zzf(zzbbo zzbboVar) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, zzbboVar);
        Parcel parcelZzda = zzda(1, parcelZza);
        zzbbl zzbblVar = (zzbbl) zzayv.zza(parcelZzda, zzbbl.CREATOR);
        parcelZzda.recycle();
        return zzbblVar;
    }

    public final zzbbl zzg(zzbbo zzbboVar) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, zzbboVar);
        Parcel parcelZzda = zzda(2, parcelZza);
        zzbbl zzbblVar = (zzbbl) zzayv.zza(parcelZzda, zzbbl.CREATOR);
        parcelZzda.recycle();
        return zzbblVar;
    }
}
