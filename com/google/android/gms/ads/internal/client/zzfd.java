package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzfd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfd> CREATOR = new com.google.android.gms.appset.zzb(13);
    public final int zza;
    public final int zzb;
    public final String zzc;

    public zzfd(int i, int i2, String str) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(this.zza);
        CloseableKt.zzc(parcel, 2, 4);
        parcel.writeInt(this.zzb);
        CloseableKt.writeString(parcel, 3, this.zzc, false);
        CloseableKt.zzb(parcel, iZza);
    }
}
