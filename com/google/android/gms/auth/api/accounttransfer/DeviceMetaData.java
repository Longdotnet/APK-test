package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.zza;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class DeviceMetaData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DeviceMetaData> CREATOR = new zza(5);
    public final int zza;
    public final boolean zzb;
    public final long zzc;
    public final boolean zzd;

    public DeviceMetaData(int i, boolean z, long j, boolean z2) {
        this.zza = i;
        this.zzb = z;
        this.zzc = j;
        this.zzd = z2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(this.zza);
        CloseableKt.zzc(parcel, 2, 4);
        parcel.writeInt(this.zzb ? 1 : 0);
        CloseableKt.zzc(parcel, 3, 8);
        parcel.writeLong(this.zzc);
        CloseableKt.zzc(parcel, 4, 4);
        parcel.writeInt(this.zzd ? 1 : 0);
        CloseableKt.zzb(parcel, iZza);
    }
}
