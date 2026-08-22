package com.google.ads.mediation;

import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

/* JADX INFO: loaded from: classes.dex */
public final class zzc extends InterstitialAdLoadCallback {
    public final AbstractAdViewAdapter zza;
    public final MediationInterstitialListener zzb;

    public zzc(AbstractAdViewAdapter abstractAdViewAdapter, MediationInterstitialListener mediationInterstitialListener) {
        this.zza = abstractAdViewAdapter;
        this.zzb = mediationInterstitialListener;
    }

    @Override // com.google.android.gms.ads.AdLoadCallback
    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.zzb.onAdFailedToLoad(this.zza, loadAdError);
    }

    @Override // com.google.android.gms.ads.AdLoadCallback
    public final /* bridge */ /* synthetic */ void onAdLoaded(Object obj) {
        InterstitialAd interstitialAd = (InterstitialAd) obj;
        AbstractAdViewAdapter abstractAdViewAdapter = this.zza;
        abstractAdViewAdapter.mInterstitialAd = interstitialAd;
        MediationInterstitialListener mediationInterstitialListener = this.zzb;
        interstitialAd.setFullScreenContentCallback(new zzd(abstractAdViewAdapter, mediationInterstitialListener));
        mediationInterstitialListener.onAdLoaded(abstractAdViewAdapter);
    }
}
