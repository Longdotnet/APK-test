package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzfps extends zzayt implements IInterface {
    public zzfps(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    public final zzfpq zze(zzfpo zzfpoVar) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, zzfpoVar);
        Parcel parcelZzda = zzda(1, parcelZza);
        zzfpq zzfpqVar = (zzfpq) zzayv.zza(parcelZzda, zzfpq.CREATOR);
        parcelZzda.recycle();
        return zzfpqVar;
    }

    public final zzfpz zzf(zzfpx zzfpxVar) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, zzfpxVar);
        Parcel parcelZzda = zzda(3, parcelZza);
        zzfpz zzfpzVar = (zzfpz) zzayv.zza(parcelZzda, zzfpz.CREATOR);
        parcelZzda.recycle();
        return zzfpzVar;
    }

    public final void zzg(zzfpl zzfplVar) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, zzfplVar);
        zzdb(2, parcelZza);
    }
}
