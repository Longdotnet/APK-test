package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbgo extends zzayu implements zzbgp {
    public zzbgo() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    public static zzbgp zzh(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
        return iInterfaceQueryLocalInterface instanceof zzbgp ? (zzbgp) iInterfaceQueryLocalInterface : new zzbgn(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                IObjectWrapper iObjectWrapperZzf = zzf();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, iObjectWrapperZzf);
                return true;
            case 2:
                Uri uriZze = zze();
                parcel2.writeNoException();
                zzayv.zzf(parcel2, uriZze);
                return true;
            case 3:
                double dZzb = zzb();
                parcel2.writeNoException();
                parcel2.writeDouble(dZzb);
                return true;
            case 4:
                int iZzd = zzd();
                parcel2.writeNoException();
                parcel2.writeInt(iZzd);
                return true;
            case 5:
                int iZzc = zzc();
                parcel2.writeNoException();
                parcel2.writeInt(iZzc);
                return true;
            case 6:
                Map mapZzg = zzg();
                parcel2.writeNoException();
                parcel2.writeMap(mapZzg);
                return true;
            default:
                return false;
        }
    }
}
