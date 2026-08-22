package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.auth.PhoneAuthCredential;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzsv implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        PhoneAuthCredential phoneAuthCredential = null;
        String strCreateString = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                phoneAuthCredential = (PhoneAuthCredential) Protocol.Companion.createParcelable(parcel, i, PhoneAuthCredential.CREATOR);
            } else if (c != 2) {
                Protocol.Companion.skipUnknownField(parcel, i);
            } else {
                strCreateString = Protocol.Companion.createString(parcel, i);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzsu(phoneAuthCredential, strCreateString);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzsu[i];
    }
}
