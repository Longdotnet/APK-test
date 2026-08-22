package com.daerisoft.thespikerm;

import com.google.android.ump.ConsentForm;
import com.google.android.ump.FormError;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class GoogleMobileAdsGM$$ExternalSyntheticLambda19 implements ConsentForm.OnConsentFormDismissedListener {
    public final /* synthetic */ GoogleMobileAdsGM f$0;

    public /* synthetic */ GoogleMobileAdsGM$$ExternalSyntheticLambda19(GoogleMobileAdsGM googleMobileAdsGM) {
        this.f$0 = googleMobileAdsGM;
    }

    public final void onConsentFormDismissed(FormError formError) {
        this.f$0.lambda$AdMob_Consent_Show$24(formError);
    }
}
