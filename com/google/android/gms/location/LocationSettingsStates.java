package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class LocationSettingsStates extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LocationSettingsStates> CREATOR = new zzl(3);
    public final boolean zza;
    public final boolean zzb;
    public final boolean zzc;
    public final boolean zzd;
    public final boolean zze;
    public final boolean zzf;

    public LocationSettingsStates(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.zza = z;
        this.zzb = z2;
        this.zzc = z3;
        this.zzd = z4;
        this.zze = z5;
        this.zzf = z6;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(this.zza ? 1 : 0);
        CloseableKt.zzc(parcel, 2, 4);
        parcel.writeInt(this.zzb ? 1 : 0);
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(this.zzc ? 1 : 0);
        CloseableKt.zzc(parcel, 4, 4);
        parcel.writeInt(this.zzd ? 1 : 0);
        CloseableKt.zzc(parcel, 5, 4);
        parcel.writeInt(this.zze ? 1 : 0);
        CloseableKt.zzc(parcel, 6, 4);
        parcel.writeInt(this.zzf ? 1 : 0);
        CloseableKt.zzb(parcel, iZza);
    }
}
