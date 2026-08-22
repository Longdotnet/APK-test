package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzbmp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbmp> CREATOR = new zzbmq();
    public final int zza;
    public final int zzb;
    public final String zzc;
    public final int zzd;

    public zzbmp(int i, int i2, String str, int i3) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = str;
        this.zzd = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zzb;
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(i2);
        CloseableKt.writeString(parcel, 2, this.zzc, false);
        int i3 = this.zzd;
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(i3);
        int i4 = this.zza;
        CloseableKt.zzc(parcel, 1000, 4);
        parcel.writeInt(i4);
        CloseableKt.zzb(parcel, iZza);
    }
}
