package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzaay;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzf implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        String strCreateString = null;
        String strCreateString2 = null;
        String strCreateString3 = null;
        zzaay zzaayVar = null;
        String strCreateString4 = null;
        String strCreateString5 = null;
        String strCreateString6 = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    strCreateString = Protocol.Companion.createString(parcel, i);
                    break;
                case 2:
                    strCreateString2 = Protocol.Companion.createString(parcel, i);
                    break;
                case 3:
                    strCreateString3 = Protocol.Companion.createString(parcel, i);
                    break;
                case 4:
                    zzaayVar = (zzaay) Protocol.Companion.createParcelable(parcel, i, zzaay.CREATOR);
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
                default:
                    Protocol.Companion.skipUnknownField(parcel, i);
                    break;
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zze(strCreateString, strCreateString2, strCreateString3, zzaayVar, strCreateString4, strCreateString5, strCreateString6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zze[i];
    }
}
