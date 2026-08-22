package com.google.android.gms.games.internal.player;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzg implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        Status status = null;
        String strCreateString = null;
        StockProfileImageEntity stockProfileImageEntity = null;
        zzh zzhVar = null;
        Boolean booleanObject = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        int i = 0;
        boolean z6 = false;
        boolean z7 = false;
        int i2 = 0;
        int i3 = 0;
        boolean z8 = false;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i4 = parcel.readInt();
            switch ((char) i4) {
                case 1:
                    status = (Status) Protocol.Companion.createParcelable(parcel, i4, Status.CREATOR);
                    break;
                case 2:
                    strCreateString = Protocol.Companion.createString(parcel, i4);
                    break;
                case 3:
                    z = Protocol.Companion.readBoolean(parcel, i4);
                    break;
                case 4:
                    z2 = Protocol.Companion.readBoolean(parcel, i4);
                    break;
                case 5:
                    z3 = Protocol.Companion.readBoolean(parcel, i4);
                    break;
                case 6:
                    stockProfileImageEntity = (StockProfileImageEntity) Protocol.Companion.createParcelable(parcel, i4, StockProfileImageEntity.CREATOR);
                    break;
                case 7:
                    z4 = Protocol.Companion.readBoolean(parcel, i4);
                    break;
                case '\b':
                    z5 = Protocol.Companion.readBoolean(parcel, i4);
                    break;
                case '\t':
                    i = Protocol.Companion.readInt(parcel, i4);
                    break;
                case '\n':
                    z6 = Protocol.Companion.readBoolean(parcel, i4);
                    break;
                case 11:
                    z7 = Protocol.Companion.readBoolean(parcel, i4);
                    break;
                case '\f':
                    i2 = Protocol.Companion.readInt(parcel, i4);
                    break;
                case '\r':
                    i3 = Protocol.Companion.readInt(parcel, i4);
                    break;
                case 14:
                    z8 = Protocol.Companion.readBoolean(parcel, i4);
                    break;
                case 15:
                    zzhVar = (zzh) Protocol.Companion.createParcelable(parcel, i4, zzh.CREATOR);
                    break;
                case 16:
                    booleanObject = Protocol.Companion.readBooleanObject(parcel, i4);
                    break;
                default:
                    Protocol.Companion.skipUnknownField(parcel, i4);
                    break;
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new ProfileSettingsEntity(status, strCreateString, z, z2, z3, stockProfileImageEntity, z4, z5, i, z6, z7, i2, i3, z8, zzhVar, booleanObject);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new ProfileSettingsEntity[i];
    }
}
