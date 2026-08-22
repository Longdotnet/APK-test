package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.location.LocationRequest;
import java.util.List;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzbb implements Parcelable.Creator<zzba> {
    @Override // android.os.Parcelable.Creator
    public final zzba createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        List<ClientIdentity> listCreateTypedList = zzba.zza;
        LocationRequest locationRequest = null;
        String strCreateString = null;
        String strCreateString2 = null;
        String strCreateString3 = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        long j = Long.MAX_VALUE;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c != 1) {
                switch (c) {
                    case 5:
                        listCreateTypedList = Protocol.Companion.createTypedList(parcel, i, ClientIdentity.CREATOR);
                        break;
                    case 6:
                        strCreateString = Protocol.Companion.createString(parcel, i);
                        break;
                    case 7:
                        z = Protocol.Companion.readBoolean(parcel, i);
                        break;
                    case '\b':
                        z2 = Protocol.Companion.readBoolean(parcel, i);
                        break;
                    case '\t':
                        z3 = Protocol.Companion.readBoolean(parcel, i);
                        break;
                    case '\n':
                        strCreateString2 = Protocol.Companion.createString(parcel, i);
                        break;
                    case 11:
                        z4 = Protocol.Companion.readBoolean(parcel, i);
                        break;
                    case '\f':
                        z5 = Protocol.Companion.readBoolean(parcel, i);
                        break;
                    case '\r':
                        strCreateString3 = Protocol.Companion.createString(parcel, i);
                        break;
                    case 14:
                        j = Protocol.Companion.readLong(parcel, i);
                        break;
                    default:
                        Protocol.Companion.skipUnknownField(parcel, i);
                        break;
                }
            } else {
                locationRequest = (LocationRequest) Protocol.Companion.createParcelable(parcel, i, LocationRequest.CREATOR);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzba(locationRequest, listCreateTypedList, strCreateString, z, z2, z3, strCreateString2, z4, z5, strCreateString3, j);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzba[] newArray(int i) {
        return new zzba[i];
    }
}
