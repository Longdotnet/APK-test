package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.ActionCodeSettings;

/* JADX INFO: loaded from: classes.dex */
final class zzwe extends zzyb {
    private final zzse zza;
    private final String zzw;

    public zzwe(String str, ActionCodeSettings actionCodeSettings, String str2, String str3) {
        super(4);
        zzah.checkNotEmpty(str, "email cannot be null or empty");
        this.zza = new zzse(str, actionCodeSettings, str2);
        this.zzw = str3;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyd
    public final String zza() {
        return this.zzw;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyb
    public final void zzb() {
        zzm(null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyd
    public final void zzc(TaskCompletionSource taskCompletionSource, zzxb zzxbVar) {
        this.zzv = new zzya(this, taskCompletionSource);
        zzxbVar.zzq(this.zza, this.zzc);
    }
}
