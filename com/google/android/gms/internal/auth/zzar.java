package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzar implements Parcelable.Creator<zzaq> {
    @Override // android.os.Parcelable.Creator
    public final zzaq createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        int i = 0;
        String strCreateString = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i2 = parcel.readInt();
            char c = (char) i2;
            if (c == 1) {
                i = Protocol.Companion.readInt(parcel, i2);
            } else if (c != 2) {
                Protocol.Companion.skipUnknownField(parcel, i2);
            } else {
                strCreateString = Protocol.Companion.createString(parcel, i2);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzaq(i, strCreateString);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzaq[] newArray(int i) {
        return new zzaq[i];
    }
}
