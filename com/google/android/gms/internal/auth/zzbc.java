package com.google.android.gms.internal.auth;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzbc implements Parcelable.Creator<zzbb> {
    @Override // android.os.Parcelable.Creator
    public final zzbb createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        int i = 0;
        String strCreateString = null;
        PendingIntent pendingIntent = null;
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
                pendingIntent = (PendingIntent) Protocol.Companion.createParcelable(parcel, i2, PendingIntent.CREATOR);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzbb(i, strCreateString, pendingIntent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzbb[] newArray(int i) {
        return new zzbb[i];
    }
}
