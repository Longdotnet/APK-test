package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class RoomEntity extends GamesDowngradeableSafeParcel {
    public static final Parcelable.Creator<RoomEntity> CREATOR = new zzc();

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        if (!shouldDowngrade()) {
            CloseableKt.zzb(parcel, CloseableKt.zza(parcel, 20293));
            return;
        }
        parcel.writeString("unsupported");
        parcel.writeString("unsupported");
        parcel.writeLong(0L);
        parcel.writeInt(0);
        parcel.writeString("unsupported");
        parcel.writeInt(-1);
        parcel.writeBundle(null);
        parcel.writeInt(0);
    }
}
