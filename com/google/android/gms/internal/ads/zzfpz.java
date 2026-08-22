package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzfpz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfpz> CREATOR = new zzfqa();
    public final int zza;
    public final byte[] zzb;
    public final int zzc;

    public zzfpz(int i, byte[] bArr, int i2) {
        this.zza = i;
        this.zzb = bArr == null ? null : Arrays.copyOf(bArr, bArr.length);
        this.zzc = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(i2);
        CloseableKt.writeByteArray(parcel, 2, this.zzb, false);
        int i3 = this.zzc;
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(i3);
        CloseableKt.zzb(parcel, iZza);
    }

    public zzfpz(byte[] bArr, int i) {
        this(1, null, 1);
    }
}
