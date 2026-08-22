package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzbwd extends zzayt implements IInterface {
    public zzbwd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener");
    }

    public final void zze(zzbwc zzbwcVar, String str, String str2) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, zzbwcVar);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzdb(2, parcelZza);
    }
}
