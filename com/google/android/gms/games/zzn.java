package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzn implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        PlayerLevel playerLevel = null;
        PlayerLevel playerLevel2 = null;
        long j = 0;
        long j2 = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                j = Protocol.Companion.readLong(parcel, i);
            } else if (c == 2) {
                j2 = Protocol.Companion.readLong(parcel, i);
            } else if (c == 3) {
                playerLevel = (PlayerLevel) Protocol.Companion.createParcelable(parcel, i, PlayerLevel.CREATOR);
            } else if (c != 4) {
                Protocol.Companion.skipUnknownField(parcel, i);
            } else {
                playerLevel2 = (PlayerLevel) Protocol.Companion.createParcelable(parcel, i, PlayerLevel.CREATOR);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new PlayerLevelInfo(j, j2, playerLevel, playerLevel2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new PlayerLevelInfo[i];
    }
}
