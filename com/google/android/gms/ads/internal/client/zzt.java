package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzt> CREATOR = new com.google.android.gms.appset.zzb(20);
    public final int zza;
    public final int zzb;
    public final String zzc;
    public final long zzd;

    public zzt(int i, int i2, long j, String str) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = str;
        this.zzd = j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(this.zza);
        CloseableKt.zzc(parcel, 2, 4);
        parcel.writeInt(this.zzb);
        CloseableKt.writeString(parcel, 3, this.zzc, false);
        CloseableKt.zzc(parcel, 4, 8);
        parcel.writeLong(this.zzd);
        CloseableKt.zzb(parcel, iZza);
    }
}
