package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class zzvj extends zzyb {
    private final zzrg zza;

    public zzvj(String str, String str2, String str3) {
        super(4);
        zzah.checkNotEmpty(str, "code cannot be null or empty");
        zzah.checkNotEmpty(str2, "new password cannot be null or empty");
        this.zza = new zzrg(str, str2, str3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyd
    public final String zza() {
        return "confirmPasswordReset";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyb
    public final void zzb() {
        zzm(null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyd
    public final void zzc(TaskCompletionSource taskCompletionSource, zzxb zzxbVar) {
        this.zzv = new zzya(this, taskCompletionSource);
        zzxbVar.zze(this.zza, this.zzc);
    }
}
