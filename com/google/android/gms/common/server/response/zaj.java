package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.server.converter.zaa;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zaj implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        String strCreateString = null;
        String strCreateString2 = null;
        zaa zaaVar = null;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        int i4 = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i5 = parcel.readInt();
            switch ((char) i5) {
                case 1:
                    i = Protocol.Companion.readInt(parcel, i5);
                    break;
                case 2:
                    i2 = Protocol.Companion.readInt(parcel, i5);
                    break;
                case 3:
                    z = Protocol.Companion.readBoolean(parcel, i5);
                    break;
                case 4:
                    i3 = Protocol.Companion.readInt(parcel, i5);
                    break;
                case 5:
                    z2 = Protocol.Companion.readBoolean(parcel, i5);
                    break;
                case 6:
                    strCreateString = Protocol.Companion.createString(parcel, i5);
                    break;
                case 7:
                    i4 = Protocol.Companion.readInt(parcel, i5);
                    break;
                case '\b':
                    strCreateString2 = Protocol.Companion.createString(parcel, i5);
                    break;
                case '\t':
                    zaaVar = (zaa) Protocol.Companion.createParcelable(parcel, i5, zaa.CREATOR);
                    break;
                default:
                    Protocol.Companion.skipUnknownField(parcel, i5);
                    break;
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new FastJsonResponse.Field(i, i2, z, i3, z2, strCreateString, i4, strCreateString2, zaaVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new FastJsonResponse.Field[i];
    }
}
