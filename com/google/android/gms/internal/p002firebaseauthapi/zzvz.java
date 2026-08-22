package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
final class zzvz extends zzyb {
    private final zzsq zza;

    public zzvz(String str, String str2, String str3) {
        super(2);
        zzah.checkNotEmpty(str, "email cannot be null or empty");
        zzah.checkNotEmpty(str2, "password cannot be null or empty");
        this.zza = new zzsq(str, str2, str3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyd
    public final String zza() {
        return "reauthenticateWithEmailPasswordWithData";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyb
    public final void zzb() {
        zzx zzxVarZzN = zzwy.zzN(this.zzd, this.zzk);
        if (!this.zze.getUid().equalsIgnoreCase(zzxVarZzN.getUid())) {
            zzl(new Status(FirebaseError.ERROR_USER_MISMATCH));
        } else {
            ((zzg) this.zzf).zza(this.zzj, zzxVarZzN);
            zzm(new zzr(zzxVarZzN));
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyd
    public final void zzc(TaskCompletionSource taskCompletionSource, zzxb zzxbVar) {
        this.zzv = new zzya(this, taskCompletionSource);
        zzxbVar.zzw(this.zza, this.zzc);
    }
}
