package com.google.android.gms.games.internal.v2.appshortcuts;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.PersistableBundle;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzj implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        String strCreateString = null;
        PersistableBundle persistableBundle = null;
        Boolean booleanObject = null;
        Boolean booleanObject2 = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                strCreateString = Protocol.Companion.createString(parcel, i);
            } else if (c == 2) {
                persistableBundle = (PersistableBundle) Protocol.Companion.createParcelable(parcel, i, PersistableBundle.CREATOR);
            } else if (c == 3) {
                booleanObject = Protocol.Companion.readBooleanObject(parcel, i);
            } else if (c != 4) {
                Protocol.Companion.skipUnknownField(parcel, i);
            } else {
                booleanObject2 = Protocol.Companion.readBooleanObject(parcel, i);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzi(strCreateString, persistableBundle, booleanObject, booleanObject2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzi[i];
    }
}
