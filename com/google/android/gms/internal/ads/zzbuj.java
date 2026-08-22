package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzbuj implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                iBinder = Protocol.Companion.readIBinder(parcel, i);
            } else if (c != 2) {
                Protocol.Companion.skipUnknownField(parcel, i);
            } else {
                iBinder2 = Protocol.Companion.readIBinder(parcel, i);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzbui(iBinder, iBinder2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbui[i];
    }
}
