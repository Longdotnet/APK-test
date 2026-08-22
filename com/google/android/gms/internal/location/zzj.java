package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Collections;
import java.util.List;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzj extends AbstractSafeParcelable {
    final com.google.android.gms.location.zzs zzc;
    final List<ClientIdentity> zzd;
    final String zze;
    static final List<ClientIdentity> zza = Collections.emptyList();
    static final com.google.android.gms.location.zzs zzb = new com.google.android.gms.location.zzs(true, 50, 0.0f, Long.MAX_VALUE, Integer.MAX_VALUE);
    public static final Parcelable.Creator<zzj> CREATOR = new zzk();

    public zzj(com.google.android.gms.location.zzs zzsVar, List<ClientIdentity> list, String str) {
        this.zzc = zzsVar;
        this.zzd = list;
        this.zze = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzj)) {
            return false;
        }
        zzj zzjVar = (zzj) obj;
        return com.google.android.gms.common.internal.zzah.equal(this.zzc, zzjVar.zzc) && com.google.android.gms.common.internal.zzah.equal(this.zzd, zzjVar.zzd) && com.google.android.gms.common.internal.zzah.equal(this.zze, zzjVar.zze);
    }

    public final int hashCode() {
        return this.zzc.hashCode();
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzc);
        String strValueOf2 = String.valueOf(this.zzd);
        String str = this.zze;
        int length = strValueOf.length();
        StringBuilder sb = new StringBuilder(length + 77 + strValueOf2.length() + String.valueOf(str).length());
        sb.append("DeviceOrientationRequestInternal{deviceOrientationRequest=");
        sb.append(strValueOf);
        sb.append(", clients=");
        sb.append(strValueOf2);
        return Fragment$$ExternalSyntheticOutline0.m(sb, ", tag='", str, "'}");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeParcelable(parcel, 1, this.zzc, i, false);
        CloseableKt.writeTypedList(parcel, 2, this.zzd, false);
        CloseableKt.writeString(parcel, 3, this.zze, false);
        CloseableKt.zzb(parcel, iZza);
    }
}
