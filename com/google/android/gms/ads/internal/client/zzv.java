package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzv> CREATOR = new com.google.android.gms.appset.zzb(21);
    public final String zza;
    public long zzb;
    public zze zzc;
    public final Bundle zzd;
    public final String zze;
    public final String zzf;
    public final String zzg;
    public final String zzh;

    public zzv(String str, long j, zze zzeVar, Bundle bundle, String str2, String str3, String str4, String str5) {
        this.zza = str;
        this.zzb = j;
        this.zzc = zzeVar;
        this.zzd = bundle;
        this.zze = str2;
        this.zzf = str3;
        this.zzg = str4;
        this.zzh = str5;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, this.zza, false);
        long j = this.zzb;
        CloseableKt.zzc(parcel, 2, 8);
        parcel.writeLong(j);
        CloseableKt.writeParcelable(parcel, 3, this.zzc, i, false);
        CloseableKt.writeBundle(parcel, 4, this.zzd, false);
        CloseableKt.writeString(parcel, 5, this.zze, false);
        CloseableKt.writeString(parcel, 6, this.zzf, false);
        CloseableKt.writeString(parcel, 7, this.zzg, false);
        CloseableKt.writeString(parcel, 8, this.zzh, false);
        CloseableKt.zzb(parcel, iZza);
    }
}
