package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import java.util.ArrayList;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzaf implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        ArrayList arrayListCreateTypedList = null;
        zzag zzagVar = null;
        String strCreateString = null;
        com.google.firebase.auth.zze zzeVar = null;
        zzx zzxVar = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                arrayListCreateTypedList = Protocol.Companion.createTypedList(parcel, i, PhoneMultiFactorInfo.CREATOR);
            } else if (c == 2) {
                zzagVar = (zzag) Protocol.Companion.createParcelable(parcel, i, zzag.CREATOR);
            } else if (c == 3) {
                strCreateString = Protocol.Companion.createString(parcel, i);
            } else if (c == 4) {
                zzeVar = (com.google.firebase.auth.zze) Protocol.Companion.createParcelable(parcel, i, com.google.firebase.auth.zze.CREATOR);
            } else if (c != 5) {
                Protocol.Companion.skipUnknownField(parcel, i);
            } else {
                zzxVar = (zzx) Protocol.Companion.createParcelable(parcel, i, zzx.CREATOR);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzae(arrayListCreateTypedList, zzagVar, strCreateString, zzeVar, zzxVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzae[i];
    }
}
