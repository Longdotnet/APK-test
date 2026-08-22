package com.daerisoft.thespikerm;

import com.google.ads.mediation.zzd;
import com.google.android.gms.ads.rewarded.RewardedAd;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class GoogleMobileAdsGM$5$$ExternalSyntheticLambda0 implements GoogleMobileAdsGM.AdCleaner {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ zzd f$0;

    public /* synthetic */ GoogleMobileAdsGM$5$$ExternalSyntheticLambda0(zzd zzdVar, int i) {
        this.$r8$classId = i;
        this.f$0 = zzdVar;
    }

    @Override // com.daerisoft.thespikerm.GoogleMobileAdsGM.AdCleaner
    public final void clean(Object obj) {
        RewardedAd rewardedAd = (RewardedAd) obj;
        switch (this.$r8$classId) {
            case 0:
                ((GoogleMobileAdsGM) this.f$0.zzb).cleanUpAd(rewardedAd);
                break;
            default:
                ((GoogleMobileAdsGM) this.f$0.zzb).cleanUpAd(rewardedAd);
                break;
        }
    }
}
