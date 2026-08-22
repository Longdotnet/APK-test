package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzaax implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        int i = 0;
        ArrayList arrayListCreateStringList = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i2 = parcel.readInt();
            char c = (char) i2;
            if (c == 1) {
                i = Protocol.Companion.readInt(parcel, i2);
            } else if (c != 2) {
                Protocol.Companion.skipUnknownField(parcel, i2);
            } else {
                arrayListCreateStringList = Protocol.Companion.createStringList(parcel, i2);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzaaw(i, arrayListCreateStringList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzaaw[i];
    }
}
