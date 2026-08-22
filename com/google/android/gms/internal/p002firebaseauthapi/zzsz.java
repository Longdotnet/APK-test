package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzsz implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        PhoneMultiFactorInfo phoneMultiFactorInfo = null;
        String strCreateString = null;
        String strCreateString2 = null;
        String strCreateString3 = null;
        String strCreateString4 = null;
        long j = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    phoneMultiFactorInfo = (PhoneMultiFactorInfo) Protocol.Companion.createParcelable(parcel, i, PhoneMultiFactorInfo.CREATOR);
                    break;
                case 2:
                    strCreateString = Protocol.Companion.createString(parcel, i);
                    break;
                case 3:
                    strCreateString2 = Protocol.Companion.createString(parcel, i);
                    break;
                case 4:
                    j = Protocol.Companion.readLong(parcel, i);
                    break;
                case 5:
                    z = Protocol.Companion.readBoolean(parcel, i);
                    break;
                case 6:
                    z2 = Protocol.Companion.readBoolean(parcel, i);
                    break;
                case 7:
                    strCreateString3 = Protocol.Companion.createString(parcel, i);
                    break;
                case '\b':
                    strCreateString4 = Protocol.Companion.createString(parcel, i);
                    break;
                case '\t':
                    z3 = Protocol.Companion.readBoolean(parcel, i);
                    break;
                default:
                    Protocol.Companion.skipUnknownField(parcel, i);
                    break;
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzsy(phoneMultiFactorInfo, strCreateString, strCreateString2, j, z, z2, strCreateString3, strCreateString4, z3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzsy[i];
    }
}
