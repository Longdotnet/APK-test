package com.daerisoft.thespikerm;

import com.google.ads.mediation.zzd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class GoogleMobileAdsGM$7$$ExternalSyntheticLambda0 implements GoogleMobileAdsGM.AdCleaner {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ zzd f$0;

    public /* synthetic */ GoogleMobileAdsGM$7$$ExternalSyntheticLambda0(zzd zzdVar, int i) {
        this.$r8$classId = i;
        this.f$0 = zzdVar;
    }

    @Override // com.daerisoft.thespikerm.GoogleMobileAdsGM.AdCleaner
    public final void clean(Object obj) {
        RewardedInterstitialAd rewardedInterstitialAd = (RewardedInterstitialAd) obj;
        switch (this.$r8$classId) {
            case 0:
                ((GoogleMobileAdsGM) this.f$0.zzb).cleanUpAd(rewardedInterstitialAd);
                break;
            default:
                ((GoogleMobileAdsGM) this.f$0.zzb).cleanUpAd(rewardedInterstitialAd);
                break;
        }
    }
}
