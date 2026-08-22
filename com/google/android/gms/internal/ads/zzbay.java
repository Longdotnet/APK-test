package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.loader.app.gv.DYYbQc;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzbay extends zzayu implements zzbaz {
    public zzbay() {
        super("com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzbaw zzbauVar;
        if (i == 1) {
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder == null) {
                zzbauVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
                zzbauVar = iInterfaceQueryLocalInterface instanceof zzbaw ? (zzbaw) iInterfaceQueryLocalInterface : new zzbau(strongBinder);
            }
            zzayv.zzd(parcel);
            zzd(zzbauVar);
        } else if (i == 2) {
            parcel.readInt();
            zzayv.zzd(parcel);
        } else {
            if (i != 3) {
                return false;
            }
            com.google.android.gms.ads.internal.client.zze zzeVar = (com.google.android.gms.ads.internal.client.zze) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zze.CREATOR);
            zzayv.zzd(parcel);
            zzc(zzeVar);
        }
        parcel2.writeNoException();
        return true;
    }

    public static zzbaz zze(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DYYbQc.PXqAl);
        return iInterfaceQueryLocalInterface instanceof zzbaz ? (zzbaz) iInterfaceQueryLocalInterface : new zzbax(iBinder);
    }
}
