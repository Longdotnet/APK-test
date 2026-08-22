package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzfx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfx> CREATOR = new com.google.android.gms.appset.zzb(15);
    public final int zza;
    public final int zzb;

    public zzfx(int i, int i2) {
        this.zza = i;
        this.zzb = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(this.zza);
        CloseableKt.zzc(parcel, 2, 4);
        parcel.writeInt(this.zzb);
        CloseableKt.zzb(parcel, iZza);
    }

    public zzfx(RequestConfiguration requestConfiguration) {
        this.zza = requestConfiguration.zzb;
        this.zzb = requestConfiguration.zzc;
    }
}
