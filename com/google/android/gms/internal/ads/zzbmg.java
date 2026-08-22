package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbmg extends zzayu implements zzbmh {
    public zzbmg() {
        super("com.google.android.gms.ads.internal.initialization.IAdapterInitializationCallback");
    }

    public static zzbmh zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.initialization.IAdapterInitializationCallback");
        return iInterfaceQueryLocalInterface instanceof zzbmh ? (zzbmh) iInterfaceQueryLocalInterface : new zzbmf(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 2) {
            zzf();
        } else {
            if (i != 3) {
                return false;
            }
            String string = parcel.readString();
            zzayv.zzd(parcel);
            zze(string);
        }
        parcel2.writeNoException();
        return true;
    }
}
