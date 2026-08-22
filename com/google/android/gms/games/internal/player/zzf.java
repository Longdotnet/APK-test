package com.google.android.gms.games.internal.player;

import android.os.Parcel;
import android.os.Parcelable;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzf implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    z = Protocol.Companion.readBoolean(parcel, i);
                    break;
                case 2:
                    z2 = Protocol.Companion.readBoolean(parcel, i);
                    break;
                case 3:
                    z3 = Protocol.Companion.readBoolean(parcel, i);
                    break;
                case 4:
                    z4 = Protocol.Companion.readBoolean(parcel, i);
                    break;
                case 5:
                    z5 = Protocol.Companion.readBoolean(parcel, i);
                    break;
                case 6:
                    z6 = Protocol.Companion.readBoolean(parcel, i);
                    break;
                case 7:
                    z7 = Protocol.Companion.readBoolean(parcel, i);
                    break;
                case '\b':
                    z8 = Protocol.Companion.readBoolean(parcel, i);
                    break;
                case '\t':
                    z9 = Protocol.Companion.readBoolean(parcel, i);
                    break;
                case '\n':
                    z10 = Protocol.Companion.readBoolean(parcel, i);
                    break;
                default:
                    Protocol.Companion.skipUnknownField(parcel, i);
                    break;
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zze(z, z2, z3, z4, z5, z6, z7, z8, z9, z10);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zze[i];
    }
}
