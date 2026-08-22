package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.AdError;

/* JADX INFO: loaded from: classes.dex */
public interface MediationBannerListener {
    void onAdClicked(MediationBannerAdapter mediationBannerAdapter);

    void onAdClosed(MediationBannerAdapter mediationBannerAdapter);

    void onAdFailedToLoad(MediationBannerAdapter mediationBannerAdapter, AdError adError);

    void onAdLoaded(MediationBannerAdapter mediationBannerAdapter);

    void onAdOpened(MediationBannerAdapter mediationBannerAdapter);

    void zzb(MediationBannerAdapter mediationBannerAdapter, String str, String str2);
}
