package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class LocationAvailability extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationAvailability> CREATOR = new com.google.android.gms.drive.zza(26);
    public int zza;
    public int zzb;
    public long zzc;
    public int zzd;
    public zzbo[] zze;

    public final boolean equals(Object obj) {
        if (obj instanceof LocationAvailability) {
            LocationAvailability locationAvailability = (LocationAvailability) obj;
            if (this.zza == locationAvailability.zza && this.zzb == locationAvailability.zzb && this.zzc == locationAvailability.zzc && this.zzd == locationAvailability.zzd && Arrays.equals(this.zze, locationAvailability.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zzd), Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Long.valueOf(this.zzc), this.zze});
    }

    public final String toString() {
        boolean z = this.zzd < 1000;
        StringBuilder sb = new StringBuilder(48);
        sb.append("LocationAvailability[isLocationAvailable: ");
        sb.append(z);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(this.zza);
        CloseableKt.zzc(parcel, 2, 4);
        parcel.writeInt(this.zzb);
        CloseableKt.zzc(parcel, 3, 8);
        parcel.writeLong(this.zzc);
        CloseableKt.zzc(parcel, 4, 4);
        parcel.writeInt(this.zzd);
        CloseableKt.writeTypedArray(parcel, 5, this.zze, i);
        CloseableKt.zzb(parcel, iZza);
    }
}
