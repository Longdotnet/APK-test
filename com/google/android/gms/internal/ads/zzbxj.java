package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzbxj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbxj> CREATOR = new zzbxk();
    public final String zza;
    public final String zzb;

    public zzbxj(ServerSideVerificationOptions serverSideVerificationOptions) {
        this(serverSideVerificationOptions.zza, serverSideVerificationOptions.zzb);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.zza;
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, str, false);
        CloseableKt.writeString(parcel, 2, this.zzb, false);
        CloseableKt.zzb(parcel, iZza);
    }

    public zzbxj(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }
}
