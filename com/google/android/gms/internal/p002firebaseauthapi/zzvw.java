package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
final class zzvw extends zzyb {
    private final zzss zza;

    public zzvw(EmailAuthCredential emailAuthCredential) {
        super(2);
        zzah.checkNotNull(emailAuthCredential, "Credential cannot be null");
        this.zza = new zzss(emailAuthCredential);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyd
    public final String zza() {
        return "reauthenticateWithEmailLink";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyb
    public final void zzb() {
        zzx zzxVarZzN = zzwy.zzN(this.zzd, this.zzk);
        if (!this.zze.getUid().equalsIgnoreCase(zzxVarZzN.getUid())) {
            zzl(new Status(FirebaseError.ERROR_USER_MISMATCH));
        } else {
            ((zzg) this.zzf).zza(this.zzj, zzxVarZzN);
            zzm(null);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyd
    public final void zzc(TaskCompletionSource taskCompletionSource, zzxb zzxbVar) {
        this.zzv = new zzya(this, taskCompletionSource);
        zzxbVar.zzx(this.zza, this.zzc);
    }
}
