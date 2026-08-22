package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzcl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcl> CREATOR = new zzcm();
    public final long zza;
    public final long zzb;
    public final boolean zzc;
    public final String zzd;
    public final String zze;
    public final String zzf;
    public final Bundle zzg;
    public final String zzh;

    public zzcl(long j, long j2, boolean z, String str, String str2, String str3, Bundle bundle, String str4) {
        this.zza = j;
        this.zzb = j2;
        this.zzc = z;
        this.zzd = str;
        this.zze = str2;
        this.zzf = str3;
        this.zzg = bundle;
        this.zzh = str4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        long j = this.zza;
        CloseableKt.zzc(parcel, 1, 8);
        parcel.writeLong(j);
        long j2 = this.zzb;
        CloseableKt.zzc(parcel, 2, 8);
        parcel.writeLong(j2);
        boolean z = this.zzc;
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(z ? 1 : 0);
        CloseableKt.writeString(parcel, 4, this.zzd, false);
        CloseableKt.writeString(parcel, 5, this.zze, false);
        CloseableKt.writeString(parcel, 6, this.zzf, false);
        CloseableKt.writeBundle(parcel, 7, this.zzg, false);
        CloseableKt.writeString(parcel, 8, this.zzh, false);
        CloseableKt.zzb(parcel, iZza);
    }
}
