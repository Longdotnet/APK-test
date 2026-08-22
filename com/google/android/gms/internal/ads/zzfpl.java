package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzfpl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfpl> CREATOR = new zzfpm();
    public final int zza;
    public final byte[] zzb;

    public zzfpl(int i, byte[] bArr) {
        this.zza = i;
        this.zzb = bArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(i2);
        CloseableKt.writeByteArray(parcel, 2, this.zzb, false);
        CloseableKt.zzb(parcel, iZza);
    }

    public zzfpl(byte[] bArr) {
        this(1, bArr);
    }
}
