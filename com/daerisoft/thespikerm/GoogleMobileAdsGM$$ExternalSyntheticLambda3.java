package com.daerisoft.thespikerm;

import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.ump.ConsentForm;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.FormError;
import com.google.android.ump.UserMessagingPlatform$OnConsentFormLoadFailureListener;
import com.google.android.ump.UserMessagingPlatform$OnConsentFormLoadSuccessListener;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class GoogleMobileAdsGM$$ExternalSyntheticLambda3 implements UserMessagingPlatform$OnConsentFormLoadSuccessListener, UserMessagingPlatform$OnConsentFormLoadFailureListener, GoogleMobileAdsGM.AdCleaner, OnPaidEventListener, ConsentInformation.OnConsentInfoUpdateSuccessListener, ConsentInformation.OnConsentInfoUpdateFailureListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ GoogleMobileAdsGM f$0;

    public /* synthetic */ GoogleMobileAdsGM$$ExternalSyntheticLambda3(GoogleMobileAdsGM googleMobileAdsGM, int i) {
        this.$r8$classId = i;
        this.f$0 = googleMobileAdsGM;
    }

    @Override // com.daerisoft.thespikerm.GoogleMobileAdsGM.AdCleaner
    public void clean(Object obj) {
        switch (this.$r8$classId) {
            case 3:
                this.f$0.cleanUpAd((AdView) obj);
                break;
            case 4:
            case 5:
            default:
                this.f$0.cleanUpAd((AppOpenAd) obj);
                break;
            case 6:
                this.f$0.cleanUpAd((InterstitialAd) obj);
                break;
            case 7:
                this.f$0.cleanUpAd((RewardedAd) obj);
                break;
            case 8:
                this.f$0.cleanUpAd((RewardedInterstitialAd) obj);
                break;
        }
    }

    @Override // com.google.android.ump.UserMessagingPlatform$OnConsentFormLoadFailureListener
    public void onConsentFormLoadFailure(FormError formError) {
        this.f$0.lambda$AdMob_Consent_Load$22(formError);
    }

    @Override // com.google.android.ump.UserMessagingPlatform$OnConsentFormLoadSuccessListener
    public void onConsentFormLoadSuccess(ConsentForm consentForm) {
        this.f$0.lambda$AdMob_Consent_Load$21(consentForm);
    }

    @Override // com.google.android.ump.ConsentInformation.OnConsentInfoUpdateFailureListener
    public void onConsentInfoUpdateFailure(FormError formError) {
        this.f$0.lambda$AdMob_Consent_RequestInfoUpdate$19(formError);
    }

    @Override // com.google.android.ump.ConsentInformation.OnConsentInfoUpdateSuccessListener
    public void onConsentInfoUpdateSuccess() {
        this.f$0.lambda$AdMob_Consent_RequestInfoUpdate$18();
    }

    @Override // com.google.android.gms.ads.OnPaidEventListener
    public void onPaidEvent(AdValue adValue) {
        this.f$0.lambda$createBannerAdView$6(adValue);
    }
}
