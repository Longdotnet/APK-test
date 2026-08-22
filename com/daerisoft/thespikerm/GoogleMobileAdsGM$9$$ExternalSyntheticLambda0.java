package com.daerisoft.thespikerm;

import com.google.android.gms.ads.appopen.AppOpenAd;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class GoogleMobileAdsGM$9$$ExternalSyntheticLambda0 implements GoogleMobileAdsGM.AdCleaner {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ GoogleMobileAdsGM.AnonymousClass9 f$0;

    public /* synthetic */ GoogleMobileAdsGM$9$$ExternalSyntheticLambda0(GoogleMobileAdsGM.AnonymousClass9 anonymousClass9, int i) {
        this.$r8$classId = i;
        this.f$0 = anonymousClass9;
    }

    @Override // com.daerisoft.thespikerm.GoogleMobileAdsGM.AdCleaner
    public final void clean(Object obj) {
        AppOpenAd appOpenAd = (AppOpenAd) obj;
        switch (this.$r8$classId) {
            case 0:
                GoogleMobileAdsGM.this.cleanUpAd(appOpenAd);
                break;
            default:
                GoogleMobileAdsGM.this.cleanUpAd(appOpenAd);
                break;
        }
    }
}
