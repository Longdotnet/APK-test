package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzrw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzrw> CREATOR = new zzrx();
    private final String zza;
    private final zzaay zzb;

    public zzrw(String str, zzaay zzaayVar) {
        this.zza = str;
        this.zzb = zzaayVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, this.zza, false);
        CloseableKt.writeParcelable(parcel, 2, this.zzb, i, false);
        CloseableKt.zzb(parcel, iZza);
    }

    public final zzaay zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zza;
    }
}
