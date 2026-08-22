package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.os.RemoteException;
import com.facebook.GraphRequest;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.VersionInfo;
import java.util.List;
import kotlin.coroutines.jvm.internal.DEXi.JuorMn;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Adapter {
    public abstract VersionInfo getSDKVersionInfo();

    public abstract VersionInfo getVersionInfo();

    public abstract void initialize(Context context, InitializationCompleteCallback initializationCompleteCallback, List<GraphRequest.Companion> list);

    public void loadAppOpenAd(MediationAppOpenAdConfiguration mediationAppOpenAdConfiguration, MediationAdLoadCallback mediationAdLoadCallback) {
        mediationAdLoadCallback.onFailure(new AdError(7, getClass().getSimpleName().concat(" does not support app open ads."), "com.google.android.gms.ads", null));
    }

    public void loadBannerAd(MediationBannerAdConfiguration mediationBannerAdConfiguration, MediationAdLoadCallback mediationAdLoadCallback) {
        mediationAdLoadCallback.onFailure(new AdError(7, getClass().getSimpleName().concat(" does not support banner ads."), "com.google.android.gms.ads", null));
    }

    public void loadInterstitialAd(MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, MediationAdLoadCallback mediationAdLoadCallback) {
        mediationAdLoadCallback.onFailure(new AdError(7, getClass().getSimpleName().concat(" does not support interstitial ads."), "com.google.android.gms.ads", null));
    }

    public void loadNativeAdMapper(MediationNativeAdConfiguration mediationNativeAdConfiguration, MediationAdLoadCallback mediationAdLoadCallback) throws RemoteException {
        throw new RemoteException("Method is not found");
    }

    public void loadRewardedAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback mediationAdLoadCallback) {
        mediationAdLoadCallback.onFailure(new AdError(7, getClass().getSimpleName().concat(" does not support rewarded ads."), "com.google.android.gms.ads", null));
    }

    public void loadRewardedInterstitialAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback mediationAdLoadCallback) {
        mediationAdLoadCallback.onFailure(new AdError(7, getClass().getSimpleName().concat(" does not support rewarded interstitial ads."), "com.google.android.gms.ads", null));
    }

    @Deprecated
    public void loadNativeAd(MediationNativeAdConfiguration mediationNativeAdConfiguration, MediationAdLoadCallback mediationAdLoadCallback) {
        mediationAdLoadCallback.onFailure(new AdError(7, getClass().getSimpleName().concat(" does not support native ads."), JuorMn.qQYDzDKULeWCyYI, null));
    }
}
