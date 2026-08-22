package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzabd implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        String strCreateString = null;
        String strCreateString2 = null;
        long j = 0;
        boolean z = false;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 2) {
                strCreateString = Protocol.Companion.createString(parcel, i);
            } else if (c == 3) {
                strCreateString2 = Protocol.Companion.createString(parcel, i);
            } else if (c == 4) {
                j = Protocol.Companion.readLong(parcel, i);
            } else if (c != 5) {
                Protocol.Companion.skipUnknownField(parcel, i);
            } else {
                z = Protocol.Companion.readBoolean(parcel, i);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzabc(strCreateString, strCreateString2, j, z);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzabc[i];
    }
}
