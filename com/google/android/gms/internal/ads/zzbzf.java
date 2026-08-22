package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzbzf implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        String strCreateString = null;
        String strCreateString2 = null;
        com.google.android.gms.ads.internal.client.zzr zzrVar = null;
        com.google.android.gms.ads.internal.client.zzm zzmVar = null;
        String strCreateString3 = null;
        int i = 0;
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
                    zzrVar = (com.google.android.gms.ads.internal.client.zzr) Protocol.Companion.createParcelable(parcel, i2, com.google.android.gms.ads.internal.client.zzr.CREATOR);
                    break;
                case 4:
                    zzmVar = (com.google.android.gms.ads.internal.client.zzm) Protocol.Companion.createParcelable(parcel, i2, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    break;
                case 5:
                    i = Protocol.Companion.readInt(parcel, i2);
                    break;
                case 6:
                    strCreateString3 = Protocol.Companion.createString(parcel, i2);
                    break;
                default:
                    Protocol.Companion.skipUnknownField(parcel, i2);
                    break;
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzbze(strCreateString, strCreateString2, zzrVar, zzmVar, i, strCreateString3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbze[i];
    }
}
