package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzaak implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        String strCreateString = null;
        String strCreateString2 = null;
        String strCreateString3 = null;
        zzaac zzaacVar = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 2) {
                strCreateString = Protocol.Companion.createString(parcel, i);
            } else if (c == 3) {
                strCreateString2 = Protocol.Companion.createString(parcel, i);
            } else if (c == 4) {
                strCreateString3 = Protocol.Companion.createString(parcel, i);
            } else if (c != 5) {
                Protocol.Companion.skipUnknownField(parcel, i);
            } else {
                zzaacVar = (zzaac) Protocol.Companion.createParcelable(parcel, i, zzaac.CREATOR);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzaaj(strCreateString, strCreateString2, strCreateString3, zzaacVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzaaj[i];
    }
}
