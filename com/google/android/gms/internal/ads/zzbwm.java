package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbwm extends zzayu implements zzbwn {
    public zzbwm() {
        super("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
    }

    public static zzbwn zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
        return iInterfaceQueryLocalInterface instanceof zzbwn ? (zzbwn) iInterfaceQueryLocalInterface : new zzbwl(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                IObjectWrapper iObjectWrapperAsInterface = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzl(iObjectWrapperAsInterface);
                break;
            case 2:
                IObjectWrapper iObjectWrapperAsInterface2 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                int i3 = parcel.readInt();
                zzayv.zzd(parcel);
                zzk(iObjectWrapperAsInterface2, i3);
                break;
            case 3:
                IObjectWrapper iObjectWrapperAsInterface3 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzi(iObjectWrapperAsInterface3);
                break;
            case 4:
                IObjectWrapper iObjectWrapperAsInterface4 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzj(iObjectWrapperAsInterface4);
                break;
            case 5:
                IObjectWrapper iObjectWrapperAsInterface5 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzp(iObjectWrapperAsInterface5);
                break;
            case 6:
                IObjectWrapper iObjectWrapperAsInterface6 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzf(iObjectWrapperAsInterface6);
                break;
            case 7:
                IObjectWrapper iObjectWrapperAsInterface7 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzbwo zzbwoVar = (zzbwo) zzayv.zza(parcel, zzbwo.CREATOR);
                zzayv.zzd(parcel);
                zzm(iObjectWrapperAsInterface7, zzbwoVar);
                break;
            case 8:
                IObjectWrapper iObjectWrapperAsInterface8 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zze(iObjectWrapperAsInterface8);
                break;
            case 9:
                IObjectWrapper iObjectWrapperAsInterface9 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                int i4 = parcel.readInt();
                zzayv.zzd(parcel);
                zzg(iObjectWrapperAsInterface9, i4);
                break;
            case 10:
                IObjectWrapper iObjectWrapperAsInterface10 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzh(iObjectWrapperAsInterface10);
                break;
            case 11:
                IObjectWrapper iObjectWrapperAsInterface11 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzo(iObjectWrapperAsInterface11);
                break;
            case 12:
                zzayv.zzd(parcel);
                break;
            case 13:
                IObjectWrapper iObjectWrapperAsInterface12 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzn(iObjectWrapperAsInterface12);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
