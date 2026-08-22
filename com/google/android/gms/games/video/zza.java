package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zza implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        boolean[] zArrCreateBooleanArray = null;
        boolean[] zArrCreateBooleanArray2 = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                z = Protocol.Companion.readBoolean(parcel, i);
            } else if (c == 2) {
                z2 = Protocol.Companion.readBoolean(parcel, i);
            } else if (c == 3) {
                z3 = Protocol.Companion.readBoolean(parcel, i);
            } else if (c == 4) {
                zArrCreateBooleanArray = Protocol.Companion.createBooleanArray(parcel, i);
            } else if (c != 5) {
                Protocol.Companion.skipUnknownField(parcel, i);
            } else {
                zArrCreateBooleanArray2 = Protocol.Companion.createBooleanArray(parcel, i);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new VideoCapabilities(z, z2, z3, zArrCreateBooleanArray, zArrCreateBooleanArray2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new VideoCapabilities[i];
    }
}
