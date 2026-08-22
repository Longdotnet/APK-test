package com.google.android.gms.internal.games_v2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzam extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzam> CREATOR = new zzan();

    @Deprecated
    private final String zza;
    private final String zzb;

    public zzam(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzam)) {
            return false;
        }
        zzam zzamVar = (zzam) obj;
        return com.google.android.gms.common.internal.zzah.equal(this.zza, zzamVar.zza) && com.google.android.gms.common.internal.zzah.equal(this.zzb, zzamVar.zzb);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        com.google.firebase.auth.zzz zzzVar = new com.google.firebase.auth.zzz(this);
        zzzVar.add(this.zza, "serverAuthCode");
        zzzVar.add(this.zzb, "sessionId");
        return zzzVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.zza;
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, str, false);
        CloseableKt.writeString(parcel, 2, this.zzb, false);
        CloseableKt.zzb(parcel, iZza);
    }

    public final String zza() {
        return this.zzb;
    }
}
