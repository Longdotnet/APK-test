package com.daerisoft.thespikerm;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class GoogleMobileAdsGM$$ExternalSyntheticLambda10 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ GoogleMobileAdsGM f$0;
    public final /* synthetic */ double f$1;

    public /* synthetic */ GoogleMobileAdsGM$$ExternalSyntheticLambda10(GoogleMobileAdsGM googleMobileAdsGM, double d, int i) {
        this.$r8$classId = i;
        this.f$0 = googleMobileAdsGM;
        this.f$1 = d;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                this.f$0.lambda$AdMob_Banner_Move$2(this.f$1);
                break;
            default:
                this.f$0.lambda$AdMob_Consent_RequestInfoUpdate$20(this.f$1);
                break;
        }
    }
}
