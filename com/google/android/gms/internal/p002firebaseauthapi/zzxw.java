package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.PhoneAuthProvider;

/* JADX INFO: loaded from: classes.dex */
final class zzxw implements zzxz {
    final /* synthetic */ Status zza;

    public zzxw(zzxy zzxyVar, Status status) {
        this.zza = status;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxz
    public final void zza(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.onVerificationFailed(zzxc.zza(this.zza));
    }
}
