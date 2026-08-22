package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbti extends zzayu implements zzbtj {
    public zzbti() {
        super("com.google.android.gms.ads.internal.offline.IOfflineUtils");
    }

    public static zzbtj zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.offline.IOfflineUtils");
        return iInterfaceQueryLocalInterface instanceof zzbtj ? (zzbtj) iInterfaceQueryLocalInterface : new zzbth(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                Intent intent = (Intent) zzayv.zza(parcel, Intent.CREATOR);
                zzayv.zzd(parcel);
                zze(intent);
                break;
            case 2:
                IObjectWrapper iObjectWrapperAsInterface = ObjectWrapper.asInterface(parcel.readStrongBinder());
                String string = parcel.readString();
                String string2 = parcel.readString();
                zzayv.zzd(parcel);
                zzi(iObjectWrapperAsInterface, string, string2);
                break;
            case 3:
                zzh();
                break;
            case 4:
                IObjectWrapper iObjectWrapperAsInterface2 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzg(iObjectWrapperAsInterface2);
                break;
            case 5:
                String[] strArrCreateStringArray = parcel.createStringArray();
                int[] iArrCreateIntArray = parcel.createIntArray();
                IObjectWrapper iObjectWrapperAsInterface3 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzf(strArrCreateStringArray, iArrCreateIntArray, iObjectWrapperAsInterface3);
                break;
            case 6:
                IObjectWrapper iObjectWrapperAsInterface4 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.offline.buffering.zza zzaVar = (com.google.android.gms.ads.internal.offline.buffering.zza) zzayv.zza(parcel, com.google.android.gms.ads.internal.offline.buffering.zza.CREATOR);
                zzayv.zzd(parcel);
                zzj(iObjectWrapperAsInterface4, zzaVar);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
