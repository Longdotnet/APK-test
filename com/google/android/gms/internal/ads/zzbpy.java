package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbpy extends zzayu implements zzbpz {
    public zzbpy() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd");
    }

    public static zzbpz zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd");
        return iInterfaceQueryLocalInterface instanceof zzbpz ? (zzbpz) iInterfaceQueryLocalInterface : new zzbpx(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            IObjectWrapper iObjectWrapperZze = zze();
            parcel2.writeNoException();
            zzayv.zzg(parcel2, iObjectWrapperZze);
        } else {
            if (i != 2) {
                return false;
            }
            boolean zZzf = zzf();
            parcel2.writeNoException();
            int i3 = zzayv.zza;
            parcel2.writeInt(zZzf ? 1 : 0);
        }
        return true;
    }
}
