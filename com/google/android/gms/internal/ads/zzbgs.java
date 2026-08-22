package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbgs extends zzayu implements zzbgt {
    public zzbgs() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    public static zzbgt zzdC(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
        return iInterfaceQueryLocalInterface instanceof zzbgt ? (zzbgt) iInterfaceQueryLocalInterface : new zzbgr(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzbgm zzbgkVar;
        switch (i) {
            case 1:
                String string = parcel.readString();
                IObjectWrapper iObjectWrapperAsInterface = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzdx(string, iObjectWrapperAsInterface);
                parcel2.writeNoException();
                return true;
            case 2:
                String string2 = parcel.readString();
                zzayv.zzd(parcel);
                IObjectWrapper iObjectWrapperZzb = zzb(string2);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, iObjectWrapperZzb);
                return true;
            case 3:
                IObjectWrapper iObjectWrapperAsInterface2 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzdB(iObjectWrapperAsInterface2);
                parcel2.writeNoException();
                return true;
            case 4:
                zzc();
                parcel2.writeNoException();
                return true;
            case 5:
                ObjectWrapper.asInterface(parcel.readStrongBinder());
                parcel.readInt();
                zzayv.zzd(parcel);
                parcel2.writeNoException();
                return true;
            case 6:
                IObjectWrapper iObjectWrapperAsInterface3 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzdy(iObjectWrapperAsInterface3);
                parcel2.writeNoException();
                return true;
            case 7:
                IObjectWrapper iObjectWrapperAsInterface4 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzd(iObjectWrapperAsInterface4);
                parcel2.writeNoException();
                return true;
            case 8:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder == null) {
                    zzbgkVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IMediaContent");
                    zzbgkVar = iInterfaceQueryLocalInterface instanceof zzbgm ? (zzbgm) iInterfaceQueryLocalInterface : new zzbgk(strongBinder);
                }
                zzayv.zzd(parcel);
                zzdz(zzbgkVar);
                parcel2.writeNoException();
                return true;
            case 9:
                IObjectWrapper iObjectWrapperAsInterface5 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzdA(iObjectWrapperAsInterface5);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
