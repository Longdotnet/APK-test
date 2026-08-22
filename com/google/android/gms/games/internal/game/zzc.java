package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public class zzc implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new GameBadgeEntity[i];
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public GameBadgeEntity createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        String strCreateString = null;
        Uri uri = null;
        int i = 0;
        String strCreateString2 = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i2 = parcel.readInt();
            char c = (char) i2;
            if (c == 1) {
                i = Protocol.Companion.readInt(parcel, i2);
            } else if (c == 2) {
                strCreateString = Protocol.Companion.createString(parcel, i2);
            } else if (c == 3) {
                strCreateString2 = Protocol.Companion.createString(parcel, i2);
            } else if (c != 4) {
                Protocol.Companion.skipUnknownField(parcel, i2);
            } else {
                uri = (Uri) Protocol.Companion.createParcelable(parcel, i2, Uri.CREATOR);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new GameBadgeEntity(i, strCreateString, strCreateString2, uri);
    }
}
