package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new zzr(0);
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final String zzd;
    public final long zze;
    public final long zzf;
    public final String zzg;
    public final boolean zzh;
    public final boolean zzi;
    public final long zzj;
    public final String zzk;
    public final long zzl;
    public final long zzm;
    public final int zzn;
    public final boolean zzo;
    public final boolean zzp;
    public final String zzq;
    public final Boolean zzr;
    public final long zzs;
    public final List zzt;
    public final String zzu;
    public final String zzv;
    public final String zzw;
    public final String zzx;

    public zzq(String str, String str2, String str3, long j, String str4, long j2, long j3, String str5, boolean z, boolean z2, String str6, long j4, int i, boolean z3, boolean z4, String str7, Boolean bool, long j5, List list, String str8, String str9, String str10) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        this.zza = str;
        this.zzb = true != TextUtils.isEmpty(str2) ? str2 : null;
        this.zzc = str3;
        this.zzj = j;
        this.zzd = str4;
        this.zze = j2;
        this.zzf = j3;
        this.zzg = str5;
        this.zzh = z;
        this.zzi = z2;
        this.zzk = str6;
        this.zzl = 0L;
        this.zzm = j4;
        this.zzn = i;
        this.zzo = z3;
        this.zzp = z4;
        this.zzq = str7;
        this.zzr = bool;
        this.zzs = j5;
        this.zzt = list;
        this.zzu = null;
        this.zzv = str8;
        this.zzw = str9;
        this.zzx = str10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 2, this.zza, false);
        CloseableKt.writeString(parcel, 3, this.zzb, false);
        CloseableKt.writeString(parcel, 4, this.zzc, false);
        CloseableKt.writeString(parcel, 5, this.zzd, false);
        CloseableKt.zzc(parcel, 6, 8);
        parcel.writeLong(this.zze);
        CloseableKt.zzc(parcel, 7, 8);
        parcel.writeLong(this.zzf);
        CloseableKt.writeString(parcel, 8, this.zzg, false);
        CloseableKt.zzc(parcel, 9, 4);
        parcel.writeInt(this.zzh ? 1 : 0);
        CloseableKt.zzc(parcel, 10, 4);
        parcel.writeInt(this.zzi ? 1 : 0);
        CloseableKt.zzc(parcel, 11, 8);
        parcel.writeLong(this.zzj);
        CloseableKt.writeString(parcel, 12, this.zzk, false);
        CloseableKt.zzc(parcel, 13, 8);
        parcel.writeLong(this.zzl);
        CloseableKt.zzc(parcel, 14, 8);
        parcel.writeLong(this.zzm);
        CloseableKt.zzc(parcel, 15, 4);
        parcel.writeInt(this.zzn);
        CloseableKt.zzc(parcel, 16, 4);
        parcel.writeInt(this.zzo ? 1 : 0);
        CloseableKt.zzc(parcel, 18, 4);
        parcel.writeInt(this.zzp ? 1 : 0);
        CloseableKt.writeString(parcel, 19, this.zzq, false);
        CloseableKt.writeBooleanObject(parcel, 21, this.zzr);
        CloseableKt.zzc(parcel, 22, 8);
        parcel.writeLong(this.zzs);
        CloseableKt.writeStringList(parcel, 23, this.zzt);
        CloseableKt.writeString(parcel, 24, this.zzu, false);
        CloseableKt.writeString(parcel, 25, this.zzv, false);
        CloseableKt.writeString(parcel, 26, this.zzw, false);
        CloseableKt.writeString(parcel, 27, this.zzx, false);
        CloseableKt.zzb(parcel, iZza);
    }

    public zzq(String str, String str2, String str3, String str4, long j, long j2, String str5, boolean z, boolean z2, long j3, String str6, long j4, long j5, int i, boolean z3, boolean z4, String str7, Boolean bool, long j6, ArrayList arrayList, String str8, String str9, String str10, String str11) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzj = j3;
        this.zzd = str4;
        this.zze = j;
        this.zzf = j2;
        this.zzg = str5;
        this.zzh = z;
        this.zzi = z2;
        this.zzk = str6;
        this.zzl = j4;
        this.zzm = j5;
        this.zzn = i;
        this.zzo = z3;
        this.zzp = z4;
        this.zzq = str7;
        this.zzr = bool;
        this.zzs = j6;
        this.zzt = arrayList;
        this.zzu = str8;
        this.zzv = str9;
        this.zzw = str10;
        this.zzx = str11;
    }
}
