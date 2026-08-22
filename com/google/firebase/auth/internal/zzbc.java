package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import java.util.ArrayList;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzbc implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        ArrayList arrayListCreateTypedList = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i = parcel.readInt();
            if (((char) i) != 1) {
                Protocol.Companion.skipUnknownField(parcel, i);
            } else {
                arrayListCreateTypedList = Protocol.Companion.createTypedList(parcel, i, PhoneMultiFactorInfo.CREATOR);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzbb(arrayListCreateTypedList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbb[i];
    }
}
