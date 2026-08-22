package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzbmq implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        int i = 0;
        int i2 = 0;
        String strCreateString = null;
        int i3 = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i4 = parcel.readInt();
            char c = (char) i4;
            if (c == 1) {
                i3 = Protocol.Companion.readInt(parcel, i4);
            } else if (c == 2) {
                strCreateString = Protocol.Companion.createString(parcel, i4);
            } else if (c == 3) {
                i2 = Protocol.Companion.readInt(parcel, i4);
            } else if (c != 1000) {
                Protocol.Companion.skipUnknownField(parcel, i4);
            } else {
                i = Protocol.Companion.readInt(parcel, i4);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzbmp(i, i3, strCreateString, i2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbmp[i];
    }
}
