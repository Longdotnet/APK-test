package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.location.zzl;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzh> CREATOR = new zzl(14);
    public final int zzk;
    public final boolean zzl;

    public zzh(int i, boolean z) {
        this.zzk = i;
        this.zzl = z;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 2, 4);
        parcel.writeInt(this.zzk);
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(this.zzl ? 1 : 0);
        CloseableKt.zzb(parcel, iZza);
    }
}
