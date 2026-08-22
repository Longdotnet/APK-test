package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzbsf implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i4 = parcel.readInt();
            char c = (char) i4;
            if (c == 1) {
                i = Protocol.Companion.readInt(parcel, i4);
            } else if (c == 2) {
                i2 = Protocol.Companion.readInt(parcel, i4);
            } else if (c != 3) {
                Protocol.Companion.skipUnknownField(parcel, i4);
            } else {
                i3 = Protocol.Companion.readInt(parcel, i4);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzbse(i, i2, i3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbse[i];
    }
}
