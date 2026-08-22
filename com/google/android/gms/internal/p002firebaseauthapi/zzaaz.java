package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzaaz implements Parcelable.Creator {
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
        String strCreateString8 = null;
        String strCreateString9 = null;
        String strCreateString10 = null;
        String strCreateString11 = null;
        String strCreateString12 = null;
        String strCreateString13 = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 2:
                    strCreateString = Protocol.Companion.createString(parcel, i);
                    break;
                case 3:
                    strCreateString2 = Protocol.Companion.createString(parcel, i);
                    break;
                case 4:
                    strCreateString3 = Protocol.Companion.createString(parcel, i);
                    break;
                case 5:
                    strCreateString4 = Protocol.Companion.createString(parcel, i);
                    break;
                case 6:
                    strCreateString5 = Protocol.Companion.createString(parcel, i);
                    break;
                case 7:
                    strCreateString6 = Protocol.Companion.createString(parcel, i);
                    break;
                case '\b':
                    strCreateString7 = Protocol.Companion.createString(parcel, i);
                    break;
                case '\t':
                    strCreateString8 = Protocol.Companion.createString(parcel, i);
                    break;
                case '\n':
                    z = Protocol.Companion.readBoolean(parcel, i);
                    break;
                case 11:
                    z2 = Protocol.Companion.readBoolean(parcel, i);
                    break;
                case '\f':
                    strCreateString9 = Protocol.Companion.createString(parcel, i);
                    break;
                case '\r':
                    strCreateString10 = Protocol.Companion.createString(parcel, i);
                    break;
                case 14:
                    strCreateString11 = Protocol.Companion.createString(parcel, i);
                    break;
                case 15:
                    strCreateString12 = Protocol.Companion.createString(parcel, i);
                    break;
                case 16:
                    z3 = Protocol.Companion.readBoolean(parcel, i);
                    break;
                case 17:
                    strCreateString13 = Protocol.Companion.createString(parcel, i);
                    break;
                default:
                    Protocol.Companion.skipUnknownField(parcel, i);
                    break;
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzaay(strCreateString, strCreateString2, strCreateString3, strCreateString4, strCreateString5, strCreateString6, strCreateString7, strCreateString8, z, z2, strCreateString9, strCreateString10, strCreateString11, strCreateString12, z3, strCreateString13);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzaay[i];
    }
}
