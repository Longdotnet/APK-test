package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.finsky.externalreferrer.jUdg.RDFWIi;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzx;

/* JADX INFO: loaded from: classes2.dex */
final class zzvk extends zzyb {
    final zzri zza;

    public zzvk(String str, String str2, String str3) {
        super(2);
        zzah.checkNotEmpty(str, "email cannot be null or empty");
        zzah.checkNotEmpty(str2, "password cannot be null or empty");
        this.zza = new zzri(str, str2, str3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyd
    public final String zza() {
        return RDFWIi.uUf;
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
        zzxbVar.zzf(this.zza, this.zzc);
    }
}
