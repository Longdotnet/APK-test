package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzayv;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzdv extends zzayu implements zzdw {
    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        String string = parcel.readString();
        IObjectWrapper iObjectWrapperAsInterface = ObjectWrapper.asInterface(parcel.readStrongBinder());
        IObjectWrapper iObjectWrapperAsInterface2 = ObjectWrapper.asInterface(parcel.readStrongBinder());
        zzayv.zzd(parcel);
        zze(string, iObjectWrapperAsInterface, iObjectWrapperAsInterface2);
        parcel2.writeNoException();
        return true;
    }
}
