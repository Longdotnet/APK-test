package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzbxd extends zzayt implements IInterface {
    public zzbxd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdSkuListener");
    }

    public final void zze(zzbws zzbwsVar, String str, String str2) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, zzbwsVar);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzdb(2, parcelZza);
    }
}
