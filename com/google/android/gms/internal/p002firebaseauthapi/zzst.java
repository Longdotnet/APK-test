package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.auth.EmailAuthCredential;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzst implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        EmailAuthCredential emailAuthCredential = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i = parcel.readInt();
            if (((char) i) != 1) {
                Protocol.Companion.skipUnknownField(parcel, i);
            } else {
                emailAuthCredential = (EmailAuthCredential) Protocol.Companion.createParcelable(parcel, i, EmailAuthCredential.CREATOR);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzss(emailAuthCredential);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzss[i];
    }
}
