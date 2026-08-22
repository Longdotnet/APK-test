package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.drive.zza;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new zza(22);
    public final boolean zza;
    public final String zzb;
    public final int zzc;
    public final int zzd;

    public zzq(boolean z, String str, int i, int i2) {
        this.zza = z;
        this.zzb = str;
        this.zzc = RangesKt.zza(i) - 1;
        this.zzd = JvmClassMappingKt.zza(i2) - 1;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(this.zza ? 1 : 0);
        CloseableKt.writeString(parcel, 2, this.zzb, false);
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(this.zzc);
        CloseableKt.zzc(parcel, 4, 4);
        parcel.writeInt(this.zzd);
        CloseableKt.zzb(parcel, iZza);
    }
}
