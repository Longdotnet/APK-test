package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.auth.ActionCodeSettings;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzsd implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        String strCreateString = null;
        ActionCodeSettings actionCodeSettings = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                strCreateString = Protocol.Companion.createString(parcel, i);
            } else if (c != 2) {
                Protocol.Companion.skipUnknownField(parcel, i);
            } else {
                actionCodeSettings = (ActionCodeSettings) Protocol.Companion.createParcelable(parcel, i, ActionCodeSettings.CREATOR);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzsc(strCreateString, actionCodeSettings);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzsc[i];
    }
}
