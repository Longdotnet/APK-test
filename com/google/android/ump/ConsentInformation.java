package com.google.android.ump;

import android.app.Activity;

/* JADX INFO: loaded from: classes.dex */
public interface ConsentInformation {

    public interface OnConsentInfoUpdateFailureListener {
        void onConsentInfoUpdateFailure(FormError formError);
    }

    public interface OnConsentInfoUpdateSuccessListener {
        void onConsentInfoUpdateSuccess();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public final class PrivacyOptionsRequirementStatus {
        public static final PrivacyOptionsRequirementStatus NOT_REQUIRED;
        public static final PrivacyOptionsRequirementStatus REQUIRED;
        public static final PrivacyOptionsRequirementStatus UNKNOWN;
        public static final /* synthetic */ PrivacyOptionsRequirementStatus[] zza;

        static {
            PrivacyOptionsRequirementStatus privacyOptionsRequirementStatus = new PrivacyOptionsRequirementStatus("UNKNOWN", 0);
            UNKNOWN = privacyOptionsRequirementStatus;
            PrivacyOptionsRequirementStatus privacyOptionsRequirementStatus2 = new PrivacyOptionsRequirementStatus("NOT_REQUIRED", 1);
            NOT_REQUIRED = privacyOptionsRequirementStatus2;
            PrivacyOptionsRequirementStatus privacyOptionsRequirementStatus3 = new PrivacyOptionsRequirementStatus("REQUIRED", 2);
            REQUIRED = privacyOptionsRequirementStatus3;
            zza = new PrivacyOptionsRequirementStatus[]{privacyOptionsRequirementStatus, privacyOptionsRequirementStatus2, privacyOptionsRequirementStatus3};
        }

        public static PrivacyOptionsRequirementStatus valueOf(String str) {
            return (PrivacyOptionsRequirementStatus) Enum.valueOf(PrivacyOptionsRequirementStatus.class, str);
        }

        public static PrivacyOptionsRequirementStatus[] values() {
            return (PrivacyOptionsRequirementStatus[]) zza.clone();
        }
    }

    int getConsentStatus();

    boolean isConsentFormAvailable();

    void requestConsentInfoUpdate(Activity activity, ConsentRequestParameters consentRequestParameters, OnConsentInfoUpdateSuccessListener onConsentInfoUpdateSuccessListener, OnConsentInfoUpdateFailureListener onConsentInfoUpdateFailureListener);

    void reset();
}
