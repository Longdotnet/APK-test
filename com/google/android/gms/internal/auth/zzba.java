package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzba implements Parcelable.Creator<zzaz> {
    @Override // android.os.Parcelable.Creator
    public final zzaz createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        int i = 0;
        String strCreateString = null;
        byte[] bArrCreateByteArray = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i2 = parcel.readInt();
            char c = (char) i2;
            if (c == 1) {
                i = Protocol.Companion.readInt(parcel, i2);
            } else if (c == 2) {
                strCreateString = Protocol.Companion.createString(parcel, i2);
            } else if (c != 3) {
                Protocol.Companion.skipUnknownField(parcel, i2);
            } else {
                bArrCreateByteArray = Protocol.Companion.createByteArray(parcel, i2);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzaz(i, strCreateString, bArrCreateByteArray);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzaz[] newArray(int i) {
        return new zzaz[i];
    }
}
