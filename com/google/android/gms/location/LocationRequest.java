package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import androidx.sqlite.db.framework.VERT.YcVWhnLsj;
import com.google.android.gms.ads.rewarded.zQ.yzwzcWHcnH;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes2.dex */
public final class LocationRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationRequest> CREATOR = new com.google.android.gms.drive.zza(27);
    public int zza;
    public long zzb;
    public long zzc;
    public boolean zzd;
    public long zze;
    public int zzf;
    public float zzg;
    public long zzh;
    public boolean zzi;

    public final boolean equals(Object obj) {
        if (obj instanceof LocationRequest) {
            LocationRequest locationRequest = (LocationRequest) obj;
            if (this.zza == locationRequest.zza) {
                long j = this.zzb;
                long j2 = locationRequest.zzb;
                if (j == j2 && this.zzc == locationRequest.zzc && this.zzd == locationRequest.zzd && this.zze == locationRequest.zze && this.zzf == locationRequest.zzf && this.zzg == locationRequest.zzg) {
                    long j3 = this.zzh;
                    if (j3 >= j) {
                        j = j3;
                    }
                    long j4 = locationRequest.zzh;
                    if (j4 >= j2) {
                        j2 = j4;
                    }
                    if (j == j2 && this.zzi == locationRequest.zzi) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zza), Long.valueOf(this.zzb), Float.valueOf(this.zzg), Long.valueOf(this.zzh)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(this.zza);
        CloseableKt.zzc(parcel, 2, 8);
        parcel.writeLong(this.zzb);
        CloseableKt.zzc(parcel, 3, 8);
        parcel.writeLong(this.zzc);
        CloseableKt.zzc(parcel, 4, 4);
        parcel.writeInt(this.zzd ? 1 : 0);
        CloseableKt.zzc(parcel, 5, 8);
        parcel.writeLong(this.zze);
        CloseableKt.zzc(parcel, 6, 4);
        parcel.writeInt(this.zzf);
        CloseableKt.zzc(parcel, 7, 4);
        parcel.writeFloat(this.zzg);
        CloseableKt.zzc(parcel, 8, 8);
        parcel.writeLong(this.zzh);
        CloseableKt.zzc(parcel, 9, 4);
        parcel.writeInt(this.zzi ? 1 : 0);
        CloseableKt.zzb(parcel, iZza);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Request[");
        int i = this.zza;
        if (i == 100) {
            str = "PRIORITY_HIGH_ACCURACY";
        } else if (i == 102) {
            str = "PRIORITY_BALANCED_POWER_ACCURACY";
        } else if (i != 104) {
            str = i != 105 ? "???" : "PRIORITY_NO_POWER";
        } else {
            str = "PRIORITY_LOW_POWER";
        }
        sb.append(str);
        long j = this.zzb;
        if (i != 105) {
            sb.append(" requested=");
            sb.append(j);
            sb.append("ms");
        }
        sb.append(" fastest=");
        sb.append(this.zzc);
        sb.append("ms");
        long j2 = this.zzh;
        if (j2 > j) {
            sb.append(" maxWait=");
            sb.append(j2);
            sb.append("ms");
        }
        float f = this.zzg;
        if (f > 0.0f) {
            sb.append(" smallestDisplacement=");
            sb.append(f);
            sb.append("m");
        }
        long j3 = this.zze;
        if (j3 != Long.MAX_VALUE) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            sb.append(YcVWhnLsj.BuprrFYNSYmygG);
            sb.append(j3 - jElapsedRealtime);
            sb.append("ms");
        }
        int i2 = this.zzf;
        if (i2 != Integer.MAX_VALUE) {
            sb.append(yzwzcWHcnH.XzBCiefkz);
            sb.append(i2);
        }
        sb.append(']');
        return sb.toString();
    }
}
