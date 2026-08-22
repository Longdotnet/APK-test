package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
public final class zzbzj {
    public final ListenableFuture zza(Context context, int i) {
        zzcak zzcakVar = new zzcak();
        com.google.android.gms.ads.internal.util.client.zzf zzfVar = com.google.android.gms.ads.internal.client.zzbb.zzb.zzc;
        int iIsGooglePlayServicesAvailable = GoogleApiAvailabilityLight.zza.isGooglePlayServicesAvailable(context, 12451000);
        if (iIsGooglePlayServicesAvailable == 0 || iIsGooglePlayServicesAvailable == 2) {
            zzcaf.zza.execute(new zzbzi(this, context, zzcakVar));
        }
        return zzcakVar;
    }
}
