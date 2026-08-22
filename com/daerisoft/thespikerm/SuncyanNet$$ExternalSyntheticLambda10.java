package com.daerisoft.thespikerm;

import java.io.Serializable;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SuncyanNet$$ExternalSyntheticLambda10 implements Runnable {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ String f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Serializable f$3;
    public final /* synthetic */ int f$4;

    public /* synthetic */ SuncyanNet$$ExternalSyntheticLambda10(int i, GoogleMobileAdsGM googleMobileAdsGM, String str, String str2, ConcurrentLinkedQueue concurrentLinkedQueue) {
        this.f$2 = googleMobileAdsGM;
        this.f$0 = str;
        this.f$1 = str2;
        this.f$3 = concurrentLinkedQueue;
        this.f$4 = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                SuncyanNet.lambda$RequestMTLS$1(this.f$0, this.f$1, (String) this.f$2, (String) this.f$3, this.f$4);
                break;
            default:
                ((GoogleMobileAdsGM) this.f$2).lambda$loadInterstitialAd$8(this.f$0, this.f$1, (ConcurrentLinkedQueue) this.f$3, this.f$4);
                break;
        }
    }

    public /* synthetic */ SuncyanNet$$ExternalSyntheticLambda10(String str, String str2, String str3, String str4, int i) {
        this.f$0 = str;
        this.f$1 = str2;
        this.f$2 = str3;
        this.f$3 = str4;
        this.f$4 = i;
    }
}
