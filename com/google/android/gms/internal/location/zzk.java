package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import java.util.List;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzk implements Parcelable.Creator<zzj> {
    @Override // android.os.Parcelable.Creator
    public final zzj createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        com.google.android.gms.location.zzs zzsVar = zzj.zzb;
        List<ClientIdentity> listCreateTypedList = zzj.zza;
        String strCreateString = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                zzsVar = (com.google.android.gms.location.zzs) Protocol.Companion.createParcelable(parcel, i, com.google.android.gms.location.zzs.CREATOR);
            } else if (c == 2) {
                listCreateTypedList = Protocol.Companion.createTypedList(parcel, i, ClientIdentity.CREATOR);
            } else if (c != 3) {
                Protocol.Companion.skipUnknownField(parcel, i);
            } else {
                strCreateString = Protocol.Companion.createString(parcel, i);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzj(zzsVar, listCreateTypedList, strCreateString);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzj[] newArray(int i) {
        return new zzj[i];
    }
}
