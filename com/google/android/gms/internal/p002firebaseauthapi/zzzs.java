package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.auth.zze;
import java.util.ArrayList;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzzs implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        String strCreateString = null;
        String strCreateString2 = null;
        String strCreateString3 = null;
        String strCreateString4 = null;
        zzaag zzaagVar = null;
        String strCreateString5 = null;
        String strCreateString6 = null;
        zze zzeVar = null;
        ArrayList arrayListCreateTypedList = null;
        boolean z = false;
        boolean z2 = false;
        long j = 0;
        long j2 = 0;
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
                    strCreateString3 = Protocol.Companion.createString(parcel, i);
                    break;
                case 6:
                    strCreateString4 = Protocol.Companion.createString(parcel, i);
                    break;
                case 7:
                    zzaagVar = (zzaag) Protocol.Companion.createParcelable(parcel, i, zzaag.CREATOR);
                    break;
                case '\b':
                    strCreateString5 = Protocol.Companion.createString(parcel, i);
                    break;
                case '\t':
                    strCreateString6 = Protocol.Companion.createString(parcel, i);
                    break;
                case '\n':
                    j = Protocol.Companion.readLong(parcel, i);
                    break;
                case 11:
                    j2 = Protocol.Companion.readLong(parcel, i);
                    break;
                case '\f':
                    z2 = Protocol.Companion.readBoolean(parcel, i);
                    break;
                case '\r':
                    zzeVar = (zze) Protocol.Companion.createParcelable(parcel, i, zze.CREATOR);
                    break;
                case 14:
                    arrayListCreateTypedList = Protocol.Companion.createTypedList(parcel, i, zzaac.CREATOR);
                    break;
                default:
                    Protocol.Companion.skipUnknownField(parcel, i);
                    break;
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzzr(strCreateString, strCreateString2, z, strCreateString3, strCreateString4, zzaagVar, strCreateString5, strCreateString6, j, j2, z2, zzeVar, arrayListCreateTypedList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzzr[i];
    }
}
