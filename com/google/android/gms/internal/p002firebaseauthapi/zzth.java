package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.auth.UserProfileChangeRequest;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzth implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        UserProfileChangeRequest userProfileChangeRequest = null;
        String strCreateString = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                userProfileChangeRequest = (UserProfileChangeRequest) Protocol.Companion.createParcelable(parcel, i, UserProfileChangeRequest.CREATOR);
            } else if (c != 2) {
                Protocol.Companion.skipUnknownField(parcel, i);
            } else {
                strCreateString = Protocol.Companion.createString(parcel, i);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zztg(userProfileChangeRequest, strCreateString);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zztg[i];
    }
}
