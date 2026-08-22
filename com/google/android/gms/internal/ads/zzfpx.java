package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzfpx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfpx> CREATOR = new zzfpy();
    public final int zza;
    public final int zzb;
    public final String zzc;
    public final String zzd;
    public final int zze;

    public zzfpx(int i, int i2, int i3, String str, String str2) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = str;
        this.zzd = str2;
        this.zze = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(i2);
        int i3 = this.zzb;
        CloseableKt.zzc(parcel, 2, 4);
        parcel.writeInt(i3);
        CloseableKt.writeString(parcel, 3, this.zzc, false);
        CloseableKt.writeString(parcel, 4, this.zzd, false);
        int i4 = this.zze;
        CloseableKt.zzc(parcel, 5, 4);
        parcel.writeInt(i4);
        CloseableKt.zzb(parcel, iZza);
    }

    public zzfpx(int i, int i2, String str, String str2) {
        this(1, 1, i2 - 1, str, str2);
    }
}
