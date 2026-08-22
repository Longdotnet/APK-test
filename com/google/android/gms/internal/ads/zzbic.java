package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.loader.app.gv.DYYbQc;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzbic extends zzayu implements zzbid {
    public static zzbid zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnUnifiedNativeAdLoadedListener");
        return iInterfaceQueryLocalInterface instanceof zzbid ? (zzbid) iInterfaceQueryLocalInterface : new zzbib(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzbij zzbihVar;
        if (i != 1) {
            return false;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        if (strongBinder == null) {
            zzbihVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
            zzbihVar = iInterfaceQueryLocalInterface instanceof zzbij ? (zzbij) iInterfaceQueryLocalInterface : new zzbih(strongBinder);
        }
        zzayv.zzd(parcel);
        zze(zzbihVar);
        parcel2.writeNoException();
        return true;
    }

    public zzbic() {
        super(DYYbQc.DixsfJkvtNGYlwD);
    }
}
