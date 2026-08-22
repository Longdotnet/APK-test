package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzs> CREATOR = new zzl(9);
    public final boolean zza;
    public final long zzb;
    public final float zzc;
    public final long zzd;
    public final int zze;

    public zzs(boolean z, long j, float f, long j2, int i) {
        this.zza = z;
        this.zzb = j;
        this.zzc = f;
        this.zzd = j2;
        this.zze = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzs)) {
            return false;
        }
        zzs zzsVar = (zzs) obj;
        return this.zza == zzsVar.zza && this.zzb == zzsVar.zzb && Float.compare(this.zzc, zzsVar.zzc) == 0 && this.zzd == zzsVar.zzd && this.zze == zzsVar.zze;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.zza), Long.valueOf(this.zzb), Float.valueOf(this.zzc), Long.valueOf(this.zzd), Integer.valueOf(this.zze)});
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DeviceOrientationRequest[mShouldUseMag=");
        sb.append(this.zza);
        sb.append(" mMinimumSamplingPeriodMs=");
        sb.append(this.zzb);
        sb.append(" mSmallestAngleChangeRadians=");
        sb.append(this.zzc);
        long j = this.zzd;
        if (j != Long.MAX_VALUE) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            sb.append(" expireIn=");
            sb.append(j - jElapsedRealtime);
            sb.append("ms");
        }
        int i = this.zze;
        if (i != Integer.MAX_VALUE) {
            sb.append(" num=");
            sb.append(i);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(this.zza ? 1 : 0);
        CloseableKt.zzc(parcel, 2, 8);
        parcel.writeLong(this.zzb);
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeFloat(this.zzc);
        CloseableKt.zzc(parcel, 4, 8);
        parcel.writeLong(this.zzd);
        CloseableKt.zzc(parcel, 5, 4);
        parcel.writeInt(this.zze);
        CloseableKt.zzb(parcel, iZza);
    }
}
