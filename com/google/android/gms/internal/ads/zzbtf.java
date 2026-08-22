package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nativead.NativeAd;

/* JADX INFO: loaded from: classes.dex */
public final class zzbtf extends zzbic {
    private final NativeAd.OnNativeAdLoadedListener zza;

    public zzbtf(NativeAd.OnNativeAdLoadedListener onNativeAdLoadedListener) {
        this.zza = onNativeAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzbid
    public final void zze(zzbij zzbijVar) {
        this.zza.onNativeAdLoaded(new zzbsz(zzbijVar));
    }
}
