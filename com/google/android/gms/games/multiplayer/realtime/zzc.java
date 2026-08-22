package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

/* JADX INFO: loaded from: classes.dex */
final class zzc extends zzd {
    @Override // com.google.android.gms.games.multiplayer.realtime.zzd, android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zza */
    public final RoomEntity createFromParcel(Parcel parcel) {
        Parcelable.Creator<RoomEntity> creator = RoomEntity.CREATOR;
        return (GamesDowngradeableSafeParcel.zzp(DowngradeableSafeParcel.getUnparcelClientVersion()) || DowngradeableSafeParcel.canUnparcelSafely(RoomEntity.class.getCanonicalName())) ? super.createFromParcel(parcel) : new RoomEntity();
    }
}
