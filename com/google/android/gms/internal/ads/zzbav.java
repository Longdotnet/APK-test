package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbav extends zzayu implements zzbaw {
    public zzbav() {
        super("com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
    }

    public static zzbaw zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
        return iInterfaceQueryLocalInterface instanceof zzbaw ? (zzbaw) iInterfaceQueryLocalInterface : new zzbau(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzbbd zzbbbVar;
        switch (i) {
            case 2:
                com.google.android.gms.ads.internal.client.zzbx zzbxVarZzf = zzf();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzbxVarZzf);
                return true;
            case 3:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    boolean z = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenAdPresentationCallback") instanceof zzbba;
                }
                zzayv.zzd(parcel);
                parcel2.writeNoException();
                return true;
            case 4:
                IObjectWrapper iObjectWrapperAsInterface = ObjectWrapper.asInterface(parcel.readStrongBinder());
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 == null) {
                    zzbbbVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenFullScreenContentCallback");
                    zzbbbVar = iInterfaceQueryLocalInterface instanceof zzbbd ? (zzbbd) iInterfaceQueryLocalInterface : new zzbbb(strongBinder2);
                }
                zzayv.zzd(parcel);
                zzl(iObjectWrapperAsInterface, zzbbbVar);
                parcel2.writeNoException();
                return true;
            case 5:
                com.google.android.gms.ads.internal.client.zzea zzeaVarZzg = zzg();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzeaVarZzg);
                return true;
            case 6:
                boolean zZzh = zzayv.zzh(parcel);
                zzayv.zzd(parcel);
                zzi(zZzh);
                parcel2.writeNoException();
                return true;
            case 7:
                com.google.android.gms.ads.internal.client.zzdt zzdtVarZzb = com.google.android.gms.ads.internal.client.zzfu.zzb(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzj(zzdtVarZzb);
                parcel2.writeNoException();
                return true;
            case 8:
                String strZzh = zzh();
                parcel2.writeNoException();
                parcel2.writeString(strZzh);
                return true;
            case 9:
                long jZze = zze();
                parcel2.writeNoException();
                parcel2.writeLong(jZze);
                return true;
            case 10:
                long j = parcel.readLong();
                zzayv.zzd(parcel);
                zzk(j);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
