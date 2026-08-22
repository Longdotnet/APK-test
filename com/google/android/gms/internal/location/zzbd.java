package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzbd implements Parcelable.Creator<zzbc> {
    @Override // android.os.Parcelable.Creator
    public final zzbc createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        int i = 1;
        zzba zzbaVar = null;
        IBinder iBinder = null;
        PendingIntent pendingIntent = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i2 = parcel.readInt();
            switch ((char) i2) {
                case 1:
                    i = Protocol.Companion.readInt(parcel, i2);
                    break;
                case 2:
                    zzbaVar = (zzba) Protocol.Companion.createParcelable(parcel, i2, zzba.CREATOR);
                    break;
                case 3:
                    iBinder = Protocol.Companion.readIBinder(parcel, i2);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) Protocol.Companion.createParcelable(parcel, i2, PendingIntent.CREATOR);
                    break;
                case 5:
                    iBinder2 = Protocol.Companion.readIBinder(parcel, i2);
                    break;
                case 6:
                    iBinder3 = Protocol.Companion.readIBinder(parcel, i2);
                    break;
                default:
                    Protocol.Companion.skipUnknownField(parcel, i2);
                    break;
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzbc(i, zzbaVar, iBinder, pendingIntent, iBinder2, iBinder3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzbc[] newArray(int i) {
        return new zzbc[i];
    }
}
