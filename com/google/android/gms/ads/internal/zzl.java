package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzl> CREATOR = new com.google.android.gms.appset.zzb(28);
    public final boolean zza;
    public final boolean zzb;
    public final String zzc;
    public final boolean zzd;
    public final float zze;
    public final int zzf;
    public final boolean zzg;
    public final boolean zzh;
    public final boolean zzi;

    public zzl(boolean z, boolean z2, String str, boolean z3, float f, int i, boolean z4, boolean z5, boolean z6) {
        this.zza = z;
        this.zzb = z2;
        this.zzc = str;
        this.zzd = z3;
        this.zze = f;
        this.zzf = i;
        this.zzg = z4;
        this.zzh = z5;
        this.zzi = z6;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 2, 4);
        parcel.writeInt(this.zza ? 1 : 0);
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(this.zzb ? 1 : 0);
        CloseableKt.writeString(parcel, 4, this.zzc, false);
        CloseableKt.zzc(parcel, 5, 4);
        parcel.writeInt(this.zzd ? 1 : 0);
        CloseableKt.zzc(parcel, 6, 4);
        parcel.writeFloat(this.zze);
        CloseableKt.zzc(parcel, 7, 4);
        parcel.writeInt(this.zzf);
        CloseableKt.zzc(parcel, 8, 4);
        parcel.writeInt(this.zzg ? 1 : 0);
        CloseableKt.zzc(parcel, 9, 4);
        parcel.writeInt(this.zzh ? 1 : 0);
        CloseableKt.zzc(parcel, 10, 4);
        parcel.writeInt(this.zzi ? 1 : 0);
        CloseableKt.zzb(parcel, iZza);
    }

    public zzl(boolean z, boolean z2, boolean z3, float f, boolean z4, boolean z5, boolean z6) {
        this(z, z2, null, z3, f, -1, z4, z5, z6);
    }
}
