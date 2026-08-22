package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.PhoneAuthProvider;

/* JADX INFO: loaded from: classes.dex */
final class zzxt implements zzxz {
    final /* synthetic */ String zza;

    public zzxt(zzxy zzxyVar, String str) {
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxz
    public final void zza(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.onCodeSent(this.zza, PhoneAuthProvider.ForceResendingToken.zza());
    }
}
