package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzaw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaw> CREATOR = new zzr(3);
    public final String zza;
    public final zzau zzb;
    public final String zzc;
    public final long zzd;

    public zzaw(zzaw zzawVar, long j) {
        com.google.android.gms.common.internal.zzah.checkNotNull(zzawVar);
        this.zza = zzawVar.zza;
        this.zzb = zzawVar.zzb;
        this.zzc = zzawVar.zzc;
        this.zzd = j;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzb);
        StringBuilder sb = new StringBuilder("origin=");
        sb.append(this.zzc);
        sb.append(",name=");
        return Fragment$$ExternalSyntheticOutline0.m(sb, this.zza, ",params=", strValueOf);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzr.zza(this, parcel, i);
    }

    public zzaw(String str, zzau zzauVar, String str2, long j) {
        this.zza = str;
        this.zzb = zzauVar;
        this.zzc = str2;
        this.zzd = j;
    }
}
