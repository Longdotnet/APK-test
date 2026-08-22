package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.protobuf.DescriptorProtos;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public class zzf implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new GameEntity[i];
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public GameEntity createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        boolean z = false;
        boolean z2 = false;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        String strCreateString = null;
        String strCreateString2 = null;
        String strCreateString3 = null;
        String strCreateString4 = null;
        String strCreateString5 = null;
        String strCreateString6 = null;
        Uri uri = null;
        Uri uri2 = null;
        Uri uri3 = null;
        String strCreateString7 = null;
        String strCreateString8 = null;
        String strCreateString9 = null;
        String strCreateString10 = null;
        String strCreateString11 = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i4 = parcel.readInt();
            char c = (char) i4;
            if (c != 28) {
                switch (c) {
                    case 1:
                        strCreateString = Protocol.Companion.createString(parcel, i4);
                        break;
                    case 2:
                        strCreateString2 = Protocol.Companion.createString(parcel, i4);
                        break;
                    case 3:
                        strCreateString3 = Protocol.Companion.createString(parcel, i4);
                        break;
                    case 4:
                        strCreateString4 = Protocol.Companion.createString(parcel, i4);
                        break;
                    case 5:
                        strCreateString5 = Protocol.Companion.createString(parcel, i4);
                        break;
                    case 6:
                        strCreateString6 = Protocol.Companion.createString(parcel, i4);
                        break;
                    case 7:
                        uri = (Uri) Protocol.Companion.createParcelable(parcel, i4, Uri.CREATOR);
                        break;
                    case '\b':
                        uri2 = (Uri) Protocol.Companion.createParcelable(parcel, i4, Uri.CREATOR);
                        break;
                    case '\t':
                        uri3 = (Uri) Protocol.Companion.createParcelable(parcel, i4, Uri.CREATOR);
                        break;
                    case '\n':
                        z = Protocol.Companion.readBoolean(parcel, i4);
                        break;
                    case 11:
                        z2 = Protocol.Companion.readBoolean(parcel, i4);
                        break;
                    case '\f':
                        strCreateString7 = Protocol.Companion.createString(parcel, i4);
                        break;
                    case '\r':
                        i = Protocol.Companion.readInt(parcel, i4);
                        break;
                    case 14:
                        i2 = Protocol.Companion.readInt(parcel, i4);
                        break;
                    case 15:
                        i3 = Protocol.Companion.readInt(parcel, i4);
                        break;
                    case 16:
                        z3 = Protocol.Companion.readBoolean(parcel, i4);
                        break;
                    case 17:
                        z4 = Protocol.Companion.readBoolean(parcel, i4);
                        break;
                    case 18:
                        strCreateString8 = Protocol.Companion.createString(parcel, i4);
                        break;
                    case 19:
                        strCreateString9 = Protocol.Companion.createString(parcel, i4);
                        break;
                    case 20:
                        strCreateString10 = Protocol.Companion.createString(parcel, i4);
                        break;
                    case 21:
                        z5 = Protocol.Companion.readBoolean(parcel, i4);
                        break;
                    case 22:
                        z6 = Protocol.Companion.readBoolean(parcel, i4);
                        break;
                    case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                        z7 = Protocol.Companion.readBoolean(parcel, i4);
                        break;
                    case 24:
                        strCreateString11 = Protocol.Companion.createString(parcel, i4);
                        break;
                    case 25:
                        z8 = Protocol.Companion.readBoolean(parcel, i4);
                        break;
                    default:
                        Protocol.Companion.skipUnknownField(parcel, i4);
                        break;
                }
            } else {
                z9 = Protocol.Companion.readBoolean(parcel, i4);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new GameEntity(strCreateString, strCreateString2, strCreateString3, strCreateString4, strCreateString5, strCreateString6, uri, uri2, uri3, z, z2, strCreateString7, i, i2, i3, z3, z4, strCreateString8, strCreateString9, strCreateString10, z5, z6, z7, strCreateString11, z8, z9);
    }
}
