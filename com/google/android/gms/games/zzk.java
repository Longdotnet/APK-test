package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

/* JADX INFO: loaded from: classes.dex */
final class zzk extends zzl {
    @Override // com.google.android.gms.games.zzl, android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final PlayerEntity createFromParcel(Parcel parcel) {
        Parcelable.Creator<PlayerEntity> creator = PlayerEntity.CREATOR;
        if (GamesDowngradeableSafeParcel.zzp(DowngradeableSafeParcel.getUnparcelClientVersion()) || DowngradeableSafeParcel.canUnparcelSafely(PlayerEntity.class.getCanonicalName())) {
            return super.createFromParcel(parcel);
        }
        String string = parcel.readString();
        String string2 = parcel.readString();
        String string3 = parcel.readString();
        String string4 = parcel.readString();
        return new PlayerEntity(string, string2, string3 == null ? null : Uri.parse(string3), string4 == null ? null : Uri.parse(string4), parcel.readLong(), -1, -1L, null, null, null, null, null, true, false, parcel.readString(), parcel.readString(), null, null, null, null, -1L, null, null, false, null);
    }
}
