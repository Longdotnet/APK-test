package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.AdError;

/* JADX INFO: loaded from: classes.dex */
public interface MediationInterstitialListener {
    void onAdClosed(MediationInterstitialAdapter mediationInterstitialAdapter);

    void onAdFailedToLoad(MediationInterstitialAdapter mediationInterstitialAdapter, int i);

    void onAdFailedToLoad(MediationInterstitialAdapter mediationInterstitialAdapter, AdError adError);

    void onAdLoaded(MediationInterstitialAdapter mediationInterstitialAdapter);

    void onAdOpened(MediationInterstitialAdapter mediationInterstitialAdapter);
}
