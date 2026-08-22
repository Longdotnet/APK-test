package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzbls extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbls> CREATOR = new zzblt();
    public final boolean zza;
    public final String zzb;
    public final int zzc;
    public final byte[] zzd;
    public final String[] zze;
    public final String[] zzf;
    public final boolean zzg;
    public final long zzh;

    public zzbls(boolean z, String str, int i, byte[] bArr, String[] strArr, String[] strArr2, boolean z2, long j) {
        this.zza = z;
        this.zzb = str;
        this.zzc = i;
        this.zzd = bArr;
        this.zze = strArr;
        this.zzf = strArr2;
        this.zzg = z2;
        this.zzh = j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        boolean z = this.zza;
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(z ? 1 : 0);
        CloseableKt.writeString(parcel, 2, this.zzb, false);
        int i2 = this.zzc;
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(i2);
        CloseableKt.writeByteArray(parcel, 4, this.zzd, false);
        CloseableKt.writeStringArray(parcel, 5, this.zze, false);
        CloseableKt.writeStringArray(parcel, 6, this.zzf, false);
        boolean z2 = this.zzg;
        CloseableKt.zzc(parcel, 7, 4);
        parcel.writeInt(z2 ? 1 : 0);
        long j = this.zzh;
        CloseableKt.zzc(parcel, 8, 8);
        parcel.writeLong(j);
        CloseableKt.zzb(parcel, iZza);
    }
}
