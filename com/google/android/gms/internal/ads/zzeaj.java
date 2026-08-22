package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
public final class zzeaj {
    private final zzbvk zza;

    public zzeaj(zzbvk zzbvkVar) {
        this.zza = zzbvkVar;
    }

    public final void zza() {
        ListenableFuture listenableFutureZza = this.zza.zza();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzia)).booleanValue()) {
            zzcai.zzb(listenableFutureZza, "persistFlags");
        } else {
            zzcai.zza(listenableFutureZza, "persistFlags");
        }
    }
}
