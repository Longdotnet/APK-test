package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.ActionCodeSettings;

/* JADX INFO: loaded from: classes.dex */
final class zzwv extends zzyb {
    private final zzti zza;

    public zzwv(String str, String str2, ActionCodeSettings actionCodeSettings) {
        super(6);
        zzah.checkNotEmpty(str);
        zzah.checkNotEmpty(str2);
        zzah.checkNotNull(actionCodeSettings);
        this.zza = new zzti(str, str2, actionCodeSettings);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyd
    public final String zza() {
        return "verifyBeforeUpdateEmail";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyb
    public final void zzb() {
        zzm(null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyd
    public final void zzc(TaskCompletionSource taskCompletionSource, zzxb zzxbVar) {
        this.zzv = new zzya(this, taskCompletionSource);
        zzxbVar.zzF(this.zza, this.zzc);
    }
}
