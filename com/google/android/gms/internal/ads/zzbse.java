package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.VersionInfo;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzbse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbse> CREATOR = new zzbsf();
    public final int zza;
    public final int zzb;
    public final int zzc;

    public zzbse(int i, int i2, int i3) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
    }

    public static zzbse zza(VersionInfo versionInfo) {
        throw null;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzbse)) {
            zzbse zzbseVar = (zzbse) obj;
            if (zzbseVar.zzc == this.zzc && zzbseVar.zzb == this.zzb && zzbseVar.zza == this.zza) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new int[]{this.zza, this.zzb, this.zzc});
    }

    public final String toString() {
        return this.zza + "." + this.zzb + "." + this.zzc;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(i2);
        int i3 = this.zzb;
        CloseableKt.zzc(parcel, 2, 4);
        parcel.writeInt(i3);
        int i4 = this.zzc;
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(i4);
        CloseableKt.zzb(parcel, iZza);
    }
}
