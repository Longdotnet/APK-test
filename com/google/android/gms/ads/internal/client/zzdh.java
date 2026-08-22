package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.internal.ads.zzayt;

/* JADX INFO: loaded from: classes.dex */
public final class zzdh extends zzayt implements zzdj {
    @Override // com.google.android.gms.ads.internal.client.zzdj
    public final String zze() {
        Parcel parcelZzda = zzda(1, zza());
        String string = parcelZzda.readString();
        parcelZzda.recycle();
        return string;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdj
    public final String zzf() {
        Parcel parcelZzda = zzda(2, zza());
        String string = parcelZzda.readString();
        parcelZzda.recycle();
        return string;
    }
}
