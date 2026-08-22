package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzal implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        String strCreateString = null;
        boolean z = false;
        boolean z2 = false;
        String strCreateString2 = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 2) {
                strCreateString = Protocol.Companion.createString(parcel, i);
            } else if (c == 3) {
                strCreateString2 = Protocol.Companion.createString(parcel, i);
            } else if (c == 4) {
                z = Protocol.Companion.readBoolean(parcel, i);
            } else if (c != 5) {
                Protocol.Companion.skipUnknownField(parcel, i);
            } else {
                z2 = Protocol.Companion.readBoolean(parcel, i);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new UserProfileChangeRequest(strCreateString, strCreateString2, z, z2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new UserProfileChangeRequest[i];
    }
}
