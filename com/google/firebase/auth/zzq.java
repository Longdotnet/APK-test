package com.google.firebase.auth;

import com.google.firebase.FirebaseException;

/* JADX INFO: loaded from: classes.dex */
public final class zzq extends PhoneAuthProvider.OnVerificationStateChangedCallbacks {
    public final /* synthetic */ PhoneAuthProvider.OnVerificationStateChangedCallbacks zza;
    public final /* synthetic */ FirebaseAuth zzb;

    public zzq(FirebaseAuth firebaseAuth, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks) {
        this.zzb = firebaseAuth;
        this.zza = onVerificationStateChangedCallbacks;
    }

    @Override // com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
    public final void onCodeAutoRetrievalTimeOut(String str) {
    }

    @Override // com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
    public final void onCodeSent(String str, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
        String strZzb = this.zzb.zzg.zzb();
        com.google.android.gms.common.internal.zzah.checkNotNull(strZzb);
        this.zza.onVerificationCompleted(PhoneAuthProvider.getCredential(str, strZzb));
    }

    @Override // com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
    public final void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
        this.zza.onVerificationCompleted(phoneAuthCredential);
    }

    @Override // com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
    public final void onVerificationFailed(FirebaseException firebaseException) {
        this.zza.onVerificationFailed(firebaseException);
    }
}
