package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzbfy extends zzayt implements IInterface {
    public zzbfy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.flags.IFlagRetrieverSupplierProxy");
    }

    public final void zze(zzbuu zzbuuVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, zzbuuVar);
        zzdb(1, parcelZza);
    }
}
