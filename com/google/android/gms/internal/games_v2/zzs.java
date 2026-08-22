package com.google.android.gms.internal.games_v2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzs> CREATOR = new zzt();
    private final String zza;

    public zzs(String str) {
        this.zza = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzs) {
            return com.google.android.gms.common.internal.zzah.equal(this.zza, ((zzs) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza});
    }

    public final String toString() {
        com.google.firebase.auth.zzz zzzVar = new com.google.firebase.auth.zzz(this);
        zzzVar.add(this.zza, "gameRunToken");
        return zzzVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.zza;
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, str, false);
        CloseableKt.zzb(parcel, iZza);
    }

    public final String zza() {
        return this.zza;
    }
}
