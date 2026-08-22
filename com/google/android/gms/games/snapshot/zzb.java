package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzb implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        SnapshotMetadataEntity snapshotMetadataEntity = null;
        SnapshotContentsEntity snapshotContentsEntity = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                snapshotMetadataEntity = (SnapshotMetadataEntity) Protocol.Companion.createParcelable(parcel, i, SnapshotMetadataEntity.CREATOR);
            } else if (c != 3) {
                Protocol.Companion.skipUnknownField(parcel, i);
            } else {
                snapshotContentsEntity = (SnapshotContentsEntity) Protocol.Companion.createParcelable(parcel, i, SnapshotContentsEntity.CREATOR);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new SnapshotEntity(snapshotMetadataEntity, snapshotContentsEntity);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new SnapshotEntity[i];
    }
}
