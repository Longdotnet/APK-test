package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzsg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzsg> CREATOR = new zzsh();
    private final zzaal zza;

    public zzsg(zzaal zzaalVar) {
        this.zza = zzaalVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeParcelable(parcel, 1, this.zza, i, false);
        CloseableKt.zzb(parcel, iZza);
    }

    public final zzaal zza() {
        return this.zza;
    }
}
