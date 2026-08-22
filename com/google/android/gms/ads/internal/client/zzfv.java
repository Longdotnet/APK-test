package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Objects;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzfv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfv> CREATOR = new com.google.android.gms.appset.zzb(14);
    public final String zza;
    public final int zzb;
    public final zzm zzc;
    public final int zzd;

    public zzfv(String str, int i, zzm zzmVar, int i2) {
        this.zza = str;
        this.zzb = i;
        this.zzc = zzmVar;
        this.zzd = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzfv) {
            zzfv zzfvVar = (zzfv) obj;
            if (this.zza.equals(zzfvVar.zza) && this.zzb == zzfvVar.zzb && this.zzc.zza(zzfvVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.zza, Integer.valueOf(this.zzb), this.zzc);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, this.zza, false);
        CloseableKt.zzc(parcel, 2, 4);
        parcel.writeInt(this.zzb);
        CloseableKt.writeParcelable(parcel, 3, this.zzc, i, false);
        CloseableKt.zzc(parcel, 4, 4);
        parcel.writeInt(this.zzd);
        CloseableKt.zzb(parcel, iZza);
    }
}
