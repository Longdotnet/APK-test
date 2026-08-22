package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.signin.internal.FVfQ.GsPcpBmONXh;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzbmr extends zzayu implements zzbms {
    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzbmv zzbmtVar;
        if (i == 3) {
            com.google.android.gms.ads.internal.client.zzed zzedVarZzb = zzb();
            parcel2.writeNoException();
            zzayv.zzg(parcel2, zzedVarZzb);
            return true;
        }
        if (i == 4) {
            zzd();
            parcel2.writeNoException();
            return true;
        }
        if (i == 5) {
            IObjectWrapper iObjectWrapperAsInterface = ObjectWrapper.asInterface(parcel.readStrongBinder());
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder == null) {
                zzbmtVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
                zzbmtVar = iInterfaceQueryLocalInterface instanceof zzbmv ? (zzbmv) iInterfaceQueryLocalInterface : new zzbmt(strongBinder);
            }
            zzayv.zzd(parcel);
            zzf(iObjectWrapperAsInterface, zzbmtVar);
            parcel2.writeNoException();
            return true;
        }
        if (i == 6) {
            IObjectWrapper iObjectWrapperAsInterface2 = ObjectWrapper.asInterface(parcel.readStrongBinder());
            zzayv.zzd(parcel);
            zze(iObjectWrapperAsInterface2);
            parcel2.writeNoException();
            return true;
        }
        if (i != 7) {
            return false;
        }
        zzbgm zzbgmVarZzc = zzc();
        parcel2.writeNoException();
        zzayv.zzg(parcel2, zzbgmVarZzc);
        return true;
    }

    public zzbmr() {
        super(GsPcpBmONXh.bSL);
    }
}
