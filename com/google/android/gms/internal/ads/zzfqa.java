package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzfqa implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        int i = 0;
        byte[] bArrCreateByteArray = null;
        int i2 = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i3 = parcel.readInt();
            char c = (char) i3;
            if (c == 1) {
                i = Protocol.Companion.readInt(parcel, i3);
            } else if (c == 2) {
                bArrCreateByteArray = Protocol.Companion.createByteArray(parcel, i3);
            } else if (c != 3) {
                Protocol.Companion.skipUnknownField(parcel, i3);
            } else {
                i2 = Protocol.Companion.readInt(parcel, i3);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzfpz(i, bArrCreateByteArray, i2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzfpz[i];
    }
}
