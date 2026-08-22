package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzbgf implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        int i = 0;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        boolean z3 = false;
        int i4 = 0;
        int i5 = 0;
        boolean z4 = false;
        int i6 = 0;
        com.google.android.gms.ads.internal.client.zzgc zzgcVar = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i7 = parcel.readInt();
            switch ((char) i7) {
                case 1:
                    i = Protocol.Companion.readInt(parcel, i7);
                    break;
                case 2:
                    z = Protocol.Companion.readBoolean(parcel, i7);
                    break;
                case 3:
                    i2 = Protocol.Companion.readInt(parcel, i7);
                    break;
                case 4:
                    z2 = Protocol.Companion.readBoolean(parcel, i7);
                    break;
                case 5:
                    i3 = Protocol.Companion.readInt(parcel, i7);
                    break;
                case 6:
                    zzgcVar = (com.google.android.gms.ads.internal.client.zzgc) Protocol.Companion.createParcelable(parcel, i7, com.google.android.gms.ads.internal.client.zzgc.CREATOR);
                    break;
                case 7:
                    z3 = Protocol.Companion.readBoolean(parcel, i7);
                    break;
                case '\b':
                    i4 = Protocol.Companion.readInt(parcel, i7);
                    break;
                case '\t':
                    i5 = Protocol.Companion.readInt(parcel, i7);
                    break;
                case '\n':
                    z4 = Protocol.Companion.readBoolean(parcel, i7);
                    break;
                case 11:
                    i6 = Protocol.Companion.readInt(parcel, i7);
                    break;
                default:
                    Protocol.Companion.skipUnknownField(parcel, i7);
                    break;
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzbge(i, z, i2, z2, i3, zzgcVar, z3, i4, i5, z4, i6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbge[i];
    }
}
