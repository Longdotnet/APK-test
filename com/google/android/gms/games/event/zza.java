package com.google.android.gms.games.event;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.games.PlayerEntity;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zza implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        boolean z = false;
        String strCreateString = null;
        String strCreateString2 = null;
        String strCreateString3 = null;
        Uri uri = null;
        String strCreateString4 = null;
        PlayerEntity playerEntity = null;
        String strCreateString5 = null;
        long j = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    strCreateString = Protocol.Companion.createString(parcel, i);
                    break;
                case 2:
                    strCreateString2 = Protocol.Companion.createString(parcel, i);
                    break;
                case 3:
                    strCreateString3 = Protocol.Companion.createString(parcel, i);
                    break;
                case 4:
                    uri = (Uri) Protocol.Companion.createParcelable(parcel, i, Uri.CREATOR);
                    break;
                case 5:
                    strCreateString4 = Protocol.Companion.createString(parcel, i);
                    break;
                case 6:
                    playerEntity = (PlayerEntity) Protocol.Companion.createParcelable(parcel, i, PlayerEntity.CREATOR);
                    break;
                case 7:
                    j = Protocol.Companion.readLong(parcel, i);
                    break;
                case '\b':
                    strCreateString5 = Protocol.Companion.createString(parcel, i);
                    break;
                case '\t':
                    z = Protocol.Companion.readBoolean(parcel, i);
                    break;
                default:
                    Protocol.Companion.skipUnknownField(parcel, i);
                    break;
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new EventEntity(strCreateString, strCreateString2, strCreateString3, uri, strCreateString4, playerEntity, j, strCreateString5, z);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new EventEntity[i];
    }
}
