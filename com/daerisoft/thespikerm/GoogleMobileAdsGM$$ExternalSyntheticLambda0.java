package com.daerisoft.thespikerm;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class GoogleMobileAdsGM$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ GoogleMobileAdsGM f$0;

    public /* synthetic */ GoogleMobileAdsGM$$ExternalSyntheticLambda0(GoogleMobileAdsGM googleMobileAdsGM, int i) {
        this.$r8$classId = i;
        this.f$0 = googleMobileAdsGM;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                this.f$0.lambda$AdMob_Initialize$1();
                break;
            case 1:
                this.f$0.lambda$AdMob_Banner_Show$3();
                break;
            case 2:
                this.f$0.lambda$AdMob_Banner_Remove$5();
                break;
            case 3:
                this.f$0.lambda$AdMob_Banner_Hide$4();
                break;
            default:
                this.f$0.lambda$AdMob_Consent_Show$25();
                break;
        }
    }
}
