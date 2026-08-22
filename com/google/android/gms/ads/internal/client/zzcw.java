package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.internal.ads.zzayt;
import com.google.android.gms.internal.ads.zzayv;
import com.google.android.gms.internal.ads.zzbpp;
import com.google.android.gms.internal.ads.zzbpq;

/* JADX INFO: loaded from: classes.dex */
public final class zzcw extends zzayt implements zzcy {
    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final zzbpq getAdapterCreator() {
        Parcel parcelZzda = zzda(2, zza());
        zzbpq zzbpqVarZzf = zzbpp.zzf(parcelZzda.readStrongBinder());
        parcelZzda.recycle();
        return zzbpqVarZzf;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final zzfd getLiteSdkVersion() {
        Parcel parcelZzda = zzda(1, zza());
        zzfd zzfdVar = (zzfd) zzayv.zza(parcelZzda, zzfd.CREATOR);
        parcelZzda.recycle();
        return zzfdVar;
    }
}
