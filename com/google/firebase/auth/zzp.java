package com.google.firebase.auth;

import android.util.Log;
import com.google.android.gms.internal.p002firebaseauthapi.zzwy;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes.dex */
public final class zzp implements OnCompleteListener {
    public final /* synthetic */ PhoneAuthOptions zza;
    public final /* synthetic */ FirebaseAuth zzb;

    public zzp(FirebaseAuth firebaseAuth, PhoneAuthOptions phoneAuthOptions) {
        this.zzb = firebaseAuth;
        this.zza = phoneAuthOptions;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        String strZzb;
        String strZza;
        if (task.isSuccessful()) {
            strZzb = ((com.google.firebase.auth.internal.zze) task.getResult()).zzb();
            strZza = ((com.google.firebase.auth.internal.zze) task.getResult()).zza();
        } else {
            Log.e("FirebaseAuth", task.getException() != null ? "Error while validating application identity: ".concat(String.valueOf(task.getException().getMessage())) : "Error while validating application identity: ");
            Log.e("FirebaseAuth", "Proceeding without any application identifier.");
            strZzb = null;
            strZza = null;
        }
        PhoneAuthOptions phoneAuthOptions = this.zza;
        long jLongValue = phoneAuthOptions.zzg().longValue();
        String strZzh = phoneAuthOptions.zzh();
        PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacksZze = phoneAuthOptions.zze();
        FirebaseAuth firebaseAuth = this.zzb;
        PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacksZzL = firebaseAuth.zzL(strZzh, onVerificationStateChangedCallbacksZze);
        MultiFactorSession multiFactorSessionZzc = phoneAuthOptions.zzc();
        com.google.android.gms.common.internal.zzah.checkNotNull(multiFactorSessionZzc);
        com.google.firebase.auth.internal.zzag zzagVar = (com.google.firebase.auth.internal.zzag) multiFactorSessionZzc;
        if (zzagVar.zze()) {
            zzwy zzwyVar = firebaseAuth.zze;
            String strZzh2 = phoneAuthOptions.zzh();
            com.google.android.gms.common.internal.zzah.checkNotNull(strZzh2);
            zzwyVar.zzD(zzagVar, strZzh2, firebaseAuth.zzi, jLongValue, phoneAuthOptions.zzd() != null, phoneAuthOptions.zzj(), strZzb, strZza, firebaseAuth.zzK(), onVerificationStateChangedCallbacksZzL, phoneAuthOptions.zzi(), phoneAuthOptions.zza());
            return;
        }
        zzwy zzwyVar2 = firebaseAuth.zze;
        PhoneMultiFactorInfo phoneMultiFactorInfoZzf = phoneAuthOptions.zzf();
        com.google.android.gms.common.internal.zzah.checkNotNull(phoneMultiFactorInfoZzf);
        zzwyVar2.zzE(zzagVar, phoneMultiFactorInfoZzf, firebaseAuth.zzi, jLongValue, phoneAuthOptions.zzd() != null, phoneAuthOptions.zzj(), strZzb, strZza, firebaseAuth.zzK(), onVerificationStateChangedCallbacksZzL, phoneAuthOptions.zzi(), phoneAuthOptions.zza());
    }
}
