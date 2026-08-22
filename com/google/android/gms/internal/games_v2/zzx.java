package com.google.android.gms.internal.games_v2;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzx> CREATOR = new zzy();
    private final Intent zza;

    public zzx(Intent intent) {
        this.zza = intent;
    }

    public static zzx zza(Intent intent) {
        return new zzx(intent);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzx) {
            return com.google.android.gms.common.internal.zzah.equal(this.zza, ((zzx) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        Intent intent = this.zza;
        if (intent != null) {
            return intent.hashCode();
        }
        return 0;
    }

    public final String toString() {
        com.google.firebase.auth.zzz zzzVar = new com.google.firebase.auth.zzz(this);
        zzzVar.add(this.zza, "resultData");
        return zzzVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        Intent intent = this.zza;
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeParcelable(parcel, 1, intent, i, false);
        CloseableKt.zzb(parcel, iZza);
    }
}
