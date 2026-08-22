package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzav extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzav> CREATOR = new zzaw();
    final int zza;
    public final String zzb;
    public final int zzc;

    public zzav(int i, String str, int i2) {
        this.zza = 1;
        com.google.android.gms.common.internal.zzah.checkNotNull(str);
        this.zzb = str;
        this.zzc = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        int i2 = this.zza;
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(i2);
        CloseableKt.writeString(parcel, 2, this.zzb, false);
        int i3 = this.zzc;
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(i3);
        CloseableKt.zzb(parcel, iZza);
    }

    public zzav(String str, int i) {
        this(1, str, i);
    }
}
