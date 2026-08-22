package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.util.concurrent.dN.MnHfHMYQDPUO;
import com.google.android.gms.drive.zza;
import com.google.firebase.auth.zzz;
import java.util.Arrays;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes2.dex */
public final class Feature extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Feature> CREATOR = new zza(20);
    public final String zza;
    public final int zzb;
    public final long zzc;

    public Feature(int i, long j, String str) {
        this.zza = str;
        this.zzb = i;
        this.zzc = j;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            String str = this.zza;
            if (((str != null && str.equals(feature.zza)) || (str == null && feature.zza == null)) && getVersion() == feature.getVersion()) {
                return true;
            }
        }
        return false;
    }

    public final long getVersion() {
        long j = this.zzc;
        return j == -1 ? this.zzb : j;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, Long.valueOf(getVersion())});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, this.zza, false);
        CloseableKt.zzc(parcel, 2, 4);
        parcel.writeInt(this.zzb);
        long version = getVersion();
        CloseableKt.zzc(parcel, 3, 8);
        parcel.writeLong(version);
        CloseableKt.zzb(parcel, iZza);
    }

    public final String toString() {
        zzz zzzVar = new zzz(this);
        zzzVar.add(this.zza, MnHfHMYQDPUO.rIkaglcbtVIFyHe);
        zzzVar.add(Long.valueOf(getVersion()), "version");
        return zzzVar.toString();
    }

    public Feature(String str, long j) {
        this.zza = str;
        this.zzc = j;
        this.zzb = -1;
    }
}
