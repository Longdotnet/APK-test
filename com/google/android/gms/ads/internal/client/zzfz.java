package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzfz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfz> CREATOR = new com.google.android.gms.appset.zzb(16);
    public final String zza;

    public zzfz(String str) {
        this.zza = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 15, this.zza, false);
        CloseableKt.zzb(parcel, iZza);
    }
}
