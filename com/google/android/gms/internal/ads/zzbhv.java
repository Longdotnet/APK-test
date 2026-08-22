package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbhv extends zzayu implements zzbhw {
    public zzbhv() {
        super("com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
    }

    public static zzbhw zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
        return iInterfaceQueryLocalInterface instanceof zzbhw ? (zzbhw) iInterfaceQueryLocalInterface : new zzbhu(iBinder);
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
        zzayv.zzd(parcel);
        zze(zzbhhVar);
        parcel2.writeNoException();
        return true;
    }
}
