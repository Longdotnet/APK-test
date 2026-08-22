package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.io.CloseableKt;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzp implements Parcelable.Creator {
    public static void zza(zzo zzoVar, Parcel parcel) {
        int iZza = CloseableKt.zza(parcel, 20293);
        int friendStatus = zzoVar.getFriendStatus();
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(friendStatus);
        CloseableKt.writeString(parcel, 2, zzoVar.zza(), false);
        CloseableKt.writeString(parcel, 3, zzoVar.zzb(), false);
        CloseableKt.writeString(parcel, 4, zzoVar.zzc(), false);
        CloseableKt.zzb(parcel, iZza);
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        String strCreateString = null;
        String strCreateString2 = null;
        int i = 0;
        String strCreateString3 = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i2 = parcel.readInt();
            char c = (char) i2;
            if (c == 1) {
                i = Protocol.Companion.readInt(parcel, i2);
            } else if (c == 2) {
                strCreateString = Protocol.Companion.createString(parcel, i2);
            } else if (c == 3) {
                strCreateString3 = Protocol.Companion.createString(parcel, i2);
            } else if (c != 4) {
                Protocol.Companion.skipUnknownField(parcel, i2);
            } else {
                strCreateString2 = Protocol.Companion.createString(parcel, i2);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzo(i, strCreateString, strCreateString3, strCreateString2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzo[i];
    }
}
