package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzag;

/* JADX INFO: loaded from: classes.dex */
final class zzwm extends zzyb {
    private final zzsw zza;

    public zzwm(zzag zzagVar, String str, String str2, long j, boolean z, boolean z2, String str3, String str4, boolean z3) {
        super(8);
        zzah.checkNotNull(zzagVar);
        zzah.checkNotEmpty(str);
        String strZzc = zzagVar.zzc();
        zzah.checkNotEmpty(strZzc);
        this.zza = new zzsw(strZzc, str, str2, j, z, z2, str3, str4, z3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyd
    public final String zza() {
        return "startMfaEnrollmentWithPhoneNumber";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyb
    public final void zzb() {
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyd
    public final void zzc(TaskCompletionSource taskCompletionSource, zzxb zzxbVar) {
        this.zzv = new zzya(this, taskCompletionSource);
        zzxbVar.zzz(this.zza, this.zzc);
    }
}
