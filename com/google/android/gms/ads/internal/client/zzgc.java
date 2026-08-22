package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzgc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgc> CREATOR = new com.google.android.gms.appset.zzb(17);
    public final boolean zza;
    public final boolean zzb;
    public final boolean zzc;

    public zzgc(VideoOptions videoOptions) {
        this(videoOptions.zza, videoOptions.zzb, videoOptions.zzc);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 2, 4);
        parcel.writeInt(this.zza ? 1 : 0);
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(this.zzb ? 1 : 0);
        CloseableKt.zzc(parcel, 4, 4);
        parcel.writeInt(this.zzc ? 1 : 0);
        CloseableKt.zzb(parcel, iZza);
    }

    public zzgc(boolean z, boolean z2, boolean z3) {
        this.zza = z;
        this.zzb = z2;
        this.zzc = z3;
    }
}
