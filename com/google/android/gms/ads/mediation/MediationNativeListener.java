package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.internal.ads.zzbhk;

/* JADX INFO: loaded from: classes.dex */
public interface MediationNativeListener {
    void onAdClicked(MediationNativeAdapter mediationNativeAdapter);

    void onAdClosed(MediationNativeAdapter mediationNativeAdapter);

    void onAdFailedToLoad(MediationNativeAdapter mediationNativeAdapter, AdError adError);

    void onAdImpression(MediationNativeAdapter mediationNativeAdapter);

    void onAdLoaded(MediationNativeAdapter mediationNativeAdapter, UnifiedNativeAdMapper unifiedNativeAdMapper);

    void onAdOpened(MediationNativeAdapter mediationNativeAdapter);

    void zzd(MediationNativeAdapter mediationNativeAdapter, zzbhk zzbhkVar);

    void zze(MediationNativeAdapter mediationNativeAdapter, zzbhk zzbhkVar, String str);
}
