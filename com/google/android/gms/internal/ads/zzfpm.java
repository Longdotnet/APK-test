package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzfpm implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        byte[] bArrCreateByteArray = null;
        int i = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i2 = parcel.readInt();
            char c = (char) i2;
            if (c == 1) {
                i = Protocol.Companion.readInt(parcel, i2);
            } else if (c != 2) {
                Protocol.Companion.skipUnknownField(parcel, i2);
            } else {
                bArrCreateByteArray = Protocol.Companion.createByteArray(parcel, i2);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzfpl(i, bArrCreateByteArray);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzfpl[i];
    }
}
