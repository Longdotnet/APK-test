package com.google.android.gms.internal.ads;

import android.os.Parcel;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.firebase.inject.PVS.jIKWv;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzfqk extends zzayu implements zzfql {
    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 2:
                ObjectWrapper.asInterface(parcel.readStrongBinder());
                parcel.readString();
                zzayv.zzd(parcel);
                break;
            case 3:
                break;
            case 4:
                parcel.createIntArray();
                zzayv.zzd(parcel);
                break;
            case 5:
                parcel.createByteArray();
                zzayv.zzd(parcel);
                break;
            case 6:
                parcel.readInt();
                zzayv.zzd(parcel);
                break;
            case 7:
                parcel.readInt();
                zzayv.zzd(parcel);
                break;
            case 8:
                ObjectWrapper.asInterface(parcel.readStrongBinder());
                parcel.readString();
                parcel.readString();
                zzayv.zzd(parcel);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }

    public zzfqk() {
        super(jIKWv.yxoBLXfLMbkwMBP);
    }
}
