package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;
import com.google.protobuf.DescriptorProtos;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public class zzl implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new PlayerEntity[i];
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zza */
    public PlayerEntity createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        String strCreateString = null;
        String strCreateString2 = null;
        Uri uri = null;
        Uri uri2 = null;
        String strCreateString3 = null;
        String strCreateString4 = null;
        String strCreateString5 = null;
        MostRecentGameInfoEntity mostRecentGameInfoEntity = null;
        PlayerLevelInfo playerLevelInfo = null;
        String strCreateString6 = null;
        String strCreateString7 = null;
        Uri uri3 = null;
        String strCreateString8 = null;
        Uri uri4 = null;
        String strCreateString9 = null;
        zzo zzoVar = null;
        zza zzaVar = null;
        String strCreateString10 = null;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        long j = -1;
        long j2 = 0;
        long j3 = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i2 = parcel.readInt();
            switch ((char) i2) {
                case 1:
                    strCreateString = Protocol.Companion.createString(parcel, i2);
                    break;
                case 2:
                    strCreateString2 = Protocol.Companion.createString(parcel, i2);
                    break;
                case 3:
                    uri = (Uri) Protocol.Companion.createParcelable(parcel, i2, Uri.CREATOR);
                    break;
                case 4:
                    uri2 = (Uri) Protocol.Companion.createParcelable(parcel, i2, Uri.CREATOR);
                    break;
                case 5:
                    j2 = Protocol.Companion.readLong(parcel, i2);
                    break;
                case 6:
                    i = Protocol.Companion.readInt(parcel, i2);
                    break;
                case 7:
                    j3 = Protocol.Companion.readLong(parcel, i2);
                    break;
                case '\b':
                    strCreateString3 = Protocol.Companion.createString(parcel, i2);
                    break;
                case '\t':
                    strCreateString4 = Protocol.Companion.createString(parcel, i2);
                    break;
                case '\n':
                case 11:
                case '\f':
                case '\r':
                case 17:
                case 26:
                case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                case 28:
                case 30:
                case DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                case ' ':
                case '\"':
                default:
                    Protocol.Companion.skipUnknownField(parcel, i2);
                    break;
                case 14:
                    strCreateString5 = Protocol.Companion.createString(parcel, i2);
                    break;
                case 15:
                    mostRecentGameInfoEntity = (MostRecentGameInfoEntity) Protocol.Companion.createParcelable(parcel, i2, MostRecentGameInfoEntity.CREATOR);
                    break;
                case 16:
                    playerLevelInfo = (PlayerLevelInfo) Protocol.Companion.createParcelable(parcel, i2, PlayerLevelInfo.CREATOR);
                    break;
                case 18:
                    z = Protocol.Companion.readBoolean(parcel, i2);
                    break;
                case 19:
                    z2 = Protocol.Companion.readBoolean(parcel, i2);
                    break;
                case 20:
                    strCreateString6 = Protocol.Companion.createString(parcel, i2);
                    break;
                case 21:
                    strCreateString7 = Protocol.Companion.createString(parcel, i2);
                    break;
                case 22:
                    uri3 = (Uri) Protocol.Companion.createParcelable(parcel, i2, Uri.CREATOR);
                    break;
                case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                    strCreateString8 = Protocol.Companion.createString(parcel, i2);
                    break;
                case 24:
                    uri4 = (Uri) Protocol.Companion.createParcelable(parcel, i2, Uri.CREATOR);
                    break;
                case 25:
                    strCreateString9 = Protocol.Companion.createString(parcel, i2);
                    break;
                case 29:
                    j = Protocol.Companion.readLong(parcel, i2);
                    break;
                case '!':
                    zzoVar = (zzo) Protocol.Companion.createParcelable(parcel, i2, zzo.CREATOR);
                    break;
                case DescriptorProtos.MethodOptions.FEATURES_FIELD_NUMBER /* 35 */:
                    zzaVar = (zza) Protocol.Companion.createParcelable(parcel, i2, zza.CREATOR);
                    break;
                case DescriptorProtos.FileOptions.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                    z3 = Protocol.Companion.readBoolean(parcel, i2);
                    break;
                case DescriptorProtos.FileOptions.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
                    strCreateString10 = Protocol.Companion.createString(parcel, i2);
                    break;
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new PlayerEntity(strCreateString, strCreateString2, uri, uri2, j2, i, j3, strCreateString3, strCreateString4, strCreateString5, mostRecentGameInfoEntity, playerLevelInfo, z, z2, strCreateString6, strCreateString7, uri3, strCreateString8, uri4, strCreateString9, j, zzoVar, zzaVar, z3, strCreateString10);
    }
}
