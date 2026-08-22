package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.location.zzl;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzd> CREATOR = new zzl(12);
    public final long zzf;
    public final HarmfulAppsData[] zzg;
    public final int zzh;
    public final boolean zzi;

    public zzd(long j, HarmfulAppsData[] harmfulAppsDataArr, int i, boolean z) {
        this.zzf = j;
        this.zzg = harmfulAppsDataArr;
        this.zzi = z;
        if (z) {
            this.zzh = i;
        } else {
            this.zzh = -1;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 2, 8);
        parcel.writeLong(this.zzf);
        CloseableKt.writeTypedArray(parcel, 3, this.zzg, i);
        CloseableKt.zzc(parcel, 4, 4);
        parcel.writeInt(this.zzh);
        CloseableKt.zzc(parcel, 5, 4);
        parcel.writeInt(this.zzi ? 1 : 0);
        CloseableKt.zzb(parcel, iZza);
    }
}
