package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzbvq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbvq> CREATOR = new zzbvr();
    public final Bundle zza;
    public final VersionInfoParcel zzb;
    public final ApplicationInfo zzc;
    public final String zzd;
    public final List zze;
    public final PackageInfo zzf;
    public final String zzg;
    public final String zzh;
    public zzfeq zzi;
    public String zzj;
    public final boolean zzk;
    public final boolean zzl;
    public final Bundle zzm;
    public final Bundle zzn;
    public final int zzo;

    public zzbvq(Bundle bundle, VersionInfoParcel versionInfoParcel, ApplicationInfo applicationInfo, String str, List list, PackageInfo packageInfo, String str2, String str3, zzfeq zzfeqVar, String str4, boolean z, boolean z2, Bundle bundle2, Bundle bundle3, int i) {
        this.zza = bundle;
        this.zzb = versionInfoParcel;
        this.zzd = str;
        this.zzc = applicationInfo;
        this.zze = list;
        this.zzf = packageInfo;
        this.zzg = str2;
        this.zzh = str3;
        this.zzi = zzfeqVar;
        this.zzj = str4;
        this.zzk = z;
        this.zzl = z2;
        this.zzm = bundle2;
        this.zzn = bundle3;
        this.zzo = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = this.zza;
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeBundle(parcel, 1, bundle, false);
        CloseableKt.writeParcelable(parcel, 2, this.zzb, i, false);
        CloseableKt.writeParcelable(parcel, 3, this.zzc, i, false);
        CloseableKt.writeString(parcel, 4, this.zzd, false);
        CloseableKt.writeStringList(parcel, 5, this.zze);
        CloseableKt.writeParcelable(parcel, 6, this.zzf, i, false);
        CloseableKt.writeString(parcel, 7, this.zzg, false);
        CloseableKt.writeString(parcel, 9, this.zzh, false);
        CloseableKt.writeParcelable(parcel, 10, this.zzi, i, false);
        CloseableKt.writeString(parcel, 11, this.zzj, false);
        boolean z = this.zzk;
        CloseableKt.zzc(parcel, 12, 4);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = this.zzl;
        CloseableKt.zzc(parcel, 13, 4);
        parcel.writeInt(z2 ? 1 : 0);
        CloseableKt.writeBundle(parcel, 14, this.zzm, false);
        CloseableKt.writeBundle(parcel, 15, this.zzn, false);
        int i2 = this.zzo;
        CloseableKt.zzc(parcel, 16, 4);
        parcel.writeInt(i2);
        CloseableKt.zzb(parcel, iZza);
    }
}
