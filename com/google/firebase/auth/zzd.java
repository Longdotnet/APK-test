package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzd implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        while (parcel.dataPosition() < iValidateObjectHeader) {
            Protocol.Companion.skipUnknownField(parcel, parcel.readInt());
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new PhoneAuthProvider.ForceResendingToken();
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new PhoneAuthProvider.ForceResendingToken[i];
    }
}
