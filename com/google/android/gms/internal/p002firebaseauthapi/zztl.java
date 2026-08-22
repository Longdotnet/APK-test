package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.zze;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zztl implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        Status status = null;
        zze zzeVar = null;
        String strCreateString = null;
        String strCreateString2 = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                status = (Status) Protocol.Companion.createParcelable(parcel, i, Status.CREATOR);
            } else if (c == 2) {
                zzeVar = (zze) Protocol.Companion.createParcelable(parcel, i, zze.CREATOR);
            } else if (c == 3) {
                strCreateString = Protocol.Companion.createString(parcel, i);
            } else if (c != 4) {
                Protocol.Companion.skipUnknownField(parcel, i);
            } else {
                strCreateString2 = Protocol.Companion.createString(parcel, i);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zztk(status, zzeVar, strCreateString, strCreateString2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zztk[i];
    }
}
