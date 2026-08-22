package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
public final class zzbpx extends zzayt implements zzbpz {
    public zzbpx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd");
    }

    @Override // com.google.android.gms.internal.ads.zzbpz
    public final IObjectWrapper zze() {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzda(1, zza()));
    }

    @Override // com.google.android.gms.internal.ads.zzbpz
    public final boolean zzf() {
        Parcel parcelZzda = zzda(2, zza());
        boolean zZzh = zzayv.zzh(parcelZzda);
        parcelZzda.recycle();
        return zZzh;
    }
}
