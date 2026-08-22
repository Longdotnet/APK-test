package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.ActionCodeSettings;

/* JADX INFO: loaded from: classes.dex */
final class zzwd extends zzyb {
    private final zzsc zza;

    public zzwd(String str, ActionCodeSettings actionCodeSettings) {
        super(6);
        zzah.checkNotEmpty(str, "token cannot be null or empty");
        this.zza = new zzsc(str, actionCodeSettings);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyd
    public final String zza() {
        return "sendEmailVerification";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyb
    public final void zzb() {
        zzm(null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyd
    public final void zzc(TaskCompletionSource taskCompletionSource, zzxb zzxbVar) {
        this.zzv = new zzya(this, taskCompletionSource);
        zzxbVar.zzp(this.zza, this.zzc);
    }
}
