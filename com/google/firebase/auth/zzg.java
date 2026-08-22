package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzg implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        String strCreateString = null;
        String strCreateString2 = null;
        String strCreateString3 = null;
        String strCreateString4 = null;
        boolean z = false;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                strCreateString = Protocol.Companion.createString(parcel, i);
            } else if (c == 2) {
                strCreateString2 = Protocol.Companion.createString(parcel, i);
            } else if (c == 3) {
                strCreateString3 = Protocol.Companion.createString(parcel, i);
            } else if (c == 4) {
                strCreateString4 = Protocol.Companion.createString(parcel, i);
            } else if (c != 5) {
                Protocol.Companion.skipUnknownField(parcel, i);
            } else {
                z = Protocol.Companion.readBoolean(parcel, i);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new EmailAuthCredential(strCreateString, strCreateString2, strCreateString3, strCreateString4, z);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new EmailAuthCredential[i];
    }
}
