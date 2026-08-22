package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzd implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        GameEntity gameEntity = null;
        PlayerEntity playerEntity = null;
        String strCreateString = null;
        Uri uri = null;
        String strCreateString2 = null;
        String strCreateString3 = null;
        String strCreateString4 = null;
        String strCreateString5 = null;
        String strCreateString6 = null;
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        boolean z = false;
        float f = 0.0f;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    gameEntity = (GameEntity) Protocol.Companion.createParcelable(parcel, i, GameEntity.CREATOR);
                    break;
                case 2:
                    playerEntity = (PlayerEntity) Protocol.Companion.createParcelable(parcel, i, PlayerEntity.CREATOR);
                    break;
                case 3:
                    strCreateString = Protocol.Companion.createString(parcel, i);
                    break;
                case 4:
                default:
                    Protocol.Companion.skipUnknownField(parcel, i);
                    break;
                case 5:
                    uri = (Uri) Protocol.Companion.createParcelable(parcel, i, Uri.CREATOR);
                    break;
                case 6:
                    strCreateString2 = Protocol.Companion.createString(parcel, i);
                    break;
                case 7:
                    strCreateString3 = Protocol.Companion.createString(parcel, i);
                    break;
                case '\b':
                    strCreateString4 = Protocol.Companion.createString(parcel, i);
                    break;
                case '\t':
                    j = Protocol.Companion.readLong(parcel, i);
                    break;
                case '\n':
                    j2 = Protocol.Companion.readLong(parcel, i);
                    break;
                case 11:
                    f = Protocol.Companion.readFloat(parcel, i);
                    break;
                case '\f':
                    strCreateString5 = Protocol.Companion.createString(parcel, i);
                    break;
                case '\r':
                    z = Protocol.Companion.readBoolean(parcel, i);
                    break;
                case 14:
                    j3 = Protocol.Companion.readLong(parcel, i);
                    break;
                case 15:
                    strCreateString6 = Protocol.Companion.createString(parcel, i);
                    break;
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new SnapshotMetadataEntity(gameEntity, playerEntity, strCreateString, uri, strCreateString2, strCreateString3, strCreateString4, j, j2, f, strCreateString5, z, j3, strCreateString6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new SnapshotMetadataEntity[i];
    }
}
