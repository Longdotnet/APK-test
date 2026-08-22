package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbhs extends zzayu implements zzbht {
    public zzbhs() {
        super("com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
    }

    public static zzbht zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
        return iInterfaceQueryLocalInterface instanceof zzbht ? (zzbht) iInterfaceQueryLocalInterface : new zzbhr(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzbhj zzbhhVar;
        if (i != 1) {
            return false;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        if (strongBinder == null) {
            zzbhhVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
            zzbhhVar = iInterfaceQueryLocalInterface instanceof zzbhj ? (zzbhj) iInterfaceQueryLocalInterface : new zzbhh(strongBinder);
        }
        String string = parcel.readString();
        zzayv.zzd(parcel);
        zze(zzbhhVar, string);
        parcel2.writeNoException();
        return true;
    }
}
