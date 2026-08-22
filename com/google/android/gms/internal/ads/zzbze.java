package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzbze extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbze> CREATOR = new zzbzf();
    public final String zza;
    public final String zzb;

    @Deprecated
    public final com.google.android.gms.ads.internal.client.zzr zzc;
    public final com.google.android.gms.ads.internal.client.zzm zzd;
    public final int zze;
    public final String zzf;

    public zzbze(String str, String str2, com.google.android.gms.ads.internal.client.zzr zzrVar, com.google.android.gms.ads.internal.client.zzm zzmVar, int i, String str3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzrVar;
        this.zzd = zzmVar;
        this.zze = i;
        this.zzf = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.zza;
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, str, false);
        CloseableKt.writeString(parcel, 2, this.zzb, false);
        CloseableKt.writeParcelable(parcel, 3, this.zzc, i, false);
        CloseableKt.writeParcelable(parcel, 4, this.zzd, i, false);
        int i2 = this.zze;
        CloseableKt.zzc(parcel, 5, 4);
        parcel.writeInt(i2);
        CloseableKt.writeString(parcel, 6, this.zzf, false);
        CloseableKt.zzb(parcel, iZza);
    }
}
