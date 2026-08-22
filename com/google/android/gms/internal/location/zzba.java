package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzba extends AbstractSafeParcelable {
    final LocationRequest zzb;
    final List<ClientIdentity> zzc;
    final String zzd;
    final boolean zze;
    final boolean zzf;
    final boolean zzg;
    final String zzh;
    final boolean zzi;
    boolean zzj;
    String zzk;
    long zzl;
    static final List<ClientIdentity> zza = Collections.emptyList();
    public static final Parcelable.Creator<zzba> CREATOR = new zzbb();

    public zzba(LocationRequest locationRequest, List<ClientIdentity> list, String str, boolean z, boolean z2, boolean z3, String str2, boolean z4, boolean z5, String str3, long j) {
        this.zzb = locationRequest;
        this.zzc = list;
        this.zzd = str;
        this.zze = z;
        this.zzf = z2;
        this.zzg = z3;
        this.zzh = str2;
        this.zzi = z4;
        this.zzj = z5;
        this.zzk = str3;
        this.zzl = j;
    }

    public static zzba zza(String str, LocationRequest locationRequest) {
        return new zzba(locationRequest, zza, null, false, false, false, null, false, false, null, Long.MAX_VALUE);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzba) {
            zzba zzbaVar = (zzba) obj;
            if (com.google.android.gms.common.internal.zzah.equal(this.zzb, zzbaVar.zzb) && com.google.android.gms.common.internal.zzah.equal(this.zzc, zzbaVar.zzc) && com.google.android.gms.common.internal.zzah.equal(this.zzd, zzbaVar.zzd) && this.zze == zzbaVar.zze && this.zzf == zzbaVar.zzf && this.zzg == zzbaVar.zzg && com.google.android.gms.common.internal.zzah.equal(this.zzh, zzbaVar.zzh) && this.zzi == zzbaVar.zzi && this.zzj == zzbaVar.zzj && com.google.android.gms.common.internal.zzah.equal(this.zzk, zzbaVar.zzk)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zzb.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.zzb);
        if (this.zzd != null) {
            sb.append(" tag=");
            sb.append(this.zzd);
        }
        if (this.zzh != null) {
            sb.append(" moduleId=");
            sb.append(this.zzh);
        }
        if (this.zzk != null) {
            sb.append(" contextAttributionTag=");
            sb.append(this.zzk);
        }
        sb.append(" hideAppOps=");
        sb.append(this.zze);
        sb.append(" clients=");
        sb.append(this.zzc);
        sb.append(" forceCoarseLocation=");
        sb.append(this.zzf);
        if (this.zzg) {
            sb.append(" exemptFromBackgroundThrottle");
        }
        if (this.zzi) {
            sb.append(" locationSettingsIgnored");
        }
        if (this.zzj) {
            sb.append(" inaccurateLocationsDelayed");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeParcelable(parcel, 1, this.zzb, i, false);
        CloseableKt.writeTypedList(parcel, 5, this.zzc, false);
        CloseableKt.writeString(parcel, 6, this.zzd, false);
        boolean z = this.zze;
        CloseableKt.zzc(parcel, 7, 4);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = this.zzf;
        CloseableKt.zzc(parcel, 8, 4);
        parcel.writeInt(z2 ? 1 : 0);
        boolean z3 = this.zzg;
        CloseableKt.zzc(parcel, 9, 4);
        parcel.writeInt(z3 ? 1 : 0);
        CloseableKt.writeString(parcel, 10, this.zzh, false);
        boolean z4 = this.zzi;
        CloseableKt.zzc(parcel, 11, 4);
        parcel.writeInt(z4 ? 1 : 0);
        boolean z5 = this.zzj;
        CloseableKt.zzc(parcel, 12, 4);
        parcel.writeInt(z5 ? 1 : 0);
        CloseableKt.writeString(parcel, 13, this.zzk, false);
        long j = this.zzl;
        CloseableKt.zzc(parcel, 14, 8);
        parcel.writeLong(j);
        CloseableKt.zzb(parcel, iZza);
    }

    public final zzba zzb(long j) {
        LocationRequest locationRequest = this.zzb;
        long j2 = locationRequest.zzh;
        long j3 = locationRequest.zzb;
        if (j2 < j3) {
            j2 = j3;
        }
        if (j2 <= j3) {
            this.zzl = 10000L;
            return this;
        }
        LocationRequest locationRequest2 = this.zzb;
        long j4 = locationRequest2.zzb;
        long j5 = locationRequest2.zzh;
        if (j5 < j4) {
            j5 = j4;
        }
        StringBuilder sb = new StringBuilder(120);
        sb.append("could not set max age when location batching is requested, interval=");
        sb.append(j4);
        sb.append("maxWaitTime=");
        sb.append(j5);
        throw new IllegalArgumentException(sb.toString());
    }

    public final zzba zzc(String str) {
        this.zzk = str;
        return this;
    }

    public final zzba zzd(boolean z) {
        this.zzj = true;
        return this;
    }
}
