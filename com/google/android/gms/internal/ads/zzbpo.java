package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzbpo extends zzayt implements zzbpq {
    public zzbpo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final zzbpt zzb(String str) {
        zzbpt zzbprVar;
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzda = zzda(1, parcelZza);
        IBinder strongBinder = parcelZzda.readStrongBinder();
        if (strongBinder == null) {
            zzbprVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            zzbprVar = iInterfaceQueryLocalInterface instanceof zzbpt ? (zzbpt) iInterfaceQueryLocalInterface : new zzbpr(strongBinder);
        }
        parcelZzda.recycle();
        return zzbprVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final zzbrp zzc(String str) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzda = zzda(3, parcelZza);
        zzbrp zzbrpVarZzb = zzbro.zzb(parcelZzda.readStrongBinder());
        parcelZzda.recycle();
        return zzbrpVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final boolean zzd(String str) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzda = zzda(4, parcelZza);
        boolean zZzh = zzayv.zzh(parcelZzda);
        parcelZzda.recycle();
        return zZzh;
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final boolean zze(String str) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzda = zzda(2, parcelZza);
        boolean zZzh = zzayv.zzh(parcelZzda);
        parcelZzda.recycle();
        return zZzh;
    }
}
