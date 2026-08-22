package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.BitmapTeleporter;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzc implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        String strCreateString = null;
        Long longObject = null;
        BitmapTeleporter bitmapTeleporter = null;
        Uri uri = null;
        Long longObject2 = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                strCreateString = Protocol.Companion.createString(parcel, i);
            } else if (c == 2) {
                longObject = Protocol.Companion.readLongObject(parcel, i);
            } else if (c == 4) {
                uri = (Uri) Protocol.Companion.createParcelable(parcel, i, Uri.CREATOR);
            } else if (c == 5) {
                bitmapTeleporter = (BitmapTeleporter) Protocol.Companion.createParcelable(parcel, i, BitmapTeleporter.CREATOR);
            } else if (c != 6) {
                Protocol.Companion.skipUnknownField(parcel, i);
            } else {
                longObject2 = Protocol.Companion.readLongObject(parcel, i);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new SnapshotMetadataChangeEntity(strCreateString, longObject, bitmapTeleporter, uri, longObject2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new SnapshotMetadataChangeEntity[i];
    }
}
