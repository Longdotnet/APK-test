package com.google.android.gms.internal.location;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzm implements Parcelable.Creator<zzl> {
    @Override // android.os.Parcelable.Creator
    public final zzl createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        zzj zzjVar = null;
        int i = 1;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i2 = parcel.readInt();
            char c = (char) i2;
            if (c == 1) {
                i = Protocol.Companion.readInt(parcel, i2);
            } else if (c == 2) {
                zzjVar = (zzj) Protocol.Companion.createParcelable(parcel, i2, zzj.CREATOR);
            } else if (c == 3) {
                iBinder = Protocol.Companion.readIBinder(parcel, i2);
            } else if (c != 4) {
                Protocol.Companion.skipUnknownField(parcel, i2);
            } else {
                iBinder2 = Protocol.Companion.readIBinder(parcel, i2);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzl(i, zzjVar, iBinder, iBinder2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzl[] newArray(int i) {
        return new zzl[i];
    }
}
