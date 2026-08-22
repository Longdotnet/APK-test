package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzs implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        zzx zzxVar = null;
        zzp zzpVar = null;
        com.google.firebase.auth.zze zzeVar = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                zzxVar = (zzx) Protocol.Companion.createParcelable(parcel, i, zzx.CREATOR);
            } else if (c == 2) {
                zzpVar = (zzp) Protocol.Companion.createParcelable(parcel, i, zzp.CREATOR);
            } else if (c != 3) {
                Protocol.Companion.skipUnknownField(parcel, i);
            } else {
                zzeVar = (com.google.firebase.auth.zze) Protocol.Companion.createParcelable(parcel, i, com.google.firebase.auth.zze.CREATOR);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzr(zzxVar, zzpVar, zzeVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzr[i];
    }
}
