package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzzy;
import java.util.ArrayList;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzy implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        zzzy zzzyVar = null;
        zzt zztVar = null;
        String strCreateString = null;
        String strCreateString2 = null;
        ArrayList arrayListCreateTypedList = null;
        ArrayList arrayListCreateStringList = null;
        String strCreateString3 = null;
        Boolean booleanObject = null;
        zzz zzzVar = null;
        com.google.firebase.auth.zze zzeVar = null;
        zzbb zzbbVar = null;
        boolean z = false;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    zzzyVar = (zzzy) Protocol.Companion.createParcelable(parcel, i, zzzy.CREATOR);
                    break;
                case 2:
                    zztVar = (zzt) Protocol.Companion.createParcelable(parcel, i, zzt.CREATOR);
                    break;
                case 3:
                    strCreateString = Protocol.Companion.createString(parcel, i);
                    break;
                case 4:
                    strCreateString2 = Protocol.Companion.createString(parcel, i);
                    break;
                case 5:
                    arrayListCreateTypedList = Protocol.Companion.createTypedList(parcel, i, zzt.CREATOR);
                    break;
                case 6:
                    arrayListCreateStringList = Protocol.Companion.createStringList(parcel, i);
                    break;
                case 7:
                    strCreateString3 = Protocol.Companion.createString(parcel, i);
                    break;
                case '\b':
                    booleanObject = Protocol.Companion.readBooleanObject(parcel, i);
                    break;
                case '\t':
                    zzzVar = (zzz) Protocol.Companion.createParcelable(parcel, i, zzz.CREATOR);
                    break;
                case '\n':
                    z = Protocol.Companion.readBoolean(parcel, i);
                    break;
                case 11:
                    zzeVar = (com.google.firebase.auth.zze) Protocol.Companion.createParcelable(parcel, i, com.google.firebase.auth.zze.CREATOR);
                    break;
                case '\f':
                    zzbbVar = (zzbb) Protocol.Companion.createParcelable(parcel, i, zzbb.CREATOR);
                    break;
                default:
                    Protocol.Companion.skipUnknownField(parcel, i);
                    break;
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzx(zzzyVar, zztVar, strCreateString, strCreateString2, arrayListCreateTypedList, arrayListCreateStringList, strCreateString3, booleanObject, zzzVar, z, zzeVar, zzbbVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzx[i];
    }
}
