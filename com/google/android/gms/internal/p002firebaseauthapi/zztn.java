package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.auth.zze;
import java.util.ArrayList;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zztn implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        String strCreateString = null;
        ArrayList arrayListCreateTypedList = null;
        zze zzeVar = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                strCreateString = Protocol.Companion.createString(parcel, i);
            } else if (c == 2) {
                arrayListCreateTypedList = Protocol.Companion.createTypedList(parcel, i, zzaac.CREATOR);
            } else if (c != 3) {
                Protocol.Companion.skipUnknownField(parcel, i);
            } else {
                zzeVar = (zze) Protocol.Companion.createParcelable(parcel, i, zze.CREATOR);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zztm(strCreateString, arrayListCreateTypedList, zzeVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zztm[i];
    }
}
