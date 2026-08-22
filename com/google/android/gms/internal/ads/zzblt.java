package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzblt implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        long j = 0;
        boolean z = false;
        int i = 0;
        boolean z2 = false;
        String strCreateString = null;
        byte[] bArrCreateByteArray = null;
        String[] strArrCreateStringArray = null;
        String[] strArrCreateStringArray2 = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i2 = parcel.readInt();
            switch ((char) i2) {
                case 1:
                    z = Protocol.Companion.readBoolean(parcel, i2);
                    break;
                case 2:
                    strCreateString = Protocol.Companion.createString(parcel, i2);
                    break;
                case 3:
                    i = Protocol.Companion.readInt(parcel, i2);
                    break;
                case 4:
                    bArrCreateByteArray = Protocol.Companion.createByteArray(parcel, i2);
                    break;
                case 5:
                    strArrCreateStringArray = Protocol.Companion.createStringArray(parcel, i2);
                    break;
                case 6:
                    strArrCreateStringArray2 = Protocol.Companion.createStringArray(parcel, i2);
                    break;
                case 7:
                    z2 = Protocol.Companion.readBoolean(parcel, i2);
                    break;
                case '\b':
                    j = Protocol.Companion.readLong(parcel, i2);
                    break;
                default:
                    Protocol.Companion.skipUnknownField(parcel, i2);
                    break;
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzbls(z, strCreateString, i, bArrCreateByteArray, strArrCreateStringArray, strArrCreateStringArray2, z2, j);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbls[i];
    }
}
