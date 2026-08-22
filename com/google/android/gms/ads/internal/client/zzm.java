package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.work.WorkContinuation;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzah;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.io.CloseableKt;
import okhttp3.internal.concurrent.onZL.mnwSv;

/* JADX INFO: loaded from: classes2.dex */
public final class zzm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzm> CREATOR = new com.google.android.gms.appset.zzb(18);
    public final long zzA;
    public final int zza;
    public final long zzb;
    public final Bundle zzc;
    public final int zzd;
    public final List zze;
    public final boolean zzf;
    public final int zzg;
    public final boolean zzh;
    public final String zzi;
    public final zzfz zzj;
    public final Location zzk;
    public final String zzl;
    public final Bundle zzm;
    public final Bundle zzn;
    public final List zzo;
    public final String zzp;
    public final String zzq;
    public final boolean zzr;
    public final zzc zzs;
    public final int zzt;
    public final String zzu;
    public final List zzv;
    public final int zzw;
    public final String zzx;
    public final int zzy;
    public final long zzz;

    public zzm(int i, long j, Bundle bundle, int i2, List list, boolean z, int i3, boolean z2, String str, zzfz zzfzVar, Location location, String str2, Bundle bundle2, Bundle bundle3, List list2, String str3, String str4, boolean z3, zzc zzcVar, int i4, String str5, List list3, int i5, String str6, int i6, long j2, long j3) {
        this.zza = i;
        this.zzb = j;
        this.zzc = bundle == null ? new Bundle() : bundle;
        this.zzd = i2;
        this.zze = list;
        this.zzf = z;
        this.zzg = i3;
        this.zzh = z2;
        this.zzi = str;
        this.zzj = zzfzVar;
        this.zzk = location;
        this.zzl = str2;
        this.zzm = bundle2 == null ? new Bundle() : bundle2;
        this.zzn = bundle3;
        this.zzo = list2;
        this.zzp = str3;
        this.zzq = str4;
        this.zzr = z3;
        this.zzs = zzcVar;
        this.zzt = i4;
        this.zzu = str5;
        this.zzv = list3 == null ? new ArrayList() : list3;
        this.zzw = i5;
        this.zzx = str6;
        this.zzy = i6;
        this.zzz = j2;
        this.zzA = j3;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzm) {
            return zza(obj) && this.zzz == ((zzm) obj).zzz;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zza), Long.valueOf(this.zzb), this.zzc, Integer.valueOf(this.zzd), this.zze, Boolean.valueOf(this.zzf), Integer.valueOf(this.zzg), Boolean.valueOf(this.zzh), this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzo, this.zzp, this.zzq, Boolean.valueOf(this.zzr), Integer.valueOf(this.zzt), this.zzu, this.zzv, Integer.valueOf(this.zzw), this.zzx, Integer.valueOf(this.zzy), Long.valueOf(this.zzz), Long.valueOf(this.zzA)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(this.zza);
        CloseableKt.zzc(parcel, 2, 8);
        parcel.writeLong(this.zzb);
        CloseableKt.writeBundle(parcel, 3, this.zzc, false);
        CloseableKt.zzc(parcel, 4, 4);
        parcel.writeInt(this.zzd);
        CloseableKt.writeStringList(parcel, 5, this.zze);
        CloseableKt.zzc(parcel, 6, 4);
        parcel.writeInt(this.zzf ? 1 : 0);
        CloseableKt.zzc(parcel, 7, 4);
        parcel.writeInt(this.zzg);
        CloseableKt.zzc(parcel, 8, 4);
        parcel.writeInt(this.zzh ? 1 : 0);
        CloseableKt.writeString(parcel, 9, this.zzi, false);
        CloseableKt.writeParcelable(parcel, 10, this.zzj, i, false);
        CloseableKt.writeParcelable(parcel, 11, this.zzk, i, false);
        CloseableKt.writeString(parcel, 12, this.zzl, false);
        CloseableKt.writeBundle(parcel, 13, this.zzm, false);
        CloseableKt.writeBundle(parcel, 14, this.zzn, false);
        CloseableKt.writeStringList(parcel, 15, this.zzo);
        CloseableKt.writeString(parcel, 16, this.zzp, false);
        CloseableKt.writeString(parcel, 17, this.zzq, false);
        CloseableKt.zzc(parcel, 18, 4);
        parcel.writeInt(this.zzr ? 1 : 0);
        CloseableKt.writeParcelable(parcel, 19, this.zzs, i, false);
        CloseableKt.zzc(parcel, 20, 4);
        parcel.writeInt(this.zzt);
        CloseableKt.writeString(parcel, 21, this.zzu, false);
        CloseableKt.writeStringList(parcel, 22, this.zzv);
        CloseableKt.zzc(parcel, 23, 4);
        parcel.writeInt(this.zzw);
        CloseableKt.writeString(parcel, 24, this.zzx, false);
        CloseableKt.zzc(parcel, 25, 4);
        parcel.writeInt(this.zzy);
        CloseableKt.zzc(parcel, 26, 8);
        parcel.writeLong(this.zzz);
        CloseableKt.zzc(parcel, 27, 8);
        parcel.writeLong(this.zzA);
        CloseableKt.zzb(parcel, iZza);
    }

    public final boolean zza(Object obj) {
        if (!(obj instanceof zzm)) {
            return false;
        }
        zzm zzmVar = (zzm) obj;
        return this.zza == zzmVar.zza && this.zzb == zzmVar.zzb && WorkContinuation.zza(this.zzc, zzmVar.zzc) && this.zzd == zzmVar.zzd && zzah.equal(this.zze, zzmVar.zze) && this.zzf == zzmVar.zzf && this.zzg == zzmVar.zzg && this.zzh == zzmVar.zzh && zzah.equal(this.zzi, zzmVar.zzi) && zzah.equal(this.zzj, zzmVar.zzj) && zzah.equal(this.zzk, zzmVar.zzk) && zzah.equal(this.zzl, zzmVar.zzl) && WorkContinuation.zza(this.zzm, zzmVar.zzm) && WorkContinuation.zza(this.zzn, zzmVar.zzn) && zzah.equal(this.zzo, zzmVar.zzo) && zzah.equal(this.zzp, zzmVar.zzp) && zzah.equal(this.zzq, zzmVar.zzq) && this.zzr == zzmVar.zzr && this.zzt == zzmVar.zzt && zzah.equal(this.zzu, zzmVar.zzu) && zzah.equal(this.zzv, zzmVar.zzv) && this.zzw == zzmVar.zzw && zzah.equal(this.zzx, zzmVar.zzx) && this.zzy == zzmVar.zzy;
    }

    public final boolean zzb() {
        String str = mnwSv.tczriVQVslA;
        Bundle bundle = this.zzc;
        return bundle.getBoolean(str, false) || bundle.getBoolean("zenith_v2", false);
    }
}
