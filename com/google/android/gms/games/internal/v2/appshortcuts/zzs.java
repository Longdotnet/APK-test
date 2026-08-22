package com.google.android.gms.games.internal.v2.appshortcuts;

import android.content.ComponentName;
import android.os.Parcel;
import android.os.Parcelable;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzs implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        String strCreateString = null;
        ComponentName componentName = null;
        String strCreateString2 = null;
        int i = 0;
        long j = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i2 = parcel.readInt();
            char c = (char) i2;
            if (c == 1) {
                j = Protocol.Companion.readLong(parcel, i2);
            } else if (c == 2) {
                strCreateString = Protocol.Companion.createString(parcel, i2);
            } else if (c == 3) {
                i = Protocol.Companion.readInt(parcel, i2);
            } else if (c == 4) {
                componentName = (ComponentName) Protocol.Companion.createParcelable(parcel, i2, ComponentName.CREATOR);
            } else if (c != 5) {
                Protocol.Companion.skipUnknownField(parcel, i2);
            } else {
                strCreateString2 = Protocol.Companion.createString(parcel, i2);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzr(j, strCreateString, i, componentName, strCreateString2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzr[i];
    }
}
