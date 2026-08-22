package com.google.android.gms.internal.consent_sdk;

import com.google.android.ump.ConsentForm;
import com.google.android.ump.FormError;
import com.google.android.ump.UserMessagingPlatform$OnConsentFormLoadFailureListener;
import com.google.android.ump.UserMessagingPlatform$OnConsentFormLoadSuccessListener;

/* JADX INFO: loaded from: classes.dex */
final class zzba implements UserMessagingPlatform$OnConsentFormLoadSuccessListener, UserMessagingPlatform$OnConsentFormLoadFailureListener {
    private final UserMessagingPlatform$OnConsentFormLoadSuccessListener zza;
    private final UserMessagingPlatform$OnConsentFormLoadFailureListener zzb;

    public /* synthetic */ zzba(UserMessagingPlatform$OnConsentFormLoadSuccessListener userMessagingPlatform$OnConsentFormLoadSuccessListener, UserMessagingPlatform$OnConsentFormLoadFailureListener userMessagingPlatform$OnConsentFormLoadFailureListener, zzbb zzbbVar) {
        this.zza = userMessagingPlatform$OnConsentFormLoadSuccessListener;
        this.zzb = userMessagingPlatform$OnConsentFormLoadFailureListener;
    }

    @Override // com.google.android.ump.UserMessagingPlatform$OnConsentFormLoadFailureListener
    public final void onConsentFormLoadFailure(FormError formError) {
        this.zzb.onConsentFormLoadFailure(formError);
    }

    @Override // com.google.android.ump.UserMessagingPlatform$OnConsentFormLoadSuccessListener
    public final void onConsentFormLoadSuccess(ConsentForm consentForm) {
        this.zza.onConsentFormLoadSuccess(consentForm);
    }
}
