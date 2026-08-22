package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
final class zzvq extends zzyb {
    private final EmailAuthCredential zza;

    public zzvq(EmailAuthCredential emailAuthCredential) {
        super(2);
        zzah.checkNotNull(emailAuthCredential, "credential cannot be null");
        this.zza = emailAuthCredential;
        zzah.checkNotEmpty(emailAuthCredential.zzd(), "email cannot be null");
        zzah.checkNotEmpty(emailAuthCredential.zze(), "password cannot be null");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyd
    public final String zza() {
        return "linkEmailAuthCredential";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyb
    public final void zzb() {
        zzx zzxVarZzN = zzwy.zzN(this.zzd, this.zzk);
        ((zzg) this.zzf).zza(this.zzj, zzxVarZzN);
        zzm(new zzr(zzxVarZzN));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyd
    public final void zzc(TaskCompletionSource taskCompletionSource, zzxb zzxbVar) {
        this.zzv = new zzya(this, taskCompletionSource);
        String strZzd = this.zza.zzd();
        String strZze = this.zza.zze();
        zzah.checkNotEmpty(strZze);
        zzxbVar.zzl(new zzru(strZzd, strZze, this.zze.zzf()), this.zzc);
    }
}
