package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbgl extends zzayu implements zzbgm {
    public zzbgl() {
        super("com.google.android.gms.ads.internal.formats.client.IMediaContent");
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzbhx zzbhxVar;
        switch (i) {
            case 2:
                float fZze = zze();
                parcel2.writeNoException();
                parcel2.writeFloat(fZze);
                return true;
            case 3:
                IObjectWrapper iObjectWrapperAsInterface = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzj(iObjectWrapperAsInterface);
                parcel2.writeNoException();
                return true;
            case 4:
                IObjectWrapper iObjectWrapperZzi = zzi();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, iObjectWrapperZzi);
                return true;
            case 5:
                float fZzg = zzg();
                parcel2.writeNoException();
                parcel2.writeFloat(fZzg);
                return true;
            case 6:
                float fZzf = zzf();
                parcel2.writeNoException();
                parcel2.writeFloat(fZzf);
                return true;
            case 7:
                com.google.android.gms.ads.internal.client.zzed zzedVarZzh = zzh();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzedVarZzh);
                return true;
            case 8:
                boolean zZzl = zzl();
                parcel2.writeNoException();
                int i3 = zzayv.zza;
                parcel2.writeInt(zZzl ? 1 : 0);
                return true;
            case 9:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder == null) {
                    zzbhxVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnMediaContentChangedListener");
                    zzbhxVar = iInterfaceQueryLocalInterface instanceof zzbhx ? (zzbhx) iInterfaceQueryLocalInterface : new zzbhx(strongBinder);
                }
                zzayv.zzd(parcel);
                zzm(zzbhxVar);
                parcel2.writeNoException();
                return true;
            case 10:
                boolean zZzk = zzk();
                parcel2.writeNoException();
                int i4 = zzayv.zza;
                parcel2.writeInt(zZzk ? 1 : 0);
                return true;
            default:
                return false;
        }
    }
}
