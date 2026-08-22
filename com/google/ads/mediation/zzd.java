package com.google.ads.mediation;

import com.daerisoft.thespikerm.GoogleMobileAdsGM;
import com.daerisoft.thespikerm.GoogleMobileAdsGM$3$$ExternalSyntheticLambda0;
import com.daerisoft.thespikerm.GoogleMobileAdsGM$5$$ExternalSyntheticLambda0;
import com.daerisoft.thespikerm.GoogleMobileAdsGM$7$$ExternalSyntheticLambda0;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.gson.yWTz.kBfGXgdfpo;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class zzd extends FullScreenContentCallback {
    public final /* synthetic */ int $r8$classId;
    public final Object zza;
    public final Object zzb;

    public /* synthetic */ zzd(GoogleMobileAdsGM googleMobileAdsGM, Object obj, int i) {
        this.$r8$classId = i;
        this.zzb = googleMobileAdsGM;
        this.zza = obj;
    }

    @Override // com.google.android.gms.ads.FullScreenContentCallback
    public void onAdFailedToShowFullScreenContent(AdError adError) {
        switch (this.$r8$classId) {
            case 1:
                GoogleMobileAdsGM googleMobileAdsGM = (GoogleMobileAdsGM) this.zzb;
                googleMobileAdsGM.isShowingAd = false;
                GoogleMobileAdsGM$3$$ExternalSyntheticLambda0 googleMobileAdsGM$3$$ExternalSyntheticLambda0 = new GoogleMobileAdsGM$3$$ExternalSyntheticLambda0(this, 0);
                InterstitialAd interstitialAd = (InterstitialAd) this.zza;
                googleMobileAdsGM.cleanAd(interstitialAd, googleMobileAdsGM$3$$ExternalSyntheticLambda0);
                HashMap map = new HashMap();
                map.put("unit_id", interstitialAd.getAdUnitId());
                map.put("errorMessage", adError.zzb);
                map.put("errorCode", Double.valueOf(adError.zza));
                googleMobileAdsGM.sendAsyncEvent("AdMob_Interstitial_OnShowFailed", map);
                break;
            case 2:
                GoogleMobileAdsGM googleMobileAdsGM2 = (GoogleMobileAdsGM) this.zzb;
                googleMobileAdsGM2.isShowingAd = false;
                GoogleMobileAdsGM$5$$ExternalSyntheticLambda0 googleMobileAdsGM$5$$ExternalSyntheticLambda0 = new GoogleMobileAdsGM$5$$ExternalSyntheticLambda0(this, 1);
                RewardedAd rewardedAd = (RewardedAd) this.zza;
                googleMobileAdsGM2.cleanAd(rewardedAd, googleMobileAdsGM$5$$ExternalSyntheticLambda0);
                HashMap map2 = new HashMap();
                map2.put("unit_id", rewardedAd.getAdUnitId());
                map2.put("errorMessage", adError.zzb);
                map2.put("errorCode", Double.valueOf(adError.zza));
                googleMobileAdsGM2.sendAsyncEvent("AdMob_RewardedVideo_OnShowFailed", map2);
                break;
            case 3:
                GoogleMobileAdsGM googleMobileAdsGM3 = (GoogleMobileAdsGM) this.zzb;
                googleMobileAdsGM3.isShowingAd = false;
                GoogleMobileAdsGM$7$$ExternalSyntheticLambda0 googleMobileAdsGM$7$$ExternalSyntheticLambda0 = new GoogleMobileAdsGM$7$$ExternalSyntheticLambda0(this, 0);
                RewardedInterstitialAd rewardedInterstitialAd = (RewardedInterstitialAd) this.zza;
                googleMobileAdsGM3.cleanAd(rewardedInterstitialAd, googleMobileAdsGM$7$$ExternalSyntheticLambda0);
                HashMap map3 = new HashMap();
                map3.put("unit_id", rewardedInterstitialAd.getAdUnitId());
                map3.put("errorMessage", adError.zzb);
                map3.put("errorCode", Double.valueOf(adError.zza));
                googleMobileAdsGM3.sendAsyncEvent("AdMob_RewardedInterstitial_OnShowFailed", map3);
                break;
        }
    }

    @Override // com.google.android.gms.ads.FullScreenContentCallback
    public final void onAdShowedFullScreenContent() {
        switch (this.$r8$classId) {
            case 0:
                ((MediationInterstitialListener) this.zzb).onAdOpened((AbstractAdViewAdapter) this.zza);
                break;
            case 1:
                HashMap map = new HashMap();
                map.put("unit_id", ((InterstitialAd) this.zza).getAdUnitId());
                ((GoogleMobileAdsGM) this.zzb).sendAsyncEvent("AdMob_Interstitial_OnFullyShown", map);
                break;
            case 2:
                HashMap map2 = new HashMap();
                map2.put("unit_id", ((RewardedAd) this.zza).getAdUnitId());
                ((GoogleMobileAdsGM) this.zzb).sendAsyncEvent("AdMob_RewardedVideo_OnFullyShown", map2);
                break;
            default:
                HashMap map3 = new HashMap();
                map3.put("unit_id", ((RewardedInterstitialAd) this.zza).getAdUnitId());
                ((GoogleMobileAdsGM) this.zzb).sendAsyncEvent("AdMob_RewardedInterstitial_OnFullyShown", map3);
                break;
        }
    }

    public zzd(AbstractAdViewAdapter abstractAdViewAdapter, MediationInterstitialListener mediationInterstitialListener) {
        this.$r8$classId = 0;
        this.zza = abstractAdViewAdapter;
        this.zzb = mediationInterstitialListener;
    }

    @Override // com.google.android.gms.ads.FullScreenContentCallback
    public final void onAdDismissedFullScreenContent() {
        switch (this.$r8$classId) {
            case 0:
                ((MediationInterstitialListener) this.zzb).onAdClosed((AbstractAdViewAdapter) this.zza);
                break;
            case 1:
                GoogleMobileAdsGM$3$$ExternalSyntheticLambda0 googleMobileAdsGM$3$$ExternalSyntheticLambda0 = new GoogleMobileAdsGM$3$$ExternalSyntheticLambda0(this, 1);
                GoogleMobileAdsGM googleMobileAdsGM = (GoogleMobileAdsGM) this.zzb;
                InterstitialAd interstitialAd = (InterstitialAd) this.zza;
                googleMobileAdsGM.cleanAd(interstitialAd, googleMobileAdsGM$3$$ExternalSyntheticLambda0);
                HashMap map = new HashMap();
                map.put("unit_id", interstitialAd.getAdUnitId());
                googleMobileAdsGM.sendAsyncEvent("AdMob_Interstitial_OnDismissed", map);
                break;
            case 2:
                GoogleMobileAdsGM$5$$ExternalSyntheticLambda0 googleMobileAdsGM$5$$ExternalSyntheticLambda0 = new GoogleMobileAdsGM$5$$ExternalSyntheticLambda0(this, 0);
                GoogleMobileAdsGM googleMobileAdsGM2 = (GoogleMobileAdsGM) this.zzb;
                RewardedAd rewardedAd = (RewardedAd) this.zza;
                googleMobileAdsGM2.cleanAd(rewardedAd, googleMobileAdsGM$5$$ExternalSyntheticLambda0);
                HashMap map2 = new HashMap();
                map2.put("unit_id", rewardedAd.getAdUnitId());
                googleMobileAdsGM2.sendAsyncEvent("AdMob_RewardedVideo_OnDismissed", map2);
                break;
            default:
                GoogleMobileAdsGM$7$$ExternalSyntheticLambda0 googleMobileAdsGM$7$$ExternalSyntheticLambda0 = new GoogleMobileAdsGM$7$$ExternalSyntheticLambda0(this, 1);
                GoogleMobileAdsGM googleMobileAdsGM3 = (GoogleMobileAdsGM) this.zzb;
                RewardedInterstitialAd rewardedInterstitialAd = (RewardedInterstitialAd) this.zza;
                googleMobileAdsGM3.cleanAd(rewardedInterstitialAd, googleMobileAdsGM$7$$ExternalSyntheticLambda0);
                HashMap map3 = new HashMap();
                map3.put(kBfGXgdfpo.VAHnfLizcwffY, rewardedInterstitialAd.getAdUnitId());
                googleMobileAdsGM3.sendAsyncEvent("AdMob_RewardedInterstitial_OnDismissed", map3);
                break;
        }
    }
}
