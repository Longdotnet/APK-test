package com.google.android.gms.internal.ads;

import android.os.Parcel;
import com.google.android.gms.common.util.concurrent.dN.MnHfHMYQDPUO;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzbdv extends zzayu implements zzbdw {
    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            String strZzb = zzb();
            parcel2.writeNoException();
            parcel2.writeString(strZzb);
        } else if (i == 2) {
            String strZzc = zzc();
            parcel2.writeNoException();
            parcel2.writeString(strZzc);
        } else if (i == 3) {
            IObjectWrapper iObjectWrapperAsInterface = ObjectWrapper.asInterface(parcel.readStrongBinder());
            zzayv.zzd(parcel);
            zzd(iObjectWrapperAsInterface);
            parcel2.writeNoException();
        } else if (i == 4) {
            zze();
            parcel2.writeNoException();
        } else {
            if (i != 5) {
                return false;
            }
            zzf();
            parcel2.writeNoException();
        }
        return true;
    }

    public zzbdv() {
        super(MnHfHMYQDPUO.CzKAV);
    }
}
