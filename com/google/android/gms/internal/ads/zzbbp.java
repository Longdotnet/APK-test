package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzbbp implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        boolean z = false;
        int i = 0;
        String strCreateString = null;
        String strCreateString2 = null;
        String strCreateString3 = null;
        String strCreateString4 = null;
        Bundle bundleCreateBundle = null;
        String strCreateString5 = null;
        long j = 0;
        long j2 = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i2 = parcel.readInt();
            switch ((char) i2) {
                case 2:
                    strCreateString = Protocol.Companion.createString(parcel, i2);
                    break;
                case 3:
                    j = Protocol.Companion.readLong(parcel, i2);
                    break;
                case 4:
                    strCreateString2 = Protocol.Companion.createString(parcel, i2);
                    break;
                case 5:
                    strCreateString3 = Protocol.Companion.createString(parcel, i2);
                    break;
                case 6:
                    strCreateString4 = Protocol.Companion.createString(parcel, i2);
                    break;
                case 7:
                    bundleCreateBundle = Protocol.Companion.createBundle(parcel, i2);
                    break;
                case '\b':
                    z = Protocol.Companion.readBoolean(parcel, i2);
                    break;
                case '\t':
                    j2 = Protocol.Companion.readLong(parcel, i2);
                    break;
                case '\n':
                    strCreateString5 = Protocol.Companion.createString(parcel, i2);
                    break;
                case 11:
                    i = Protocol.Companion.readInt(parcel, i2);
                    break;
                default:
                    Protocol.Companion.skipUnknownField(parcel, i2);
                    break;
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzbbo(strCreateString, j, strCreateString2, strCreateString3, strCreateString4, bundleCreateBundle, z, j2, strCreateString5, i);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbbo[i];
    }
}
