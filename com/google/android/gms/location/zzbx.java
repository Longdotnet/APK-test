package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzah;
import java.util.Arrays;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzbx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbx> CREATOR = new zzl(7);
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;

    public zzbx(int i, int i2, int i3, int i4) {
        zzah.checkState(i >= 0 && i <= 23, "Start hour must be in range [0, 23].");
        zzah.checkState(i2 >= 0 && i2 <= 59, "Start minute must be in range [0, 59].");
        zzah.checkState(i3 >= 0 && i3 <= 23, "End hour must be in range [0, 23].");
        zzah.checkState(i4 >= 0 && i4 <= 59, "End minute must be in range [0, 59].");
        zzah.checkState(((i + i2) + i3) + i4 > 0, "Parameters can't be all 0.");
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbx)) {
            return false;
        }
        zzbx zzbxVar = (zzbx) obj;
        return this.zza == zzbxVar.zza && this.zzb == zzbxVar.zzb && this.zzc == zzbxVar.zzc && this.zzd == zzbxVar.zzd;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd)});
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(117);
        sb.append("UserPreferredSleepWindow [startHour=");
        sb.append(this.zza);
        sb.append(", startMinute=");
        sb.append(this.zzb);
        sb.append(", endHour=");
        sb.append(this.zzc);
        sb.append(", endMinute=");
        sb.append(this.zzd);
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzah.checkNotNull(parcel);
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(this.zza);
        CloseableKt.zzc(parcel, 2, 4);
        parcel.writeInt(this.zzb);
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(this.zzc);
        CloseableKt.zzc(parcel, 4, 4);
        parcel.writeInt(this.zzd);
        CloseableKt.zzb(parcel, iZza);
    }
}
