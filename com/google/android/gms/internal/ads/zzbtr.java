package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
public final class zzbtr extends zzayt implements zzbtt {
    public zzbtr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzbtt
    public final IBinder zze(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        Parcel parcelZzda = zzda(1, parcelZza);
        IBinder strongBinder = parcelZzda.readStrongBinder();
        parcelZzda.recycle();
        return strongBinder;
    }
}
