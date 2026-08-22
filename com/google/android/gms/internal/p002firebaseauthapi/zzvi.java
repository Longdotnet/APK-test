package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzo;

/* JADX INFO: loaded from: classes.dex */
final class zzvi extends zzyb {
    private final zzre zza;

    public zzvi(String str, String str2) {
        super(4);
        zzah.checkNotEmpty(str, "code cannot be null or empty");
        this.zza = new zzre(str, str2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyd
    public final String zza() {
        return "checkActionCode";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyb
    public final void zzb() {
        zzm(new zzo(this.zzm));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyd
    public final void zzc(TaskCompletionSource taskCompletionSource, zzxb zzxbVar) {
        this.zzv = new zzya(this, taskCompletionSource);
        zzxbVar.zzd(this.zza, this.zzc);
    }
}
