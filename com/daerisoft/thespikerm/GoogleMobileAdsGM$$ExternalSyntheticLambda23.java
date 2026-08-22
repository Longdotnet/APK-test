package com.daerisoft.thespikerm;

import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class GoogleMobileAdsGM$$ExternalSyntheticLambda23 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ GoogleMobileAdsGM f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ ConcurrentLinkedQueue f$3;
    public final /* synthetic */ int f$4;
    public final /* synthetic */ String f$5;
    public final /* synthetic */ String f$6;

    public /* synthetic */ GoogleMobileAdsGM$$ExternalSyntheticLambda23(GoogleMobileAdsGM googleMobileAdsGM, String str, String str2, ConcurrentLinkedQueue concurrentLinkedQueue, int i, String str3, String str4, int i2) {
        this.$r8$classId = i2;
        this.f$0 = googleMobileAdsGM;
        this.f$1 = str;
        this.f$2 = str2;
        this.f$3 = concurrentLinkedQueue;
        this.f$4 = i;
        this.f$5 = str3;
        this.f$6 = str4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                GoogleMobileAdsGM.$r8$lambda$pNKpGF2UysJFf_kqCgl2SJ0k4f4(this.f$4, this.f$0, this.f$1, this.f$2, this.f$5, this.f$6, this.f$3);
                break;
            default:
                GoogleMobileAdsGM.$r8$lambda$JhyGSPHcVJ79stSKHuTWl3EUdk8(this.f$4, this.f$0, this.f$1, this.f$2, this.f$5, this.f$6, this.f$3);
                break;
        }
    }
}
