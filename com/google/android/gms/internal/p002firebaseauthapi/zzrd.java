package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzrd implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        String strCreateString = null;
        String strCreateString2 = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                strCreateString = Protocol.Companion.createString(parcel, i);
            } else if (c != 2) {
                Protocol.Companion.skipUnknownField(parcel, i);
            } else {
                strCreateString2 = Protocol.Companion.createString(parcel, i);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzrc(strCreateString, strCreateString2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzrc[i];
    }
}
