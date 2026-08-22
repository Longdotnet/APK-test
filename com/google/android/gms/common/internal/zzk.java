package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzk> CREATOR = new com.google.android.gms.drive.zza(9);
    public Bundle zza;
    public Feature[] zzb;
    public int zzc;
    public ConnectionTelemetryConfiguration zzd;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeBundle(parcel, 1, this.zza, false);
        CloseableKt.writeTypedArray(parcel, 2, this.zzb, i);
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(this.zzc);
        CloseableKt.writeParcelable(parcel, 4, this.zzd, i, false);
        CloseableKt.zzb(parcel, iZza);
    }
}
