package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzj implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        String strCreateString = "";
        String strCreateString2 = null;
        Uri uri = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                strCreateString2 = Protocol.Companion.createString(parcel, i);
            } else if (c == 2) {
                uri = (Uri) Protocol.Companion.createParcelable(parcel, i, Uri.CREATOR);
            } else if (c != 3) {
                Protocol.Companion.skipUnknownField(parcel, i);
            } else {
                strCreateString = Protocol.Companion.createString(parcel, i);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new StockProfileImageEntity(strCreateString2, uri, strCreateString);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new StockProfileImageEntity[i];
    }
}
