package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzbxy implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        String strCreateString = null;
        String strCreateString2 = null;
        ArrayList arrayListCreateStringList = null;
        ArrayList arrayListCreateStringList2 = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 2:
                    strCreateString = Protocol.Companion.createString(parcel, i);
                    break;
                case 3:
                    strCreateString2 = Protocol.Companion.createString(parcel, i);
                    break;
                case 4:
                    z = Protocol.Companion.readBoolean(parcel, i);
                    break;
                case 5:
                    z2 = Protocol.Companion.readBoolean(parcel, i);
                    break;
                case 6:
                    arrayListCreateStringList = Protocol.Companion.createStringList(parcel, i);
                    break;
                case 7:
                    z3 = Protocol.Companion.readBoolean(parcel, i);
                    break;
                case '\b':
                    z4 = Protocol.Companion.readBoolean(parcel, i);
                    break;
                case '\t':
                    arrayListCreateStringList2 = Protocol.Companion.createStringList(parcel, i);
                    break;
                default:
                    Protocol.Companion.skipUnknownField(parcel, i);
                    break;
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzbxx(strCreateString, strCreateString2, z, z2, arrayListCreateStringList, z3, z4, arrayListCreateStringList2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbxx[i];
    }
}
