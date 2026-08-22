package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzaq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaq> CREATOR = new zzar();
    final int zza;
    public final String zzb;

    public zzaq(int i, String str) {
        this.zza = 1;
        com.google.android.gms.common.internal.zzah.checkNotNull(str);
        this.zzb = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        int i2 = this.zza;
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(i2);
        CloseableKt.writeString(parcel, 2, this.zzb, false);
        CloseableKt.zzb(parcel, iZza);
    }

    public zzaq(String str) {
        this(1, str);
    }
}
