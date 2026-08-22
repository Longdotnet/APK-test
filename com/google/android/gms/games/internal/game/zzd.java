package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzd implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        int i = 0;
        Uri uri = null;
        int i2 = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i3 = parcel.readInt();
            char c = (char) i3;
            if (c == 1) {
                uri = (Uri) Protocol.Companion.createParcelable(parcel, i3, Uri.CREATOR);
            } else if (c == 2) {
                i = Protocol.Companion.readInt(parcel, i3);
            } else if (c != 3) {
                Protocol.Companion.skipUnknownField(parcel, i3);
            } else {
                i2 = Protocol.Companion.readInt(parcel, i3);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new ScreenshotEntity(uri, i, i2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new ScreenshotEntity[i];
    }
}
