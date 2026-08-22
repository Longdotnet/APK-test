package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzbbm implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        long j = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 2) {
                parcelFileDescriptor = (ParcelFileDescriptor) Protocol.Companion.createParcelable(parcel, i, ParcelFileDescriptor.CREATOR);
            } else if (c == 3) {
                z = Protocol.Companion.readBoolean(parcel, i);
            } else if (c == 4) {
                z2 = Protocol.Companion.readBoolean(parcel, i);
            } else if (c == 5) {
                j = Protocol.Companion.readLong(parcel, i);
            } else if (c != 6) {
                Protocol.Companion.skipUnknownField(parcel, i);
            } else {
                z3 = Protocol.Companion.readBoolean(parcel, i);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzbbl(parcelFileDescriptor, z, z2, j, z3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbbl[i];
    }
}
