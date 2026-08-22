package com.google.android.gms.games.internal.experience;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.games.GameEntity;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zza implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        int i = 0;
        int i2 = 0;
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        String strCreateString = null;
        GameEntity gameEntity = null;
        String strCreateString2 = null;
        String strCreateString3 = null;
        String strCreateString4 = null;
        Uri uri = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i3 = parcel.readInt();
            switch ((char) i3) {
                case 1:
                    strCreateString = Protocol.Companion.createString(parcel, i3);
                    break;
                case 2:
                    gameEntity = (GameEntity) Protocol.Companion.createParcelable(parcel, i3, GameEntity.CREATOR);
                    break;
                case 3:
                    strCreateString2 = Protocol.Companion.createString(parcel, i3);
                    break;
                case 4:
                    strCreateString3 = Protocol.Companion.createString(parcel, i3);
                    break;
                case 5:
                    strCreateString4 = Protocol.Companion.createString(parcel, i3);
                    break;
                case 6:
                    uri = (Uri) Protocol.Companion.createParcelable(parcel, i3, Uri.CREATOR);
                    break;
                case 7:
                    j = Protocol.Companion.readLong(parcel, i3);
                    break;
                case '\b':
                    j2 = Protocol.Companion.readLong(parcel, i3);
                    break;
                case '\t':
                    j3 = Protocol.Companion.readLong(parcel, i3);
                    break;
                case '\n':
                    i = Protocol.Companion.readInt(parcel, i3);
                    break;
                case 11:
                    i2 = Protocol.Companion.readInt(parcel, i3);
                    break;
                default:
                    Protocol.Companion.skipUnknownField(parcel, i3);
                    break;
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new ExperienceEventEntity(strCreateString, gameEntity, strCreateString2, strCreateString3, strCreateString4, uri, j, j2, j3, i, i2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new ExperienceEventEntity[i];
    }
}
