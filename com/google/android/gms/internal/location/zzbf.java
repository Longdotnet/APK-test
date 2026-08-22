package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzbf implements Parcelable.Creator<zzbe> {
    @Override // android.os.Parcelable.Creator
    public final zzbe createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        String strCreateString = null;
        int i = 0;
        short s = 0;
        int i2 = 0;
        double d = 0.0d;
        double d2 = 0.0d;
        float f = 0.0f;
        long j = 0;
        int i3 = -1;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i4 = parcel.readInt();
            switch ((char) i4) {
                case 1:
                    strCreateString = Protocol.Companion.createString(parcel, i4);
                    break;
                case 2:
                    j = Protocol.Companion.readLong(parcel, i4);
                    break;
                case 3:
                    Protocol.Companion.zzb(parcel, i4, 4);
                    s = (short) parcel.readInt();
                    break;
                case 4:
                    Protocol.Companion.zzb(parcel, i4, 8);
                    d = parcel.readDouble();
                    break;
                case 5:
                    Protocol.Companion.zzb(parcel, i4, 8);
                    d2 = parcel.readDouble();
                    break;
                case 6:
                    f = Protocol.Companion.readFloat(parcel, i4);
                    break;
                case 7:
                    i = Protocol.Companion.readInt(parcel, i4);
                    break;
                case '\b':
                    i2 = Protocol.Companion.readInt(parcel, i4);
                    break;
                case '\t':
                    i3 = Protocol.Companion.readInt(parcel, i4);
                    break;
                default:
                    Protocol.Companion.skipUnknownField(parcel, i4);
                    break;
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzbe(strCreateString, i, s, d, d2, f, j, i2, i3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzbe[] newArray(int i) {
        return new zzbe[i];
    }
}
