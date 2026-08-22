package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzaz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaz> CREATOR = new zzba();
    final int zza;
    public final String zzb;
    public final byte[] zzc;

    public zzaz(int i, String str, byte[] bArr) {
        this.zza = 1;
        com.google.android.gms.common.internal.zzah.checkNotNull(str);
        this.zzb = str;
        com.google.android.gms.common.internal.zzah.checkNotNull(bArr);
        this.zzc = bArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        int i2 = this.zza;
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(i2);
        CloseableKt.writeString(parcel, 2, this.zzb, false);
        CloseableKt.writeByteArray(parcel, 3, this.zzc, false);
        CloseableKt.zzb(parcel, iZza);
    }

    public zzaz(String str, byte[] bArr) {
        this(1, str, bArr);
    }
}
