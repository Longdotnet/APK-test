package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzze implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        String strCreateString = null;
        String strCreateString2 = null;
        zzaaw zzaawVar = null;
        ArrayList arrayListCreateStringList = null;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 2:
                    strCreateString = Protocol.Companion.createString(parcel, i);
                    break;
                case 3:
                    z = Protocol.Companion.readBoolean(parcel, i);
                    break;
                case 4:
                    strCreateString2 = Protocol.Companion.createString(parcel, i);
                    break;
                case 5:
                    z2 = Protocol.Companion.readBoolean(parcel, i);
                    break;
                case 6:
                    zzaawVar = (zzaaw) Protocol.Companion.createParcelable(parcel, i, zzaaw.CREATOR);
                    break;
                case 7:
                    arrayListCreateStringList = Protocol.Companion.createStringList(parcel, i);
                    break;
                default:
                    Protocol.Companion.skipUnknownField(parcel, i);
                    break;
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzzd(strCreateString, z, strCreateString2, z2, zzaawVar, arrayListCreateStringList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzzd[i];
    }
}
