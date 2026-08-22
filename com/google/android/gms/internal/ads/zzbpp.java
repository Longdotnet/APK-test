package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbpp extends zzayu implements zzbpq {
    public zzbpp() {
        super("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    public static zzbpq zzf(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        return iInterfaceQueryLocalInterface instanceof zzbpq ? (zzbpq) iInterfaceQueryLocalInterface : new zzbpo(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            String string = parcel.readString();
            zzayv.zzd(parcel);
            zzbpt zzbptVarZzb = zzb(string);
            parcel2.writeNoException();
            zzayv.zzg(parcel2, zzbptVarZzb);
        } else if (i == 2) {
            String string2 = parcel.readString();
            zzayv.zzd(parcel);
            boolean zZze = zze(string2);
            parcel2.writeNoException();
            parcel2.writeInt(zZze ? 1 : 0);
        } else if (i == 3) {
            String string3 = parcel.readString();
            zzayv.zzd(parcel);
            zzbrp zzbrpVarZzc = zzc(string3);
            parcel2.writeNoException();
            zzayv.zzg(parcel2, zzbrpVarZzc);
        } else {
            if (i != 4) {
                return false;
            }
            String string4 = parcel.readString();
            zzayv.zzd(parcel);
            boolean zZzd = zzd(string4);
            parcel2.writeNoException();
            parcel2.writeInt(zZzd ? 1 : 0);
        }
        return true;
    }
}
