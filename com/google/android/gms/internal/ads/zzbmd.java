package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzbmd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbmd> CREATOR = new zzbme();
    public final String zza;
    public final boolean zzb;
    public final int zzc;
    public final String zzd;

    public zzbmd(String str, boolean z, int i, String str2) {
        this.zza = str;
        this.zzb = z;
        this.zzc = i;
        this.zzd = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.zza;
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, str, false);
        boolean z = this.zzb;
        CloseableKt.zzc(parcel, 2, 4);
        parcel.writeInt(z ? 1 : 0);
        int i2 = this.zzc;
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(i2);
        CloseableKt.writeString(parcel, 4, this.zzd, false);
        CloseableKt.zzb(parcel, iZza);
    }
}
