package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzsy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzsy> CREATOR = new zzsz();
    private final PhoneMultiFactorInfo zza;
    private final String zzb;
    private final String zzc;
    private final long zzd;
    private final boolean zze;
    private final boolean zzf;
    private final String zzg;
    private final String zzh;
    private final boolean zzi;

    public zzsy(PhoneMultiFactorInfo phoneMultiFactorInfo, String str, String str2, long j, boolean z, boolean z2, String str3, String str4, boolean z3) {
        this.zza = phoneMultiFactorInfo;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = j;
        this.zze = z;
        this.zzf = z2;
        this.zzg = str3;
        this.zzh = str4;
        this.zzi = z3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeParcelable(parcel, 1, this.zza, i, false);
        CloseableKt.writeString(parcel, 2, this.zzb, false);
        CloseableKt.writeString(parcel, 3, this.zzc, false);
        long j = this.zzd;
        CloseableKt.zzc(parcel, 4, 8);
        parcel.writeLong(j);
        boolean z = this.zze;
        CloseableKt.zzc(parcel, 5, 4);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = this.zzf;
        CloseableKt.zzc(parcel, 6, 4);
        parcel.writeInt(z2 ? 1 : 0);
        CloseableKt.writeString(parcel, 7, this.zzg, false);
        CloseableKt.writeString(parcel, 8, this.zzh, false);
        boolean z3 = this.zzi;
        CloseableKt.zzc(parcel, 9, 4);
        parcel.writeInt(z3 ? 1 : 0);
        CloseableKt.zzb(parcel, iZza);
    }

    public final long zza() {
        return this.zzd;
    }

    public final PhoneMultiFactorInfo zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final String zze() {
        return this.zzh;
    }

    public final String zzf() {
        return this.zzg;
    }

    public final boolean zzg() {
        return this.zze;
    }

    public final boolean zzh() {
        return this.zzi;
    }
}
