package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.firebase.auth.ActionCodeSettings;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzsc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzsc> CREATOR = new zzsd();
    private final String zza;
    private final ActionCodeSettings zzb;

    public zzsc(String str, ActionCodeSettings actionCodeSettings) {
        this.zza = str;
        this.zzb = actionCodeSettings;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, this.zza, false);
        CloseableKt.writeParcelable(parcel, 2, this.zzb, i, false);
        CloseableKt.zzb(parcel, iZza);
    }

    public final ActionCodeSettings zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zza;
    }
}
