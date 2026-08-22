package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzblg extends zzayu implements zzblh {
    public zzblg() {
        super("com.google.android.gms.ads.internal.h5.client.IH5AdsManager");
    }

    public static zzblh zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.h5.client.IH5AdsManager");
        return iInterfaceQueryLocalInterface instanceof zzblh ? (zzblh) iInterfaceQueryLocalInterface : new zzblf(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            String string = parcel.readString();
            zzayv.zzd(parcel);
            zzf(string);
        } else {
            if (i != 2) {
                return false;
            }
            zze();
        }
        parcel2.writeNoException();
        return true;
    }
}
