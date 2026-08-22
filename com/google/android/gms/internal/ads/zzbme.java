package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzbme implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        String strCreateString = null;
        boolean z = false;
        int i = 0;
        String strCreateString2 = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i2 = parcel.readInt();
            char c = (char) i2;
            if (c == 1) {
                strCreateString = Protocol.Companion.createString(parcel, i2);
            } else if (c == 2) {
                z = Protocol.Companion.readBoolean(parcel, i2);
            } else if (c == 3) {
                i = Protocol.Companion.readInt(parcel, i2);
            } else if (c != 4) {
                Protocol.Companion.skipUnknownField(parcel, i2);
            } else {
                strCreateString2 = Protocol.Companion.createString(parcel, i2);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzbmd(strCreateString, z, i, strCreateString2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbmd[i];
    }
}
