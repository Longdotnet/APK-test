package com.google.android.gms.ads.mediation.rtb;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationAppOpenAdConfiguration;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;

/* JADX INFO: loaded from: classes.dex */
public abstract class RtbAdapter extends Adapter {
    public abstract void collectSignals(RtbSignalData rtbSignalData, SignalCallbacks signalCallbacks);

    public void loadRtbAppOpenAd(MediationAppOpenAdConfiguration mediationAppOpenAdConfiguration, MediationAdLoadCallback mediationAdLoadCallback) {
        loadAppOpenAd(mediationAppOpenAdConfiguration, mediationAdLoadCallback);
    }

    public void loadRtbBannerAd(MediationBannerAdConfiguration mediationBannerAdConfiguration, MediationAdLoadCallback mediationAdLoadCallback) {
        loadBannerAd(mediationBannerAdConfiguration, mediationAdLoadCallback);
    }

    public void loadRtbInterstitialAd(MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, MediationAdLoadCallback mediationAdLoadCallback) {
        loadInterstitialAd(mediationInterstitialAdConfiguration, mediationAdLoadCallback);
    }

    @Deprecated
    public void loadRtbNativeAd(MediationNativeAdConfiguration mediationNativeAdConfiguration, MediationAdLoadCallback mediationAdLoadCallback) {
        loadNativeAd(mediationNativeAdConfiguration, mediationAdLoadCallback);
    }

    public void loadRtbNativeAdMapper(MediationNativeAdConfiguration mediationNativeAdConfiguration, MediationAdLoadCallback mediationAdLoadCallback) throws RemoteException {
        loadNativeAdMapper(mediationNativeAdConfiguration, mediationAdLoadCallback);
    }

    public void loadRtbRewardedAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback mediationAdLoadCallback) {
        loadRewardedAd(mediationRewardedAdConfiguration, mediationAdLoadCallback);
    }

    public void loadRtbRewardedInterstitialAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback mediationAdLoadCallback) {
        loadRewardedInterstitialAd(mediationRewardedAdConfiguration, mediationAdLoadCallback);
    }
}
