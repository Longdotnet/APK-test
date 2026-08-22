package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzg;

/* JADX INFO: loaded from: classes.dex */
final class zzwu extends zzyb {
    private final UserProfileChangeRequest zza;

    public zzwu(UserProfileChangeRequest userProfileChangeRequest) {
        super(2);
        zzah.checkNotNull(userProfileChangeRequest, "request cannot be null");
        this.zza = userProfileChangeRequest;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyd
    public final String zza() {
        return "updateProfile";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyb
    public final void zzb() {
        ((zzg) this.zzf).zza(this.zzj, zzwy.zzN(this.zzd, this.zzk));
        zzm(null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyd
    public final void zzc(TaskCompletionSource taskCompletionSource, zzxb zzxbVar) {
        this.zzv = new zzya(this, taskCompletionSource);
        zzxbVar.zzE(new zztg(this.zza, this.zze.zzf()), this.zzc);
    }
}
