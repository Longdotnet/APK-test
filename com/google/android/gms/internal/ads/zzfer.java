package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzfer implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        String strCreateString = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i7 = parcel.readInt();
            switch ((char) i7) {
                case 1:
                    i = Protocol.Companion.readInt(parcel, i7);
                    break;
                case 2:
                    i2 = Protocol.Companion.readInt(parcel, i7);
                    break;
                case 3:
                    i3 = Protocol.Companion.readInt(parcel, i7);
                    break;
                case 4:
                    i4 = Protocol.Companion.readInt(parcel, i7);
                    break;
                case 5:
                    strCreateString = Protocol.Companion.createString(parcel, i7);
                    break;
                case 6:
                    i5 = Protocol.Companion.readInt(parcel, i7);
                    break;
                case 7:
                    i6 = Protocol.Companion.readInt(parcel, i7);
                    break;
                default:
                    Protocol.Companion.skipUnknownField(parcel, i7);
                    break;
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzfeq(i, i2, i3, i4, strCreateString, i5, i6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzfeq[i];
    }
}
