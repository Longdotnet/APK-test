package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzayv;
import com.google.android.gms.internal.ads.zzbpq;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzcx extends zzayu implements zzcy {
    public static zzcy asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.ILiteSdkInfo");
        return iInterfaceQueryLocalInterface instanceof zzcy ? (zzcy) iInterfaceQueryLocalInterface : new zzcw(iBinder, "com.google.android.gms.ads.internal.client.ILiteSdkInfo");
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            zzfd liteSdkVersion = getLiteSdkVersion();
            parcel2.writeNoException();
            zzayv.zzf(parcel2, liteSdkVersion);
        } else {
            if (i != 2) {
                return false;
            }
            zzbpq adapterCreator = getAdapterCreator();
            parcel2.writeNoException();
            zzayv.zzg(parcel2, adapterCreator);
        }
        return true;
    }
}
