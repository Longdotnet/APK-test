package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

/* JADX INFO: loaded from: classes.dex */
final class zzb extends zzc {
    @Override // com.google.android.gms.games.internal.game.zzc, android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zza */
    public final GameBadgeEntity createFromParcel(Parcel parcel) {
        Parcelable.Creator<GameBadgeEntity> creator = GameBadgeEntity.CREATOR;
        if (GamesDowngradeableSafeParcel.zzp(DowngradeableSafeParcel.getUnparcelClientVersion()) || DowngradeableSafeParcel.canUnparcelSafely(GameBadgeEntity.class.getCanonicalName())) {
            return super.createFromParcel(parcel);
        }
        int i = parcel.readInt();
        String string = parcel.readString();
        String string2 = parcel.readString();
        String string3 = parcel.readString();
        return new GameBadgeEntity(i, string, string2, string3 == null ? null : Uri.parse(string3));
    }
}
