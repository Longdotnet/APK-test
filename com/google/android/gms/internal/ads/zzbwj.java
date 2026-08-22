package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzbwj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbwj> CREATOR = new zzbwk();
    public final com.google.android.gms.ads.internal.client.zzm zza;
    public final String zzb;

    public zzbwj(com.google.android.gms.ads.internal.client.zzm zzmVar, String str) {
        this.zza = zzmVar;
        this.zzb = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        com.google.android.gms.ads.internal.client.zzm zzmVar = this.zza;
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeParcelable(parcel, 2, zzmVar, i, false);
        CloseableKt.writeString(parcel, 3, this.zzb, false);
        CloseableKt.zzb(parcel, iZza);
    }
}
