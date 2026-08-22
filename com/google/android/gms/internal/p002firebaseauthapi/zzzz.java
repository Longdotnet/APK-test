package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzzz implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        String strCreateString = null;
        String strCreateString2 = null;
        Long longObject = null;
        String strCreateString3 = null;
        Long longObject2 = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 2) {
                strCreateString = Protocol.Companion.createString(parcel, i);
            } else if (c == 3) {
                strCreateString2 = Protocol.Companion.createString(parcel, i);
            } else if (c == 4) {
                longObject = Protocol.Companion.readLongObject(parcel, i);
            } else if (c == 5) {
                strCreateString3 = Protocol.Companion.createString(parcel, i);
            } else if (c != 6) {
                Protocol.Companion.skipUnknownField(parcel, i);
            } else {
                longObject2 = Protocol.Companion.readLongObject(parcel, i);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzzy(strCreateString, strCreateString2, longObject, strCreateString3, longObject2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzzy[i];
    }
}
