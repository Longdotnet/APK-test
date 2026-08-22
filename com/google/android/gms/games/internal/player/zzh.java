package com.google.android.gms.games.internal.player;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzah;
import java.util.Arrays;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzh extends com.google.android.gms.games.internal.zzg {
    public static final Parcelable.Creator<zzh> CREATOR = new zzi();
    public final String zza;

    public zzh(String str) {
        this.zza = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzh)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return zzah.equal(this.zza, ((zzh) obj).zza);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, this.zza, false);
        CloseableKt.zzb(parcel, iZza);
    }
}
