package com.google.firebase.auth;

/* JADX INFO: loaded from: classes.dex */
public class PhoneMultiFactorGenerator {
    public static final String FACTOR_ID = "phone";

    public static PhoneMultiFactorAssertion getAssertion(PhoneAuthCredential phoneAuthCredential) {
        com.google.android.gms.common.internal.zzah.checkNotNull(phoneAuthCredential);
        return new PhoneMultiFactorAssertion(phoneAuthCredential);
    }
}
