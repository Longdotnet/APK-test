package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public class zzb implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new ParticipantEntity[i];
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public ParticipantEntity createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        while (parcel.dataPosition() < iValidateObjectHeader) {
            Protocol.Companion.skipUnknownField(parcel, parcel.readInt());
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new ParticipantEntity();
    }
}
