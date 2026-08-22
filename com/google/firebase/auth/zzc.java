package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzc implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        String strCreateString = null;
        String strCreateString2 = null;
        String strCreateString3 = null;
        String strCreateString4 = null;
        String strCreateString5 = null;
        String strCreateString6 = null;
        String strCreateString7 = null;
        boolean z = false;
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i2 = parcel.readInt();
            switch ((char) i2) {
                case 1:
                    strCreateString = Protocol.Companion.createString(parcel, i2);
                    break;
                case 2:
                    strCreateString2 = Protocol.Companion.createString(parcel, i2);
                    break;
                case 3:
                    strCreateString3 = Protocol.Companion.createString(parcel, i2);
                    break;
                case 4:
                    strCreateString4 = Protocol.Companion.createString(parcel, i2);
                    break;
                case 5:
                    z = Protocol.Companion.readBoolean(parcel, i2);
                    break;
                case 6:
                    strCreateString5 = Protocol.Companion.createString(parcel, i2);
                    break;
                case 7:
                    z2 = Protocol.Companion.readBoolean(parcel, i2);
                    break;
                case '\b':
                    strCreateString6 = Protocol.Companion.createString(parcel, i2);
                    break;
                case '\t':
                    i = Protocol.Companion.readInt(parcel, i2);
                    break;
                case '\n':
                    strCreateString7 = Protocol.Companion.createString(parcel, i2);
                    break;
                default:
                    Protocol.Companion.skipUnknownField(parcel, i2);
                    break;
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new ActionCodeSettings(strCreateString, strCreateString2, strCreateString3, strCreateString4, z, strCreateString5, z2, strCreateString6, i, strCreateString7);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new ActionCodeSettings[i];
    }
}
