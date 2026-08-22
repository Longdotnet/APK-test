package com.google.android.gms.internal.ads;

import com.facebook.GraphRequest;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzbsh implements Runnable {
    final /* synthetic */ AdOverlayInfoParcel zza;
    final /* synthetic */ zzbsi zzb;

    public zzbsh(zzbsi zzbsiVar, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zza = adOverlayInfoParcel;
        Objects.requireNonNull(zzbsiVar);
        this.zzb = zzbsiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        GraphRequest.Companion companion = com.google.android.gms.ads.internal.zzv.zza.zzc;
        GraphRequest.Companion.zza(this.zzb.zza, this.zza, true, null);
    }
}
