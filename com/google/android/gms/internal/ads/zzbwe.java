package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbwe extends zzayu implements zzbwf {
    public zzbwe() {
        super("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            zzbwj zzbwjVar = (zzbwj) zzayv.zza(parcel, zzbwj.CREATOR);
            zzayv.zzd(parcel);
            zzg(zzbwjVar);
            parcel2.writeNoException();
        } else if (i != 2) {
            zzbwi zzbwgVar = null;
            zzbwd zzbwdVar = null;
            com.google.android.gms.ads.internal.client.zzcb zzbzVar = null;
            if (i == 3) {
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
                    zzbwgVar = iInterfaceQueryLocalInterface instanceof zzbwi ? (zzbwi) iInterfaceQueryLocalInterface : new zzbwg(strongBinder);
                }
                zzayv.zzd(parcel);
                zzo(zzbwgVar);
                parcel2.writeNoException();
            } else if (i != 34) {
                switch (i) {
                    case 5:
                        boolean zZzs = zzs();
                        parcel2.writeNoException();
                        int i3 = zzayv.zza;
                        parcel2.writeInt(zZzs ? 1 : 0);
                        break;
                    case 6:
                        zzh();
                        parcel2.writeNoException();
                        break;
                    case 7:
                        zzj();
                        parcel2.writeNoException();
                        break;
                    case 8:
                        zze();
                        parcel2.writeNoException();
                        break;
                    case 9:
                        IObjectWrapper iObjectWrapperAsInterface = ObjectWrapper.asInterface(parcel.readStrongBinder());
                        zzayv.zzd(parcel);
                        zzi(iObjectWrapperAsInterface);
                        parcel2.writeNoException();
                        break;
                    case 10:
                        IObjectWrapper iObjectWrapperAsInterface2 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                        zzayv.zzd(parcel);
                        zzk(iObjectWrapperAsInterface2);
                        parcel2.writeNoException();
                        break;
                    case 11:
                        IObjectWrapper iObjectWrapperAsInterface3 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                        zzayv.zzd(parcel);
                        zzf(iObjectWrapperAsInterface3);
                        parcel2.writeNoException();
                        break;
                    case 12:
                        String strZzd = zzd();
                        parcel2.writeNoException();
                        parcel2.writeString(strZzd);
                        break;
                    case 13:
                        String string = parcel.readString();
                        zzayv.zzd(parcel);
                        zzp(string);
                        parcel2.writeNoException();
                        break;
                    case 14:
                        IBinder strongBinder2 = parcel.readStrongBinder();
                        if (strongBinder2 != null) {
                            IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdMetadataListener");
                            zzbzVar = iInterfaceQueryLocalInterface2 instanceof com.google.android.gms.ads.internal.client.zzcb ? (com.google.android.gms.ads.internal.client.zzcb) iInterfaceQueryLocalInterface2 : new com.google.android.gms.ads.internal.client.zzbz(strongBinder2);
                        }
                        zzayv.zzd(parcel);
                        zzl(zzbzVar);
                        parcel2.writeNoException();
                        break;
                    case 15:
                        Bundle bundleZzb = zzb();
                        parcel2.writeNoException();
                        zzayv.zzf(parcel2, bundleZzb);
                        break;
                    case 16:
                        IBinder strongBinder3 = parcel.readStrongBinder();
                        if (strongBinder3 != null) {
                            IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener");
                            zzbwdVar = iInterfaceQueryLocalInterface3 instanceof zzbwd ? (zzbwd) iInterfaceQueryLocalInterface3 : new zzbwd(strongBinder3);
                        }
                        zzayv.zzd(parcel);
                        zzu(zzbwdVar);
                        parcel2.writeNoException();
                        break;
                    case 17:
                        parcel.readString();
                        zzayv.zzd(parcel);
                        parcel2.writeNoException();
                        break;
                    case 18:
                        IObjectWrapper iObjectWrapperAsInterface4 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                        zzayv.zzd(parcel);
                        zzr(iObjectWrapperAsInterface4);
                        parcel2.writeNoException();
                        break;
                    case 19:
                        String string2 = parcel.readString();
                        zzayv.zzd(parcel);
                        zzm(string2);
                        parcel2.writeNoException();
                        break;
                    case 20:
                        boolean zZzt = zzt();
                        parcel2.writeNoException();
                        int i4 = zzayv.zza;
                        parcel2.writeInt(zZzt ? 1 : 0);
                        break;
                    case 21:
                        com.google.android.gms.ads.internal.client.zzea zzeaVarZzc = zzc();
                        parcel2.writeNoException();
                        zzayv.zzg(parcel2, zzeaVarZzc);
                        break;
                    default:
                        return false;
                }
            } else {
                boolean zZzh = zzayv.zzh(parcel);
                zzayv.zzd(parcel);
                zzn(zZzh);
                parcel2.writeNoException();
            }
        } else {
            zzq();
            parcel2.writeNoException();
        }
        return true;
    }
}
