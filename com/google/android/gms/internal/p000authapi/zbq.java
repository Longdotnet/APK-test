package com.google.android.gms.internal.p000authapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.Credential;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zbq implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        Credential credential = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i = parcel.readInt();
            if (((char) i) != 1) {
                Protocol.Companion.skipUnknownField(parcel, i);
            } else {
                credential = (Credential) Protocol.Companion.createParcelable(parcel, i, Credential.CREATOR);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zbp(credential);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zbp[i];
    }
}
