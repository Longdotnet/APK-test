package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzcm implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        long j = 0;
        long j2 = 0;
        boolean z = false;
        String strCreateString = null;
        String strCreateString2 = null;
        String strCreateString3 = null;
        Bundle bundleCreateBundle = null;
        String strCreateString4 = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    j = Protocol.Companion.readLong(parcel, i);
                    break;
                case 2:
                    j2 = Protocol.Companion.readLong(parcel, i);
                    break;
                case 3:
                    z = Protocol.Companion.readBoolean(parcel, i);
                    break;
                case 4:
                    strCreateString = Protocol.Companion.createString(parcel, i);
                    break;
                case 5:
                    strCreateString2 = Protocol.Companion.createString(parcel, i);
                    break;
                case 6:
                    strCreateString3 = Protocol.Companion.createString(parcel, i);
                    break;
                case 7:
                    bundleCreateBundle = Protocol.Companion.createBundle(parcel, i);
                    break;
                case '\b':
                    strCreateString4 = Protocol.Companion.createString(parcel, i);
                    break;
                default:
                    Protocol.Companion.skipUnknownField(parcel, i);
                    break;
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzcl(j, j2, z, strCreateString, strCreateString2, strCreateString3, bundleCreateBundle, strCreateString4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzcl[i];
    }
}
