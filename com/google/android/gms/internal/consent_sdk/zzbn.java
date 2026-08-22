package com.google.android.gms.internal.consent_sdk;

import com.daerisoft.thespikerm.GoogleMobileAdsGM$$ExternalSyntheticLambda19;
import com.google.android.ump.ConsentForm;
import com.google.android.ump.FormError;
import com.google.android.ump.UserMessagingPlatform$OnConsentFormLoadFailureListener;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzbn implements UserMessagingPlatform$OnConsentFormLoadFailureListener {
    public final /* synthetic */ ConsentForm.OnConsentFormDismissedListener zza;

    @Override // com.google.android.ump.UserMessagingPlatform$OnConsentFormLoadFailureListener
    public final void onConsentFormLoadFailure(FormError formError) {
        ((GoogleMobileAdsGM$$ExternalSyntheticLambda19) this.zza).onConsentFormDismissed(formError);
    }
}
