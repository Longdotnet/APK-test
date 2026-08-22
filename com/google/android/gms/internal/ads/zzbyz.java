package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbyz extends zzayu implements zzbza {
    public zzbyz() {
        super("com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    public static zzbza zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalGenerator");
        return iInterfaceQueryLocalInterface instanceof zzbza ? (zzbza) iInterfaceQueryLocalInterface : new zzbyy(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzbyx zzbyvVar = null;
        switch (i) {
            case 1:
                IObjectWrapper iObjectWrapperAsInterface = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzbze zzbzeVar = (zzbze) zzayv.zza(parcel, zzbze.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalCallback");
                    zzbyvVar = iInterfaceQueryLocalInterface instanceof zzbyx ? (zzbyx) iInterfaceQueryLocalInterface : new zzbyv(strongBinder);
                }
                zzayv.zzd(parcel);
                zzf(iObjectWrapperAsInterface, zzbzeVar, zzbyvVar);
                parcel2.writeNoException();
                return true;
            case 2:
                IObjectWrapper iObjectWrapperAsInterface2 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzk(iObjectWrapperAsInterface2);
                parcel2.writeNoException();
                return true;
            case 3:
                ObjectWrapper.asInterface(parcel.readStrongBinder());
                ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, null);
                return true;
            case 4:
                ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, null);
                return true;
            case 5:
                ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(Uri.CREATOR);
                IObjectWrapper iObjectWrapperAsInterface3 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzbuf zzbufVarZzb = zzbue.zzb(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzm(arrayListCreateTypedArrayList, iObjectWrapperAsInterface3, zzbufVarZzb);
                parcel2.writeNoException();
                return true;
            case 6:
                ArrayList arrayListCreateTypedArrayList2 = parcel.createTypedArrayList(Uri.CREATOR);
                IObjectWrapper iObjectWrapperAsInterface4 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzbuf zzbufVarZzb2 = zzbue.zzb(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzl(arrayListCreateTypedArrayList2, iObjectWrapperAsInterface4, zzbufVarZzb2);
                parcel2.writeNoException();
                return true;
            case 7:
                zzbui zzbuiVar = (zzbui) zzayv.zza(parcel, zzbui.CREATOR);
                zzayv.zzd(parcel);
                zzg(zzbuiVar);
                parcel2.writeNoException();
                return true;
            case 8:
                IObjectWrapper iObjectWrapperAsInterface5 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzj(iObjectWrapperAsInterface5);
                parcel2.writeNoException();
                return true;
            case 9:
                ArrayList arrayListCreateTypedArrayList3 = parcel.createTypedArrayList(Uri.CREATOR);
                IObjectWrapper iObjectWrapperAsInterface6 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzbuf zzbufVarZzb3 = zzbue.zzb(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzi(arrayListCreateTypedArrayList3, iObjectWrapperAsInterface6, zzbufVarZzb3);
                parcel2.writeNoException();
                return true;
            case 10:
                ArrayList arrayListCreateTypedArrayList4 = parcel.createTypedArrayList(Uri.CREATOR);
                IObjectWrapper iObjectWrapperAsInterface7 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzbuf zzbufVarZzb4 = zzbue.zzb(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzh(arrayListCreateTypedArrayList4, iObjectWrapperAsInterface7, zzbufVarZzb4);
                parcel2.writeNoException();
                return true;
            case 11:
                IObjectWrapper iObjectWrapperAsInterface8 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperAsInterface9 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                String string = parcel.readString();
                IObjectWrapper iObjectWrapperAsInterface10 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                IObjectWrapper iObjectWrapperZze = zze(iObjectWrapperAsInterface8, iObjectWrapperAsInterface9, string, iObjectWrapperAsInterface10);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, iObjectWrapperZze);
                return true;
            default:
                return false;
        }
    }
}
