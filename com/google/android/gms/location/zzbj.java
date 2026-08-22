package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzbj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbj> CREATOR = new com.google.android.gms.drive.zza(29);
    public final String zza;
    public final String zzb;
    public final String zzc;

    public zzbj(String str, String str2, String str3) {
        this.zzc = str;
        this.zza = str2;
        this.zzb = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, this.zza, false);
        CloseableKt.writeString(parcel, 2, this.zzb, false);
        CloseableKt.writeString(parcel, 5, this.zzc, false);
        CloseableKt.zzb(parcel, iZza);
    }
}
