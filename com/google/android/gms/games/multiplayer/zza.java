package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

/* JADX INFO: loaded from: classes.dex */
final class zza extends zzb {
    @Override // com.google.android.gms.games.multiplayer.zzb, android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zza */
    public final ParticipantEntity createFromParcel(Parcel parcel) {
        Parcelable.Creator<ParticipantEntity> creator = ParticipantEntity.CREATOR;
        return (GamesDowngradeableSafeParcel.zzp(DowngradeableSafeParcel.getUnparcelClientVersion()) || DowngradeableSafeParcel.canUnparcelSafely(ParticipantEntity.class.getCanonicalName())) ? super.createFromParcel(parcel) : new ParticipantEntity();
    }
}
