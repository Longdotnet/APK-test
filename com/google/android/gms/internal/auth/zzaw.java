package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzaw implements Parcelable.Creator<zzav> {
    @Override // android.os.Parcelable.Creator
    public final zzav createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        int i = 0;
        String strCreateString = null;
        int i2 = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i3 = parcel.readInt();
            char c = (char) i3;
            if (c == 1) {
                i = Protocol.Companion.readInt(parcel, i3);
            } else if (c == 2) {
                strCreateString = Protocol.Companion.createString(parcel, i3);
            } else if (c != 3) {
                Protocol.Companion.skipUnknownField(parcel, i3);
            } else {
                i2 = Protocol.Companion.readInt(parcel, i3);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzav(i, strCreateString, i2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzav[] newArray(int i) {
        return new zzav[i];
    }
}
