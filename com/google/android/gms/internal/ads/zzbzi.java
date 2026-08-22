package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzbzi implements Runnable {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzcak zzb;

    public zzbzi(zzbzj zzbzjVar, Context context, zzcak zzcakVar) {
        this.zza = context;
        this.zzb = zzcakVar;
        Objects.requireNonNull(zzbzjVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzb.zzc(AdvertisingIdClient.getAdvertisingIdInfo(this.zza));
        } catch (GooglePlayServicesNotAvailableException | IOException | IllegalStateException e) {
            this.zzb.zzd(e);
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Exception while getting advertising Id info", e);
        }
    }
}
