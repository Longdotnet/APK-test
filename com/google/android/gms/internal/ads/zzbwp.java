package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzbwp implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        int i = 0;
        String strCreateString = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i2 = parcel.readInt();
            char c = (char) i2;
            if (c == 2) {
                strCreateString = Protocol.Companion.createString(parcel, i2);
            } else if (c != 3) {
                Protocol.Companion.skipUnknownField(parcel, i2);
            } else {
                i = Protocol.Companion.readInt(parcel, i2);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzbwo(strCreateString, i);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbwo[i];
    }
}
