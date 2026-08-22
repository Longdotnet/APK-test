package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzeh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzeh> CREATOR = new com.google.android.gms.appset.zzb(11);
    public final int zza;

    public zzeh(int i) {
        this.zza = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 2, 4);
        parcel.writeInt(this.zza);
        CloseableKt.zzb(parcel, iZza);
    }
}
