package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzb implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        int i = 0;
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i3 = parcel.readInt();
            char c = (char) i3;
            if (c == 1) {
                i = Protocol.Companion.readInt(parcel, i3);
            } else if (c == 2) {
                i2 = Protocol.Companion.readInt(parcel, i3);
            } else if (c == 7) {
                z = Protocol.Companion.readBoolean(parcel, i3);
            } else if (c == '\b') {
                z2 = Protocol.Companion.readBoolean(parcel, i3);
            } else if (c != '\t') {
                Protocol.Companion.skipUnknownField(parcel, i3);
            } else {
                z3 = Protocol.Companion.readBoolean(parcel, i3);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new VideoConfiguration(i, i2, z, z2, z3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new VideoConfiguration[i];
    }
}
