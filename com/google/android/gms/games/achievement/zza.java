package com.google.android.gms.games.achievement;

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
        String strCreateString = null;
        String strCreateString2 = null;
        String strCreateString3 = null;
        Uri uri = null;
        String strCreateString4 = null;
        Uri uri2 = null;
        String strCreateString5 = null;
        String strCreateString6 = null;
        PlayerEntity playerEntity = null;
        String strCreateString7 = null;
        String strCreateString8 = null;
        float f = -1.0f;
        long j = 0;
        long j2 = 0;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i5 = parcel.readInt();
            switch ((char) i5) {
                case 1:
                    strCreateString = Protocol.Companion.createString(parcel, i5);
                    break;
                case 2:
                    i = Protocol.Companion.readInt(parcel, i5);
                    break;
                case 3:
                    strCreateString2 = Protocol.Companion.createString(parcel, i5);
                    break;
                case 4:
                    strCreateString3 = Protocol.Companion.createString(parcel, i5);
                    break;
                case 5:
                    uri = (Uri) Protocol.Companion.createParcelable(parcel, i5, Uri.CREATOR);
                    break;
                case 6:
                    strCreateString4 = Protocol.Companion.createString(parcel, i5);
                    break;
                case 7:
                    uri2 = (Uri) Protocol.Companion.createParcelable(parcel, i5, Uri.CREATOR);
                    break;
                case '\b':
                    strCreateString5 = Protocol.Companion.createString(parcel, i5);
                    break;
                case '\t':
                    i2 = Protocol.Companion.readInt(parcel, i5);
                    break;
                case '\n':
                    strCreateString6 = Protocol.Companion.createString(parcel, i5);
                    break;
                case 11:
                    playerEntity = (PlayerEntity) Protocol.Companion.createParcelable(parcel, i5, PlayerEntity.CREATOR);
                    break;
                case '\f':
                    i3 = Protocol.Companion.readInt(parcel, i5);
                    break;
                case '\r':
                    i4 = Protocol.Companion.readInt(parcel, i5);
                    break;
                case 14:
                    strCreateString7 = Protocol.Companion.createString(parcel, i5);
                    break;
                case 15:
                    j = Protocol.Companion.readLong(parcel, i5);
                    break;
                case 16:
                    j2 = Protocol.Companion.readLong(parcel, i5);
                    break;
                case 17:
                    f = Protocol.Companion.readFloat(parcel, i5);
                    break;
                case 18:
                    strCreateString8 = Protocol.Companion.createString(parcel, i5);
                    break;
                default:
                    Protocol.Companion.skipUnknownField(parcel, i5);
                    break;
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new AchievementEntity(strCreateString, i, strCreateString2, strCreateString3, uri, strCreateString4, uri2, strCreateString5, i2, strCreateString6, playerEntity, i3, i4, strCreateString7, j, j2, f, strCreateString8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new AchievementEntity[i];
    }
}
